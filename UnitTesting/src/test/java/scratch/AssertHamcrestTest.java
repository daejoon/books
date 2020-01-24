package scratch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssertHamcrestTest {

    @Test
    public void 부동소수_assertThat() {

        assertEquals(2.32 * 3, 6.96, 0.00005);
    }
}
