package cources.stepic.base.GCS;

class Pair<First, Second> {

    private final First valueFist;
    private final Second valueSecond;

    private Pair(First valueFist, Second valueSecond) {
        this.valueFist = valueFist;
        this.valueSecond = valueSecond;
    }

    private Pair() {
        this.valueFist = null;
        this.valueSecond = null;
    }


    public First getFirst() {
        return valueFist;
    }

    public Second getSecond() {
        return valueSecond;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (object == null){
            return false;
        }
        if (getClass() != object.getClass()){
            return false;
        }

       // Pair<?, ?> pairEq = (Pair<?, ?>) object;

         Pair <First, Second> pairEq = (Pair<First, Second>) object;


//Элементы пары надо сравнивать на equals() с учетом того, что это может быть null.


        if (valueFist != null && pairEq.valueFist != null) {
            return this.valueFist.equals(pairEq.valueFist);
        }

        if (valueSecond != null && pairEq.valueSecond != null) {
           return this.valueSecond.equals(pairEq.valueSecond);
        }


        return false;
    }

    // тернарный оператор
    // условие ? выражение 1 : выражение 2
    // если ? выполнить это : иначе выполнить это

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + (valueFist == null ? 0 : valueFist.hashCode());
        return hash;
    }

    public static <First, Second> Pair<First, Second> of(First i, Second s) {
        return new Pair<>(i, s);
    }


}
