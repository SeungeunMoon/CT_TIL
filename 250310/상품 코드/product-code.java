import java.util.Scanner;

class Product {
    String name;
    int code;

    public Product(String n, int c) {
        this.name = n;
        this.code = c;
    }
    public Product() {
        this.name = "codetree";
        this.code = 50;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name2 = sc.next();
        int code2 = sc.nextInt();

        Product p1 = new Product();
        Product p2 = new Product(name2, code2);

        System.out.printf("product %d is %s\n", p1.code, p1.name);
        System.out.printf("product %d is %s", p2.code, p2.name);
        


    }
}