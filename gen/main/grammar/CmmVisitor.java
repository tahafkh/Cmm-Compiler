// Generated from E:/UT/S5/Compiler/CA/Phase 1/src/main/grammar\Cmm.g4 by ANTLR 4.9.1
package main.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CmmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CmmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CmmParser#cmm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmm(CmmParser.CmmContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CmmParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#display_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplay_statement(CmmParser.Display_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#size_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSize_statement(CmmParser.Size_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#append_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppend_statement(CmmParser.Append_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#conditional_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional_statement(CmmParser.Conditional_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(CmmParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#else_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_statement(CmmParser.Else_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#loop_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_statement(CmmParser.Loop_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#do_while_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDo_while_loop(CmmParser.Do_while_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#while_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_loop(CmmParser.While_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#function_call_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call_statement(CmmParser.Function_call_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#expression_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_statement(CmmParser.Expression_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#declare_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_statement(CmmParser.Declare_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(CmmParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(CmmParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#function_decleration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_decleration(CmmParser.Function_declerationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(CmmParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#func_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_body(CmmParser.Func_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CmmParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(CmmParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(CmmParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#extra_parantheses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtra_parantheses(CmmParser.Extra_paranthesesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#list_refrence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_refrence(CmmParser.List_refrenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_call(CmmParser.Method_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(CmmParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#dot_refrence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot_refrence(CmmParser.Dot_refrenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#bracket_indexing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracket_indexing(CmmParser.Bracket_indexingContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#fptr_decleration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFptr_decleration(CmmParser.Fptr_declerationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#fptr_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFptr_type(CmmParser.Fptr_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#function_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_type(CmmParser.Function_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#struct_decleration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_decleration(CmmParser.Struct_declerationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#struct_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_type(CmmParser.Struct_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#struct_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_init(CmmParser.Struct_initContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#set_get}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_get(CmmParser.Set_getContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#setter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetter(CmmParser.SetterContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#getter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetter(CmmParser.GetterContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#list_decleration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_decleration(CmmParser.List_declerationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#list_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_type(CmmParser.List_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CmmParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#initable_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitable_type(CmmParser.Initable_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#non_initable_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNon_initable_type(CmmParser.Non_initable_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#eol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEol(CmmParser.EolContext ctx);
}