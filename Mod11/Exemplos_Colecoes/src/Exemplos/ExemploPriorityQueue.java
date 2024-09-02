package Exemplos;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Kadson Lima on 01/09/2024
 *
 * @author Kadson Lima
 */

public class ExemploPriorityQueue {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<String>();
        queue.add("short");
        queue.add("Very long indeed");
        queue.add("Medium");
        while (queue.size() != 0) {
            System.out.println(queue.remove());
        }
    }


}
