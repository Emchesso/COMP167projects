
public class Author {
	/* Details the creation of an Author object that with first and last name.
	 * Used in Book objects. 
	 */
	private String firstName, lastName;

	public Author() {
		firstName = "";
		lastName = "";
	}
	public Author(String authorFirstName, String authorLastName) {
		firstName = authorFirstName;
		lastName = authorLastName;
	}

	public void setFirstName(String userFirstName) {
		firstName = userFirstName;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String userLastName) {
		lastName = userLastName;
	}
	public String getLastName() {
		return lastName;
	}

	public String toString() {
		return firstName + " " + lastName;
	}
}
