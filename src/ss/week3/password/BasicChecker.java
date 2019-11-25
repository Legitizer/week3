package ss.week3.password;

public class BasicChecker implements Checker {
	
	@Override
	public String generatePassword() {
		String pass = "";
		
		int rand = (int)Math.round(Math.random()*4)+6;
		
		for (int i = 0; i < rand; i++) {
			int randomIndex = (int)Math.round(Math.random()*Checker.characters.length-1);
			pass = pass + Checker.characters[randomIndex];
		}
		
		return pass;
	}
}
