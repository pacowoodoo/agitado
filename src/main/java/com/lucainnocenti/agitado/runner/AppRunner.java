package com.lucainnocenti.agitado.runner;

import com.lucainnocenti.agitado.service.LoggerService;
import com.lucainnocenti.agitado.service.TemperatureDiggerService;
import com.lucainnocenti.agitado.service.TemperatureLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//servizio di raccolta dati

@Service
@RequiredArgsConstructor
public class AppRunner {

    @Autowired
    private LoggerService loggerService;
    @Autowired
    private TemperatureDiggerService temperatureLogService;

    public void run() throws Exception {
        //loggerService.logError("Error altra VIA!!!");
        temperatureLogService.digTemperature();

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
                temperatureLogService.storeTmpLogs(tempLogs);
            }
        }*/
        /*TempLogs tempLogs = new TempLogs();
        //tempLogs.set
        tempLogs.setZoneId(2);
        temperatureLogService.storeTmpLogs(tempLogs);
    }*/
}
