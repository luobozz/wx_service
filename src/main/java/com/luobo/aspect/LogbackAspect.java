package com.luobo.aspect;


import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.luobo.log.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * LogbackAspect class
 *
 * @author zhouliang
 * @date 2020/6/10 13:17
 */

@Aspect
@Component
public class LogbackAspect {

    public LogbackAspect() {
    }

    @Pointcut("execution(* com.luobo.controller.*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void requestPath(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String ctx = request.getContextPath() + request.getServletPath();
        MDC.put("uniqueKey", String.valueOf((long)ctx.hashCode() + System.currentTimeMillis()));
        Log.info("<{}> <{}> {}:{},parameters:{},sign:{},args:{}", new Object[]{request.getMethod(), ctx, this.getIpAddr(request), this.getPort(request), this.formatParameterMap(request), joinPoint.getSignature().toLongString(), joinPoint.getArgs()});
    }

    @AfterReturning(
            returning = "result",
            pointcut = "pointcut()"
    )
    public void requestResult(Object result) {
        Log.info("返回结果:{}", this.formatValue(result, 300));
    }

    public Map<String, String> formatParameterMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap();

        String name;
        String value;
        for(Enumeration names = request.getParameterNames(); names.hasMoreElements(); map.put(name, value)) {
            name = (String)names.nextElement();
            String[] values = request.getParameterValues(name);
            value = "";
            if (values.length <= 1) {
                if (values.length > 0) {
                    value = values[0];
                }
            } else {
                String[] var7 = values;
                int var8 = values.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    String v = var7[var9];
                    value = value.concat(",").concat(v);
                }

                value = value.substring(1);
            }
        }

        return map;
    }

    public String getIpAddr(HttpServletRequest request) {
        return request.getHeader("x-real-ip") != null ? request.getHeader("x-real-ip") : request.getRemoteAddr();
    }

    public int getPort(HttpServletRequest request) {
        return request.getHeader("x-real-port") != null ? Integer.parseInt(request.getHeader("x-real-port")) : request.getRemotePort();
    }

    public String formatValue(Object value, int limitLength) {
        if (value == null) {
            return "";
        } else {
            String str;
            if (value instanceof CharSequence) {
                str = "\"" + value + "\"";
            } else {
                try {
                    str = value.toString();
                } catch (Throwable var5) {
                    str = var5.toString();
                }
            }

            return str.length() > limitLength ? str.substring(0, limitLength) + " (truncated)..." : str;
        }
    }
}
