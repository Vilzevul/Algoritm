package pro.sky;

import java.util.Arrays;

public class IntListImpl implements IntList {
    int[] intList = new int[1];
    private int size = 0;
    private final int delta = 1;

    private void resize() {
        int[] newIntList = new int[intList.length + delta];
        for (int i = 0; i < intList.length; i++) {
            newIntList[i] = intList[i];
        }
        intList = newIntList;
    }


    private int findBinaryOf(int item) {
        int min = 0;
        int max = intList.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == intList[mid]) {
                return mid;
            }

            if (item < intList[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }



    private void sortInsertion() {
        for (int i = 1; i < intList.length; i++) {
            int temp = intList[i];
            int j = i;
            while (j > 0 && intList[j - 1] >= temp) {
                intList[j] = intList[j - 1];
                j--;
            }
            intList[j] = temp;
        }
    }


    //Implementation
    @Override
    public int add(int item) {
        if (size == intList.length) resize();
        intList[size] = item;
        size++;
        return intList[size - 1];

    }

    @Override
    public int add(int index, int item) {
        if (index >= size) throw new IndexOutOfBoundsException("Индекс " + index);
        if (size == intList.length) resize();

        for (int i = size - 1; i >= index; i--) {
            intList[i + 1] = intList[i];
        }
        intList[index] = item;
        size++;

        return intList[index];

    }

    @Override
    public int set(int index, int item) {
        if (index >= size) throw new IndexOutOfBoundsException("Индекс " + index);
        intList[index] = item;
        return intList[index];

    }

    @Override
    public int remove(String item) {
        int index = -1;
        int items = Integer.valueOf(item);
        for (int i = 0; i < size; i++) {
            if (intList[i] == items) index = i;
            continue;
        }
        if (index == -1) throw new IllegalArgumentException("Аргумент " + item);

        for (int j = index; j < size - 1; j++) {
            intList[j] = intList[j + 1];
        }
        size--;
        return intList[index];

    }

    @Override
    public int remove(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("Индекс " + index);
        for (int i = index; i < size - 1; i++) {
            intList[i] = intList[i + 1];
        }
        size--;
        return intList[index];

    }

    @Override
    public boolean contains(int item) {
        sortInsertion();
        if (findBinaryOf(item) == -1) return false;
        return true;
    }


    @Override
    public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (intList[i] == item) return i;
        }
        return -1;

    }

    @Override
    public int lastIndexOf(int item) {
        for (int i = size - 1; i >= 0; i--) {
            if (intList[i] == item) return i;
        }
        return -1;

    }

    @Override
    public int get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("Индекс " + index);
        return intList[index];

    }

    @Override
    public boolean equals(IntList otherList) {
        if (otherList == null) throw new IllegalArgumentException("Аргумент null");
        if (this == otherList) return true;
        if (getClass() != otherList.getClass()) return false;
        IntListImpl that = (IntListImpl) otherList;
        return Arrays.equals(intList, that.intList);

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return false;
        return true;

    }

    @Override
    public void clear() {
        for (int i = 0; i < intList.length; i++) {
            intList[i] = 0;
        }
        size = 0;

    }

    @Override
    public int[] toArray() {
        int[] arr = new int[size];

        arr = Arrays.copyOf(intList, size);
        for (int i = 0; i < size; i++) {
            arr[i] = intList[i];
        }
        return arr;

    }
}
