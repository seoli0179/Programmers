import java.util.ArrayList;

public class main
{
    public static void main(String[] args)
    {
        int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};

        Solution s = new Solution();

        String[] str = s.solution(line);

        //System.out.println("Hello, world!" + str[0]);

        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }

    }
}

class Point {

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    int x;
    int y;
}

class Solution {

    public String[] solution(int[][] line) {
        String[] answer = {};
        String test = "";
        
        answer = calculate(line);
        
        return answer;
    }
    
    public String[] calculate(int[][] line) {

        ArrayList<Point> pointArr = new ArrayList<Point>();
        
        String str = "";
        String[] answer;
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        int count = 0;

        
        for(int i = 0; i<line.length-1; i++){
            for(int j = i + 1; j<line.length;j++){
                double x = 0;
                double y = 0;

                double A = line[i][0];
                double B = line[i][1];
                double E = line[i][2];

                double C = line[j][0];
                double D = line[j][1];
                double F = line[j][2];

                if(A*D-B*C!=0){
                    
                    x = ((B * F) - (E * D)) / ((A * D) - (B * C));
                    y = ((E * C) - (A * F)) / ((A * D) - (B * C));
                    
                    if(isInteger(x) && isInteger(y)){
                        
                        int xInt = (int)x;
                        int yInt = (int)y;

                        pointArr.add(new Point(xInt,yInt));
                        
                        minX = Math.min(minX,xInt);
                        minY = Math.min(minY,yInt);
                        maxX = Math.max(maxX,xInt);
                        maxY = Math.max(maxY,yInt);

                        int arrayX = pointArr.get(count).getX();
                        int arrayY = pointArr.get(count).getY();
                        
                        //str += "(" + arrayX + ", " + arrayY + ") ";

                        count++;
                    }
                    
                }

                
            }
        }

        int answerSize;

        if(minY==maxY){
            answerSize = 1;
        }else{
            answerSize = (minY<0)?minY*-1:minY;
            answerSize += maxY + 1;
        }
        

        answer = new String[answerSize];
        
        //str += "min(" + minX + ", " + minY + ") max(" + maxX + ", " + maxY +")" + "\n";
        
        int flag = 0;
        int count2 = 0;
        for(int j = minY ; j <= maxY; j++){
            for(int i = minX ; i <= maxX; i++){
                for(int z = 0; z < pointArr.size();z++){
                    if(i == pointArr.get(z).getX() && j == (pointArr.get(z).getY()*(answerSize==1?1:-1))){
                        str += "*";
                        flag = 1;
                        break;
                    }
                }
                if(flag==0) str += ".";
                flag = 0;
            }
            answer[count2++] = str;
            str = "";
        }
        
        
        return answer;
        
    }
    
    public boolean isInteger(double num) {
        return num % 1 == 0.0;
    }

    
}
