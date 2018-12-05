import java.util.Scanner;

public class CodeDecode {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String decoded;
        String coded;
        String password;
        String codeDecode;
        int countPassword;
        boolean specialChar;
        boolean overZ;
        boolean underA;
        boolean uppercase;

        do {
            System.out.print("Code or decode? [C/D]: ");
            codeDecode = scanner.next();
        } while (!codeDecode.equals("C") && !codeDecode.equals("D") && !codeDecode.equals("stop"));

        while (!codeDecode.equals("stop")) {
            switch (codeDecode) {
                case "C":
                    System.out.print("String: ");
                    scanner.nextLine();
                    decoded = scanner.nextLine();
                    coded = "";

                    System.out.print("Password (letters only): ");
                    password = scanner.next();

                    countPassword = 0;

                    for (int i = 0; i < decoded.length(); i++) {
                        specialChar = !((decoded.charAt(i) >= 'A' && decoded.charAt(i) <= 'Z') || (decoded.charAt(i) >= 'a' && decoded.charAt(i) <= 'z'));
                        uppercase = decoded.charAt(i) == decoded.toUpperCase().charAt(i);

                        if (specialChar) {
                            coded += (char) decoded.charAt(i);
                        } else if (uppercase) {
                            overZ = (decoded.charAt(i) + password.toUpperCase().charAt(countPassword) - 64 > 'Z');
                            if (overZ)
                                coded += (char) (decoded.charAt(i) - (26 - (password.toUpperCase().charAt(countPassword) - 64)));
                            else
                                coded += (char) (decoded.charAt(i) + password.toUpperCase().charAt(countPassword) - 64);
                        } else {
                            overZ = (decoded.charAt(i) + password.toLowerCase().charAt(countPassword) - 96 > 'z');
                            if (overZ)
                                coded += (char) (decoded.charAt(i) - (26 - (password.toLowerCase().charAt(countPassword) - 96)));
                            else
                                coded += (char) (decoded.charAt(i) + password.toLowerCase().charAt(countPassword) - 96);
                        }

                        countPassword++;
                        if (countPassword == password.length()) {
                            countPassword = 0;
                        }
                    }

                    System.out.printf("'%s' coded with '%s' is '%s'.%n%n", decoded, password, coded);
                    break;
                case "D":
                    System.out.print("String: ");
                    scanner.nextLine();
                    coded = scanner.nextLine();
                    decoded = "";

                    System.out.print("Password (letters only): ");
                    password = scanner.next();

                    countPassword = 0;

                    for (int i = 0; i < coded.length(); i++) {
                        specialChar = !((coded.charAt(i) >= 'A' && coded.charAt(i) <= 'Z') || (coded.charAt(i) >= 'a' && coded.charAt(i) <= 'z'));
                        uppercase = coded.charAt(i) == coded.toUpperCase().charAt(i);

                        if (specialChar) {
                            decoded += (char) coded.charAt(i);
                        } else if (uppercase) {
                            underA = (coded.charAt(i) - password.toUpperCase().charAt(countPassword) + 64 < 'A');
                            if (underA)
                                decoded += (char) (coded.charAt(i) + (26 - (password.toUpperCase().charAt(countPassword) + 64)));
                            else
                                decoded += (char) (coded.charAt(i) - password.toUpperCase().charAt(countPassword) + 64);
                        } else {
                            underA = (coded.charAt(i) - password.toLowerCase().charAt(countPassword) + 96 < 'a');
                            if (underA)
                                decoded += (char) (coded.charAt(i) + (26 - (password.toLowerCase().charAt(countPassword) - 96)));
                            else
                                decoded += (char) (coded.charAt(i) - password.toLowerCase().charAt(countPassword) + 96);
                        }

                        countPassword++;
                        if (countPassword == password.length()) {
                            countPassword = 0;
                        }
                    }

                    System.out.printf("'%s' decoded with '%s' is '%s'.%n%n", coded, password, decoded);
                    break;
            }
            do {
                System.out.print("Code or decode? [C/D]: ");
                codeDecode = scanner.next();
            } while (!codeDecode.equals("C") && !codeDecode.equals("D") && !codeDecode.equals("stop"));
        }
    }
}