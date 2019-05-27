package des.algo;

import des.constants.DesConstants;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

public class DesAlgorithmImpl implements DesAlgorithm {

    public String encrypt(String data, SecretKey key,String algo) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(algo);
        if(algo.contains("ECB")){
            cipher.init(Cipher.ENCRYPT_MODE,key);
        }else{
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(DesConstants.iv);
            cipher.init(Cipher.ENCRYPT_MODE,key,paramSpec);
        }
        byte[] encryptedResult = cipher.doFinal(data.getBytes());
        return DatatypeConverter.printHexBinary(encryptedResult);
    }

    public String decrypt(String data, SecretKey key,String algo) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(algo);
        if(algo.contains("ECB")){
            cipher.init(Cipher.DECRYPT_MODE,key);
        }else{
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(DesConstants.iv);
            cipher.init(Cipher.DECRYPT_MODE,key,paramSpec);
        }
        byte[] decryptedResult = cipher.doFinal(DatatypeConverter.parseHexBinary(data));
        return DatatypeConverter.printHexBinary(decryptedResult);
    }

    public String encrypt(String data, byte[] sKey,String algo) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {



        SecretKey key = new SecretKeySpec(sKey, algo);
        Cipher cipher = Cipher.getInstance(algo);
        if(algo.contains("ECB")){
            cipher.init(Cipher.ENCRYPT_MODE,key);
        }else{
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(DesConstants.iv);
            cipher.init(Cipher.ENCRYPT_MODE,key,paramSpec);
        }
        byte[] encryptedResult = cipher.doFinal(data.getBytes());
        return DatatypeConverter.printHexBinary(encryptedResult);
    }

    public String decrypt(String data, byte[] sKey,String algo) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {

        SecretKey key = new SecretKeySpec(sKey, algo);
        Cipher cipher = Cipher.getInstance(algo);
        if(algo.contains("ECB")){
            cipher.init(Cipher.DECRYPT_MODE,key);
        }else{
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(DesConstants.iv);
            cipher.init(Cipher.DECRYPT_MODE,key,paramSpec);
        }
        byte[] decryptedResult = cipher.doFinal(DatatypeConverter.parseHexBinary(data));
        return DatatypeConverter.printHexBinary(decryptedResult);
    }
}
