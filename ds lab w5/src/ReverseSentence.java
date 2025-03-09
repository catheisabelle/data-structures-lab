import java.util.Scanner;
import java.util.Stack;

public class ReverseSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter a sentence:");
        String sentence = scanner.nextLine();

        String[] words = sentence.split(" ");

        Stack<String> stack = new Stack<>();

        for (String word : words) {
            stack.push(word);
        }

        StringBuilder reversedSentence = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedSentence.append(stack.pop()).append(" ");
        }

        System.out.println("\nreversed sentence:");
        System.out.println(reversedSentence);

        scanner.close();
    }
}