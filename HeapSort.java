import java.util.ArrayList;
import java.util.PriorityQueue;

public class HeapSort {
    public static void sort(ArrayList<Integer> list)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<>(list);

        for (int i = 0; i < list.size(); i++)
        {
            list.set(i, heap.poll());
        }
    }
}