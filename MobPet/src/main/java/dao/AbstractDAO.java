package dao;

import java.sql.Connection;
import java.sql.SQLException;

import utils.ConnectionFactory;

public abstract class AbstractDAO implements IDAO {

	protected Connection conn;
	protected String table;
	protected String idTable;

	public AbstractDAO(String table, String idtable) {
		this.table = table;
		this.idTable = idtable;
	}

	protected void openConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConexao();
			}
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
