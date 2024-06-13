package Week3.Day2;
import java.util.*;
import java.io.*;
class ExhaustiveSearch {

    // https://www.acmicpc.net/problem/1759

    static int L, C;
    static String[] arr;
    static boolean[] visited;
    static ArrayList<String> answer = new ArrayList<>();
    static Set<String> moms = Set.of("a", "e", "i", "o", "u");

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[C];
        arr = new String[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);

        combination(0, L, 0, 0);

        for(String s : answer){
            System.out.println(s);
        }
    }

    private static void combination(int start, int r, int momCount, int sonCount){

        if(r == 0){
            if(momCount >= 1 && sonCount >= 2){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < C; i++) {
                    if(visited[i]){
                        sb.append(arr[i]);
                    }
                }
                answer.add(sb.toString());
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if(!visited[i]){
                visited[i] = true;
                if(moms.contains(arr[i])){
                    combination(i + 1, r-1, momCount + 1, sonCount);
                }
                else{
                    combination(i + 1, r-1, momCount, sonCount+1);
                }
            }
            visited[i] = false;
        }
    }
}

