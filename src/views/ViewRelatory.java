package views;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import views.componets.Header;
import views.componets.TitleView;

public class ViewRelatory extends JFrame implements ActionListener, ViewStandart {

	private final ViewCreate view;

	private int widthComponent;
	private final int widthView, heightView;

	private final String text;

	private JButton btnFinish;

	public ViewRelatory(String text) {

		this.text = text;

		widthView = 600;
		heightView = 470;

		view = new ViewCreate(TitleView.TITLE_VIEW, widthView, heightView);

		view.create();

		view.setLayout(null);

		addComponent();

		view.centralized();

		view.setResizable(false);

		view.showView();

	}

	@Override
	public void addComponent() {
		widthComponent = widthView - 20;

		JPanel header = header();
		header.setSize(widthComponent, 20);
		header.setLocation(6, 10);

		JPanel body = body();
		body.setLocation(6, 50);

		JPanel footer = footer();
		footer.setLocation(2, 390);

		view.add(header);
		view.add(body);
		view.add(footer);

	}

	@Override
	public JPanel header() {
		return new Header("Relatory of registry").create();
	}

	@Override
	public JPanel body() {
		JPanel body = new JPanel();
		JTextArea textArea = new JTextArea(18, 40);
		JScrollPane scrollPane = new JScrollPane(textArea);

		body.setLayout(new FlowLayout());
		body.setSize(widthComponent, 330);
		body.setBackground(null);

		textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		textArea.setText(text);
		textArea.setEditable(false);

		body.add(scrollPane);

		return body;
	}

	@Override
	public JPanel footer() {
		JPanel footer = new JPanel();
		btnFinish = new JButton();

		footer.setLayout(new FlowLayout());
		footer.setSize(widthComponent, 100);
		footer.setBackground(null);

		btnFinish.setText("End");
		btnFinish.addActionListener(this);

		footer.add(btnFinish);

		return footer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFinish) {
			new ViewInitial();
			view.dispose();
		}
	}
}
