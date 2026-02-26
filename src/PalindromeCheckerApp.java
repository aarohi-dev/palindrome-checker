public class PalindromeCheckerApp1 {
    public static void main(String[] args){
        System.out.println("Welcome to the Palindrome Checker app !");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully");

        String input = "madam";
        boolean isPalindrome = true;
        System.out.println("Input text: " + input);

        int length = input.length();
        for (int i = 0; i < input.length() / 2; i++){
            if (input.charAt(i) != input.charAt(length - 1 - i)){
                isPalindrome = false;
                break;
            }
        }
        System.out.println("Is it a Palindrome? :" + isPalindrome);

        StringBuilder reversed = new StringBuilder();
        for(int i = input.length() - 1; i >= 0; i--){
            reversed.append(input.charAt(i));
        }

        System.out.println("original: " + input);
        System.out.println("Reversed: " + reversed);


    }
}