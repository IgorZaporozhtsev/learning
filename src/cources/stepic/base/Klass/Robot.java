package cources.stepic.base.Klass;

public class Robot {
    private int y;
    private int x;
    Direction dir;

    public static void main(String[] args) {
        Robot robot = new Robot(0,0, Direction.UP);
        moveRobot(robot, -4, -2);


    }
    public Robot (int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Direction getDirection() {
        // текущее направление взгляда
        return dir;
    }

    public int getX() {
        // текущая координата X
        return x;
    }

    public int getY() {
        // текущая координата Y
        return y;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
        if      (dir == Direction.UP)    {dir = Direction.LEFT;}
        else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
        else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
        else if (dir == Direction.RIGHT) {dir = Direction.UP;}
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
        else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
        else if (dir == Direction.LEFT)  {dir = Direction.UP;}
        else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
        if (dir == Direction.UP)    {y++;}
        if (dir == Direction.DOWN)  {y--;}
        if (dir == Direction.LEFT)  {x--;}
        if (dir == Direction.RIGHT) {x++;}
    }


    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }



    public static void moveRobot(Robot robot, int toX, int toY) {

        System.out.println("I looking in " + robot.dir);

        if (robot.getX() > toX) {
             if (robot.getDirection().equals(Direction.UP)) {
                 robot.turnLeft();
             } else if (robot.getDirection().equals(Direction.DOWN)) {
                 robot.turnRight();
             } else if (robot.getDirection().equals(Direction.RIGHT)) {
                 robot.turnLeft();
                 robot.turnLeft();
             }
        }

        if (robot.getX() < toX) {
            if (robot.getDirection().equals(Direction.UP)) {
                robot.turnRight();
            } else if (robot.getDirection().equals(Direction.DOWN)) {
                robot.turnLeft();
            } else if (robot.getDirection().equals(Direction.LEFT)) {
                robot.turnRight();
                robot.turnRight();
            }
        }

        System.out.println("Начальная точка по оси Х я нахожусь " + robot.getX());
        System.out.println("Начальная точка По оси Y я нахожусь " + robot.getY());
        System.out.println("Точка X куда нужно передвинуться " + toX);
        System.out.println("Точка Y куда нужно передвинуться " + toY);
        System.out.println("I turn in " + robot.dir);

        while (robot.getX() != toX)  {
            robot.stepForward();
            System.out.println("Я иду до точки X" + robot.getX());
        }

        System.out.println("По оси Х я нахожусь " + robot.getX());
        System.out.println("По оси Y я нахожусь " + robot.getY());


        if (robot.getX() == toX & robot.getY() > toY) {
            if (robot.getDirection().equals(Direction.RIGHT)) {
                robot.turnRight();
            } else if (robot.getDirection().equals(Direction.LEFT)) {
                robot.turnLeft();
            }

            System.out.println("I turn in" + robot.dir);
        }


        if (robot.getX() == toX & robot.getY() < toY) {
            if (robot.getDirection().equals(Direction.RIGHT)) {
                robot.turnLeft();
            } else if (robot.getDirection().equals(Direction.LEFT)) {
                robot.turnRight();
            }

            System.out.println("I turn in" + robot.dir);
        }


        while (robot.getY() != toY)  {
            robot.stepForward();
          System.out.println("Я иду до точки Y" + robot.getY());
        }


        System.out.println("Конечная точка по оси Х я нахожусь " + (robot.getX() == toX));
        System.out.println("Конечная точка по оси Y я нахожусь " + (robot.getY() == toY));
    }




}


