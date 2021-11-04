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
END: 'end' NEWLINE+; // might get ignored
RETURN: 'return ';
NEWLINE: '\n';

IF: 'if';
ELSE: 'else';
WHILE: 'while';
DO: 'do';
GET: 'get';
SET: 'set';

DISPLAY: 'display';
APPEND: 'append';
SIZE: 'size';
FPTR: 'fptr';

TYPE: 'int' | 'bool';
TRUE:'true';
FALSE:'false';
STRUCT: 'struct';
LIST: 'list';
VOID: 'void';

ARROW: '->';

ARITHMETIC_OP: '+' | '_' | '*' | '/'; // Add '-' for negative values
EQ_OP: '==' | '>' | '<';
LOGICAL_OP: '&' | '|' | '~';
ASSIGN_OP: '='; //check Lvalue for left op
// Apply priorities

IDENTIFIER: [a-zA-Z_][A-Za-z0-9_]*; // check if they are not keyword (page 5)

LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';

SHARP: '#';
COMMA: ',';
DOT: '.';
SEMICOLLON: ';';

INT_VALUE: '0' | [1-9][0-9]*;

COMMENT: ('/*' .*? '*/') -> skip;
WS: ([; \t\n\r]) -> skip;
