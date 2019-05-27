
import des.algo.DesAlgorithm;
import des.algo.DesAlgorithmImpl;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        System.out.println("Welcome to cryptographic algorithm area");
        Security.addProvider(new BouncyCastleProvider());
   /*     Scanner scanner = new Scanner(System.in);
        System.out.println("Provider added");
        DesAlgorithm desAlgorithm = new DesAlgorithmImpl();
        System.out.println("Enter data to encrypt : ");
        String dataToEncrypt = scanner.next();
        String encryptedData = desAlgorithm.encrypt(dataToEncrypt);
        System.out.println("Encrypted Data : "+encryptedData);*/

    }
}
