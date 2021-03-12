package com.luobo.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Log class
 *
 * @author zhouliang
 * @date 2020/6/10 13:21
 */

public class Log {
    private static Logger getLogger() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return LoggerFactory.getLogger(stackTrace[3].getClassName());
    }

    public static void debug(String msg) {
        getLogger() .debug(msg);
    }

    public static void debug(String format, Object... arguments) {
        getLogger() .debug(format, arguments);
    }

    public static void debug(String format, Throwable t) {
        getLogger() .debug(format, t);
    }

    public static void error(String msg) {
        getLogger() .error(msg);
    }

    public static void error(String format, Object... arguments) {
        getLogger() .error(format, arguments);
    }

    public static void error(String format, Throwable t) {
        getLogger() .error(format, t);
    }

    public static void error(Throwable t) {
        getLogger() .error("{}", t);
    }

    public static void warn(String msg) {
        getLogger() .warn(msg);
    }

    public static void warn(String format, Object... arguments) {
        getLogger() .warn(format, arguments);
    }

    public static void warn(String format, Throwable t) {
        getLogger() .warn(format, t);
    }

    public static void info(String msg) {
        getLogger() .info(msg);
    }

    public static void info(String format, Object... arguments) {
        getLogger() .info(format, arguments);
    }

    public static void info(String format, Throwable t) {
        getLogger() .info(format, t);
    }
}
