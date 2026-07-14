import java.util.*;
import java.io.*;

public class Main {
    private static int n,k,u,d,result=0;
    private static int[][] map;
    private static int[] dx={1,-1,0,0};
    private static int[] dy={0,0,-1,1};
    private static List<Integer> selected=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        u=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());

        map=new int[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        comb(0,0);
        System.out.println(result);

    }
    private static void comb(int index,int cnt){
        if(cnt==k){
            result=Math.max(result,bfs());
            return;
        }

        if(index==n*n){
            return;
        }

        selected.add(index);
        comb(index+1,cnt+1);
        selected.remove(selected.size()-1);

        comb(index+1,cnt);

    }
    private static int bfs(){
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[n][n];

        for(int i=0;i<k;i++){
            int r= selected.get(i)/n;
            int c= selected.get(i)%n;

            q.add(new int[]{r,c});
            visited[r][c]=true;
        }
        int cnt=k;

        while(!q.isEmpty()){
            int[] curr=q.poll();

            for(int i=0;i<4;i++){
                int nx=curr[0]+dx[i];
                int ny=curr[1]+dy[i];

                if(nx>=0&& nx<n &&ny>=0 &&ny<n && !visited[nx][ny]){
                    int diff=Math.abs(map[nx][ny]-map[curr[0]][curr[1]]);
                    if(diff>=u &&diff<=d){
                        visited[nx][ny]=true;
                        q.add(new int[]{nx,ny});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}