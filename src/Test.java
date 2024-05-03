import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Test {
	public static void main(String[] args){
		TestUserDAO dao = new TestUserDAO();
		dao.select("taro","123");
		dao.selectAll();
		dao.selectByName("taro");
		dao.selectByPassword("123");
	}



public void selectByPassword(String password){
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	
	String sql = "select * from test_table where password=?";
	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString((1, password);
		ResultSet rs=ps.executeQuery();
		while (rs.next()){
			System.out.println(rs.getString("user_name"));
			System.out.println(rs.getString("password"));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	try{
		con.close();
	}catch (SQLException e){
		e.printStackTrace();
	}
}

}