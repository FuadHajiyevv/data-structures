package custom_array;

import java.util.Arrays;

public class FArray {
    private int size;

    private int[] array;

    public FArray() {
        array = new int[0];
    }


    public void add(int num) {
        int[] tempArray = new int[++this.size];
        for (int i = 0; i < size - 1; i++) {
            tempArray[i] = array[i];
        }
        tempArray[size - 1] = num;
        array = tempArray;
    }

    public void add(int index, int num) {
        int[] tempArray = new int[++this.size];
        for (int i = 0, j = 0; i < size; i++) {
            if (index == i) {
                tempArray[i] = num;
            } else
                tempArray[i] = array[j++];
        }
        array = tempArray;
    }

    public void delete(int index) {
        int[] tempArray = new int[--this.size];
        for (int i = 0, j = 0; i < size + 1; i++) {
            if (i == index) {
                continue;
            }
            tempArray[j++] = array[i];
        }
        array = tempArray;
    }

    public int size() {
        return size;
    }


    public boolean contains(int num) {
        for (int i = 0; i < this.size(); i++) {
            if (array[i] == num) {
                return true;
            }
        }
        return false;
    }

    public int get(int index) {
        if (this.size() > index) {
            return array[index];
        }
        throw new IndexOutOfBoundsException();
    }

    public int indexOf(int num) {
        for (int i = 0; i < this.size(); i++) {
            if (array[i] == num) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void change(int index, int num) {
        if (index < size && index >= 0) {
            array[index] = num;
            return;
        }
        throw new IndexOutOfBoundsException(String.format("Index %d is out of bound array with length %d", index, size));
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
