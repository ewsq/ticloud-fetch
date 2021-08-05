package com.xybc.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class DbFlow implements Serializable {
	private String uid;
	private Long ts;
	private String sip;
	private String sp;
	private String dip;
	private String dp;
	private String cmd;
}