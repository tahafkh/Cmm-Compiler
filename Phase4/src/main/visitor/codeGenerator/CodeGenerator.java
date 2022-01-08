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
import main.visitor.Visitor;
import main.visitor.type.ExpressionTypeChecker;
import java.io.*;
import java.util.*;

public class  CodeGenerator extends Visitor<String> {
    ExpressionTypeChecker expressionTypeChecker = new ExpressionTypeChecker();
    private String outputPath;
    private FileWriter currentFile;
    private boolean inMain = false;
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
        createFile(structDeclaration.getStructName().getName());
        //todo
        return null;
    }

    @Override
    public String visit(FunctionDeclaration functionDeclaration) {
//        String funcName = funcDeclaration.getFunctionName().getName();
//
//        String command = "";
//        command += ".method public " + funcName;
//
//        FunctionSymbolTableItem fsti = getFuncSymbolTableItem("Function_" + funcName);
//        expressionTypeChecker.setCurFunction(fsti);
//
//        Map<String, Type> argTypeMap = fsti.getArgTypes();
//        Type returnType = fsti.getReturnType();
//        ArrayList<Type> argTypes = new ArrayList<>();
//        for (Identifier identifier: funcDeclaration.getArgs()) {
//            String argName = identifier.getName();
//            Type t = argTypeMap.get(argName);
//            argTypes.add(t);
//        }
//
//        StringBuilder argList = new StringBuilder("(");
//        for (Type t : argTypes) {
//            argList.append(getArgTypeSymbol(t));
//        }
//        argList.append(")");
//        argList.append(getArgTypeSymbol(returnType));
//        command += argList.toString() + "\n";
//
//        command += ".limit stack 140\n";
//        command += ".limit locals 140\n";
//
//        command += funcDeclaration.getBody().accept(this);
//        command += ".end method\n";
//        return command;
        return null;
    }

    @Override
    public String visit(MainDeclaration mainDeclaration) {
        inMain = true;

        addStaticMainMethod();

        mainDeclaration.getBody().accept(this);

        inMain = false;
        return null;
    }

    @Override
    public String visit(VariableDeclaration variableDeclaration) {
        int slot = slotOf(variableDeclaration.getVarName().getName()); //todo
        Type type = variableDeclaration.getVarType();

        if (variableDeclaration.getDefaultValue() != null) {
            addCommand(variableDeclaration.getDefaultValue().accept(this));
        }
        else {
            if(type instanceof FptrType){
                addCommand("aconst_null");
            }
            else if(type instanceof StructType){
//            initializeStruct((StructType) type);
            }
            else if(type instanceof IntType || type instanceof BoolType){
                addCommand("ldc 0");
            }
            else{
//            initializeList((ListType) type);
            }
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
                rightOperandCommands = "new List\ndup\n" + rightOperandCommands + "invokespecial List/<init>(LList;)V\n";
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
//                commands += "checkcast " + makeTypeSignature(rightType) + "\n";
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

        return null;
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
        return null;
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
