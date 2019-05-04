package editor.algorithm.treedoc;

import java.util.PriorityQueue;

public class MajorNode extends Node{
    private PriorityQueue<MiniNode> queue;
    private PositionIdentifier pos;
    private Node left;
    private Node right;


    public MajorNode(MiniNode miniNode) {
        queue =new PriorityQueue<>
                (1,(o1,o2)->o1.getDisambiguator().getCounter()==o2.getDisambiguator().getCounter()?
                        o1.getDisambiguator().getUid().compareTo(o2.getDisambiguator().getUid()):
                        o1.getDisambiguator().getCounter()-o2.getDisambiguator().getCounter());
        queue.add(miniNode);
        this.pos=miniNode.getPos();
    }

    public void add(MiniNode miniNode){
        queue.add(miniNode);
    }

    public void deletee(Disambiguator disambiguator){
        for(MiniNode miniNode: queue){
            if(disambiguator.equals(miniNode.getDisambiguator())){
                queue.remove(miniNode);
            }
        }
    }

    public PriorityQueue<MiniNode> getQueue() {
        return queue;
    }

    public void setQueue(PriorityQueue<MiniNode> queue) {
        this.queue = queue;
    }

    public PositionIdentifier getPos() {
        return pos;
    }

    public void setPos(PositionIdentifier pos) {
        this.pos = pos;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
