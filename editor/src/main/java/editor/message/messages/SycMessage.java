package editor.message.messages;

import editor.message.Message;

public class SycMessage<T> extends Message {
    private String type;
    private T data;

    public SycMessage(String type,T data){
        this.type=type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SycMessage{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
