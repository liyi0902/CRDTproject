package editor.algorithm.logoot;

import editor.algorithm.Doc;

import java.util.ArrayList;


public class LogootDoc extends Doc {
    private int totalClock;
    private ArrayList<Atom> atoms;

    public LogootDoc(){
        this.totalClock=0;
        this.atoms=new ArrayList<>();
    }


    public int getTotalClock() {
        return totalClock;
    }

    public void setTotalClock(int totalClock) {
        this.totalClock = totalClock;
    }




    @Override
    public synchronized void localInsert(int pos,char c){
        this.setTotalClock(this.getTotalClock()+1);

    }


    @Override
    public synchronized void localDelete(int pos) {

    }



    /**
     * insert a character from remote quest
     * @param pos
     * @param c
     * @return index for the front end editor to insert the character
     */
    @Override
    public synchronized int remoteInsert(PositionIdentifier pos, char c) {


    }

    /**
     * delete a character from remote quest
     * @param pos
     * @return index for the front end editor to insert the character
     */
    @Override
    public synchronized int remoteDelete(PositionIdentifier pos) {


    }


    /**
     * insert an atom to the crdt structure
     *
     * todo  optimization can use binary search
     * @param c
     * @param pos
     * @return
     */
    private int insert(char c, PositionIdentifier pos) {
        Atom atom=new Atom(c, pos);
        for(int i=0;i<atoms.size();i++){
            if(atoms.get(i).getPos().compareTo(pos)>0){
                atoms.add(i,atom);
                return i;
            }
        }
        atoms.add(atom);
        return atoms.size()-1;
    }


    /**
     * delete an atom from the crdt structure
     *
     * todo  optimization can use binary search
     * @param pos
     * @return
     */
    private int delete(PositionIdentifier pos) {
        for(int i=0;i<atoms.size();i++){
            if(atoms.get(i).getPos().equals(pos)){
                atoms.remove(i);
                return i;
            }
        }
        return -1;
    }
}
