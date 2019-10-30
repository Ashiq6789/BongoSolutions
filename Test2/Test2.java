interface Vehicle {
    int set_num_of_wheels();
    int set_num_of_passengers();
    boolean has_gas();
}

class Cars implements Vehicle{
    private int wheels,passengers;
    private boolean gas;

    public Cars(int wheels, int passengers, boolean gas){
        this.wheels = wheels;
        this.passengers = passengers;
        this.gas =gas;
    }

    @Override
    public int set_num_of_wheels() {
        return wheels;
    }

    @Override
    public int set_num_of_passengers() {
        return passengers;
    }

    @Override
    public boolean has_gas() {
        return gas;
    }
}

class Planes implements Vehicle{
    private int wheels,passengers;
    private boolean gas;

    public Planes(int wheels, int passengers, boolean gas){
        this.wheels = wheels;
        this.passengers = passengers;
        this.gas =gas;
    }

    @Override
    public int set_num_of_wheels() {
        return wheels;
    }

    @Override
    public int set_num_of_passengers() {
        return passengers;
    }

    @Override
    public boolean has_gas() {
        return gas;
    }
}

public class Test2 {

    public static void main (String[] args){

        Vehicle vehicle1 = new Cars(4, 4,true);
        Vehicle vehicle2 = new Planes(6,200,false);
    }
}
