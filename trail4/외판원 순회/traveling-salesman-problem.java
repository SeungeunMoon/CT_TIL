import java.util.*;
import java.io.*;

public class Main {
    private static int n,ans=Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());

        map=new int[n][n];
        visited=new boolean[n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        visited[0]=true;
        dfs(0,1,0);
        System.out.println(ans);

    }
    private static void dfs(int curr, int cnt,int sum){
        
        if(cnt==n){
            if(map[curr][0]>0){
                ans=Math.min(ans,sum+map[curr][0]);
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]&& map[curr][i]>0){
                visited[i]=true;
                dfs(i,cnt+1,sum+map[curr][i]);
                visited[i]=false;
            }
        }
    }
}