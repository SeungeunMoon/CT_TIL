import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Forecast {
    String date, day, weather;

    public Forecast(String date, String day, String weather) {
        this.date = date;
        this.day = day;
        this.weather = weather;
    }
    
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 0;

        Forecast[] forecasts = new Forecast[n];
        for (int i = 0; i < n; i++) {
            String date = sc.next();
            String day = sc.next();
            String weather = sc.next();

            if (weather.equals("Rain")){
                forecasts[m] = new Forecast(date, day, weather);
                m++;
            }
        }
        
        int idx = 0;
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");

        for (int j = 0; j < m; j++) {
            try {
                Date d1,d2;
                d1 = dateFormat.parse(forecasts[idx].date);
                d2 = dateFormat.parse(forecasts[j].date);

                if (d1.compareTo(d2) > 0) {
                    idx = j;
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("%s %s %s", forecasts[idx].date, forecasts[idx].day, forecasts[idx].weather);

    }
}