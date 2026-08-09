import java.util.*;
import java.io.*;
public class Main {
    private static int n,m;
    static class Line{
        int a,b;
        public Line(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    private static List<Line> lines=new ArrayList<>();
    private static List<Line> selected =new ArrayList<>();
    private static int[] origin;
    private static int ans=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            lines.add(new Line(a,b));
        }

        origin=runLadder(lines);
        backtracking(0);
        System.out.println(ans);
    }
    private static void backtracking(int idx){
        if(idx==m){
            int[] curr=runLadder(selected);
            if(Arrays.equals(origin,curr)){
                ans=Math.min(ans,selected.size());
            }
            return;
        }

        //가로줄 선택
        selected.add(lines.get(idx));
        backtracking(idx+1);
        selected.remove(selected.size()-1);

        //2. 선택 안함
        backtracking(idx+1);
    }
    private static int[] runLadder(List<Line> lineList){
        int[] result=new int[n+1];

        for(int i=1;i<=n;i++){
            int currNum=i;

            //(높이 b) 순서대로 가로줄 처리
            //높이 b가 1부터 15까지 
            for(int height=1;height<=15;height++){
                for(Line line : lineList){
                    if(line.b==height){
                        if(line.a==currNum){
                            currNum++;
                        }else if(line.a+1==currNum){
                            currNum--;
                        }
                    }
                }
            }
            result[i]=currNum;
        }
        return result;

    }
}