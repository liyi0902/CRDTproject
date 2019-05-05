package editor.algorithm.logoot;

import java.util.ArrayList;
import java.util.Random;

public class LogootDoc  {
    private int totalClock;
    private ArrayList<Atom> atoms;

    public LogootDoc(){
        this.totalClock=0;
        this.atoms=new ArrayList<>();
    }


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
