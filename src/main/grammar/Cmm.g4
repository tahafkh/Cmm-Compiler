grammar Cmm;

//Rules
//TODO
// Check new line at the beginning of file 100/100?
// function 100/100?
// function input handling
// pre-defined functions 33/100
// 2 bugs: 1.  append(li, 8 * 9 / func())[1][0]; 2. expression precedence

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

expression // check precedence
    : LPAR expression RPAR {System.out.println("Operator:()";}
    | M=(MINUS | NOT) expression {System.out.println("Operator:" + $M.getText());}
    | expression X=(DIV | MULT) expression {System.out.println("Operator:" + $X.getText());}
    | expression Y=(PLUS | MINUS) expression {System.out.println("Operator:" + $Y.getText());}
    | expression Z=(GREATER_THAN | LESS_THAN) expression {System.out.println("Operator:" + $Z.getText());}
    | expression EQUAL expression {System.out.println("Operator:==";}
    | expression AND expression {System.out.println("Operator:&");}
    | expression OR expression {System.out.println("Operator:|");}
    | expression ASSIGN expression {System.out.println("Operator:=");}
    | expression COMMA expression {System.out.println("Operator:,");}
    | value
    | function_call_expression
    | display_expression
    | size_expression
    | append_expression
    ;

//  append(li, 8 * 9 / func())[1][0]
value: INTEGER | BOOL_VALUE | variable;
variable: (IDENTIFIER | list_refrence | method_call) (dot_refrence | bracket_indexing | extra_parantheses)*;
extra_parantheses: LPAR parameters RPAR;
list_refrence: IDENTIFIER bracket_indexing;
method_call: IDENTIFIER LPAR parameters RPAR;
parameters: (expression (COMMA expression)*)?;
dot_refrence: DOT (IDENTIFIER | list_refrence) {System.out.println("Operator:.";};
bracket_indexing: LBRACK expression RBRACK {System.out.println("Operator:[]";};

// Fptr:
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
    : struct_type BEGIN struct_init END
    ;

struct_type
    : STRUCT IDENTIFIER
    ;

struct_init
    : (declare_statement | set_get)+
    ;

set_get
    : type IDENTIFIER arguments BEGIN setter getter END
    ;

setter
    : SET ((NEWLINE expression eol) |( BEGIN (expression eol)+ END))
    ;

getter
    : GET (NEWLINE return_statement | BEGIN expression+ return_statement END)
    ;


// List:
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
