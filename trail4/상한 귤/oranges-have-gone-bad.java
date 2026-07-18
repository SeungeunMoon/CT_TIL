import java.util.*;
import java.io.*;

public class Main {
    private static int n,k;
    private static int[][] map;
    private static int[] dx={1,-1,0,0};
    private static int[] dy={0,0,-1,1};

    static class Edge{
        int x,y;
        public Edge(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    private static List<Edge> list=new ArrayList<>();
    private static int[][] time;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        map=new int[n][n];
        time=new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(time[i],-2);    
        }

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());

                if(map[i][j]==2){
                    list.add(new Edge(i,j));
                }

                if(map[i][j]==0){
                    time[i][j]=-1;
                }
            }
        }

        bfs();

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(time[i][j]).append(' ');    
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }

    private static void bfs(){
        Queue<Edge> q=new LinkedList<>();
        boolean[][] visited=new boolean[n][n];

        int t=0;
        for(int i=0;i<list.size();i++){
            int x=list.get(i).x;
            int y=list.get(i).y;

            q.add(list.get(i));
            visited[x][y]=true;
            time[x][y]=t;
        }
        
        while(!q.isEmpty()){
            t++;
            int size=q.size();    
            for(int i=0;i<size;i++){
                Edge curr= q.poll();
                for(int j=0;j<4;j++){
                    int nx=curr.x+dx[j];
                    int ny=curr.y+dy[j];
                    if(nx>=0&& nx<n &&ny>=0 &&ny<n && !visited[nx][ny] && map[nx][ny]==1){
                        q.add(new Edge(nx,ny));
                        visited[nx][ny]=true;
                        time[nx][ny]=t;
                    }
                }
            }
        }


    }
}