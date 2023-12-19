// tip: each public class is put in its own file
public class main
{
    // https://school.programmers.co.kr/learn/courses/30/lessons/68645
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] answer = s.solution(5);
        for(int i : answer){
            System.out.print(i + ",");
        }
        
    }
}

class Solution {

    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        int[] answer = {};

        int[][] triangle = new int[n][n];        

        int x = 0;
        int y = 0;
        int d = 0;
        int v = 1;

        while (true){
            triangle[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0){
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0){
                    break;
                }
            }
            x = nx;
            y = ny;
        }

        answer = new int[v - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
    }
}
