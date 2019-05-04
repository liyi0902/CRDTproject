package editor.message.messages;

import editor.algorithm.treedoc.PositionIdentifier;
import editor.message.Message;

public class DeleteMessage<T> extends Message {
    private String type;
    private T pos;

    public DeleteMessage(String type,T pos){
        this.type=type;
        this.pos=pos;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getPos() {
        return pos;
    }

    public void setPos(T pos) {
        this.pos = pos;
    }
}
