package main.visitor.name;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.struct.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.ast.types.StructType;
import main.compileError.CompileError;
import main.compileError.nameError.*;
import main.visitor.*;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.items.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class NameAnalyzer  extends Visitor<Void> {
    public boolean hasError() { return !errors.isEmpty(); }
    private boolean inStruct = false;
    private StructDeclaration curr_struct = null;
    private HashMap<StructDeclaration, ArrayList<String> > struct_dependency =
            new HashMap<>();
    private ArrayList<CompileError> errors;

    private void printErrors() {
        for (CompileError exception: errors)
            System.out.println(exception.getMessage());
    }

    @Override
    public Void visit(Program program) {
        SymbolTable root = new SymbolTable();
        SymbolTable.root = root;
        SymbolTable.push(root);
        errors = new ArrayList<CompileError>();

        for (StructDeclaration structDeclaration: program.getStructs()) {
            SymbolTable structSymbolTable = new SymbolTable();
            StructSymbolTableItem newSymbolTableItem = new StructSymbolTableItem(structDeclaration);
            newSymbolTableItem.setStructSymbolTable((structSymbolTable));
            try{
                root.put(newSymbolTableItem);
            } catch (ItemAlreadyExistsException ex) {
                DuplicateStruct exception = new DuplicateStruct(structDeclaration.getLine(), structDeclaration.getStructName().getName());
                program.addError(exception);
            }
            SymbolTable.push(structSymbolTable);
            structDeclaration.accept(this);
        }

        ArrayList<StructDeclaration> structs = new ArrayList<StructDeclaration>(struct_dependency.keySet());

        for (FunctionDeclaration functionDeclaration:program.getFunctions()) {
            SymbolTable newSymbolTable = new SymbolTable();
            FunctionSymbolTableItem newSymbolTableItem = new FunctionSymbolTableItem(functionDeclaration);
            newSymbolTableItem.setFunctionSymbolTable((newSymbolTable));
            try{
                SymbolTable.root.getItem(StructSymbolTableItem.START_KEY + functionDeclaration.getFunctionName().getName());
                FunctionStructConflict exception = new FunctionStructConflict(functionDeclaration.getLine(), functionDeclaration.getFunctionName().getName());
                program.addError(exception);
            } catch (ItemNotFoundException ignored) {}
            try{
                root.put(newSymbolTableItem);
            } catch (ItemAlreadyExistsException e) {
                DuplicateFunction exception = new DuplicateFunction(functionDeclaration.getLine(), functionDeclaration.getFunctionName().getName());
                program.addError(exception);
            }
            SymbolTable.push(newSymbolTable);
            functionDeclaration.accept(this);
        }

        program.getMain().accept(this);

        errors.addAll(program.flushErrors());
        printErrors();
        return null;
    }

    @Override
    public Void visit(FunctionDeclaration functionDec) {
        functionDec.getFunctionName().accept(this);

        for (VariableDeclaration var: functionDec.getArgs()) {
            VariableSymbolTableItem varSymbol = new VariableSymbolTableItem(var.getVarName());
            try {
                SymbolTable.top.put(varSymbol);
            } catch (ItemAlreadyExistsException e) {
                DuplicateVar exception = new DuplicateVar(var.getLine(), var.getVarName().getName());
                functionDec.addError(exception);
            }
            try{
                SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + var.getVarName().getName());
                VarFunctionConflict exception = new VarFunctionConflict(var.getLine(), var.getVarName().getName());
                functionDec.addError(exception);
            } catch (ItemNotFoundException ignored) {}
            try{
                SymbolTable.root.getItem(StructSymbolTableItem.START_KEY + var.getVarName().getName());
                VarStructConflict exception = new VarStructConflict(var.getLine(), var.getVarName().getName());
                functionDec.addError(exception);
            } catch (ItemNotFoundException ignored) {}
        }
        functionDec.getBody().accept(this);
        errors.addAll(functionDec.flushErrors());
        return null;
    }

    @Override
    public Void visit(MainDeclaration mainDec) {
        mainDec.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(VariableDeclaration variableDec) {
        if (inStruct && variableDec.getVarType().toString().length() >=11 && Objects.equals(variableDec.getVarType().toString().substring(0,10), "StructType"))
            struct_dependency.computeIfAbsent(curr_struct, k -> new ArrayList<>()).add(variableDec.getVarName().getName());

        VariableSymbolTableItem varSymbol = new VariableSymbolTableItem(variableDec.getVarName());
        try {
            SymbolTable.top.getItem(VariableSymbolTableItem.START_KEY + variableDec.getVarName().getName());
            DuplicateVar exception = new DuplicateVar(variableDec.getLine(), variableDec.getVarName().getName());
            variableDec.addError(exception);
        } catch (ItemNotFoundException e) {
            try {
                SymbolTable.top.put(varSymbol);
            } catch (ItemAlreadyExistsException ignored) {}
        }
        try{
            SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + variableDec.getVarName().getName());
            VarFunctionConflict exception = new VarFunctionConflict(variableDec.getLine(), variableDec.getVarName().getName());
            variableDec.addError(exception);
        } catch (ItemNotFoundException ignored) {}
        try{
            SymbolTable.root.getItem(StructSymbolTableItem.START_KEY + variableDec.getVarName().getName());
            VarStructConflict exception = new VarStructConflict(variableDec.getLine(), variableDec.getVarName().getName());
            variableDec.addError(exception);
        } catch (ItemNotFoundException ignored) {}

        if (variableDec.getDefaultValue() != null)
            variableDec.getDefaultValue().accept(this);
        errors.addAll(variableDec.flushErrors());
        return null;
    }

    @Override
    public Void visit(StructDeclaration structDec) {
        structDec.getStructName().accept(this);
        inStruct = true;
        curr_struct = structDec;
        structDec.getBody().accept(this);
        inStruct = false;
        return null;
    }

    @Override
    public Void visit(SetGetVarDeclaration setGetVarDec) {
        VariableSymbolTableItem varSymbol = new VariableSymbolTableItem(setGetVarDec.getVarName());
        try {
            SymbolTable.top.put(varSymbol);
        } catch (ItemAlreadyExistsException e) {
            DuplicateVar exception = new DuplicateVar(setGetVarDec.getLine(), setGetVarDec.getVarName().getName());
            setGetVarDec.addError(exception);
        }
        try{
            SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + setGetVarDec.getVarName().getName());
            VarFunctionConflict exception = new VarFunctionConflict(setGetVarDec.getLine(), setGetVarDec.getVarName().getName());
            setGetVarDec.addError(exception);
        } catch (ItemNotFoundException ignored) {}
        try{
            SymbolTable.root.getItem(StructSymbolTableItem.START_KEY + setGetVarDec.getVarName().getName());
            VarStructConflict exception = new VarStructConflict(setGetVarDec.getLine(), setGetVarDec.getVarName().getName());
            setGetVarDec.addError(exception);
        } catch (ItemNotFoundException ignored) {}

        for (VariableDeclaration var: setGetVarDec.getArgs())
            var.accept(this);

        errors.addAll(setGetVarDec.flushErrors());

//        setGetVarDec.getSetterBody().accept(this);
//        setGetVarDec.getGetterBody().accept(this);
        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        assignmentStmt.getLValue().accept(this);
        assignmentStmt.getRValue().accept(this);
        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        for (Statement stmt: blockStmt.getStatements())
            stmt.accept(this);
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        SymbolTable then = new SymbolTable(SymbolTable.top);
        SymbolTable.push(then);
        conditionalStmt.getCondition().accept(this);
        conditionalStmt.getThenBody().accept(this);
        SymbolTable.pop();
        SymbolTable _else = new SymbolTable(SymbolTable.top);
        SymbolTable.push(_else);
        conditionalStmt.getElseBody().accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(FunctionCallStmt functionCallStmt) {
        functionCallStmt.getFunctionCall().accept(this);
        return null;
    }

    @Override
    public Void visit(DisplayStmt displayStmt) {
        displayStmt.getArg().accept(this);
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        returnStmt.getReturnedExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(LoopStmt loopStmt) {
        SymbolTable loop = new SymbolTable(SymbolTable.top);
        SymbolTable.push(loop);
        loopStmt.getCondition().accept(this);
        loopStmt.getBody().accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(VarDecStmt varDecStmt) {
        for (VariableDeclaration var: varDecStmt.getVars())
            var.accept(this);
        return null;
    }

    @Override
    public Void visit(ListAppendStmt listAppendStmt) {
        listAppendStmt.getListAppendExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(ListSizeStmt listSizeStmt) {
        listSizeStmt.getListSizeExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        binaryExpression.getFirstOperand().accept(this);
        binaryExpression.getSecondOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        unaryExpression.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionCall funcCall) {
        funcCall.getInstance().accept(this);
        for (Expression expr: funcCall.getArgs())
            expr.accept(this);
        return null;
    }

    @Override
    public Void visit(Identifier identifier) { //todo?
        return null;
    }

    @Override
    public Void visit(ListAccessByIndex listAccessByIndex) {
        listAccessByIndex.getInstance().accept(this);
        listAccessByIndex.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(StructAccess structAccess) {
        structAccess.getInstance().accept(this);
        structAccess.getElement().accept(this);
        return null;
    }

    @Override
    public Void visit(ListSize listSize) {
        listSize.getArg().accept(this);
        return null;
    }

    @Override
    public Void visit(ListAppend listAppend) {
        listAppend.getListArg().accept(this);
        listAppend.getElementArg().accept(this);
        return null;
    }

    @Override
    public Void visit(ExprInPar exprInPar) {
        for (Expression expr: exprInPar.getInputs())
            expr.accept(this);
        return null;
    }

    @Override
    public Void visit(IntValue intValue) {
        return null;
    }

    @Override
    public Void visit(BoolValue boolValue) {
        return null;
    }
}
