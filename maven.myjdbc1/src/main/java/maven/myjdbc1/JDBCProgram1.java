package maven.myjdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class JDBCProgram1 
{
	public static void main(String []args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test321","root","root");		
			String sql="Select empno,ename,sal,deptno,job as nor from emp";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			boolean rf=false;
			Emp e;
			while(rs.next())
			{
				e=new Emp(rs.getInt(1),rs.getString(2),rs.getString(5),rs.getFloat(3),rs.getInt(4));
				System.out.println(e.toString());
			}
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//return null;
		}
		//return null;
	}
}
