package createList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import entities.Student;
import views.ViewRelatory;

public class ListStudent {

	ArrayList students;

	public ListStudent() {
		students = new ArrayList();
	}

	public void addStudents(Student student) {
		students.add(student);

	}

	public void print() {
		String str = "Students List";

		Collections.sort(students);

		Iterator iter = students.iterator();
		while (iter.hasNext()) {
			str += "\n" + iter.next();
		}

		new ViewRelatory(str);
	}

}
