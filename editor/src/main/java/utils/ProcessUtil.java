package utils;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * generate id for user
 */
public class ProcessUtil {
    /**
     * get the process id ,it can be used to distinguish different users in one computer
     * @return
     */
    public static Integer getProcessID() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

        return Integer.valueOf(runtimeMXBean.getName().split("@")[0]);
    }

    /**
     * get uuid,it can be used to distinguish different users in distributed system
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");


    }

    /**
     *
     * @return
     */
    public static String getProcessID2(){
        return new BigInteger(130, new SecureRandom()).toString(32);
    }

    public static void main(String[] args) {
        System.out.println(getProcessID());
        System.out.println(getUUID());
        System.out.println(getProcessID2());
    }
}
