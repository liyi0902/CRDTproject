package editor.message.handlers;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import editor.controller.EditorController;
import editor.message.MessageHandler;
import editor.network.Connection;

public class JoinHandler extends MessageHandler {
    private EditorController editorController;

    public JoinHandler(EditorController editorController) {
        this.editorController = editorController;
    }

    @Override
    public boolean processMessage(JSONObject json, Connection connection) {

        return true;
    }




}
