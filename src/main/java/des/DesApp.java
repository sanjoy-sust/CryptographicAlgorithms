package des;

import des.algo.DesAlgorithm;
import des.algo.DesAlgorithmImpl;
import des.constants.DesConstants;
import des.enums.Algorithm;
import des.enums.ChipperMode;
import des.enums.DesPaddingMode;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.xml.bind.DatatypeConverter;
import java.security.*;
import java.util.Scanner;

public class DesApp {

    DesAlgorithm desAlgorithm = new DesAlgorithmImpl();

    public String encrypt(String dataToEncrypt, SecretKey key, String algo) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException {

        return desAlgorithm.encrypt(dataToEncrypt, key, algo);
    }

    public String decrypt(String dataToDecrypt, SecretKey key, String algo) throws NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException {
        return desAlgorithm.decrypt(dataToDecrypt, key, algo);
    }

    public String encrypt(String dataToEncrypt, byte[] key, String algo) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException {

        return desAlgorithm.encrypt(dataToEncrypt, key, algo);
    }

    public String decrypt(String dataToDecrypt, byte[] key, String algo) throws NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException {
        return desAlgorithm.decrypt(dataToDecrypt, key, algo);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Security.addProvider(new BouncyCastleProvider());

        SecretKey secretKey = getSecretKey(Algorithm.DES.getValue());
        System.out.println("Secret Key : " + DatatypeConverter.printHexBinary(secretKey.getEncoded()));
        DesApp desApp = new DesApp();

        System.out.println("Enter your data to encrypt : ");

        Scanner scanner = new Scanner(System.in);
        String dataToEncrypt = scanner.next();
        System.out.println("Original data : " + DatatypeConverter.printHexBinary(dataToEncrypt.getBytes()));
        String encryptedData = desApp.encrypt(dataToEncrypt, DesConstants.baseKey, getAlgo(Algorithm.DES.getValue(),ChipperMode.CBC.getValue(),DesPaddingMode.PKCS5_PADDING.getValue()));
        System.out.println("Encrypted Data : " + encryptedData);
        String decryptedData = desApp.decrypt(encryptedData, DesConstants.baseKey, getAlgo(Algorithm.DES.getValue(),ChipperMode.CBC.getValue(),DesPaddingMode.PKCS5_PADDING.getValue()));
        System.out.println("DecryptedData : " + decryptedData);

        System.out.println("#######################################################################");
        System.out.println("Original data : " + DatatypeConverter.printHexBinary(dataToEncrypt.getBytes()));
        encryptedData = desApp.encrypt(dataToEncrypt, secretKey, getAlgo(Algorithm.DES.getValue(),ChipperMode.CBC.getValue(),DesPaddingMode.PKCS5_PADDING.getValue()));
        System.out.println("Encrypted Data : " + encryptedData);
        decryptedData = desApp.decrypt(encryptedData, secretKey, getAlgo(Algorithm.DES.getValue(),ChipperMode.CBC.getValue(),DesPaddingMode.PKCS5_PADDING.getValue()));
        System.out.println("DecryptedData : " + decryptedData);

    }

    private static String getAlgo(String algo,String cipherMode, String paddingMode) {
        return algo + "/" + cipherMode + "/" + paddingMode ;
    }

    private static SecretKey getSecretKey(String algo) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algo);
        SecureRandom secureRandom = new SecureRandom();
        int keyBitSize = 56;
        keyGenerator.init(keyBitSize, secureRandom);
        return keyGenerator.generateKey();
    }
}
