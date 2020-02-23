package PriorityQueue;

import java.util.PriorityQueue;
import java.util.*;

class Interval {
    int start;
    int end;
    Interval(){start = 0; end = 0;}
    Interval(int s, int e){start = s; end = e;}
}

public class MeetingRooms {
    public int minMeetingRooms(Interval[] intervals){
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (i0, i1) -> (i0.start - i1.start));

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(Interval i : intervals){
            if (heap.size() > 0 && heap.peek() <= i.start){
                heap.poll();
            }

            heap.offer(i.end);
        }
        return heap.size();
    }
}
