import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.next();
        char place = sc.next().charAt(0);
        int time = sc.nextInt();

        class Zerozeroseven {
            String code;
            char place;
            int time;

            public Zerozeroseven(String code, char place, int time) {
                this.code = code;
                this.place =place;
                this.time = time;
            }

        }
        Zerozeroseven z1 = new Zerozeroseven(code, place, time);

        System.out.println("secret code : "+ z1.code);
        System.out.println("meeting point : "+z1.place);
        System.out.println("time : "+z1.time);

        
    }
}