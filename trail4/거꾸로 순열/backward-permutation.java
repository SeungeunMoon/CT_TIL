import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static boolean[] visited;
    private static List<Integer> list=new ArrayList<>();
    private static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        visited=new boolean[n+1];

        per();

        System.out.println(sb);

    }
    private static void per(){
        if(list.size()==n){
            for(int i=0; i<n ;i++){
                sb.append(list.get(i)).append(' ');
            }
            sb.append('\n');
            return;
        }
        

        for(int i=n;i>=1;i--){
            if(!visited[i]){
                list.add(i);
                visited[i]=true;
                per();
                list.remove(list.size()-1);
                visited[i]=false;
            }
        }

    }
}