// https://school.programmers.co.kr/learn/courses/30/lessons/12949
// A 행열 열의 개수 = B 행열 행의 개수
// tip: each public class is put in its own file
public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        int[][] arr1 = new int[][]{{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = new int[][]{{3, 3}, {3, 3}};

        Solution s = new Solution();

        int[][] answer = s.solution(arr1, arr2);

        for(int i=0;i<answer.length;i++){
            for(int j=0;j<answer[i].length;j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Hello, world!");
    }
}

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = cal(arr1,arr2);
        return answer;
    }

    public int[][] cal(int[][] arr1, int[][] arr2){
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[0].length; j++){
                int sum = 0;
                for(int k = 0; k < arr1[i].length; k++){
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }

        return answer;

    }

}
