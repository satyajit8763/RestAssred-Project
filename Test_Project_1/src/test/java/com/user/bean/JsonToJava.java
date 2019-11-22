package com.user.bean;

import org.codehaus.jackson.annotate.JsonIgnore;

public class JsonToJava 
{
String page;
String per_page;
String total;
@JsonIgnore
String total_pages;
Data[] data;
public String getPage() {
	return page;
}
public void setPage(String page) {
	this.page = page;
}
public String getPer_page() {
	return per_page;
}
public void setPer_page(String per_page) {
	this.per_page = per_page;
}
public String getTotal() {
	return total;
}
public void setTotal(String total) {
	this.total = total;
}
public String getTotal_pages() {
	return total_pages;
}
public void setTotalpages(String total_pages) {
	this.total_pages = total_pages;
}
public Data[] getData() {
	return data;
}
public void setData(Data[] data) {
	this.data = data;
}

}
