package com.ttyc.chapter3.stack;

public class TestCase2 {
    public static void main(String[] args) {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        linkedStack.push(1);
        linkedStack.push(3);
        linkedStack.push(5);
        System.out.println("linkedStack = " + linkedStack);

        Integer po1 = linkedStack.pop();
        System.out.println("po1 = " + po1);
        System.out.println("linkedStack = " + linkedStack);

        Integer po2 = linkedStack.pop();
        System.out.println("po2 = " + po2);
        System.out.println("linkedStack = " + linkedStack);

        Integer po3 = linkedStack.pop();
        System.out.println("po3 = " + po3);
        System.out.println("linkedStack = " + linkedStack);

    }
}
