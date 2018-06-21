package com.mattdamon.drools.dto;

import java.io.Serializable;

/**
 * 报价计算参数
 * 
 * @author MATT-DAMON
 * 
 */
public class QuoteDomain implements Serializable {

	private static final long serialVersionUID = -6570346470380188798L;

	// 用户名
	private String orgId;

	private double premiumRate;

	private double price;

	public double getPremiumRate() {
		return premiumRate;
	}

	public void setPremiumRate(double premiumRate) {
		this.premiumRate = premiumRate;
	}

	public void recordPriceLog(String city) {
		System.out.println("规则为[" + city + "]的报价记录------------->");
		System.out.println("-------------");
		System.out.println("ORGID:[" + this.getOrgId() + "].");
		System.out.println("费率:[" + this.getPremiumRate() + "].");
		System.out.println("金额:[" + this.getPrice() + "].");
		System.out.println("-------------");
		System.out.println("计算结果:[" + this.getPrice() * this.getPremiumRate() + "].");
		System.out.println("-------------|");
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}