package Week3.Day05;
import java.io.*;
import java.util.*;
public class _08 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/1713

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            else{
                int minNum = 101;
                int minTicket = 1001;
                if(list.size() == N){
                    for(int l : list){
                        if(minTicket > map.get(l)){
                            minNum = l;
                            minTicket = Math.min(minTicket, map.get(l));
                        }
                    }

                    int index = list.indexOf(minNum);
                    list.remove(index);
                    map.remove(minNum);
                }
                map.put(num, 1);
                list.add(num);
            }
        }

        Collections.sort(list);
        for (int l : list) {
            System.out.println(l);
        }
    }
}
