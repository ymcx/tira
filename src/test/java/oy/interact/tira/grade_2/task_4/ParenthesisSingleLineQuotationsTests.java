package oy.interact.tira.grade_2.task_4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import oy.interact.tira.factories.StackFactory;
import oy.interact.tira.student.ParenthesesException;
import oy.interact.tira.student.ParenthesisChecker;
import oy.interact.tira.util.StackInterface;

/**
 * Tests for checking if structured parenthesis in a string match correctly.
 * 
 */
@DisplayName("Testing the stack with two structured files with parentheses.")
class ParenthesisSingleLineQuotationsTests {

   static int result = 0;

   @Test
   // @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
   @DisplayName("Testing a string with mismatching quotation characters") 
   void testMismatchingQuotationsInString() {
      try {
         final String wrongString = "Lorem \"ipsum ( dolor sit { amet, [ \"consectetur adipiscing\" ] elit, sed } do eiusmod tempor ) incididunt ut...";
         StackInterface<Character> stackToTest = StackFactory.createCharacterStack();
         ParenthesisChecker.checkParentheses(stackToTest, wrongString);         
      } catch (ParenthesesException e) {
         assertEquals(ParenthesesException.QUOTATION_ERROR, e.code, "Wrong error code in the thrown exception when quotes do not match");
      } catch (Exception e2) {
         fail("Must throw ParenthesesException when quotes do not match.");
      }
   }

   @Test
   // @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
   @DisplayName("Testing a string with mismatching quotation characters")
   void testOnlyOneQuotationInString() {
      try {
         final String wrongString = "Lorem ipsum ( dolor sit { amet, [ consectetur adipiscing\" ] elit, sed } do eiusmod tempor ) incididunt ut...";
         StackInterface<Character> stackToTest = StackFactory.createCharacterStack();
         ParenthesisChecker.checkParentheses(stackToTest, wrongString);
      } catch (ParenthesesException e) {
         assertEquals(ParenthesesException.QUOTATION_ERROR, e.code,
               "Wrong error code in the thrown exception when quotes do not match");
      } catch (Exception e2) {
         fail("Must throw ParenthesesException when quotes do not match.");
      }
   }
   @Test
   // @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
   @DisplayName("JSON file with correct parentheses (faulty in quotations) should pass the test.")
   void testCorrectJSONParenthesis() {
      try {
         String toCheck = new String(getClass().getClassLoader().getResourceAsStream("Person3.json").readAllBytes());
         StackInterface<Character> stackToTest = StackFactory.createCharacterStack();
         assertNotNull(stackToTest, "StackFactory failed to create the stack object");
         ParenthesisChecker.checkParentheses(stackToTest, toCheck);
      } catch (ParenthesesException e) {
         System.out.println("Exception thrown: " + e.getMessage());
         fail("Must not throw ParenthesisExceptions from checkParentheses when parentheses are correct (not in quotations)");
         System.out.println("Wrongly threw: " + e.toString());
      } catch (Exception others) {
         System.out.println("Exception thrown: " + others.getMessage());
         fail("Must throw ParenthesisExceptions from checkParentheses when parentheses are wrong");         
      }
   }


}
