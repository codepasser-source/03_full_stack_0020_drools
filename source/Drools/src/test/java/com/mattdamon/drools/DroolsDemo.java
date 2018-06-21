package com.mattdamon.drools;

import java.io.IOException;

import com.mattdamon.drools.dto.QuoteDomain;
import com.mattdamon.drools.logic.QuoteRuleEngine;
import com.mattdamon.drools.logic.impl.QuoteRuleEngineImpl;

public class DroolsDemo {

	public static void main(String[] args) throws IOException {
		System.setProperty("jxl.encoding", "UTF-8");

		QuoteRuleEngine pointRuleEngine = new QuoteRuleEngineImpl();
		System.out.println("初始化规则引擎...");
		pointRuleEngine.initEngine();
		System.out.println("初始化规则引擎结束.");
		final QuoteDomain pointDomain = new QuoteDomain();

		pointDomain.setOrgId("0000");
		pointDomain.setPrice(100);

		pointRuleEngine.executeRuleEngine(pointDomain);

		System.out.println("excute completed...");
	}
}
