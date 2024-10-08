package com.pogodin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackWithMiddleRetrieveTest {
    @Test
    public void testPushPop() {
        StackWithMiddleRetrieve.Stack stack = new StackWithMiddleRetrieve.StackImpl();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop(), "The popped element should be 30");
        assertEquals(20, stack.pop(), "The popped element should be 20");
        assertEquals(10, stack.pop(), "The popped element should be 10");
    }

    @Test
    public void testMiddleElem() {
        StackWithMiddleRetrieve.Stack stack = new StackWithMiddleRetrieve.StackImpl();

        stack.push(10);
        assertEquals(10, stack.middleElem(), "Middle element should be 10 after pushing one element");

        stack.push(20);
        assertEquals(10, stack.middleElem(), "Middle element should still be 10 after pushing two elements");

        stack.push(30);
        assertEquals(20, stack.middleElem(), "Middle element should be 20 after pushing three elements");

        stack.push(40);
        assertEquals(20, stack.middleElem(), "Middle element should still be 20 after pushing four elements");

        stack.pop();
        assertEquals(20, stack.middleElem(), "Middle element should be 20 after popping the top element");

        stack.pop();
        assertEquals(10, stack.middleElem(), "Middle element should be 10 after popping the second element");
    }

    @Test
    public void testPopEmptyStack() {
        StackWithMiddleRetrieve.Stack stack = new StackWithMiddleRetrieve.StackImpl();

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            stack.pop();
        });

        String expectedMessage = "Stack is empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Exception message should indicate the stack is empty");
    }

    @Test
    public void testMiddleEmptyStack() {
        StackWithMiddleRetrieve.Stack stack = new StackWithMiddleRetrieve.StackImpl();

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            stack.middleElem();
        });

            String expectedMessage = "Stack is empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Exception message should indicate the stack is empty");
    }
}