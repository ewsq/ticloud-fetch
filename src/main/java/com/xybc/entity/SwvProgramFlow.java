package com.xybc.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SwvProgramFlow implements Serializable {
	private String id;
	private String uid;
	private String ts;
	private String sip;
	private String sp;
	private String dip;
	private String dp;
	private String sensor_ip;
	private String probe_ip;
	private String sample_time;
	private String malware_type;
	private String virusname;
	private String md5;
}