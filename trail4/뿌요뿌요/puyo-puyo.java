import java.util.*;
import java.io.*;

public class Main {
    private static int n,currCnt,bombCnt=0,maxSize=0;
    private static int[][] map;
    private static int[] dx={1,-1,0,0};
    private static int[] dy={0,0,-1,1};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map=new int[n][n];
        visited=new boolean[n][n];

        StringTokenizer st;

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());        
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    visited[i][j]=true;
                    currCnt=1;
                    dfs(i,j,map[i][j]);

                    if(currCnt>=4){
                        bombCnt++;
                    }
                    maxSize=Math.max(maxSize,currCnt);
                }
            }
        }
        System.out.println(bombCnt+" "+maxSize);
    

    }
    private static void dfs(int x,int y,int curr){

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx <0 || nx >=n || ny<0 || ny>=n) continue;
            if(map[nx][ny]!=curr) continue;
            if(visited[nx][ny]) continue;

            currCnt++;
            visited[nx][ny]=true;
            dfs(nx,ny,curr);
        }
    }
}