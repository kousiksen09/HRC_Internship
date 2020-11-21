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

@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ShowServlet()
	{
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Pojoclass> ksp=new ArrayList<Pojoclass>();
		try {
			ksp= ShowServlet.getall();
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
	            ResultSet rs = st.executeQuery("select * from customer_invoice LIMIT 500");
	            
	            while(rs.next()) {
	            	Pojoclass pj= new Pojoclass();
	            	 pj.setPk_id(rs.getInt("pk_id"));
	            	 pj.setAcct_doc_header_id(rs.getInt("acct_doc_header_id"));
	            	 pj.setCompany_id(rs.getInt("company_id"));
	                 pj.setDocument_number(rs.getInt("document_number"));
	                 pj.setDocument_number_norm(rs.getInt("document_number_norm"));
	                 pj.setBussiness_code(rs.getString("business_code"));
	                 pj.setCreate_year(rs.getInt("create_year"));
	                 pj.setDocument_line__number(rs.getInt("document_line_number"));
	                 pj.setDoctype(rs.getString("doctype"));
	                 pj.setCustomer_number(rs.getInt("customer_number"));
	                 pj.setCustomer_number_norm(rs.getInt("customer_number_norm"));
	                 pj.setFk_customer_map_id(rs.getInt("fk_customer_map_id"));
	                 pj.setCustomer_name(rs.getString("customer_name"));
	                 pj.setDivision(rs.getString("division"));
	                 pj.setDocument_create_date(rs.getDate("document_create_date"));
	                 pj.setDocument_create_date_norm(rs.getDate("document_create_date_norm"));
	                 pj.setPosting_date(rs.getDate("posting_date"));
	                 pj.setPosting_date_norm(rs.getDate("posting_date_norm"));
	                 pj.setPosting_id(rs.getString("posting_id"));
	                 pj.setDue_date(rs.getDate("due_date"));
	                 pj.setDue_date_norm(rs.getDate("due_date_norm")) ;
	                 pj.setOrder_date(rs.getDate("order_date"));
	                 pj.setOrder_date_norm(rs.getDate("order_date_norm"));
	                 pj.setInvoice_id(rs.getInt("invoice_id"));
	                 pj.setInvoice_id_norm(rs.getInt("invoice_id_norm"));
	                 pj.setBaseline_create_date(rs.getDate("baseline_create_date"));
	                 pj.setInvoice_date_norm(rs.getDate("invoice_date_norm"));
	                 pj.setTotal_open_amount(rs.getFloat("total_open_amount"));
	                 pj.setTotal_open_amount_norm(rs.getFloat("total_open_amount_norm"));
	                 pj.setCust_payment_terms(rs.getInt("cust_payment_terms"));
	                 pj.setBusiness_area(rs.getString("business_area"));
	                 pj.setShip_date(rs.getDate("ship_date"));               
	                 pj.setShip_to(rs.getString("ship_to"));
	                 pj.setClearing_date(rs.getDate("clearing_date"));
	                 pj.setClearing_date_norm(rs.getDate("clearing_date_norm"));
	                 pj.setReason_code(rs.getString("reason_code"));
	                 pj.setIsOpen(rs.getInt("isOpen"));
	                 pj.setDiscount_due_date_norm(rs.getDate("discount_due_date_norm"));
	                 pj.setDebit_credit_indicator(rs.getString("debit_credit_indicator"));
	                 pj.setPayment_method(rs.getString("payment_method"));
	                 pj.setDocument_creation_date(rs.getDate("document_creation_date"));
	                 pj.setInvoice_amount_doc_currency(rs.getFloat("invoice_amount_doc_currency"));
	                 pj.setDocument_id(rs.getInt("document_id"));
	                 pj.setActual_open_amount(rs.getFloat("actual_open_amount"));
	                 pj.setPaid_amount(rs.getFloat("paid_amount"));
	                 pj.setDayspast_due(rs.getInt("dayspast_due"));
	                 pj.setInvoice_age(rs.getInt("invoice_age"));
	                 pj.setDisputed_amount(rs.getFloat("disputed_amount"));
	                 al.add(pj);
	            }
	 }
		 catch (SQLException e) {
	            e.printStackTrace();
	        }
		 return al;
	}
}
