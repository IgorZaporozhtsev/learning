package algoexpert.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TournamentWinner2 {

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

        var competition_4 = new ArrayList<String>();
        competition_4.add("C#");
        competition_4.add("Python");

        var competition_5 = new ArrayList<String>();
        competition_5.add("Java");
        competition_5.add("C#");



        var competitions = new ArrayList<ArrayList<String>>();
        competitions.add(competition_1);
        competitions.add(competition_2);
        competitions.add(competition_3);
       // competitions.add(competition_4);
       // competitions.add(competition_5);

        var results = new ArrayList<>(Arrays.asList(0, 0, 1)); //1- home 0 - away

        String winner = tournamentWinner(competitions , results);
        System.out.printf("Winner is %s%n", winner);
    }

    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        var participants = new HashMap<String, Integer>();
        participants.put("", 0);
        var winner = "";

        //[homeTeam, awayTeam]

        for (int i = 0; i < competitions.size(); i++) {
            String home = competitions.get(i).get(0);
            String away = competitions.get(i).get(1);

            //home team won
            if (results.get(i) == 1){
                Integer score = participants.getOrDefault(home, 0);
                participants.put(home, score + 3);

                winner = defineWinner(participants, winner, home);
            }
            //away team won
            else {
                Integer score = participants.getOrDefault(away, 0);
                participants.put(away, score + 3);

                winner = defineWinner(participants, winner, away);
            }
        }

        return winner;
    }

    private static String defineWinner(HashMap<String, Integer> participants, String winner, String away) {
        if (participants.getOrDefault(away, 0) >= participants.get(winner)){
            winner = away;
        }
        return winner;
    }
}
