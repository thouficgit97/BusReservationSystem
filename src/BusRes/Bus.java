package BusRes;

public class Bus {
    private int busNo;
    private boolean ac;
    private int capacity;
    Bus(int no,boolean ac,int capacity){
        this.busNo = no;
        this.capacity = capacity;
        this.ac = ac;
    }
    public int getBusNo(){
        return busNo;
    }

    public boolean isAc(){
        return ac;
    }
    public int getCapacity(){
        return capacity;
    }

    public void setAc(boolean val) {
        ac = val;
    }

    public void setCapacity(int cap) {
        capacity = cap;
    }

    public void displayBusInfo(){
        System.out.println("Bus No:" + busNo + " Ac:" + ac + " Total Capacity: " + capacity);
    }
}
