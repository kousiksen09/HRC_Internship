package com.customerInvoice;
import java.util.*;
public class NewPojo {
	public int getCustomer_number() {
		return customer_number;
	}
	public void setCustomer_number(int customer_number) {
		this.customer_number = customer_number;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public float getActual_open_amount() {
		return actual_open_amount;
	}
	public void setActual_open_amount(float actual_open_amount) {
		this.actual_open_amount = actual_open_amount;
	}
	public int customer_number;
	public String customer_name;
	public float actual_open_amount;
}
