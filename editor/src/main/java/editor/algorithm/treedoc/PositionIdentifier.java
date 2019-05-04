package editor.algorithm.treedoc;

public class PositionIdentifier implements Comparable<PositionIdentifier> {
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


    /**
     * some different from the paper.
     * the paper use disambiguator in a path, and there are no two paths are equal
     * but i can't understand some sentences in paper and fill confused how to use disambiguator in paths
     * here i assume path can be equal in a major node, then we will compare the disambiguator in mini nodes
     * @param pos
     * @return 0 if equal, -1 if this before another, 1 if another before this
     */
    @Override
    public int compareTo(PositionIdentifier pos) {
        String path1=this.paths;
        int len1=path1.length();
        String path2=pos.getPaths();
        int len2=path2.length();

        if(path1.equals(path2)){
            return 0;
        }

        if(len2>len1&&path2.startsWith(path1)&&String.valueOf(path2.charAt(len1)).equals(right)){
            return -1;
        }

        if(len1>len2&&path1.startsWith(path2)&&String.valueOf(path1.charAt(len2)).equals(left)){
            return -1;
        }

        int index=this.getCommonPrefix(pos);

        if(path1.charAt(index)<path2.charAt(index)){
            return -1;
        }

        return 1;

    }


    public boolean isParentOf(PositionIdentifier pos){
        String path1=this.paths;
        int len1=path1.length();
        String path2=pos.getPaths();
        int len2=path2.length();

        return len1<len2&&path1.equals(path2.substring(0,len2-1));
    }


    public boolean isAncestorOf(PositionIdentifier pos){
        String path1=this.paths;
        int len1=path1.length();
        String path2=pos.getPaths();
        int len2=path2.length();

        return len1<len2&&this.getCommonPrefix(pos)>0;
    }


    private int getCommonPrefix(PositionIdentifier pos){
        String path1=this.paths;
        int len1=path1.length();
        String path2=pos.getPaths();
        int len2=path2.length();
        String prefix="";
        for(int i = 0, j = 0;i<len1&&j<len2;i++,j++){
            if(path1.substring(i,i+1).equals(path2.substring(j,j+1))) {
                prefix=prefix+path1.substring(i,i+1);
            }
            else {
                break;
            }
        }
        return prefix.length();

    }







}
