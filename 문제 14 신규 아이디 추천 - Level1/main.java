// tip: each public class is put in its own file
public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(s.solution("z-+.^."));
        System.out.println(s.solution("=.="));
        System.out.println(s.solution("123_.def"));
        System.out.println(s.solution("abcdefghijklmn.p"));
    }
}

class Solution {
    public String solution(String new_id) {
        String answer = "";

        char[] charArr = new_id.toCharArray();

        // 1단계
        for(int i=0;i<charArr.length;i++){
            if(charArr[i]>='A' && charArr[i]<='Z'){
                charArr[i] = (char)(charArr[i] + 'a' - 'A');
            }
        }

        // 2단계
        String temp = "";
        for(int i=0;i<charArr.length;i++){
            if(charArr[i]>='a' && charArr[i]<='z'){
                temp += charArr[i];
            }else if(charArr[i]>='0' && charArr[i]<='9'){
                temp += charArr[i];
            }else if(charArr[i]=='-'){
                temp += charArr[i];
            }else if(charArr[i]=='_'){
                temp += charArr[i];
            }else if(charArr[i]=='.'){
                temp += charArr[i];
            }else{

            }
        }

        charArr = temp.toCharArray();

        // 3단계
        temp = "";
        int flag = 0;
        for(int i=0;i<charArr.length-1;i++){
            if(charArr[i]=='.'&&charArr[i+1]=='.'){
                flag = 1;
            }else{
                if(flag == 1){
                    temp += '.';
                    flag = 0;
                }else{
                    temp += charArr[i];
                }
            }
        }
        if(flag == 1){
            temp += '.';
            flag = 0;
        }else{
            temp += charArr[charArr.length-1];
        }
        charArr = temp.toCharArray();

        // 4단계
        if(charArr.length >= 1 && charArr[0] == '.'){
            temp = "";
            for(int i=1;i<charArr.length;i++){
                temp += charArr[i];
            }
        }
        charArr = temp.toCharArray();

        if(charArr.length >= 1 && charArr[charArr.length - 1] == '.'){
            temp = "";
            for(int i=0;i<charArr.length-1;i++){
                temp += charArr[i];
            }
        }
        charArr = temp.toCharArray();

        // 5단계
        if(charArr.length == 0){
            temp = "a";
        }
        charArr = temp.toCharArray();

        // 6단계
        if(charArr.length >= 16){
            temp = "";
            for(int i=0;i<15;i++){
                temp += charArr[i];
            }
        }
        charArr = temp.toCharArray();
        if(charArr[charArr.length - 1] == '.'){
            temp = "";
            for(int i=0;i<charArr.length-1;i++){
                temp += charArr[i];
            }
        }
        charArr = temp.toCharArray();

        // 7단계계
        temp = String.valueOf(charArr);
        while(temp.length()<=2){
            char charTemp = charArr[charArr.length-1];
            temp += charTemp;
        }
        charArr = temp.toCharArray();

        answer = String.valueOf(charArr);


        return answer;
    }
}
