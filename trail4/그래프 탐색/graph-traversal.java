import java.util.*;
import java.io.*;
public class Main {
    private static int n,m,cnt=0;
   
    private static List<Integer>[] list;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        list=new ArrayList[n+1];
        visited=new boolean[n+1];

        for(int i=0;i<n+1;i++){
            list[i]=new ArrayList<>();
        }
       
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        visited[1]=true;
        dfs(1);
        System.out.println(cnt);
        // Please write your code here.
    }
    private static void dfs(int vertex){

        for(int i=0;i<list[vertex].size();i++){
            int curr=list[vertex].get(i);
            if(!visited[curr]){
                visited[curr]=true;
                cnt++;
                dfs(curr);
            }
        }
    }
}