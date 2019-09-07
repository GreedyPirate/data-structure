package com.ttyc.chapter3.stack.usecase;

import com.ttyc.chapter3.stack.LinkedStack;

import java.util.HashSet;
import java.util.Set;

/**
 * 圆括号、方括号和大括号。编写一个算法，判断表达式中的各种左括号是否与右括号匹配。
 * 例如，输入2+(3+4)*[2+{[3]}]-8，输出匹配正确；输入2+(3+4*[2)+{[3]}-8，输出匹配错误
 */
public class BracketsMatch {
    private static final Set<Character> LEFT = new HashSet<>();
    private static final Set<Character> RIGHT = new HashSet<>();

    static {
        LEFT.add('(');
        LEFT.add('[');
        LEFT.add('{');
        RIGHT.add(')');
        RIGHT.add(']');
        RIGHT.add('}');
    }

    public boolean isMatch(String formula) {
        if(formula == null || formula.length() == 0) {
            throw new IllegalArgumentException("empty string");
        }
        LinkedStack<Character> stack = new LinkedStack<>();
        char[] chars = formula.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(LEFT.contains(aChar)) {
                stack.push(aChar);
            }
            if (RIGHT.contains(aChar)) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
