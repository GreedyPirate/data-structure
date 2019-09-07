package com.ttyc.chapter1.sequence;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
    public static void main(String[] args) {
        SequenceList<Integer> list = new SequenceList<>(10);
        System.out.println(list.isEmpty());

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);

        list.add(5, 1);
        System.out.println(list);

        list.delete(1);
        System.out.println(list);


        System.out.println(list.getElementLocation(3));
        System.out.println((Integer) list.getElementByIndex(2));

        list.destroy();
        System.out.println(list);

      /*  int[] arr = {5,10,12,0,41,-3,1,9,2,20,6,4,8};
        Separator.separate(arr);*/

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(3);
        ints.add(4);
        ints.add(5);

        ints.add(1,2);
        System.out.println(ints);
    }
}
