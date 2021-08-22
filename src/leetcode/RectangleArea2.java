package leetcode;

//https://leetcode.com/problems/rectangle-area-ii/solution/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * For a rectangle like rec = [1,0,3,1], the first update is to add [1, 3] to the active set at y = 0, and the second update is to remove [1, 3] at y = 1. Note that adding and removing respects multiplicity - if we also added [0, 2] at y = 0, then removing [1, 3] at y = 1 will still leave us with [0, 2] active.
 *
 * This gives us a plan: create these two events for each rectangle, then process all the events in sorted order of y. The issue now is deciding how to process the events add(x1, x2) and remove(x1, x2) such that we are able to query() the total horizontal length of our active intervals.
 *
 * We can use the fact that our remove(...) operation will always be on an interval that was previously added. Let's store all the (x1, x2) intervals in sorted order. Then, we can query() in linear time using a technique similar to a classic LeetCode problem, Merge Intervals.
 Time Complexity: O(N^2 log N), where N is the number of rectangles.
 Space Complexity: O(N)
 */
public class RectangleArea2 {
    public int rectangleArea(int[][] rectangles) {
        int OPEN = 0, CLOSE = 1;
        int [][] events = new int[rectangles.length*2][];
        int t=0;
        for (int[] rec:  rectangles) {
            events[t++] = new int[] {rec[1], OPEN, rec[0], rec[2]};
            events[t++] = new int[] {rec[3], CLOSE, rec[0], rec[2]};
        }

        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        List<int[]> active = new ArrayList<>();
        int prev_y = 0;
        long ans = 0;
        for (int[] event: events) {
            int y = event[0], type = event[1], x1 = event[2], x3 = event[3];

            long query = 0;
            int curX = -1;
            for (int[] xs: active) {
                curX = Math.max(curX, xs[0]);
                query+= Math.max(xs[1] - curX, 0);
                curX = Math.max(curX, xs[1]);
            }

            ans += query*(y-prev_y);

            if (type == CLOSE) {
                for (int[] xs : active) {
                    if (xs[0] == x1 && xs[1] == x3) {
                        active.remove(xs);
                        break;
                    }
                }
            } else {
                active.add(new int[] {x1, x3});
                active.sort(Comparator.comparingInt(a -> a[0]));
            }

            prev_y = y;

        }

        ans %= 1_000_000_007;
        return (int) ans;
    }
}
