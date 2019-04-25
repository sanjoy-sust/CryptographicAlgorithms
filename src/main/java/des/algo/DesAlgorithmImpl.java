package des.algo;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class DesAlgorithmImpl implements DesAlgorithm {
    public String encrypt(String data, SecretKey key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] encryptedResult = cipher.doFinal(data.getBytes());
        return DatatypeConverter.printHexBinary(encryptedResult);
    }

    public String decrypt(String data, SecretKey key) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] decryptedResult = cipher.doFinal(DatatypeConverter.parseHexBinary(data));
        return DatatypeConverter.printHexBinary(decryptedResult);
    }
}
