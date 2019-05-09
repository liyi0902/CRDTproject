package editor.message.messages;

import editor.message.Message;

public class InsertMessage<T> extends Message {
    private String type;
    private T atom;

    public InsertMessage(String type,T atom){
        this.type=type;
        this.atom = atom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getAtom() {
        return atom;
    }

    public void setAtom(T atom) {
        this.atom = atom;
    }

    @Override
    public String toString() {
        return "InsertMessage{" +
                "type='" + type + '\'' +
                ", atom=" + atom +
                '}';
    }
}
