// 214624KB	1904ms
package Week3.Day2;
import java.io.*;

public class _06 {
    public static void main(String[] args) throws IOException{

        // https://www.acmicpc.net/problem/8911

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int[] dx = {0, 1,  0, -1}; // 북(0) 동(1) 남(2) 서(3)
            int[] dy = {1, 0, -1,  0};

            int x = 0; int y = 0;
            int maxX = 0; int minX = 0; int maxY = 0; int minY = 0;
            int move = 0; // 거북이가 바라보는 방향

            String[] command = br.readLine().split("");
            for (int j = 0; j < command.length; j++) {
                if(command[j].equals("F")){
                     x += dx[move];
                     y += dy[move];
                }
                else if(command[j].equals("B")){
                    x -= dx[move];
                    y -= dy[move];
                }
                else if(command[j].equals("L")){
                    if(move == 0){
                        move = 3;
                    }
                    else{
                        move = move - 1;
                    }
                }
                else if(command[j].equals("R")){
                    if(move == 3){
                        move = 0;
                    }
                    else{
                        move = move + 1;
                    }
                }

                maxX = Math.max(maxX, x);
                minX = Math.min(minX, x);
                maxY = Math.max(maxY, y);
                minY = Math.min(minY, y);
            }

            int answer = (maxX - minX) * (maxY - minY);
            System.out.println(answer);
        }
    }
}
