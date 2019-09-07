package com.ttyc.chapter3.stack;

public class TestCase {
    public static void main(String[] args) {
        SequenceStack<Integer> sequenceStack = new SequenceStack<>(3);
        sequenceStack.push(1);
        sequenceStack.push(3);
        sequenceStack.push(5);
//        sequenceStack.push(7);
        System.out.println("sequenceStack = " + sequenceStack);

        Integer top1 = sequenceStack.pop();
        System.out.println("top1 = " + top1);
        System.out.println("sequenceStack = " + sequenceStack);

        Integer top2 = sequenceStack.pop();
        System.out.println("top2 = " + top2);
        System.out.println("sequenceStack = " + sequenceStack);

        Integer top3 = sequenceStack.pop();
        System.out.println("top3 = " + top3);
        System.out.println("sequenceStack = " + sequenceStack);

    }
}
