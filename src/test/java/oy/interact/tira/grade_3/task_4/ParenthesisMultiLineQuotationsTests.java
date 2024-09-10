package oy.interact.tira.grade_3.task_4;


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
public class ParenthesisMultiLineQuotationsTests {

   static int result = 0;

   @Test
   // @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
   @DisplayName("Test a Java file with multiline string.")
   void testMultilineJavaString() {
      try {
         String toCheck = new String(getClass().getClassLoader().getResourceAsStream("TestingMultilineString.java").readAllBytes());
         StackInterface<Character> stackToTest = StackFactory.createCharacterStack();
         assertNotNull(stackToTest, "StackFactory failed to create the stack object");
         int count = ParenthesisChecker.checkParentheses(stackToTest, toCheck);
         assertEquals(10, count, "Test file has 10 parentheses, result does not match");
      } catch (ParenthesesException ex1) {
         fail("Must not throw a ParenthesesException");
      } catch (Exception ex2) {
         fail("Must not throw any other exception either");
      }
   }

   @Test
   // @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
   @DisplayName("Test a Java file with multiline string.")
   void testMultilineFaultyJavaString() {
      try {
         String toCheck = new String(
               getClass().getClassLoader().getResourceAsStream("TestingMultilineStringFaulty.java").readAllBytes());
         StackInterface<Character> stackToTest = StackFactory.createCharacterStack();
         assertNotNull(stackToTest, "StackFactory failed to create the stack object");
         int count = ParenthesisChecker.checkParentheses(stackToTest, toCheck);
         assertEquals(10, count, "Test file has 10 parentheses, result does not match");
      } catch (ParenthesesException ex1) {
         assertEquals(15, ex1.lineNumber, "Faulty line is 15, not something else");
         assertEquals(41, ex1.columnNumber, "Faulty line is 15, not something else");
         assertEquals(ParenthesesException.PARENTHESES_IN_WRONG_ORDER, ex1.code, "Error code in ParenthesesException must match");
      } catch (Exception ex2) {
         fail("Must not throw any other exception either");
      }
   }

   @Test
   // @Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
   @DisplayName("Test a Java file with multiline string.")
   void testMultilineStringFaultyQuotesJavaString() {
      try {
         String toCheck = new String(
               getClass().getClassLoader().getResourceAsStream("TestingMultilineStringFaultyQuotes.java").readAllBytes());
         StackInterface<Character> stackToTest = StackFactory.createCharacterStack();
         assertNotNull(stackToTest, "StackFactory failed to create the stack object");
         int count = ParenthesisChecker.checkParentheses(stackToTest, toCheck);
         assertEquals(10, count, "Test file has 10 parentheses, result does not match");
      } catch (ParenthesesException ex1) {
         assertEquals(15, ex1.lineNumber, "Faulty line is 15, not something else");
         assertEquals(41, ex1.columnNumber, "Faulty line is 15, not something else");
         assertEquals(ParenthesesException.PARENTHESES_IN_WRONG_ORDER, ex1.code,
               "Error code in ParenthesesException must match");
      } catch (Exception ex2) {
         fail("Must not throw any other exception either");
      }
   }

}
