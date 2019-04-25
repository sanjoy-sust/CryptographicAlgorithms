package des;

import des.algo.DesAlgorithm;
import des.algo.DesAlgorithmImpl;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.xml.bind.DatatypeConverter;
import java.security.*;
import java.util.Scanner;

public class DesApp {

    DesAlgorithm desAlgorithm = new DesAlgorithmImpl();

    public String  encrypt(String dataToEncrypt,SecretKey key,String algo) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException {

        return desAlgorithm.encrypt(dataToEncrypt,key,algo);
    }

    public String decrypt(String dataToDecrypt,SecretKey key,String algo) throws NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException {
        return desAlgorithm.decrypt(dataToDecrypt,key,algo);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {

        Security.addProvider(new BouncyCastleProvider());
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        SecureRandom secureRandom = new SecureRandom();
        int keyBitSize = 64;
        keyGenerator.init(keyBitSize, secureRandom);
        SecretKey secretKey = keyGenerator.generateKey();
        System.out.println("Secret Key : "+ DatatypeConverter.printHexBinary(secretKey.getEncoded()));
        DesApp desApp = new DesApp();

        System.out.println("Enter your data to encrypt : ");
        Scanner scanner = new Scanner(System.in);
        String dataToEncrypt = scanner.next();
        System.out.println("Original data : "+DatatypeConverter.printHexBinary(dataToEncrypt.getBytes()));
        String encryptedData = desApp.encrypt(dataToEncrypt,secretKey,"DES/CBC/PKCS5Padding");
        System.out.println("Encrypted Data : "+encryptedData);
        String decryptedData = desApp.decrypt(encryptedData,secretKey,"DES/CBC/PKCS5Padding");
        System.out.println("DecryptedData : "+decryptedData);

    }
}
