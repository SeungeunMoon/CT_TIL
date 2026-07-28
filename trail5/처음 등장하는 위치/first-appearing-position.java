import java.util.*;
import java.io.*;

public class Main {
    private static TreeMap<Integer, Integer>  map=new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());

        for(int i=1;i<=n;i++){
            int num=Integer.parseInt(st.nextToken());

            if(!map.containsKey(num)){
                map.put(num,i);
            }
        }

        StringBuilder sb=new StringBuilder();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append('\n');
        }
        System.out.print(sb);

    }
}