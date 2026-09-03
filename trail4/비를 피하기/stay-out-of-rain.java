import java.util.*;
import java.io.*;
public class Main {
    private static int n,h,m;
    private static int[][] a;
    private static int[][] result;
    private static List<Edge> rain =new ArrayList<>();

    static class Edge{
        int x,y;
        public Edge(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException{
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
 
        a = new int[n][n];
        for (int i = 0; i < n; i++){
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j]==3){
                    rain.add(new Edge(i,j));
                }
            }
        }
        bfs();

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==2){
                    sb.append(result[i][j]).append(' ');
                }else{
                    sb.append(0).append(' ');
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
    private static void bfs(){
        int[] dx={1,-1,0,0};
        int[] dy={0,0,-1,1};

        //초기화
        result=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(result[i],-1);
        }

        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<rain.size();i++){
            q.add(new int[]{rain.get(i).x,rain.get(i).y,0});
            result[rain.get(i).x][rain.get(i).y]=0;
        }

        while(!q.isEmpty()){
            int[] curr=q.poll();

            for(int i=0;i<4;i++){
                int nx=curr[0]+dx[i];
                int ny=curr[1]+dy[i];

                if(nx<0||nx>=n||ny<0||ny>=n) continue;

                if(a[nx][ny]==1) continue;

                if(result[nx][ny]==-1 || result[nx][ny]> curr[2]+1){
                    q.add(new int[]{nx,ny,curr[2]+1});
                    result[nx][ny]=curr[2]+1;
                }
            }

        }

    }
}

// 이건 반대로 비를 피할 수 있는 공간에서 사람 까지 공간 슛
// 0 : 이동가능 1: 불가능 2: 사람 서있음 3 비 하기 가능