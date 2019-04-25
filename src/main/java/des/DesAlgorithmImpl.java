package des;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class DesAlgorithmImpl implements DesAlgorithm {
    public String encrypt(String data) throws NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        return null;
    }

    public String decrypt(String data) {
        return null;
    }
}
