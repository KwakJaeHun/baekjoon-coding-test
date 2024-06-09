package Week2.Day4;
import java.io.*;
import java.util.*;
public class _04 {

    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/11899

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        int add = 0;

        char[] textArray = br.readLine().toCharArray();

        for (int i = 0; i < textArray.length; i++) {
            if(textArray[i] == '('){
                stack.push(textArray[i]);
            }
            else if(!stack.isEmpty() && textArray[i] == ')'){
                stack.pop();
            }
            else{
                add++;
            }
        }

        System.out.println(add + stack.size());
    }
}
