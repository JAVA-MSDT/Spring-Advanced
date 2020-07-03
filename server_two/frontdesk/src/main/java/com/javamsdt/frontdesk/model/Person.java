package com.javamsdt.frontdesk.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

	private long personId;
	private String personFirstName;
	private String personLastName;
	private String personLogin;
	private String personEmail;
	private String personLogo;

	public Person() {
	}

	public Person(final String personFirstName, final String personLastName, final String personLogin,
			final String personEmail, final String personLogo) {
		this.personFirstName = personFirstName;
		this.personLastName = personLastName;
		this.personLogin = personLogin;
		this.personEmail = personEmail;
		this.personLogo = personLogo;
	}

	public Person(final long personId, final String personFirstName, final String personLastName,
			final String personLogin, final String personEmail, final String personLogo) {
		this.personId = personId;
		this.personFirstName = personFirstName;
		this.personLastName = personLastName;
		this.personLogin = personLogin;
		this.personEmail = personEmail;
		this.personLogo = personLogo;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(final long personId) {
		this.personId = personId;
	}

	public String getPersonFirstName() {
		return personFirstName;
	}

	public void setPersonFirstName(final String personFirstName) {
		this.personFirstName = personFirstName;
	}

	public String getPersonLastName() {
		return personLastName;
	}

	public void setPersonLastName(final String personLastName) {
		this.personLastName = personLastName;
	}

	public String getPersonLogin() {
		return personLogin;
	}

	public void setPersonLogin(final String personLogin) {
		this.personLogin = personLogin;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(final String personEmail) {
		this.personEmail = personEmail;
	}

	public String getPersonLogo() {
		return personLogo;
	}

	public void setPersonLogo(final String personLogo) {
		this.personLogo = personLogo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [personId=");
		builder.append(personId);
		builder.append(", personFirstName=");
		builder.append(personFirstName);
		builder.append(", personLastName=");
		builder.append(personLastName);
		builder.append(", personLogin=");
		builder.append(personLogin);
		builder.append(", personEmail=");
		builder.append(personEmail);
		builder.append(", personLogo=");
		builder.append(personLogo);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((personEmail == null) ? 0 : personEmail.hashCode());
		result = (prime * result) + ((personFirstName == null) ? 0 : personFirstName.hashCode());
		result = (prime * result) + (int) (personId ^ (personId >>> 32));
		result = (prime * result) + ((personLastName == null) ? 0 : personLastName.hashCode());
		result = (prime * result) + ((personLogin == null) ? 0 : personLogin.hashCode());
		result = (prime * result) + ((personLogo == null) ? 0 : personLogo.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Person other = (Person) obj;
		if (personEmail == null) {
			if (other.personEmail != null) {
				return false;
			}
		} else if (!personEmail.equals(other.personEmail)) {
			return false;
		}
		if (personFirstName == null) {
			if (other.personFirstName != null) {
				return false;
			}
		} else if (!personFirstName.equals(other.personFirstName)) {
			return false;
		}
		if (personId != other.personId) {
			return false;
		}
		if (personLastName == null) {
			if (other.personLastName != null) {
				return false;
			}
		} else if (!personLastName.equals(other.personLastName)) {
			return false;
		}
		if (personLogin == null) {
			if (other.personLogin != null) {
				return false;
			}
		} else if (!personLogin.equals(other.personLogin)) {
			return false;
		}
		if (personLogo == null) {
			if (other.personLogo != null) {
				return false;
			}
		} else if (!personLogo.equals(other.personLogo)) {
			return false;
		}
		return true;
	}

}
