package ss.week3.password;

public class StrongChecker extends BasicChecker {
	@Override
	public boolean acceptable(String pass) {
		boolean result = true;
		if (!super.acceptable(pass) || (!Character.isLetter(pass.charAt(0)) && !Character.isDigit(pass.charAt(pass.length()-1)))) {
			result = false;
		}
		return result;
	}
}
