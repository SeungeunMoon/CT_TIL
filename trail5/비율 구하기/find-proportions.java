import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String,Integer> map=new TreeMap<>();
        StringBuilder sb=new StringBuilder();

        int n=Integer.parseInt(br.readLine());
        int total=n;

        while(n>0){
            
            String str=br.readLine();

            map.put(str,map.getOrDefault(str,0)+1);

            n--;
        }
        for(Map.Entry<String,Integer> entry :map.entrySet()){
            double num=(double) entry.getValue()/total *100;

           sb.append(entry.getKey())
              .append(" ")
              .append(String.format("%.4f", num))
              .append("\n");

        
        }
        System.out.print(sb);
    }
}