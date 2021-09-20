package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import domain.client.Client;
import domain.client.CreditCard;
import domain.client.DomainEntity;
import dao.AbstractDAO;
import java.sql.Date;


public class CreditCardDAO extends AbstractDAO {


	public CreditCardDAO() {
		super("credit_cards", "crc_id");
	}


	public int save(DomainEntity entity) {
		openConnection();
		PreparedStatement pstm = null;

		CreditCard creditCard = (CreditCard) entity;

		String sql = "INSERT INTO " + table
				+ "(crc_number, crc_expiration_date, crc_security_code, crc_printed_name, crc_cli_id, crc_is_active) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			pstm = connection.prepareStatement(sql);

			pstm.setString(1, creditCard.getNumber());
			pstm.setDate(2, Date.valueOf(creditCard.getExpirationDate()));
			pstm.setString(3, creditCard.getSecurityCode());
			pstm.setString(4, creditCard.getPrintedName());

			Client consultClient = (Client) new ClientDAO().consult(creditCard.getClient()).get(0);

			pstm.setInt(5, consultClient.getId());
			pstm.setBoolean(6, creditCard.isActive());

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
		CreditCard creditCard = (CreditCard) entity;
		creditCard.setActive(false);

		update(creditCard);
	}


	public void update(DomainEntity entity) {
		openConnection();

		PreparedStatement pstm = null;

		CreditCard creditCard = (CreditCard) entity;

		String sql = "";

		if (null != creditCard.getExpirationDate()) {
			sql = "UPDATE " + table
				+ " SET crc_number=?, crc_expiration_date=?, crc_security_code=?, crc_printed_name=?, crc_is_active=? WHERE "
				+ idTable + "=?";
		} else {
			sql = "UPDATE " + table
					+ " SET crc_is_active=? WHERE "
					+ idTable + "=?";
		}

		try {
			pstm = connection.prepareStatement(sql);

			if (null != creditCard.getExpirationDate()) {
				pstm.setString(1, creditCard.getNumber());
				pstm.setDate(2, Date.valueOf(creditCard.getExpirationDate()));
				pstm.setString(3, creditCard.getSecurityCode());
				pstm.setString(4, creditCard.getPrintedName());
				pstm.setBoolean(5, creditCard.isActive());
				pstm.setInt(6, creditCard.getId());
			} else {
				pstm.setBoolean(1, creditCard.isActive());
				pstm.setInt(2, creditCard.getId());
			}

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

		CreditCard creditCard = (CreditCard) entity;

		String sql = "";

		if (creditCard.getId() != 0) {
			// consult by id
			sql = "SELECT * from " + table + " WHERE " + idTable + "=?";
		} else if (null == creditCard.getNumber() && creditCard.getClient().getUser().getId() != 0) {
			// consult by user id
			sql = "SELECT * from " + table
					+ " INNER JOIN clients ON credit_cards.crc_cli_id=clients.cli_id WHERE clients.cli_usr_id=?";
		} else if (null != creditCard.getNumber() && creditCard.getClient().getUser().getId() != 0) {
			// consult by number and user id
			sql = "SELECT * from " + table + " WHERE crc_cli_id=? AND crc_number=? AND pho_is_active=?";
		}

		List<DomainEntity> creditCards = new ArrayList<DomainEntity>();

		try {
			pstm = connection.prepareStatement(sql);

			if (creditCard.getId() != 0) {
				// consult by id
				pstm.setInt(1, creditCard.getId());
			} else if (null == creditCard.getNumber() && creditCard.getClient().getUser().getId() != 0) {
				// consult by user id
				pstm.setInt(1, creditCard.getClient().getUser().getId());
			} else if (null != creditCard.getNumber() && creditCard.getClient().getUser().getId() != 0) {
				// consult by number and user id
				Client consultClient = (Client) new ClientDAO().consult(creditCard.getClient()).get(0);

				pstm.setInt(1, consultClient.getId());
				pstm.setString(2, creditCard.getNumber());
				pstm.setBoolean(3, true);
			}

			rs = pstm.executeQuery();

			while (rs.next()) {
				CreditCard currentCreditCard = new CreditCard();
				currentCreditCard.setId(rs.getInt(idTable));
				currentCreditCard.setNumber(rs.getString("crc_number"));
				currentCreditCard.setExpirationDate(rs.getDate("crc_expiration_date").toLocalDate());
				currentCreditCard.setSecurityCode(rs.getString("crc_security_code"));
				currentCreditCard.setPrintedName(rs.getString("crc_printed_name"));

				Client client = new Client();
				client.setId(rs.getInt("crc_cli_id"));

				currentCreditCard.setClient(client);

				currentCreditCard.setActive(rs.getBoolean("crc_is_active"));

				creditCards.add(currentCreditCard);
			}

			return creditCards;
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

		return creditCards;
	}


}