import java.util.*;
import java.io.*;

public class Main {
    private static int n,m,t;
    private static int[][] grid;
    private static int[] dx={-1,1,0,0};
    private static int[] dy={0,0,-1,1};
    private static List<Edge> list=new ArrayList<>();
    static class Edge{
        int x,y;
        public Edge(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        t=Integer.parseInt(st.nextToken());

        grid = new int[n][n];

        for (int i = 0; i < n; i++){
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            list.add(new Edge(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1));

        }

        while(t>0){
            move();
            t--;
        }
        System.out.println(list.size());
        
    }
    private static void move(){
        List<Edge> tmp=new ArrayList<>();
        int[][] count=new int[n][n];


        for(int i=0;i<list.size();i++){
            int r=list.get(i).x;
            int c=list.get(i).y;

            int nextX = r;
            int nextY = c;

            int max=0;
       

            for(int j=0;j<4;j++){
                int nx=r+dx[j];
                int ny=c+dy[j];

                if(nx>=0 &&nx<n&& ny>=0&&ny<n){
                   
                        if(grid[nx][ny]>max){
                            max=grid[nx][ny];
                            nextX=nx;
                            nextY=ny;
                        }
                    
                }
            }
            tmp.add(new Edge(nextX, nextY));
            count[nextX][nextY]++;
        }
        list.clear();

        for(Edge e:tmp){
            if(count[e.x][e.y]==1){
                list.add(e);
            }
        }
    }
}