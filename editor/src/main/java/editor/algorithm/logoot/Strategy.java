package editor.algorithm.logoot;

import java.util.ArrayList;

public abstract class Strategy {

//    abstract PositionIdentifier generatePositionIdentifiers(PositionIdentifier p, PositionIdentifier q);

    abstract ArrayList<Identifier> generatePositionIdentifiers(ArrayList<Identifier> p, ArrayList<Identifier> q) throws Exception;

    abstract ArrayList<Identifier> generatePositionIdentifiers(ArrayList<Identifier> p, ArrayList<Identifier> q,int bound) ;


    /**
     * use the integer list to consruct Identifier list for a new PositionIdentifier, the same to the method in paper
     * @param next
     * @param p
     * @param q
     * @return
     */
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
        System.out.println("res"+res);
        System.out.println("show digits: "+getDigits(res,res.size()-1));

        return res;

    }



    public ArrayList<Integer> getDigits(ArrayList<Identifier> identifiers,int index){
        ArrayList<Integer> list=new ArrayList<>();
        int len=identifiers.size();
        for(int i=0;i<=index;i++){
            if(i<len){
                list.add(identifiers.get(i).getDigit());
            }
            else {
                list.add(0);
            }
        }
        return list;

    }

    public int getDigit(ArrayList<Identifier> identifiers,int index){
        if(index<identifiers.size()){
            return identifiers.get(index).getDigit();
        }
        else {
            return 0;
        }
    }


}
