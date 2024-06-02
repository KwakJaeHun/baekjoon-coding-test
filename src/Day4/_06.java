package Day4;
import java.util.*;
public class _06 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/1213
        // 팰린드롬 만들기
        
        Scanner sc = new Scanner(System.in);
        
        String sentence = sc.next();
        
        int[] alphabetArray = new int[26];
        // {0, 0, 0, 0 ....}
        // {A 개수, B 개수, C 개수, D 개수 ....}

        for (int i = 0; i < sentence.length(); i++) {
            // A일때 A(또는 65)를 빼주면 0이 나오고 alphabetArray 의 0번째 index는 A 라는 공식을 활용하여 알파벳이 몇개 있는지 확인
            
            int index = sentence.charAt(i) - (int)'A';
            alphabetArray[index] = alphabetArray[index] + 1;
        }

        int unableCount = 0; // 홀수개의 알파벳이 2개 이상이면 팰린드롬 생성 불가
        int middleAlphabet = 0;
        for(int i = 0; i < alphabetArray.length; i++){
            if(alphabetArray[i] % 2 != 0){
                unableCount++;
                middleAlphabet = i; // 홀수개의 알파벳 인덱스 저장
            }
            
            if(unableCount > 1){
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        String result = "";
        
        // 중간 전까지 문자열 추가
        for (int i = 0; i < alphabetArray.length; i++) {

            // ex ) 위에서 0번째 인덱스에 더해준 갯수의 절반을 result에 추가해준다.
            //      홀수일 경우 : 3 / 2 는 1 이므로 1개를 추가 / 이 후 로직에서 중간에 하나 추가 / 밑에 로직에서 생성된 문자열을 뒤집어서 추가해주면 된다.
            
            for (int j = 0; j < alphabetArray[i] / 2; j++) {
                result += (char) (i + (int) 'A') + ""; // A 또는 65
            }
        }

        // 중간 문자열에 추가할 변수 생성 및 값 할당, 홀수가 한개일때만 값 추가, 짝수개의 알파벳만 있을 경우 추가할 필요 없음
        String middle = "";
        if(unableCount == 1){
            middle = (char) (middleAlphabet + (int) 'A') + "";
        }

        // 중간 전까지 생성된 문자열 + 중간 문자열 변수 + 중간 전까지의 문자 reverse 하여 추가
        result += middle + new StringBuilder(result).reverse();

        System.out.println(result);

    }
}
