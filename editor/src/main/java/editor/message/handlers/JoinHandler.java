package editor.message.handlers;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import editor.algorithm.logoot.Atom;
import editor.controller.EditorController;
import editor.message.MessageHandler;
import editor.message.MessageType;
import editor.message.messages.InsertMessage;
import editor.message.messages.SycMessage;
import editor.network.Connection;

import java.util.ArrayList;

/**
 * handle the join message
 */
public class JoinHandler extends MessageHandler {
    private EditorController editorController;

    public JoinHandler(EditorController editorController) {
        this.editorController = editorController;
    }

    @Override
    public boolean processMessage(JSONObject json, Connection connection) {

        // when receive join message,send the syc message
        ArrayList<Atom> atoms=editorController.getDoc().getAtoms();
        System.out.println("atoms size"+atoms.size());
        connection.sendSycMessage(atoms);
        editorController.getConnections().add(connection);
        return true;
    }




}
