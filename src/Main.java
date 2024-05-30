import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();

        Set<Integer> numberSet = new HashSet<>();

        for (int i = firstNumber; i <= secondNumber; i++) {
            numberSet.add(i);
        }

        Map<String, Integer> numberMap = new TreeMap<>();
        for(int s : numberSet){
            String numberString = numberStringReplace(String.valueOf(s));

            numberMap.put(numberString, s);
        }

        int count = 1;
        for(String n : numberMap.keySet()){
            System.out.print(numberMap.get(n) + " ");
            if(count % 10 == 0){
                System.out.println("");
            }
            count++;
        }
    }

    private static String numberStringReplace(String numberString) {

        numberString = numberString.replace("0", "zero");
        numberString = numberString.replace("1", "one");
        numberString = numberString.replace("2", "two");
        numberString = numberString.replace("3", "three");
        numberString = numberString.replace("4", "four");
        numberString = numberString.replace("5", "five");
        numberString = numberString.replace("6", "six");
        numberString = numberString.replace("7", "seven");
        numberString = numberString.replace("8", "eight");
        numberString = numberString.replace("9", "nine");

        return numberString;
    }
}