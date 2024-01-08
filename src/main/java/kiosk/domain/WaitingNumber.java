package kiosk.domain;

public class WaitingNumber {

    private int waitingNumber = 0;
    private static final WaitingNumber WaitingNumber = new WaitingNumber();
    private WaitingNumber(){}
    public static WaitingNumber getInstance(){
        return WaitingNumber;
    }

    public int getWaitingNumber() {
        return waitingNumber;
    }

    public void add(){
        waitingNumber++;
    }
}
