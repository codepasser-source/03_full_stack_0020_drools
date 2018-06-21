package com.mattdamon.drools.logic;

import com.mattdamon.drools.dto.QuoteDomain;

/**
 * 规则接口
 * 
 * @author MATT-DAMON
 * 
 */
public interface QuoteRuleEngine {

	/**
	 * 初始化规则引擎
	 */
	public void initEngine();

	/**
	 * 刷新规则引擎中的规则
	 */
	public void refreshEnginRule();

	/**
	 * 执行规则引擎
	 * 
	 * @param pointDomain
	 *            积分Fact
	 */
	public void executeRuleEngine(final QuoteDomain pointDomain);
}