package com.cukierek;

public class Person {

	private String firstName;
	private String lastName;
	private Integer age;
	private Gender gender;

	public Person(String firstName, String lastName, Integer age, Gender gender) {
		if (firstName == null || lastName == null || age == null || gender == null)
			throw new IllegalArgumentException();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}

	public Person(String firstName, String lastName, Integer age) {
		if (firstName == null || lastName == null || age == null || gender == null)
			throw new IllegalArgumentException();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = Gender.MALE;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Person)) return false;

		Person person = (Person) o;

		if (!firstName.equals(person.firstName)) return false;
		if (!lastName.equals(person.lastName)) return false;
		if (!age.equals(person.age)) return false;
		return gender == person.gender;
	}

    /* @Override
    public boolean equals(Object object) {
        if (!(object instanceof Person) || object == null) {
            return false;
        }
        Person person = (Person) object;
        return firstName.equals(person.firstName) && lastName.equals(person.lastName) && age.equals(person.age);
    }*/

	@Override
	public int hashCode() {
		int result = firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		result = 31 * result + age.hashCode();
		result = 31 * result + (gender != null ? gender.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Person{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age=" + age +
				", gender=" + gender +
				'}';
	}

    /*    @Override
    public String toString() {
        return "|        " + firstName + "        |        " + lastName + "        |        " + age + "        |        " + gender + "      |";
    }*/

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}
}
