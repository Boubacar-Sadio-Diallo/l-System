package tests;

import models.system.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void isValid() {
        Parser parser=new Parser("TEST","90","10","1","F=FF");
        assertTrue(parser.isValid());
        parser.chaine="#Klç";
        assertFalse(parser.isValid());
        parser=new Parser("TEST","90","10","1","");
        assertTrue(parser.isValid());
    }

    @Test
    void islexical() {
        Parser parser=new Parser("è#","90","10","1","F=FF");
        assertFalse(parser.islexical());
        parser.chaine="|--+&Ffanj<>^";
        assertTrue(parser.islexical());

    }

    @Test
    void isSyntaxic() {
        Parser parser=new Parser("F[FF]","90","10","1","F=FF");
        assertTrue(parser.isSyntaxic());
        parser.chaine="][";
        assertFalse(parser.isSyntaxic());
        parser.chaine="[F]";
        assertTrue(parser.isSyntaxic());
        parser.chaine="]]][[F[";
        assertFalse(parser.isSyntaxic());
        parser.chaine="F][";
        assertFalse(parser.isSyntaxic());
        parser.chaine="[[[[F]]]]";
        assertTrue(parser.isSyntaxic());
    }

    @Test
    void isAngleCorrect() {
        Parser parser=new Parser("TEST","90","10","1","F=FF");
        assertTrue(parser.isAngleCorrect());
        parser=new Parser("TEST","-90","10","1","F=FF");
        assertTrue(parser.isAngleCorrect());
        parser=new Parser("TEST","non","10","1","F=FF");
        assertFalse(parser.isAngleCorrect());
    }

    @Test
    void isANumberValid() {
        Parser parser=new Parser("TEST","90","10","1","F=FF");
        assertTrue(parser.isANumberValid("10"));
        assertTrue(parser.isANumberValid("1"));
        assertFalse(parser.isANumberValid("1.4"));
        assertFalse(parser.isANumberValid("-10"));
        assertFalse(parser.isANumberValid("rien"));
    }


    @Test
    void isRulesValid() {
        Parser parser=new Parser("TEST","90","10","1","F=FF");
        assertTrue(parser.isRulesValid());
        parser=new Parser("TEST","90","10","1","F=FF\nA=AB\n-=-+");
        assertTrue(parser.isRulesValid());
        parser=new Parser("TEST","90","10","1","F= FF\nA=AB\n-=-+");
        assertFalse(parser.isRulesValid());
        parser=new Parser("TEST","90","10","1","F->FF\nA=AB\n-=-+");
        assertFalse(parser.isRulesValid());
        parser=new Parser("TEST","90","10","1","");
        assertTrue(parser.isRulesValid());

    }
}