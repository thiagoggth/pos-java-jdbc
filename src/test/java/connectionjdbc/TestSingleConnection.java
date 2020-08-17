package connectionjdbc;

import org.junit.Test;

public class TestSingleConnection {
	@Test
	public void initDB() {
		SingleConnection.getConnection();
	}
}
