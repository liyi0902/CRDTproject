package editor.algorithm.logoot;

import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;

/**
 * use a new method get from http://digitalfreepen.com/2017/10/06/simple-real-time-collaborative-text-editor.html
 * to generate PositionIdentifier
 * This class is not used again since some problems
 */
public class NewStrategy extends Strategy{


    /**
     * generate PositionIdentifiers
     * @param p
     * @param q
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<Identifier> generatePositionIdentifiers(ArrayList<Identifier> p, ArrayList<Identifier> q) throws Exception{
        System.out.println("p size"+p.size());
        System.out.println("q size"+q.size());

        Identifier head1;
        Identifier head2;
        if(p.size()!=0){
            head1=p.get(0);
        }
        else {
            head1=new Identifier(0);
        }
        if(q.size()!=0){
            head2=q.get(0);
        }
        else {
            head2=new Identifier(10);
        }

        if(head1.getDigit()!=head2.getDigit()){
            ArrayList<Integer> l1=super.getDigits(p,p.size()-1);
            ArrayList<Integer> l2=super.getDigits(q,q.size()-1);
            System.out.println("l1 :"+l1.toString());
            System.out.println("l2 :"+l2.toString());

            ArrayList<Integer> delta=subtractGreaterThan(l2,l1);
            ArrayList<Integer> next=increment(l1,delta);
            return super.constructPosition(next,p,q);
        }
        else {
            if(head1.getSiteId().compareTo(head2.getSiteId())==-1){
                ArrayList<Identifier> result=new ArrayList<>();
                result.add(head1);
                result.addAll(generatePositionIdentifiers(rest(p),new ArrayList<>()));
                return result;

            }
            else if(head1.getSiteId().compareTo(head2.getSiteId())==0) {
                ArrayList<Identifier> result=new ArrayList<>();
                result.add(head1);
                result.addAll(generatePositionIdentifiers(rest(p),rest(q)));
                return result;
            }
            else {
                throw new Exception("invalid site ordering");
            }

        }

    }


    /**
     * compare twp list and subtract the greater part
     * @param l2
     * @param l1
     * @return
     */
    private ArrayList<Integer> subtractGreaterThan(ArrayList<Integer> l2,ArrayList<Integer> l1){

        int i1=0;
        int i2=Integer.MAX_VALUE;
        ArrayList<Integer> delta=new ArrayList<>();
        int len1=l1.size();
        int len2=l2.size();
        int size=Math.max(len1,len2);

        if(len1>0&&len2>0){
            StringBuilder sb1=new StringBuilder();
            StringBuilder sb2=new StringBuilder();
            for(int i=0;i<size;i++){
                if(i<len1&&i<len2){
                    sb1.append(l1.get(i));
                    sb2.append(l2.get(i));
                }
                else if(i>=len1){
                    l1.add(0);
                    sb1.append(0);
                    sb2.append(l2.get(i));
                }
                else {
                    l2.add(0);
                    sb1.append(l1.get(i));
                    sb2.append(0);
                }
            }
            i1=Integer.valueOf(sb1.toString());
            i2=Integer.valueOf(sb2.toString());
        }

        if(len1>0&&len2==0){
            StringBuilder sb1=new StringBuilder();
            for(int i=0;i<len1;i++){
                sb1.append(l1.get(i));
            }
            i1=Integer.valueOf(sb1.toString());
        }
        if(len1==0&&len2>0){
            StringBuilder sb2=new StringBuilder();
            for(int i=0;i<len2;i++){
                sb2.append(l2.get(i));
            }
            i2=Integer.valueOf(sb2.toString());
        }


        System.out.println("i1:"+i1);
        System.out.println("i2:"+i2);


        String dif=String.valueOf(i2-i1);
        for(int i=0;i<size-dif.length();i++){
            delta.add(0);
        }
        for(int i=0;i<dif.length();i++){
            delta.add(Integer.parseInt(String.valueOf(dif.charAt(i))));
        }

        System.out.println("delta:"+delta.toString());
        return delta;

    }

    /**
     * increment a list use a delta
     * @param l
     * @param delta
     * @return
     */
    private ArrayList<Integer> increment(ArrayList<Integer> l,ArrayList<Integer> delta){
        System.out.println("l:"+l.toString());

        ArrayList<Integer> inc=new ArrayList<>();
        for(int i=0;i<delta.size();i++){
            if(delta.get(i)==0){
                inc.add(0);
            }
            else {
                break;
            }
        }
        inc.add(0);
        inc.add(1);
        ArrayList<Integer> v1=add(l,inc);
        if(v1.get(v1.size()-1)==0){
            v1=add(v1,inc);
        }
        System.out.println("v1:"+v1.toString());
        return v1;

    }

    /**
     * add a list to another list
     * @param l
     * @param inc
     * @return
     */
    private ArrayList<Integer> add(ArrayList<Integer> l,ArrayList<Integer> inc){
        if(l.size()==0){
            l.add(1);
            return l;
        }

        if(inc.size()>l.size()){
            l.add(1);
            return l;
        }
        else {
            ArrayList<Integer> res=new ArrayList<>();
            int dif=l.size()-inc.size();
            for(int i=0;i<dif;i++){
                inc.add(0);
            }
            StringBuilder sb1=new StringBuilder();
            StringBuilder sb2=new StringBuilder();
            for(int i=0;i<l.size();i++){
                sb1.append(l.get(i));
                sb2.append(inc.get(i));
            }
            int i1=Integer.valueOf(sb1.toString());
            int i2=Integer.valueOf(sb2.toString());
            String add=String.valueOf(i1+i2);
            for(int i=0;i<add.length();i++){
                res.add(Integer.parseInt(String.valueOf(add.charAt(i))));
            }
            return res;
        }

    }


    /**
     * get the rest list except the head of the list
     * @param list
     * @return
     */
    public ArrayList<Identifier> rest(ArrayList<Identifier> list){
        ArrayList<Identifier> res=new ArrayList<>();
        for(int i=1;i<list.size();i++){
            res.add(list.get(i));
        }
        return res;
    }

    @Override
    ArrayList<Identifier> generatePositionIdentifiers(ArrayList<Identifier> p, ArrayList<Identifier> q, int bound)  {
        return null;
    }
}
