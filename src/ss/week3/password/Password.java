package ss.week3.password;

public class Password {
	public static final String INITIAL = "password";
	
	private String word;
	private Checker checker;
	private String factoryPassword;
	
	
	public Password(Checker checker) {
		this.checker = checker;
		this.factoryPassword = this.checker.generatePassword();
		this.word = checker.generatePassword();
		this.factoryPassword = this.word;
	}
	
	public String getInitPass() {
		return INITIAL;
	}
	
	public Password() {
		this(new BasicChecker());
	}
	
	public boolean acceptable(String suggestion) {
		return checker.acceptable(suggestion);
	}
	
	public Checker getChecker() {
		return checker;
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
