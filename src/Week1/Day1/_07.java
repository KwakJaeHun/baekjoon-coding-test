package Week1.Day1;
import java.util.*;

public class _07 {
    public static void main(String[] args) {
        // 인하대학교 컴퓨터공학과를 졸업하기 위해서는, 전공평점이 3.3 이상이거나 졸업고사를 통과해야 한다. 그런데 아뿔싸, 치훈이는 깜빡하고 졸업고사를 응시하지 않았다는 사실을 깨달았다!
        // 치훈이의 전공평점을 계산해주는 프로그램을 작성해보자.
        //
        // 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
        // 인하대학교 컴퓨터공학과의 등급에 따른 과목평점은 다음 표와 같다.
        //
        // A+	4.5
        // A0	4.0
        // B+	3.5
        // B0	3.0
        // C+	2.5
        // C0	2.0
        // D+	1.5
        // D0	1.0
        // F	0.0
        // P/F 과목의 경우 등급이 P또는 F로 표시되는데, 등급이 P인 과목은 계산에서 제외해야 한다.
        //
        // 과연 치훈이는 무사히 졸업할 수 있을까?

        /**
         * 1. Mqp으로 과목 평점 생성
         * 2. for 문을 통해 과목, 학점, 등급을 입력 받음
         * 2-1. 학점이 P가 아닐때 학점 * 과목평점 과 학점의 총합을 계산
         * 3. (학점 * 과목평점) / 학점 총합
         */

        Scanner sc = new Scanner(System.in);

        double gradeRating = 0;
        double gradeSum = 0;
        for(int i = 0; i < 20; i++){
            String subject = sc.next();
            double score = sc.nextDouble();
            String grade = sc.next();

            if(!grade.equals("P")){
                gradeRating += score * getGrade(grade);
                gradeSum    += score;
            }
        }

        System.out.println(gradeRating / gradeSum );
    }

    public static double getGrade(String key){

        Map<String, Double> gradeGraph = new HashMap<>();

        gradeGraph.put("A+", 4.5);
        gradeGraph.put("A0", 4.0);
        gradeGraph.put("B+", 3.5);
        gradeGraph.put("B0", 3.0);
        gradeGraph.put("C+", 2.5);
        gradeGraph.put("C0", 2.0);
        gradeGraph.put("D+", 1.5);
        gradeGraph.put("D0", 1.0);
        gradeGraph.put("F", 0.0);

        return gradeGraph.get(key);
    }
}
