// https://school.programmers.co.kr/learn/courses/30/lessons/70129
// tip: each public class is put in its own file
public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] answer = s.solution("110010101001");
        System.out.println("["+answer[0]+","+answer[1]+"]");
    }
}

class Solution {
    public int[] solution(String s) {      

        StringBuilder sb = new StringBuilder();
        sb.append(s);

        int repeatCount = 0;
        int zeroCount = 0;

        while(!sb.toString().equals("1")){
            repeatCount++;
            char[] charArr = sb.toString().toCharArray();
            sb = new StringBuilder();
            for(int i = 0; i < charArr.length; i++){
                if(charArr[i] == '1'){
                    sb.append("1");
                }else{
                    zeroCount++;
                }
            }
            int n = sb.length();
            sb = new StringBuilder();
            while(n>0){
                sb.append(n%2);
                n /= 2;
            }
        }

        int[] answer = {repeatCount,zeroCount};

        return answer;
    }
}
