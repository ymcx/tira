package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class ParenthesisChecker {

   private ParenthesisChecker() {
   }

   private static int getLN(String fromString, int i) {
      return fromString.substring(0, i).split("\\n", -1).length;
   }

   public static int checkParentheses(StackInterface<Character> stack, String fromString) throws ParenthesesException {
      String parenthesis = "({[]})";
      int count = 0;
      for (int i=0; i<fromString.length(); ++i) {
         int index = parenthesis.indexOf(fromString.charAt(i));
         switch(index) {
            case 0:
            case 1:
            case 2:
               try {
                  stack.push(fromString.charAt(i));
               }
               catch (NullPointerException e) {
                  throw new ParenthesesException("Merkki on null", getLN(fromString, i), i+1, ParenthesesException.STACK_FAILURE);
               }
               break;
            case 3:
            case 4:
            case 5:
               if (stack.isEmpty()) {
                  throw new ParenthesesException("Liian monta sulkevaa suljetta", getLN(fromString, i), i+1, ParenthesesException.TOO_MANY_CLOSING_PARENTHESES);
               }
               if (5 - index != parenthesis.indexOf(stack.pop())) {
                  throw new ParenthesesException("Sulkeet väärässä järjestyksessä", getLN(fromString, i), i+1, ParenthesesException.PARENTHESES_IN_WRONG_ORDER);
               }
               ++count;
               break;
         }  
      }
      if (!stack.isEmpty()) {
         throw new ParenthesesException("Liian monta avaavaa suljetta", getLN(fromString, fromString.length()), 0, ParenthesesException.TOO_MANY_OPENING_PARENTHESES);
      }
      return count * 2;
   }  
}
