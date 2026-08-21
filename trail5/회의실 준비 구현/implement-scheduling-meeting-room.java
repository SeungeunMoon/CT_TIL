import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int start,end;
        public Edge(int start,int end){
            this.start=start;
            this.end=end;
        }
        @Override
        public int compareTo(Edge o){
            return this.end-o.end;
        }
    }
    private static int n,ans;
    private static List<Edge> meeting =new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            meeting.add(new Edge(start,end));
        }

        Collections.sort(meeting);

        int last=-1;

        for(int i=0;i<n;i++){
            int s=meeting.get(i).start;
            int e=meeting.get(i).end;

            if(last<=s){
                ans++;
                last=e;
            }
        }
        System.out.println(ans);


    }
}