import java.security.SecureRandom;

import java.io.Console;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class PasswordManager {
    private static final Map<String, String> passwords = new HashMap<>();

    public static void main(String[] args) {
        Console console = System.console();

        if (console  == null) {
            System.err.println("Could not get console instance");
            System.exit(1);
        }

        while (true) {
            String option = console.readLine("Enter 1 to get a password, 2 to set a password, or 3 to exit: ");

            switch (option) {
                case "1":

                    String account = console.readLine("Enter account name: ");
                    getPassword(console, account);
                    break;

                case "2":
                    account = console.readLine("Enter account name: ");
                    setPassword(console, account);
                    break;

                case "3":
                    System.exit(0);
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    private static void getPassword(Console console, String account){
        String password = passwords.get(account);
        if (password == null) {
            System.out.println("No password found for " + account);

        } 
        else {
            System.out.println("Password for " + account + ": " + password);
        }
    }


    private static void setPassword(Console console, String account){
        char[] passwordChars = console.readPassword("Enter new password: ");
        String password = Base64.getEncoder().encodeToString(hashPassword(passwordChars));
        passwords.put(account, password);
        System.out.println("Password for " + account + " has been set.");
    }

    private static byte[] hashPassword(char[] password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return bcrypt(password, salt);
    }

    private static byte[] bcrypt(char [] password, byte[] salt) {
        return new byte[0];
    }

}