import java.util.Scanner;

class Info {
    String name, address, region;

    public Info(String n, String a, String r) {
        this.name = n;
        this.address =a;
        this.region = r;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        String[] addresses = new String[n];
        String[] regions = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            addresses[i] = sc.next();
            regions[i] = sc.next();
        }
        
        Info[] people = new Info[n];
        int min_idx = 0;
        
        for(int i=0; i < n; i++) {
            people[i] = new Info(names[i], addresses[i], regions[i]);

            if (people[min_idx].name.compareTo(people[i].name) < 0) {
                min_idx = i;
            }
        }

        System.out.println("name "+people[min_idx].name);
        System.out.println("addr "+people[min_idx].address);
        System.out.print("city "+people[min_idx].region);

    }
}