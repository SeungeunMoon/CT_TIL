import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
    
        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            int num=Integer.parseInt(st.nextToken());
            set1.add(num);
        }

        int n2=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());

        int[] arr=new int[n2];
        for(int i=0;i<n2;i++){
            int num=Integer.parseInt(st.nextToken());
            set2.add(num);
            arr[i]=num;
        }

        for(int i=0;i<n2;i++){
            if(set1.contains(arr[i])){
                arr[i]=1;
            }else{
                arr[i]=0;
            }
        }
        for(int i=0;i<n2;i++){

            System.out.print(arr[i]+" ");
        }

    }
}