import java.util.*;

public class StringOperations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        String changedCase = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch))
                changedCase += Character.toLowerCase(ch);
            else
                changedCase += Character.toUpperCase(ch);
        }
        System.out.println("The string after changing the case is " + changedCase);

        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        System.out.println("The string after reversing is " + reverse);

        System.out.print("Enter the second string for comparision: ");
        String str2 = sc.nextLine();
        int diff = str.compareTo(str2);
        System.out.println("The difference between ASCII value is " + Math.abs(diff));

        System.out.print("Enter the string to be inserted into first string: ");
        String insert = sc.nextLine();
        String result = str + " " + insert;
        System.out.println("The string after insertion is : " + result);

        System.out.print("Enter a String: ");
        String str3 = sc.nextLine();
        System.out.println("Uppercase: " + str3.toUpperCase());
        System.out.println("Lowercase: " + str3.toLowerCase());
        System.out.print("Enter a String: ");
        String str4 = sc.nextLine();
        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);
        int pos = str4.indexOf(ch);
        if (pos >= 0)
            System.out.println("Position of entered character: " + pos);
        else
            System.out.println("Entered character is not present");
        System.out.print("Enter a String: ");
        String str5 = sc.next();
        String rev = "";
        for (int i = str5.length() - 1; i >= 0; i--) {
            rev += str5.charAt(i);
        }
        if (str5.equals(rev))
            System.out.println("Entered string is palindrome");
        else
            System.out.println("Entered string is not a palindrome");

        sc.nextLine();
        System.out.print("Enter a String: ");
        String str6 = sc.nextLine();
        String words[] = str6.trim().split("\\s+");
        int wordCount = words.length;

        int vowels = 0, consonants = 0;
        for (int i = 0; i < str6.length(); i++) {
            char c = Character.toLowerCase(str6.charAt(i));
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    vowels++;
                else
                    consonants++;
            }
        }

        System.out.println("No. of words: " + wordCount);
        System.out.println("No. of vowels: " + vowels);
        System.out.println("No. of consonants: " + consonants);

        sc.close();
    }
}