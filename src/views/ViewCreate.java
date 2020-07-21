package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ViewCreate extends JFrame {

	String titleView;
	int width, height;

	public ViewCreate(String titleView, int width, int height) throws HeadlessException {
		super();
		this.titleView = titleView;
		this.width = width;
		this.height = height;
	}

	public void create() {
		setTitle(titleView);
		setSize(width, height);

		getContentPane().setBackground(Color.white);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void centralized() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension view = getSize();

		if (view.height > screen.height)
			setSize(view.width, screen.height);

		if (view.width > screen.width)
			setSize(screen.width, view.width);

		setLocation((screen.width - view.width) / 2, (screen.height - view.height) / 2);
	}

	public void showView() {
		setVisible(true);
	}

}
