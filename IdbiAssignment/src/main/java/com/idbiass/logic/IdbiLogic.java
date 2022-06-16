package com.idbiass.logic;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.idbiass.dao.IdbiDAO;
import com.idbiass.dto.IdbiDTO;

public class IdbiLogic {

	private static String userName = "root";
	private static String password = "root";
	private static String url = "jdbc:mysql://localhost:3306/amey?useSSL=false";

	// date base variable
	private static final String INSERT_USERS_SQL = "INSERT INTO idbiass"
			+ " (fName,lName, moNumber, regDate, regTime,gender,email) VALUES " + " (?,?,?,?,?,?,?);";
	private static final String SELECT_ALL_USERS = "select * from idbiass;";
	private static final String SELECT_USER_BY_ID = "select id,fName, lName, moNumber,regDate, regTime,gender,email from idbiass where email =? and fName=?";
	
	protected static Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection(url, userName, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("Database connection established");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}

	Connection connection = null;

	public IdbiDAO insertUser(IdbiDTO idbiDtoObj) {

		// TODO Auto-generated method stub
		idbiDtoObj.setfName(idbiDtoObj.getfName());
		idbiDtoObj.setlName(idbiDtoObj.getlName());
		idbiDtoObj.setMoNumber(idbiDtoObj.getMoNumber());
		idbiDtoObj.setGender(idbiDtoObj.getGender());
		idbiDtoObj.setEmail(idbiDtoObj.getEmail());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		String strCurrentDate = sdf.format(currentDate);
	
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
		Date currentTime = new Date();
		String strCurrentTime = sdfTime.format(currentTime);

		IdbiDAO idbiDAOobj = new IdbiDAO();

		idbiDAOobj.setfName(idbiDtoObj.getfName());
		idbiDAOobj.setlName(idbiDtoObj.getlName());
		idbiDAOobj.setMoNumber(idbiDtoObj.getMoNumber());
		idbiDAOobj.setGender(idbiDtoObj.getGender());
		idbiDAOobj.setRegDate(strCurrentDate);
		idbiDAOobj.setRegTime(strCurrentTime);
		idbiDAOobj.setEmail(idbiDtoObj.getEmail());
		return idbiDAOobj;

	}

	public static void insertData(IdbiDAO idbiDaoObj) {
		// TODO Auto-generated method stub
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, idbiDaoObj.getfName());
			preparedStatement.setString(2, idbiDaoObj.getlName());
			int i=Integer.parseInt(idbiDaoObj.getMoNumber());
			preparedStatement.setInt(3, i);

			
//			preparedStatement.setString(3, idbiDaoObj.getMoNumber());
			
			preparedStatement.setString(4,idbiDaoObj.getRegDate());
			preparedStatement.setString(5, idbiDaoObj.getRegTime());
			preparedStatement.setString(6, idbiDaoObj.getGender());
			preparedStatement.setString(7, idbiDaoObj.getEmail());
//			System.out.println(idbiDaoObj.getfName());
//			System.out.println(idbiDaoObj.getfName());
//			System.out.println(idbiDaoObj.getlName());
////			not getting print
//			System.out.println(idbiDaoObj.getMoNumber());
//			System.out.println(idbiDaoObj.getRegDate());
//			System.out.println(idbiDaoObj.getRegTime());
//			System.out.println(idbiDaoObj.getGender());
//			System.out.println(idbiDaoObj.getEmail());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<IdbiDAO> selectAllUsers() {
		// TODO Auto-generated method stub
		List<IdbiDAO> users = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String fName = rs.getString("fName");
				String lName = rs.getString("lName");
				String moNumber = rs.getString("moNumber");
				String regDate = rs.getString("regDate");
				String regTime = rs.getString("regTime");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				users.add(new IdbiDAO(id,fName,lName, moNumber, regDate, regTime,gender,email));
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}

	

	public static IdbiDAO selectUser(String email, String a) {
		IdbiDAO user = null;
		System.out.println("Some THING IN SelectUser");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, a);
//			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String fName = rs.getString("fName");
				String lName = rs.getString("lName");
				String moNumber = rs.getString("moNumber");
				String regDate = rs.getString("regDate");
				String regTime = rs.getString("regTime");
//				String email = rs.getString("email");
				String gender = rs.getString("gender");
				user = new IdbiDAO(id,fName, lName, moNumber ,regDate, regTime,gender,email);

//				user = new IdbiDAO(moNumber, fName, lName, id,  regTime,gender);
//				System.out.println("Anyhing in select user");
//				System.out.println("user"+user);
			}
		} catch (SQLException e) {
			System.err.print(e);
		}
		return user;
	}


	
	
}
