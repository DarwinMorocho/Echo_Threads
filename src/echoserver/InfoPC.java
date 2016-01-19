/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import javax.management.MBeanServerConnection;

/**
 *
 * @author gato
 */
public class InfoPC {

    public static class info {

        public static String nombrePC() {
            return System.getenv("COMPUTERNAME");
        }

        public static String Usuario() {
            return System.getProperty("user.name");
        }

        public static String Procesador() {
            return System.getenv("PROCESSOR_IDENTIFIER");
        }

        public static String SO() {
            return System.getProperty("os.name");
        }

        public static String JDK() {
            return System.getProperty("java.version");
        }

        public static String Dir() {
            return System.getProperty("user.dir");
        }

        public static Object printUsage() {
            Object value = null;
            OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
            for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
                method.setAccessible(true);
                if (method.getName().startsWith("get")
                        && Modifier.isPublic(method.getModifiers())) {

                    try {
                        value = method.invoke(operatingSystemMXBean);
                    } catch (Exception e) {
                        value = e;
                    } // try
                    System.out.println(method.getName() + " = " + value);

                } // if

            }
            return value;
        }

      
    }
}
