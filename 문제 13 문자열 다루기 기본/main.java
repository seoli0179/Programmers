// https://school.programmers.co.kr/learn/courses/30/lessons/12918
// tip: each public class is put in its own file
public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        System.out.println("Hello, world!");
    }
}

class Solution {
    public boolean solution(String s) {
        boolean answer = true;

        try{
            if(s.length() == 4 || s.length() == 6){
                int a = Integer.parseInt(s);
                return true;
            }else{
                return false;
            }
            
        }catch(Exception e){
            return false;
        }
    }
}
