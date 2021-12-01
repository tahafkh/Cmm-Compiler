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

//todo R
structDeclaration returns[StructDeclaration structDeclarationRet]:
    STRUCT identifier ((BEGIN structBody NEWLINE+ END) | (NEWLINE+ singleStatementStructBody SEMICOLON?)) NEWLINE+;

//todo R
singleVarWithGetAndSet :
    type identifier functionArgsDec BEGIN NEWLINE+ setBody getBody END;

//todo R
singleStatementStructBody :
    varDecStatement | singleVarWithGetAndSet;

//todo R
structBody :
    (NEWLINE+ (singleStatementStructBody SEMICOLON)* singleStatementStructBody SEMICOLON?)+;

//todo R
getBody :
    GET body NEWLINE+;

//todo R
setBody :
    SET body NEWLINE+;

//todo R
functionDeclaration returns[FunctionDeclaration functionDeclarationRet]:
    (type | VOID ) identifier functionArgsDec body NEWLINE+;

//todo R
functionArgsDec :
    LPAR (type identifier (COMMA type identifier)*)? RPAR ;

//todo
functionArguments returns [ExprInPar expr] locals [ArrayList<Expression> inputs]:
    {$inputs = new ArrayList<Expression>();}
    (ex1=expression
    {$inputs.add($ex1.expr);}
    (COMMA ex2=expression
    {$inputs.add($ex2.expr);}
    )*)?
    {$expr = new ExprInPar($inputs);};

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
varDecStatement returns [VarDecStmt stmt] locals [VariableDeclaration var]:
    {$stmt = new varDecStatement();}
    t=type i=identifier
    {$stmt.setLine($i.expr.getLine());
     $var = new VariableDeclaration($i.expr, $t.tp);}
    (ASSIGN oe=orExpression
    {$var.setDefaultValue($oe.expr);}
    )?
    {$stmt.addVar($var);}
    (COMMA i=identifier
    {$var = new VariableDeclaration($i.expr, $t.tp);}
    (ASSIGN oe=orExpression
    {$var.setDefaultValue($oe.expr);}
    )?
    {$stmt.addVar($var);}
    )*;

//todo
functionCallStmt returns [FunctionCallStmt stmt] locals [FunctionCall fcall, Expression instance]:
     oe=otherExpression
     {$instance = $oe.expr;}
     ((LPAR fargs=functionArguments
     {$instance = new FunctionCall($instance, $fargs.expr);}
     RPAR) | (DOT sacc=identifier
     {$instance = new StructAccess($instance, $sacc.expr);}
     ))*
     (lp=LPAR fargs=functionArguments RPAR)
     {$stmt = new FunctionCallStmt($instance, $fargs.expr);
      $stmt.setLine($lp.getLine())};

//todo
returnStatement returns [ReturnStmt stmt]:
    {$stmt = new ReturnStmt();}
    ret = RETURN
    {$stmt.setLine($ret.getLine());}
    (ex=expression
    {$stmt.setReturnedExpr($ex.expr);}
    )?;

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
loopStatement returns [LoopStmt stmt]:
    wl=whileLoopStatement
    {$stmt = $wl.stmt;}
    | dl=doWhileLoopStatement
    {$stmt = $dl.stmt;}
    ;

//todo
whileLoopStatement returns [LoopStmt stmt]:
    w=WHILE cond=expression bod=loopCondBody
    {$stmt = new LoopStmt();
     $stmt.setLine($w.getLine());
     $stmt.setCondition($cond.expr);
     $stmt.setBody($bod.stmt);
     };

//todo
doWhileLoopStatement returns [LoopStmt stmt]:
    d=DO bod=body NEWLINE* WHILE cond=expression
    {$stmt = new LoopStmt();
     $stmt.setLine($d.getLine());
     $stmt.setCondition($cond.expr);
     $stmt.setBody($bod.stmt);
     };

//todo
displayStatement returns [DisplayStmt stmt]:
  disp=DISPLAY LPAR arg=expression RPAR
  {$stmt = new DisplayStmt($arg.expr);
   $stmt.setLine($disp.getLine());};

//todo
assignmentStatement returns [AssignmentStmt stmt]:
    lval=orExpression ass=ASSIGN rval=expression
    {$stmt = new AssignmentStmt($lval.expr, $rval.expr);
     $stmt.setLine($ass.getLine());};

//todo
singleStatement returns [Statement stmt] :
    ifstmt=ifStatement
    {$stmt = $ifstmt.stmt}
    | disstmt=displayStatement
    {$stmt = $disstmt.stmt}
    | fcstmt=functionCallStmt
    {$stmt = $fcstmt.stmt}
    | retstmt=returnStatement
    {$stmt = $retstmt.stmt}
    | asstmt=assignmentStatement
    {$stmt = $asstmt.stmt}
    | varstmt=varDecStatement
    {$stmt = $varstmt.stmt}
    | lstmt=loopStatement
    {$stmt = $lstmt.stmt}
    | appstmt=append
    {$stmt = new ListAppendStmt($appstmt.expr);}
    | szstmt=size
    {$stmt = new ListSizeStmt($szstmt.expr);}
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
    {$_op = UnaryOperator.not;}
    | op = MINUS
    {$_op = UnaryOperator.minus;}
    )
    pu=preUnaryExpression
    {$expr = new UnaryExpression($pu.expr, _op);
     $expr.setLine($op.getLine());}
    )
    | ex=accessExpression
    {$expr = $ex.expr;};

//todo R
accessExpression returns [Expression expr]:
    oe=otherExpression
    {$expr = $oe.expr;}
    ((LPAR f=functionArguments RPAR)
    | (DOT identifier))*  ((LBRACK expression RBRACK) | (DOT identifier))*;

//todo
otherExpression returns [Expression expr]:
    v=value
    {$expr = $v.expr;}
    | i=identifier
    {$expr = $i.expr;}
    | lp=LPAR (f=functionArguments) RPAR
    {$expr = $f.expr;
     $expr.setLine($lp.getLine());}
    | s=size
    {$expr = $s.expr;}
    | a=append
    {$expr = $a.expr;}
    ;

//todo
size returns [ListSize expr]:
    s=SIZE
    LPAR arg=expression RPAR
    {$expr = new ListSize($arg.expr);
     $expr.setLine($s.getLine());}
     ;

//todo
append returns [ListAppend expr]:
    a=APPEND
    LPAR liarg=expression COMMA elarg=expression RPAR
    {$expr = new ListAppend($liarg.expr, $elarg.expr);
     $expr.setLine($a.getLine());}
     ;

//todo
value returns [Value expr]:
    bv=boolValue
    {$expr = $bv.expr;}
    | i=INT_VALUE
    {$expr = new IntValue($i.int);
     $expr.setLine($i.getLine());}
    ;

//todo
boolValue returns [BoolValue expr]:
    a=TRUE | a=FALSE
    {$expr = new BoolValue($a);
     $expr.setLine($a.getLine());}
    ;

//todo
identifier returns [Identifier expr]:
    i=IDENTIFIER
    {$expr = new Identifier($i.text);
     $expr.setLine($i.getLine());
    }
    ;

//todo
type returns [Type tp]:
    INT
    {$tp = new IntType();}
    | BOOL
    {$tp = new BoolType();}
    | LIST SHARP t=type
    {$tp = ListType($t.tp);}
    | STRUCT i=identifier
    {$tp = StructType($i.expr);}
    | f=fptrType
    {$tp = $f.tp;}
    ;

//todo
fptrType returns [FptrType tp] locals [ArrayList<Type> args, Type return]:
    FPTR
    {$args = new ArrayList<Type>;}
    LESS_THAN (VOID
    {$args.add(new VoidType());}
    | (t=type
    {$args.add($t.tp);}
    (COMMA t=type
    {$args.add($t.tp);}
    )*)) ARROW (t=type
    {$return = $t.tp;}
    |
    VOID
    {$return = new VoidType();}
    ) GREATER_THAN
    {$tp = new FptrType($args, $return);}
    ;

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