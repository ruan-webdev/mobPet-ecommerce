package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.client.Client;
import domain.client.CreditCard;
import domain.client.DomainEntity;
import dao.AbstractDAO;
import java.sql.Date;


import utils.ConnectionFactory;

public class CreditCardDAO extends AbstractDAO {

	public CreditCardDAO() {
		super("cartoes_credito", "cdc_id");
	}


	public int save(DomainEntity entity) {
		openConnection();
		PreparedStatement pstm = null;

		CreditCard cartaoCredito = (CreditCard) entity;

		String sql = "INSERT INTO " + table
				+ "(cdc_nome, cdc_num, cdc_codigo, cdc_flag, cdc_validade, cdc_apelido, cdc_cli_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cartaoCredito.getNome());
			pstm.setString(2, cartaoCredito.getNum());
			pstm.setString(3, cartaoCredito.getCodigo());
			pstm.setString(4, cartaoCredito.getBandeira());
			pstm.setDate(5, Date.valueOf(cartaoCredito.getValidade()));
			pstm.setString(6, cartaoCredito.getApelido());

			Client consultClient = (Client) new ClientDAO().consult(cartaoCredito.getCliente()).get(0);

			pstm.setInt(7, consultClient.getId());

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
		CreditCard creditCard = (CreditCard) entity;


		update(creditCard);
	}

	
	public void update(DomainEntity entity) {
		openConnection();

		PreparedStatement pstm = null;

		CreditCard cartaoCredito = (CreditCard) entity;

		String sql = "";
		


		if (null != cartaoCredito.getValidade()) {
			sql = "UPDATE " + table
				+ " SET cdc_num=?, cdc_validade?, cdc_codigo=?, cdc_nome=?, WHERE "
				+ idTable + "=?";
		} else {
	
		}

		try {
			pstm = conn.prepareStatement(sql);

			if (null != cartaoCredito.getValidade()) {
				pstm.setString(1, cartaoCredito.getNome());
				pstm.setString(2, cartaoCredito.getNum());
				pstm.setString(3, cartaoCredito.getCodigo());
				pstm.setString(4, cartaoCredito.getBandeira());
				pstm.setDate(5, Date.valueOf(cartaoCredito.getValidade()));
				pstm.setString(6, cartaoCredito.getApelido());
				pstm.setInt(7, cartaoCredito.getId());
				
			} else {
				pstm.setInt(1, cartaoCredito.getId());
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

		CreditCard cartaoCredito = (CreditCard) entity;

		String sql = "";

		if (cartaoCredito.getId() != 0) {
			// consult by id
			sql = "SELECT * from " + table + " WHERE " + idTable + "=?";
		} else if (null == cartaoCredito.getNum() && cartaoCredito.getCliente().getUsuario().getId() != 0) {
			// consult by user id
			sql = "SELECT * from " + table
					+ " INNER JOIN clientes ON cartoes_credito.cdc_cli_id=clientes.cli_id WHERE clientes.cli_usr_id=?";
		} else if (null != cartaoCredito.getNum() && cartaoCredito.getCliente().getUsuario().getId() != 0) {
			// consult by number and user id
			sql = "SELECT * from " + table + " WHERE cdc_cli_id=? AND cdc_num=? ";
		}

		List<DomainEntity> creditCards = new ArrayList<DomainEntity>();

		try {
			pstm = conn.prepareStatement(sql);

			if (cartaoCredito.getId() != 0) {
				// consult by id
				pstm.setInt(1, cartaoCredito.getId());
			} else if (null == cartaoCredito.getNum() && cartaoCredito.getCliente().getUsuario().getId() != 0) {
				// consult by user id
				pstm.setInt(1, cartaoCredito.getCliente().getUsuario().getId());
			} else if (null != cartaoCredito.getNum() && cartaoCredito.getCliente().getUsuario().getId() != 0) {
				// consult by number and user id
				Client consultClient = (Client) new ClientDAO().consult(cartaoCredito.getCliente()).get(0);

				pstm.setInt(1, consultClient.getId());
				pstm.setString(2, cartaoCredito.getNum());
				pstm.setBoolean(3, true);
			}

			rs = pstm.executeQuery();

			while (rs.next()) {
				CreditCard currentCreditCard = new CreditCard();
				currentCreditCard.setId(rs.getInt(idTable));
				currentCreditCard.setNum(rs.getString("cdc_num"));
				currentCreditCard.setValidade(rs.getDate("cdc_validade").toLocalDate());
				currentCreditCard.setCodigo(rs.getString("cdc_codigo"));
				currentCreditCard.setNome(rs.getString("cdc_nome"));
				currentCreditCard.setBandeira(rs.getString("cdc_flag"));
				currentCreditCard.setApelido(rs.getString("cdc_apelido"));
				
				Client client = new Client();
				client.setId(rs.getInt("cdc_cli_id"));

				currentCreditCard.setCliente(client);

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
			if (conn != null) {
				try {
					System.out.println("Closing connection...");
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return creditCards;
	}

}