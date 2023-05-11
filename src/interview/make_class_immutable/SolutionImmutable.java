package interview.make_class_immutable;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

class SolutionImmutable {

    public static void main(String[] args) {

        Set<ReservationImmutable> reservations = Set.of(
                new ReservationImmutable(1),
                new ReservationImmutable(2),
                new ReservationImmutable(3),
                new ReservationImmutable(4),
                new ReservationImmutable(5),
                new ReservationImmutable(6)
        );
        System.out.println(reservations.contains(new ReservationImmutable(1)));
    }


    public static final class ReservationImmutable {
        private final int id;
        private final String clientFullName;
        private final List<LocalDate> reservationDates;

        public ReservationImmutable(int id) {
            this(id, null);
        }

        public ReservationImmutable(int id, String clientFullName) {
            this(id, clientFullName, Collections.emptyList());
        }

        public ReservationImmutable(int id, String clientFullName, List<LocalDate> reservationDates) {
            if (id < 0) {
                throw new IllegalArgumentException("id cannot be negative");
            }
            this.id = id;
            this.clientFullName = clientFullName;
            this.reservationDates = Collections.unmodifiableList(new ArrayList<>(reservationDates));
        }

        public int getId() {
            return id;
        }

        public String getClientFullName() {
            return clientFullName;
        }

        public List<LocalDate> getReservationDates() {
            return reservationDates;
        }
    }

}