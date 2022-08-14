package com.gafur.logging.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 1. Loglama Asynkron olmalı
 * 2. printStackTrace ve System.out.ptintln kullanılmamalı
 * 3. Sensitive data olmamalı (passpord, vs )
 * 4. Tum loglar markezi toplanmalidir, belli formatta
 * 5. Level'lar dikkatli kullanilmalidir
 * 6. Farkli level'lar icin farkli appendarlar kullanilabilir
 */

@Slf4j
@RestController
@RequestMapping("/log")
public class LogEndpoint {

    @GetMapping
    public String getDetails(){
        log.info("get details method is started");
        return internalLogDeatil();
    }

    private String internalLogDeatil(){
        try {
            log.debug("internalLogDeatil method is started");
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException ex){
            log.error("internalLogDeatil method throws ex: {}", ex.getMessage());
        }
        return "API Message";
    }
}
