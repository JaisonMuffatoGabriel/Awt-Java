package views;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import createList.ListStudent;
import entities.Student;
import views.componets.Header;
import views.componets.TitleView;

public class ViewAddStudent extends JFrame implements ActionListener, ViewStandart {

	private final ViewCreate view;

	private int widthComponent;
	private final int widthView, heightView;

	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtCpf;
	private JTextField txtRegistryA;

	private JButton btnAdd;

	private final ListStudent list;

	public ViewAddStudent() {

		widthView = 300;
		heightView = 300;

		view = new ViewCreate(TitleView.TITLE_VIEW, widthView, heightView);

		view.create();

		view.setLayout(null);

		addComponent();

		view.centralized();

		view.setResizable(false);

		list = new ListStudent();

		view.showView();
	}

	@Override
	public void addComponent() {
		widthComponent = widthView - 20;

		JPanel header = header();
		header.setSize(widthView, 30);
		header.setLocation(6, 10);

		JPanel body = body();
		body.setLocation(6, 50);

		JPanel footer = footer();
		footer.setLocation(2, 220);

		view.add(header);
		view.add(body);
		view.add(footer);

	}

	@Override
	public JPanel header() {
		return new Header("Add Student").create();
	}

	@Override
	public JPanel body() {
		JPanel body = new JPanel();

		JLabel labelName = new JLabel();
		JLabel labelCpf = new JLabel();
		JLabel labelAge = new JLabel();
		JLabel labelRegistryA = new JLabel();

		txtName = new JTextField();
		txtCpf = new JTextField();
		txtAge = new JTextField();
		txtRegistryA = new JTextField();

		body.setLayout(new GridLayout(4, 2, 4, 4));
		body.setSize(widthComponent, 150);
		body.setBackground(null);

		labelName.setText("Name:");
		labelAge.setText("Age:");
		labelCpf.setText("CPF:");
		labelRegistryA.setText("Registry:");

		body.add(labelName);
		body.add(txtName);

		body.add(labelAge);
		body.add(txtAge);

		body.add(labelCpf);
		body.add(txtCpf);

		body.add(labelRegistryA);
		body.add(txtRegistryA);

		return body;
	}

	@Override
	public JPanel footer() {
		JPanel footer = new JPanel();
		btnAdd = new JButton();

		footer.setLayout(new FlowLayout());
		footer.setSize(widthComponent, 100);
		footer.setBackground(null);

		btnAdd.setText("Add");
		btnAdd.addActionListener(this);

		footer.add(btnAdd);

		return footer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnAdd) {
			String name, cpf;
			int age;
			Long registryA;

			VerifyNumberField verifyAge = new VerifyNumberField(txtAge);
			VerifyNumberField verifyRegistryA = new VerifyNumberField(txtRegistryA);

			if (verifyField()) {
				JOptionPane.showMessageDialog(null, "Fill in all fields!");
				return;
			}

			if (!verifyAge.verify()) {
				JOptionPane.showMessageDialog(null, "Fill Age field with number!");
				return;
			}

			if (!verifyRegistryA.verify()) {
				JOptionPane.showMessageDialog(null, "Fill Registry field with number!");
				return;
			}

			name = txtName.getText();
			cpf = txtCpf.getText();
			age = Integer.parseInt(txtAge.getText());
			registryA = Long.parseLong(txtRegistryA.getText());

			list.addStudents(new Student(name, cpf, age, registryA));

			int resp = JOptionPane.showConfirmDialog(null, "Continue?", TitleView.TITLE_VIEW,
					JOptionPane.YES_NO_OPTION);

			if (resp == 0) {
				clearField();
			}

			if (resp == 1) {
				list.print();
				view.dispose();
			}
		}
	}

	private void clearField() {
		txtName.setText("");
		txtAge.setText("");
		txtCpf.setText("");
		txtRegistryA.setText("");
	}

	private boolean verifyField() {
		return txtName.getText().isEmpty() || txtCpf.getText().isEmpty() || txtAge.getText().isEmpty()
				|| txtRegistryA.getText().isEmpty();
	}

}
