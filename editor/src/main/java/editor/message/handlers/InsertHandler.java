package editor.message.handlers;

import com.alibaba.fastjson.JSONObject;
import editor.algorithm.logoot.Atom;
import editor.algorithm.logoot.PositionIdentifier;
import editor.controller.EditorController;
import editor.message.MessageHandler;
import editor.message.messages.InsertMessage;
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
            }
        }

        InsertMessage<Atom> insertMessage= JsonUtil.convertJSONToObject(json,InsertMessage.class);
        PositionIdentifier pos=insertMessage.getAtom().getPos();
        char c=insertMessage.getAtom().getC();
        editorController.remoteInsert(pos,c);
        return true;

    }
}
