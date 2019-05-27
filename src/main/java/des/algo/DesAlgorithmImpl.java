package des.algo;

import des.constants.DesConstants;
import javafx.scene.chart.PieChart;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

public class DesAlgorithmImpl implements DesAlgorithm {

    public String encrypt(String data, SecretKey key, String algo) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        return cryptoData(algo, key, Cipher.ENCRYPT_MODE, data.getBytes());
    }

    public String decrypt(String data, SecretKey key, String algo) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        return cryptoData(algo, key, Cipher.DECRYPT_MODE, DatatypeConverter.parseHexBinary(data));
    }

    public String encrypt(String data, byte[] sKey, String algo) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        SecretKey key = new SecretKeySpec(sKey, algo);
        return cryptoData(algo, key, Cipher.ENCRYPT_MODE, data.getBytes());
    }

    public String decrypt(String data, byte[] sKey, String algo) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        SecretKey key = new SecretKeySpec(sKey, algo);
        return cryptoData(algo, key, Cipher.DECRYPT_MODE, DatatypeConverter.parseHexBinary(data));
    }

    private String cryptoData(String algo, SecretKey key, int encryptMode, byte[] bytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(algo);
        System.out.println("Key supplied : "+ DatatypeConverter.printHexBinary(key.getEncoded()));
        if (algo.contains("ECB")) {
            cipher.init(encryptMode, key);
        } else {
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(DesConstants.iv);
            cipher.init(encryptMode, key, paramSpec);
        }
        byte[] encryptedResult = cipher.doFinal(bytes);
        return DatatypeConverter.printHexBinary(encryptedResult);
    }


}
