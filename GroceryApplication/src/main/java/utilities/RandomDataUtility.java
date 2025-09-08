package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker faker = new Faker();

	public String createRandomUserName() {
		return faker.name().username();
	}

	public String createRandomPassword() {
		return faker.internet().password();
	}

	public String createRandomEmail() {
		return faker.internet().emailAddress();

	}

	public String createRandomFullName() {
		return faker.name().fullName();

	}

	public String createRandomPhoneNumber() {
		return faker.phoneNumber().cellPhone();

	}

	public String createRandomNews() {
		// return faker.lorem().sentence();
		return faker.company().catchPhrase();
	}

}
