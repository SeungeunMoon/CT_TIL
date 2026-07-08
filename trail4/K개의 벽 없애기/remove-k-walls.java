import java.util.*;
import java.io.*;

public class Main {
    private static int n,k;
    private static int[][] map;
    private static Pair start,end;
    private static int[] dx={1,-1,0,0};
    private static int[] dy={0,0,1,-1};
    static class Pair{
        int x,y,dis,wall;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        public Pair(int x,int y,int dis,int wall){
            this.x=x;
            this.y=y;
            this.dis=dis;
            this.wall=wall;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

       
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine());

       int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        start=new Pair(r1-1,c1-1);
        end=new Pair(r2-1,c2-1);

        System.out.println(bfs());
        
    }
    private static int bfs(){
        Queue<Pair> q=new LinkedList<>();
        boolean[][][] visited=new boolean[n][n][k+1];
        q.add(new Pair(start.x,start.y,0,0));
        visited[start.x][start.y][0]=true;

        while(!q.isEmpty()){
            Pair curr= q.poll();
            if(curr.x==end.x && curr.y==end.y){
                return curr.dis;
            }
            for(int i=0;i<4;i++){
                int nx=curr.x+dx[i];
                int ny= curr.y+dy[i];
                if(nx>=0 && nx<n &&ny>=0 &&ny<n &&!visited[nx][ny][curr.wall]){
                    if(map[nx][ny]==1){
                        if(curr.wall<k){
                            q.add(new Pair(nx,ny,curr.dis+1,curr.wall+1));
                            visited[nx][ny][curr.wall+1]=true;
                        }
                    }else{
                        q.add(new Pair(nx,ny,curr.dis+1,curr.wall));
                            visited[nx][ny][curr.wall]=true;
                    }
                }
            }
        }
        return -1;

    }
}