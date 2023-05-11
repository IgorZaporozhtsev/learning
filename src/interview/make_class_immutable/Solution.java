package interview.make_class_immutable;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * How to do that reservations.contains(new Reservation(1)) return true
 * How to make class immutable, why we need class immutable
 */

class Solution {

    public static void main(String[] args) {
        var reservation = new Reservation(1);

        Set<Reservation> reservations = Set.of(
                reservation,
                new Reservation(2),
                new Reservation(3),
                new Reservation(4),
                new Reservation(5),
                new Reservation(6)
        );

        reservation.id = 3;
        System.out.println(reservations.contains(new Reservation(1)));
    }


    public static class Reservation {
        public int id;
        public String clientFullName;
        public List<LocalDate> reservationDates;


        public Reservation(Integer id) {
            this.id = id;
            if (id < 0) {
                throw new IllegalArgumentException("id cannot be negative");
            }
        }

        public Reservation(Integer id, String clientFullName) {
            this.id = id;
            this.clientFullName = clientFullName;

            if (id < 0) {
                throw new IllegalArgumentException("id cannot be negative");
            }
        }

        public Reservation(Integer id, String clientFullName, List<LocalDate> reservationDates) {
            this.id = id;
            this.clientFullName = clientFullName;
            this.reservationDates = reservationDates;
            if (id < 0) {
                throw new IllegalArgumentException("id cannot be negative");
            }
        }

        public Integer getId() {
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