package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connexion {
	private String URL;
	private String username;
	private String password;
	private String driverClassseName;

	
	
	public connexion(String uRL, String username, String password, String driverClassseName) {
		super();
		URL = uRL;
		this.username = username;
		this.password = password;
		this.driverClassseName = driverClassseName;
	}
	public Connection connectToDB() {
		try {
			Connection connexion = DriverManager.getConnection(URL,username,password);
			return connexion;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriverClassseName() {
		return driverClassseName;
	}
	public void setDriverClassseName(String driverClassseName) {
		this.driverClassseName = driverClassseName;
	}
	
	


}
