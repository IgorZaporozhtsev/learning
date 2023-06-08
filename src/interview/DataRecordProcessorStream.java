package interview;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

//fill date gaps
public class DataRecordProcessorStream {
    static class DataRecord {
        LocalDate date;
        Long value;

        public DataRecord(LocalDate date, Long value) {
            this.date = date;
            this.value = value;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
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
        drList.add(new DataRecord(LocalDate.of(2023, 3, 1), 0l));
        drList.add(new DataRecord(LocalDate.of(2023, 3, 2), 0l));
        drList.add(new DataRecord(LocalDate.of(2023, 3, 8), 0l));
        drList.add(new DataRecord(LocalDate.of(2023, 3, 9), 0l));

        LocalDate oldDate = drList.get(0).date;

        for (DataRecord dataRecord: drList) {
            LocalDate currentDate = dataRecord.date;
            if (currentDate.isAfter(oldDate.plus(Period.ofDays(1)))) {

                //calculate the GAP current date - old date minus one
                var gapsAmount = ChronoUnit.DAYS.between( oldDate, currentDate) - 1;

                for (int i = 0; i < gapsAmount; i++) {
                    filledDRList.add(
                            new DataRecord(
                                    currentDate.minus(Period.ofDays((int)gapsAmount - i)),
                                    0l)
                    );
                }
            }
            oldDate = currentDate;
            filledDRList.add(dataRecord);
        }
        filledDRList.forEach(System.out::print);
    }
}
