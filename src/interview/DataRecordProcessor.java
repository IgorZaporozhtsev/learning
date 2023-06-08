package interview;

import java.util.ArrayList;

//fill date gaps
public class DataRecordProcessor {
    static class DataRecord {
        Long date;
        Long value;

        public DataRecord(Long date, Long value) {
            this.date = date;
            this.value = value;
        }

        public Long getDate() {
            return date;
        }

        public void setDate(Long date) {
            this.date = date;
        }

        public Long getValue() {
            return value;
        }

        public void setValue(Long value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "date: " + date + " \n";
        }
    }

    //1,2   ,3,4,5,6,7  8,9
    public static void main(String[] args) {
        var drList = new ArrayList<DataRecord>();
        var filledDRList = new ArrayList<DataRecord>();
        drList.add(new DataRecord(1L, 0l));
        drList.add(new DataRecord(2L, 0l));
        drList.add(new DataRecord(8L, 0l));
        drList.add(new DataRecord(9L, 0l));

        long oldDate = 0;
        for (int j = 0; j < drList.size(); j++) {
            DataRecord dataRecord = drList.get(j);
            if (dataRecord.date > oldDate + 1) {
                //calculate
                long gapsAmount = dataRecord.date - drList.get(j - 1).date;
                for (long i = 1; i < gapsAmount; i++) {
                    filledDRList.add(new DataRecord((long) j + i, 0l));
                }
            }
            oldDate = dataRecord.date;
            filledDRList.add(dataRecord);
        }
        filledDRList.forEach(System.out::print);
    }
}
