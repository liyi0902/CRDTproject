package editor.algorithm.logoot;

import java.util.ArrayList;

public abstract class Strategy {

//    abstract PositionIdentifier generatePositionIdentifiers(PositionIdentifier p, PositionIdentifier q);

    abstract ArrayList<Identifier> generatePositionIdentifiers(ArrayList<Identifier> p, ArrayList<Identifier> q) throws Exception;

    public PositionIdentifier constructPosition(ArrayList<Integer> next,PositionIdentifier p, PositionIdentifier q){
        ArrayList<Identifier> res=new ArrayList<>();
        for(int i=0;i<next.size();i++){
            int digit=next.get(i);

            if(i==next.size()-1){
                res.add(new Identifier(digit));
            }
            else if(i<p.getIdentifiers().size()&&digit==p.getIdentifiers().get(i).getDigit()){
                res.add(new Identifier(digit,p.getIdentifiers().get(i).getSiteId()));
            }
            else if(i<q.getIdentifiers().size()&&digit==q.getIdentifiers().get(i).getDigit()){
                res.add(new Identifier(digit,q.getIdentifiers().get(i).getSiteId()));
            }
            else {
                res.add(new Identifier(digit));
            }
        }
        return new PositionIdentifier(res);

    }

    public ArrayList<Identifier> constructPosition(ArrayList<Integer> next,ArrayList<Identifier> p, ArrayList<Identifier> q){
        ArrayList<Identifier> res=new ArrayList<>();
        for(int i=0;i<next.size();i++){
            int digit=next.get(i);

            if(i==next.size()-1){
                res.add(new Identifier(digit));
            }
            else if(i<p.size()&&digit==p.get(i).getDigit()){
                res.add(new Identifier(digit,p.get(i).getSiteId()));
            }
            else if(i<q.size()&&digit==q.get(i).getDigit()){
                res.add(new Identifier(digit,q.get(i).getSiteId()));
            }
            else {
                res.add(new Identifier(digit));
            }
        }
        return res;

    }

    public ArrayList<Integer> getDigits(ArrayList<Identifier> identifiers,int index){
        ArrayList<Integer> list=new ArrayList<>();
        int len=identifiers.size();
        for(int i=0;i<index;i++){
            if(i<len){
                list.add(identifiers.get(i).getDigit());
            }
            else {
                list.add(0);
            }
        }
        return list;

    }


}
