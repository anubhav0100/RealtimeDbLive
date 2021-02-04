package com.edevelopers.realdbtime.Model;

public class RegisterLoginModel {

     String result = "";
     String ApiKey= "";
     String Api_Secret= "";
     String username= "";
     String Password= "";
     String email= "";
     String phonenumber= "";
     String first_name= "";
     String middle_name= "";
     String last_name= "";
     String address= "";
     String country= "";

     public RegisterLoginModel (){

     }

    public String getPassword() {
        return Password;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getApi_Secret() {
        return Api_Secret;
    }

    public String getApiKey() {
        return ApiKey;
    }

    public String getCountry() {
        return country;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setApi_Secret(String api_Secret) {
        Api_Secret = api_Secret;
    }

    public void setApiKey(String apiKey) {
        ApiKey = apiKey;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
