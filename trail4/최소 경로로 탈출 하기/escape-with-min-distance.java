import java.util.*;
import java.io.*;

public class Main {
    static class Pair{
        int x,y,dis;
        public Pair(int x,int y,int dis){
            this.x=x;
            this.y=y;
            this.dis=dis;
        }
    }    
    private static int n,m;
    private static int[][] map;
    private static int[] dx={1,-1,0,0};
    private static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++){
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        int result=bfs();
        System.out.println(result);



    }
    private static int bfs(){
        Queue<Pair> q=new LinkedList<>();
        boolean[][] visited =new boolean[n][m];

        q.add(new Pair(0,0,0));
        visited[0][0]=true;

        while(!q.isEmpty()){
            Pair curr=q.poll();

            if(curr.x==n-1 && curr.y==m-1){
                return curr.dis;
            }
            for(int i=0;i<4;i++){
                int nx=curr.x+dx[i];
                int ny=curr.y+dy[i];
                if(nx>=0 &&nx<n &&ny>=0 &&ny <m &&!visited[nx][ny] && map[nx][ny]==1){
                    q.add(new Pair(nx,ny,curr.dis+1));
                    visited[nx][ny]=true;
                }
            }
        }
        return -1;
    }
}