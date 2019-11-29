package ss.week3.password;

public class BasicChecker implements Checker {
	public static final String PASSWORD = "password";
	@Override
	public String generatePassword() {
		return PASSWORD;
	}
}
