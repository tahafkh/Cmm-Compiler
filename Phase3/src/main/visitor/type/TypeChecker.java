package main.visitor.type;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.struct.*;
import main.ast.nodes.expression.Identifier;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.statement.*;
import main.ast.types.*;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.VoidType;
import main.compileError.CompileError;
import main.compileError.typeError.*;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.items.*;
import main.visitor.Visitor;


public class TypeChecker extends Visitor<Boolean> {

    ExpressionTypeChecker expressionTypeChecker;

    private Integer retLine = -1;
    private Boolean inSetGet = false;
    private FunctionDeclaration curFunction = null;

    public TypeChecker(){
        this.expressionTypeChecker = new ExpressionTypeChecker();
    }

    @Override
    public Boolean visit(Program program) {
        SymbolTable symbolTable;
        for (StructDeclaration structDec : program.getStructs()) {
            try {
                StructSymbolTableItem structSymbolTableItem = (StructSymbolTableItem) SymbolTable.root.getItem(StructSymbolTableItem.START_KEY + structDec.getStructName().getName() );
                symbolTable = structSymbolTableItem.getStructSymbolTable();
                SymbolTable.push(symbolTable);
            } catch (ItemNotFoundException ignored) {}
            structDec.accept(this);
            SymbolTable.pop();
        }

        for (FunctionDeclaration funcDec : program.getFunctions()) {
            try {
                FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + funcDec.getFunctionName().getName());
                symbolTable = new SymbolTable();
                functionSymbolTableItem.setFunctionSymbolTable(symbolTable);
                SymbolTable.push(symbolTable);
                funcDec.accept(this);
                SymbolTable.pop();
            } catch (ItemNotFoundException ignored) {}
        }

        symbolTable = new SymbolTable();
        SymbolTable.push(symbolTable);
        program.getMain().accept(this);
        SymbolTable.pop();
        return true;
    }

    @Override
    public Boolean visit(FunctionDeclaration functionDec) {
        curFunction = functionDec;
        for (VariableDeclaration var: functionDec.getArgs()) {
            VariableSymbolTableItem varSymbol = new VariableSymbolTableItem(var.getVarName());
            try {
                SymbolTable.top.put(varSymbol);
            } catch (ItemAlreadyExistsException ignored) {}
        }

        if (functionDec.getReturnType() instanceof StructType structType) {
            expressionTypeChecker.setIsStructDec(true);
            Identifier structRet = new Identifier(structType.getStructName().getName());
            structRet.setLine(functionDec.getLine());
            structRet.accept(expressionTypeChecker);
            expressionTypeChecker.setIsStructDec(false);
            for (CompileError exception : structRet.flushErrors())
                functionDec.addError(exception);
        }

        Boolean hasRet = functionDec.getBody().accept(this);

        if (!(functionDec.getReturnType() instanceof VoidType) && !hasRet) {
            MissingReturnStatement exception;
            exception = new MissingReturnStatement(functionDec.getLine(), functionDec.getFunctionName().getName());
            functionDec.addError(exception);
        }

        return hasRet;
    }

    @Override
    public Boolean visit(MainDeclaration mainDec) {
        curFunction = null;
        retLine = -1;
        mainDec.getBody().accept(this);
        if (retLine >= 0) {
            CannotUseReturn exception;
            exception = new CannotUseReturn(retLine);
            mainDec.addError(exception);
        }
        return true;
    }

    @Override
    public Boolean visit(VariableDeclaration variableDec) {
        if (variableDec.getDefaultValue() != null) {
            Type defaultType = variableDec.getDefaultValue().accept(expressionTypeChecker);
            if (!expressionTypeChecker.haveSameType(variableDec.getVarType(), defaultType)) {
                UnsupportedOperandType exception;
                exception = new UnsupportedOperandType(variableDec.getLine(), BinaryOperator.assign.name());
                variableDec.addError(exception);
            }
        }
        if (variableDec.getVarType() instanceof StructType structVar) {
            expressionTypeChecker.setIsStructDec(true);
            structVar.getStructName().accept(expressionTypeChecker);
            expressionTypeChecker.setIsStructDec(false);
        }

        try {
            VariableSymbolTableItem newVar = new VariableSymbolTableItem(variableDec.getVarName());
            newVar.setType(variableDec.getVarType());
            SymbolTable.top.put(newVar);
        } catch (ItemAlreadyExistsException ignored) {}

        if (inSetGet) {
            CannotUseDefineVar exception;
            exception = new CannotUseDefineVar(variableDec.getLine());
            variableDec.addError(exception);
        }
        return false;
    }

    @Override
    public Boolean visit(StructDeclaration structDec) {
        structDec.getBody().accept(this);
        return false;
    }

    @Override
    public Boolean visit(SetGetVarDeclaration setGetVarDec) {
        inSetGet = true;
        retLine = -1;
        try {
            SymbolTable symbolTable = ((FunctionSymbolTableItem) SymbolTable.top.getItem(FunctionSymbolTableItem.START_KEY + setGetVarDec.getVarName().getName())).getFunctionSymbolTable();
            SymbolTable.push(symbolTable);
        } catch (ItemNotFoundException ignored) {}

        setGetVarDec.getSetterBody().accept(this);
        if (retLine >= 0) {
            CannotUseReturn exception;
            exception = new CannotUseReturn(retLine);
            setGetVarDec.addError(exception);
        }

        SymbolTable.pop();

        Boolean hasReturn = setGetVarDec.getGetterBody().accept(this);
        if(!hasReturn) {
            MissingReturnStatement exception;
            exception = new MissingReturnStatement(setGetVarDec.getLine(), setGetVarDec.getVarName().getName());
            setGetVarDec.addError(exception);
        }

        inSetGet = false;
        return false;
    }

    @Override
    public Boolean visit(AssignmentStmt assignmentStmt) {
        var leftType = assignmentStmt.getLValue().accept(expressionTypeChecker);
        var rightType = assignmentStmt.getRValue().accept(expressionTypeChecker);

        if(!expressionTypeChecker.haveSameType(leftType, rightType)){
            UnsupportedOperandType exception;
            exception = new UnsupportedOperandType(assignmentStmt.getRValue().getLine(), BinaryOperator.assign.name());
            assignmentStmt.addError(exception);
        }
        if (!expressionTypeChecker.isLValue(assignmentStmt.getLValue())) {
            LeftSideNotLvalue exception;
            exception = new LeftSideNotLvalue(assignmentStmt.getLValue().getLine());
            assignmentStmt.addError(exception);
        }
        return false;
    }

    @Override
    public Boolean visit(BlockStmt blockStmt) {
        Boolean hasRet = true;
        for (Statement stmt: blockStmt.getStatements())
            hasRet = hasRet & stmt.accept(this);
        return hasRet;
    }

    @Override
    public Boolean visit(ConditionalStmt conditionalStmt) {
        Boolean hasRet;
        Type condType = conditionalStmt.getCondition().accept(expressionTypeChecker);
        if(!(condType instanceof BoolType || condType instanceof NoType)) {
            ConditionNotBool exception = new ConditionNotBool(conditionalStmt.getLine());
            conditionalStmt.addError(exception);
        }

        SymbolTable then = new SymbolTable(SymbolTable.top);
        SymbolTable.push(then);
        hasRet = conditionalStmt.getThenBody().accept(this);
        SymbolTable.pop();
        if (conditionalStmt.getElseBody() != null) {
            SymbolTable _else = new SymbolTable(SymbolTable.top);
            SymbolTable.push(_else);
            hasRet = hasRet & conditionalStmt.getElseBody().accept(this);
            SymbolTable.pop();
        }
        return hasRet;
    }

    @Override
    public Boolean visit(FunctionCallStmt functionCallStmt) {
        functionCallStmt.getFunctionCall().accept(expressionTypeChecker);
        return false;
    }

    @Override
    public Boolean visit(DisplayStmt displayStmt) {
        Type argType = displayStmt.getArg().accept(expressionTypeChecker);
        if (argType instanceof FptrType || argType instanceof StructType) {
            UnsupportedTypeForDisplay exception;
            exception = new UnsupportedTypeForDisplay(displayStmt.getLine());
            displayStmt.addError(exception);
        }
        return false;
    }

    @Override
    public Boolean visit(ReturnStmt returnStmt) {
        retLine = returnStmt.getLine();
        if (returnStmt.getReturnedExpr() != null) {
            Type returnType = returnStmt.getReturnedExpr().accept(expressionTypeChecker);
            if (curFunction != null) {
                if (!expressionTypeChecker.haveSameType(curFunction.getReturnType(), returnType)) {
                    ReturnValueNotMatchFunctionReturnType exception;
                    exception = new ReturnValueNotMatchFunctionReturnType(returnStmt.getLine());
                    returnStmt.addError(exception);
                }
            }
        }
        return true;
    }

    @Override
    public Boolean visit(LoopStmt loopStmt) {
        Type condType = loopStmt.getCondition().accept(expressionTypeChecker);
        if(!(condType instanceof BoolType || condType instanceof NoType)) {
            ConditionNotBool exception = new ConditionNotBool(loopStmt.getLine());
            loopStmt.addError(exception);
        }

        SymbolTable loop = new SymbolTable(SymbolTable.top);
        SymbolTable.push(loop);
        Boolean hasRet = loopStmt.getBody().accept(this);
        SymbolTable.pop();
        return hasRet;
    }

    @Override
    public Boolean visit(VarDecStmt varDecStmt) {
        for (VariableDeclaration varDec : varDecStmt.getVars()) {
            varDec.accept(this);
        }
        return false;
    }

    @Override
    public Boolean visit(ListAppendStmt listAppendStmt) {
        listAppendStmt.getListAppendExpr().accept(expressionTypeChecker);
        return false;
    }

    @Override
    public Boolean visit(ListSizeStmt listSizeStmt) {
        listSizeStmt.getListSizeExpr().accept(expressionTypeChecker);
        return false;
    }
}
