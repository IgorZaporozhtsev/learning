package algoexpert.codewars;

public class ComplementaryDNA {
    public static void main(String[] args) {
        //"ATTGC" --> "TAACG"
        //"GTAT" --> "CATA"
        String dna1 = "ATTGC";
        String dna2 = "GTAT";

        System.out.println(makeComplement(dna1));
    }

    private static String makeComplement(String dna) {
        String[] split = dna.split("");
        StringBuilder builder = new StringBuilder();
        for (String s : split) {
            String replace = "";
            if (s.equals("A")){
                replace = s.replace('A', 'T');
            } else if (s.equals("T")){
                replace = s.replace('T', 'A');
            } else if (s.equals("C")) {
                replace = s.replace('C', 'G');
            } else if (s.equals("G")) {
                replace = s.replace('G', 'C');
            }
            builder.append(replace);
        }

        return builder.toString();
    }
}
