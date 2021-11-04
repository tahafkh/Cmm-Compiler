grammar Cmm;

//Rules
main
    : 'main' LPAR RPAR //func_body //body is like function body
    ;

function
    : RETURN_TYPE IDENTIFIER LPAR //arguments func_body
    ;

func_body
    : BEGIN long_body END
    | short_body
    ;

long_body
    : short_body short_body+
    ;

short_body
    : expression '\n'
    ;

expression
    : IDENTIFIER


test
    : 'a' BEGIN END
    ;


//Tokens
BEGIN: 'begin' '\n';
END: 'end'; // might get ignored
RETURN: 'return';

ARITHMETIC_OP: '+' | '_' | '*' | '/'; // Add '-' for negative values
EQ_OP: '==' | '>' | '<';
LOGICAL_OP: '&' | '|' | '~';
ASSIGN_OP: '='; //check Lvalue for left op
// Apply priorities

IDENTIFIER: [a-zA-Z_][A-Za-z0-9_]*; // check if they are not keyword (page 5)

LPAR: '(';
RPAR: ')';

INT_VALUE: '0' | [1-9][0-9]*;

COMMENT: ('/*' .*? '*/') -> skip;
WS: ([; \t\n\r]) -> skip;

