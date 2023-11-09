package com.balancedbrackets;

import java.util.Stack;
import java.util.Scanner;

public class BalancedBrackets {

    public static boolean isBalancedBrackets(String input) {
        Stack<Character> stack = new Stack<>();

        for (char character : input.toCharArray()) {
            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
            } else if (character == ')' || character == '}' || character == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char openBracket = stack.pop();

                if ((character == ')' && openBracket != '(') ||
                    (character == '}' && openBracket != '{') ||
                    (character == ']' && openBracket != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
    	Scanner scanner= new Scanner(System.in);
    	System.out.print("Enter a string with brackets: ");
    	String input = scanner.nextLine();
        if (isBalancedBrackets(input)) {
            System.out.println("Balanced Brackets");
        } else {
            System.out.println("Unbalanced String");
        }
    }
}
