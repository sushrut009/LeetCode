package com.stack.delimiter;

public class DelimitersParsingUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DelimiterMatching D1 = new DelimiterMatching() ;
		D1.delimit_match("ab[d{e(f)g}])hi");
	}

}
