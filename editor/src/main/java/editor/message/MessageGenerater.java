package editor.message;

import editor.algorithm.logoot.Atom;
import editor.algorithm.logoot.PositionIdentifier;
import editor.message.messages.*;

import java.util.ArrayList;
import java.util.HashMap;

public class MessageGenerater {
    public static Message generateInsertMessage(Atom atom){
        return new InsertMessage<>(MessageType.INSET.name(),atom);
    }

    public static Message generateDeleteMessage(PositionIdentifier pos){
        return new DeleteMessage<>(MessageType.DELETE.name(),pos);
    }

    public static Message generateJoinMessage(String id){
        return new JoinMessage(MessageType.JOIN.name(),id);
    }

    public static Message generateExitMessage(String id){
        return new ExitMessage(MessageType.EXIT.name(),id);
    }

    public static Message generateSycMessage(ArrayList<Atom> atoms){
//        HashMap<Integer,Atom> map=new HashMap<>();
//        for(int i=0;i<atoms.size();i++){
//            map.put(i,atoms.get(i));
//        }
        return new SycMessage<>(MessageType.SYC.name(),atoms);
    }


}
