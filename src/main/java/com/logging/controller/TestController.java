package com.logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


@Slf4j
@RestController
public class TestController {

    @GetMapping("/view")
    public String homeView() {
        //sistem debug edilirken kullanilir info olmaz
        try {
            PrintWriter writer = new PrintWriter(new File("./logs/app_logs.log"));
            writer.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }


        //sistem debug edilirken kullanilir info olmaz
        log.info("get details metodu basladi");
        return internalLogDetail();
    }

    private String internalLogDetail(){
        try {
            log.debug("internelLogDetail metodu basladi");
            //hesaplama yapilirken info gonderilebilir
            Thread.sleep(1000);
            return "API Mesaj";
        } catch (InterruptedException e) {
            //format onemli
            log.error("Hata : {}", e);
        }
        return "";
    }

}
