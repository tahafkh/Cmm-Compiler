package main.visitor.name;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.struct.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.compileError.CompileError;
import main.compileError.nameError.*;
import main.visitor.*;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.items.*;

import java.util.ArrayList;

public class NameAnalyzer  extends Visitor<Void> {
    public boolean hasError() { return !errors.isEmpty(); }
    private ArrayList<CompileError> errors;

    private void errorPrinter() {
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
                structDeclaration.accept(this);
            }
            SymbolTable.push(structSymbolTable);
        }

        for (FunctionDeclaration functionDeclaration:program.getFunctions()) {
            SymbolTable newSymbolTable = new SymbolTable();
            FunctionSymbolTableItem newSymbolTableItem = new FunctionSymbolTableItem(functionDeclaration);
            newSymbolTableItem.setFunctionSymbolTable((newSymbolTable));
            try{
                SymbolTable.root.getItem(StructSymbolTableItem.START_KEY + functionDeclaration.getFunctionName().getName());
                FunctionStructConflict exception = new FunctionStructConflict(functionDeclaration.getLine(), functionDeclaration.getFunctionName().getName());
                program.addError(exception);
            } catch (ItemNotFoundException ignored){}
            try{
                root.put(newSymbolTableItem);
            } catch (ItemAlreadyExistsException ex) {
                DuplicateFunction exception = new DuplicateFunction(functionDeclaration.getLine(), functionDeclaration.getFunctionName().getName());
                program.addError(exception);
                functionDeclaration.accept(this);
            }
            SymbolTable.push(newSymbolTable);
        }

        program.getMain().accept(this);
        errors.addAll(program.flushErrors());
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
            } catch (ItemNotFoundException e) {
                e.printStackTrace();
            }
        }
        functionDec.getBody().accept(this);

        return null;
    }

    @Override
    public Void visit(MainDeclaration mainDec) {
        mainDec.getBody().accept(this);
        return null;
    }
    //todo
    @Override
    public Void visit(VariableDeclaration variableDec) {
        variableDec.getVarName().accept(this);
        if (variableDec.getDefaultValue() != null)
            variableDec.getDefaultValue().accept(this);
        return null;
    }

    @Override
    public Void visit(StructDeclaration structDec) {
        structDec.getStructName().accept(this);
        structDec.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(SetGetVarDeclaration setGetVarDec) {
        setGetVarDec.getVarName().accept(this);
        for (VariableDeclaration var: setGetVarDec.getArgs())
            var.accept(this);
        setGetVarDec.getSetterBody().accept(this);
        setGetVarDec.getGetterBody().accept(this);
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
        conditionalStmt.getCondition().accept(this);
        conditionalStmt.getThenBody().accept(this);
        conditionalStmt.getElseBody().accept(this);
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
        loopStmt.getCondition().accept(this);
        loopStmt.getBody().accept(this);
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
    public Void visit(Identifier identifier) {
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
