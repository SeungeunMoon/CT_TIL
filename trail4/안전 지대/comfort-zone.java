import java.io.*;
import java.util.*;

public class Main {
    private static int n,m,max=-1,result=0;
    private static int[][] grid;
    private static boolean[][] visited;
    private static int[] dx={1,-1,0,0};
    private static int[] dy={0,0,-1,1};
 

    public static void main(String[] args) throws IOException{
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited=new boolean[n][m];
        
        int k=0;

        grid = new int[n][m];
        for(int i = 0; i < n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                k=Math.max(k,grid[i][j]);
            }
    
        }

        int start=1;
        while(start<=k){
            int cnt=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    visited[i][j]=false;
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++)
                    if(!visited[i][j]&&grid[i][j]>start){
                        visited[i][j]=true;
                        dfs(i,j,start);
                        cnt++;
                    }
            }
            if(max<cnt){
                max=cnt;
                result=start;
            }
            max=Math.max(cnt,max);
            start++;
        }
        System.out.print(result+" "+max);
    }
    private static void dfs(int x,int y,int k){
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 || nx >=n || ny <0 || ny>=m) continue;
            if(visited[nx][ny]) continue;
            if(grid[nx][ny]>k){
                visited[nx][ny]=true;
                dfs(nx,ny,k);
            }
        }
    }

}