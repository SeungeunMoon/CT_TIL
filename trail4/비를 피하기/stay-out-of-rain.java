import java.util.*;
import java.io.*;

// 0 : 이동
// 1 : 이동 x(벽)
// 2 : 사람
// 3 : 비 피할 수 이음
public class Main {
    private static int[][] map;
    private static int n,h,m;
    private static int[] dx={1,-1,0,0};
    private static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int[][] result=bfs();
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==2){
                sb.append(result[i][j]);
                }else sb.append(0);

                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
        
    }
    private static int[][] bfs(){
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],-1);
        }
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==3){
                    q.add(new int[]{i,j});
                    dist[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0];
            int y=curr[1];
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0 && nx<n &&ny>=0 && ny<n){
                    if(map[nx][ny]!=1 && dist[nx][ny]==-1){
                        dist[nx][ny]=dist[x][y]+1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return dist;
    }
}