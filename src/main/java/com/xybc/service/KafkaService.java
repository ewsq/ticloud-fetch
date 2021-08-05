package com.xybc.service;

import com.xybc.entity.*;

import java.util.List;

public interface KafkaService {
	void insertSwvWebFlow(List<SwvWebFlow> swvWebFlowList);
	void insertSwvProgramFlow(List<SwvProgramFlow> swvProgramFlowList);
	void insertDbFlow(List<DbFlow> dbFlowList);
	void insertHttpFlow(List<HttpFlow> httpFlowList);
	void insertSensorFlow(List<SensorFlow> sensorFlowList);
}
