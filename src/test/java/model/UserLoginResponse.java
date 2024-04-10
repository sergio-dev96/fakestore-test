package model;

public class UserLoginResponse{
	private String access;
	private String refresh;

	public void setAccess(String access){
		this.access = access;
	}

	public String getAccess(){
		return access;
	}

	public void setRefresh(String refresh){
		this.refresh = refresh;
	}

	public String getRefresh(){
		return refresh;
	}

	@Override
 	public String toString(){
		return 
			"UserLoginResponse{" +
			"access = '" + access + '\'' + 
			",refresh = '" + refresh + '\'' + 
			"}";
		}
}
