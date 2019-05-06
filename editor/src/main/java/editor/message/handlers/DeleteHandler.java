package editor.message.handlers;

import com.alibaba.fastjson.JSONObject;

import editor.algorithm.logoot.PositionIdentifier;
import editor.controller.EditorController;
import editor.message.MessageHandler;
import editor.message.messages.DeleteMessage;
import editor.network.Connection;
import editor.utils.JsonUtil;

public class DeleteHandler extends MessageHandler {

    private EditorController editorController;

    public DeleteHandler(EditorController editorController) {
        this.editorController = editorController;
    }

    @Override
    public boolean processMessage(JSONObject json, Connection connection) {
        String msg=json.toJSONString();
        for(Connection c:this.editorController.getConnections()){
            c.writeMsg(msg);
        }

        DeleteMessage<PositionIdentifier> deleteMessage= JsonUtil.convertJSONToObject(json,DeleteMessage.class);
        PositionIdentifier pos=deleteMessage.getPos();
        editorController.remoteDelete(pos);
        return true;

    }



}
