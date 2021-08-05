package com.xybc.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SwvWebFlow implements Serializable {
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
	private String mala_url_type;
	private String url;
}