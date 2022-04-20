package algorithms;

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
        int[] res = new int[q.length + 2];
        int currentIndex = 0;
        Arrays.sort(q);
        for (int i : q){
            if (i > initialPosition){
                break;
            }
            currentIndex++;
        }
        int j = 0;
        for (int i = currentIndex; i < q.length && j < res.length; i++){
            res[j++] = q[i];
        }
        res[j++] = cylinders;
        j = res.length - 1;
        res[j--] = 0;
        for (int i = 0; i < q.length && i < currentIndex; i++){
            res[j--] = q[i];
        }
        return res;
    }

    public static int[] CSCAN(int[] q, int initialPosition, int cylinders){
        int[] res = new int[q.length + 2];
        int currentIndex = 0;
        Arrays.sort(q);
        for (int i : q){
            if (i > initialPosition){
                break;
            }
            currentIndex++;
        }
        int j = 0;
        for (int i = currentIndex; i < q.length && j < res.length; i++){
            res[j++] = q[i];
        }
        res[j++] = cylinders;
        res[j++] = 0;
        for (int i = 0; i < q.length && i < currentIndex; i++){
            res[j++] = q[i];
        }
        return res;
    }

    public static int[] LOOK(int[] q, int initialPosition, int cylinders){
        int[] res = new int[q.length];
        int currentIndex = 0;
        Arrays.sort(q);
        for (int i : q){
            if (i > initialPosition){
                break;
            }
            currentIndex++;
        }
        int j = 0;
        for (int i = currentIndex; i < q.length && j < res.length; i++){
            res[j++] = q[i];
        }
        j = q.length - 1;
        for (int i = 0; i < q.length && i < currentIndex; i++){
            res[j--] = q[i];
        }
        return res;
    }

    public static int[] CLOOK(int[] q, int initialPosition, int cylinders){
        int[] res = new int[q.length];
        int currentIndex = 0;
        Arrays.sort(q);
        for (int i : q){
            if (i > initialPosition){
                break;
            }
            currentIndex++;
        }
        int j = 0;
        for (int i = currentIndex; i < q.length && j < res.length; i++){
            res[j++] = q[i];
        }
        for (int i = 0; i < q.length && i < currentIndex; i++){
            res[j++] = q[i];
        }
        return res;
    }

}


