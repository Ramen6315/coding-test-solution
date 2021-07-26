package programmers;

//TODO: 다시 풀어 볼것
public class BigNumberCreator {
    public static void main(String[] args) {
        String name = "4177252841";
        int k = 4;
        System.out.println(solution(name, k));
    }
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        String[] numbers = number.split("");
        for(int j=0, index= -1; j < number.length()-k; j++) {
            String max = "0";
            for(int i=index+1; i<=k+j; i++) {
                if(Integer.parseInt(max) < Integer.parseInt(numbers[i])) {
                    index = i;
                    max = numbers[i];
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
