package com.xybc.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SensorFlow implements Serializable {
	private String uid;
	private String sensor_ip;
	private String sample_time;
	private String resp_bytes;
	private String sip;
	private String stat_start;
	private String resp_pkts;
	private String dip;
	private String proto;
	private String orig_bytes;
	private String stat_end;
	private String orig_pkts;
	private String probe_ip;
	private String sp;
	private String dp;
}