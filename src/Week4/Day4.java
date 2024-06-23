package Week4;

public class Day4 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/172927

    public static void main(String[] args) {
        int[] picks = {1,0,1};
        String[] minerals = {"stone","stone","stone","stone","stone","diamond"};

        System.out.println(solution(picks, minerals));
    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int[][] fatigueTable = {
                {1, 1, 1},
                {5, 1, 1},
                {25, 5, 1}
        };

        int mineralIndex = 0;

        while (mineralIndex < minerals.length) {
            if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
                break;
            }
            
            // 최소 피로도 곡괭이 찾기
            int minPick = 0;
            int minFatigue  = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                if (picks[i] > 0) {
                    int currentFatigue = 0;
                    for (int j = mineralIndex; j < Math.min(mineralIndex + 5, minerals.length); j++) {
                        if(minerals[j].equals("diamond")){
                            currentFatigue += fatigueTable[i][0];
                        }
                        else if(minerals[j].equals("iron")){
                            currentFatigue += fatigueTable[i][1];
                        }
                        else if(minerals[j].equals("stone")){
                            currentFatigue += fatigueTable[i][2];
                        }
                    }
                    if (currentFatigue <= minFatigue) {
                        minFatigue = currentFatigue;
                        minPick = i;
                    }
                }
            }

            picks[minPick]--;
            int count = 5;

            while (count > 0 && mineralIndex < minerals.length) {
                String mineral = minerals[mineralIndex];
                if(mineral.equals("diamond")){
                    answer += fatigueTable[minPick][0];
                }
                else if(mineral.equals("iron")){
                    answer += fatigueTable[minPick][1];
                }
                else if(mineral.equals("stone")){
                    answer += fatigueTable[minPick][2];
                }
                mineralIndex++;
                count--;
            }
        }
        return answer;
    }
}
