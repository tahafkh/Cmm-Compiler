// Generated from E:/UT/S5/Compiler/CA/Phase 1/src/main/grammar\Cmm.g4 by ANTLR 4.9.1
package main.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CmmParser}.
 */
public interface CmmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CmmParser#cmm}.
	 * @param ctx the parse tree
	 */
	void enterCmm(CmmParser.CmmContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#cmm}.
	 * @param ctx the parse tree
	 */
	void exitCmm(CmmParser.CmmContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#no_function_call_statement}.
	 * @param ctx the parse tree
	 */
	void enterNo_function_call_statement(CmmParser.No_function_call_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#no_function_call_statement}.
	 * @param ctx the parse tree
	 */
	void exitNo_function_call_statement(CmmParser.No_function_call_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CmmParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CmmParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#display_expression}.
	 * @param ctx the parse tree
	 */
	void enterDisplay_expression(CmmParser.Display_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#display_expression}.
	 * @param ctx the parse tree
	 */
	void exitDisplay_expression(CmmParser.Display_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#size_expression}.
	 * @param ctx the parse tree
	 */
	void enterSize_expression(CmmParser.Size_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#size_expression}.
	 * @param ctx the parse tree
	 */
	void exitSize_expression(CmmParser.Size_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#append_expression}.
	 * @param ctx the parse tree
	 */
	void enterAppend_expression(CmmParser.Append_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#append_expression}.
	 * @param ctx the parse tree
	 */
	void exitAppend_expression(CmmParser.Append_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#conditional_statement}.
	 * @param ctx the parse tree
	 */
	void enterConditional_statement(CmmParser.Conditional_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#conditional_statement}.
	 * @param ctx the parse tree
	 */
	void exitConditional_statement(CmmParser.Conditional_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(CmmParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(CmmParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElse_statement(CmmParser.Else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElse_statement(CmmParser.Else_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void enterLoop_statement(CmmParser.Loop_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void exitLoop_statement(CmmParser.Loop_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#do_while_loop}.
	 * @param ctx the parse tree
	 */
	void enterDo_while_loop(CmmParser.Do_while_loopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#do_while_loop}.
	 * @param ctx the parse tree
	 */
	void exitDo_while_loop(CmmParser.Do_while_loopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#while_loop}.
	 * @param ctx the parse tree
	 */
	void enterWhile_loop(CmmParser.While_loopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#while_loop}.
	 * @param ctx the parse tree
	 */
	void exitWhile_loop(CmmParser.While_loopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void enterExpression_statement(CmmParser.Expression_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void exitExpression_statement(CmmParser.Expression_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#declare_statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_statement(CmmParser.Declare_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#declare_statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_statement(CmmParser.Declare_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#var_init}.
	 * @param ctx the parse tree
	 */
	void enterVar_init(CmmParser.Var_initContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#var_init}.
	 * @param ctx the parse tree
	 */
	void exitVar_init(CmmParser.Var_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(CmmParser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(CmmParser.Return_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#function_call_statement}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call_statement(CmmParser.Function_call_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#function_call_statement}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call_statement(CmmParser.Function_call_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(CmmParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(CmmParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#function_decleration}.
	 * @param ctx the parse tree
	 */
	void enterFunction_decleration(CmmParser.Function_declerationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#function_decleration}.
	 * @param ctx the parse tree
	 */
	void exitFunction_decleration(CmmParser.Function_declerationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(CmmParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(CmmParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#func_body}.
	 * @param ctx the parse tree
	 */
	void enterFunc_body(CmmParser.Func_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#func_body}.
	 * @param ctx the parse tree
	 */
	void exitFunc_body(CmmParser.Func_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#comma_expression}.
	 * @param ctx the parse tree
	 */
	void enterComma_expression(CmmParser.Comma_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#comma_expression}.
	 * @param ctx the parse tree
	 */
	void exitComma_expression(CmmParser.Comma_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expression(CmmParser.Assign_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expression(CmmParser.Assign_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#or_expression}.
	 * @param ctx the parse tree
	 */
	void enterOr_expression(CmmParser.Or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#or_expression}.
	 * @param ctx the parse tree
	 */
	void exitOr_expression(CmmParser.Or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#and_expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expression(CmmParser.And_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#and_expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expression(CmmParser.And_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#equal_expression}.
	 * @param ctx the parse tree
	 */
	void enterEqual_expression(CmmParser.Equal_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#equal_expression}.
	 * @param ctx the parse tree
	 */
	void exitEqual_expression(CmmParser.Equal_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#relation_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelation_expression(CmmParser.Relation_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#relation_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelation_expression(CmmParser.Relation_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#add_sub_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdd_sub_expression(CmmParser.Add_sub_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#add_sub_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdd_sub_expression(CmmParser.Add_sub_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#mult_div_expression}.
	 * @param ctx the parse tree
	 */
	void enterMult_div_expression(CmmParser.Mult_div_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#mult_div_expression}.
	 * @param ctx the parse tree
	 */
	void exitMult_div_expression(CmmParser.Mult_div_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#not_expression}.
	 * @param ctx the parse tree
	 */
	void enterNot_expression(CmmParser.Not_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#not_expression}.
	 * @param ctx the parse tree
	 */
	void exitNot_expression(CmmParser.Not_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#high_expression}.
	 * @param ctx the parse tree
	 */
	void enterHigh_expression(CmmParser.High_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#high_expression}.
	 * @param ctx the parse tree
	 */
	void exitHigh_expression(CmmParser.High_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#final_expression}.
	 * @param ctx the parse tree
	 */
	void enterFinal_expression(CmmParser.Final_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#final_expression}.
	 * @param ctx the parse tree
	 */
	void exitFinal_expression(CmmParser.Final_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CmmParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CmmParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(CmmParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(CmmParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#fptr_type}.
	 * @param ctx the parse tree
	 */
	void enterFptr_type(CmmParser.Fptr_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#fptr_type}.
	 * @param ctx the parse tree
	 */
	void exitFptr_type(CmmParser.Fptr_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#function_type}.
	 * @param ctx the parse tree
	 */
	void enterFunction_type(CmmParser.Function_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#function_type}.
	 * @param ctx the parse tree
	 */
	void exitFunction_type(CmmParser.Function_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#struct_decleration}.
	 * @param ctx the parse tree
	 */
	void enterStruct_decleration(CmmParser.Struct_declerationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#struct_decleration}.
	 * @param ctx the parse tree
	 */
	void exitStruct_decleration(CmmParser.Struct_declerationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#struct_type}.
	 * @param ctx the parse tree
	 */
	void enterStruct_type(CmmParser.Struct_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#struct_type}.
	 * @param ctx the parse tree
	 */
	void exitStruct_type(CmmParser.Struct_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#struct_init}.
	 * @param ctx the parse tree
	 */
	void enterStruct_init(CmmParser.Struct_initContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#struct_init}.
	 * @param ctx the parse tree
	 */
	void exitStruct_init(CmmParser.Struct_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#struct_statement}.
	 * @param ctx the parse tree
	 */
	void enterStruct_statement(CmmParser.Struct_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#struct_statement}.
	 * @param ctx the parse tree
	 */
	void exitStruct_statement(CmmParser.Struct_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#set_get}.
	 * @param ctx the parse tree
	 */
	void enterSet_get(CmmParser.Set_getContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#set_get}.
	 * @param ctx the parse tree
	 */
	void exitSet_get(CmmParser.Set_getContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#setter}.
	 * @param ctx the parse tree
	 */
	void enterSetter(CmmParser.SetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#setter}.
	 * @param ctx the parse tree
	 */
	void exitSetter(CmmParser.SetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#getter}.
	 * @param ctx the parse tree
	 */
	void enterGetter(CmmParser.GetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#getter}.
	 * @param ctx the parse tree
	 */
	void exitGetter(CmmParser.GetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#list_decleration}.
	 * @param ctx the parse tree
	 */
	void enterList_decleration(CmmParser.List_declerationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#list_decleration}.
	 * @param ctx the parse tree
	 */
	void exitList_decleration(CmmParser.List_declerationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#list_type}.
	 * @param ctx the parse tree
	 */
	void enterList_type(CmmParser.List_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#list_type}.
	 * @param ctx the parse tree
	 */
	void exitList_type(CmmParser.List_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CmmParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CmmParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#initable_type}.
	 * @param ctx the parse tree
	 */
	void enterInitable_type(CmmParser.Initable_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#initable_type}.
	 * @param ctx the parse tree
	 */
	void exitInitable_type(CmmParser.Initable_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#non_initable_type}.
	 * @param ctx the parse tree
	 */
	void enterNon_initable_type(CmmParser.Non_initable_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#non_initable_type}.
	 * @param ctx the parse tree
	 */
	void exitNon_initable_type(CmmParser.Non_initable_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#eol}.
	 * @param ctx the parse tree
	 */
	void enterEol(CmmParser.EolContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#eol}.
	 * @param ctx the parse tree
	 */
	void exitEol(CmmParser.EolContext ctx);
}