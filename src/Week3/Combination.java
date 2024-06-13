package Week3;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {

        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (visited[i])
                    sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }
}
