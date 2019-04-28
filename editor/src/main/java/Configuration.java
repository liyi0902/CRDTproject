import utils.ProcessUtil;

public class Configuration {
    public static String localhost="localhost";
    public static String processId= ProcessUtil.getUUID();
    public static int localpost=8000;

    public static void setLocalhost(String localhost) {
        Configuration.localhost = localhost;
    }

    public static void setProcessId(String processId) {
        Configuration.processId = processId;
    }

    public static void setLocalpost(int localpost) {
        Configuration.localpost = localpost;
    }

    public static String getLocalhost() {
        return localhost;
    }

    public static String getProcessId() {
        return processId;
    }

    public static int getLocalpost() {
        return localpost;
    }
}
