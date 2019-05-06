package editor.algorithm.logoot;

import editor.algorithm.Doc;

import java.util.ArrayList;

/**
 * Doc for crdt structure
 * we use list to store atoms,maybe use tree structure is better . treemap? treeset?
 */
public class LogootDoc extends Doc {
    private int totalClock;
    private ArrayList<Atom> atoms;
    private Strategy strategy;

    public LogootDoc(){
        this.totalClock=0;
        this.atoms=new ArrayList<>();
        this.strategy=new NewStrategy();
    }


    public int getTotalClock() {
        return totalClock;
    }

    public void setTotalClock(int totalClock) {
        this.totalClock = totalClock;
    }




    /**
     * local insert a character
     * @param pos
     * @return Atom with positionIdentifier and character, then broadcast it for other process to merge
     */
    @Override
    public synchronized Atom localInsert(int pos,char c){
        //may have bug，need test
        PositionIdentifier before=atoms.get(pos-1).getPos();
        PositionIdentifier after=atoms.get(pos+1).getPos();
        PositionIdentifier current=new PositionIdentifier();
        try {
            ArrayList<Identifier> list=strategy.generatePositionIdentifiers(before.getIdentifiers(),after.getIdentifiers());
            current.setClock(this.getTotalClock());
            current.setIdentifiers(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        this.setTotalClock(this.getTotalClock()+1);
        return new Atom(c,current);

    }


    /**
     * local delete a character
     * @param pos
     * @return PositionIdentifier of the character, then broadcast it for other process to merge
     */
    @Override
    public synchronized PositionIdentifier localDelete(int pos) {
        //may has bug，need test
        return atoms.remove(pos).getPos();

    }



    /**
     * insert a character from remote quest
     * @param pos
     * @param c
     * @return index for the front end editor to insert the character
     */
    @Override
    public synchronized int remoteInsert(PositionIdentifier pos, char c) {
        return this.insert(pos,c);
    }

    /**
     * delete a character from remote quest
     * @param pos
     * @return index for the front end editor to insert the character
     */
    @Override
    public synchronized int remoteDelete(PositionIdentifier pos) {
        return this.delete(pos);
    }


    /**
     * insert an atom to the crdt structure
     *
     * todo  optimization can use binary search
     * @param c
     * @param pos
     * @return
     */
    private int insert(PositionIdentifier pos,char c) {
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
