package views.componets;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header {

	private final String txtHeader;

	public Header(String txtHeader) {
		super();
		this.txtHeader = txtHeader;
	}

	public JPanel create() {
		JPanel header = new JPanel();
		JLabel title = new JLabel();

		header.setLayout(new FlowLayout());
		header.setBackground(null);
		header.setAlignmentX(Component.CENTER_ALIGNMENT);
		header.setAlignmentY(Component.CENTER_ALIGNMENT);

		title.setText(txtHeader);
		header.add(title);
		return header;
	}

}
