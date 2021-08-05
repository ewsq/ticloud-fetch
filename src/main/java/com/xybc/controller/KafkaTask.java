package com.xybc.controller;

import com.alibaba.fastjson.JSONObject;
import com.xybc.entity.*;
import com.xybc.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** 
* @Description: 山西监听kafka迪普数据存入tc_alarm,clickhouse
* @Author: wangkang 
* @Date: 2021/5/20
*/ 
@Component
public class KafkaTask {

	@Autowired
	private KafkaService kafkaService;

	private List<SwvWebFlow> swvWebFlowList = new ArrayList<>();
	private List<SwvProgramFlow> swvProgramFlowList = new ArrayList<>();
	private List<DbFlow> dbFlowList = new ArrayList<>();
	private List<HttpFlow> httpFlowList = new ArrayList<>();
	private List<SensorFlow> sensorFlowList = new ArrayList<>();

	@KafkaListener(topics = {"swv_web_flow"})
	public void listenSwvWebFlow(String record, Acknowledgment acknowledgment) {
		System.out.println("=======kafka=======监听swv_web_flow消息：" + record);
		SwvWebFlow swvWebFlow = JSONObject.parseObject(record, SwvWebFlow.class);
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		swvWebFlow.setId(id);
		System.out.println("=======swvWebFlowList：size=======：" + swvWebFlowList.size());
		swvWebFlowList.add(swvWebFlow);
		if(swvWebFlowList.size() < 1000){
			acknowledgment.acknowledge();
		}else{
			kafkaService.insertSwvWebFlow(swvWebFlowList);
			swvWebFlowList.clear();
			acknowledgment.acknowledge();
		}
	}

	@KafkaListener(topics = {"swv_program_flow"})
	public void listenSwvProgramFlow(String record, Acknowledgment acknowledgment) {
		System.out.println("=======kafka=======监听swv_program_flow消息：" + record);
		SwvProgramFlow swvProgramFlow = JSONObject.parseObject(record, SwvProgramFlow.class);
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		swvProgramFlow.setId(id);
		System.out.println("=======swvProgramFlowList：size=======：" + swvProgramFlowList.size());
		swvProgramFlowList.add(swvProgramFlow);
		if(swvProgramFlowList.size() < 1000){
			acknowledgment.acknowledge();
		}else{
			kafkaService.insertSwvProgramFlow(swvProgramFlowList);
			swvProgramFlowList.clear();
			acknowledgment.acknowledge();
		}
	}

	@KafkaListener(topics = {"db_flow"})
	public void listenDbFlow(String record, Acknowledgment acknowledgment) {
//		System.out.println("=======kafka=======监听db_flow消息：" + record);
		DbFlow dbFlow = JSONObject.parseObject(record, DbFlow.class);
		System.out.println("=======dbFlowList：size=======：" + dbFlowList.size());
		dbFlowList.add(dbFlow);
		if(dbFlowList.size() < 1000){
			acknowledgment.acknowledge();
		}else{
			kafkaService.insertDbFlow(dbFlowList);
			dbFlowList.clear();
			acknowledgment.acknowledge();
		}
	}

	@KafkaListener(topics = {"http_flow"})
	public void listenHttpFlow(String record, Acknowledgment acknowledgment) {
//		System.out.println("=======kafka=======监听http_flow消息：" + record);
		HttpFlow httpFlow = JSONObject.parseObject(record, HttpFlow.class);
		System.out.println("=======httpFlowList：size=======：" + httpFlowList.size());
		httpFlowList.add(httpFlow);
		if(httpFlowList.size() < 1000){
			acknowledgment.acknowledge();
		}else{
			kafkaService.insertHttpFlow(httpFlowList);
			httpFlowList.clear();
			acknowledgment.acknowledge();
		}
	}

	@KafkaListener(topics = {"sensor_flow"})
	public void listenSensorFlow(String record, Acknowledgment acknowledgment) {
//		System.out.println("=======kafka=======监听sensor_flow消息：" + record);
		SensorFlow sensorFlow = JSONObject.parseObject(record, SensorFlow.class);
		System.out.println("=======sensorFlowList：size=======：" + sensorFlowList.size());
		sensorFlowList.add(sensorFlow);
		if(sensorFlowList.size() < 1000){
			acknowledgment.acknowledge();
		}else{
			kafkaService.insertSensorFlow(sensorFlowList);
			sensorFlowList.clear();
			acknowledgment.acknowledge();
		}
	}

}