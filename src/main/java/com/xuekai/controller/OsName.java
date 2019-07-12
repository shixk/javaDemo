package com.xuekai.controller;

import com.xuekai.entity.SettlementRule;

public class OsName {
	public static void main(String[] args) {

		System.out.println(System.getProperty("os.name"));

		SettlementRule rule=new SettlementRule();
		rule.setId(1);
		rule.setInvoiceFlag("need_invoice");
		rule.setPayFlag("need_pay");

		SettlementRule rule1=new SettlementRule();

		rule1.setId(2);
		rule1.setInvoiceFlag("need_invoice");
		rule1.setPayFlag("need_pay");

	}
}
