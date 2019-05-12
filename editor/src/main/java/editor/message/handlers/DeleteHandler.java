package editor.message.handlers;

import com.alibaba.fastjson.JSONObject;

import com.alibaba.fastjson.TypeReference;
import editor.algorithm.logoot.Atom;
import editor.algorithm.logoot.PositionIdentifier;
import editor.controller.EditorController;
import editor.message.MessageHandler;
import editor.message.messages.DeleteMessage;
import editor.message.messages.InsertMessage;
import editor.network.Connection;
import editor.utils.JsonUtil;

/**
 * handle the delete message
 */
public class DeleteHandler extends MessageHandler {

    private EditorController editorController;

    public DeleteHandler(EditorController editorController) {
        this.editorController = editorController;
    }

    @Override
    public boolean processMessage(JSONObject json, Connection connection) {
        String msg=json.toJSONString();
        //send the msg to other process
        for(Connection c:this.editorController.getConnections()){
            if(c!=connection){
                c.writeMsg(msg);
            }
        }

        DeleteMessage<PositionIdentifier> deleteMessage= JsonUtil.convertJSONToObject(json,new TypeReference<DeleteMessage<PositionIdentifier>>(){});
        PositionIdentifier pos=deleteMessage.getPos();
        editorController.remoteDelete(pos);
        return true;

    }



}
