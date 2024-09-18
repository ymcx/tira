package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class ParenthesisChecker {

   private ParenthesisChecker() {
   }

   private static int getLN(String fromString, int i) {
      return fromString.substring(0, i).split("\\n", -1).length;
   }

   private static int getCN(String fromString, int i) {
      // spagetti
      int lastNLChar = fromString.substring(0, i).lastIndexOf("\n");
      if (lastNLChar != -1) {
         return i - fromString.substring(0, lastNLChar).length();
      }
      return i + 1;
   }

   public static int checkParentheses(StackInterface<Character> stack, String fromString) throws ParenthesesException {
      String parenthesis = "({[]})\"";
      int count = 0;
      int quoteStreak = 0;
      int quoteLN = 0;
      boolean singleQuote = false;
      boolean tripleQuote = false;
      for (int i=0; i<fromString.length(); ++i) {
         int index = parenthesis.indexOf(fromString.charAt(i));
         switch(index) {
            case 0:
            case 1:
            case 2:
               quoteStreak = 0;
               if (tripleQuote || (singleQuote && quoteLN == getLN(fromString, i))) {
                  break;
               }
               singleQuote = false;
               try {
                  stack.push(fromString.charAt(i));
               }
               catch (NullPointerException e) {
                  throw new ParenthesesException("Merkki on null", getLN(fromString, i), getCN(fromString, i), ParenthesesException.STACK_FAILURE);
               }
               break;
            case 3:
            case 4:
            case 5:
               quoteStreak = 0;
               if (tripleQuote || (singleQuote && quoteLN == getLN(fromString, i))) {
                  break;
               }
               singleQuote = false;
               if (stack.isEmpty()) {
                  throw new ParenthesesException("Liian monta sulkevaa suljetta", getLN(fromString, i), getCN(fromString, i), ParenthesesException.TOO_MANY_CLOSING_PARENTHESES);
               }
               if (5 - index != parenthesis.indexOf(stack.pop())) {
                  throw new ParenthesesException("Sulkeet väärässä järjestyksessä", getLN(fromString, i), getCN(fromString, i), ParenthesesException.PARENTHESES_IN_WRONG_ORDER);
               }
               ++count;
               break;
            case 6:
               ++quoteStreak;
               if (quoteStreak <= 2) {
                  if (tripleQuote) {
                     quoteStreak = 0;
                     tripleQuote ^= true;
                     break;
                  }
                  if (!singleQuote) {
                     quoteLN = getLN(fromString, i);
                     singleQuote = true;
                  }
                  else if (quoteLN != getLN(fromString, i)) {
                     throw new ParenthesesException("Lainausmerkit eivät täsmää", getLN(fromString, i), getCN(fromString, i), ParenthesesException.QUOTATION_ERROR);
                  }
                  else {
                     singleQuote = false;
                  }
               }
               if (quoteStreak == 3) {
                  quoteStreak = 0;
                  tripleQuote ^= true;
               }
               break;
            default:
               quoteStreak = 0;
               break;
         }  
      }
      if (singleQuote || tripleQuote) {
         throw new ParenthesesException("Lainausmerkit eivät täsmää", getLN(fromString, fromString.length()), getCN(fromString, fromString.length()), ParenthesesException.QUOTATION_ERROR);
      }
      if (!stack.isEmpty()) {
         throw new ParenthesesException("Liian monta avaavaa suljetta", getLN(fromString, fromString.length()), getCN(fromString, fromString.length()), ParenthesesException.TOO_MANY_OPENING_PARENTHESES);
      }
      return count * 2;
   }  
}
