// https://school.programmers.co.kr/learn/courses/30/lessons/81301
// tip: each public class is put in its own file
public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.solution("23four5six7"));
    }
}

class Solution {
    public int solution(String s) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        String[] number = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        char[] charArr = s.toCharArray();

        for(int i=0; i<charArr.length;i++){

            if(charArr[i] >= '0' && charArr[i] <= '9'){
                answer += charArr[i] - '0';
                answer *= 10;
            }else{
                sb.append(charArr[i]);
                for(int j=0; j<number.length; j++){
                    if(sb.toString().equals(number[j])){
                        sb = new StringBuilder();
                        answer += j;
                        answer *= 10;
                    }
                }
            }

        }

        answer /= 10;

        return answer;
    }
}
