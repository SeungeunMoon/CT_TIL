import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        TreeMap<Integer, Integer> tm = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch(cmd) {
                case "add":
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    tm.put(a,b);
                    break;
                case "find":
                    int f = Integer.parseInt(st.nextToken());
                    if(tm.getOrDefault(f, -1) != -1) sb.append(tm.get(f)).append("\n");
                    else sb.append("None").append("\n");
                    break;
                case "remove":
                    int r = Integer.parseInt(st.nextToken());
                    tm.remove(r);
                    break;
                case "print_list":
                    Iterator<Entry<Integer,Integer>> it = tm.entrySet().iterator();

                    if(it.hasNext() == false) {
                        sb.append("None").append("\n"); break;
                    }
                    while(it.hasNext()) {
                        Entry<Integer, Integer> entry = it.next();
                        sb.append(entry.getValue()).append(" ");
                    }
                    sb.append("\n");
                    break;
            }
        }

        System.out.print(sb);


    }
}