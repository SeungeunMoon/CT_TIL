import java.util.*;
import java.io.*;

public class Main {
    private static boolean[] visited;
    private static List<Integer> list=new ArrayList<>();
    private static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        visited=new boolean[n+1];
        per(0,n);
        System.out.print(sb);
    }
    private static void per(int cnt,int n){
        if(cnt==n){
            for(int i=0;i<n;i++){
                sb.append(list.get(i)).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                list.add(i);
                visited[i]=true;

                per(cnt+1,n);
                list.remove(list.size()-1);
                visited[i]=false;
            }
        }
    }
}