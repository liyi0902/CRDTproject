package editor.message.messages;

import editor.message.Message;

public class SycMessage<T> extends Message {

    private String type;
    private T data;

    public SycMessage(String type, T t){
        this.type=type;
        this.data=t;
    }


}
