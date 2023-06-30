package br.com.carv.app.connection;

import java.sql.Connection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConnectionFactoryTest {

	@Test
	public void should_return_connection() {
		Connection connection = ConnectionFactory.getConnection();
		Assertions.assertNotNull(connection);
	}
}
