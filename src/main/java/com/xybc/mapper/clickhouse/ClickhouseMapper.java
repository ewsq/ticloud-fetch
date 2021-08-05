package com.xybc.mapper.clickhouse;

import com.xybc.entity.DbFlow;
import com.xybc.entity.HttpFlow;
import com.xybc.entity.SensorFlow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClickhouseMapper {

	void insertDbFlow(@Param("dbFlow") List<DbFlow> dbFlowList);
	void insertHttpFlow(@Param("httpFlowList") List<HttpFlow> httpFlowList);
	void insertSensorFlow(@Param("sensorFlowList") List<SensorFlow> sensorFlowList);

}
