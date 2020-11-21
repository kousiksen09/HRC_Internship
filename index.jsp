<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Customer Invoice</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<style>
html {
  
  scroll-behavior: smooth;
}
body {
  line-height: 24px;
  font-size: 14px;
  box-sizing: border-box;
  font-family: "Roboto", sans-serif;
  
  font-weight: normal;
  color: #777777;
}
.hrhead{
     font-family:"Kaushan Script","Helvetica Neue",Helvetica,Arial,cursive; 
    text-align: center;
    font-size: 2.8em;
    text-transform: capitalize;
 
    background-color: #36096d;
    background-image: linear-gradient(315deg, #36096d 0%, #37d5d6 74%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}
.hrbtn{
 position: relative;
  text-align: center;
  display: block;
  background-color: #6b0f1a;
  background-image: linear-gradient(315deg, #6b0f1a 0%, #b91372 74%);

  padding: 15px 40px;

  color: #fff;
  font-family: "Roboto", sans-serif;
  font-size: 15px;
  font-weight: 500;
  
  border: 1px solid #861657;
  outline: none !important;
  box-shadow: none !important;
  text-align: center;
  cursor: pointer;
  transition: all 300ms linear 0s;
  border-radius: 5px;
  text-transform: capitalize;
  }
  .hrc
  {
  top:0;
  left:0;
  margin:10px;
  padding: 20px 10px 10px 20px;
  max-height: 100vh;
  }
</style>
</head>
<body>
<div class="container">
<h2 class="hrhead">Customer Invoice Database</h2>


<div class="hrc">
<input type="button" class="hrbtn" value="Show Table" id="showTable"/>
<br>
  <table class="table table-dark table-striped" id="cid">
  <thead>
  <tr>
 <th scope="col">acct_doc_header_id</th>
  <th scope="col">company_id</th>
  <th scope="col">document_number</th>
  <th scope="col">document_number_norm  </th>
  <th scope="col">business_code</th>
  <th scope="col">create_year</th>
  <th scope="col">document_line_number</th>
  <th scope="col">doctype</th>
  <th scope="col">customer_number</th>
  <th scope="col">customer_number_norm</th>
  <th scope="col">fk_customer_map_id</th>
  <th scope="col">customer_name</th>
  <th scope="col">division</th>
  <th scope="col">document_create_date</th>
  <th scope="col">document_create_date_norm</th>
  <th scope="col">posting_date</th>
  <th scope="col">posting_date_norm</th>
  <th scope="col">posting_id</th>
  <th scope="col">due_date</th>
  <th scope="col">due_date_norm</th>
  <th scope="col">order_date</th>
  <th scope="col">order_date_norm</th>
  <th scope="col">invoice_id</th>
  <th scope="col">invoice_id_norm</th>
  <th scope="col">baseline_create_date</th>
  <th scope="col">invoice_date_norm</th>
  <th scope="col">total_open_amount</th>
  <th scope="col">total_open_amount_norm</th>
  <th scope="col">cust_payment_terms</th>
  <th scope="col">business_area</th>
  <th scope="col">ship_date</th>
  <th scope="col">ship_to</th>
  <th scope="col">clearing_date</th>
  <th scope="col">clearing_date_norm</th>
  <th scope="col">reason_code</th>
  <th scope="col">isOpen</th>
  <th scope="col">discount_due_date_norm</th>
  <th scope="col">debit_credit_indicator</th>
  <th scope="col">payment_method</th>
  <th scope="col">document_creation_date</th>
  <th scope="col">invoice_amount_doc_currency</th>
  <th scope="col">document_id</th>
  <th scope="col">actual_open_amount</th>
  <th scope="col">paid_amount</th>
  <th scope="col">dayspast_due</th>
  <th scope="col">invoice_age</th>
  <th scope="col">disputed_amount</th>
  
  </tr>
  </thead>
  </table>
  </div>
</div>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#hrc").hide();
     $("#showTable").click(function(event){
           $.get('ShowServlet',function(responseJson) {
        	   if(responseJson!=null){
            	   $("#cid").find("tr:gt(0)").remove();
            	   var table1 = $("#cid");
	               $.each(responseJson, function(key,value) { 
	               		   var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
	               		 rowNew.children().eq(0).text(value['acct_doc_header_id']); 
	                       rowNew.children().eq(1).text(value['company_id']);
	                       rowNew.children().eq(2).text(value['document_number']);
	                       rowNew.children().eq(3).text(value['document_number_norm']);
	                       rowNew.children().eq(4).text(value['business_code']);
	                       rowNew.children().eq(5).text(value['create_year']);
	                       rowNew.children().eq(6).text(value['document_line_number']);
	                       rowNew.children().eq(7).text(value['doctype']);
	                       rowNew.children().eq(8).text(value['customer_number']);
	                       rowNew.children().eq(9).text(value['customer_number_norm']);
	                       rowNew.children().eq(10).text(value['fk_customer_map_id']);
	                       rowNew.children().eq(11).text(value['customer_name']);
	                       rowNew.children().eq(12).text(value['division']);
	                       rowNew.children().eq(13).text(value['document_create_date']);
	                       rowNew.children().eq(14).text(value['document_create_date_norm']);
	                       rowNew.children().eq(15).text(value['posting_date']);
	                       rowNew.children().eq(16).text(value['posting_date_norm']);
	                       rowNew.children().eq(17).text(value['posting_id']);
	                       rowNew.children().eq(18).text(value['due_date']);
	                       rowNew.children().eq(19).text(value['due_date_norm']);
	                       rowNew.children().eq(20).text(value['order_date']);
	                       rowNew.children().eq(21).text(value['order_date_norm']);
	                       rowNew.children().eq(22).text(value['invoice_id']);
	                       rowNew.children().eq(23).text(value['invoice_id_norm']);
	                       rowNew.children().eq(24).text(value['baseline_create_date']);
	                       rowNew.children().eq(25).text(value['invoice_date_norm']);
	                       rowNew.children().eq(26).text(value['total_open_amount']);
	                       rowNew.children().eq(27).text(value['total_open_amount_norm']);
	                       rowNew.children().eq(28).text(value['cust_payment_terms']);
	                       rowNew.children().eq(29).text(value['business_area']);
	                       rowNew.children().eq(30).text(value['ship_date']);
	                       rowNew.children().eq(31).text(value['ship_to']);
	                       rowNew.children().eq(32).text(value['clearing_date']);
	                       rowNew.children().eq(33).text(value['clearing_date_norm']);
	                       rowNew.children().eq(34).text(value['reason_code']);
	                       rowNew.children().eq(35).text(value['isOpen']);
	                       rowNew.children().eq(36).text(value['discount_due_date_norm']);
	                       rowNew.children().eq(37).text(value['debit_credit_indicator']);
	                       rowNew.children().eq(38).text(value['payment_method']);
	                       rowNew.children().eq(39).text(value['document_creation_date']);
	                       rowNew.children().eq(40).text(value['invoice_amount_doc_currency']);
	                       rowNew.children().eq(41).text(value['document_id']);
	                       rowNew.children().eq(42).text(value['actual_open_amount']);
	                       rowNew.children().eq(43).text(value['paid_amount']);
	                       rowNew.children().eq(44).text(value['dayspast_due']);
	                       rowNew.children().eq(45).text(value['invoice_age']);
	                       rowNew.children().eq(46).text(value['disputed_amount']);

	                       rowNew.appendTo(table1);
	               });
                }
            });
            $("#hrc").show();          
	 });      
});
</script>



</body>
</html>