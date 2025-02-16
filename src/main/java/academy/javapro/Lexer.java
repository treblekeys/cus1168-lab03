//Jinqing Mei
package academy.javapro;

import java.util.*;
import java.util.regex.*;

public class Lexer {
    private static final Pattern[] PATTERNS = {
            Pattern.compile("\\s+"),                                       // whitespace
            Pattern.compile("\\b(if|else|for|while|int|float|String)\\b"), // keywords
            Pattern.compile("\\b\\d+(\\.\\d+)?\\b"),                      // literals
            Pattern.compile("==|<=|>=|!=|&&|\\|\\||[+\\-*/=<>!]"),        // operators
            Pattern.compile("[;,.(){}\\[\\]]"),                           // punctuation
            Pattern.compile("\\b[a-zA-Z_][a-zA-Z0-9_]*\\b")               // identifiers
    };

    private static final String[] TYPES = {
            "WHITESPACE",
            "KEYWORD",
            "LITERAL",
            "OPERATOR",
            "PUNCTUATION",
            "IDENTIFIER"
    };

    private String input;
    private List<String[]> tokens;
    private int position;

    //Initialize lexer
    public Lexer(String input) {
        this.input = input;
        this.tokens = new ArrayList<>();
        this.position = 0;
    }

    //Process input string and break it into tokens
    public void tokenize() {
        while(position < input.length()) {
            String remainingInput = input.substring(position);
            boolean matched = false;
            for(int i = 0; i < PATTERNS.length; i++) {
                Matcher matcher = PATTERNS[i].matcher(remainingInput);
                if(matcher.lookingAt()) {
                    String match = matcher.group();
                    if(!TYPES[i].equals("WHITESPACE")) {
                        tokens.add(new String[] {TYPES[i] , match});
                    }
                    position += match.length();
                    matched = true;
                    break;
                }
            }
            if(!matched) {
                throw new RuntimeException("Invalid character at position " + position + ": " + remainingInput.charAt(0));
            }
        }
    }

    public List<String[]> getTokens() {
        return tokens;
    }

    public static void main(String[] args) {
        String code = "int x = 10; if (x > 5) { x = x + 1; }";
        Lexer lexer = new Lexer(code);
        lexer.tokenize();
        for (String[] token : lexer.getTokens()) {
            System.out.println(token[0] + ": " + token[1]);
        }
    }
}
