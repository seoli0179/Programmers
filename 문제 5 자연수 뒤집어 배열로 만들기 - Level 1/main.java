// https://school.programmers.co.kr/learn/courses/30/lessons/12932
// tip: each public class is put in its own file

public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] answer = s.solution(12345L);
        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i]);
        }
    }
}

class Solution {
    public int[] solution(long n) {
        int[] answer = cal(n);
        return answer;
    }

    public int[] cal(long n) {
        
        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();
        char[] arr = reversed.toCharArray();

        int[] answer = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            answer[i] = arr[i] - '0';
        }

        return answer;

    }

}
