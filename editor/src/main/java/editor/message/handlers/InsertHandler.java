package editor.message.handlers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.JsonObject;
import editor.algorithm.logoot.Atom;
import editor.algorithm.logoot.Identifier;
import editor.algorithm.logoot.PositionIdentifier;
import editor.controller.EditorController;
import editor.message.MessageHandler;
import editor.message.messages.InsertMessage;
import editor.message.messages.SycMessage;
import editor.network.Connection;
import editor.utils.JsonUtil;

public class InsertHandler extends MessageHandler {
    private EditorController editorController;

    public InsertHandler(EditorController editorController) {
        this.editorController = editorController;
    }

    @Override
    public boolean processMessage(JSONObject json, Connection connection) {
        String msg=json.toJSONString();
        for(Connection c:this.editorController.getConnections()){
            if(c!=connection){
                c.writeMsg(msg);
                System.out.println("send");
            }
        }
        System.out.println("json:"+json.toJSONString());

        InsertMessage<Atom> insertMessage=JsonUtil.convertJSONToObject(json,new TypeReference<InsertMessage<Atom>>(){});


        System.out.println(insertMessage.toString());


        PositionIdentifier pos=insertMessage.getAtom().getPos();
        char c=insertMessage.getAtom().getC();
        editorController.remoteInsert(pos,c);
        return true;

    }
}
