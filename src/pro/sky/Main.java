package pro.sky;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        StringList arr = new StringListImpl();
        IntList num = new IntListImpl();

        SortMethods.init();
num.add(5);
num.add(7);
num.add(3);
        int[] copy = new int[num.size()];

        System.out.println(num.contains(3));
        copy = num.toArray();
        for (int i = 0; i < copy.length ; i++) {
            System.out.print(copy[i]+" ");
        }
        System.out.println();


        //3 sortInsertion

        int[] insertion = Arrays.copyOf(SortMethods.intList,SortMethods.intList.length);
        long startInsertion = System.currentTimeMillis();
        SortMethods.sortInsertion(insertion);
        long timerInsertion = System.currentTimeMillis() - startInsertion;
        System.out.println("sortInsertion " + timerInsertion);


        //1 sortBubble
        int[] bubble = Arrays.copyOf(SortMethods.intList,SortMethods.intList.length);

        long startBubble = System.currentTimeMillis();
        SortMethods.sortBubble(bubble);
        long timerBubble = System.currentTimeMillis() - startBubble;
        System.out.println("sortBubble " + timerBubble);

        //2 sortSelection

        int[] selection = Arrays.copyOf(SortMethods.intList,SortMethods.intList.length);

        long startSelection = System.currentTimeMillis();
        SortMethods.sortSelection(selection);
        long timerSelection = System.currentTimeMillis() - startSelection;
        System.out.println("sortSelection " + timerSelection);


        //4 sort
        int[] sort;
        sort = SortMethods.intList.clone();

        long startSort = System.currentTimeMillis();
        Arrays.sort(sort);
        long timerSort = System.currentTimeMillis() - startSort;
        System.out.println("Arrays.sort " + timerSort);



    }

}


