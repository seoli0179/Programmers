// https://school.programmers.co.kr/learn/courses/30/lessons/12916
// tip: each public class is put in its own file
public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        Solution s = new Solution();
        
        System.out.println(s.solution("pPoooyY"));
        System.out.println(s.solution("Pyy"));
    }
}

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] charArr = s.toCharArray();
        int countP = 0;
        int countY = 0;

        for(int i=0; i<charArr.length; i++){
            if(charArr[i] == 'p' || charArr[i] == 'P'){
                countP++;
            }
            if(charArr[i] == 'y' || charArr[i] == 'Y'){
                countY++;
            }
        }

        answer = countP == countY;

        return answer;
    }
}
