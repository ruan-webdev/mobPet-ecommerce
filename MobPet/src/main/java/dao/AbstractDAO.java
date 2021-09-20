package dao;

import java.sql.Connection;
import java.sql.SQLException;

import utils.ConnectionFactory;

public abstract class AbstractDAO implements IDAO {

	protected Connection connection;
	protected String table;
	protected String idTable;

	public AbstractDAO(String table, String idtable) {
		this.table = table;
		this.idTable = idtable;
	}

	protected void openConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				connection = ConnectionFactory.getConexao();
			}
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
