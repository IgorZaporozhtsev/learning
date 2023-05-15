package interview;

public class ConstructorChain {
    public static void main(String[] args) {
        var first = new Store("first");
        System.out.println(first);
    }

    final static class Store {
        private final String name;
        private final int capacity;
        private final int rentCost;
        private final String currency;

        public Store(String name) {
            this(name, 0);
        }

        public Store(String name, int capacity) {
            this(name, capacity, 0);
        }

        public Store(String name, int capacity, int rentCost) {
            this(name, capacity, rentCost, "USD");
        }

        public Store(String name, int capacity, int rentCost, String currency) {
            this.name = name;
            this.capacity = capacity;
            this.rentCost = rentCost;
            this.currency = currency;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        public int getRentCost() {
            return rentCost;
        }

        public String getCurrency() {
            return currency;
        }

        @Override
        public String toString() {
            return "Store{" +
                    "name='" + name + '\'' +
                    ", capacity=" + capacity +
                    ", rentCost=" + rentCost +
                    ", currency='" + currency + '\'' +
                    '}';
        }
    }
}
