// https://school.programmers.co.kr/learn/courses/30/lessons/81302
public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        
        Solution s = new Solution();
        int[] answer = s.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
        for(int i : answer){
            System.out.println(i+",");
        }
    }
}

class Solution {

    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy = {-1, 0, 0, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for(int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
            if(isDistanced(room)) answer[i] = 1;
            else answer[i] = 0;
        }


        return answer;
    }

    private boolean isDistanced(char[][] room) {

        for(int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if(room[y][x] != 'P') continue;
                if(!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }

    private boolean isDistanced(char[][] room, int x, int y) {

        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(ny < 0 || ny >= room.length) continue;
            if(nx < 0 || nx >= room[ny].length) continue;
            if(room[ny][nx] == 'P') return false;
            if(room[ny][nx] == 'O'){
                if(isNextToValunteer(room, nx, ny, 3-d)) return false;
            }
        }
        return true;
    }

    private boolean isNextToValunteer(char[][] room, int x, int y, int exclude) {

        for(int d = 0; d < 4; d++) {
            if (d == exclude) continue;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(ny < 0 || ny >= room.length) continue;
            if(nx < 0 || nx >= room[ny].length) continue;
            if (room[ny][nx] == 'P') return true;
        }
        return false;

    }

}
