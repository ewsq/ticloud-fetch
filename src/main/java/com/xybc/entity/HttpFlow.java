package com.xybc.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class HttpFlow implements Serializable {
	private String uid;
	private String method;
	private String sip;
	private String url;
	private String dip;
	private Long ts;
	private String total_len;
	private String sp;
	private String dp;
}