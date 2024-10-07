package com.pogodin;

/**
 * Implement a stack that supports push, pop, and retrieving the middle element in constant time.
 */
public class StackWithMiddleRetrieve {
    interface Stack {
        void push(int val);

        int pop();

        int middleElem();
    }

    static class StackImpl implements Stack {

        private static final String EMPTY_STACK_ERR = "Stack is empty";
        private final StackNode head = new StackNode(); // head, always exists
        private StackNode last;
        private StackNode mid;
        int nodeCounter;

        public StackImpl() {
            last = head;
            mid = head;
        }

        @Override
        public void push(int val) {
            StackNode newNode = new StackNode();
            newNode.val = val;
            newNode.prev = last;
            last.next = newNode;
            last = last.next;
            nodeCounter++;

            if (nodeCounter % 2 != 0) {
                mid = mid.next;
            }
        }

        @Override
        public int pop() {
            emptyStackCheck();

            StackNode popped = last;
            last = last.prev;
            last.next = null;
            nodeCounter--;

            if (nodeCounter % 2 == 0) {
                mid = mid.prev;
            }

            return popped.val;
        }

        @Override
        public int middleElem() {
            emptyStackCheck();
            return mid.val;
        }

        private void emptyStackCheck() {
            if (last == head) {
                throw new IllegalStateException(EMPTY_STACK_ERR);
            }
        }
    }

    static class StackNode {
        int val;
        StackNode prev;
        StackNode next;
    }
}
