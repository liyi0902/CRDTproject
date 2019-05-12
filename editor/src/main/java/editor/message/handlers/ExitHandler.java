package editor.message.handlers;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import editor.controller.EditorController;
import editor.message.MessageHandler;
import editor.network.Connection;
import lombok.extern.slf4j.Slf4j;

/**
 * handle the exit message
 */
@Slf4j
public class ExitHandler extends MessageHandler {

    private EditorController editorController;

    public ExitHandler(EditorController editorController) {
        this.editorController = editorController;
    }

    @Override
    public boolean processMessage(JSONObject json, Connection connection) {
        log.info("Logout request from {} is received.",connection.getSocket().getRemoteSocketAddress());
        connection.closeCon();
        editorController.connectionClosed(connection);
        return true;
    }
}
