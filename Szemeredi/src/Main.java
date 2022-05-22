import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {

        Game game = Game.DataInput();
        int gameIters = 0;
        while (true){
            System.out.println("---------------------" + "Tura nr " + gameIters + "-----------------------");
            System.out.println("Zbiór do gry:");
            System.out.println(game.Set);
            int len1;
            if (gameIters == 0) len1 = game.computerFirstMove(); else len1 = game.ComputerMove();
            if (len1 >= game.k) {
                System.out.println("KOMPUTER WYGRAŁ!");
                Map<Integer, List<Integer>> winning = ProgressionChecker.CheckProgressions(game.ComputerSet);
                int key = winning.keySet().iterator().next();
                System.out.println("Wygrywający ciąg: " + winning.get(key));
                TimeUnit.SECONDS.sleep(5);
                break;
            }
            if(game.checkRemis()) {
                System.out.println("REMIS!");
                System.out.println("Żaden z zawodników nie ułoży już ciągu");
                TimeUnit.SECONDS.sleep(5);
                return;
            }
            System.out.println("Zbiór do gry:");
            System.out.println(game.Set);
            int len2 = game.PlayerMove();
            if (len2 >= game.k) {
                System.out.println("GRACZ WYGRAŁ!");
                Map<Integer, List<Integer>> winning = ProgressionChecker.CheckProgressions(game.PlayerSet);
                int key = winning.keySet().iterator().next();
                System.out.println("Wygrywający ciąg: " + winning.get(key));
                TimeUnit.SECONDS.sleep(5);
                break;
            }
            if(game.checkRemis()) {
                System.out.println("REMIS!");
                System.out.println("Żaden z zawodników nie ułoży już ciągu");
                TimeUnit.SECONDS.sleep(5);
                return;
            }
            gameIters++;
        }
    }
}
