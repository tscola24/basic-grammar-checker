package proj5;
/**
 * GrammarChecker Test Class
 *
 * Author: Theo Scola
 * Ver: 6/5/25
 * Note: For the improveGrammar tests,
 * I just print them to check the output rather than try to use an assert function
 */

import org.junit.*;
import org.junit.After;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

public class GrammarCheckerTests {
    GrammarChecker GC;

    @Rule
    public Timeout timeout = Timeout.millis(1000);

    @After
    public void tearDown()
    {
        GC = null;
    }

    @Test
    public void testConstruct()
    {
        GC = new GrammarChecker("src/smallThesaurus.txt", 3);
        assertNotNull("testing constructor constructs", GC);
    }

    @Test
    public void testImproveGrammar0()
    {
        GC = new GrammarChecker("src/smallThesaurus.txt", 3);
        GC.improveGrammar("src/apartment.txt");
    }

    @Test
    public void testImproveGrammar1()
    {
        GC = new GrammarChecker("src/bigThesaurus.txt", 3);
        GC.improveGrammar("src/apartment.txt");
    }

    @Test
    public void testImproveGrammar2()
    {
        GC = new GrammarChecker("src/bigThesaurus.txt", 3);
        GC.improveGrammar("src/lamb.txt");
    }
}
