package cources.stepic.base.tutorial;

public class Gen3 {
    // Двумерные координаты
    static public class TwoD {
        int x, y;

        public TwoD(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //Трехмерные координаты
    class TreeD extends TwoD {
        int z;

        public TreeD(int x, int y, int z) {
            super(x, y);
            this.z = z;
        }

        // Четырехмерные координаты

    }

    class FourD extends TreeD {
        int t;

        public FourD(int x, int y, int z, int t) {
            super(x, y, z);
            this.t = t;
        }

    }
// Этот класс хранит массив координат обьектов

    static class Coords<T extends TwoD> {
        T[] coords;

        public Coords(T[] o) {
            this.coords = o;
        }
    }

// продемонмтрировать пременение ограниченых метасимволов

    static class BoundedWildcard {
        public static void showXY(Coords<?> c) {
            System.out.println("Координаты X Y: ");
            for (int i = 0; i < c.coords.length; i++) {
                System.out.println(c.coords[i].x + " " + c.coords[i].y);
                System.out.println();
            }

        }
    }

    public static void main(String args[]) {


        TwoD td[] = {
                new TwoD(0, 0),
                new TwoD(7, 9)

        };


        Coords <TwoD> tdlocks = new Coords<TwoD>(td);

        System.out.println("Содержимое объекта tdlocks");


        BoundedWildcard.showXY(tdlocks);

    }
}
