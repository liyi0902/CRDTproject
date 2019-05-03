package editor.algorithm.treedoc;

public class PositionIdentifier {
    private static final String left="0";
    private static final String right="1";
    private String paths;
    private Disambiguator disambiguator;


    public PositionIdentifier(Disambiguator disambiguator,String paths){
        this.disambiguator=disambiguator;
        this.paths=paths;
    }

    public PositionIdentifier(String paths){
        this.paths=paths;
    }


    public String getPaths() {
        return paths;
    }

    public void setPaths(String paths) {
        this.paths = paths;
    }


    public boolean beofre(PositionIdentifier pos){

    }
}
