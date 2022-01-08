package main.visitor.codeGenerator;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.struct.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.*;
import main.ast.nodes.expression.values.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.ast.types.*;
import main.ast.types.primitives.*;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.items.StructSymbolTableItem;
import main.symbolTable.items.VariableSymbolTableItem;
import main.visitor.Visitor;
import main.visitor.type.ExpressionTypeChecker;
import java.io.*;
import java.util.*;

public class  CodeGenerator extends Visitor<String> {
    ExpressionTypeChecker expressionTypeChecker = new ExpressionTypeChecker();
    private String outputPath;
    private FileWriter currentFile;
    StructDeclaration currStruct = null;
    private boolean inDefaultConst = false;
    private int numOfUsedLabel = 0;

    private String getFreshLabel() {
        String label = "Label_";
        label += numOfUsedLabel;
        numOfUsedLabel++;
        return label;
    }

    private String getJasminType(Type type) {
        if (type instanceof IntType)
            return "java/lang/Integer";
        else if (type instanceof BoolType)
            return "java/lang/Boolean";
        else if (type instanceof FptrType)
            return "Fptr";
        else if (type instanceof ListType)
            return "List";
        else if (type instanceof StructType)
            return ((StructType) type).getStructName().getName();

        return null;
    }

    private void copyFile(String toBeCopied, String toBePasted) {
        try {
            File readingFile = new File(toBeCopied);
            File writingFile = new File(toBePasted);
            InputStream readingFileStream = new FileInputStream(readingFile);
            OutputStream writingFileStream = new FileOutputStream(writingFile);
            byte[] buffer = new byte[1024];
            int readLength;
            while ((readLength = readingFileStream.read(buffer)) > 0)
                writingFileStream.write(buffer, 0, readLength);
            readingFileStream.close();
            writingFileStream.close();
        } catch (IOException e) {//unreachable
        }
    }

    private void prepareOutputFolder() {
        this.outputPath = "output/";
        String jasminPath = "utilities/jarFiles/jasmin.jar";
        String listClassPath = "utilities/codeGenerationUtilityClasses/List.j";
        String fptrClassPath = "utilities/codeGenerationUtilityClasses/Fptr.j";
        try{
            File directory = new File(this.outputPath);
            File[] files = directory.listFiles();
            if(files != null)
                for (File file : files)
                    file.delete();
            directory.mkdir();
        }
        catch(SecurityException e) {//unreachable

        }
        copyFile(jasminPath, this.outputPath + "jasmin.jar");
        copyFile(listClassPath, this.outputPath + "List.j");
        copyFile(fptrClassPath, this.outputPath + "Fptr.j");
    }

    private void createFile(String name) {
        try {
            String path = this.outputPath + name + ".j";
            File file = new File(path);
            file.createNewFile();
            this.currentFile = new FileWriter(path);
        } catch (IOException e) {//never reached
        }
    }

    private void addCommand(String command) {
        try {
            command = String.join("\n\t\t", command.split("\n"));
            if(command.startsWith("Label_"))
                this.currentFile.write("\t" + command + "\n");
            else if(command.startsWith("."))
                this.currentFile.write(command + "\n");
            else
                this.currentFile.write("\t\t" + command + "\n");
            this.currentFile.flush();
        } catch (IOException e) {//unreachable

        }
    }

    private void addStaticMainMethod() {
        addCommand(".method public static main([Ljava/lang/String;)V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("new Main");
        addCommand("invokespecial Main/<init>()V");
        addCommand("return");
        addCommand(".end method");
    }

    private int slotOf(String identifier) {
        int cnt = 1;
        // Get curr symbol table
        // Count its variables and arguments
        // cnt++
        return cnt;
    }

    private void addDefaultConstructor(String structName) {
        inDefaultConst = true;
        addCommand(".method public <init>()V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("aload 0");

        currStruct.getBody().accept(this);

        addCommand("return");
        addCommand(".end method");
        inDefaultConst = false;
    }

    @Override
    public String visit(Program program) {
        prepareOutputFolder();

        for(StructDeclaration structDeclaration : program.getStructs()){
            structDeclaration.accept(this);
        }

        createFile("Main");

        program.getMain().accept(this);

        for (FunctionDeclaration functionDeclaration: program.getFunctions()){
            functionDeclaration.accept(this);
        }
        return null;
    }

    @Override
    public String visit(StructDeclaration structDeclaration) {
        String structName = structDeclaration.getStructName().getName();
        createFile(structName);
        currStruct = structDeclaration;
        //todo

        addCommand(".class " + structName);
        addCommand(".super java/lang/Object");

        structDeclaration.getBody().accept(this);

        addDefaultConstructor();
        currStruct = null;

        return null;
    }

    @Override
    public String visit(FunctionDeclaration functionDeclaration) {
        //todo

        String header = "";
        String className = currentClass.getClassName().getName();
        if (methodDeclaration instanceof ConstructorDeclaration){
            header += ".method public <init>(";
            for(VarDeclaration arg : methodDeclaration.getArgs()){
                header += "L" + makeTypeSignature(arg.getType()) + ";";
            }
            header += ")V";
        }
        else{
            header += ".method public " + methodDeclaration.getMethodName().getName() + "(";
            for(VarDeclaration arg : methodDeclaration.getArgs()){
                header += "L" + makeTypeSignature(arg.getType()) + ";";
            }
            if (methodDeclaration.getReturnType() instanceof NullType)
                header += ")V";
            else
                header += ")L"  + makeTypeSignature(methodDeclaration.getReturnType()) + ";";
        }

        addCommand(header);
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");

        if(methodDeclaration instanceof ConstructorDeclaration) {

            if (currentClass.getParentClassName() == null){
                addCommand("aload 0");
                addCommand("invokespecial java/lang/Object/<init>()V");
            }
            else{
                String parentClassName = currentClass.getParentClassName().getName();
                addCommand("aload 0");
                addCommand("invokespecial " + parentClassName + "/<init>()V");
            }

            for(FieldDeclaration field : currentClass.getFields()){
                String fieldName = field.getVarDeclaration().getVarName().getName();
                Type fieldType = field.getVarDeclaration().getType();

                if(fieldType instanceof ClassType || fieldType instanceof FptrType){
                    addCommand("aload 0");
                    addCommand("aconst_null");
                    addCommand("putfield " + className + "/" + fieldName + " L" + makeTypeSignature(fieldType) + ";\n");
                }
                else if(fieldType instanceof IntType || fieldType instanceof BoolType){
                    addCommand("aload 0");
                    addCommand("ldc 0");
                    if(fieldType instanceof IntType)
                        addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
                    if(fieldType instanceof BoolType)
                        addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
                    addCommand("putfield " + className + "/" + fieldName + " L" + makeTypeSignature(fieldType) + ";\n");
                }
                else if(fieldType instanceof StringType){
                    addCommand("aload 0");
                    addCommand("ldc \"\"");
                    addCommand("putfield " + className + "/" + fieldName + " L" + makeTypeSignature(fieldType) + ";\n");
                }
                else{
                    addCommand("aload 0");
                    initializeList((ListType) fieldType);
                    addCommand("putfield " + className + "/" + fieldName + " L" + makeTypeSignature(fieldType) + ";\n");
                }
            }

        }

        for(VarDeclaration var : methodDeclaration.getLocalVars()){
            var.accept(this);
        }

        for(Statement stmt : methodDeclaration.getBody()){
            stmt.accept(this);
        }
        if(!methodDeclaration.getDoesReturn())
            addCommand("return");

        addCommand(".end method");

        numOfUsedTemp = 0;
        return null;
    }

    @Override
    public String visit(MainDeclaration mainDeclaration) {
        //todo
        addStaticMainMethod();

        mainDeclaration.getBody().accept(this);

        return null;
    }

    @Override
    public String visit(VariableDeclaration variableDeclaration) {
        String varName = variableDeclaration.getVarName().getName();
        int slot = slotOf(varName); //todo
        Type type = variableDeclaration.getVarType();

        if (variableDeclaration.getDefaultValue() != null) {
            addCommand(variableDeclaration.getDefaultValue().accept(this));
        }
        else {
            String initCommands = "";
            String commands = "";
            if (type instanceof FptrType) {
                initCommands += "aconst_null\n";
            } else if (type instanceof StructType) {
                initCommands += "new " + ((StructType) type).getStructName().getName() + "\n" +
                        "dup\n" +
                        "invokespecial " + ((StructType) type).getStructName().getName() + "/<init>()V\n";
            } else if (type instanceof IntType || type instanceof BoolType) {
                initCommands += "ldc 0\n";
            } else {
                initCommands += "new List\n" +
                        "dup\n" +
                        "new java/util/ArrayList\n" +
                        "dup\n" +
                        "invokespecial java/util/ArrayList/<init>()V\n" +
                        "invokespecial List/<init>(Ljava/util/ArrayList;)V\n";
            }
            if (inDefaultConst) {
                commands += "aload 0\n" + initCommands + "putfield " +
                        currStruct.getStructName().getName() + "/" + varName + " L" + getJasminType(type) + ";\n";
            }
            else {
                commands = initCommands;
            }
            addCommand(commands);
        }

        if(type instanceof IntType)
            addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
        if(type instanceof BoolType)
            addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");

        addCommand("astore " + slot);
        return null;
    }

    @Override
    public String visit(SetGetVarDeclaration setGetVarDeclaration) {
        return null;
    }

    @Override
    public String visit(AssignmentStmt assignmentStmt) {
        //todo
        BinaryExpression assExpr = new BinaryExpression(assignmentStmt.getLValue(), assignmentStmt.getRValue(),
                                                            BinaryOperator.assign);
        addCommand(assExpr.accept(this));
        addCommand("pop");
        return null;
    }

    @Override
    public String visit(BlockStmt blockStmt) {
        //todo
        for (Statement statement: blockStmt.getStatements()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public String visit(ConditionalStmt conditionalStmt) {
        //todo
        String labelFalse = getFreshLabel();
        String labelAfter = getFreshLabel();
        addCommand(conditionalStmt.getCondition().accept(this));
        // check
        addCommand("ifeq " + labelFalse);
        conditionalStmt.getThenBody().accept(this);
        addCommand("goto " + labelAfter);
        addCommand(labelFalse + ":");
        if (conditionalStmt.getElseBody() != null)
            conditionalStmt.getElseBody().accept(this);
        addCommand(labelAfter + ":");
        return null;
    }

    @Override
    public String visit(FunctionCallStmt functionCallStmt) {
        //todo
        expressionTypeChecker.setInFunctionCallStmt(true);
        addCommand(functionCallStmt.getFunctionCall().accept(this));
        addCommand("pop");
        expressionTypeChecker.setInFunctionCallStmt(false);
        return null;
    }

    @Override
    public String visit(DisplayStmt displayStmt) {
        addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
        Type argType = displayStmt.getArg().accept(expressionTypeChecker);
        String commandsOfArg = displayStmt.getArg().accept(this);

        addCommand(commandsOfArg);
        if (argType instanceof IntType)
            addCommand("invokevirtual java/io/PrintStream/println(I)V");
        if (argType instanceof BoolType)
            addCommand("invokevirtual java/io/PrintStream/println(Z)V");

        return null;
    }

    @Override
    public String visit(ReturnStmt returnStmt) {
        //todo
        Type type = returnStmt.getReturnedExpr().accept(expressionTypeChecker);
        if(type instanceof VoidType) {
            addCommand("return");
        }
        else {
            addCommand( returnStmt.getReturnedExpr().accept(this) );
            if(type instanceof IntType)
                addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
            if(type instanceof BoolType)
                addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
            addCommand("areturn");
        }
        return null;
    }

    @Override
    public String visit(LoopStmt loopStmt) {
        //todo
        String labelStart = getFreshLabel();
        String labelAfter = getFreshLabel();

        addCommand(labelStart + ":");

        if (loopStmt.getCondition() != null) {
            addCommand(loopStmt.getCondition().accept(this));
            addCommand("ifeq " + labelAfter); // check
        }

        loopStmt.getBody().accept(this);

        addCommand("goto " + labelStart);
        addCommand(labelAfter + ":");

        return null;
    }

    @Override
    public String visit(VarDecStmt varDecStmt) {
        //todo
        for (VariableDeclaration newVar : varDecStmt.getVars()) {
            addCommand(newVar.accept(this));
        }
        return null;
    }

    @Override
    public String visit(ListAppendStmt listAppendStmt) {
        //todo
        addCommand(listAppendStmt.getListAppendExpr().accept(this));
        return null;
    }

    @Override
    public String visit(ListSizeStmt listSizeStmt) {
        //todo
        addCommand(listSizeStmt.getListSizeExpr().accept(this));
        return null;
    }

    @Override
    public String visit(BinaryExpression binaryExpression) {
        //todo
        BinaryOperator operator = binaryExpression.getBinaryOperator();
        Type operandType = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
        String commands = "";
        if (operator != BinaryOperator.and && operator != BinaryOperator.or && operator != BinaryOperator.assign) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);

            if (operator == BinaryOperator.add) {
                commands += "iadd\n";
            } else if (operator == BinaryOperator.sub) {
                commands += "isub\n";
            } else if (operator == BinaryOperator.mult) {
                commands += "imul\n";
            } else if (operator == BinaryOperator.div) {
                commands += "idiv\n";
            } else if ((operator == BinaryOperator.gt) || (operator == BinaryOperator.lt) || (operator == BinaryOperator.eq)) {
                String labelFalse = getFreshLabel();
                String labelAfter = getFreshLabel();
                if (operator == BinaryOperator.gt)
                    commands += "if_icmple " + labelFalse + "\n";
                else if (operator == BinaryOperator.lt)
                    commands += "if_icmpge " + labelFalse + "\n";
                else {
                    if (!(operandType instanceof IntType) && !(operandType instanceof BoolType))
                        commands += "if_acmpne " + labelFalse + "\n";
                    else
                        commands += "if_icmpne " + labelFalse + "\n";
                }
                commands += "ldc " + "1\n";
                commands += "goto " + labelAfter + "\n";
                commands += labelFalse + ":\n";
                commands += "ldc " + "0\n";
                commands += labelAfter + ":\n";
            }
        }
        else if (operator == BinaryOperator.and) {
            String labelFalse = getFreshLabel();
            String labelAfter = getFreshLabel();
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += "ifeq " + labelFalse + "\n";
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "ifeq " + labelFalse + "\n";
            commands += "ldc " + "1\n";
            commands += "goto " + labelAfter + "\n";
            commands += labelFalse + ":\n";
            commands += "ldc " + "0\n";
            commands += labelAfter + ":\n";
        }
        else if (operator == BinaryOperator.or) {
            String labelTrue = getFreshLabel();
            String labelAfter = getFreshLabel();
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += "ifne " + labelTrue + "\n";
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "ifne " + labelTrue + "\n";
            commands += "ldc " + "0\n";
            commands += "goto " + labelAfter + "\n";
            commands += labelTrue + ":\n";
            commands += "ldc " + "1\n";
            commands += labelAfter + ":\n";
        }
        else { // assign
            Type leftType = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
            Type rightType = binaryExpression.getSecondOperand().accept(expressionTypeChecker);
            String rightOperandCommands = binaryExpression.getSecondOperand().accept(this);
            if (leftType instanceof ListType) {
                rightOperandCommands = "new List\n" +
                                        "dup\n" +
                                        rightOperandCommands + "invokespecial List/<init>(LList;)V\n";
            }

            if (rightType instanceof IntType) {
                rightOperandCommands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
            }
            if (rightType instanceof BoolType) {
                rightOperandCommands += "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";
            }

            if (binaryExpression.getFirstOperand() instanceof Identifier identifier) {
                int slot = slotOf(identifier.getName());
                commands += rightOperandCommands;
                commands += "astore " + slot + "\n";
                commands += "aload " + slot + "\n";
                if (rightType instanceof IntType)
                    commands += "invokevirtual java/lang/Integer/intValue()I\n";
                if (rightType instanceof BoolType)
                    commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
            }
            else if (binaryExpression.getFirstOperand() instanceof ListAccessByIndex) {
                Expression instance = ((ListAccessByIndex) binaryExpression.getFirstOperand()).getInstance();
                Expression index = ((ListAccessByIndex) binaryExpression.getFirstOperand()).getIndex();
                commands += instance.accept(this);
                commands += index.accept(this);
                commands += rightOperandCommands;
                commands += "invokevirtual List/setElement(ILjava/lang/Object;)V\n";

                commands += instance.accept(this);
                commands += index.accept(this);
                commands += "invokevirtual List/getElement(I)Ljava/lang/Object;\n";
                commands += "checkcast " + getJasminType(rightType) + "\n";
                if (rightType instanceof IntType)
                    commands += "invokevirtual java/lang/Integer/intValue()I\n";
                if (rightType instanceof BoolType)
                    commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
            }
            else if (binaryExpression.getFirstOperand() instanceof StructAccess) {
                Expression instance = ((StructAccess) binaryExpression.getFirstOperand()).getInstance();
                Type instanceType = instance.accept(expressionTypeChecker);
                String elementName = ((StructAccess) binaryExpression.getFirstOperand()).getElement().getName();
                Type elementType = ((StructAccess) binaryExpression.getFirstOperand()).getElement().accept(expressionTypeChecker);

                String structName = ((StructType) instanceType).getStructName().getName();

                commands += instance.accept(this);
                commands += rightOperandCommands;
                commands += "putfield " + structName + "/" + elementName + " L" + getJasminType(elementType) + ";\n";

                commands += instance.accept(this);
                commands += "getfield " + structName + "/" + elementName + " L" + getJasminType(elementType) + ";\n";

                if (rightType instanceof IntType)
                    commands += "invokevirtual java/lang/Integer/intValue()I\n";
                if (rightType instanceof BoolType)
                    commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
            }
            return commands;
        }
    }

    @Override
    public String visit(UnaryExpression unaryExpression){
        return null;
    }

    @Override
    public String visit(StructAccess structAccess){
        //todo
        Type elementType = structAccess.accept(expressionTypeChecker);
        String elementName = structAccess.getElement().getName();

        Type instanceType = structAccess.getInstance().accept(expressionTypeChecker);

        String commands = "";
        String structName = ((StructType) instanceType).getStructName().getName();

        try {
            SymbolTable structSymbolTable = ((StructSymbolTableItem) SymbolTable.root.getItem(StructSymbolTableItem.START_KEY + structName)).getStructSymbolTable();
            try {
                structSymbolTable.getItem(VariableSymbolTableItem.START_KEY + elementName);
                commands += structAccess.getInstance().accept(this);
                commands += "getfield " + structName + "/" + elementName + " L" + getJasminType(elementType) + ";\n";
                if (elementType instanceof IntType)
                    commands += "invokevirtual java/lang/Integer/intValue()I\n";
                if (elementType instanceof BoolType)
                    commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";

            } catch (ItemNotFoundException ignored) {}
        } catch (ItemNotFoundException ignored) {}

        return commands;
    }

    @Override
    public String visit(Identifier identifier){
        //todo
        int slotNum = slotOf(identifier.getName());
        String commands = "aload " + slotNum + "\n";

        Type type = identifier.accept(expressionTypeChecker);
        if(type instanceof IntType)
            commands += "invokevirtual java/lang/Integer/intValue()I\n";
        if(type instanceof BoolType)
            commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
        return commands;
    }

    @Override
    public String visit(ListAccessByIndex listAccessByIndex){
        //todo
        String commands = listAccessByIndex.getInstance().accept(this);
        commands += listAccessByIndex.getIndex().accept(this);
        commands += "invokevirtual List/getElement(I)Ljava/lang/Object;\n";

        Type type = listAccessByIndex.accept(expressionTypeChecker);
        if (type instanceof IntType)
            commands += "invokevirtual java/lang/Integer/intValue()I\n";
        if (type instanceof BoolType)
            commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
        return commands;
    }

    @Override
    public String visit(FunctionCall functionCall){
        //todo
        int tempIndex = slotOf("");

        String commands = functionCall.getInstance().accept(this);
        commands += "new java/util/ArrayList\n";
        commands += "dup\n";
        commands += "invokespecial java/util/ArrayList/<init>()V\n";
        commands += "astore " + tempIndex + "\n";

        for(Expression arg : functionCall.getArgs()){
            commands += "aload " + tempIndex + "\n";

            Type argType = arg.accept(expressionTypeChecker);

            if(argType instanceof ListType) {
                commands += "new List\n";
                commands += "dup\n";
            }

            commands += arg.accept(this);

            if(argType instanceof IntType)
                commands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";

            if(argType instanceof BoolType)
                commands += "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";

            if(argType instanceof ListType) {
                commands += "invokespecial List/<init>(LList;)V\n";
            }

            commands += "invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z\n";
            commands += "pop\n";
        }

        commands += "aload " + tempIndex + "\n";
        commands += "invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;\n";

        Type retType = ((FptrType) functionCall.getInstance().accept(expressionTypeChecker)).getReturnType();

        if(!(retType instanceof VoidType))
            commands += "checkcast " + getJasminType(retType) + "\n";

        if (retType instanceof IntType)
            commands += "invokevirtual java/lang/Integer/intValue()I\n";
        if (retType instanceof BoolType)
            commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
        return commands;
    }

    @Override
    public String visit(ListSize listSize){
        //todo
        String commands = listSize.getArg().accept(this);
        commands += "invokevirual List/getSize(Ljava/lang/Object;)V\n";
        return commands;
    }

    @Override
    public String visit(ListAppend listAppend) {
        //todo
        String commands = listAppend.getListArg().accept(this);
        commands += listAppend.getElementArg().accept(this);
        commands += "invokevirual List/addElement()I\n";
        return commands;
    }

    @Override
    public String visit(IntValue intValue) {
        //todo
        return "ldc " + intValue.getConstant() +"\n";
    }

    @Override
    public String visit(BoolValue boolValue) {
        //todo
        return "ldc " + (boolValue.getConstant() ? "1" : "0") + "\n";
    }

    @Override
    public String visit(ExprInPar exprInPar) {
        return exprInPar.getInputs().get(0).accept(this);
    }
}
