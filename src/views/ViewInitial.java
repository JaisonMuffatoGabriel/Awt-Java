package views;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import views.componets.Header;
import views.componets.TitleView;

public class ViewInitial extends JFrame implements ActionListener, ViewStandart {

	private static final long serialVersionUID = 1L;

	private final ViewCreate initialView;

	private final int widthView, heightView;
	private int widthComponent;

	private JButton btnTeacher;
	private JButton btnStudent;
	private JButton btnExit;

	public ViewInitial() {

		widthView = 300;
		heightView = 200;

		initialView = new ViewCreate(TitleView.TITLE_VIEW, widthView, heightView);

		initialView.create();

		initialView.setLayout(null);

		addComponent();

		initialView.centralized();

		initialView.setResizable(false);

		initialView.showView();
	}

	@Override
	public final void addComponent() {
		widthComponent = widthView - 20;

		JPanel header = header();
		header.setSize(widthComponent, 30);
		header.setLocation(6, 10);

		JPanel body = body();
		body.setLocation(10, 50);

		JPanel footer = footer();
		footer.setLocation(6, 120);

		initialView.add(header);
		initialView.add(body);
		initialView.add(footer);
	}

	@Override
	public final JPanel header() {
		return new Header("AWT System").create();
	}

	@Override
	public final JPanel body() {
		JPanel body = new JPanel();
		btnTeacher = new JButton();
		btnStudent = new JButton();

		body.setLayout(new GridLayout(2, 1));
		body.setSize(widthComponent, 60);
		body.setBackground(null);

		btnTeacher.setText("Teacher");
		btnTeacher.addActionListener(this);

		btnStudent.setText("Student");
		btnStudent.addActionListener(this);

		body.add(btnTeacher);
		body.add(btnStudent);

		return body;
	}

	@Override
	public final JPanel footer() {
		JPanel footer = new JPanel();
		btnExit = new JButton();

		footer.setLayout(new FlowLayout());
		footer.setSize(widthComponent, 100);
		footer.setBackground(null);

		btnExit.setText("Exit");
		btnExit.addActionListener(this);

		footer.add(btnExit);
		return footer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnTeacher) {
			new ViewAddTeacher();
			initialView.dispose();
		}

		if (e.getSource() == btnStudent) {
			new ViewAddStudent();
			initialView.dispose();
		}

		if (e.getSource() == btnExit)
			System.exit(0);

	}

}
