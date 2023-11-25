import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/60057
// tip: each public class is put in its own file
public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.solution("abcabcabcabcdededededede"));
    }
}

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        char[] arr = s.toCharArray();
        String[] arrStr = new String[arr.length];
        Arrays.fill(arrStr, "");

        for(int i=1; i<arr.length+1; i++){
            String str1 = "";
            String str2 = "";
            int count = 1;
            for(int j=0; j<arr.length; j++){                
                if(str1.length() < i){
                    str1 += arr[j];
                    //System.out.println("1["+str1+ ", " + str2 + "] [" + i + ", "+j+"]");
                }else{
                    if(str2.length() < i){
                        str2 += arr[j];
                        //System.out.println("2["+str1+ ", " + str2 + "] [" + i + ", "+j+"]");
                    }else{
                        if(str1.equals(str2)){
                            count++;
                            str2 = "";
                        }else{
                            if(count > 1)
                                arrStr[i-1] += count + str1;
                            else
                                arrStr[i-1] += str1;
                            count = 1;
                            str1 = str2;
                            str2 = "";
                        }
                        j--;
                        //System.out.println("3["+str1+ ", " + str2 + "] [" + i + ", "+j+"]");
                    }
                }
                if(j == arr.length - 1){   
                    if(str1.equals(str2)){
                        count++;
                        arrStr[i-1] += count + str1;
                    }else{
                        if(count > 1)
                            arrStr[i-1] += count + str1 + str2;
                        else
                            arrStr[i-1] += str1 + str2;
                    }
                    //System.out.println("4["+str1+ ", " + str2 + "] [" + i + ", "+j+"]");
                }
                //System.out.println(arrStr[i-1]);
            }
        }

        for(int i =0; i<arr.length; i++){
            answer = Math.min(answer,arrStr[i].length());
            //System.out.println(arrStr[i] + " : " + arrStr[i].length());
        }

        return answer;
    }
}
