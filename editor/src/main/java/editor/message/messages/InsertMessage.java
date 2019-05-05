package editor.message.messages;

import editor.message.Message;

public class InsertMessage<T> extends Message {
    private String type;
    private T pos;
    private char c;

    public InsertMessage(String type,T pos,char c){
        this.c=c;
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

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }
}
