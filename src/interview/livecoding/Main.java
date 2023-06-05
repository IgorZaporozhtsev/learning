package interview.livecoding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Record> list = new ArrayList<>();
        List<Record> col = new ArrayList<>();
        list.add(new Record(1L, 0L));
        list.add(new Record(2L, 0L));
        list.add(new Record(8L, 0L));
        list.add(new Record(9L, 0L));

        var old = 0L;

        for (Record record : list) {
            var ts = record.ts;

            if (ts > old - 1){
                for (int i = 0; i < ts - old - 1; i++) {
                    var NewRecord = new Record(ts - i - 1, null);
                    col.add(NewRecord);
                }
            }
            old = ts;
        }

        list.addAll(col);
        System.out.println(list.stream().sorted(Comparator.comparing(Record::getTs)).toList());

    }



    //1,2,8,9
    //1,2,3,8,9

    //1,2,3, 4, 5,6,7, 8,9


    static class Record{

        public Record(Long ts, Long value) {
            this.ts = ts;
            this.value = value;
        }

        Long ts;
        Long value;

        public Long getTs() {
            return ts;
        }

        public void setTs(Long ts) {
            this.ts = ts;
        }

        public Long getValue() {
            return value;
        }

        public void setValue(Long value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return
                    "ts=" + ts ;
        }
    }
}
