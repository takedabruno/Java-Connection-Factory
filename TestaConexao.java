package connectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = new ConnectionFactory().getConnection("localhost", "test", "root", "");
		System.out.println("Conexão aberta!");
		connection.close();
	}
}
