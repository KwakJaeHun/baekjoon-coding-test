package Day5;
import java.util.*;
public class _03 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/10798
        
        Scanner sc = new Scanner(System.in);
        
        // 바깥 ArrayList 생성
        List<ArrayList<String>> al = new ArrayList<>();
        
        // 바깥 ArrayList 안에 ArrayList 넣어주며 최대값 구하기
        int maxSize = 0;
        for (int i = 0; i < 5; i++) {
            String sentence = sc.next();
            ArrayList<String> inAl = new ArrayList<>();
            for (int j = 0; j < sentence.length(); j++) {
                inAl.add(sentence.charAt(j) + "");
            }
            al.add(inAl);

            if(sentence.length() > maxSize){
                maxSize = sentence.length();
            }
        }

        String answer = "";

        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < 5; j++) {
                // row size - 1 (index) 가 i 보다 크거나 같을때만 String 추가
                // ex) 최대 길이 : 7, 3번째 row 길이 : 5일 경우 i가 4일때 까지만 추가
                if(al.get(j).size() -1 >= i){
                    answer += al.get(j).get(i);
                }
            }
        }

        System.out.println(answer);
    }
}
