package editor.algorithm.logoot;

public class LogootDoc  {
    private int totalClock;


    public int getTotalClock() {
        return totalClock;
    }

    public void setTotalClock(int totalClock) {
        this.totalClock = totalClock;
    }


    public void insert(char c, PositionIdentifier pos) {

        this.setTotalClock(this.getTotalClock()+1);

    }

    public void delete(PositionIdentifier pos) {


    }

}
