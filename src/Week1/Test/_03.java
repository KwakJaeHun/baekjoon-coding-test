package Week1.Test;
import java.util.*;
public class _03 {
    // https://www.acmicpc.net/problem/3107

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.next();
        
        // ::를 **** 로 치환, 밑에서 **** 발견시 0000 넣어주기 위함.
        if(sentence.contains("::")){
            sentence = sentence.replace("::", ":****:");
        }

        String[] sentenceArray = sentence.split(":");
        
        // 공백이 아닌 요소만 넣어 List 생성
        List<String> setenceList = new ArrayList<>();
        for (int i = 0; i < sentenceArray.length; i++) {
            if(!sentenceArray[i].isEmpty()){
                setenceList.add(String.format("%4s", sentenceArray[i]).replace(" ", "0")); // 4자리 이하인 경우 0을 4자리까지 채워서 List에 추가
            }
        }
        
        String[] answer = new String[8];
        
        // 0000을 넣어줘야 하는 횟수 >  :: 를 :****: 로 치환해서 넣어줬기 때문에 + 1
        int addZeroCount = 8 - setenceList.size() + 1;
        
        // **** 발견시 index를 알기 위한 카운트
        int count = 0;
        for (int i = 0; i < setenceList.size(); i++) {
            if(setenceList.get(i).equals("****")){
                for (int j = 0; j < addZeroCount; j++) {
                    answer[count] = "0000";
                    count++;
                }
            }
            else{
                answer[count] = setenceList.get(i);
                count++;
            }
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
            if(i != answer.length -1){
                System.out.print(":");
            }
        }
    }

}
