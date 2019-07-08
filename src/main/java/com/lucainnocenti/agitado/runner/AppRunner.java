package com.lucainnocenti.agitado.runner;

import com.lucainnocenti.agitado.enums.TadoZones;
import com.lucainnocenti.agitado.repository.entity.TempLogs;
import com.lucainnocenti.agitado.service.LoggerService;
import com.lucainnocenti.agitado.service.TempLogsService;
import dev.bertolotti.tadojava.TadoConnector;
import dev.bertolotti.tadojava.TadoHome;
import dev.bertolotti.tadojava.TadoZone;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

//servizio di raccolta dati

@Service
@RequiredArgsConstructor
public class AppRunner {

    @Autowired
    private LoggerService loggerService;
    @Autowired
    private TempLogsService tempLogsService;

    public void run() throws Exception {
        //loggerService.logError("Error altra VIA!!!");
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
                TadoZones currentZone = TadoZones.valueOfId(zone.getId());
                tempLogs.setZoneId(currentZone.getId());
                tempLogs.setEventDate(ZonedDateTime.now());
                tempLogs.setExt_umidity(60);
                tempLogs.setExt_umidity(50);
                tempLogs.setExtTemperature(20);
                tempLogs.setTemperature(25);
                tempLogs.setHeating_active(true);
                tempLogs.setTempLogscol("boh");
                tempLogs.setZoneDesc(currentZone.getName());
                tempLogsService.storeTmpLogs(tempLogs);
            }
        }

    }

    //@Scheduled(fixedDelay = 2000)
   /* public void run(String... args) throws Exception {

        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);*/
        /*TadoConnector connector = new TadoConnector("me@lucainnocenti.com", "boiaboia");
        connector.initialize();

        for (TadoHome home : connector.getHomes()) {
            System.out.println(home.toString());
            System.out.println(home.getState(connector));
            for (TadoZone zone : home.getZones(connector)) {
                System.out.println(zone.toString());
                System.out.println(zone.getCapabilities(connector));
                TempLogs tempLogs = new TempLogs();
                //tempLogs.set
                tempLogs.setZoneId(zone.getId());
                tempLogsService.storeTmpLogs(tempLogs);
            }
        }*/
        /*TempLogs tempLogs = new TempLogs();
        //tempLogs.set
        tempLogs.setZoneId(2);
        tempLogsService.storeTmpLogs(tempLogs);
    }*/
}
