import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i=0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        for (int i=0; i < n; i++) {
            System.out.print(nums[i]*nums[i]+" ");
        }
        
    }
}