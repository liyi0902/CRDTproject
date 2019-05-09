package editor.message.messages;

import editor.message.Message;

public class SycMessage<T> extends Message {
    private String type;
    private T atoms;

    public SycMessage(String type,T atom){
        this.type=type;
        this.atoms = atom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getAtom() {
        return atoms;
    }

    public void setAtom(T atom) {
        this.atoms = atom;
    }

    @Override
    public String toString() {
        return "SycMessage{" +
                "type='" + type + '\'' +
                ", atom=" + atoms +
                '}';
    }
}
