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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class NameAnalyzer  extends Visitor<Void> {
    public boolean hasError() { return !errors.isEmpty(); }
    private ArrayList<CompileError> errors;
    private int newStructID = 1;
    private int newFuncID = 1;

    private boolean inStruct = false;
    private StructDeclaration curr_struct = null;
    private HashMap<StructDeclaration, ArrayList<String> > structDependency =
            new HashMap<>();
    private HashMap<String, StructDeclaration > nameStruct = new HashMap<>();
    private HashMap<StructDeclaration, Boolean> isBeingVisited = new HashMap<>();
    private HashMap<StructDeclaration, Boolean> isVisited = new HashMap<>();
    private HashSet<StructDeclaration> inCycle = new HashSet<>();

    private boolean hasCycle(StructDeclaration struct) {
        isBeingVisited.put(struct, true);
        Boolean isInCycle = false;
        for (String neighbor : structDependency.get(struct)) {
            try {
                StructDeclaration neighborStruct = nameStruct.get(neighbor);
                if (isBeingVisited.containsKey(neighborStruct) && isBeingVisited.get(neighborStruct)) {
                    inCycle.add(neighborStruct);
                    isInCycle = true;
                }
                else if (hasCycle(neighborStruct) && isVisited.containsKey(neighborStruct) && isVisited.get(neighborStruct)) {
                    inCycle.add(neighborStruct);
                }
            } catch (Exception ignored) {}
        }

        isBeingVisited.put(struct, false);
        isVisited.put(struct, true);
        return isInCycle;
    }

    private void checkCyclicDependencies(ArrayList<StructDeclaration> structs){
        for (StructDeclaration structDeclaration : structs) {
            isVisited.clear();
            hasCycle(structDeclaration);
        }
        for(StructDeclaration struct : inCycle){
            errors.add(new CyclicDependency(struct.getLine(), struct.getStructName().getName()));
        }
    }

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
            newSymbolTableItem.setStructSymbolTable(structSymbolTable);
            try{
                root.put(newSymbolTableItem);

                nameStruct.put(structDeclaration.toString(), structDeclaration);
            } catch (ItemAlreadyExistsException ex) {
                DuplicateStruct exception = new DuplicateStruct(structDeclaration.getLine(), structDeclaration.getStructName().getName());
                program.addError(exception);
                String newName = structDeclaration.getStructName().getName() + "@" + newStructID;
                newStructID += 1;
                structDeclaration.setStructName(new Identifier(newName));
                try {
                    StructSymbolTableItem newStructSym = new StructSymbolTableItem(structDeclaration);
                    newStructSym.setStructSymbolTable(structSymbolTable);
                    root.put(newStructSym);
                } catch (ItemAlreadyExistsException ignored) {}
            }
            SymbolTable.push(structSymbolTable);
        }

        for (FunctionDeclaration functionDeclaration:program.getFunctions()) {
            SymbolTable funcSymbolTable = new SymbolTable();
            FunctionSymbolTableItem newSymbolTableItem = new FunctionSymbolTableItem(functionDeclaration);
            newSymbolTableItem.setFunctionSymbolTable(funcSymbolTable);
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
                String newName = functionDeclaration.getFunctionName().getName() + "@" + newFuncID;
                newFuncID += 1;
                functionDeclaration.setFunctionName(new Identifier(newName));
                try {
                    FunctionSymbolTableItem newFuncSym = new FunctionSymbolTableItem(functionDeclaration);
                    newFuncSym.setFunctionSymbolTable(funcSymbolTable);
                    root.put(newFuncSym);
                } catch (ItemAlreadyExistsException ignored) {}
            }
            SymbolTable.push(funcSymbolTable);
        }

        SymbolTable.push(new SymbolTable());
        program.getMain().accept(this);
        SymbolTable.pop();

        for (StructDeclaration structDeclaration: program.getStructs()) {
            SymbolTableItem curSymbolTableItem;
            StructSymbolTableItem structSymbolTableItem;
            try{
                curSymbolTableItem = SymbolTable.root.getItem(StructSymbolTableItem.START_KEY + structDeclaration.getStructName().getName());
                structSymbolTableItem = (StructSymbolTableItem) curSymbolTableItem;
                SymbolTable.push(structSymbolTableItem.getStructSymbolTable());
                structDeclaration.accept(this);
                SymbolTable.pop();
            }catch (ItemNotFoundException ignored){}
        }

        ArrayList<StructDeclaration> structs = new ArrayList<StructDeclaration>(structDependency.keySet());
        checkCyclicDependencies(structs);

        for (FunctionDeclaration funcDeclaration: program.getFunctions()) {
            SymbolTableItem curSymbolTableItem;
            FunctionSymbolTableItem funcSymbolTableItem;
            try{
                curSymbolTableItem = SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + funcDeclaration.getFunctionName().getName());
                funcSymbolTableItem = (FunctionSymbolTableItem) curSymbolTableItem;
                SymbolTable.push(funcSymbolTableItem.getFunctionSymbolTable());
                funcDeclaration.accept(this);
                SymbolTable.pop();
            }catch (ItemNotFoundException ignored){}
        }

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
        if (inStruct && !curr_struct.getStructName().getName().contains("@")) {
            if (variableDec.getVarType().toString().contains("StructType_")) {
                String neighbourStruct = variableDec.getVarType().toString().replace("StructType", "StructDeclaration");
                structDependency.computeIfAbsent(curr_struct, k -> new ArrayList<>()).add(neighbourStruct);
            }
        }
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
        if (conditionalStmt.getElseBody() != null) {
            SymbolTable.push(_else);
            conditionalStmt.getElseBody().accept(this);
            SymbolTable.pop();
        }
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
        if (returnStmt.getReturnedExpr() != null)
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
