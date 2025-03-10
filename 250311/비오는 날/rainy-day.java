import java.util.Scanner;

class Forecast {
    String date, day, weather;

    public Forecast(String date, String day, String weather) {
        this.date = date;
        this.day = day;
        this.weather = weather;
    }
    
}

public class Main {
    public static Forecast ans = new Forecast("9999-99-99", "", "");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String date = sc.next();
            String day = sc.next();
            String weather = sc.next();

            Forecast f = new Forecast(date, day,weather);
            if (weather.equals("Rain")){
                if (ans.date.compareTo(f.date)>0)
                    ans = f;
            }
        }

        System.out.printf("%s %s %s", ans.date, ans.day, ans.weather);

    }
}