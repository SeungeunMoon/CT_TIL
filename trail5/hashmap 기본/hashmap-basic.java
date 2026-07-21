import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<Integer, Integer> hm = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            switch(cmd) {
                case "add":
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    hm.put(a,b);
                    break;
                case "find":
                    int num = Integer.parseInt(st.nextToken());
                    if(hm.containsKey(num) == true) System.out.println(hm.get(num));
                    else System.out.println("None");
                    break;
                case "remove":
                    int rnum = Integer.parseInt(st.nextToken());
                    hm.remove(rnum);

            }
        }

        


    }
}