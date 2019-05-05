package editor.algorithm.logoot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PositionIdentifier implements Serializable, Comparable<PositionIdentifier> {
    private ArrayList<Identifier> identifiers;
    private int clock;

    public PositionIdentifier(ArrayList<Identifier> identifiers,int clock){
        this.identifiers=identifiers;
        this.clock=clock;
    }

    public PositionIdentifier(ArrayList<Identifier> identifiers){
        this.identifiers=identifiers;
    }


    public ArrayList<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(ArrayList<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public int getClock() {
        return clock;
    }

    public void setClock(int clock) {
        this.clock = clock;
    }

    @Override
    public int compareTo(PositionIdentifier pos) {
        ArrayList<Identifier> list1=this.identifiers;
        ArrayList<Identifier> list2=pos.identifiers;
        int len1=list1.size();
        int len2=list2.size();
        for(int i=0;i< Math.min(list1.size(), list2.size()); i++){
            int res=list1.get(i).compareTo(list2.get(i));
            if(res!=0){
                return res;
            }
        }
        if(len1<len2){
            return -1;
        }
        else if(len1>len2){
            return 1;
        }
        else {
            return 0;
        }
    }



}
