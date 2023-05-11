package interview.make_class_immutable;


import java.time.LocalDate;
import java.util.*;

/**
 * How to do that reservations.contains(new Reservation(1)) return true
 * How to make class immutable, why we need class immutable
 */

class SolutionImmutable {


    public static void main(String[] args) {

        var reservationImmutable = new ReservationImmutable(1);

        Set<ReservationImmutable> reservations = Set.of(
                reservationImmutable,
                new ReservationImmutable(2),
                new ReservationImmutable(3),
                new ReservationImmutable(4),
                new ReservationImmutable(5),
                new ReservationImmutable(6)
        );
        //reservationImmutable.id = 4;

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


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ReservationImmutable that = (ReservationImmutable) o;
            return id == that.id && Objects.equals(clientFullName, that.clientFullName)
                    && Objects.equals(reservationDates, that.reservationDates);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, clientFullName, reservationDates);
        }
    }

}