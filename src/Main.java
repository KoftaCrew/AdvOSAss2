import java.util.Arrays;

public class Main {

    public static int initialPosition;
    public static final int MAX_INDEX = 200;

    public static void main(String[] args) {
        //TODO
        int[] queue = new int[]{98, 183, 37, 122, 14, 124, 65, 67};
        initialPosition = 53;
        System.out.println(Arrays.toString(CSCAN(queue)));
	// write your code here
    }

    public static void printStats(int[] order, int startIndex){
        //TODO
    }

    public static int[] FCFS(int[] queue){
        return queue;
    }

    public static int[] SSTF(int[] q){
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

    public static int[] SCAN(int[] q){
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
        res[j++] = MAX_INDEX;
        j = res.length - 1;
        res[j--] = 0;
        for (int i = 0; i < q.length && i < currentIndex; i++){
            res[j--] = q[i];
        }
        return res;
    }

    public static int[] CSCAN(int[] q){
        int[] res = new int[q.length + 1];
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
        res[j++] = 0;
        for (int i = 0; i < q.length && i < currentIndex; i++){
            res[j++] = q[i];
        }
        return res;
    }



}


