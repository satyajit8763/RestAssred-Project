package com.user.bean;

public class UserData 
{
String Name;
String Email;
String Job;
String age;
String id;
String createdAt;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
}
public UserData(String Name, String Email, String job, String age) 
{
	
	this.Name = Name;
	this.Email = Email;
	this.Job = job;
	this.age = age;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getJob() {
	return Job;
}
public void setJob(String job) {
	Job = job;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
}









