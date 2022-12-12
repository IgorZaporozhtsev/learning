package algoexpert.arrays;

import java.util.*;

public class TournamentWinner {
    public static void main(String[] args) {

        var competition_1 = new ArrayList<String>();
        competition_1.add("HTML");
        competition_1.add("Java");

        var competition_2 = new ArrayList<String>();
        competition_2.add("Java");
        competition_2.add("Python");

        var competition_3 = new ArrayList<String>();
        competition_3.add("Python");
        competition_3.add("HTML");

        var competitions = new ArrayList<ArrayList<String>>();
        competitions.add(competition_1);
        competitions.add(competition_2);
        competitions.add(competition_3);

        var results = new ArrayList<>(Arrays.asList(0 ,1, 1));

        String winner = tournamentWinner(competitions , results);
        System.out.printf("Winner is %s%n", winner);
    }

    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
        // home team   away team
        // "HTML, C#"
        // 0 - winner is away team
        // 1 - winner is home team

        /*
            0, 0, 1

            HTML   - 0
            Python - 2
            C#     - 1

      */

        // <count, team>
        var winners = new HashMap<String, Integer>();



        for (int i = 0; i < competitions.size(); i++) {
            String home = competitions.get(i).get(0);
            String away = competitions.get(i).get(1);
            Integer stageResult = results.get(i);


            //home
            if (stageResult == 1){
                winners.putIfAbsent(home, 0);
                int score = winners.get(home);
                winners.put(home, score + 1);

            } else{
                //away
                winners.putIfAbsent(away, 0);
                int score = winners.get(away);
                winners.put(away, score + 1);
            }
        }


         return Collections.max(winners.entrySet(), Map.Entry.comparingByValue()).getKey();



    }
}
