package dao.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.client.Address;
import domain.client.Client;
import domain.client.AddressType;
import domain.client.DomainEntity;
import dao.AbstractDAO;

public class AddressDAO extends AbstractDAO{


	public AddressDAO() {
		super("address", "ads_id");
	}


	public int save(DomainEntity entity) {
		openConnection();
		PreparedStatement pstm = null;

		Address address = (Address) entity;

		String sql = "INSERT INTO " + table + "(ads_cep, ads_public_place, ads_number, "
				+ "ads_complement, ads_neighbourhood, ads_city, ads_state, ads_type, "
				+ "ads_cli_id, ads_is_active) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			pstm = connection.prepareStatement(sql);

			pstm.setString(1, address.getCep());
			pstm.setString(2, address.getPublicPlace());
			pstm.setString(3, address.getNumber());
			pstm.setString(4, address.getComplement());
			pstm.setString(5, address.getNeighbourhood());
			pstm.setString(6, address.getCity());
			pstm.setString(7, address.getState());
			pstm.setString(8, address.getType().toString().toLowerCase());

			Client consultClient = (Client) new ClientDAO().consult(address.getClient()).get(0);

			pstm.setInt(9, consultClient.getId());
			pstm.setBoolean(10, address.isActive());

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
		Address address = (Address) entity;
		address.setActive(false);

		update(address);
	}


	public void update(DomainEntity entity) {
		openConnection();

		PreparedStatement pstm = null;

		Address address = (Address) entity;

		String sql = "";
		
		if (null != address.getCep()) {
			sql = "UPDATE " + table
				+ " SET ads_cep=?, ads_public_place=?, ads_number=?, ads_complement=?, ads_neighbourhood=?, ads_city=?, ads_state=?, ads_type=?, ads_is_active=? WHERE "
				+ idTable + "=?";
		} else {
			sql = "UPDATE " + table
					+ " SET ads_is_active=? WHERE "
					+ idTable + "=?";
		}

		try {
			pstm = connection.prepareStatement(sql);

			if (null != address.getCep()) {
				pstm.setString(1, address.getCep());
				pstm.setString(2, address.getPublicPlace());
				pstm.setString(3, address.getNumber());
				pstm.setString(4, address.getComplement());
				pstm.setString(5, address.getNeighbourhood());
				pstm.setString(6, address.getCity());
				pstm.setString(7, address.getState());
				pstm.setString(8, address.getType().toString().toLowerCase());
				pstm.setBoolean(9, address.isActive());
				pstm.setInt(10, address.getId());
			} else {
				pstm.setBoolean(1, address.isActive());
				pstm.setInt(2, address.getId());
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

		Address address = (Address) entity;

		String sql = "";

		if (address.getId() != 0) {
			// consult by id
			sql = "SELECT * from " + table + " WHERE " + idTable + "=?";
		} else if (address.getClient().getUser().getId() != 0) {
			// consult by user id
			sql = "SELECT * from " + table
					+ " INNER JOIN clients ON address.ads_cli_id=clients.cli_id WHERE clients.cli_usr_id=?";
		}

		List<DomainEntity> adresses = new ArrayList<DomainEntity>();

		try {
			pstm = connection.prepareStatement(sql);

			if (address.getId() != 0) {
				// consult by id
				pstm.setInt(1, address.getId());
			} else if (address.getClient().getUser().getId() != 0) {
				// consult by user id
				pstm.setInt(1, address.getClient().getUser().getId());
			}

			rs = pstm.executeQuery();

			while (rs.next()) {
				Address currentAddress = new Address();
				currentAddress.setId(rs.getInt(idTable));
				currentAddress.setCep(rs.getString("ads_cep"));
				currentAddress.setPublicPlace(rs.getString("ads_public_place"));
				currentAddress.setNumber(rs.getString("ads_number"));
				currentAddress.setComplement(rs.getString("ads_complement"));
				currentAddress.setNeighbourhood(rs.getString("ads_neighbourhood"));
				currentAddress.setCity(rs.getString("ads_city"));
				currentAddress.setState(rs.getString("ads_state"));

				if (rs.getString("ads_type").equals("shipping")) {
					currentAddress.setType(AddressType.SHIPPING);
				} else if (rs.getString("ads_type").equals("billing")) {
					currentAddress.setType(AddressType.BILLING);
				} else if (rs.getString("ads_type").equals("shipping_and_billing")) {
					currentAddress.setType(AddressType.SHIPPING_AND_BILLING);
				}

				Client client = new Client();
				client.setId(rs.getInt("ads_cli_id"));
				
				currentAddress.setClient(client);
				
				currentAddress.setActive(rs.getBoolean("ads_is_active"));
				
				adresses.add(currentAddress);
			}

			return adresses;
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

		return adresses;
	}

}