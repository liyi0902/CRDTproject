package editor.message.messages;

import editor.message.Message;

public class SycMessage<M> extends Message {

    private String type;
    private M data;

    public SycMessage(String type, M m){
        this.type=type;
        this.data=m;
    }


}
