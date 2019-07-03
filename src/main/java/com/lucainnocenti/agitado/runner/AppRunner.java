package com.lucainnocenti.agitado.runner;

import com.lucainnocenti.agitado.repository.entity.TempLogs;
import com.lucainnocenti.agitado.service.LoggerService;
import com.lucainnocenti.agitado.service.TempLogsService;
import dev.bertolotti.tadojava.TadoConnector;
import dev.bertolotti.tadojava.TadoException;
import dev.bertolotti.tadojava.TadoHome;
import dev.bertolotti.tadojava.TadoZone;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//servizio di raccolta dati

@Component
@EnableScheduling
@RequiredArgsConstructor
public class AppRunner implements CommandLineRunner {

    private LoggerService loggerService;
    private TempLogsService tempLogsService;

    @Override
    public void run(String... args) throws Exception {
        loggerService.logError("Error altra VIA!!!");


    }

    @Scheduled(fixedDelay = 2000)
    public void scheduleFixedDelayTask() throws TadoException {

        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
        TadoConnector connector = new TadoConnector("me@lucainnocenti.com", "boiaboia");
        connector.initialize();

        for (TadoHome home : connector.getHomes()) {
            System.out.println(home.toString());
            System.out.println(home.getState(connector));
            for (TadoZone zone : home.getZones(connector)) {
                System.out.println(zone.toString());
                System.out.println(zone.getCapabilities(connector));
                TempLogs tempLogs = new TempLogs();
                //tempLogs.set
                tempLogsService.storeTmpLogs(tempLogs);
            }
        }

    }
}
