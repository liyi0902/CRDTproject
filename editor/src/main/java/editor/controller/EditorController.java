package editor.controller;


import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import editor.Configuration;
import editor.message.Message;
import editor.message.MessageHandler;
import editor.message.MessageType;
import editor.message.handlers.*;
import editor.network.Connection;
import editor.network.ConnectionListener;
import editor.utils.JsonUtil;
import editor.view.EditorFrame;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * the operation of the edit and the network system
 */
@Slf4j
public class EditorController {

    private static EditorFrame editorFrame;
    private static ConnectionListener connectionListener;
    private static ArrayList<Connection> connections;
    private boolean flag = false;
    private volatile static EditorController newInstance;
    private HashMap<String, MessageHandler> handlerMap;


    private EditorController(){
        editorFrame=EditorFrame.getInstance();
        connections = new ArrayList<Connection>();
        handlerMap=new HashMap<>();
        this.initialHandlers();
        if (Configuration.getRemoteHost() != null) {
            // if remote server host provided, connect to it and then wait for response to start listener.
            this.initiateConnection();
        } else {
            this.startListener();
        }

    }

    /**
     * start a listener to accept sockets
     */
    public void startListener() {
        try {
            ConnectionListener connectionListener = new ConnectionListener();
        } catch (IOException e) {
            log.error("failed to startup a listening thread: " + e);
            System.exit(-1);
        }
    }


    /**
     *  make a connection to another server if remote hostname is supplied
     */
    public void initiateConnection() {
        try {
            startListener();
            Socket s = new Socket(Configuration.getRemoteHost(), Configuration.getRemotePort());
            Connection c = outgoingConnection(s);
            //todo syc the doc
//            c.writeMsg();

        } catch (IOException e) {
            log.error("failed to make connection to " + Configuration.getRemoteHost() + ":" + Configuration.getRemotePort() + " :" + e);
            connectionListener.setFlag(true);
            System.exit(-1);
        }

    }

    public synchronized void connectionClosed(Connection con) {
        if (!flag) {
            log.info("Remove connection {} from list", con.getSocket().getRemoteSocketAddress());
            connections.remove(con);
        }
    }

    /**
     * A new incoming connection has been established, and a reference is returned to it
     */
    public synchronized Connection incomingConnection(Socket s) throws IOException {
        log.debug("incomming connection: " + Configuration.socketAddress(s));
        Connection c = new Connection(s);
        connections.add(c);
        return c;
    }

    /**
     * A new outgoing connection has been established, and a reference is returned to it
     */
    public synchronized Connection outgoingConnection(Socket s) throws IOException {
        log.debug("outgoing connection: " + Configuration.socketAddress(s));
        Connection c = new Connection(s);
        connections.add(c);
        return c;
    }


    public static EditorController getInstance(){
        if(newInstance==null){
            synchronized (EditorController.class){
                if(newInstance==null){
                    newInstance=new EditorController();
                }
            }
        }
        return newInstance;
    }

    private void initialHandlers() {
        handlerMap.put(MessageType.JOIN.name(),new JoinHandler(this));
        handlerMap.put(MessageType.SYC.name(),new SycHandler(this));
        handlerMap.put(MessageType.DELETE.name(),new DeleteHandler(this));
        handlerMap.put(MessageType.INSET.name(),new InsertHandler(this));
        handlerMap.put(MessageType.EXIT.name(),new ExitHandler(this));

    }

    /**
     * process message
     * @param con
     * @param msg
     * @return
     */
    public synchronized boolean process(Connection con, String msg) {
        log.debug("received message [{}] from [{}]", msg, Configuration.socketAddress(con.getSocket()));

        boolean isSucc = false;
        try {
            JSONObject jsonObject = JsonUtil.convertStringToJSONObject(msg);
            String type=jsonObject.getString("type");
            MessageHandler h = handlerMap.get(type);
            if (h != null) {
                isSucc = h.processMessage(jsonObject, con);
            } else {
                log.error("Cannot find message handler for message type [{}]", type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSucc;
    }



    public static ConnectionListener getConnectionListener() {
        return connectionListener;
    }

    public static void setConnectionListener(ConnectionListener connectionListener) {
        EditorController.connectionListener = connectionListener;
    }

    public static ArrayList<Connection> getConnections() {
        return connections;
    }

    public static void setConnections(ArrayList<Connection> connections) {
        EditorController.connections = connections;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
        connectionListener.setFlag(true);
    }
}