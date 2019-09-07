package com.ttyc.chapter3.usecase;

import com.ttyc.chapter3.stack.SequenceStack;

/**
 * 辗转相除法 10进制转2进制
 */
public class RadixTransform {

    private static final int RADIX = 2;

    public String transform(int number) {
        SequenceStack<Integer> stack = new SequenceStack<>();
        do {
            int value = number / RADIX;
            int mod = number % RADIX;
            stack.push(mod);

            number = value;
        }while (number != 0);

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }
}
