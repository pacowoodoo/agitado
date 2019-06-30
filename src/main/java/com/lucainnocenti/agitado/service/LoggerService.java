package com.lucainnocenti.agitado.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoggerService {

    Logger logger = LogManager.getLogger();

    public void logDebug(String message) {
        try {
            logger.log(Level.DEBUG, Class.forName(Thread.currentThread().getStackTrace()[2].getClassName())+" :: "+message);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
