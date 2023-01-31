package algoexpert.arrays.easy;

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

        var competition_4 = new ArrayList<String>();
        competition_4.add("C#");
        competition_4.add("Python");

        var competition_5 = new ArrayList<String>();
        competition_5.add("Java");
        competition_5.add("C#");

        var competition_6 = new ArrayList<String>();
        competition_6.add("C#");
        competition_6.add("HTML");

        var competitions = new ArrayList<ArrayList<String>>();
        competitions.add(competition_1);
        competitions.add(competition_2);
        competitions.add(competition_3);
        competitions.add(competition_4);
        competitions.add(competition_5);
        competitions.add(competition_6);

        var results = new ArrayList<>(Arrays.asList(0 ,1, 1, 1, 0, 1));

        String winner = tournamentWinner(competitions , results);
        System.out.printf("Winner is %s%n", winner);
    }

    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        // <count, team>
        var participants = new HashMap<String, Integer>();

        for (int i = 0; i < competitions.size(); i++) {
            String home = competitions.get(i).get(0);
            String away = competitions.get(i).get(1);
            participants.putIfAbsent(home, 0);
            Integer stageResult = results.get(i);

            //home
            if (stageResult == 1){
                int score = participants.get(home) + 3;
                participants.put(home, score);
            } else {
                //away
                participants.putIfAbsent(away, 0);
                int score = participants.get(away) + 3;
                participants.put(away, score);
            }
        }





//        Map.Entry<String, Integer> entry = Collections.max(participants.entrySet(), Map.Entry.comparingByValue());
//
//        return entry.getKey();

        return "winner";

    }
    
}
