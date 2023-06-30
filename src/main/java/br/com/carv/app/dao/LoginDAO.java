package br.com.carv.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import br.com.carv.app.connection.ConnectionFactory;
import br.com.carv.app.payload.LoginRequest;

public class LoginDAO {

	private final Connection connection = ConnectionFactory.getConnection();
	private final Logger logger = Logger.getLogger(LoginDAO.class.getSimpleName());

	public Boolean validateEmail(LoginRequest loginRequest) throws SQLException {
		logger.info("Checking email availability.");

		String query = "SELECT email FROM Login WHERE EXISTS (SELECT email FROM Login WHERE email =  ?)";
		PreparedStatement preparedStatement = this.connection.prepareStatement(query);
		preparedStatement.setString(1, loginRequest.getEmail());

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) return false;

		return true;
	}

	public Boolean authenticate(LoginRequest loginRequest) throws SQLException {
		logger.info("Authenticating login to the database.");

		String query = "SELECT email, password FROM Login WHERE (email = ? AND password = ?)";
		PreparedStatement preparedStatement = this.connection.prepareStatement(query);
		preparedStatement.setString(1, loginRequest.getEmail());
		preparedStatement.setString(2, loginRequest.getPassword());

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) return true;

		return false;
	}
}
