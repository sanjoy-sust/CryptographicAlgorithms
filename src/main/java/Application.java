
import des.DesAlgorithm;
import des.DesAlgorithmImpl;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome to cryptographic algorithm area");
        Security.addProvider(new BouncyCastleProvider());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provider added");
        DesAlgorithm desAlgorithm = new DesAlgorithmImpl();
        System.out.println("Enter data to encrypt : ");
        String dataToEncrypt = scanner.next();
        String encryptedData = desAlgorithm.encrypt(dataToEncrypt);
        System.out.println("Encrypted Data : "+encryptedData);
    }
}
