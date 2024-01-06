package kiosk.domain;

public class WaitingNumber {
    private static final WaitingNumber WaitingNumber = new WaitingNumber();
    private WaitingNumber(){}
    public static WaitingNumber getInstance(){
        return WaitingNumber;
    }

    private int waitingNumber = 0;

    public int getWaitingNumber() {
        return waitingNumber;
    }

    public void add(){
        waitingNumber++;
    }
}
