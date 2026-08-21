import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static String[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));

        StringBuilder sb=new StringBuilder();
        for(String s: arr){
            sb.append(s);
        }

        System.out.println(sb);
        
    }
}