package dao.impl;

import utils.ConnectionFactory;
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
		super("enderecos","edr_id");
		
	}


    public int save(DomainEntity entity) {

    	openConnection();
    	PreparedStatement pstm = null;
    	
        Address endereco = (Address) entity;
        
        String sql = "INSERT INTO " + table + "(edr_estado, edr_cep, edr_cidade, edr_bairro, edr_logradouro, edr_num, edr_complemento, edr_tipo, edr_nome_perso, edr_cli_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            
        	pstm = conn.prepareStatement(sql);

            pstm.setString(1, endereco.getEstado());
            pstm.setString(2, endereco.getCep());
            pstm.setString(3, endereco.getCidade());
            pstm.setString(4, endereco.getBairro());
            pstm.setString(5, endereco.getLogradouro());
            pstm.setString(6, endereco.getNumero());
            pstm.setString(7, endereco.getComplemento());
            pstm.setString(8, endereco.getTipoEndereco().toString().toUpperCase());
            pstm.setString(9, endereco.getApelido());


            List<DomainEntity> clients = new ClientDAO().consult(endereco.getCliente());

            Client consultClient = null;

            if (clients != null && clients.size() > 0) {
              consultClient = (Client) clients.get(0);
              pstm.setInt(10, consultClient.getId());
              pstm.execute();
            }
           
            
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
		Address endereco = (Address) entity;

		update(endereco);
	}
    

    public void update(DomainEntity entity) {
		openConnection();

		PreparedStatement pstm = null;

		Address endereco = (Address) entity;

		String sql = "";
		
		if (null != endereco.getCep()) {
			sql = "UPDATE " + table
				+ " SET edr_estado=?, edr_cep=?, edr_cidade=?, edr_bairro=?, edr_logradouro=?, adr_num=?, edr_complemento=?, edr_tipo=?, edr_nome_perso=? WHERE "
				+ idTable + "=?";
		}

		try {
			pstm = conn.prepareStatement(sql);

			if (null != endereco.getCep()) {
				pstm.setString(1, endereco.getEstado());
				pstm.setString(2, endereco.getCep());
				pstm.setString(3, endereco.getCidade());
				pstm.setString(4, endereco.getBairro());
				pstm.setString(5, endereco.getLogradouro());
				pstm.setString(6, endereco.getNumero());
				pstm.setString(7, endereco.getComplemento());
				pstm.setString(8, endereco.getTipoEndereco().toString().toUpperCase());
				pstm.setString(9, endereco.getApelido());
				pstm.setInt(10, endereco.getId());
			} else {
				pstm.setInt(2, endereco.getId());
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

		Address endereco = (Address) entity;

		String sql = "";

		if (endereco.getId() != 0) {
			// consult by id
			sql = "SELECT * from " + table + " WHERE " + idTable + "=?";
		} else if (endereco.getCliente().getUsuario().getId() != 0) {
			// consult by user id
			sql = "SELECT * from " + table
					+ " INNER JOIN clientes ON endereco.edr_cli_id=clientes.cli_id WHERE clientes.cli_usr=?";
		}

		List<DomainEntity> adresses = new ArrayList<DomainEntity>();

		try {
			pstm = conn.prepareStatement(sql);

			if (endereco.getId() != 0) {
				// consult by id
				pstm.setInt(1, endereco.getId());
			} else if (endereco.getCliente().getUsuario().getId() != 0) {
				// consult by user id
				pstm.setInt(1, endereco.getCliente().getUsuario().getId());
			}

			rs = pstm.executeQuery();

			while (rs.next()) {
				Address currentAddress = new Address();
				currentAddress.setId(rs.getInt(idTable));
				currentAddress.setEstado(rs.getString("edr_estado"));
				currentAddress.setCep(rs.getString("edr_cep"));
				currentAddress.setCidade(rs.getString("edr_cidade"));
				currentAddress.setBairro(rs.getString("edr_bairro"));
				currentAddress.setLogradouro(rs.getString("edr_logradouro"));
				currentAddress.setNumero(rs.getString("edr_num"));
				currentAddress.setComplemento(rs.getString("edr_complemento"));
				currentAddress.setApelido(rs.getString("edr_tipo_perso"));
				

				if (rs.getString("edr_tipo").equals("entrega")) {
					currentAddress.setTipoEndereco(AddressType.ENTREGA);
				} else if (rs.getString("edr_tipo").equals("cobranca")) {
					currentAddress.setTipoEndereco(AddressType.COBRANCA);
				} else if (rs.getString("edr_tipo").equals("cobranca_entrega")) {
					currentAddress.setTipoEndereco(AddressType.COBRANCA_ENTREGA);
				}

				Client client = new Client();
				client.setId(rs.getInt("ads_cli_id"));
				
				currentAddress.setCliente(client);
			
				
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
			if (conn != null) {
				try {
					System.out.println("Closing connection...");
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return adresses;
	}
}