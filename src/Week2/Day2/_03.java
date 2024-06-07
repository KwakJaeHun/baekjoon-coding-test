package Week2.Day2;
import java.util.*;
public class _03 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/31562

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 아는 노래 개수
        int M = sc.nextInt(); // 맞히기 시도할 노래의 개수
        sc.nextLine();

        HashMap<String, ArrayList<String>> songInfo = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] s = sc.nextLine().split(" ");

            String title = s[1];
            StringBuilder e = new StringBuilder();
            for (int j = 2; j <= 4; j++) {
                e.append(s[j]);
            }

            if(songInfo.containsKey(e.toString())){
                songInfo.get(e.toString()).add(title);
            }
            else{
                ArrayList<String> sArray = new ArrayList<>();
                sArray.add(title);
                songInfo.put(e.toString(), sArray);
            }
        }

        for (int i = 0; i < M; i++) {
            String quiz1 = sc.next();
            String quiz2 = sc.next();
            String quiz3 = sc.next();

            String getTitle = quiz1+quiz2+quiz3;

            if(songInfo.containsKey(getTitle)){
                if(songInfo.get(getTitle).size() == 1){
                    System.out.println(songInfo.get(getTitle).get(0));
                }
                else{
                    System.out.println("?");
                }
            }
            else{
                System.out.println("!");
            }
            
        }
    }
}
