import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        
        long start = 1;
        long end = 2000000000L;
        long minNum = end;

        while(start < end) {
            long mid = (start+end) / 2;
            if(mid*(mid+1)/2 > s) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        System.out.print(end-1);
    }


}