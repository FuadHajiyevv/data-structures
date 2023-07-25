package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class FStack {

    private int[] stackBasedOnArray;

    private int top = -1;

    public FStack() {
        stackBasedOnArray = new int[10];
    }

    public FStack(int initialCapacity){
        stackBasedOnArray = new int[initialCapacity];
    }

    public void push(int value) {
        top++;
        if (top < stackBasedOnArray.length) {
            stackBasedOnArray[top] = value;
            return;
        }

        int[] resizeArray = new int[stackBasedOnArray.length * 2];
        for(int i = 0; i < stackBasedOnArray.length; i++)
            resizeArray[i] = stackBasedOnArray[i];
        resizeArray[top] = value;
        stackBasedOnArray = resizeArray;
    }

    public int pop() {
        if (top == -1)
            throw new EmptyStackException();

        int elementBefore = stackBasedOnArray[top];
        top--;
        return elementBefore;
    }

    public int peek() {
        if (top == -1)
            throw new EmptyStackException();
        return stackBasedOnArray[top];
    }


    public boolean empty() {
        return this.top == -1;
    }

    @Override
    public String toString() {
        int[] elementsNotOverTop = Arrays.copyOfRange(stackBasedOnArray, 0, top + 1);
        return Arrays.toString(elementsNotOverTop);
    }
}
