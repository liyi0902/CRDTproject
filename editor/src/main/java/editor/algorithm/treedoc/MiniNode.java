package editor.algorithm.treedoc;

public class MiniNode extends Node{

    private boolean isDeleted;
    private PositionIdentifier pos;
    private Disambiguator disambiguator;
    private char val;

    public MiniNode(char val,Disambiguator disambiguator,PositionIdentifier pos){
        this.disambiguator=disambiguator;
        this.pos = pos;
        this.val=val;
        this.isDeleted=false;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Disambiguator getDisambiguator() {
        return disambiguator;
    }


    public char getVal() {
        return val;
    }

    public PositionIdentifier getPos() {
        return pos;
    }

}
