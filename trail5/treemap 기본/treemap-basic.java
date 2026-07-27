import java.util.*;
import java.util.Map.*;
import java.io.*;

public class Main {
    private static TreeMap<Integer,Integer> map=new TreeMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int n=Integer.parseInt(br.readLine());

        while(n>0){
            st=new StringTokenizer(br.readLine());
            String type= st.nextToken();


            if(type.equals("add")){
                int k=Integer.parseInt(st.nextToken());
                int v=Integer.parseInt(st.nextToken());
                map.put(k,v);

            }else if(type.equals("find")){
                int k=Integer.parseInt(st.nextToken());
                int num= map.getOrDefault(k,-1);
                if(num!=-1){
                    sb.append(num);
                }else{
                    sb.append("None");
                }
                sb.append('\n');

            }else if(type.equals("remove")){
                int k=Integer.parseInt(st.nextToken());
                map.remove(k);

            }else if(type.equals("print_list")){
                Iterator<Entry<Integer,Integer>> it=map.entrySet().iterator();

                if(!it.hasNext()){
                    sb.append("None");
                }else{
                    while(it.hasNext()){
                        Entry<Integer,Integer> entry=it.next();
                        sb.append(entry.getValue()).append(' ');
                    }
                }
                sb.append('\n');
            }

            n--;
        }


        System.out.print(sb);

    }
}