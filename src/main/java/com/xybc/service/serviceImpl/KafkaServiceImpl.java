package com.xybc.service.serviceImpl;

import com.xybc.entity.*;
import com.xybc.mapper.clickhouse.ClickhouseMapper;
import com.xybc.mapper.mysql.MysqlMapper;
import com.xybc.service.KafkaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KafkaServiceImpl implements KafkaService {

	@Resource
	private MysqlMapper mysqlMapper;
	@Resource
	private ClickhouseMapper clickhouseMapper;

	@Override
	public void insertSwvWebFlow(List<SwvWebFlow> swvWebFlowList) {
		mysqlMapper.insertSwvWebFlow(swvWebFlowList);
	}

	@Override
	public void insertSwvProgramFlow(List<SwvProgramFlow> swvProgramFlowList) {
		mysqlMapper.insertSwvProgramFlow(swvProgramFlowList);
	}

	@Override
	public void insertDbFlow(List<DbFlow> dbFlowList) {
		clickhouseMapper.insertDbFlow(dbFlowList);
	}

	@Override
	public void insertHttpFlow(List<HttpFlow> httpFlowList) {
		clickhouseMapper.insertHttpFlow(httpFlowList);
	}

	@Override
	public void insertSensorFlow(List<SensorFlow> sensorFlowList) {
		clickhouseMapper.insertSensorFlow(sensorFlowList);
	}
}