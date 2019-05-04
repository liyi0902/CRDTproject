package editor.message;

import com.alibaba.fastjson.JSONObject;
import editor.network.Connection;


public abstract class MessageHandler {

	public abstract boolean processMessage(JSONObject json, Connection connection);

}
