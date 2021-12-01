grammar Cmm;

@header{
     import main.ast.nodes.*;
     import main.ast.nodes.declaration.*;
     import main.ast.nodes.declaration.struct.*;
     import main.ast.nodes.expression.*;
     import main.ast.nodes.expression.operators.*;
     import main.ast.nodes.expression.values.*;
     import main.ast.nodes.expression.values.primitive.*;
     import main.ast.nodes.statement.*;
     import main.ast.types.*;
     import main.ast.types.primitives.*;
     import java.util.*;
 }

cmm returns[Program cmmProgram]:
    NEWLINE* p = program {$cmmProgram = $p.programRet;} NEWLINE* EOF;

program returns[Program programRet]:
    {$programRet = new Program();
     int line = 1;
     $programRet.setLine(line);}
    (s = structDeclaration {$programRet.addStruct($s.structDeclarationRet);})*
    (f = functionDeclaration {$programRet.addFunction($f.functionDeclarationRet);})*
    m = main {$programRet.setMain($m.mainRet);};

//todo
main returns[MainDeclaration mainRet]:
    {$mainRet = new MainDeclaration();}
    m=MAIN
    {$mainRet.setLine($m.getLine());}
    LPAR RPAR bd=body
    {$mainRet.setBody($bd.stmt)};

//todo
structDeclaration returns[StructDeclaration structDeclarationRet]:
    STRUCT identifier ((BEGIN structBody NEWLINE+ END) | (NEWLINE+ singleStatementStructBody SEMICOLON?)) NEWLINE+;

//todo
singleVarWithGetAndSet :
    type identifier functionArgsDec BEGIN NEWLINE+ setBody getBody END;

//todo
singleStatementStructBody :
    varDecStatement | singleVarWithGetAndSet;

//todo
structBody :
    (NEWLINE+ (singleStatementStructBody SEMICOLON)* singleStatementStructBody SEMICOLON?)+;

//todo
getBody :
    GET body NEWLINE+;

//todo
setBody :
    SET body NEWLINE+;

//todo
functionDeclaration returns[FunctionDeclaration functionDeclarationRet]:
    (type | VOID ) identifier functionArgsDec body NEWLINE+;

//todo
functionArgsDec :
    LPAR (type identifier (COMMA type identifier)*)? RPAR ;

//todo
functionArguments :
    (expression (COMMA expression)*)?;

//todo
body returns [Statement stmt]:
     (
     bs=blockStatement
     {$stmt = $bs.stmt;}
     | (NEWLINE+ ss=singleStatement
     {$stmt = $ss.stmt;}
     (SEMICOLON)?)
     );

//todo
loopCondBody returns [Statement stmt]:
     (bs=blockStatement
     {$stmt = $bs.stmt;}
     | (NEWLINE+ ss=singleStatement
     {$stmt = $ss.stmt;}
     ));

//todo
blockStatement returns [BlockStmt stmt]:
    {$stmt = new BlockStmt();}
    bg=BEGIN
    {$stmt.setLine($bg.getLine());}
    (NEWLINE+ (st1=singleStatement
    {$stmt.addStatement($st1.stmt);}
    SEMICOLON)* st2=singleStatement
    {$stmt.addStatement($st2.stmt);}
    (SEMICOLON)?)+ NEWLINE+ END;

//todo
varDecStatement :
    type identifier (ASSIGN orExpression )? (COMMA identifier (ASSIGN orExpression)? )*;

//todo
functionCallStmt :
     otherExpression ((LPAR functionArguments RPAR) | (DOT identifier))* (LPAR functionArguments RPAR);

//todo
returnStatement :
    RETURN (expression)?;

//todo
ifStatement returns [ConditionalStmt stmt]:
    if=IF cond=expression
    {$stmt = new ConditionalStmt($cond.expr);
     $stmt.setLine($if.getLine());}
    (lpb=loopCondBody
    {$stmt.setThenBody($lpb.stmt);}
    | bd=body
    {$stmt.setThenBody($bd.stmt);}
    elstmt=elseStatement
    {$stmt.setElseBody($elstmt.stmt);}
    );

//todo
elseStatement returns [Statement stmt]:
     NEWLINE* ELSE lpb=loopCondBody
     {$stmt = $lpb.stmt;};

//todo
loopStatement :
    whileLoopStatement | doWhileLoopStatement;

//todo
whileLoopStatement :
    WHILE expression loopCondBody;

//todo
doWhileLoopStatement :
    DO body NEWLINE* WHILE expression;

//todo
displayStatement returns [DisplayStmt stmt]:
  disp=DISPLAY
  {$stmt = new DisplayStmt();}
  LPAR expression RPAR;

//todo
assignmentStatement :
    orExpression ASSIGN expression;

//todo
singleStatement returns [Statement stmt] :
    ifstmt=ifStatement
    {$stmt = $ifstmt.stmt}
    | disstmt=displayStatement
    {$stmt = $disstmt.stmt}
    | fcstmt=functionCallStmt
//    {$stmt = $fcstmt.stmt}
    | retstmt=returnStatement
//    {$stmt = $retstmt.stmt}
    | asstmt=assignmentStatement
//    {$stmt = $asstmt.stmt}
    | varstmt=varDecStatement
//    {$stmt = $varstmt.stmt}
    | lstmt=loopStatement
//    {$stmt = $lstmt.stmt}
    | appstmt=append
//    {$stmt = $appstmt.stmt}
    | szstmt=size
//    {$stmt = $szstmt.stmt}
    ;

//todo
expression returns [Expression expr]:
    oe=orExpression
    {$expr = $oe.expr;}
    (op = ASSIGN ex=expression
    {$expr = new BinaryExpression($expr, $ex.expr, BinaryOperator.assign);
     $expr.setLine($op.getLine());}
    )? ;

//todo
orExpression returns [Expression expr]:
    an=andExpression
    {$expr = $an.expr;}
    (op = OR ex=andExpression
    {$expr = new BinaryExpression($expr, $ex.expr, BinaryOperator.or);
     $expr.setLine($op.getLine());}
    )*;

//todo
andExpression returns [Expression expr]:
    eq=equalityExpression
    {$expr = $eq.expr;}
    (op = AND ex=equalityExpression
    {$expr = new BinaryExpression($expr, $ex.expr, BinaryOperator.and);
         $expr.setLine($op.getLine());}
    )*;

//todo
equalityExpression returns [Expression expr]:
    re=relationalExpression
    {$expr = $re.expr;}
    (op = EQUAL ex=relationalExpression
    {$expr = new BinaryExpression($expr, $ex.expr, BinaryOperator.eq);
     $expr.setLine($op.getLine());}
    )*;

//todo
relationalExpression returns [Expression expr] locals [BinaryOperator _op]:
    ad=additiveExpression
    {$expr = $ad.expr;}
    ((op = GREATER_THAN
    {$_op = BinaryOperator.gt;}
    | op = LESS_THAN
    {$_op = BinaryOperator.lt;})
    ex=additiveExpression
    {$expr = new BinaryExpression($expr, $ex.expr, $_op);
     $expr.setLine($op.getLine());}
    )*;

//todo
additiveExpression returns [Expression expr] locals [BinaryOperator _op]:
    ml=multiplicativeExpression
    {$expr = $ml.expr;}
    ((op = PLUS
    {$_op = BinaryOperator.add;}
    | op = MINUS
    {$_op = BinaryOperator.sub;})
    ex=multiplicativeExpression
    {$expr = new BinaryExpression($expr, $ex.expr, $_op);
     $expr.setLine($op.getLine());}
    )*;

//todo
multiplicativeExpression returns [Expression expr] locals [BinaryOperator _op]:
    pu=preUnaryExpression
    {$expr = $pu.expr;}
    ((op = MULT
    {$_op = BinaryOperator.mult;}
    | op = DIVIDE
    {$_op = BinaryOperator.div;}
    )
    ex=preUnaryExpression
    {$expr = new BinaryExpression($expr, $ex.expr, $_op);
     $expr.setLine($op.getLine());}
    )*;

//todo
preUnaryExpression returns [Expression expr] locals [UnaryOperator _op]:
    ((op = NOT
    {$_op = UnaryOperator.not}
    | op = MINUS
    {$_op = UnaryOperator.minus}
    )
    pu=preUnaryExpression
    {$expr = new UnaryExpression($pu.expr, _op);
     $expr.setLine($op.getLine());}
    )
    | ex=accessExpression
    {$expr = $ex.expr;};

//todo
accessExpression:
    otherExpression ((LPAR functionArguments RPAR) | (DOT identifier))*  ((LBRACK expression RBRACK) | (DOT identifier))*;

//todo
otherExpression:
    value | identifier | LPAR (functionArguments) RPAR | size | append ;

//todo
size :
    SIZE LPAR expression RPAR;

//todo
append :
    APPEND LPAR expression COMMA expression RPAR;

//todo
value :
    boolValue | INT_VALUE;

//todo
boolValue:
    TRUE | FALSE;

//todo
identifier:
    IDENTIFIER;

//todo
type:
    INT | BOOL | LIST SHARP type | STRUCT identifier | fptrType;

//todo
fptrType:
    FPTR LESS_THAN (VOID | (type (COMMA type)*)) ARROW (type | VOID) GREATER_THAN;

MAIN: 'main';
RETURN: 'return';
VOID: 'void';

SIZE: 'size';
DISPLAY: 'display';
APPEND: 'append';

IF: 'if';
ELSE: 'else';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIVIDE: '/';


EQUAL: '==';
ARROW: '->';
GREATER_THAN: '>';
LESS_THAN: '<';


AND: '&';
OR: '|';
NOT: '~';

TRUE: 'true';
FALSE: 'false';

BEGIN: 'begin';
END: 'end';

INT: 'int';
BOOL: 'bool';
LIST: 'list';
STRUCT: 'struct';
FPTR: 'fptr';
GET: 'get';
SET: 'set';
WHILE: 'while';
DO: 'do';

ASSIGN: '=';
SHARP: '#';
LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';

COMMA: ',';
DOT: '.';
SEMICOLON: ';';
NEWLINE: '\n';

INT_VALUE: '0' | [1-9][0-9]*;
IDENTIFIER: [a-zA-Z_][A-Za-z0-9_]*;


COMMENT: ('/*' .*? '*/') -> skip;
WS: ([ \t\r]) -> skip;