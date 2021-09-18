package utils;

import java.sql.Connection;
import java.sql.SQLException;


public class TesteConnection {

	public static void main(String[] args) {
		
		ConnectionFactory teste = new ConnectionFactory();
		try {
			teste.getConexao();
			System.out.println("funcionou");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
