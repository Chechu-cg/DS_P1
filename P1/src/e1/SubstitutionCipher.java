package e1;

import java.util.Scanner;

public class SubstitutionCipher {
    private static final String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String minusculas = "abcdefghijklmnopqrstuvwxyz";

    public static String encode(int key, String arg){
        StringBuilder text = new StringBuilder(arg);
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < minusculas.length(); j++) {
                if (text.charAt(i) == minusculas.charAt(j)) {
                    if (j + key > minusculas.length() - 1) {
                        text.setCharAt(i, minusculas.charAt(j + key - minusculas.length()));
                    } else {
                        text.setCharAt(i, minusculas.charAt(j + key));
                    }
                    break;
                } else if (text.charAt(i) == mayusculas.charAt(j)) {
                    if (j + key > mayusculas.length() - 1) {
                        text.setCharAt(i, mayusculas.charAt(j + key - mayusculas.length()));
                    } else {
                        text.setCharAt(i, mayusculas.charAt(j + key));
                    }
                    break;
                }
            }

        }
        System.out.println("coded = " + text);

        return text.toString();
    }

    public static String decode(int key, String arg){
        StringBuilder text = new StringBuilder(arg);

        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < mayusculas.length(); j++) {

                if (text.charAt(i) == minusculas.charAt(j)) {
                    if (j-key < 0) {
                        text.setCharAt(i, minusculas.charAt(minusculas.length() + j - key));
                    } else {
                        text.setCharAt(i, minusculas.charAt(j-key));
                    }
                    break;
                } else if (text.charAt(i) == mayusculas.charAt(j)) {
                    if (j-key < 0) {
                        text.setCharAt(i, mayusculas.charAt(mayusculas.length() + j - key));
                    }  else {
                        text.setCharAt(i, mayusculas.charAt(j-key));
                    }
                    break;
                }
            }
        }

        System.out.println("decoded = " + text);
        return text.toString();
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = scan.nextLine();

        int key = 3;
        String coded = encode(key, text);
        decode(key, coded);

    }

}
