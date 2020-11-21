package com.customerInvoice;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public CountServlet()
	{
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Pojoclass> ksp=new ArrayList<Pojoclass>();
		try {
			ksp= CountServlet.getall();
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(ksp, new TypeToken<List<Pojoclass>>() {}.getType());

			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	public static ArrayList<Pojoclass> getall() throws ClassNotFoundException
	 {

        String url = "jdbc:mysql://localhost:3306/project"; 

        String user = "root"; 

        String pass = "root"; 
	 
		 ArrayList<Pojoclass> al= new ArrayList<Pojoclass>();
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");

	            //Reference to connection interface 

	            Connection con = DriverManager.getConnection(url,user,pass); 
	            Statement st = con.createStatement(); 
	            ResultSet rs = st.executeQuery("select * from customer_invoice LIMIT 500000");
	            
	            while(rs.next()) {
	            	Pojoclass pj= new Pojoclass();
	            	 pj.setPk_id(rs.getInt("pk_id"));
	            	
	                 pj.setCustomer_number(rs.getInt("customer_number"));
	             
	                 pj.setCustomer_name(rs.getString("customer_name"));
	             
	                 pj.setTotal_open_amount(rs.getFloat("total_open_amount"));
	             
	             
	                 pj.setIsOpen(rs.getInt("isOpen"));
	              
	                 pj.setActual_open_amount(rs.getFloat("actual_open_amount"));
	             
	                 pj.setDayspast_due(rs.getInt("dayspast_due"));
	              
	                 al.add(pj);
	            }
	 }
		 catch (SQLException e) {
	            e.printStackTrace();
	        }
		 return al;
	}
}
