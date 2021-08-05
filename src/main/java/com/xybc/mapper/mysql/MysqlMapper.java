package com.xybc.mapper.mysql;

import com.xybc.entity.SwvProgramFlow;
import com.xybc.entity.SwvWebFlow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MysqlMapper {
	void insertSwvWebFlow(@Param("swvWebFlow") List<SwvWebFlow> swvWebFlowList);
	void insertSwvProgramFlow(@Param("swvProgramFlow") List<SwvProgramFlow> swvProgramFlowList);
}
