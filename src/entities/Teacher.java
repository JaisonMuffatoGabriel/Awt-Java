package entities;

public class Teacher extends UserModel implements Comparable {

	private Long registryT;

	public Teacher(String name, String cpf, int age, Long registryT) {
		super(name, cpf, age);
		this.registryT = registryT;
	}

	public Long getRegistryT() {
		return registryT;
	}

	public void setRegistryT(Long registryT) {
		this.registryT = registryT;
	}

	@Override
	public String toString() {
		return "Name = " + getName() + ", CPF = " + getCpf() + ", Age = " + getAge() + ", Registry = " + registryT
				+ ".";
	}

	@Override
	public int compareTo(Object obj) {
		Teacher teacher = (Teacher) obj;
		int resp = this.getName().compareTo(teacher.getName());
		if (resp != 0) {
			return resp;
		} else if (this.getRegistryT() < teacher.getRegistryT()) {
			return -1;
		} else if (this.getRegistryT() > teacher.getRegistryT()) {
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
