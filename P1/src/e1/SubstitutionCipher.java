package e1;

import java.util.Scanner;

public class SubstitutionCipher {

    // Usar String encode(int key, String text)
    // Usar String decode(int key, String text)

    // Clases: String, Character, StringBuilder

    private static String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String minusculas = "abcdefghijklmnopqrstuvwxyz";
    private static int key = 3;
    private String coded;

    public static String encode(int key, String text) {

        for (int i = 0; i < text.length(); i++) {

            for (int j = 0; j < minusculas.length(); j++) {
                if (text.charAt(i) == minusculas.charAt(j)) {
                    if (j + key > minusculas.length() - 1) {
                        System.out.print(minusculas.charAt(j + key - minusculas.length()));
                    } else {
                        System.out.print(minusculas.charAt(j + key));
                    }
                } else if (text.charAt(i) == mayusculas.charAt(j)) {
                    if (j + key > mayusculas.length() - 1) {
                        System.out.print(mayusculas.charAt(j + key - mayusculas.length()));
                    } else {
                        System.out.print(mayusculas.charAt(j + key));
                    }
                }
            }
        }


        return text;
    }

    void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = scan.nextLine();

        coded = encode(key, text);


    }

}
