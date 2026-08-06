import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int cnt=st.countTokens();

        int[] arr=new int[cnt];

        for(int i=0;i<cnt;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        System.out.println(arr[0]+" "+arr[1]+" "+(arr[cnt-1]-arr[0]-arr[1]));
    }
}