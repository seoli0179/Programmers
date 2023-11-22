// https://school.programmers.co.kr/learn/courses/30/lessons/12926
// tip: each public class is put in its own file

public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        Solution s = new Solution();
        String answer = s.solution("a B z", 4);
        System.out.println(answer);
        
    }
}

class Solution {
    public String solution(String s, int n) {
        String answer = cal(s,n);
        return answer;
    }

    public String cal(String s, int n) {
        
        char[] arr = new StringBuilder(s).toString().toCharArray();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 'A' && arr[i] <= 'Z'){
                if(arr[i] + n > 'Z'){
                    arr[i] = (char)(arr[i] + n - 'Z' + 'A' - 1);
                }else{
                    arr[i] += n;
                }
            }else if(arr[i] >= 'a' && arr[i] <= 'z'){
                if(arr[i] + n > 'z'){
                    arr[i] = (char)(arr[i] + n - 'z' + 'a' - 1);
                }else{
                    arr[i] += n;
                }
            }else{
                arr[i] = arr[i];
            }
        }

        return String.valueOf(arr);

    }

}
