package connectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCExemplo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//Linha inclusa para que o driver MySQL (incluida pelo mysql-connector-java-5.08-bin.jar)
		//se comunique com o DriverManager
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/test","root", "");
		System.out.println("Conectado!");
		conexao.close();
	}
}
