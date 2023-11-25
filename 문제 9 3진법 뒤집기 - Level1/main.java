// https://school.programmers.co.kr/learn/courses/30/lessons/68935
// tip: each public class is put in its own file
public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        Solution s = new Solution();      
        System.out.println(s.solution(45));
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;

        return conversion(n);
    }

    public static int conversion(int num){

        StringBuilder sb = new StringBuilder();
        int current = num;

        while(current > 0){
            if(current%3<10){
                sb.append(current % 3);
            }else{
                sb.append((char)(current % 3 + '0'));
            }
            current /= 3;
        }

        current = 0;
        char[] charArr = sb.toString().toCharArray();

        for(int i = charArr.length; i>0; i--){
            current += (charArr[i-1] - '0') * Math.pow(3,(charArr.length-i));
        }

        return current;

    }
}
