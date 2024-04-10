package model;

import java.util.List;

public class UserInvalidResponse{
	private List<String> password;
	private List<String> email;
	private List<String> username;

	public List<String> getFirstName() {
		return firstName;
	}

	public void setFirstName(List<String> firstName) {
		this.firstName = firstName;
	}

	public List<String> getLastName() {
		return lastName;
	}

	public void setLastName(List<String> lastName) {
		this.lastName = lastName;
	}

	private List<String> firstName;
	private List<String> lastName;

	public void setPassword(List<String> password){
		this.password = password;
	}

	public List<String> getPassword(){
		return password;
	}

	public void setEmail(List<String> email){
		this.email = email;
	}

	public List<String> getEmail(){
		return email;
	}

	public void setUsername(List<String> username){
		this.username = username;
	}

	public List<String> getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"UserInvalidResponse{" + 
			"password = '" + password + '\'' + 
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}