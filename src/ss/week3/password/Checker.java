package ss.week3.password;

public interface Checker {
	
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
