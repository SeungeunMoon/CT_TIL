import java.util.*;
import java.io.*;

public class Main {
    static class Edge{
        int a,b;
        public Edge(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    private static int n,m,ans=Integer.MAX_VALUE;
    private static List<Edge> list=new ArrayList<>();
    private static List<Edge> selected=new ArrayList<>();
    private static int[] origin;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        origin=new int[n+1];

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list.add(new Edge(a,b));
        }

        origin=calculate(list);
        dfs(0);
        System.out.println(ans);

        
    }
    private static void dfs(int idx){
        if(idx==m){
            int[] curr= calculate(selected);
            if(Arrays.equals(origin,curr)){
                ans=Math.min(ans,selected.size());
            }
            return;
        }
        //선택
        selected.add(list.get(idx));
        dfs(idx+1);
        selected.remove(selected.size()-1);
        //선택X
        dfs(idx+1);
    }
    private static int[] calculate(List<Edge> curr){
        int[] result=new int[n+1];

        for(int i=1;i<n+1;i++){
            int index=i;

            for(int height=1;height<=15;height++){
                for(Edge line: curr){
                    if(line.b==height){
                        if(line.a==index){
                            index++;
                        }else if(line.a==index-1){
                            index--;
                        }
                    }
                }
            }
            result[i]=index;
        }
        return result;
    }
}