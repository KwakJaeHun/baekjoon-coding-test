package Week4;
import java.util.*;
public class Day2 {
    public static void main(String[] args) {

        // https://school.programmers.co.kr/learn/courses/30/lessons/178870

        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;

        System.out.println(Arrays.toString(solution(sequence, k)));
    }

    public static int[] solution(int[] sequence, int k) {

        int startIndex = 0;
        int endIndex = 0;
        int sum = sequence[0];
        int sumLength = Integer.MAX_VALUE;
        int shortStartIndex = 0;
        int shortEndIndex = 0;

        while(startIndex <= sequence.length - 1){

            if(k > sum){
                if(endIndex < sequence.length - 1){
                    endIndex++;
                    sum += sequence[endIndex];
                }
                else{
                    sum -= sequence[startIndex];
                    startIndex++;
                }
            }
            else if(k < sum){
                sum -= sequence[startIndex];
                startIndex++;

            }
            else if(k == sum){
                if(sumLength > endIndex - startIndex){
                    sumLength = endIndex - startIndex;
                    shortStartIndex = startIndex;
                    shortEndIndex = endIndex;
                }

                if(endIndex < sequence.length - 1){
                    endIndex++;
                    sum += sequence[endIndex];
                }
                else if(startIndex < sequence.length - 1){
                    sum -= sequence[startIndex];
                    startIndex++;
                }
                else{
                    break;
                }
            }
        }

        return new int[]{shortStartIndex, shortEndIndex};
    }
}
