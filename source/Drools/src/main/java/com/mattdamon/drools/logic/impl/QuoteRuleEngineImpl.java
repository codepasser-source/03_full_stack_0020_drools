package com.mattdamon.drools.logic.impl;

import java.util.Collection;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.AgendaFilter;

import com.mattdamon.drools.dto.QuoteDomain;
import com.mattdamon.drools.logic.QuoteRuleEngine;

/**
 * 规则接口实现类
 * 
 * @author MATT-DAMON
 * 
 */
public class QuoteRuleEngineImpl implements QuoteRuleEngine {

	private KnowledgeBase ruleBase;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.drools.demo.point.PointRuleEngine#initEngine()
	 */
	public void initEngine() {
		// 设置时间格式
		System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");

		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("quote.drl"),
				ResourceType.DRL);
		ruleBase = KnowledgeBaseFactory.newKnowledgeBase();
		ruleBase.addKnowledgePackages(kbuilder.getKnowledgePackages());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.drools.demo.point.PointRuleEngine#refreshEnginRule()
	 */
	public void refreshEnginRule() {
		if (ruleBase != null) {
			Collection<KnowledgePackage> packages = ruleBase
					.getKnowledgePackages();
			for (KnowledgePackage pg : packages) {
				ruleBase.removeKnowledgePackage(pg.getName());
			}

			initEngine();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.drools.demo.point.PointRuleEngine#executeRuleEngine(com.drools.demo
	 * .point.PointDomain)
	 */
	public void executeRuleEngine(final QuoteDomain pointDomain) {
		if (null == ruleBase.getKnowledgePackages()
				|| 0 == ruleBase.getKnowledgePackages().size()) {
			return;
		}

		StatefulKnowledgeSession statefulSession = ruleBase
				.newStatefulKnowledgeSession();
		statefulSession.insert(pointDomain);
		// statefulSession.fireAllRules();
		statefulSession.fireAllRules(new AgendaFilter() {
			@Override
			public boolean accept(org.drools.runtime.rule.Activation activation) {
				// TODO Auto-generated method stub
				return !activation.getRule().getName().contains("_test");
			}
		});
		// fire

		statefulSession.dispose();
	}
}