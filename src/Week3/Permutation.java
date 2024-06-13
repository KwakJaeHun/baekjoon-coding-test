package Week3;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    static void permutation(int[] arr, int[] result, boolean[] visited, int n, int r, int depth) {

        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                sb.append(result[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                permutation(arr, result, visited, n, r, depth + 1);
                visited[i] = false;
            }
        }
    }
}
