package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.AbstractDAO;
import domain.client.DomainEntity;
import domain.client.User;
import domain.client.UserRole;

public class UserDAO extends AbstractDAO {

	public UserDAO() {
		super("users", "usr_id");
	}


	public int save(DomainEntity entity) {
		openConnection();
		PreparedStatement pstm = null;

		User user = (User) entity;

		String sql = "INSERT INTO " + table + "(usr_email, usr_password, usr_role, usr_is_active) VALUES (?, ?, ?, ?)";

		try {
			pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pstm.setString(1, user.getEmail());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getRole().toString().toLowerCase());
			pstm.setBoolean(4, user.isActive());

			pstm.execute();

			ResultSet rs = pstm.getGeneratedKeys();

			int idUser = 0;

			if (rs.next()) {
				idUser = rs.getInt(1);
			}

			return idUser;
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

		User user = (User) entity;

		String sql = "UPDATE " + table + " SET usr_password=?, usr_is_active=? WHERE " + idTable + "=?";

		try {
			pstm = connection.prepareStatement(sql);

			pstm.setString(1, user.getPassword());
			pstm.setBoolean(2, user.isActive());
			pstm.setInt(3, user.getId());

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
	}

	
	public List<DomainEntity> consult(DomainEntity entity) {
		openConnection();

		PreparedStatement pstm = null;
		ResultSet rs = null;

		User user = (User) entity;

		String sql = "";

		if (user.getId() != 0) {
			// consult by id
			sql = "SELECT * from " + table + " WHERE usr_id=?";
		} else if (null != user.getEmail()) {
			if (null == user.getPassword()) {
				// consult by email
				sql = "SELECT * from " + table + " WHERE usr_email=?";
			} else if (null != user.getPassword()) {
				// consult by email and password (login consult)
				sql = "SELECT * from " + table + " WHERE usr_email=? AND usr_password=?";
			}
		}

		List<DomainEntity> users = new ArrayList<DomainEntity>();

		try {
			pstm = connection.prepareStatement(sql);

			if (user.getId() != 0) {
				// consult by id
				pstm.setInt(1, user.getId());
			} else if (null != user.getEmail()) {
				if (null == user.getPassword()) {
					// consult by email
					pstm.setString(1, user.getEmail());
				} else if (null != user.getPassword()) {
					// consult by email and password (login consult)
					pstm.setString(1, user.getEmail());
					pstm.setString(2, user.getPassword());
				}
			}

			rs = pstm.executeQuery();

			while (rs.next()) {
				User currentUser = new User();
				currentUser.setId(rs.getInt(idTable));
				currentUser.setEmail(rs.getString("usr_email"));
				currentUser.setPassword(rs.getString("usr_password"));
				currentUser.setRole(rs.getString("usr_role").equals("client") ? UserRole.CLIENT : UserRole.ADMIN);
				currentUser.setActive(rs.getBoolean("usr_is_active"));

				users.add(currentUser);
			}

			return users;
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

		return users;
	}
}
