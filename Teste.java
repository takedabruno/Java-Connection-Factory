package connectionFactory;

import java.util.Calendar;

public class Teste {
	public static void main(String[] args) throws ClassNotFoundException {
		 // pronto para gravar
		 Contato contato = new Contato();
		 contato.setNome("Caelum");
		 contato.setEmail("contato@caelum.com.br");
		 contato.setEndereco("R. Vergueiro 3185 cj57");
		 contato.setDataNascimento(Calendar.getInstance());
		 
		 // grave nessa conexão!!!
		 ContatoDao dao = new ContatoDao();
		 
		 // método elegante
		 dao.adiciona(contato);
		 
		 System.out.println("Gravado!");
	}
}
