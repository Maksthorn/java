package LinkedLists;

import java.util.ArrayList;
import java.util.List;

class MinStack {
    int size = 0;
    List<Integer> list;

    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
        size += 1;

    }

    public void pop() {
        list.remove(size - 1);
        size -= 1;
    }

    public int top() {
        return list.get(size -  1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;

        for (int item : list){
            min = Math.min(min, item);
        }

        return min;
    }
}
