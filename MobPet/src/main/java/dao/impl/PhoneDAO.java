package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AbstractDAO;
import domain.client.Client;
import domain.client.DomainEntity;
import domain.client.Phone;

public class PhoneDAO extends AbstractDAO {

	public PhoneDAO() {
		super("phones", "pho_id");
	}

	
	public int save(DomainEntity entity) {
		openConnection();
		PreparedStatement pstm = null;

		Phone phone = (Phone) entity;

		String sql = "INSERT INTO " + table + "(pho_number, pho_cli_id, pho_is_active) VALUES (?, ?, ?)";

		try {
			pstm = connection.prepareStatement(sql);

			pstm.setString(1, phone.getNumber());

			Client consultClient = (Client) new ClientDAO().consult(phone.getClient()).get(0);

			pstm.setInt(2, consultClient.getId());
			pstm.setBoolean(3, phone.isActive());

			pstm.execute();
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
		Phone phone = (Phone) entity;
		phone.setActive(false);

		update(phone);
	}

	
	public void update(DomainEntity entity) {
		openConnection();

		PreparedStatement pstm = null;

		Phone phone = (Phone) entity;

		String sql = "UPDATE " + table + " SET pho_number=?, pho_is_active=? WHERE " + idTable + "=?";

		try {
			pstm = connection.prepareStatement(sql);

			pstm.setString(1, phone.getNumber());
			pstm.setBoolean(2, phone.isActive());
			pstm.setInt(3, phone.getId());

			pstm.executeUpdate();
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

		Phone phone = (Phone) entity;

		String sql = "";

		if (phone.getId() != 0) {
			// consult by id
			sql = "SELECT * from " + table + " WHERE " + idTable + "=?";
		} else if (null == phone.getNumber() && phone.getClient().getUser().getId() != 0) {
			// consult by user id
			sql = "SELECT * from " + table
					+ " INNER JOIN clients ON phones.pho_cli_id=clients.cli_id WHERE clients.cli_usr_id=?";
		} else if (null != phone.getNumber() && phone.getClient().getUser().getId() != 0) {
			// consult by phone number and user id
			sql = "SELECT * from " + table + " WHERE pho_cli_id=? AND pho_number=? AND pho_is_active=?";
		}

		List<DomainEntity> phones = new ArrayList<DomainEntity>();

		try {
			pstm = connection.prepareStatement(sql);

			if (phone.getId() != 0) {
				// consult by id
				pstm.setInt(1, phone.getId());
			} else if (null == phone.getNumber() && phone.getClient().getUser().getId() != 0) {
				// consult by user id
				pstm.setInt(1, phone.getClient().getUser().getId());
			} else if (null != phone.getNumber() && phone.getClient().getUser().getId() != 0) {
				// consult by phone number and user id
				Client consultClient = (Client) new ClientDAO().consult(phone.getClient()).get(0);
				
				pstm.setInt(1, consultClient.getId());
				pstm.setString(2, phone.getNumber());
				pstm.setBoolean(3, true);
			}

			rs = pstm.executeQuery();

			while (rs.next()) {
				Phone currentPhone = new Phone();
				currentPhone.setId(rs.getInt(idTable));
				currentPhone.setNumber(rs.getString("pho_number"));

				Client client = new Client();
				client.setId(rs.getInt("pho_cli_id"));

				currentPhone.setClient(client);

				currentPhone.setActive(rs.getBoolean("pho_is_active"));

				phones.add(currentPhone);
			}

			return phones;
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

		return phones;
	}

}
