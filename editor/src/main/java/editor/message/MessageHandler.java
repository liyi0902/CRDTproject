package editor.message;

import com.alibaba.fastjson.JSONObject;
import editor.network.Connection;

/**
 * abstract class of message handler
 */
public abstract class MessageHandler {

	public abstract boolean processMessage(JSONObject json, Connection connection);

}
