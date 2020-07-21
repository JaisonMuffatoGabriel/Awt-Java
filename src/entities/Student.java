package entities;

public class Student extends UserModel implements Comparable {

	private Long registryA;

	public Student(String name, String cpf, int age, Long registryA) {
		super(name, cpf, age);
		this.registryA = registryA;
	}

	public Long getRegistryA() {
		return registryA;
	}

	public void setRegistryA(Long registryA) {
		this.registryA = registryA;
	}

	@Override
	public String toString() {
		return "Name = " + getName() + ", CPF = " + getCpf() + ", Age = " + getAge() + ", Registry = " + registryA
				+ ".";
	}

	@Override
	public int compareTo(Object obj) {
		Student student = (Student) obj;
		int resp = this.getName().compareTo(student.getName());
		if (resp != 0) {
			return resp;
		} else if (this.getRegistryA() < student.getRegistryA()) {
			return -1;
		} else if (this.getRegistryA() > student.getRegistryA()) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
