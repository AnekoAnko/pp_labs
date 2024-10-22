package battles;

import droids.Droid;

import java.util.List;

public class Battle {

    public static String oneOnOne(Droid droid1, Droid droid2) {
        StringBuilder battleLog = new StringBuilder();
        int i = 0, j = 0;

        while (droid1.getHealth() > 0 && droid2.getHealth() > 0) {
            if (i == 3) {
                droid1.skill(droid2);
                battleLog.append(droid1.getName()).append(" uses his special skill!").append("\n");
                i = 0; 
            } else {
                droid1.attack(droid2);
                battleLog.append(droid1.getName()).append(" attacks ").append(droid2.getName()).append("\n");
            }
            i++;


            if (droid2.getHealth() > 0) {
                if (j == 3) {
                    droid2.skill(droid1);
                    battleLog.append(droid2.getName()).append(" uses his special skill!").append("\n");
                    j = 0; 
                    droid2.attack(droid1);
                    battleLog.append(droid2.getName()).append(" attacks ").append(droid1.getName()).append("\n");
                }
                j++;
            }
        }

        String result = droid1.getHealth() > 0 ? droid1.getName() + " wins!" : droid2.getName() + " wins!";
        battleLog.append(result).append("\n");
        return battleLog.toString();
    }

    public static String teamBattle(List<Droid> team1, List<Droid> team2) {
        StringBuilder battleLog = new StringBuilder();
        
        while (!team1.isEmpty() && !team2.isEmpty()) {
            Droid droid1 = team1.get(0);
            Droid droid2 = team2.get(0);
            battleLog.append(oneOnOne(droid1, droid2));
            
            if (droid1.getHealth() <= 0) {
                team1.remove(droid1);
            }
            if (droid2.getHealth() <= 0) {
                team2.remove(droid2);
            }
        }

        String result = team1.isEmpty() ? "Team 2 wins!" : "Team 1 wins!";
        battleLog.append(result).append("\n");
        return battleLog.toString();
    }
}
