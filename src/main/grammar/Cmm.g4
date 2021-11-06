grammar Cmm;

//Rules
//TODO
// Check new line at the beginning of file
// main
// function
// while do while
// if else
// fptr
// expression
// operator precedence
// function input handling

main
    : MAIN LPAR RPAR func_body //body is like function body
    ;

function
    : TYPE IDENTIFIER arguments func_body //Fix return type and check it with void
    ;

//return_type
//    : TYPE | VOID |

arguments
    : LPAR type IDENTIFIER (COMMA type IDENTIFIER)* RPAR
    ;

func_body
    : BEGIN long_body END
    | NEWLINE+ short_body
    ;

long_body
    : short_body short_body*
    ;

short_body
    : expression NEWLINE+
    ;

expression
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
    ;


value: INTEGER | BOOL_VALUE | variable;
variable: (IDENTIFIER | list_refrence | method_call) (dot_refrence | bracket_indexing | extra_parantheses)*;
extra_parantheses: LPAR parameters RPAR;
list_refrence: IDENTIFIER bracket_indexing;
method_call: IDENTIFIER LPAR parameters RPAR;
parameters: (expression (COMMA expression)*)?;
dot_refrence: DOT (IDENTIFIER | list_refrence) {System.out.println("Operator:.";};
bracket_indexing: LBRACK expression RBRACK {System.out.println("Operator:[]";};

//__________________________________________________________________________________________________________

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
    : SET ((NEWLINE expression ( | SEMICOLON) NEWLINE) |( BEGIN (expression ( | SEMICOLON) NEWLINE)+ END))
    ;

getter
    : GET (NEWLINE expression | BEGIN expression+ END)
    ;

list_decleration
    : LIST SHARP type IDENTIFIER
    ;

list_type // Can't be initialized
    : LIST SHARP type
    ;

type
    : initable_type | non_initable_type
    ;

initable_type
    : PRIMITIVE_TYPE // | fptr
    ;

non_initable_type
    : list_type | struct_type
    ;

declare_statement
    : ((type IDENTIFIER ( | SEMICOLON )) | (initable_type IDENTIFIER ASSIGN expression))
    NEWLINE
    ;


//Tokens
MAIN: 'main';
BEGIN: 'begin' NEWLINE;
END: 'end' NEWLINE;
RETURN: 'return ';

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
//LITERALS: INTEGER | BOOL_VALUE;

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
COMMENT: ('/*' .*? '*/') -> skip;
WS: ([ \t\r]) -> skip;
NEWLINE: '\n'+;
