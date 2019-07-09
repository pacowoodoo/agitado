package com.lucainnocenti.agitado.service;

import com.lucainnocenti.agitado.enums.TadoZones;
import com.lucainnocenti.agitado.repository.entity.TempLogs;
import dev.bertolotti.tadojava.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service

public class TemperatureDiggerService {

	@Autowired
	private LoggerService loggerService;
	@Autowired
	private TemperatureLogService temperatureLogService;

	public void digTemperature() throws TadoException {
		TadoConnector connector = new TadoConnector("me@lucainnocenti.com", "boiaboia");
		connector.initialize();

		for (TadoHome home : connector.getHomes()) {
			System.out.println(home.toString());
			System.out.println(home.getState(connector));
			TadoWeather tadoWeather = home.getWeather(connector);
			for (TadoZone zone : home.getZones(connector)) {
				System.out.println(zone.toString());
				System.out.println(zone.getCapabilities(connector));
				TempLogs tempLogs = new TempLogs();
				//tempLogs.set
				TadoZones currentZone = TadoZones.valueOfId(zone.getId());
				tempLogs.setZoneId(currentZone.getId());
				tempLogs.setEventDate(ZonedDateTime.now());
				tempLogs.setExtSolarIntensity(tadoWeather.getSolarIntensity().getPercentage());
				tempLogs.setExtTemperature(tadoWeather.getOutsideTemperature().getCelsius());
				tempLogs.setTemperature(25);
				tempLogs.setHeatingActive(true);
				tempLogs.setTempLogscol("boh");
				tempLogs.setZoneDesc(currentZone.getName());
				temperatureLogService.storeTmpLogs(tempLogs);
			}
		}
	}
}
