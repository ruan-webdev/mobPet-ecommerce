package dao.impl;

import utils.ConnectionFactory;
import java.sql.Date;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.AbstractDAO;
import domain.client.Client;
import domain.client.DomainEntity;
import domain.client.Gender;
import domain.client.User; 

 
public class ClientDAO extends AbstractDAO{
	public ClientDAO() {
		super("clients", "cli_id");
	}

	
	public int save(DomainEntity entity) {
		openConnection();
		PreparedStatement pstm = null;

		Client client = (Client) entity;

		String sql = "INSERT INTO " + table
				+ "(cli_name, cli_cpf, cli_date_of_birth, cli_gender, cli_usr_id) VALUES (?, ?, ?, ?, ?)";
		
		User user = client.getUser();
		
		int idUser = new UserDAO().save(user);
		
		if (idUser == 0) {
			return 0;
		}
		
		try {
			pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pstm.setString(1, client.getName());
			pstm.setString(2, client.getCpf());
			pstm.setDate(3, Date.valueOf(client.getDateOfBirth()));
			pstm.setString(4, client.getGender().toString().toLowerCase());
			pstm.setInt(5, idUser);

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
			if (connection != null) {
				try {
					System.out.println("Closing connection...");
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
		return 0;
	}

	
	public void remove(DomainEntity entity) {

	}

	
	public void update(DomainEntity entity) {
		openConnection();

		PreparedStatement pstm = null;

		Client client = (Client) entity;

		String sql = "UPDATE " + table + " SET cli_name=?, cli_date_of_birth=?, cli_gender=? WHERE "
				+ idTable + "=?";

		try {
			pstm = connection.prepareStatement(sql);

			pstm.setString(1, client.getName());
			pstm.setDate(2, Date.valueOf(client.getDateOfBirth()));
			pstm.setString(3, client.getGender().toString().toLowerCase());
			pstm.setInt(4, client.getId());

			pstm.executeUpdate();

			new UserDAO().update(client.getUser());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
				}
			}
			if (connection != null) {
				try {
					System.out.println("Closing connection...");
					connection.close();
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
		} else if (client.getUser().getId() != 0) {
			// consult by user id
			sql = "SELECT * from " + table + " WHERE cli_usr_id=?";
		}

		List<DomainEntity> clients = new ArrayList<DomainEntity>();

		try {
			pstm = connection.prepareStatement(sql);

			if (null != client.getCpf()) {
				// consult by cpf
				pstm.setString(1, client.getCpf());
			} else if (client.getUser().getId() != 0) {
				// consult by user id
				pstm.setInt(1, client.getUser().getId());
			}

			rs = pstm.executeQuery();

			UserDAO userDAO = new UserDAO();

			while (rs.next()) {
				Client currentClient = new Client();
				currentClient.setId(rs.getInt(idTable));
				currentClient.setName(rs.getString("cli_name"));
				currentClient.setCpf(rs.getString("cli_cpf"));
				currentClient.setDateOfBirth((rs.getDate("cli_date_of_birth").toLocalDate()));
				currentClient.setGender(rs.getString("cli_gender").equals("male") ? Gender.MALE : Gender.FEMALE);

				User user = new User();
				user.setId(rs.getInt("cli_usr_id"));

				user = (User) userDAO.consult(user).get(0);
				
				currentClient.setUser(user);

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
			if (connection != null) {
				try {
					System.out.println("Closing connection...");
					connection.close();
				} catch (SQLException e) {
				}
			}
		}

		return clients;
	}
}