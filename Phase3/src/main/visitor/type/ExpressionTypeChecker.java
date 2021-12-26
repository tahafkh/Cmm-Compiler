package main.visitor.type;

import main.ast.nodes.Node;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.*;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.types.*;
import main.ast.types.primitives.*;
import main.compileError.CompileError;
import main.compileError.typeError.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.FunctionSymbolTableItem;
import main.symbolTable.items.StructSymbolTableItem;
import main.symbolTable.items.VariableSymbolTableItem;
import main.visitor.Visitor;

import java.util.ArrayList;

public class ExpressionTypeChecker extends Visitor<Type> {

    private Boolean isFunctioncallStmt = false;
    private Boolean isStructDec = false;

    public void addChildNodeErrors(Node parentNode, Node childNode) {
        for (CompileError exception : childNode.flushErrors())
            parentNode.addError(exception);
    }

    public void setIsStructDec(Boolean isStructDec){
        this.isStructDec = isStructDec;
    }

    public Boolean isLValue(Expression expression){
        return (expression instanceof Identifier) || (expression instanceof StructAccess)
                || (expression instanceof ListAccessByIndex);
    }

    public Boolean haveSameType(Type leftType, Type rightType) {
        if(leftType instanceof NoType || rightType instanceof NoType)
            return true;
        if(leftType instanceof ListType && rightType instanceof ListType)
            return haveSameType(((ListType) leftType).getType(), ((ListType) rightType).getType());
        if(leftType instanceof StructType leftStructType && rightType instanceof StructType rightStructType)
            return leftStructType.getStructName().getName().equals(rightStructType.getStructName().getName());
        if(leftType instanceof IntType  && rightType instanceof IntType)
            return true;
        if(leftType instanceof BoolType && rightType instanceof BoolType)
            return true;
        if(leftType instanceof VoidType && rightType instanceof VoidType)
            return true;

        if(leftType instanceof FptrType && rightType instanceof FptrType){
            if (!haveSameType( ((FptrType) leftType).getReturnType(), ((FptrType) rightType).getReturnType() ))
                return false;

            ArrayList<Type> leftTypeArgs = ((FptrType) leftType).getArgsType();
            ArrayList<Type> rightTypeArgs = ((FptrType) rightType).getArgsType();

            if(leftTypeArgs.size() != rightTypeArgs.size())
                return false;
            else{
                for(int i = 0; i < leftTypeArgs.size(); i++){
                    if(!haveSameType(leftTypeArgs.get(i),rightTypeArgs.get(i)))
                        return false;
                }
            }
            return true;
        }

        return false;
    }

    @Override
    public Type visit(BinaryExpression binaryExpression) {
        Expression left = binaryExpression.getFirstOperand();
        Expression right = binaryExpression.getSecondOperand();
        BinaryOperator operator =  binaryExpression.getBinaryOperator();

        Type leftType = left.accept(this);

        Type rightType = right.accept(this);

        if (operator.equals(BinaryOperator.and) || operator.equals(BinaryOperator.or)){
            if (leftType instanceof BoolType && rightType instanceof BoolType)
                return new BoolType();

            if ((leftType instanceof NoType || leftType instanceof BoolType) &&
                (rightType instanceof BoolType || rightType instanceof NoType))
                return new NoType();
        }

        else if(operator.equals(BinaryOperator.eq)){
            if(leftType instanceof ListType || rightType instanceof ListType){
                UnsupportedOperandType exception = new UnsupportedOperandType(left.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            if(!haveSameType(leftType, rightType)){
                UnsupportedOperandType exception = new UnsupportedOperandType(right.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else {
                if(leftType instanceof NoType || rightType instanceof NoType)
                    return new NoType();
                else
                    return new BoolType();
            }
        }

        else if(operator.equals(BinaryOperator.gt) || operator.equals(BinaryOperator.lt)){
            if (leftType instanceof IntType && rightType instanceof IntType)
                return new BoolType();

            if ((leftType instanceof NoType || leftType instanceof IntType) &&
                (rightType instanceof IntType || rightType instanceof NoType))
                return new NoType();
        }

        else if(operator.equals(BinaryOperator.assign)) {
            if(!haveSameType(leftType, rightType)){
                UnsupportedOperandType exception = new UnsupportedOperandType(right.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            if (!isLValue(left)) {
                LeftSideNotLvalue exception = new LeftSideNotLvalue(left.getLine());
                binaryExpression.addError(exception);
                return new NoType();
            }
        }

        else { // mult, add, sub, div
            if (leftType instanceof IntType && rightType instanceof IntType)
                return new IntType();

            if ((leftType instanceof NoType || leftType instanceof IntType) &&
                (rightType instanceof IntType || rightType instanceof NoType))
                return new NoType();
        }

        UnsupportedOperandType exception = new UnsupportedOperandType(left.getLine(), operator.name());
        left.addError(exception);
        return new NoType();
    }

    @Override
    public Type visit(UnaryExpression unaryExpression) {
        Expression uExpr = unaryExpression.getOperand();
        Type uType = uExpr.accept(this);
        UnaryOperator operator = unaryExpression.getOperator();

        if(operator.equals(UnaryOperator.minus)) {
            if (uType instanceof IntType)
                return new IntType();
        }
        else if (operator.equals(UnaryOperator.not)) {
            if (uType instanceof BoolType)
                return new BoolType();
        }

        if (!(uType instanceof NoType)) {
            UnsupportedOperandType exception = new UnsupportedOperandType(uExpr.getLine(), operator.name());
            uExpr.addError(exception);
        }
        return new NoType();
    }

    @Override
    public Type visit(FunctionCall funcCall) {
        Type type = funcCall.getInstance().accept(this);
        ArrayList<Type> fargsType = new ArrayList<>();
        ArrayList<Type> definedArgsType = new ArrayList<>();
        Type returnType = null;

        Boolean temp = this.isFunctioncallStmt;
        this.isFunctioncallStmt = false;
        for (Expression expression : funcCall.getArgs()) {
            Type t = expression.accept(this);
            fargsType.add(t);
        }
        this.isFunctioncallStmt = temp;

        boolean isFuncName = false;

        if (funcCall.getInstance() instanceof Identifier) {
            try {
                FunctionSymbolTableItem funcSym = (FunctionSymbolTableItem) SymbolTable.root.getItem(
                                                                 FunctionSymbolTableItem.START_KEY +
                                                                    ((Identifier) funcCall.getInstance()).getName());
                isFuncName = true;
                definedArgsType = funcSym.getArgTypes();
                returnType = funcSym.getReturnType();
            }catch (ItemNotFoundException ignored) {}
        }

        if (!(type instanceof FptrType || type instanceof NoType || isFuncName)){
            CallOnNoneFptrType exception = new CallOnNoneFptrType(funcCall.getLine());
            funcCall.addError(exception);
            return new NoType();
        }

        if(type instanceof FptrType) {
            definedArgsType = ((FptrType) type).getArgsType();
            returnType = ((FptrType) type).getReturnType();
        }

        if (!(type instanceof NoType)) {
            boolean declareError = false;
            boolean error = false;
            if (returnType instanceof VoidType && !isFunctioncallStmt) {
                CantUseValueOfVoidFunction exception = new CantUseValueOfVoidFunction(funcCall.getLine());
                funcCall.addError(exception);
                error = true;
            }

            if(fargsType.size() != definedArgsType.size())
                declareError = true;
            else {
                if(fargsType.size() != 0) {
                    int i = 0;
                    for (Type expectedType : definedArgsType) {
                        if (!haveSameType(expectedType, fargsType.get(i))) {
                            declareError = true;
                            break;
                        }
                        i++;
                    }
                }
            }

            if (declareError) {
                ArgsInFunctionCallNotMatchDefinition exception = new ArgsInFunctionCallNotMatchDefinition(funcCall.getLine());
                funcCall.addError(exception);
            }
            if (declareError || error)
                return new NoType();
            return returnType;
        }

        return new NoType();
    }

    @Override
    public Type visit(Identifier identifier) {
        try{
            FunctionSymbolTableItem funcItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + identifier.getName());
            return new FptrType(funcItem.getArgTypes(), funcItem.getReturnType());
        } catch (ItemNotFoundException ignored) {}

        try{
            StructSymbolTableItem structItem = (StructSymbolTableItem) SymbolTable.root.getItem(StructSymbolTableItem.START_KEY + identifier.getName());
            return new StructType(identifier);
        }catch (ItemNotFoundException ignored) {}

        try{
            VariableSymbolTableItem variableItem = (VariableSymbolTableItem) SymbolTable.top.getItem(VariableSymbolTableItem.START_KEY + identifier.getName());
            return variableItem.getType();
        } catch (ItemNotFoundException e1) {
            if (this.isStructDec) {
                StructNotDeclared exception = new StructNotDeclared(identifier.getLine(), identifier.getName());
                identifier.addError(exception);
            }
            else{
                VarNotDeclared exception = new VarNotDeclared(identifier.getLine(), identifier.getName());
                identifier.addError(exception);
            }
        }
        return new NoType();
    }

    @Override
    public Type visit(ListAccessByIndex listAccessByIndex) {
        Type listType = listAccessByIndex.getInstance().accept(this);
        Type indexType = listAccessByIndex.getIndex().accept(this);

        if(!(indexType instanceof IntType) && !(indexType instanceof NoType)) {
            ListIndexNotInt exception = new ListIndexNotInt(listAccessByIndex.getLine());
            listAccessByIndex.addError(exception);
        }
        addChildNodeErrors(listAccessByIndex, listAccessByIndex.getInstance());
        addChildNodeErrors(listAccessByIndex, listAccessByIndex.getIndex());

        if(listType instanceof ListType) {
            if (haveSameType( ((ListType) listType).getType(), indexType))
                return new IntType();
        }
        else if(!(listType instanceof NoType)) {
            AccessByIndexOnNonList exception = new AccessByIndexOnNonList(listAccessByIndex.getLine());
            listAccessByIndex.addError(exception);
        }
        return new NoType();
    }

    @Override
    public Type visit(StructAccess structAccess) {
        Expression instance = structAccess.getInstance();
        Identifier element = structAccess.getElement();
        Type structType = instance.accept(this);
        if(structType instanceof StructType) {
            String structName = ((StructType) structType).getStructName().getName();
            SymbolTable structSymbolTable;
            try{
                structSymbolTable = ((StructSymbolTableItem) SymbolTable.root.getItem(StructSymbolTableItem.START_KEY + structName)).getStructSymbolTable();
            }catch (ItemNotFoundException structNotFound){
                return new NoType();
            }
            try{
                VariableSymbolTableItem variableSymbolTableItem = (VariableSymbolTableItem) structSymbolTable.getItem(VariableSymbolTableItem.START_KEY + element.getName());
                return variableSymbolTableItem.getType();
            }catch(ItemNotFoundException elementNotFound){
                StructMemberNotFound exception = new StructMemberNotFound(structAccess.getLine(), structName, element.getName());
                structAccess.addError(exception);
                return new NoType();
            }
        }
        else if(!(structType instanceof NoType)) {
            AccessOnNonStruct exception = new AccessOnNonStruct(structAccess.getLine());
            structAccess.addError(exception);
        }
        return new NoType();
    }

    @Override
    public Type visit(ListSize listSize) {
        Type argType = listSize.getArg().accept(this);
        if(argType instanceof ListType)
            return new IntType();
        else {
            if(!(argType instanceof NoType)) {
                GetSizeOfNonList exception = new GetSizeOfNonList(listSize.getLine());
                listSize.addError(exception);
            }
            return new NoType();
        }
    }

    @Override
    public Type visit(ListAppend listAppend) {
        Type listArgType = listAppend.getListArg().accept(this);
        Type elementArgType = listAppend.getElementArg().accept(this);

        if(listArgType instanceof ListType) {
            if (haveSameType( ((ListType) listArgType).getType(), elementArgType))
                return new VoidType();

            if(!(elementArgType instanceof NoType)) {
                NewElementTypeNotMatchListType exception = new NewElementTypeNotMatchListType(listAppend.getLine());
                listAppend.addError(exception);
            }
        }
        else if(!(listArgType instanceof NoType)) {
            AppendToNonList exception = new AppendToNonList(listAppend.getLine());
            listAppend.addError(exception);
        }
        return new NoType();
    }

    @Override
    public Type visit(ExprInPar exprInPar) {
        ArrayList<Expression> inputs = exprInPar.getInputs();
        Type type = inputs.get(0).accept(this);
        for (int i = 1; i < inputs.size(); i++) {
            inputs.get(i).accept(this);
        }
        return type;
    }

    @Override
    public Type visit(IntValue intValue) {
        return new IntType();
    }

    @Override
    public Type visit(BoolValue boolValue) {
        return new BoolType();
    }
}
