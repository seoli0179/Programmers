// https://school.programmers.co.kr/learn/courses/30/lessons/12930
// tip: each public class is put in its own file
public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.solution("try hEllo world"));
    }
}

class Solution {
    public String solution(String s) {
        String answer = "";

        char[] arr = s.toCharArray();
        int count = 1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ' '){
                count = 1;
            }else{
                if(arr[i] >= 'a' && arr[i] <= 'z'){
                    if(count%2 == 1){
                        arr[i] += 'A' - 'a';
                    }
                } else if(arr[i] >= 'A' && arr[i] <= 'Z'){
                    if(count%2 == 0){
                        arr[i] += 'a' - 'A';
                    }
                }
                count++;
            }
        }

        answer = String.valueOf(arr);

        return answer;
    }
}
