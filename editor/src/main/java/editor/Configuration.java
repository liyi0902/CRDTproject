package editor;

import java.net.Socket;

public class Configuration {
    public static String localHost ="localhost";
    public static String processId = "";
    public static int localPort = 8000;
    private static String remoteHost = null;
    private static int remotePort = 8000;

    public static void setLocalHost(String localHost) {
        Configuration.localHost = localHost;
    }

    public static void setProcessId(String processId) {
        Configuration.processId = processId;
    }

    public static void setLocalPort(int localPort) {
        Configuration.localPort = localPort;
    }

    public static String getLocalHost() {
        return localHost;
    }

    public static String getProcessId() {
        return processId;
    }

    public static int getLocalPort() {
        return localPort;
    }

    public static String getRemoteHost() {
        return remoteHost;
    }

    public static void setRemoteHost(String remoteHost) {
        Configuration.remoteHost = remoteHost;
    }

    public static int getRemotePort() {
        return remotePort;
    }

    public static void setRemotePort(int remotePort) {
        Configuration.remotePort = remotePort;
    }

    public static String socketAddress(Socket socket){
        return socket.getInetAddress()+":"+socket.getPort();
    }
}
