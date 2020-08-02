package com.project.sandesh.encrypteraes;

public class RegisterData {

	int id;
	String name;
	String password;
	String mob;
	String sec;

	public RegisterData(){

	 }
	public RegisterData( String  name, String  password ,String  mob, String sec){

		this.name = name ;
		this.password = password;
		this.mob = mob;
		this.sec = sec;
	 }

	 public String getname() {
	              return name;
	       }

	public void setname(String name){
	this.name = name;
	 }


	public String getmob() {
	              // TODO Auto-generated method stub
	              return mob;
	       }
	public void setmob(String mob){
			this.mob = mob;
	 }


	public String getPassword() {
				return password;
	}
	      
	public void setPassword(String password){
	this.password=password;
	 }


	 public void setsec(String sec){
		this.sec = sec;
	 }
	 public String getsec(){
		return sec;
	 }

}