package br.com.zuco.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private Logger _log = LoggerFactory.getLogger(this.getClass().getName());

    @GetMapping("/")
    public String home() {
        _log.info(
                "[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
        return "/home";
    }
    
}
