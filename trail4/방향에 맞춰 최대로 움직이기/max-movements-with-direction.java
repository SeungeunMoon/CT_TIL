import java.util.*;
import java.io.*;

public class Main {
    private static int n,r,c,max=0;
    private static int[][] map;
    private static int[][] dirMap;
    private static int[] dx={0,-1,-1,0,1,1,1,0,-1};
    private static int[] dy={0,0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        map=new int[n][n];
        dirMap=new int[n+1][n+1];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                dirMap[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken())-1;
        c=Integer.parseInt(st.nextToken())-1;
        
        System.out.println(solve(r, c));

    }
    private static int solve(int x,int y){
        int cnt=0;
        int dir=dirMap[x][y];

        if (dir == 0) return 0;

        int nx=x+dx[dir];
        int ny=y+dy[dir];

        while(nx>=0 &&nx<n &&ny>=0 &&ny<n){
            if(map[nx][ny]>map[x][y]){
                cnt=Math.max(cnt,1+solve(nx,ny));

            }
            nx+=dx[dir];
            ny+=dy[dir];
        }
        return cnt;
    }
}