package dao.impl;

import utils.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.AbstractDAO;
import domain.client.Client;
import domain.client.DomainEntity;
import domain.client.User; 

 
public class ClientDAO extends AbstractDAO{
	
    public ClientDAO() {
		super("clientes", "cli_id");

	}


    public int save(DomainEntity entity) {
    	openConnection();
    	
    	PreparedStatement pstm = null;
    	
        Client cliente = (Client) entity;
        
        String sql = "INSERT INTO clientes (cli_nome, cli_cpf, cli_dt_nasc, cli_genero, cli_tel, cli_usr)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        
        User user = cliente.getUsuario();
        
        int idUser = new UserDAO().save(user);
		
		if (idUser == 0) {
			return 0;
		}
        
        try {
        	pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf());
            pstm.setDate(3, Date.valueOf(cliente.getDataNascimento()));
            pstm.setString(4, cliente.getGenero());
            pstm.setString(5, cliente.getTelefone());
            pstm.setInt(6, idUser);
            pstm.execute();
 
            
            ResultSet rs = pstm.getGeneratedKeys();

            int idClient = 0;

            if (rs.next()) {
				idClient = rs.getInt(1);
			}

			return idClient;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (pstm != null) {
					try {
						pstm.close();
					} catch (SQLException e) {
					}
				}
				if (conn != null) {
					try {
						System.out.println("Closing connection...");
						conn.close();
					} catch (SQLException e) {
					}
				}
			}
		return 0;
	}




	public void remove(DomainEntity entity) {
		// TODO Auto-generated method stub
		
	}


	public void update(DomainEntity entity) {
		openConnection();

		PreparedStatement pstm = null;

		Client client = (Client) entity;

		String sql = "UPDATE " + table + " SET cli_name=?, cli_date_of_birth=?, cli_gender=? WHERE "
				+ idTable + "=?";

		try {
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, client.getNome());
			pstm.setDate(2, Date.valueOf(client.getDataNascimento()));
			pstm.setString(3, client.getGenero().toString().toLowerCase());
			pstm.setInt(4, client.getId());

			pstm.executeUpdate();

			new UserDAO().update(client.getUsuario());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					System.out.println("Closing connection...");
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	
    public List<DomainEntity> consult(DomainEntity entity) {
		openConnection();

		PreparedStatement pstm = null;
		ResultSet rs = null;

		Client client = (Client) entity;

		String sql = "";

		if (null != client.getCpf()) {
			// consult by cpf
			sql = "SELECT * from " + table + " WHERE cli_cpf=?";
		} else if (client.getUsuario().getId() != 0) {
			// consult by user id
			sql = "SELECT * from " + table + " WHERE cli_id=?";
		}

		List<DomainEntity> clients = new ArrayList<DomainEntity>();

		try {
			pstm = conn.prepareStatement(sql);

			if (null != client.getCpf()) {
				// consult by cpf
				pstm.setString(1, client.getCpf());
			} else if (client.getUsuario().getId() != 0) {
				// consult by user id
				pstm.setInt(1, client.getUsuario().getId());
			}

			rs = pstm.executeQuery();

			UserDAO userDAO = new UserDAO();

			while (rs.next()) {
				Client currentClient = new Client();
				currentClient.setId(rs.getInt(idTable));
				currentClient.setNome(rs.getString("cli_name"));
				currentClient.setCpf(rs.getString("cli_cpf"));
				currentClient.setDataNascimento((rs.getDate("cli_dt_nasc").toLocalDate()));
				currentClient.setGenero(rs.getString("cli_genero"));

				User user = new User();
				user.setId(rs.getInt("cli_id"));

				user = (User) userDAO.consult(user).get(0);
				
				currentClient.setUsuario(user);

				clients.add(currentClient);
			}

			return clients;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					System.out.println("Closing connection...");
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return clients;
	}

}