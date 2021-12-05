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
    {$mainRet.setBody($bd.stmt);};

//todo
structDeclaration returns[StructDeclaration structDeclarationRet] locals [Statement _body]:
    {$structDeclarationRet = new StructDeclaration();}
    s=STRUCT
    {$structDeclarationRet.setLine($s.getLine());}
     i=identifier
    {$structDeclarationRet.setStructName($i.expr);}
    ((b=BEGIN sb=structBody
     {$sb.stmt.setLine($b.getLine());
     $_body = $sb.stmt;
     }
     NEWLINE+ END) | (NEWLINE+ sssb=singleStatementStructBody
     {$_body = $sssb.stmt;}
     SEMICOLON?)) NEWLINE+
     {$structDeclarationRet.setBody($_body);}
     ;

//todo
singleVarWithGetAndSet returns [SetGetVarDeclaration stmt]:
    {$stmt = new SetGetVarDeclaration();}
    t=type i=identifier fad=functionArgsDec
    {$stmt.setVarType($t.tp);
     $stmt.setVarName($i.expr);
     $stmt.setLine($i.expr.getLine());
     $stmt.setArgs($fad.args);
    }
    BEGIN NEWLINE+ sb=setBody
    {$stmt.setSetterBody($sb.stmt);}
    gb=getBody
    {$stmt.setGetterBody($gb.stmt);}
    END;

//todo
singleStatementStructBody returns [Statement stmt]:
    vds=varDecStatement
    {$stmt = $vds.stmt;}
    | sv=singleVarWithGetAndSet
    {$stmt = $sv.stmt;}
    ;

//todo
structBody returns[BlockStmt stmt]:
    {$stmt = new BlockStmt();}
    (NEWLINE+ (sssb=singleStatementStructBody
     {$stmt.addStatement($sssb.stmt);}
     SEMICOLON)* sssb=singleStatementStructBody
     {$stmt.addStatement($sssb.stmt);}
      SEMICOLON?)+;

//todo
getBody returns[Statement stmt]:
    GET bd=body
    {$stmt = $bd.stmt;}
    NEWLINE+;

//todo
setBody returns[Statement stmt]:
    SET bd=body
    {$stmt = $bd.stmt;}
    NEWLINE+;

//todo
functionDeclaration returns[FunctionDeclaration functionDeclarationRet] locals [Type _return]:
    (t=type
    {$_return = $t.tp;}
    | VOID
    {$_return = new VoidType();}
    ) i=identifier
    {$functionDeclarationRet = new FunctionDeclaration();
     $functionDeclarationRet.setLine($i.expr.getLine());
     $functionDeclarationRet.setReturnType($_return);
     $functionDeclarationRet.setFunctionName($i.expr);
    }
    fad=functionArgsDec
    {$functionDeclarationRet.setArgs($fad.args);}
    bd=body
    {$functionDeclarationRet.setBody($bd.stmt);}
    NEWLINE+;

//todo
functionArgsDec returns [ArrayList<VariableDeclaration> args] locals [VariableDeclaration vdec]:
    {$args = new ArrayList<VariableDeclaration>();}
    LPAR (t=type i=identifier
    {$vdec = new VariableDeclaration($i.expr, $t.tp);
     $vdec.setLine($i.expr.getLine());
     $args.add($vdec);}
    (COMMA t=type i=identifier
    {$vdec = new VariableDeclaration($i.expr, $t.tp);
     $vdec.setLine($i.expr.getLine());
     $args.add($vdec);}
    )*)? RPAR ;

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
    {$stmt = new VarDecStmt();}
    t=type i=identifier
    {$stmt.setLine($i.expr.getLine());
     $var = new VariableDeclaration($i.expr, $t.tp);
     $var.setLine($i.expr.getLine());}
    (ASSIGN oe=orExpression
    {$var.setDefaultValue($oe.expr);}
    )?
    {$stmt.addVar($var);}
    (COMMA i=identifier
    {$var = new VariableDeclaration($i.expr, $t.tp);
    $var.setLine($i.expr.getLine());}
    (ASSIGN oe=orExpression
    {$var.setDefaultValue($oe.expr);}
    )?
    {$stmt.addVar($var);}
    )*;

//todo
functionCallStmt returns [FunctionCallStmt stmt] locals [FunctionCall fcall, Expression instance]:
     oe=otherExpression
     {$instance = $oe.expr;}
     ((lp=LPAR fargs=functionArguments
     {$instance = new FunctionCall($instance, $fargs.expr.getInputs());
      $instance.setLine($lp.getLine());
     }
     RPAR) | (d=DOT sacc=identifier
     {$instance = new StructAccess($instance, $sacc.expr);
      $instance.setLine($d.getLine());}
     ))*
     (lp=LPAR fargs=functionArguments RPAR)
     {$fcall = new FunctionCall($instance, $fargs.expr.getInputs());
      $fcall.setLine($lp.getLine());
      $stmt = new FunctionCallStmt($fcall);
      $stmt.setLine($lp.getLine());};

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
    f=IF cond=expression
    {$stmt = new ConditionalStmt($cond.expr);
     $stmt.setLine($f.getLine());}
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
    {$stmt = $ifstmt.stmt;}
    | disstmt=displayStatement
    {$stmt = $disstmt.stmt;}
    | fcstmt=functionCallStmt
    {$stmt = $fcstmt.stmt;}
    | retstmt=returnStatement
    {$stmt = $retstmt.stmt;}
    | asstmt=assignmentStatement
    {$stmt = $asstmt.stmt;}
    | varstmt=varDecStatement
    {$stmt = $varstmt.stmt;}
    | lstmt=loopStatement
    {$stmt = $lstmt.stmt;}
    | appstmt=append
    {$stmt = new ListAppendStmt($appstmt.expr);
     $stmt.setLine($appstmt.expr.getLine());}
    | szstmt=size
    {$stmt = new ListSizeStmt($szstmt.expr);
     $stmt.setLine($szstmt.expr.getLine());}
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
    {$expr = new UnaryExpression($pu.expr, $_op);
     $expr.setLine($op.getLine());}
    )
    | ex=accessExpression
    {$expr = $ex.expr;};

//todo
accessExpression returns [Expression expr]:
    oe=otherExpression
    {$expr = $oe.expr;}
    ((lp=LPAR fargs=functionArguments RPAR)
    {$expr = new FunctionCall($expr, $fargs.expr.getInputs());
    $expr.setLine($lp.getLine());
    }
    | (d=DOT sacc=identifier
    {$expr = new StructAccess($expr, $sacc.expr);
     $expr.setLine($d.getLine());}
    ))*
    ((lb=LBRACK e=expression
     {$expr = new ListAccessByIndex($expr, $e.expr);
      $expr.setLine($lb.getLine());}
     RBRACK) | (d=DOT sacc=identifier
     {$expr = new StructAccess($expr, $sacc.expr);
      $expr.setLine($d.getLine());}
     ))*;

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
    t=TRUE
    {$expr = new BoolValue(true);
     $expr.setLine($t.getLine());}
    | f=FALSE
    {$expr = new BoolValue(false);
     $expr.setLine($f.getLine());}
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
    {$tp = new ListType($t.tp);}
    | STRUCT i=identifier
    {$tp = new StructType($i.expr);}
    | f=fptrType
    {$tp = $f.tp;}
    ;

//todo
fptrType returns [FptrType tp] locals [ArrayList<Type> args, Type _return]:
    FPTR
    {$args = new ArrayList<Type>();}
    LESS_THAN (VOID
    {$args.add(new VoidType());}
    | (t=type
    {$args.add($t.tp);}
    (COMMA t=type
    {$args.add($t.tp);}
    )*)) ARROW (t=type
    {$_return = $t.tp;}
    |
    VOID
    {$_return = new VoidType();}
    ) GREATER_THAN
    {$tp = new FptrType($args, $_return);}
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