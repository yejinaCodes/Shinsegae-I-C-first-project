package common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import security.Encrypt;

class EncryptTest {

    @Test
    @DisplayName("암호화")
    public void getEncrypt() {
        Encrypt encrypt = new Encrypt();
        String password = "testPwd12$";
        String encryptedPassword = encrypt.getEncrypt(password);

        System.out.println("Original Password : " + password);
        System.out.println("Encrypted Password: " + encryptedPassword);

        assertNotNull(encryptedPassword);
        assertEquals(64, encryptedPassword.length());
        assertTrue(encryptedPassword.matches("^[a-fA-F0-9]+$"));
    }
}