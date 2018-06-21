package com.mattdamon.drools.logic.impl;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.mattdamon.drools.dto.QuoteDomain;
import com.mattdamon.drools.logic.QuoteRuleEngine;

/**
 * 规则接口实现类
 * 
 * @author MATT-DAMON
 * 
 */
public class QuoteRuleEngineImpl implements QuoteRuleEngine {

	private KieServices service = KieServices.Factory.get();
	private KieContainer container = service.getKieClasspathContainer();
	private KieSession session;

	@Override
	public void initEngine(String drools) {
		if (container != null) {
			session = container.newKieSession("ksession-" + drools + "-01");
		}
	}

	@Override
	public void refreshEnginRule(String groupId, String artifactId,
			String version) {

		container.updateToVersion(service.newReleaseId(groupId, artifactId,
				version));

	}

	@Override
	public void executeRuleEngine(QuoteDomain pointDomain) {

		session.insert(pointDomain);

		session.fireAllRules();

		session.dispose();

		session.destroy();

	}
}