import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/81302
// tip: each public class is put in its own file
public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        String[][] places = new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        Solution s = new Solution();
        for(int i=0;i<5;i++){
                System.out.println(s.cal(places[i]));
        }
    }
}

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {};
        return answer;
    }

    public int cal(String[] place) {
        char[][] charArr = new char[5][5];

        for(int i=0;i<place.length;i++){
            charArr[i] = place[i].toCharArray();
            
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(charArr[i][j]=='P'){
                    for(int k=i;k<5;k++){
                        for(int l=j+1;l<5;l++){
                            if(charArr[k][l]=='P'){
                                int r1 = i + 1;
                                int c1 = j + 1;
                                int r2 = k + 1;
                                int c2 = l + 1;
                                int distance = Math.abs(r1 - r2) + Math.abs(c1 - c2);
                                //System.out.print(distance + " ");
                                if(distance <= 2){
                                    if(distance == 2){
                                        if(i == k){
                                            if(charArr[k][l-1] != 'X'){
                                                return 0;
                                            }
                                        }else if(j == l){
                                            if(charArr[k-1][l] != 'X'){
                                                return 0;
                                            }
                                        }else{
                                            if(j < l){
                                                if(charArr[i][j+1] != 'X' || charArr[i+1][j] != 'X'){
                                                    return 0;
                                                }
                                            }else{
                                                if(charArr[i][j-1] != 'X' || charArr[i+1][j] != 'X'){
                                                    return 0;
                                                }
                                            }
                                        }
                                    }
                                    else{
                                        return 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return 1;

    }
}
