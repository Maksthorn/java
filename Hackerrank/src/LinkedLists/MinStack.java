package LinkedLists;

import java.util.ArrayList;
import java.util.List;

class MinStack {
    List<Integer> stack;
    int size = 0;

    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
        size += 1;
    }

    public void pop() {
        stack.remove(size - 1);
        size -= 1;
    }

    public int top() {
        return stack.get(size -1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;


        for(int item : stack){
            min = Math.min(min, stack.get(item));
        }

        return min;
    }
}
