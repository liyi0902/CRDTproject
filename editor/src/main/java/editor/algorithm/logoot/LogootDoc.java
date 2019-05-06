package editor.algorithm.logoot;

import editor.algorithm.Doc;

import java.util.ArrayList;


public class LogootDoc extends Doc {
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


    @Override
    public void insert(int pos,char c){

    }


    @Override
    public void delete(int pos) {

    }

    @Override
    public void remoteInsert(PositionIdentifier pos, char c) {

    }

    @Override
    public void remoteDelete(PositionIdentifier pos) {

    }
}
