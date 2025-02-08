# Building a Lexical Analyzer

### Overview

In this lab, you will build a lexical analyzer (lexer) - the first component of a compiler or interpreter. The lexer
will process Java-like source code and break it down into a sequence of tokens, making it easier for subsequent
compilation stages to understand the code's structure.

### Learning Outcomes

After completing this lab, you will be able to:

- Implement a lexical analyzer using regular expressions
- Use Java's Pattern and Matcher classes effectively
- Process text input systematically
- Handle different types of programming language tokens
- Work with Java collections (Lists, Arrays)

### Prerequisites

- Basic Java programming
- Understanding of regular expressions
- Familiarity with Java collections


### Project Setup

- Open the project in your IDE
- Locate the starter code at: `src/main/java/academy/javapro/Lexer.java`
- Do not modify the package structure or class name
- Implement the required functionality in the TODOs provided

### Task Description

You will create a lexical analyzer that can process Java-like code and identify different types of tokens. Your program
should be able to process input like:

```java
int x = 10; if(x >5){x =x +1;}
```

And produce output identifying each token and its type, similar to:

```text
KEYWORD: int
IDENTIFIER: x
OPERATOR: =
LITERAL: 10
PUNCTUATION: ;
KEYWORD: if
PUNCTUATION: (
IDENTIFIER: x
OPERATOR: >
LITERAL: 5
PUNCTUATION: )
PUNCTUATION: {
IDENTIFIER: x
OPERATOR: =
IDENTIFIER: x
OPERATOR: +
LITERAL: 1
PUNCTUATION: ;
PUNCTUATION: }
```

### Requirements

**Functional Requirements**

Your lexer must:

- Process input text character by character
- Identify and categorize the following types of tokens:
    - Keywords (if, else, for, while, int, float, String)
    - Literals (numeric values)
    - Operators (arithmetic and comparison)
    - Punctuation marks
    - Identifiers (variable names)
- Skip whitespace appropriately
- Handle invalid input by throwing appropriate exceptions

**Technical Requirements**

- Use Java's Pattern and Matcher classes for token recognition
- Maintain proper code organization and documentation
- Include appropriate error handling
- Implement all TODO sections in the starter code

### Starter Code

```java
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

    /**
     * TODO: Initialize the lexer with the input string
     * 1. Store the input string in the 'input' field
     * 2. Initialize the tokens list as a new ArrayList
     * 3. Set the initial position to 0
     *
     * @param input The source code string to be tokenized
     */
    public Lexer(String input) {
        // Your code here
    }

    /**
     * TODO: Process the input string and break it into tokens
     * Steps to implement:
     * 1. Create a while loop that continues while position < input.length()
     * 2. Get the remaining input using substring(position)
     * 3. Try to match each pattern in PATTERNS array:
     *    - Create a matcher using pattern.matcher(remainingInput)
     *    - Use matcher.lookingAt() to check if it matches at current position
     *    - If match found:
     *      a. Get the matched text using matcher.group()
     *      b. If not whitespace, add new token to tokens list
     *      c. Update position by adding length of matched text
     * 4. If no pattern matches, throw RuntimeException for invalid input
     */
    public void tokenize() {
        // Your code here
    }

    /**
     * TODO: Return the list of tokens
     * 1. Return the tokens list containing all found tokens
     * 2. Each token should be a String array with two elements:
     *    - First element: Token type (from TYPES array)
     *    - Second element: Token value (the actual text)
     *
     * @return List<String [ ]> The list of tokens
     */
    public List<String[]> getTokens() {
        // Your code here
        return null;
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
```

### Understanding Token Types

Before writing any code, let's understand what we're looking for in our code:

### Token Categories

1. Keywords
    - Java reserved words like `if`, `while`, `class`, `public`, etc.
    - These are fixed strings that have special meaning in the language
    - Example: In `if (x > 0)`, the word `if` is a keyword
2. Identifiers
    - Names given to variables, methods, classes
    - Must start with a letter or underscore, followed by letters, numbers, or underscores
    - Example: In `int count = 0`, `count` is an identifier
3. Literals
    - Integer literals: `42`, `100`, `0`
    - Floating-point literals: `3.14`, `2.0 `
    - String literals: `"Hello"`, `"Java"`
    - Character literals: `'a'`, `'#'`
4. Punctuation
    - Parentheses: `(`, `)`
    - Braces: `{`, `}`
    - Brackets: `[`, `]`
    - Others: `,`, `;`, `.`

### Testing Your Implementation

**Test Case 1: Basic Variable Declaration**

```java
int x = 10;
```

**Expected output:**

```text
KEYWORD: int
IDENTIFIER: x
OPERATOR: =
LITERAL: 10
PUNCTUATION: ;
```

**Test Case 2: If Statement**

```java
if(x >5){}
```

**Expected output:**

```text
KEYWORD: if
PUNCTUATION: (
IDENTIFIER: x
OPERATOR: >
LITERAL: 5
PUNCTUATION: )
PUNCTUATION: {
PUNCTUATION: }
```

### Resources

- [Java Pattern Class Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html)
- [Java Matcher Class Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html)
- [Regular Expressions Tutorial](https://www.regular-expressions.info/)