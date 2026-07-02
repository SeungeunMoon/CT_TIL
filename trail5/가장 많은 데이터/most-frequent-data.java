import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        Map<String,Integer> map=new HashMap<>();
    
        String[] word=new String[100000];
        int result=0;

        for(int i=0;i<n;i++){
            word[i]=br.readLine();
        }
        for(int i=0;i<n;i++){
            if(!map.containsKey(word[i])){
                map.put(word[i],1);
            }else{
                map.put(word[i],map.get(word[i])+1);
            }
            result=Math.max(result, map.get(word[i]));
        }
        System.out.println(result);
    }
}