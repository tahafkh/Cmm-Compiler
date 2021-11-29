grammar Cmm;

//Rules
cmm
    : NEWLINE* struct_decleration* NEWLINE* function_decleration* NEWLINE* main
    ;

no_function_call_statement
    : conditional_statement | loop_statement
      | declare_statement | return_statement | assign_expression
      | display_expression | size_expression | append_expression
    ;

//statements
statement
    : conditional_statement | loop_statement | function_call_statement
    | declare_statement | return_statement | assign_expression
    | display_expression | size_expression | append_expression
    ;

//display statement
display_expression // fix input
    : DISPLAY {System.out.println("Built-in : display");} LPAR expression_statement RPAR
    ;

//size statement
size_expression // fix input
    : SIZE {System.out.println("Size");} LPAR expression_statement RPAR
    ;

//append statement
append_expression // fix input
    : APPEND {System.out.println("Append");} LPAR expression_statement COMMA expression_statement RPAR
    ;

//conditinal statement
conditional_statement
    : IF {System.out.println("Conditional : if");}
    condition ((BEGIN  statement eol (statement eol)* END) | (NEWLINE statement)) (eol? else_statement)?
    ;

condition
    : (LPAR comma_expression RPAR) | comma_expression
    ;

else_statement
    : ELSE {System.out.println("Conditional : else");}
    ((BEGIN  statement eol (statement eol)* END) | (NEWLINE statement))
    ;

//loop statements
loop_statement
    : while_loop | do_while_loop
    ;

do_while_loop
    : DO {System.out.println("Loop : do...while");}
    ((BEGIN  statement eol (statement eol)* END eol?) | (NEWLINE statement eol?)) WHILE condition
    ;

while_loop
    : WHILE {System.out.println("Loop : while");} condition
    ((BEGIN statement eol (statement eol)* END) | (NEWLINE statement))
    ;

expression_statement
    : comma_expression
    ;

declare_statement //update println
    : (type (IDENTIFIER {System.out.println("VarDec : " + $IDENTIFIER.getText());} | var_init))
    (COMMA (var_init | IDENTIFIER {System.out.println("VarDec : " + $IDENTIFIER.getText());}))*
    ;

var_init
    : IDENTIFIER {System.out.println("VarDec : " + $IDENTIFIER.getText());} ASSIGN no_function_call_statement
    ;

return_statement
    : RETURN {System.out.println("Return");} comma_expression?
    ;

function_call_statement
    : expression_statement {System.out.println("FunctionCall");} LPAR parameters RPAR
    ;

main
    : MAIN {System.out.println("Main");} LPAR RPAR func_body //body is like function body
    ;

function_decleration
    : (type | VOID) IDENTIFIER {System.out.println("FunctionDec : " + $IDENTIFIER.getText());} arguments func_body
    ;

arguments
    : LPAR ( | type IDENTIFIER {System.out.println("ArgumentDec : " + $IDENTIFIER.getText());}
    (COMMA type IDENTIFIER {System.out.println("ArgumentDec : " + $IDENTIFIER.getText());})*) RPAR
    ;

func_body
    : BEGIN (statement eol)+ END NEWLINE*
    | NEWLINE statement eol
    ;

comma_expression // fix funtion arguments
    : comma_expression COMMA assign_expression {System.out.println("Operator : ,");}
    | assign_expression
    ;

assign_expression
    : assign_expression ASSIGN or_expression //{System.out.println("Operator : =");}
    | or_expression
    ;

or_expression
    : or_expression OR and_expression {System.out.println("Operator : |");}
    | and_expression
    ;

and_expression
    : and_expression AND equal_expression {System.out.println("Operator : &");}
    | equal_expression
    ;

equal_expression
    : equal_expression EQUAL relation_expression {System.out.println("Operator : ==");}
    | relation_expression
    ;

relation_expression
    : relation_expression Z=(GREATER_THAN | LESS_THAN) add_sub_expression {System.out.println("Operator : " + $Z.getText());}
    | add_sub_expression
    ;

add_sub_expression
    : add_sub_expression Y=(PLUS | MINUS) mult_div_expression {System.out.println("Operator : " + $Y.getText());}
    | mult_div_expression
    ;

mult_div_expression
    : mult_div_expression X=(DIV | MULT) not_expression {System.out.println("Operator : " + $X.getText());}
    | not_expression
    ;

not_expression
    : M=(MINUS | NOT) high_expression {System.out.println("Operator : " + $M.getText());}
    | high_expression
    ;

// high expression
high_expression
    : high_expression DOT final_expression
    | high_expression LBRACK comma_expression RBRACK
    | high_expression LPAR parameters RPAR
    | final_expression
    ;

final_expression
    : display_expression
    | size_expression
    | append_expression
    | value
    ;

value: INTEGER | BOOL_VALUE | IDENTIFIER | LPAR comma_expression RPAR;
parameters: (assign_expression (COMMA assign_expression)*)?;

fptr_type
    : FPTR LESS_THAN function_type (COMMA function_type)* ARROW function_type GREATER_THAN
    ;

function_type
    : type | VOID
    ;

// Struct:
struct_decleration
    : STRUCT IDENTIFIER {System.out.println("StructDec : " + $IDENTIFIER.getText());}
     ((BEGIN struct_init END NEWLINE) | NEWLINE struct_statement)
    ;

struct_type
    : STRUCT IDENTIFIER
    ;

struct_init
    : struct_statement+
    ;

struct_statement
    : (declare_statement eol | set_get)
    ;

set_get
    : type IDENTIFIER {System.out.println("VarDec : " + $IDENTIFIER.getText());} arguments BEGIN setter getter END eol
    ;

setter
    : SET {System.out.println("Setter");}
     ((NEWLINE statement eol) | (BEGIN (statement eol)+ END eol))
    ;

getter
    : GET {System.out.println("Getter");}
    ((NEWLINE statement eol) | (BEGIN (statement eol)+ END eol))
    ;

// List: UNUSED
list_decleration
    : list_type IDENTIFIER
    ;

list_type // Can't be initialized
    : LIST SHARP type
    ;


type
    : initable_type | non_initable_type
    ;

initable_type
    : PRIMITIVE_TYPE | fptr_type
    ;

non_initable_type
    : list_type | struct_type
    ;

eol //(SEMICOLON | ) NEWLINE
    : (SEMICOLON NEWLINE* | NEWLINE)
    ;


//Tokens
MAIN: 'main';
BEGIN: 'begin' WS* NEWLINE;
END: 'end';
RETURN: 'return';

// Methods
IF: 'if';
ELSE: 'else';
WHILE: 'while';
DO: 'do';
GET: 'get';
SET: 'set';

// Predefined functions
DISPLAY: 'display';
APPEND: 'append';
SIZE: 'size';

// Initial types
PRIMITIVE_TYPE: 'int' | 'bool';
FPTR: 'fptr';
STRUCT: 'struct';
LIST: 'list';
VOID: 'void';

// Symbols
LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';
SHARP: '#';
COMMA: ',';
DOT: '.';
SEMICOLON: ';';
ARROW: '->';

// Operators
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
EQUAL: '==';
GREATER_THAN: '>';
LESS_THAN: '<';
AND: '&';
OR: '|';
NOT: '~';
ASSIGN: '=';

// Typedefs
BOOL_VALUE: 'true' | 'false';
INTEGER: (NONZERODIGIT DIGIT*) | [0];
IDENTIFIER: (LETTER | UNDERSCORE) (LETTER | UNDERSCORE | DIGIT)*;

// Helper
DIGIT: [0-9];
NONZERODIGIT: [1-9];
LETTER: [a-zA-Z];
UNDERSCORE: '_';

// Whitespace and comment
COMMENT: ('/*' .*? '*/') NEWLINE* -> skip;
WS: ([ \t\r]) -> skip;
NEWLINE: ('\n' | '\r')+;
