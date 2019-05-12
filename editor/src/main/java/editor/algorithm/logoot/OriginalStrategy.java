package editor.algorithm.logoot;

import java.util.ArrayList;
import java.util.Random;

/**
 * use the method in "Logoot-Undo: Distributed Collaborative Editing System on P2P networks" papaer.
 * but i think this paper has some problems, so modify some part of the method
 */
public class OriginalStrategy extends Strategy{


    /**
     * set default bound =5
     * @param p
     * @param q
     * @return
     * @throws Exception
     */
    @Override
    ArrayList<Identifier> generatePositionIdentifiers(ArrayList<Identifier> p, ArrayList<Identifier> q) throws Exception {
        return this.generatePositionIdentifiers(p,q,5);
    }

    /**
     * to generate the Identifier list for new atom
     * in the original paper, there is an argument n that means we can generate n ArrayList,
     * but in our project,we only generate one arraylist at a time.
     * @param p
     * @param q
     * @param bound
     * @return
     * @throws Exception
     */
    @Override
    ArrayList<Identifier> generatePositionIdentifiers(ArrayList<Identifier> p, ArrayList<Identifier> q,int bound) {
        System.out.println("before"+p.toString());
        System.out.println("after"+q.toString());
        int index=0;
        int interval=0;
        int min=Math.min(p.size(),q.size());

        // to find the index that two  Identifier at this index are not equals
        while ((index<min&&p.get(index).equals(q.get(index)))||(p.size()<=index&&q.size()>index&&q.get(index).getDigit()==0)){
            index++;
        }
        interval=getDigit(q,index)-getDigit(p,index)-1;
        int step=interval;


        //interval>0 means the two digit of p and q are like 100 102, so we can generate 101 between then
        if(interval>=1){
            //limit the step make it less than bound
            step=Math.min(bound,interval);
        }
        //means we need another index to diff p and q
        else{
            while (interval<1){
                index++;
                interval=Integer.MAX_VALUE-getDigit(p,index);
            }
            step=Math.min(interval,bound);

        }
        System.out.println("step: "+step);

        ArrayList<Integer> digits=getDigits(p,index);

        increment(digits,step);
        return constructPosition(digits,p,q);


    }

    /**
     * increment the list by an interval
     * @param digits
     * @param interval
     * @return
     */
    private ArrayList<Integer> increment(ArrayList<Integer> digits,int interval){
        int step=new Random().nextInt(interval)+1;
        int last=digits.get(digits.size()-1);
        digits.set(digits.size()-1,last+step);
        return digits;

    }

    public static void main(String[] args) {
        LogootDoc logootDoc=new LogootDoc();
        Identifier i1=new Identifier(0,"0");
        Identifier i2=new Identifier(2,"31d0ffd72cc447c288b9d2434a91bb0b");
        Identifier i3=new Identifier(131,"3");
        Identifier i4=new Identifier(2472,"3");
        Identifier i5=new Identifier(6,"3");
        Identifier i6=new Identifier(223,"31");
        ArrayList<Identifier> a1=new ArrayList<>();
        ArrayList<Identifier> a2=new ArrayList<>();
        a1.add(i1);
//        a1.add(i2);
//        a1.add(i6);
        a2.add(i2);
//        a2.add(i4);
//        a2.add(i3);
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        ArrayList<Identifier> arrayList=logootDoc.getStrategy().generatePositionIdentifiers(a1,a2,5);
        System.out.println("arraylist"+arrayList.toString());

    }



}
