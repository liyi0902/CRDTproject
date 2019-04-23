package demo1;

import org.json.JSONObject;
import java.net.*;



public class Message {

    public MessageType type;
    public String ip;
    public String localName;
    public int port;
    public String content;
    public String message;


    public Message(){

    }

    public Message(MessageType type){
        setAddress();
        this.port=Broadcast.RECE_PORT;
        this.type=type;
        buildJson();
    }
    public Message(String content){
        setAddress();
        this.port=Broadcast.RECE_PORT;
        this.type=MessageType.SNC;
        this.content=content;
        buildJson();
    }

    public String getMessage() {
        return message;
    }

    private void setAddress(){
        InetAddress inetAddress;
        try{
            inetAddress=InetAddress.getLocalHost();
            this.ip=inetAddress.getHostAddress();
            this.localName=inetAddress.getHostName();
        }catch (UnknownHostException e){
            System.out.println("Error when get local machine ip and hostName");
            e.printStackTrace();
        }
    }

    private void buildJson(){
        JSONObject obj=new JSONObject();
        obj.put("type",type.toString());
        obj.put("ip",ip);
        obj.put("localName",localName);
        obj.put("content",content);
        obj.put("port",port);
        this.message=obj.toString();
    }

    public static Message DecodeMessage(String s){
        JSONObject js=new JSONObject(s);
        Message message=new Message();

        MessageType type=MessageType.valueOf(js.get("type").toString());
        message.type=type;
        message.ip=js.getString("ip");
        message.port=js.getInt("port");
        message.localName=js.getString("localName");
        message.content=js.getString("content");
        message.message=s;

        return message;
    }
}