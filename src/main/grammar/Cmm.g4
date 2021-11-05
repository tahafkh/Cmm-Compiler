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
    :( | TYPE)
    IDENTIFIER ASSIGN INTEGER PLUS INTEGER
    ;

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
    : arguments BEGIN setter getter END
    ;

setter
    : SET (NEWLINE expression | BEGIN expression+ END)
    ;

getter
    : GET (NEWLINE expression | BEGIN expression+ END)
    ;

list_decleration
    : LIST SHARP type IDENTIFIER
    ;

list_type //Can't be initialized
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
