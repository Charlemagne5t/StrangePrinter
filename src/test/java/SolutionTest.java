import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void strangePrinterTest1() {
        String s = "aaabbb";
        int expected = 2;
        int actual = new Solution().strangePrinter(s);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void strangePrinterTest2() {
        String s = "aba";
        int expected = 2;
        int actual = new Solution().strangePrinter(s);

        Assert.assertEquals(expected, actual);
    }
}
