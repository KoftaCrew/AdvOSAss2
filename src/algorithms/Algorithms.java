package algorithms;


import java.util.ArrayList;
import java.util.Arrays;

public class Algorithms {
    public static int[] FCFS(int[] queue, int initialPosition, int cylinders){
        return queue;
    }

    public static int[] SSTF(int[] q, int initialPosition, int cylinders){
        int[] res = new int[q.length];
        int currentPosition = initialPosition;
        for (int i = 0; i < q.length; i++){
            int min_diff = (currentPosition - q[i]) >= 0 ? (currentPosition - q[i]) : (q[i] - currentPosition);
            int min_index = i;
            for (int j = i+1; j < q.length; j++){
                int diff = currentPosition - q[j] >= 0 ? currentPosition - q[j] : q[j] - currentPosition;
                if (diff < min_diff){
                    min_diff = diff;
                    min_index = j;
                }
            }
            int temp = q[i];
            q[i] = q[min_index];
            q[min_index] = temp;
            res[i] = q[i];
            currentPosition = res[i];
        }
        return res;
    }

    public static int[] SCAN(int[] q, int initialPosition, int cylinders){
        ArrayList<Integer> res = new ArrayList<Integer>();
        int currentIndex = 0;
        Arrays.sort(q);
        for (int i : q){
            if (i > initialPosition){
                break;
            }
            currentIndex++;
        }

        for (int i = currentIndex; i < q.length; i++) res.add(q[i]);
        if (currentIndex != 0 && currentIndex != q.length) res.add(cylinders);
        for (int i = currentIndex - 1; i >= 0; i--) res.add(q[i]);

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            ret[i] = res.get(i);
        }
        return ret;
    }

    public static int[] CSCAN(int[] q, int initialPosition, int cylinders){
        ArrayList<Integer> res = new ArrayList<Integer>();
        int currentIndex = 0;
        Arrays.sort(q);
        for (int i : q){
            if (i > initialPosition){
                break;
            }
            currentIndex++;
        }
        int j = currentIndex + 1;
        if (currentIndex != q.length) res.add(q[currentIndex]);
        else {
            currentIndex = q.length - 1;
            res.add(0);
        }
        while (j % q.length != currentIndex){
            int i = j % q.length;
            if (i == 0) {
                res.add(cylinders);
                res.add(0);
            }
            j++;
            res.add(q[i]);
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            ret[i] = res.get(i);
        }
        return ret;
    }

    public static int[] LOOK(int[] q, int initialPosition, int cylinders){
        ArrayList<Integer> res = new ArrayList<Integer>();
        int currentIndex = 0;
        Arrays.sort(q);
        for (int i : q){
            if (i > initialPosition){
                break;
            }
            currentIndex++;
        }

        for (int i = currentIndex; i < q.length; i++) res.add(q[i]);
        for (int i = currentIndex - 1; i >= 0; i--) res.add(q[i]);

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            ret[i] = res.get(i);
        }
        return ret;
    }

    public static int[] CLOOK(int[] q, int initialPosition, int cylinders) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int currentIndex = 0;
        Arrays.sort(q);
        for (int i : q) {
            if (i > initialPosition) {
                break;
            }
            currentIndex++;
        }
        int j = currentIndex + 1;
        if (currentIndex != q.length) res.add(q[currentIndex]);
        else {
            currentIndex = q.length - 1;
            j = 0;
        }
        while (j % q.length != currentIndex) {
            int i = j % q.length;
            j++;
            res.add(q[i]);
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}


