package com.lucainnocenti.restapi.runner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import TadoConnector;



public class AppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Logger logger = LogManager.getLogger(AppRunner.class);
        logger.log(Level.DEBUG,"VIA!!!");
        TadoConnector connector = new TadoConnector("your@email.com", "Password123!");

    }
}
