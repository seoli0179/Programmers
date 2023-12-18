import java.util.*;

// tip: each public class is put in its own file
public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        Solution s = new Solution();

        String[] answer = s.solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}});

        for(String str : answer){
            System.out.println(str);
        }

        
    }
}

class Solution {

    public String[] solution(int[][] line) {
        String[] answer = {};

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = Intersection(line[i][0],line[i][1],line[i][2],line[j][0],line[j][1],line[j][2]);
                if(intersection != null) {
                    points.add(intersection);
                }
            }
        }

        Point min = getMinPoint(points);
        Point max = getMaxPoint(points);

        int width = (int) (max.x - min.x + 1);
        int height = (int) (max.y - min.y + 1);

        char[][] arr = new char[height][width];
        for(char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for(Point p : points) {
            int x = (int)(p.x - min.x);
            int y = (int)(max.y - p.y);
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }

        answer = result;


        return answer;
    }

    private Point Intersection(long A, long B, long E, long C, long D, long F) {

        double x = (double)(B * F - E * D) / (A * D - B * C);
        double y = (double)(E * C - A * F) / (A * D - B * C);

        if(x % 1 != 0 || y % 1 != 0) 
            return null;

        return new Point((long)x, (long)y);
    }

    private Point getMinPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for(Point p : points) {
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }

        return new Point(x, y);
    }

    private Point getMaxPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for(Point p : points) {
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }

        return new Point(x, y);
    }

    private static class Point {

        public final long x, y;
        private Point(long x, long y){
            this.x = x;
            this.y = y;
        }

    }

}
