package pro.sky;

public class SortMethods {
    static int[] intList = new int[30000];

    public static void init() {
        for (int i = 0; i < intList.length; i++) {
            intList[i] = (int) ((Math.random() * 1000) - 500);

        }
    }

    private static void swapElements(int indexA, int indexB) {
        int tmp = intList[indexA];
        intList[indexA] = intList[indexB];
        intList[indexB] = tmp;
    }


        public static void sortBubble(int[] intList) {
            for (int i = 0; i < intList.length - 1; i++) {
                for (int j = 0; j < intList.length - 1 - i; j++) {
                    if (intList[j] > intList[j + 1]) {
                        swapElements( j, j + 1);
                    }
                }
            }
        }
    public static void sortSelection(int[] intList) {
        for (int i = 0; i < intList.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < intList.length; j++) {
                if (intList[j] < intList[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] intList) {
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

}
