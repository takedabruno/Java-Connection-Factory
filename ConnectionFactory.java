package connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection(String host, String db, String user, String password) throws ClassNotFoundException {
		try {
			// Linha inclusa para que o driver MySQL (incluida pelo mysql-connector-java-5.08-bin.jar)
			// se comunique com o DriverManager
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://" + host + "/" + db, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
