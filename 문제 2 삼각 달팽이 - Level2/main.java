import java.util.Arrays;

// tip: each public class is put in its own file
public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] answer = s.solution(2);

        for(int i = 0; i< answer.length; i++)
            System.out.print(answer[i]+" ");
    }

}

class Solution {
        
    public int[] solution(int n) {
        int[] answer = Cal(n);
        return answer;
    }

    public int[] Cal(int n) {

        int arr[][] = new int[n][n];
        for (int i=0;i<n;i++){
            Arrays.fill(arr[i], -1);
        }

        int flag = 0;
        int count = 0;
        int i = 0;
        int j = 0;

        while(true){ 
            if(n==1){
                break;
            } 
            if(n==2){
                arr[0][0] = 1;
                arr[1][0] = 2;
                count = 2;
                i = 1;
                j = 1;
                break;
            }
            if(flag == 0){
                if(i >= n-1){
                    flag = 1;
                }else if(arr[i+1][j] != -1){
                    if(arr[i][j+1] != -1){
                        break;
                    }
                    flag = 1; 
                }
                else{
                    arr[i++][j] = ++count;          
                }
            }
            else if(flag==1){
                if(j >= n-1){
                    flag = 2;
                }else if(arr[i][j+1] != -1){
                    if(arr[i-1][j-1] != -1){
                        break;
                    }
                    flag = 2;
                }
                else{
                    arr[i][j++] = ++count;
                }
            }
            else if(flag==2){
                if(arr[i-1][j-1] != -1){
                    if(arr[i+1][j] != -1){
                        break;
                    }
                    flag = 0;
                }else{
                    arr[i--][j--] = ++count;
                }
            }
        }
        arr[i][j] = ++count;   
        
        int answer[] = new int[count];
        int arrCount = 0;

        for(int k = 0; k < n; k++){
            for(int l = 0; l < n; l++){
                System.out.print(arr[k][l]+"    ");
                if(arr[k][l]!=-1){
                    answer[arrCount++] = arr[k][l];
                }
            }
            System.out.println();
        }

        return answer;

    }

}
