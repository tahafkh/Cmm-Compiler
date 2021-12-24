package main.visitor.type;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.struct.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.statement.*;
import main.ast.types.*;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.IntType;
import main.ast.types.primitives.VoidType;
import main.compileError.typeError.*;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.items.*;
import main.visitor.Visitor;

import java.util.ArrayList;
import java.util.Set;

public class TypeChecker extends Visitor<Void> {

    ExpressionTypeChecker expressionTypeChecker;

    private Boolean haveSameType(Type leftType, Type rightType) {
        if(leftType instanceof NoType || rightType instanceof NoType)
            return true;
        if(leftType instanceof IntType && rightType instanceof IntType)
            return true;
        if(leftType instanceof BoolType && rightType instanceof BoolType)
            return true;
        if(leftType instanceof VoidType && rightType instanceof VoidType)
            return true;

        if(leftType instanceof FptrType && rightType instanceof FptrType){
            //todo: Point to the same function???
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

    public void TypeChecker(){
        this.expressionTypeChecker = new ExpressionTypeChecker();
    }

    @Override
    public Void visit(Program program) {
        program.getMain().accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionDeclaration functionDec) {
        //TODO: check type
        functionDec.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(MainDeclaration mainDec) {
        mainDec.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(VariableDeclaration variableDec) {
        if (variableDec.getDefaultValue() != null) {
            Type defaultType = variableDec.getDefaultValue().accept(expressionTypeChecker);
            if (!haveSameType(variableDec.getVarType(), defaultType)) {
                UnsupportedOperandType exception;
                exception = new UnsupportedOperandType(variableDec.getLine(), BinaryOperator.assign.name());
                variableDec.addError(exception);
            }
        }
        if (variableDec.getVarType() instanceof StructType structType) {
            try {
                SymbolTable.root.getItem(StructSymbolTableItem.START_KEY + structType.getStructName().getName());
            } catch (ItemNotFoundException e) {
                variableDec.addError(new StructNotDeclared(variableDec.getLine(), structType.getStructName().getName()));
            }
        }
        // check declaration in setGet and struct
        return null;
    }

    @Override
    public Void visit(StructDeclaration structDec) {
        structDec.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(SetGetVarDeclaration setGetVarDec) {
        //Todo
        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        //Todo
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
        Type condType = conditionalStmt.getCondition().accept(expressionTypeChecker);
        if(!(condType instanceof BoolType || condType instanceof NoType)) {
            ConditionNotBool exception = new ConditionNotBool(conditionalStmt.getLine());
            conditionalStmt.addError(exception);
        }
        conditionalStmt.getThenBody().accept(this);
        if (conditionalStmt.getElseBody() != null)
            conditionalStmt.getElseBody().accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionCallStmt functionCallStmt) {
        //Todo
        return null;
    }

    @Override
    public Void visit(DisplayStmt displayStmt) {
        if (displayStmt.getArg().accept(expressionTypeChecker) instanceof FptrType
            || displayStmt.getArg().accept(expressionTypeChecker) instanceof StructType) {
            UnsupportedTypeForDisplay excpetion;
            excpetion = new UnsupportedTypeForDisplay(displayStmt.getLine());
            displayStmt.addError(excpetion);
        }
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        //Todo
        Type returnType = returnStmt.getReturnedExpr().accept(expressionTypeChecker);
        if(!expressionTypeChecker.haveSameType(curFunction.getReturnType(), returnType)){
            ReturnValueNotMatchFunctionReturnType exception = new ReturnValueNotMatchFunctionReturnType(returnStmt.getLine());
            returnStmt.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(LoopStmt loopStmt) {
        Type condType = loopStmt.getCondition().accept(expressionTypeChecker);
        if(!(condType instanceof BoolType || condType instanceof NoType)) {
            ConditionNotBool exception = new ConditionNotBool(loopStmt.getLine());
            loopStmt.addError(exception);
        }
        loopStmt.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(VarDecStmt varDecStmt) {
        for (VariableDeclaration varDec : varDecStmt.getVars()) {
            varDec.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ListAppendStmt listAppendStmt) {
        listAppendStmt.getListAppendExpr().accept(expressionTypeChecker);
        return null;
    }

    @Override
    public Void visit(ListSizeStmt listSizeStmt) {
        listSizeStmt.getListSizeExpr().accept(expressionTypeChecker);
        return null;
    }
}
