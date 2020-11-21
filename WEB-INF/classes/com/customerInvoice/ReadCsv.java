package com.customerInvoice;
import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.Date;
import com.customerInvoice.Pojoclass;
public class ReadCsv {
	
	
	//Statement stmt=null;
	//static ResultSet rs=null;
	
	//Simple query
    //String query="SELECT * from customer_invoice";
    //pstmt=dbcon.prepareStatement(query);
    //rs=pstmt.executeQuery();
	
	public static void main(String[] args) throws IOException, SQLException, ParseException{
		
//connect to data base
		       Connection dbcon=null;
		       PreparedStatement pstmt=null;
		        //Database credentials from slqyog
				String url="jdbc:mysql://localhost/project";
				String username="root";
				String password="root";
				
				
				try {
					//Registering driver class
					Class.forName("com.mysql.cj.jdbc.Driver");
					//creating connection
					dbcon=DriverManager.getConnection(url,username,password);	
					
				}
				catch(Exception e){
					System.out.println(e);
				}
				
				
//Reading Data from CSV File and load to Pojoclass.
				FileReader fr=null;
				BufferedReader bfr=null;
				try {
					fr=new FileReader("D:\\Data_uploading.csv");
					bfr=new BufferedReader(fr);			
				}
				catch(Exception e) {
					System.out.println("Data uploading.csv not found");
				}
				
				String str=bfr.readLine();
				
//				String strin[]=str.split(",");
//				System.out.println(strin.length);
				List<Pojoclass> list=new ArrayList<>();
				
				while((str=bfr.readLine())!=null) {
					
					String string[]=str.split(",",-1);
					Pojoclass obj=new Pojoclass();
					if(!string[0].isEmpty()) {
						obj.setAcct_doc_header_id(Integer.parseInt(string[0]));
					}
					else {
						obj.setAcct_doc_header_id(Types.NULL);
					}
					
                    if(!string[1].isEmpty()) {
						obj.setCompany_id(Integer.parseInt(string[1]));
					}
					else {
						obj.setCompany_id(Types.NULL);
					}
                    
                    if(!string[2].isEmpty()) {
						obj.setDocument_number(Integer.parseInt(string[2]));
					}
					else {
						obj.setDocument_number(Types.NULL);
					}

                    if(!string[3].isEmpty()) {
						obj.setDocument_number_norm(Integer.parseInt(string[3]));
					}
					else {
						obj.setDocument_number_norm(Types.NULL);
					}

                    if(!string[4].isEmpty()) {
                    	obj.setBussiness_code(string[4]);
					}
					else {
						obj.setBussiness_code(null);
					}

                    if(!string[5].isEmpty()) {
						obj.setCreate_year(string[5]);
					}
					else {
						obj.setCreate_year(null);
					}

                    if(!string[6].isEmpty()) {
						obj.setDocument_line__number(Integer.parseInt(string[6]));
					}
					else {
						obj.setDocument_line__number(Types.NULL);
					}

                    if(!string[7].isEmpty()) {
						obj.setDoctype(string[7]);
					}
					else {
						obj.setDoctype(null);
					}

                    if(!string[8].isEmpty()) {
						obj.setCustomer_number(Integer.parseInt(string[8]));
					}
					else {
						obj.setCustomer_number(Types.NULL);
					}

                    if(!string[9].isEmpty()) {
						obj.setCustomer_number_norm(Integer.parseInt(string[9]));
					}
					else {
						obj.setCustomer_number_norm(Types.NULL);
					}

                    if(!string[10].isEmpty()) {
						obj.setFk_customer_map_id(Integer.parseInt(string[10]));
					}
					else {
						obj.setFk_customer_map_id(Types.NULL);
					}

                    if(!string[11].isEmpty()) {
						obj.setCustomer_name(string[11]);
					}
					else {
						obj.setCustomer_name(null);
					}

                    if(!string[12].isEmpty()) {
						obj.setDivision(string[12]);
					}
					else {
						obj.setDivision(null);
					}

                    if(!string[13].isEmpty()) {
						obj.setDocument_create_date(java.sql.Date.valueOf(string[13]));
					}
					else {
						obj.setDocument_create_date(null);
					}

                    if(!string[14].isEmpty()) {
						obj.setDocument_create_date_norm(java.sql.Date.valueOf(string[14]));
					}
					else {
						obj.setDocument_create_date_norm(null);
					}

                    if(!string[15].isEmpty()) {
						obj.setPosting_date(java.sql.Date.valueOf(string[15]));
					}
					else {
						obj.setPosting_date(null);
					}

                    if(!string[16].isEmpty()) {
						obj.setPosting_date_norm(java.sql.Date.valueOf(string[16]));
					}
					else {
						obj.setPosting_date_norm(null);
					}

                    if(!string[17].isEmpty()) {
						obj.setPosting_id(string[17]);
					}
					else {
						obj.setPosting_id(null);
					}

                    if(!string[18].isEmpty()) {
						obj.setDue_date(java.sql.Date.valueOf(string[18]));
					}
					else {
						obj.setDue_date(null);
					}

                    if(!string[19].isEmpty()) {
						obj.setDue_date_norm(java.sql.Date.valueOf(string[19]));
					}
					else {
						obj.setDue_date_norm(null);
					}

                    if(!string[20].isEmpty()) {
						obj.setOrder_date(java.sql.Date.valueOf(string[20]));
					}
					else {
						obj.setOrder_date(null);
					}

                    if(!string[21].isEmpty()) {
						obj.setOrder_date_norm(java.sql.Date.valueOf(string[21]));
					}
					else {
						obj.setOrder_date_norm(null);
					}

                    if(!string[22].isEmpty()) {
						obj.setInvoice_id(Integer.parseInt(string[22]));
					}
					else {
						obj.setInvoice_id(Types.NULL);
					}

                    if(!string[23].isEmpty()) {
						obj.setInvoice_id_norm(Integer.parseInt(string[23]));
					}
					else {
						obj.setInvoice_id_norm(Types.NULL);
					}

                    if(!string[24].isEmpty()) {
						obj.setBaseline_create_date(java.sql.Date.valueOf(string[24]));
					}
					else {
						obj.setBaseline_create_date(null);
					}

                    if(!string[25].isEmpty()) {
						obj.setInvoice_date_norm(java.sql.Date.valueOf(string[25]));
					}
					else {
						obj.setInvoice_date_norm(null);
					}

                    if(!string[26].isEmpty()) {
						obj.setTotal_open_amount(Float.parseFloat(string[26]));
					}
					else {
						obj.setTotal_open_amount(Types.NULL);
					}

                    if(!string[27].isEmpty()) {
						obj.setTotal_open_amount_norm(Float.parseFloat(string[27]));
					}
					else {
						obj.setTotal_open_amount_norm(Types.NULL);
					}

                    if(!string[28].isEmpty()) {
						obj.setCust_payment_terms(Integer.parseInt(string[28]));
					}
					else {
						obj.setCust_payment_terms(Types.NULL);
					}

                    if(!string[29].isEmpty()) {
						obj.setBusiness_area(string[29]);
					}
					else {
						obj.setBusiness_area(null);
					}

                    if(!string[30].isEmpty()) {
                    	//ship date contains date of different format.
                    	
                    	String new1=string[30].replace('/', '-');
                    	SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
                    	java.util.Date date=format.parse(new1);
                    	java.sql.Date newdate=new java.sql.Date(date.getTime());
						obj.setShip_date(newdate);
					}
					else {
						obj.setShip_date(null);
					}

                    if(!string[31].isEmpty()) {
						obj.setShip_to(string[31]);
					}
					else {
						obj.setShip_to(null);
					}

                    if(!string[32].isEmpty()) {
						obj.setClearing_date(java.sql.Date.valueOf(string[32]));
					}
					else {
						obj.setClearing_date(null);
					}

                    if(!string[33].isEmpty()) {
						obj.setClearing_date_norm(java.sql.Date.valueOf(string[33]));
					}
					else {
						obj.setClearing_date_norm(null);
					}

                    if(!string[34].isEmpty()) {
						obj.setReason_code(string[34]);
					}
					else {
						obj.setReason_code(null);
					}

                    if(!string[35].isEmpty()) {
						obj.setIsOpen(Integer.parseInt(string[35]));
					}
					else {
						obj.setIsOpen(Types.NULL);
					}

                    if(!string[36].isEmpty()) {
						obj.setDiscount_due_date_norm(java.sql.Date.valueOf(string[36]));
					}
					else {
						obj.setDiscount_due_date_norm(null);
					}

                    if(!string[37].isEmpty()) {
						obj.setDebit_credit_indicator(string[37]);
					}
					else {
						obj.setDebit_credit_indicator(null);
					}

                    if(!string[38].isEmpty()) {
						obj.setPayment_method(string[38]);
					}
					else {
						obj.setPayment_method(null);
					}

                    if(!string[39].isEmpty()) {
						obj.setDocument_creation_date(java.sql.Date.valueOf(string[39]));
					}
					else {
						obj.setDocument_creation_date(null);
					}

                    if(!string[40].isEmpty()) {
						obj.setInvoice_amount_doc_currency(Float.parseFloat(string[40]));
					}
					else {
						obj.setInvoice_amount_doc_currency(Types.NULL);
					}

                    if(!string[41].isEmpty()) {
						obj.setDocument_id(Integer.parseInt(string[41]));
					}
					else {
						obj.setDocument_id(Types.NULL);
					}

                    if(!string[42].isEmpty()) {
						obj.setActual_open_amount(Float.parseFloat(string[42]));
					}
					else {
						obj.setActual_open_amount(Types.NULL);
					}

                    if(!string[43].isEmpty()) {
						obj.setPaid_amount(Float.parseFloat(string[43]));
					}
					else {
						obj.setPaid_amount(Types.NULL);
					}

                    if(!string[44].isEmpty()) {
						obj.setDayspast_due(Integer.parseInt(string[44]));
					}
					else {
						obj.setDayspast_due(Types.NULL);
					}

                    if(!string[45].isEmpty()) {
						obj.setInvoice_age(Integer.parseInt(string[45]));
					}
					else {
						obj.setInvoice_age(Types.NULL);
					}

                    if(!string[46].isEmpty()) {
						obj.setDisputed_amount(Float.parseFloat(string[46]));
					}
					else {
						obj.setDisputed_amount(Types.NULL);
					}

				list.add(obj);					
					
				} 

//loading data to database.
				int affected = 0;
				Iterator i=list.iterator(); //list type iterator
				int count = 1;
				       
				while(i.hasNext()) {
					
					Pojoclass pj=(Pojoclass)i.next();
					
					//preparing query statement.
					String query="INSERT INTO customer_invoice(`acct_doc_header_id`,`company_id`,`document_number`,`document_number_norm`,`business_code`,`create_year`,`document_line_number`,`doctype`,`customer_number`,`customer_number_norm`,`fk_customer_map_id`,`customer_name`,`division`,`document_create_date`,`document_create_date_norm`,`posting_date`,`posting_date_norm`,`posting_id`,`due_date`,`due_date_norm`,`order_date`,`order_date_norm`,`invoice_id`,`invoice_id_norm`,`baseline_create_date`,`invoice_date_norm`,`total_open_amount`,`total_open_amount_norm`,`cust_payment_terms`,`business_area`,`ship_date`,`ship_to`,`clearing_date`,`clearing_date_norm`,`reason_code`,`isopen`,`discount_due_date_norm`,`debit_credit_indicator`,`payment_method`,`document_creation_date`,`invoice_amount_doc_currency`,`document_id`,`actual_open_amount`,`paid_amount`,`dayspast_due`,`invoice_age`,`disputed_amount`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt=dbcon.prepareStatement(query);
					
					//geeting data using Pojoclass getter.
					
					pstmt.setDate(14, (java.sql.Date) pj.getDocument_create_date());
					pstmt.setDate(15, (java.sql.Date) pj.getDocument_create_date_norm());
					pstmt.setDate(16, (java.sql.Date) pj.getPosting_date());
					pstmt.setDate(17, (java.sql.Date) pj.getPosting_date_norm());
					pstmt.setDate(19, (java.sql.Date) pj.getDue_date());
					pstmt.setDate(20, (java.sql.Date) pj.getDue_date_norm());
					pstmt.setDate(21, (java.sql.Date) pj.getOrder_date());
					pstmt.setDate(22, (java.sql.Date) pj.getOrder_date_norm());
					pstmt.setDate(25, (java.sql.Date) pj.getBaseline_create_date());
					pstmt.setDate(26, (java.sql.Date) pj.getInvoice_date_norm());
					pstmt.setDate(31, (java.sql.Date) pj.getShip_date());
					//pstmt.setDate(31,null);
					pstmt.setDate(33, (java.sql.Date) pj.getClearing_date());
					pstmt.setDate(34, (java.sql.Date) pj.getClearing_date_norm());
					pstmt.setDate(37, (java.sql.Date) pj.getDiscount_due_date_norm());
					pstmt.setDate(40, (java.sql.Date) pj.getDocument_creation_date());
					
					pstmt.setString(5, pj.getBussiness_code());
					pstmt.setString(6, pj.getCreate_year());
					pstmt.setString(8, pj.getDoctype());
					pstmt.setString(12, pj.getCustomer_name());
					pstmt.setString(13, pj.getDivision());
					pstmt.setString(18, pj.getPosting_id());
					pstmt.setString(30, pj.getBusiness_area());
					pstmt.setString(32, pj.getShip_to());
					pstmt.setString(35, pj.getReason_code());
					pstmt.setString(38, pj.getDebit_credit_indicator());
					pstmt.setString(39, pj.getPayment_method());
					
					Integer j;
					
					if((j=pj.getAcct_doc_header_id()) == null) {
						pstmt.setNull(1, Types.NULL); //java.sql.Types.INT
					}
					else {
						pstmt.setInt(1, j);
					}
					
					if((j=pj.getCompany_id()) == null) {
						pstmt.setNull(2, Types.NULL);
					}
					else {
						pstmt.setInt(2, j);
					}
					
					if((j=pj.getDocument_number()) == null) {
						pstmt.setNull(3, Types.NULL);
					}
					else {
						pstmt.setInt(3, j);
					}
					
					if((j=pj.getDocument_number_norm()) == null) {
						pstmt.setNull(4, Types.NULL);
					}
					else {
						pstmt.setInt(4, j);
					}
					
					if((j=pj.getDocument_line__number()) == null) {
						pstmt.setNull(7, Types.NULL);
					}
					else {
						pstmt.setInt(7, j);
					}
					
					if((j=pj.getCustomer_number()) == null) {
						pstmt.setNull(9, Types.NULL);
					}
					else {
						pstmt.setInt(9, j);
					}
					
					if((j=pj.getCustomer_number_norm()) == null) {
						pstmt.setNull(10, Types.NULL);
					}
					else {
						pstmt.setInt(10, j);
					}
					
					if((j=pj.getFk_customer_map_id()) == null) {
						pstmt.setNull(11, Types.NULL);
					}
					else {
						pstmt.setInt(11, j);
					}
					
					if((j=pj.getInvoice_id()) == null) {
						pstmt.setNull(23, Types.NULL);
					}
					else {
						pstmt.setInt(23, j);
					}
					
					if((j=pj.getInvoice_id_norm()) == null) {
						pstmt.setNull(24, Types.NULL);
					}
					else {
						pstmt.setInt(24, j);
					}
					
					if((j=pj.getCust_payment_terms()) == null) {
						pstmt.setNull(29, Types.NULL);
					}
					else {
						pstmt.setInt(29, j);
					}
					
					if((j=pj.getIsOpen()) == null) {
						pstmt.setNull(36, Types.NULL);
					}
					else {
						pstmt.setInt(36, j);
					}
					
					
					if((j=pj.getDocument_id()) == null) {
						pstmt.setNull(42, Types.NULL);
					}
					else {
						pstmt.setInt(42, j);
					}
					
					if((j=pj.getDayspast_due()) == null) {
						pstmt.setNull(45, Types.NULL);
					}
					else {
						pstmt.setInt(45, j);
					}
					
					if((j=pj.getInvoice_age()) == null) {
						pstmt.setNull(46, Types.NULL);
					}
					else {
						pstmt.setInt(46, j);
					}
					
					
					
					Float k;
					
					if((k=pj.getTotal_open_amount())!=null) {
						pstmt.setFloat(27, k);
					}
					else {
						pstmt.setNull(27, Types.NULL);
					}
					
					if((k=pj.getTotal_open_amount_norm())!=null) {
						pstmt.setFloat(28, k);
					}
					else {
						pstmt.setNull(28, Types.NULL);
					}
					
					if((k=pj.getInvoice_amount_doc_currency())!=null) {
						pstmt.setFloat(41, k);
					}
					else {
						pstmt.setNull(41, Types.NULL);
					}
					
					if((k=pj.getActual_open_amount())!=null) {
						pstmt.setFloat(43, k);
					}
					else {
						pstmt.setNull(43, Types.NULL);
					}
					
					if((k=pj.getPaid_amount())!=null) {
						pstmt.setFloat(44, k);
					}
					else {
						pstmt.setNull(44, Types.NULL);
					}
					
					if((k=pj.getDisputed_amount())!=null) {
						pstmt.setFloat(47, k);
					}
					else {
						pstmt.setNull(47,Types.NULL);//
					}
					
					
					//all values fetched and fitted to prepared statement via getter
					
					
					affected=pstmt.executeUpdate();
					System.out.println("Inserted Row:"+count);
					count++;
					
				
				}
				
		
	}

}
