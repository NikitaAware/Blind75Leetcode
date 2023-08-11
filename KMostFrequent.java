/*
 * Heap 
 * Min-Heap - root - min
 *  Smallest is popped first
 * Max-heap - root - max
 *  Largest is popped first
 * 
 * Java Heap - min heap by default
 * 
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class KMostFrequent {
    int[] elements;
    int k;

    KMostFrequent(int[] elements, int k) {
        this.elements = elements;
        this.k = k;
    }

    public void printKMostFrequent() {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        Arrays.sort(elements);
        int count = 0;
        int prev = -1;
        for (int i = 0; i <= elements.length; i++) {
            // element changed
            if (i == elements.length || (i < elements.length && prev != elements[i])) {
                if (count > 0) {
                    // add to heap
                    int[] freq = new int[2];
                    freq[0] = prev;
                    freq[1] = count;
                    minHeap.add(freq);

                    // pop the topmost (least frequent)
                    if (minHeap.size() > k) {
                        minHeap.poll();
                    }
                }
                // start counting for the next element
                if (i != elements.length) {
                    count = 1;
                    prev = elements[i];
                }
            } else {
                count++;
            }
        }
        int[] res = new int[minHeap.size()];
        int i = 0;
        while (!minHeap.isEmpty()) {
            res[i] = minHeap.poll()[0];
            i++;
        }
        for (i = 0; i < res.length; i++) {
            System.out.println(res[i] + " ");
        }
    }
}
