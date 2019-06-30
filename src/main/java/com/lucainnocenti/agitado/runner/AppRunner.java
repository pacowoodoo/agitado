package com.lucainnocenti.agitado.runner;

import com.lucainnocenti.agitado.service.LoggerService;
import dev.bertolotti.tadojava.TadoConnector;
import dev.bertolotti.tadojava.TadoHome;
import dev.bertolotti.tadojava.TadoZone;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {

    @Autowired
    private LoggerService loggerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Logger logger = LogManager.getLogger(AppRunner.class);
        logger.log(Level.DEBUG,"VIA!!!");
        TadoConnector connector = new TadoConnector("me@lucainnocenti.com", "boiaboia");

        for (TadoHome home : connector.getHomes()) {
            System.out.println(home.toString());
            System.out.println(home.getState(connector));
            for (TadoZone zone : home.getZones(connector)) {
                System.out.println(zone.toString());
                //System.out.println(zone.getZoneState(connector));
            }
        }
    }
}
