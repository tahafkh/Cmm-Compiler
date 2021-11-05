grammar Cmm;

//Rules
main
    : MAIN LPAR RPAR func_body //body is like function body
    ;

function
    : TYPE IDENTIFIER LPAR arguments RPAR func_body //Fix return type and check it with void
    ;

//return_type
//    : TYPE | VOID |

arguments
    : (TYPE|STRUCT|LIST) IDENTIFIER (COMMA (TYPE|STRUCT|LIST) IDENTIFIER)* // enable chaining
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
    IDENTIFIER ASSIGN_OP INT_VALUE ARITHMETIC_OP INT_VALUE
    ;

//Tokens
MAIN: 'main';
BEGIN: 'begin' NEWLINE+;
END: 'end' NEWLINE+;
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
LITERALS: INTEGER | BOOL_VALUE;

// Operations
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
IDENTIFIER: (LETTER | UNDERSCORE) (LETTER | UNDERSCORE | DIGIT);

// Helper
DIGIT: [0-9];
NONZERODIGIT: [1-9];
LETTER: [a-zA-Z];
UNDERSCORE: '_';

// Whitespace and comment
COMMENT: ('/*' .*? '*/') -> skip;
WS: ([ \t\r]) -> skip;
NEWLINE: '\n';
