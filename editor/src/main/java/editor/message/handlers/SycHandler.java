package editor.message.handlers;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import editor.algorithm.logoot.Atom;
import editor.controller.EditorController;
import editor.message.MessageHandler;
import editor.message.messages.SycMessage;
import editor.network.Connection;
import editor.utils.JsonUtil;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * handle the syc message
 */
public class SycHandler extends MessageHandler {

    private EditorController editorController;

    public SycHandler(EditorController editorController) {
        this.editorController = editorController;
    }

    @Override
    public boolean processMessage(JSONObject json, Connection connection) {

        SycMessage<CopyOnWriteArrayList<Atom>> sycMessage= JsonUtil.convertJSONToObject(json,new TypeReference<SycMessage<CopyOnWriteArrayList<Atom>>>(){});

        System.out.println(sycMessage.toString());
        CopyOnWriteArrayList<Atom> atoms=sycMessage.getData();
        System.out.println("recevie atoms size"+atoms.size());
        editorController.sycData(atoms);

        return true;
    }




}
