package pro.sky;

import java.util.Arrays;

public class StringListImpl implements StringList {
    String[] stringList = new String[1];
    private int size = 0;
    private final int delta = 1;

    private void resize() {
        String[] newStringList = new String[stringList.length + delta];
        for (int i = 0; i < stringList.length; i++) {
            newStringList[i] = stringList[i];
        }
        stringList = newStringList;
    }

    @Override
    public String add(String item) {
        if (size == stringList.length) resize();
        stringList[size] = item;
        size++;
        return stringList[size - 1];
    }

    @Override
    public String add(int index, String item) {
        if (index >= size) throw new IndexOutOfBoundsException("Индекс "+index);
        if (size == stringList.length) resize();

            for (int i = size - 1; i >= index; i--) {
                stringList[i + 1] = stringList[i];
            }
            stringList[index] = item;
            size++;

        return stringList[index];
    }

    @Override
    public String set(int index, String item) {
        if (index >= size) throw new IndexOutOfBoundsException("Индекс "+index);
            stringList[index] = item;
        return stringList[index];
    }

    @Override
    public String remove(String item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (stringList[i].equals(item)) index = i;
            continue;
        }
        if (index==-1) throw new IllegalArgumentException("Аргумент " + item);

            for (int j = index; j < size - 1; j++) {
                stringList[j] = stringList[j + 1];
            }
            size--;
            return stringList[index];
          }

    @Override
    public String remove(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("Индекс "+index);
             for (int i = index; i < size - 1; i++) {
                stringList[i] = stringList[i + 1];
            }
            size--;
         return stringList[index];
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (stringList[i].equals(item)) return true;
        }
        return false;

    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (stringList[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (stringList[i].equals(item)) return i;
        }
        return -1;

    }

    @Override
    public String get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("Индекс "+index);
        return stringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) throw new IllegalArgumentException("Аргумент null");
        if (this == otherList) return true;
        if (getClass() != otherList.getClass()) return false;
        StringListImpl that = (StringListImpl) otherList;
        return Arrays.equals(stringList, that.stringList);
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
        for (int i = 0; i < stringList.length; i++) {
            stringList[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] arr = new String[size];

        arr = Arrays.copyOf(stringList, size);
        for (int i = 0; i < size; i++) {
            arr[i] = stringList[i];
        }
        return arr;
    }
}
