
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class App {

    public static void main(String[] args) {

        try {

            boolean run = true;
            while (run) {
                Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

                System.out.println("Welcome the the Encryptor!");
                System.out.println("Enter the path to the txt file you want to encrypt or decrypt:");
                String path = scanner.nextLine();
                FileManager fileReader = new FileManager();

                String txtString = fileReader.readFileBuffered(path);


                System.out.println("Encrypt or decrypt?");

                System.out.println("1. Encrypt");
                System.out.println("2. Decrypt");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:

                        System.out.println("Choose a method of encryption:");
                        System.out.println("1. Caesar (substitution))");
                        System.out.println("2. Rail Fence (transposition)");

                        int methodChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (methodChoice) {
                            case 1:

                                System.out.println("Enter a key between 0 and 256:");
                                int key = scanner.nextInt();
                                scanner.nextLine();
                                Encryptor encryptor = new Encryptor();
                                String cipher = encryptor.substituteEncryptString(txtString, key);
                                System.out.println("Success");
                                fileReader.writeToFile(cipher, "encrypt");

                                break;

                            case 2:

                                Encryptor encryptor2 = new Encryptor();
                                String cipher2 = encryptor2.railFenceEncrypt(txtString);

                                fileReader.writeToFile(cipher2, "encrypt");

                                break;

                            case 0:
                                run = false;
                                System.out.println("Goodbye!");
                                scanner.close();
                                return;

                            default:
                                System.out.println("Invalid choice");

                                return;

                        }
                        break;
                    case 2:

                        System.out.println("Choose a method of decryption:");

                        System.out.println("1. Caesar (substitution))");
                        System.out.println("2. Rail Fence (transposition)");

                        int methodChoice2 = scanner.nextInt();

                        switch (methodChoice2) {
                            case 1:

                                System.out.println("Enter a key between 0 and 256:");
                                int key = scanner.nextInt();
                                scanner.nextLine();
                                Encryptor encryptor = new Encryptor();
                                String cipher = encryptor.substituteDecryptString(txtString, key);
                                System.out.println("Success");
                                fileReader.writeToFile(cipher, "decrypt");

                                break;

                            case 2:

                                Encryptor encryptor2 = new Encryptor();
                                String cipher2 = encryptor2.railFenceDecrypt(txtString);
                                fileReader.writeToFile(cipher2, "decrypt");

                                break;

                            case 0:
                                run = false;
                                System.out.println("Goodbye!");
                                scanner.close();
                                return;

                            default:
                                System.out.println("Invalid choice");

                                return;

                        }

                        return;
                    default:
                        System.out.println("Invalid choice");
                        return;
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
