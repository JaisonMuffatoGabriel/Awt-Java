package createList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import entities.Teacher;
import views.ViewRelatory;

public class ListTeacher {

	ArrayList teachers;

	public ListTeacher() {
		teachers = new ArrayList();
	}

	public void addTeachers(Teacher teacher) {
		teachers.add(teacher);
	}

	public void print() {
		Collections.sort(teachers);

		String str = "Teachers List";

		Iterator iter = teachers.iterator();
		while (iter.hasNext()) {
			str += "\n" + iter.next();
		}

		new ViewRelatory(str);
	}

}
