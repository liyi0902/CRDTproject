package editor.message;

import editor.algorithm.treedoc.PositionIdentifier;
import editor.message.messages.DeleteMessage;
import editor.message.messages.ExitMessage;
import editor.message.messages.InsertMessage;
import editor.message.messages.JoinMessage;

public class MessageGenerater {
    public static Message generateInsertMessage(PositionIdentifier pos,char c){
        return new InsertMessage<PositionIdentifier>(MessageType.INSET.name(),pos,c);
    }

    public static Message generateDeleteMessage(PositionIdentifier pos){
        return new DeleteMessage<PositionIdentifier>(MessageType.DELETE.name(),pos);
    }

    public static Message generateJoinMessage(String id){
        return new JoinMessage(MessageType.JOIN.name(),id);
    }

    public static Message generateExitMessage(String id){
        return new ExitMessage(MessageType.EXIT.name(),id);
    }

}
