import java.util.*;
import java.io.*;

public class Main {
    static class Pair{
        int x,y,dis;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        public Pair(int x,int y,int dis){
            this.x=x;
            this.y=y;
            this.dis=dis;
        }
    }
    private static int n;
    private static Pair start,end;
    private static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n= Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        start = new Pair(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1);
        end = new Pair(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1);
        System.out.println(bfs());
    }
    private static int bfs(){
        Queue<Pair> q=new LinkedList<>();
        boolean[][] visited=new boolean[n][n];

        q.add(new Pair(start.x,start.y,0));
        visited[start.x][start.y]=true;

        while(!q.isEmpty()){
            Pair curr= q.poll();
            if(curr.x==end.x && curr.y==end.y){
                return curr.dis;
            }
            for(int i=0;i<8;i++){
                int nx= curr.x+dx[i];
                int ny= curr.y+dy[i];
                if(nx>=0 && nx<n &&ny>=0 && ny<n && !visited[nx][ny]){
                    q.add(new Pair(nx,ny,curr.dis+1));
                    visited[nx][ny]=true;
                }
            }
        }
        return -1;
    }
}