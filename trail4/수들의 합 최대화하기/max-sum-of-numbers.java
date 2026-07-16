import java.io.*;
import java.util.*;

public class Main {
    private static int n,max=0;
    private static int[][] map;
    private static List<Integer> list=new ArrayList<>();

    private static boolean[] col;
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());
        map=new int[n][n];
        
    
        col=new boolean[n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        per(0,0,0);
        System.out.println(max);
    }

    private static void per(int cnt,int sum,int row){
        if(cnt==n){
        
            max=Math.max(max,sum);
            return;
        }

        for(int i=0;i<n;i++){
        
            if(!col[i]){
     
                col[i]=true;
                per(cnt+1,sum+map[row][i],row+1);
      
                col[i]=false;
            }
        }
    }
}