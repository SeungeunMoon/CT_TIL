import java.util.*;
import java.io.*;
public class Main {
    private static int n,m;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx={1,0};
    private static int[] dy={0,1};
    private static boolean flag=false;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited=new boolean[n][m];

        for (int i = 0; i < n; i++){
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0]=true;
        dfs(0,0);
        if(flag) System.out.println(1);
        else System.out.println(0);
        

    }
    private static void dfs(int x,int y){

        if(x==n-1 &&y==m-1){
            flag=true;
            return;
        }
        for(int i=0;i<2;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n &&ny>=0 && ny<m && !visited[nx][ny] &&map[nx][ny]==1){
                visited[nx][ny]=true;
                dfs(nx,ny);
            }
        }
    }
}