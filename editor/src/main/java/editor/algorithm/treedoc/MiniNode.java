package editor.algorithm.treedoc;

public class MiniNode {

    private boolean isDeleted;
    private PositionIdentifier positionIdentifier;
    private Disambiguator disambiguator;
    private char val;

    public MiniNode(char val,Disambiguator disambiguator,PositionIdentifier positionIdentifier){
        this.disambiguator=disambiguator;
        this.positionIdentifier=positionIdentifier;
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

    public PositionIdentifier getPositionIdentifier() {
        return positionIdentifier;
    }
}
