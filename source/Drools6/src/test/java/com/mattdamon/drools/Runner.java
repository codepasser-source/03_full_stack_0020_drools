package com.mattdamon.drools;

import com.mattdamon.drools.dto.QuoteDomain;
import com.mattdamon.drools.logic.QuoteRuleEngine;
import com.mattdamon.drools.logic.impl.QuoteRuleEngineImpl;

public class Runner {

	public static void main(String[] args) {
		QuoteRuleEngine engine = new QuoteRuleEngineImpl();

		engine.initEngine("dtable");
		QuoteDomain quoteDomain = new QuoteDomain();
		quoteDomain.setOrgId("0000");
		engine.executeRuleEngine(quoteDomain);

		engine.initEngine("rule");
		engine.executeRuleEngine(quoteDomain);

	}
}
