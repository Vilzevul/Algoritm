package pro.sky;

public class Main {

    public static void main(String[] args) {
        // write your code here
        StringList arr = new StringListImpl();
        String str;
        arr.add("000");
        arr.add("111");
        arr.add("222");
        arr.add("333");
        arr.add("444");
        arr.add("555");
        arr.set(3,"Вместо 333");
        arr.add(2, "121");
        arr.remove(0);
        arr.remove("444");
//        arr.remove(6);
//        arr.remove("777");

        String[] copy = new String[arr.size()];
        copy = arr.toArray();

if(arr.contains("555")) System.out.println("Содержит 555");
        System.out.println("Первый Индекс 333 " + arr.indexOf("333"));
        System.out.println("Последний Индекс 222 " + arr.indexOf("222"));
        System.out.println("Элемент по индексу 3 "+arr.get(3));
if(arr.equals(arr)) System.out.println("Списки равны");
        System.out.println("Размер списка " + arr.size());
        if (arr.isEmpty()) System.out.println("список не пустой");


        for (int i = 0; i < copy.length; i++)
            System.out.println(copy[i]);
    }
}