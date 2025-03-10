import java.util.Scanner;

class Agent {

    String name;
    int score;

    public Agent(String n, int s) {
        this.name = n;
        this.score = s;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Agent[] agents = new Agent[5];
        for(int i=0; i<5; i++){
            String name = sc.next();
            int score = sc.nextInt();

            agents[i] = new Agent(name, score);
        }

        int min_agent_idx = 0;
        for (int i = 0; i<5; i++){
            if (agents[min_agent_idx].score > agents[i].score){
                min_agent_idx = i;
            }
        }

        System.out.print(agents[min_agent_idx].name + " " +agents[min_agent_idx].score);

    }
}