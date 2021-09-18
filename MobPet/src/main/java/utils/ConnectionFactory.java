package utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {
  
	
        private static String driver;
        private static String url;
        private static String user;
        private static String password;

        public static Connection getConexao() throws SQLException, ClassNotFoundException{


            driver = "com.mysql.cj.jdbc.Driver";
            url = "jdbc:mysql://localhost:3306/db_mobpet";
            user = "root";
            password = "root12345";


            Class.forName(driver);

    		Connection conn = null;
    		
    		try {
    			conn = DriverManager.getConnection(url, user, password);
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    		
    		return conn;
        }
      

        public void fecharConexao(Connection conn) {
            if(conn != null) {
                try {
                    conn.close();
                }catch (Exception e) {
                   System.err.println(e.getMessage());
                }
            }
        }

}