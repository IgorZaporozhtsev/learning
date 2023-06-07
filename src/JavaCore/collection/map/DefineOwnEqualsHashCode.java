package JavaCore.collection.map;

import java.util.Objects;

public class DefineOwnEqualsHashCode {

    public static void main(String[] args) {
        var first = new Order("Industry co.", 3241451, 3, "delivered");
        var second = new Order("Industry co.", 3241451, 3, "delivered");
        System.out.println(first.equals(second));
    }

    static class Order {
        private String name;
        private int serialNumber;
        private int amount;
        private String status;


        Order(String name, int serialNumber, int amount, String status) {
            this.name = name;
            this.serialNumber = serialNumber;
            this.amount = amount;
            this.status = status;
        }

/*        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null) return false;
            if (getClass() != object.getClass()) return false;
            Order order = (Order) object;
            return this.name.equals(order.name)
                    && this.serialNumber == order.serialNumber
                    && this.amount == order.amount
                    && this.status.equals(order.status);
        }
        */

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null) return false;
            if (getClass() != object.getClass()) return false;
            Order order = (Order) object;
            return Objects.equals(this.name, order.name)
                    && this.serialNumber == order.serialNumber
                    && this.amount == order.amount
                    && Objects.equals(this.status, order.status);
        }


        @Override
        public int hashCode() {
            return Objects.hash(name, serialNumber, amount, status);
        }
    }

}
