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

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public SearchServlet()
	{
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<NewPojo> kspa=new ArrayList<NewPojo>();
		try {
			kspa= SearchServlet.searchAll();
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(kspa, new TypeToken<List<NewPojo>>() {}.getType());

			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	

public static ArrayList<NewPojo> searchAll() throws ClassNotFoundException
{

   String url = "jdbc:mysql://localhost:3306/project"; 

   String user = "root"; 

   String pass = "root"; 

	 ArrayList<NewPojo> alu = new ArrayList<NewPojo>();
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");

           //Reference to connection interface 

           Connection conn = DriverManager.getConnection(url,user,pass); 
           Statement st = conn.createStatement(); 
           String sql="SELECT customer_number, customer_name, SUM(actual_open_amount) as aoa FROM customer_invoice GROUP BY customer_number";
        
           ResultSet rss = st.executeQuery(sql);
           while(rss.next()) {
        	   
        	   NewPojo pjo= new NewPojo();
        	   pjo.setCustomer_number(rss.getInt("customer_number"));
        	   pjo.setCustomer_name(rss.getString("customer_name"));
        	   pjo.setActual_open_amount(rss.getFloat("aoa"));
        	   alu.add(pjo);
           }
	 }
           catch (SQLException e) {
	            e.printStackTrace();
	        }
		 return alu;
	}
}

 

