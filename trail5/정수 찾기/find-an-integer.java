import java.util.*;
import java.io.*;
public class Main {
    private static int n,m;
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Set<Integer> set=new HashSet<>();


        n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        m=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<m;i++){
            int num=Integer.parseInt(st.nextToken());
            if(set.contains(num)){
                sb.append(1);
            }else{
                sb.append(0);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}