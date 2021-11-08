grammar Cmm;

//Rules
//TODO
// Check new line at the beginning of file 100/100?
// function 100/100?
// function input handling !!!
// pre-defined functions 100/100?
// expression precedence !!!

cmm
    : NEWLINE* struct_decleration* NEWLINE* function_decleration* NEWLINE* main
    ;

//statements
statement
    : conditional_statement | loop_statement | function_call_expression
    | declare_statement | return_statement | expression_statement
    | display_expression | size_expression | append_expression
    ;

//display statement
display_expression // fix input
    : DISPLAY {System.out.println("Built-in : display");} LPAR expression RPAR
    ;

//size statement
size_expression // fix input
    : SIZE {System.out.println("Size");} LPAR expression RPAR
    ;

//append statement
append_expression // fix input
    : APPEND {System.out.println("Append");} LPAR expression COMMA expression RPAR
    ;

//conditinal statement
conditional_statement
    : IF {System.out.println("Conditional : if");} condition (BEGIN statement+ END | NEWLINE statement) else_statement?
    ;

condition
    : (LPAR expression RPAR) | expression
    ;

else_statement
    : ELSE {System.out.println("Conditional:else");} (BEGIN statement+ END | NEWLINE statement)
    ;

//loop statements
loop_statement
    : while_loop | do_while_loop
    ;

do_while_loop
    : DO {System.out.println("Loop : do...while");} ((BEGIN  statement+ END) | NEWLINE statement) WHILE condition eol
    ;

while_loop
    : WHILE condition {System.out.println("Loop : while");} ((BEGIN  statement+ END) | NEWLINE statement)
    ;

//function call statement
function_call_expression
    : variable {System.out.println("FunctionCall");}
    ;

//assignments etc.
expression_statement
    : expression eol
    ;

declare_statement //update println
    : (type (IDENTIFIER | var_init)) (COMMA (var_init | IDENTIFIER))* eol
    {System.out.println("VarDec:" + $IDENTIFIER.getText());}
    ;

var_init
    : IDENTIFIER ASSIGN expression
    ;

return_statement
    : RETURN {System.out.println("Return");} expression eol
    ;

main
    : MAIN LPAR RPAR func_body //body is like function body
    ;

function_decleration
    : (type | VOID) IDENTIFIER arguments func_body
    ;

arguments
    : LPAR ( | type IDENTIFIER (COMMA type IDENTIFIER)*) RPAR
    ;

func_body
    : BEGIN statement+ END
    | NEWLINE statement
    ;

comma_expression
    : comma_expression COMMA assign_expression {System.out.println("Operator:,");}
    | assign_expression
    ;

assign_expression
    : assign_expression ASSIGN or_expression {System.out.println("Operator:=");}
    | or_expression
    ;

or_expression
    : or_expression OR and_expression {System.out.println("Operator:|");}
    | and_expression
    ;

and_expression
    : and_expression AND equal_expression {System.out.println("Operator:&");}
    | equal_expression
    ;

equal_expression
    : equal_expression AND relation_expression {System.out.println("Operator:==");}
    | relation_expression
    ;

relation_expression
    : relation_expression Z=(GREATER_THAN | LESS_THAN) add_sub_expression {System.out.println("Operator:" + $Z.getText());}
    | add_sub_expression
    ;

add_sub_expression
    : add_sub_expression Y=(PLUS | MINUS) mult_div_expression {System.out.println("Operator:" + $Y.getText());}
    | mult_div_expression
    ;

mult_div_expression
    : mult_div_expression X=(DIV | MULT) not_expression {System.out.println("Operator:" + $X.getText());}
    | not_expression
    ;

not_expression
    : M=(MINUS | NOT) high_expression {System.out.println("Operator:" + $M.getText());}
    | high_expression
    ;

// high expression
high_expression
    : M=(MINUS | NOT) high_expression {System.out.println("Operator:" + $M.getText());}
    | value
    ;

expression // check precedence
    : function_call_expression (expression | )
    | display_expression (expression | )
    | size_expression (expression | )
    | append_expression (expression | )
    | LPAR expression RPAR
    | expression DOT expression
    | expression LBRACK expression RBRACK
    | comma_expression
    ;

value: INTEGER | BOOL_VALUE | variable;
variable: (IDENTIFIER | method_call) (bracket_indexing | extra_parantheses)*;
extra_parantheses: LPAR parameters RPAR;
method_call: IDENTIFIER LPAR parameters RPAR;
parameters: (expression (COMMA expression)*)?;
bracket_indexing: LBRACK expression RBRACK {System.out.println("Operator:[]";};

// Fptr: UNUSED
fptr_decleration
    : fptr_type IDENTIFIER (ASSIGN expression | ) eol
    ;

fptr_type
    : FPTR LESS_THAN function_type (COMMA function_type)* ARROW function_type GREATER_THAN
    ;

function_type
    : type | VOID
    ;

// Struct:
struct_decleration
    : struct_type ((BEGIN struct_init END) | NEWLINE struct_statement)
    ;

struct_type
    : STRUCT IDENTIFIER
    ;

struct_init
    : struct_statement+
    ;

struct_statement
    : declare_statement | set_get
    ;

set_get
    : type IDENTIFIER arguments BEGIN setter getter END
    ;

setter
    : SET ((NEWLINE statement eol) |( BEGIN (statement eol)+ END))
    ;

getter
    : GET (NEWLINE return_statement | BEGIN statement+ return_statement END)
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
END: 'end' WS* NEWLINE;
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
COMMENT: ('/*' .*? '*/') NEWLINE -> skip;
WS: ([ \t\r]) -> skip;
NEWLINE: '\n'+;
