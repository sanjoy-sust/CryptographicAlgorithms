package des;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public interface DesAlgorithm {
    String encrypt(String data) throws NoSuchPaddingException, NoSuchAlgorithmException;
    String decrypt(String data);
}
