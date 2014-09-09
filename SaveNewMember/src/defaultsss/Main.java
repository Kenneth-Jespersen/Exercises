package defaultsss;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		

		MemberController.saveMember();
		MemberController.loadMember();

	}

}
