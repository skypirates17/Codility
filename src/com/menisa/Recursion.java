package com.menisa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Recursion {

	public static void main(String[] args) {
		// Request Body
		Map<String, Object> requestParams = new HashMap<>();
		requestParams.put("subscriber_id", 56432345);
		// requestParams.put("gender", "F");

		// Set of Conditions
		Map<String, String> map = new HashMap<>();
		map.put("subscriber_id", "N_DT-Long_M");

		// DataType
		Map<String, Class> dataType = new HashMap<>();
		dataType.put("STR", String.class);
		dataType.put("LNG", Long.class);
		dataType.put("INT", Integer.class);
		dataType.put("DTE", String.class);

		// Validation
		for (Map.Entry<String, Object> requestParam : requestParams.entrySet()) {
			String[] rules = map.get(requestParam.getKey()).split("_");
			System.out.println(Arrays.toString(rules));
			println("RequestParamValue: ", requestParam.getValue());
			checkRequestParamValue(rules, requestParam.getValue(), 0);
		}
	}

	public static void checkRequestParamValue(String[] rules, Object requestParamValue, int ruleCounter) {
		println(">>Rule No.: ", ruleCounter);

		// Check if the counter hit the last condition.
		if (ruleCounter >= rules.length) {
			println("No Rule implemented");
			println("End Checking!");

			return;
		}

		String rule = rules[ruleCounter];
		println(">>Rule: ", rule);

		//
		switch (rule) {
		case "N":
			println("Is Null: ", isNull(requestParamValue) ? "Yes" : "No");
			checkRequestParamValue(rules, requestParamValue, ++ruleCounter);
		case "NN":
			println("Is NOT Null: ", !isNull(requestParamValue) ? "Yes" : "No");
			checkRequestParamValue(rules, requestParamValue, ++ruleCounter);
		default:
			if (rule.matches("[dD][tT]-\\w*")) {
				println("DataType checking!");
				checkRequestParamValue(rules, requestParamValue, ++ruleCounter);
			} else {
				println("Default.");
				checkRequestParamValue(rules, requestParamValue, ++ruleCounter);
			}
			// case "Long"
		}
		// println("End Checking!");
		// return ;
	}
	
	public static void println(Object o1) {
		System.out.println(o1);
	}
	
	public static void println(Object o1, Object o2) {
		System.out.println(o1 + " : " + o2);
	}
	
	public static boolean isNull(Object o) {
		return o == null;
	}
	
}
