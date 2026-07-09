// Last updated: 7/9/2026, 3:01:38 PM
import java.util.*;

class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.offer(val);

        if (pq.size() > k)
            pq.poll();

        return pq.peek();
    }
}