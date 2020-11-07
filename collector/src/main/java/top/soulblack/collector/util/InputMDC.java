package top.soulblack.collector.util;

import org.slf4j.MDC;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by lxf on 2020/11/7
 */
@Component
public class InputMDC implements EnvironmentAware {

    private static Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        InputMDC.environment = environment;
    }

    public static void put() {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
            String ip = addr.getHostAddress().toString(); //获取本机ip
            String hostName = addr.getHostName().toString(); //获取本机计算机名称
            MDC.put("ip", ip);
            MDC.put("hostname", hostName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


        MDC.put("applicationName", environment.getProperty("spring.application.name"));

    }
}
