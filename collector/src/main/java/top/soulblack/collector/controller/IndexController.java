package top.soulblack.collector.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.soulblack.collector.util.InputMDC;

/**
 * Created by lxf on 2020/11/6
 */
@RestController
@Slf4j
public class IndexController {

    @GetMapping("/index")
    public String index() {
        // MDC
        InputMDC.put();

        log.info("我是一条info日志");

        log.warn("我是一条warn日志");

        log.error("我是一条error日志");

        return "idx";
    }

}
