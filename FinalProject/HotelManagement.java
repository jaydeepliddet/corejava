package FinalProject;


import java.sql.*;
import java.util.*;


// Signin  part----------------------------------------------------------------------------

class Signin
{
	
	public void sign() throws SQLException
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		Scanner sc=null;
		try
		{
			sc=new Scanner(System.in);
			
			System.out.println("Please Create your Account before starting ");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
			if(con!=null)
			{
				pstmt=con.prepareStatement("insert into signup values(id,?,?,?,?,?,?)");
				
			}
			if(pstmt!=null)
			{
				
					
					System.out.println("Please enter your name");
					String username=sc.nextLine();
					System.out.println(" ");
					System.out.println("Please enter a password");
					String password=sc.nextLine();
					System.out.println(" ");
					System.out.println("Please enter email");
					String email=sc.nextLine();
					System.out.println(" ");
					System.out.println("Please eneter your phone no");
					String phoneno=sc.nextLine();
					System.out.println(" ");
					System.out.println("Please enter your location");
					String location=sc.nextLine();
					System.out.println(" ");
					System.out.println("Please eneter your pincode");
					int pincode=sc.nextInt();	
					System.out.println(" ");
					pstmt.setString(1, username);
					pstmt.setString(2,password );
					pstmt.setString(3, email);
					pstmt.setString(4, phoneno);
					pstmt.setString(5, location);
					pstmt.setInt(6, pincode);
					
					int result=pstmt.executeUpdate();
					if(result==0)
					{
						System.out.println("details are not inserted");
						
					}
					else
					{
						System.out.println("You Successfully Signed In");
					}
					
				}
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
				if(pstmt!=null)
				{
					pstmt.close();
				}
				
				if(con!=null)
				{
					con.close();
				}
				
			
		}
		
		

	}
}
//----------------------------------------------------------------------------------------------------------------


//-------------LOGIN PART-------------------------------------------------------------------------------------
class Login 
{
	
	Connection mycon=null;
	PreparedStatement mystmt=null;
	ResultSet myrs=null;
	Scanner sc=new Scanner(System.in);
	Boolean done=false;
	
	String username;
	String username1;
	String password;
	String custname;
	int idlogin;
	protected void statement() throws SQLException
	{
		System.out.println("Enter your username");
		username=sc.nextLine();
		System.out.println(" ");
		System.out.println("Enter your password");
		password=sc.nextLine();
		System.out.println(" ");
		mystmt.setString(1, username);
		mystmt.setString(2,password);
		
		
		myrs=mystmt.executeQuery();
		if(myrs.next())
		{
			done=true;
		}
		
	}
	
	
	public void logging() throws SQLException
	{
		myrs=mystmt.executeQuery();
		while(myrs.next())
			
	
		{
			
			username1=myrs.getString("username") ;
			String password1=myrs.getString("password");
			idlogin=myrs.getInt("id");
			
		if(username1.equals(username1)&& password1.equals(password1))
		{
	
		 System.out.println(username1+" you Successfully loggedin");
		 
		}
		
		}
	}
	
	
public void login() throws SQLException
{
	

try
{
	mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
	//System.out.println(mycon);
	
	//2.create statement
	if(mycon!=null)
	{	
	mystmt=mycon.prepareStatement("Select * from signup where username = ? and password = ?");
	}
	if(mystmt!=null)
	{	
		statement();
		
	
//		System.out.println(myrs);
		
		if(done.equals(true))
		{
			logging();
		}
		else {
			
			System.out.println("Try again!!Please enter a correct username or password");
			while(done!=true)
			{
			statement();
			}
			logging();
			
			
		}
	}
	//3.execute sql query
	
	

}
catch(Exception e)
{
	e.printStackTrace();
}

finally
{
	
	if(myrs!=null)
	{
		myrs.close();
	}
	
	if(mystmt!=null)
	{
		mystmt.close();
		
	}
	
	if(mycon!=null)
	{
		mycon.close();
	}
	
}


}


}
//----------------------------------------------------------------------------------------------------------------

//-------------------------New Booking---------------------------------------------------------------------------
class NewBooking extends Login
{
	int getidd=0;
	
	String set;
	int id;
	String location;
	int select;
	String hotel;
	int stay;
	int guest;
	public void Location()
	{
		System.out.println("Select Location");
		System.out.println("1.Goa   2.Manali   3.Shimla   4.Kashmir  ");
		int press=sc.nextInt();
		if(press==1)
		{
			location="Goa";
		}
		else if(press==2)
		{
			location="Manali";
		}
		else if(press==3)
		{
			location="Shimla";
		}
		else if(press==4)
		{
			location="Kashmir";
		}
		else
		{
			System.out.println(" Enter correct number");
			Location();
		}
	}
	
	public void Hotel()
	{
		System.out.println("Select which Star Hotel you wanna Stay In ");
		System.out.println("1.5star  2.4star  3.3star ");
		select=sc.nextInt();
		if(select==1)
		{
			star5();
		}
		else if(select==2)
		{
			star4();
		}
		else if(select==3)
		{
			star3();
		}
		else
		{
			System.out.println("Enter correct number");
			Hotel();	
		}
	}
	
	
	public void star5()
	{
		System.out.println("Select which Hotel you wannna Check In ");
		System.out.println("1.JW Marriot   2.The Lalit   3.The Taj ");
		select=sc.nextInt();
		if(select==1)
		{
			hotel="JW Marriot";
		}
		
		else if(select==2)
		{
			hotel="The Lalit";
		}
		
		else if(select==3)
		{
			hotel="The Taj";
		}
		else
		{
			System.out.println("Enter correct number");
			star5();
		}
	}
	
	public void star4()
	{
		System.out.println("Select which Hotel you wannna Check In ");
		System.out.println("1.Suncity   2.Regency   3.Hubtown ");
		select=sc.nextInt();
		if(select==1)
		{
			hotel="Suncity";
		}
		
		else if(select==2)
		{
			hotel="Regency";
		}
		
		else if(select==3)
		{
			hotel="Hubtown";
		}
		else
		{
			System.out.println("Enter correct number");
			star4();
		}
	}
	public void star3()
	{
		System.out.println("Select which Hotel you wannna Check In ");
		System.out.println("1.Banquet   2.Sagar   3.Asma ");
		select=sc.nextInt();
		if(select==1)
		{
			hotel="Banquet";
		}
		
		else if(select==2)
		{
			hotel="Sagar";
		}
		
		else if(select==3)
		{
			hotel="Asma";
		}
		else
		{
			System.out.println("Enter correct number");
			star3();
		}
	}
	public void Stay()
	{
		System.out.println("How many days/night you wanna stay ");
		
		stay=sc.nextInt();
		
	}
	public void book() throws SQLException
	{
		getidd=super.idlogin;
		set=super.username1;
		
		
		
		
		
		
		Connection con=null;
		PreparedStatement pstmt=null;
		Scanner sc=null;
		try
		{
			sc=new Scanner(System.in);
			
			System.out.println("Please Fill up the following details for booking your Hotel ");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
			if(con!=null)
			{
				pstmt=con.prepareStatement("insert into booking values(BookingId,?,?,?,?,?,?,?)");
				
			}
			if(pstmt!=null)
			{
				
					
					
					System.out.println("Enter date you wannna go");
					String date=sc.nextLine();
					System.out.println(" ");
					Location();
					System.out.println(" ");
					Hotel();
					System.out.println(" ");
					Stay();
					System.out.println(" ");
					System.out.println("Please eneter no guest");
					guest=sc.nextInt();
					System.out.println(" ");
			
					pstmt.setInt(1, getidd);
					pstmt.setString(2,set );
					pstmt.setString(3, date);
					pstmt.setString(4, location);
					pstmt.setString(5, hotel);
					pstmt.setInt(6, stay);
					pstmt.setInt(7, guest);
					
					
					int result=pstmt.executeUpdate();
					if(result==0)
					{
						System.out.println("details are not inserted");
						
					}
					else
					{
						System.out.println(" Booking is Successfully done Thank you:)");
					}
					
				}
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
				if(pstmt!=null)
				{
					pstmt.close();
				}
				
				if(con!=null)
				{
					con.close();
				}
				
			
		}
		
		


		
	}
	
	
	
	
	
	
}


//---------------------------------------------------------------------------------------------------------------


//--------------------------------CheckStatus------------------------------------------------------------------------

class CheckStatus extends NewBooking
{

	Connection mycon=null;
	PreparedStatement mystmt=null;
	ResultSet myrs=null;
	int getidd;
	String usn;
	public void Status() throws SQLException
	{
		getidd=super.idlogin;
		
		System.out.println(" ");
		try
		{
			mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
//			System.out.println(mycon);
			
			//2.create statement
				
			mystmt=mycon.prepareStatement("Select * from booking where id = ? ");
			
				
			mystmt.setInt(1,getidd);
				
				
				myrs=mystmt.executeQuery();
				staterun();
				

			
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
				if(mystmt!=null)
				{
					mystmt.close();
				}
				
				if(mycon!=null)
				{
					mycon.close();
				}
				
			
		}
	}
	public void amount() throws SQLException
	{
		String hotel=myrs.getString("hotel");
		System.out.println(hotel);
		if(hotel.equals("JW Marriot") || hotel.equals("The Lalit") || hotel.equals("The Taj"))
		{
			double ex=10000;
			double tax=489.00;
			int stay=myrs.getInt("stay");
			int guest=myrs.getInt("guest");
			int ppl=1000;
			ppl=guest*ppl;
			double total=ex*stay;
			total=total+guest+tax;
			System.out.println("Total Amount :-  "+total);
		}
		else if(hotel.equals("Banquet") || hotel.equals("Sagar") || hotel.equals("Asma"))
		{
			double ex=5000;
			double tax=489.00;
			int stay=myrs.getInt("stay");
			int guest=myrs.getInt("guest");
			int ppl=1000;
			ppl=guest*ppl;
			double total=ex*stay;
			total=total+guest+tax;
			System.out.println("Total Amount :-  "+total);
		}
		else if(hotel.equals("Suncity") || hotel.equals("Hubtown") || hotel.equals("Regency"))
		{
			double ex=7000;
			double tax=489.00;
			int stay=myrs.getInt("stay");
			int guest=myrs.getInt("guest");
			int ppl=1000;
			ppl=guest*ppl;
			double total=ex*stay;
			total=total+guest+tax;
			System.out.println("Total Amount :-  "+total);
		}
	}
	public void staterun() throws SQLException
	{
		while(myrs.next())
		{
			
			String username=myrs.getString("username");
			System.out.println("Mr."+username);
			String location=myrs.getString("location");
			System.out.println("Name of Place:-\t"+location);
			String hotel=myrs.getString("hotel");
			System.out.println("Name of the Hotel:-"+hotel);
			String date=myrs.getString("date");
			System.out.println("Checkin Date:-\t"+date);
			int stay=myrs.getInt("stay");
			System.out.println("No.of stays:-\t"+stay);
			int guest=myrs.getInt("guest");
			System.out.println("No.of Guests:-\t"+guest);
			double tax=489.00;
			System.out.println("Taxes:-\t" +tax+"/-");
			amount();
			
			
			
			
		}
	}
}

//----------------------------------------------------------------------------------------------------------------
public class HotelManagement {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
//		Login lg=new Login();
//		NewBooking lg=new NewBooking();
		CheckStatus cs=new CheckStatus();
		Scanner inp=new Scanner(System.in);
		System.out.println("If you are new here Pls Signup or else You already have an account please Login ??");
		System.out.println("Please Type(0)= For Login OR Type(1)=For Signin ");
		int type=inp.nextInt();
		if(type==1)
		{
			System.out.println("Please Fill up the details to complete your Signin");
			Signin sgn=new Signin();
			sgn.sign();
			System.out.println("Login to your Id");
			System.out.println(" ");
			cs.login();
		}
		else
		{
			System.out.println("Login to your Id");
			System.out.println(" ");
			cs.login();
		}
		
//		
		
		System.out.println(" ");
		System.out.println("Welcome to the Home page");
		System.out.println(" ");
		System.out.println("Please Select Press");
		
		System.out.println("1.NewBooking  2.Check Status 3.Logout");
	
		int press=inp.nextInt();
		
		while(press!=3)
		{
		
		if(press==1)
		{
			System.out.println(" New Booking");
			cs.book();
			
		}
		else if(press==2)
		{
			System.out.println(" Check Status");
			System.out.println(" ");
			cs.Status();
			
			
					
		}
		else if(press==3)
		{
			System.out.println(" Logged Out ");
		}
		else
		{
			System.out.println("Enter the correct number ");
			System.out.println("1.NewBooking  2.Check Status 3.Logout");
			
			press=inp.nextInt();
		}
		System.out.println(" ");
		System.out.println("1.NewBooking  2.Check Status 3.Logout");
		
		press=inp.nextInt();
		}
		System.out.println("You Logged Out");
	}

}
