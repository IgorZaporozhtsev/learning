package JavaCore.Generics;

public class PairTestGenericsHorstman {

    public static void main(String[] args) {

        String[] words = {"Mary", "had", "a", "little", "lamb"};

        Pair<String> mm = ArrayAlg.minmax(words);

        System.out.println("min = " + mm.getFirst());

        System.out.println("max = " + mm.getSecond());
    }
}

class Pair<T> {

    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}

/**
 * Лексиграфичекий порядок это порядок в алфавитном порядке начиная с заглавных (прописных) букв
 * птом сортировка идет на основе прописных
 * https://chortle.ccsu.edu/java5/Notes/chap92/ch92_2.html
 */

class ArrayAlg {

    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) return null;

        String min = a[0];
        String max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) { // 1st < 2nd
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) { // 1st > 2nd
                max = a[i];
            }
        }

        return new Pair<>(min, max);
    }
}
