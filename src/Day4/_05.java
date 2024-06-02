package Day4;
import java.util.*;
public class _05 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/2941

        Scanner sc = new Scanner(System.in);
        String sentence = sc.next();

        String[] words ={"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (int i = 0; i < words.length; i++) {
            if(sentence.contains(words[i])){
                // 처음에 replace를 빈값으로 했더니 문장이 붙으면서 없던 단어가 생성됨, 공백으로 치환해주면서 해결
                sentence = sentence.replace(words[i], " ");
            }
        }
        System.out.println(sentence.length());
    }
}
