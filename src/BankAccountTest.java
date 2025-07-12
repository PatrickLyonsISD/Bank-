import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BankAccountTest {
    @Test
    void testTransferToSuccess(){
        BankAccount a = new BankAccount(1,"Alice", 500);
        BankAccount b = new BankAccount(2,"Bob", 100);

        a.transferTo(b, 200);

        assertEquals(300, a.getBalance());

        assertEquals(300, b.getBalance());

    }
}
