package editor.algorithm.treedoc;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MajorNode {
    private PriorityQueue<MiniNode> miniNodePriorityQueue;
    private PositionIdentifier pos;
    private MajorNode left;
    private MajorNode right;

    public MajorNode() {
        miniNodePriorityQueue=new PriorityQueue<>
                ((o1,o2)->o1.getDisambiguator().getCounter()==o2.getDisambiguator().getCounter()?
                        o1.getDisambiguator().getUid().compareTo(o2.getDisambiguator().getUid()):
                        o1.getDisambiguator().getCounter()-o2.getDisambiguator().getCounter());
    }

    public void add(MiniNode miniNode){
        miniNodePriorityQueue.add(miniNode);
    }

    public void deletee(Disambiguator disambiguator){
        for(MiniNode miniNode:miniNodePriorityQueue){
            if(disambiguator.equals(miniNode.getDisambiguator())){
                miniNodePriorityQueue.remove(miniNode);
            }
        }
    }




}
