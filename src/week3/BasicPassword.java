/*
 * 3.1:
 * 		INITIAL: Because there must be a password by default, otherwise, it's not secure.
 * 		public because it needs to be accessed from outside classes, it's static anyway, should be accessible.
 */

package week3;

public class BasicPassword {
	public static final String INITIAL = "";
	
	private String word;
	
	public BasicPassword() {
		word = BasicPassword.INITIAL;
	}
	
	public boolean acceptable(String suggestion) {
		boolean result = true;
		if (suggestion.length() < 6 || suggestion.contains(" ")) {
			result = false;
		}
		return result;
	}
	
	public boolean testWord(String test) {
		return test.equals(word);
	}
	
	public boolean setWord(String oldpass, String newpass) {
		boolean result = false;
		if (oldpass != null && newpass != null) {
			if (testWord(oldpass)) {
				if (acceptable(newpass)) {
					word = newpass;
					result = true;
				}
			}
		}
		return result;
	}
}
