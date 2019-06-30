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
        logErrorWithLevel(message, Level.DEBUG);
    }

    public void logError(String message) {
       logErrorWithLevel(message, Level.ERROR);
    }

    private void logErrorWithLevel(String message, Level level){
        try {
            logger.log(level, Class.forName(Thread.currentThread().getStackTrace()[2].getClassName())+" :: "+message);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
