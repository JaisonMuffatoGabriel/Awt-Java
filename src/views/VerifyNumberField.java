package views;

import javax.swing.JTextField;

public class VerifyNumberField {

	private final JTextField field;

	public VerifyNumberField(JTextField field) {
		super();
		this.field = field;
	}

	public boolean verify() {
		String str = field.getText();
		char[] chars = str.toCharArray();
		boolean ok = true;

		for (int i = 0; i < chars.length; i++) {
			try {
				Integer.parseInt(String.valueOf(chars[i]));

			} catch (NumberFormatException e) {
				ok = false;
				break;
			}
		}

		return ok;
	}

}
