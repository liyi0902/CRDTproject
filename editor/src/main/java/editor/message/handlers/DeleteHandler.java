package editor.message.handlers;

import com.alibaba.fastjson.JSONObject;

import editor.controller.EditorController;
import editor.message.MessageHandler;
import editor.network.Connection;

public class DeleteHandler extends MessageHandler {

    private EditorController editorController;

    public DeleteHandler(EditorController editorController) {
        this.editorController = editorController;
    }

    @Override
    public boolean processMessage(JSONObject json, Connection connection) {
        return false;
    }



}
