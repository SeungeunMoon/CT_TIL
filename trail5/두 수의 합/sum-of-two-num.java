import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        HashMap<Integer,Integer> numbers = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            numbers.put(num, numbers.getOrDefault(num,0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if(numbers.getOrDefault(k-key, -1) != -1){
                if(k-key == key ) answer += (value * (value-1));
                else answer += (value) * numbers.get(k-key);

            }

        }

        System.out.print(answer/2);

    }
}