package util;

import java.util.StringTokenizer;

public class Conversion {
	public static void main(String[] args) {
		String str = "SALARIED_GOVT_EMPLOYEE," + "SALARIED_NON_GOVT_EMPLOYEE," + "SELF_EMPLOYED_PROFESSIONAL,"
				+ "SELF_EMPLOYED_NON_PROFESSIONAL, HOME_MAKER";
		StringTokenizer tokenizer = new StringTokenizer(str, ",");
		StringBuffer output = new StringBuffer();
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken().trim();
			output.append(token).append("(\"").append(token).append("\"),");
		}
		String result = output.substring(0, output.length() - 1);
		System.out.println(result);
	}
}
