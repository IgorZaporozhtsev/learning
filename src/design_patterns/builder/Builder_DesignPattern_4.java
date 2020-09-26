package design_patterns.builder;

public class Builder_DesignPattern_4 {
    public static void main(String[] args) {
        MCar car = new mCarBuilder()
                    .buildTrans(Trans.AUTO)
                    .buildSpeed(200)
                    .built();
    }
}


class mCarBuilder{
    Trans trans = Trans.MANUAL;
    int speed = 20;
    MCar mCar;

    public mCarBuilder buildTrans(Trans trans) {
        this.trans = trans;
        return this;
    }

    public mCarBuilder buildSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    MCar built(){
        MCar car = new MCar();
        car.setTrans(trans);
        car.setSpeed(speed);
        return car;
    };
}

class MCar {
    Trans trans;
    int speed;

    public void setTrans(Trans trans) {
        this.trans = trans;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}

enum Trans{
    MANUAL, AUTO
}