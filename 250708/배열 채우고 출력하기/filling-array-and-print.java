import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputA = sc.nextLine();
        String[] arr = inputA.split(" ");

        for (int i=arr.length-1; i >= 0; i--){
            System.out.print(arr[i]);
        }
    }
}