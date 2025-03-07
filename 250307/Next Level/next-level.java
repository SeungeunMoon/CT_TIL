import java.util.Scanner;

class User {
    String id;
    int level;

    public User(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public User(){
        this.id = "codetree";
        this.level = 10;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int level = sc.nextInt();
        // Please write your code here.

        User user1 = new User(id, level);
        User user2 = new User();

        System.out.printf("user %s lv %d \n", user2.id, user2.level);
        System.out.printf("user %s lv %d", user1.id, user1.level);
    }
}