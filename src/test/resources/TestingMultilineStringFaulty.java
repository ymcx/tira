public class TestingMultilineStringFaulty {
    private static final String multiline = """
            This is a 
            string on multiple lines that is
            syntactically legal in Java
            and many other languages.
            This string may also contain parentheses like [ 
            and ) without problems since they do not count.
            """;    

    public static void main(String [] args) {
        System.out.println(multiline);
    }

    private void faultyParenthesisHere( ] {
        
    }
}
