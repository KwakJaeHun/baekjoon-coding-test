// 억지로 푼거 같아서 찜찜...
package Week2.Day3;
import java.util.*;
import java.io.*;
public class _04 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/2805

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]); // 나무 개수
        int M = Integer.parseInt(NM[1]); // 구하고자 하는 나무 크기

        int[] trees = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;

        // 최대 100만번
        for (int i = 0; i < N; i++) {
            int treeHeight = Integer.parseInt(st.nextToken());
            trees[i] = treeHeight;
            max = Math.max(max, treeHeight);
        }

        int answer = 0;
        int start = 0;
        int end = max;

        // start가 end보다 작거나 같을때까지 최대한 탐색한다.
        while (start <= end){

            // 생각을 잘 못 했었다.
            // 문제에서 구하자고 하는 값은 나무를 잘라낸 후의 값을 더하여 구하자고 하는 값과 같은지를 확인.

            // start는 0, end는 제일 큰 나무에서 부터 시작한다.
            // 제일 큰 나무의 절반 값에서 나무들을 잘라본다.
            int middle = (start + end) / 2;
            long getTree = 0;

            // 주어진 나무에서 제일 큰 나무의 절반값을 빼서 잘라진 나무의 합을 구한다.
            for(int tree : trees){
                if(tree > middle){
                    getTree += tree - middle;
                }
            }

            // 잘라진 나무의 값이 얻고자 하는 값보다 크거나 같으면 정답에 middle 값을 넣어준다.
            // 반복문을 돌 수록 더 큰 잘라야하는 값이 나오고 이 때문에 answer에 저장하고 반복문을 계속 진행
            //  middle + 1을 하는 이유는 M과 가장 근사한 값을 구하기 위해 반복문을 돌아 탐색한다.
            if(getTree >= M){
                answer = middle;
                start = middle + 1;
            }
            // 잘라진 나무의 값이 얻고자 하는 값보다 작은 경우 제일 큰나무의 기준을 중간값 - 1으로 해준다.
            // -1을 하는 이유는 절반까지 계산 했으므로 아래의 수와 최솟값을 계산
            else{
                end = middle-1;
            }
        }

        System.out.println(answer);
    }
}
