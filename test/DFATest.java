import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DFATest {
    private DFA dfa0;

    @BeforeMethod
    public void setUp() {
        dfa0 = new DFA("example_machines/dfa0.txt");
    }

    @Test
    public void testRunAcceptDFA0() {
        Assert.assertTrue(dfa0.run("abab"));
        Assert.assertTrue(dfa0.run("ababaaaabbbb"));
    }

    @Test
    public void testRunAcceptEmptyDFA0() {
        Assert.assertTrue(dfa0.run(""));
    }

    @Test
    public void testRunRejectDFA0() {
        Assert.assertFalse(dfa0.run("a"));
        Assert.assertFalse(dfa0.run("ab"));
        Assert.assertFalse(dfa0.run("abb"));
        Assert.assertFalse(dfa0.run("abbbb"));
    }

    // Add more as needed

    @AfterMethod
    public void tearDown() {
        dfa0 = null;
    }
}