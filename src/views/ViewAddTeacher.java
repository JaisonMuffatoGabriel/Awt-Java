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

import createList.ListTeacher;
import entities.Teacher;
import views.componets.Header;
import views.componets.TitleView;

public class ViewAddTeacher extends JFrame implements ActionListener, ViewStandart {

	private final ViewCreate view;

	private int widthComponent;
	private final int widthView, heightView;

	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtCpf;
	private JTextField txtRegistry;

	private JButton btnAdd;

	private final ListTeacher list;

	public ViewAddTeacher() {

		widthView = 300;
		heightView = 300;

		view = new ViewCreate(TitleView.TITLE_VIEW, widthView, heightView);

		view.create();

		view.setLayout(null);

		addComponent();

		view.centralized();

		view.setResizable(false);

		list = new ListTeacher();

		view.showView();
	}

	@Override
	public void addComponent() {
		widthComponent = widthView - 20;

		JPanel header = header();
		header.setSize(widthComponent, 30);
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
	public final JPanel header() {
		return new Header("Add Teacher").create();
	}

	@Override
	public JPanel body() {
		JPanel body = new JPanel();

		JLabel labelName = new JLabel();
		JLabel labelAge = new JLabel();
		JLabel labelCpf = new JLabel();
		JLabel labelRegistryT = new JLabel();

		txtName = new JTextField();
		txtAge = new JTextField();
		txtCpf = new JTextField();
		txtRegistry = new JTextField();

		body.setLayout(new GridLayout(4, 2, 4, 4));
		body.setSize(widthComponent, 150);
		body.setBackground(null);

		labelName.setText("Name:");
		labelAge.setText("Age");
		labelCpf.setText("CPF:");
		labelRegistryT.setText("Registry");

		body.add(labelName);
		body.add(txtName);

		body.add(labelAge);
		body.add(txtAge);

		body.add(labelCpf);
		body.add(txtCpf);

		body.add(labelRegistryT);
		body.add(txtRegistry);

		return body;
	}

	@Override
	public final JPanel footer() {
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
			Long registryT;

			VerifyNumberField verifyAge = new VerifyNumberField(txtAge);
			VerifyNumberField verifyRegistry = new VerifyNumberField(txtRegistry);

			if (verifyField()) {
				JOptionPane.showMessageDialog(null, "Fill in all fields!");
				return;
			}

			if (!verifyAge.verify()) {
				JOptionPane.showMessageDialog(null, "Fill Age field with number!");
				return;
			}

			if (!verifyRegistry.verify()) {
				JOptionPane.showMessageDialog(null, "Fill Registry field with number!");
				return;
			}

			name = txtName.getText();
			cpf = txtCpf.getText();
			age = Integer.parseInt(txtAge.getText());
			registryT = Long.parseLong(txtRegistry.getText());

			list.addTeachers(new Teacher(name, cpf, age, registryT));

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
		txtRegistry.setText("");
	}

	private boolean verifyField() {
		return txtName.getText().isEmpty() || txtCpf.getText().isEmpty() || txtAge.getText().isEmpty()
				|| txtRegistry.getText().isEmpty();
	}

}
