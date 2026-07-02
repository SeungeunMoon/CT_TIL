import java.util.*;
import java.io.*;
class Pair{
    int x,y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    private static List<Pair> start =new ArrayList<>();
    private static List<Pair> stone=new ArrayList<>();
    private static List<Pair> select=new ArrayList<>();
    private static int n,k,m,result=0;
    private static boolean[][] visited;
    private static int[][] grid;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());

        visited=new boolean[n][n];

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j]==1){
                    stone.add(new Pair(i,j));
                }
            }
        }
     
        for (int i = 0; i < k; i++) {
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken())-1;
            int c=Integer.parseInt(st.nextToken())-1;
            start.add(new Pair(r,c));
        }
        per(0,0);
        System.out.println(result);
        
    }
    // 돌 치울 자리 
    private static void per(int index,int cnt){
       
        if(cnt==m){
            result= Math.max(result,calc());
            return;
        }
        if(index==stone.size()){
            return;
        }
        select.add(stone.get(index));
        per(index+1,cnt+1);
        select.remove(select.size()-1);
        per(index+1,cnt);
        
    }
    private static int calc(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visited[i][j]=false;
            }
        }
        //돌 임시 치우기
        for(int i=0;i<m;i++){
            Pair pos= select.get(i);
            grid[pos.x][pos.y]=0;
        }
        bfs();
        //돌 복구
        for(int i=0;i<m;i++){
            Pair pos= select.get(i);
            grid[pos.x][pos.y]=1;
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]) cnt++;
            }
        }
        return cnt;

    }
    private static void bfs(){
        int[] dx={1,-1,0,0};
        int[] dy={0,0,-1,1};

        Queue<Pair> q=new LinkedList<>();
    
        for(int i=0;i<k;i++){
            q.add(start.get(i));
            visited[start.get(i).x][start.get(i).y]=true;
        }

        while(!q.isEmpty()){
            Pair curr= q.poll();
            int x=curr.x;
            int y=curr.y;
            for(int i=0;i<4;i++){
                int nx=curr.x+dx[i];
                int ny=curr.y+dy[i];

                if(nx>=0 &&nx<n &&ny>=0 &&ny<n &&!visited[nx][ny]&&grid[nx][ny]==0){
                    q.add(new Pair(nx,ny));
                    visited[nx][ny]=true;
                }
            }
        }
    }
}