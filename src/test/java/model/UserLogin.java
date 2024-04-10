package model;

public class UserLogin{
	private String password;
	private String username;

	public UserLogin(String password, String username) {
		this.password = password;
		this.username = username;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"UserLogin{" +
			"password = '" + password + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}
