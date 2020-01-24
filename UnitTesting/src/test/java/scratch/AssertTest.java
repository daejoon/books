package scratch;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class AssertTest {

    private Account account;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void createAccount() {
        account = new Account("an account name");
    }

    @Test
    public void hasPositiveBalance() {

        // when
        account.deposit(50);

        // then
        assertTrue(account.hasPositiveBalance());
    }

    @Test
    public void depositIncreasesBalance() {
        // given
        int initialBalance = account.getBalance();

        // when
        account.deposit(100);

        // then
        assertThat(account.getBalance(), equalTo(100));
        assertThat(account.getBalance() > 0, is(true));
    }

    @Test
    public void getAccountName() {
        account.setName("xyz1234");

        assertThat(account.getName(), startsWith("xyz"));
    }

    @Test
    public void assertThatTest() {

        assertThat(new String[]{"a", "b"}, equalTo(new String[]{"a", "b"}));
        assertThat(Arrays.asList(new String[]{"a"}), equalTo(Arrays.asList(new String[]{"a"})));

        Account account1 = new Account("my big fat acct");
        assertThat(account1.getName(), is(equalTo("my big fat acct")));
        assertThat(account1.getName(), not(equalTo("plunderings")));
        assertThat(account1.getName(), is(not(nullValue())));
        assertThat(account1.getName(), is(notNullValue()));
    }

    @Test
    public void testWithWorthlessAssertionComment() {
        account.deposit(50);
        assertThat("account balance is 100", account.getBalance(), equalTo(50));
    }

    @Test(expected = InsufficientFundsException.class)
    public void throwsWhenWithdrawingTooMuch() {
        account.withdraw(100);
    }

    @Test
    public void throwsWhenWithdrawingTooMuchWithTryCatch() {

        try {
            account.withdraw(100);
            fail();
        } catch (InsufficientFundsException expected) {
            assertThat(expected.getMessage(), equalTo("balance only 0"));
        }
    }

    @Test
    public void throwsWhenWithdrawingTooMuchWithRule() {
        thrown.expect(InsufficientFundsException.class);
        thrown.expectMessage("balance only 0");

        account.withdraw(100);
    }
}
