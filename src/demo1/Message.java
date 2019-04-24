package demo1;

import org.json.JSONObject;
import java.net.*;



public class Message {

    public MessageType type;
    public String ip;
    public String localName;
    public int port;
    public String content;
    //发送所需的json字符串，或者接收到的未解码json字符串。
    public String message;


    public Message(){

    }

    /**
     * 构造INVITATION，JOIN，LEAVE等消息的方法，只需传入消息类型。
     * @param type
     */
    public Message(MessageType type){
        setAddress();
        this.port=Broadcast.RECE_PORT;
        this.type=type;
        buildJson();
    }

    /**
     * 构造SYC消息的方法，需要传入同步的字符串内容。
     * @param content
     */
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

    /**
     * 把一个Message对象，编码成Json字符串，准备发送。自动添加本机ip，port，localName等字段。
     */
    private void buildJson(){
        JSONObject obj=new JSONObject();
        obj.put("type",type.toString());
        obj.put("ip",ip);
        obj.put("localName",localName);
        obj.put("content",content);
        obj.put("port",port);
        this.message=obj.toString();
    }

    /**
     * 把收到的一个消息字符串，解析成Message对象。
     * @param s
     * @return
     */
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
