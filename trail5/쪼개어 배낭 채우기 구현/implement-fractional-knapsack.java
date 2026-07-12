import java.util.*;
import java.io.*;
public class Main {
    private static int n,m;
    private static  Jewel[] jewels;
    static class Jewel implements Comparable<Jewel>{
        int weight;
        int price;
        double value;

        public Jewel(int weight,int price){
            this.weight=weight;
            this.price=price;
            this.value=(double)price/weight;        
        }
        @Override
        public int compareTo(Jewel o){
            if(this.value <o.value) return 1;
            else if(this.value>o.value) return -1;
            return 0;
        }

    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        jewels=new Jewel[n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int weight=Integer.parseInt(st.nextToken());
            int price=Integer.parseInt(st.nextToken());
            jewels[i]=new Jewel(weight,price);
        }

        Arrays.sort(jewels);
        double total=0;
        int remain=m;

        for(int i=0;i<n;i++){
            if(remain==0) break;

            Jewel curr=jewels[i];

            if(curr.weight<=remain){
                total+= curr.price;
                remain-=curr.weight;
            }else{
                total+=remain * curr.value;
                remain=0;
            }


        }

        System.out.printf("%.3f",total);


    }
}