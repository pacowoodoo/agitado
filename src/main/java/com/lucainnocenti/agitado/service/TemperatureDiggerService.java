package com.lucainnocenti.agitado.service;

import com.lucainnocenti.agitado.enums.TadoZoneType;
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
			home.getZones(connector)
				.stream()
				.forEach( zone -> {
					TempLogs tempLog = new TempLogs();
					//tempLogs.set
					TadoZoneType zoneType = TadoZoneType.valueOfId(zone.getId());
					try {
						zone.getState(connector).getSensorDataPoints().stream().forEach(
							datapoint -> {
								if(datapoint.getName().equals("humidity")){
									tempLog.setUmidity((double)datapoint.getDatapoint().get("percentage"));
								}

								if(datapoint.getName().equals("insideTemperature")){
									tempLog.setTemperature((double)datapoint.getDatapoint().get("celsius"));
								}
							}
						);
						zone.getState(connector).getActivityDataPoints().forEach(
							activityDataPoint -> {
								if(activityDataPoint.getName().equals("heatingPower")){
									tempLog.setHeatingPercentage((double)activityDataPoint.getDatapoint().get("percentage"));
									tempLog.setHeatingActive(tempLog.getHeatingPercentage() > 0);
								}
							}
						);
						tempLog.setTempGoal(zone.getState(connector).getSetting().getTemperature().getCelsius());
					} catch (TadoException e) {
						e.printStackTrace();
					}
					tempLog.setZoneId(zoneType.getId());
					tempLog.setEventDate(ZonedDateTime.now());
					tempLog.setExtSolarIntensity(tadoWeather.getSolarIntensity().getPercentage());
					tempLog.setExtTemperature(tadoWeather.getOutsideTemperature().getCelsius());

					tempLog.setZoneDesc(zoneType.getName());
					temperatureLogService.storeTmpLogs(tempLog);
				});
		}
	}
}
