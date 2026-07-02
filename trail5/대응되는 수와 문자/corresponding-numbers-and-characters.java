import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

    
        Map<String,Integer> map=new HashMap<>();

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
            String[] word=new String[n];

        for(int i=0;i<n;i++){
            String tmp=br.readLine();
            word[i]=tmp;
            map.put(tmp,i+1);
        }
        for(int i=0;i<m;i++){
            String tmp=br.readLine();
            char num=tmp.charAt(0);
          
            if(num>='0' &&num<='9'){
            
                sb.append(word[Integer.parseInt(tmp)-1]);
            }else{
                sb.append(map.get(tmp));
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }
}