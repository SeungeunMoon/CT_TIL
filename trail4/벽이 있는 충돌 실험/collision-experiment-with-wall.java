import java.util.*;
import java.io.*;

public class Main {
    static class Edge{
        int x,y, d;
        public Edge(int x,int y,int d){
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }
    private static int t,n,m;
    private static int[] dx={-1,1,-0,0};
    private static int[] dy={0,0,-1,1};
    private static List<Edge> list;

    public static void main(String[] args) throws IOException{
      
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        t= Integer.parseInt(br.readLine());

        while(t-- > 0) {
            st=new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            list=new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st=new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                char d = st.nextToken().charAt(0);
                int dir=-1;
                if(d=='L'){
                    dir=2;
                }else if(d=='R'){
                    dir=3;
                }else if(d=='U'){
                    dir=0;
                }else{
                    dir=1;
                }
                list.add(new Edge(x,y,dir));
            }
            int result =simul(n);
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
    private static int simul(int n){
        for(int i=0;i<n*2;i++){
        
            int[][] count=new int[n+1][n+1];

            for(Edge goosle : list){
                int nx=goosle.x+dx[goosle.d];
                int ny=goosle.y+dy[goosle.d];

                if(nx<1 ||nx>n||ny <1 || ny>n ){
                    goosle.d=reverse(goosle.d);
                }else{
                    goosle.x=nx;
                    goosle.y=ny;
                }

                count[goosle.x][goosle.y]++;

            }
            List<Edge> nextList=new ArrayList<>();
            for(Edge goosle:list){
                if(count[goosle.x][goosle.y]==1){
                    nextList.add(goosle);
                }
            }

            list=nextList;

            if(list.isEmpty()) break;
        }
        return list.size();

        
    }
    private static int reverse(int dir){
        if(dir==1){
                    dir=0;
                }else if(dir==0){
                    dir=1;
                }else if(dir==2){
                    dir=3;
                }else{
                    dir=2;
                }
                return dir;
    }
}