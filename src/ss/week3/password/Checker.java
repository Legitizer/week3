package ss.week3.password;

public interface Checker {
	
	public static final String[] characters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	
	/**
	 * Checks if a string is acceptable as a password.
	 * @param pass Password to be checked.
	 * @return {@code true} if {@code pass} is acceptable, {@code false} otherwise.
	 * @ensures {@code pass} is at least 6 characters long and has no spaces.
	 */
	public default boolean acceptable(String pass) {
		boolean result = true;
		if (pass.length() < 6 || pass.contains(" ")) {
			result = false;
		}
		return result;
	}
	
	/**
	 * Generates an acceptable password.
	 * @return Acceptable possible password.
	 */
	String generatePassword();
}
