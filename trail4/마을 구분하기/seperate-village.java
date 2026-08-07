import java.util.*;
import java.io.*;

public class Main {
    private static int[] dx={1,-1,0,0};
    private static int[] dy={0,0,1,-1};
    private static int n,people;
    private static int[][] map;
    private static boolean[][] visited;
    private static List<Integer> list=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        map=new int[n][n];
        visited=new boolean[n][n];

        StringTokenizer st;
        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
     

        for(int i=0;i<n;i++){
   
            for(int j=0;j<n;j++){
                if(!visited[i][j]&& map[i][j]==1){
                    visited[i][j]=true;
                    people=1;
                    dfs(i,j);
                    list.add(people);
                }
            }
        }
        Collections.sort(list);


        StringBuilder sb=new StringBuilder();

        sb.append(list.size()).append('\n');

        for(int i=0;i<list.size();i++){
            sb.append(list.get(i)).append('\n');
        }
        System.out.println(sb);


    }
    private static void dfs(int x,int y){

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny]==1){
                visited[nx][ny]=true;
                people++;
                dfs(nx,ny);
            }
        }

    }
}