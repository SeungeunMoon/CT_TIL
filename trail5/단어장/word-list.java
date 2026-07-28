import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        TreeMap<String,Integer> map=new TreeMap<>();
        int n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String str= br.readLine();

            map.put(str,map.getOrDefault(str,0)+1);
        }
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append('\n');
        }
        System.out.print(sb);

    }
}