package connectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ContatoDao {
	// a conex�o com o banco de dados
	private Connection connection;

	public ContatoDao() throws ClassNotFoundException {
		connection = new ConnectionFactory().getConnection("localhost", "test", "root", "");
	}
	
	 public void adiciona(Contato contato) {
	     String sql = "insert into contatos " +
	             "(nome,email,endereco,dataNascimento)" +
	             " values (?,?,?,?)";
	 
	     try {
	         // prepared statement para inser��o
	         PreparedStatement stmt = connection.prepareStatement(sql);
	 
	         // seta os valores
	         stmt.setString(1,contato.getNome());
	         stmt.setString(2,contato.getEmail());
	         stmt.setString(3,contato.getEndereco());
	         stmt.setDate(4, new Date(
	                 contato.getDataNascimento().getTimeInMillis()));
	 
	         // executa
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	 
	 public void altera(Contato contato) {
	     String sql = "update contatos set nome=?, email=?, endereco=?," +
	             "dataNascimento=? where id=?";
	     try {
	         PreparedStatement stmt = connection.prepareStatement(sql);
	         stmt.setString(1, contato.getNome());
	         stmt.setString(2, contato.getEmail());
	         stmt.setString(3, contato.getEndereco());
	         stmt.setDate(4, new Date(contato.getDataNascimento()
	                 .getTimeInMillis()));
	         stmt.setLong(5, contato.getId());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	 
	 public void remove(Contato contato) {
	     try {
	         PreparedStatement stmt = connection
	                 .prepareStatement("delete from contatos where id=?");
	         stmt.setLong(1, contato.getId());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

}
