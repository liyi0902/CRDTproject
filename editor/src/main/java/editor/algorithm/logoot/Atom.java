package editor.algorithm.logoot;

import java.io.Serializable;

public class Atom implements Serializable {
    private char c;
    private PositionIdentifier pos;

    public Atom(char c,PositionIdentifier pos){
        this.c=c;
        this.pos=pos;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public PositionIdentifier getPos() {
        return pos;
    }

    public void setPos(PositionIdentifier pos) {
        this.pos = pos;
    }




}
