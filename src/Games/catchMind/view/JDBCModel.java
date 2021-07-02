package Games.catchMind.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCModel {

	private final String ip = "";
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatment;
	private ResultSet resultSet;
	
	public JDBCModel() {
		
			//1. 해당 데이터베이스에 대한 라이브러리 등록작업 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 데이터베이스와 연결함.  
			connection = DriverManager.getConnection("jdbc:oracle:thin:@" + ip, "c##catch", "bit");
			System.out.println(connection);
			//3. 쿼리문 작성 후 DB에서 쿼리문 실행시키고 결과를 가지고 옴
			statement = connection.createStatement();
			String query = "SELECT * FROM DB"; // 쿼리문을 통해 db 가져오기(수정필요함)
			resultSet = statement.executeQuery(query);
			System.out.println("아이디" + "\t" + "비밀번호" + "\t" + "닉네임" + "\t" + "핸드폰번호");
			System.out.println("--------------------");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString("id") + "\t");
				System.out.println(resultSet.getString("pw") + "\t");
				System.out.println(resultSet.getString("nickName") + "\t");
				System.out.println(resultSet.getString("phone") + "\t");
			}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
			//4. DB 와 관련된 객체는 반드시 close처리 
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		
		
		
	}

	public void addScoreWhenExitRoom(String nickName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
