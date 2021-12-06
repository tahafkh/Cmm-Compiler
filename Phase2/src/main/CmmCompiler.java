package main;

import main.visitor.name.*;
import parsers.*;
import main.ast.nodes.Program;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class CmmCompiler {
    public void compile(CharStream textStream) {
        CmmLexer cmmLexer = new CmmLexer(textStream);
        CommonTokenStream tokenStream = new CommonTokenStream(cmmLexer);
        CmmParser cmmParser = new CmmParser(tokenStream);

        Program program = cmmParser.cmm().cmmProgram;

        NameAnalyzer nameAnalyser = new NameAnalyzer();
        nameAnalyser.visit(program);

        ASTTreePrinter astTreePrinter = new ASTTreePrinter();
        if (!nameAnalyser.hasError())
            astTreePrinter.visit(program);
    }
}
