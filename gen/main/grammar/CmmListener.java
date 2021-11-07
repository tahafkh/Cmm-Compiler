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
	 * Enter a parse tree produced by {@link CmmParser#display_statement}.
	 * @param ctx the parse tree
	 */
	void enterDisplay_statement(CmmParser.Display_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#display_statement}.
	 * @param ctx the parse tree
	 */
	void exitDisplay_statement(CmmParser.Display_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#size_statement}.
	 * @param ctx the parse tree
	 */
	void enterSize_statement(CmmParser.Size_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#size_statement}.
	 * @param ctx the parse tree
	 */
	void exitSize_statement(CmmParser.Size_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#append_statement}.
	 * @param ctx the parse tree
	 */
	void enterAppend_statement(CmmParser.Append_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#append_statement}.
	 * @param ctx the parse tree
	 */
	void exitAppend_statement(CmmParser.Append_statementContext ctx);
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
	 * Enter a parse tree produced by {@link CmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CmmParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CmmParser.ExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link CmmParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(CmmParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(CmmParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#extra_parantheses}.
	 * @param ctx the parse tree
	 */
	void enterExtra_parantheses(CmmParser.Extra_paranthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#extra_parantheses}.
	 * @param ctx the parse tree
	 */
	void exitExtra_parantheses(CmmParser.Extra_paranthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#list_refrence}.
	 * @param ctx the parse tree
	 */
	void enterList_refrence(CmmParser.List_refrenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#list_refrence}.
	 * @param ctx the parse tree
	 */
	void exitList_refrence(CmmParser.List_refrenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterMethod_call(CmmParser.Method_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitMethod_call(CmmParser.Method_callContext ctx);
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
	 * Enter a parse tree produced by {@link CmmParser#dot_refrence}.
	 * @param ctx the parse tree
	 */
	void enterDot_refrence(CmmParser.Dot_refrenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#dot_refrence}.
	 * @param ctx the parse tree
	 */
	void exitDot_refrence(CmmParser.Dot_refrenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#bracket_indexing}.
	 * @param ctx the parse tree
	 */
	void enterBracket_indexing(CmmParser.Bracket_indexingContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#bracket_indexing}.
	 * @param ctx the parse tree
	 */
	void exitBracket_indexing(CmmParser.Bracket_indexingContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#fptr_decleration}.
	 * @param ctx the parse tree
	 */
	void enterFptr_decleration(CmmParser.Fptr_declerationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#fptr_decleration}.
	 * @param ctx the parse tree
	 */
	void exitFptr_decleration(CmmParser.Fptr_declerationContext ctx);
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