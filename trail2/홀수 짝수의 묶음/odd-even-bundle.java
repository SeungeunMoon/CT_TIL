import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());

        int even=0;
        int odd=0;
        for(int i=0;i<n;i++){
            int num=Integer.parseInt(st.nextToken());
            if(num%2==0){
                even++;
            }else{
                odd++;
            }
        }

        //홀수가 더 많으면 홀수를 짝수로 만들어주기
        while(odd>even){
            odd-=2;
            even++;
        }
        if(even>odd){
            even=odd+1; //
        }

        System.out.println(even+odd);
       
    }
}
//짝수 -> 짝수 1 또는 홀수 2개
//홀수 -> 홀수 1개