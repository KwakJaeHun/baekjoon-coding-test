package Week2.Day3;
import java.io.*;
import java.util.*;

public class _01 {
    public static void main(String[] args) throws IOException{

        // https://www.satellitephonestore.com/catalog/sale/details/oneweb-ow1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arrList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            arrList.add(height);
            sum += height;
        }
        
        // 앞에서부터 2개씩 탐색 시작 / j는 i보다 항상 1개씩 커야 두개씩 탐색 가능
        for (int i = 0; i <=7; i++) {
            for (int j = i+1; j <=8 ; j++) {
                if(sum - arrList.get(i) - arrList.get(j) <= 100){
                    arrList.set(i, 0);
                    arrList.set(j, 0);

                    // arrList.remove(Integer.valueOf("0")) 을 활용해 0을 제거 하려 했지만 두번 실행해야 2개가 없어지므로 미진행
                    
                    // 오름차순 정렬
                    Collections.sort(arrList);
                    
                    int loopCount = arrList.size();
                    // 0 두개가 있으므로 index 2부터 출력
                    for(int k = 2; k < loopCount; k++){
                        System.out.println(arrList.get(k));
                    }
                    return;
                }
            }
        }
    }
}
