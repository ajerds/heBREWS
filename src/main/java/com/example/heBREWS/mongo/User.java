package com.example.heBREWS.mongo;

import com.example.heBREWS.drinks.Drink;
import java.util.ArrayList;

import com.example.heBREWS.exceptions.OrderNotFoundException;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "users")
public class User {

  private String firstName, lastName, email;
  private String passWord;
  private ArrayList<Drink> quickOrder;
  private String phoneNumber;

  @Id
     private String id;

  // constructor
  public User( String firstName, String lastName, String email, String passWord, String phoneNumber){
    setEmail(email);
    setFirstName(firstName);
    setLastName(lastName);
    setPassWord( passWord );
    setPhoneNumber( phoneNumber );
    quickOrder = new ArrayList<>();
  }

  public User( String firstName, String lastName, String email, String phoneNumber){
    setEmail(email);
    setFirstName(firstName);
    setLastName(lastName);
    setPhoneNumber( phoneNumber );
    quickOrder = new ArrayList<>();
  }


  // getters and setters
  public String getEmail () {
    return email;
  }
  public void setEmail( String email ) {
    this.email = email;
  }

  public String getFirstName () {
    return firstName;
  }
  public void setFirstName( String firstName ) {
    this.firstName = firstName;
  }

  public String getLastName () {
    return lastName;
  }
  public void setLastName( String lastName ) {
    this.lastName = lastName;
  }

  public String getPassWord () {
    return passWord;
  }
  public void setPassWord( String passWord ) {
    this.passWord = passWord;
  }
  
  public String getPhoneNumber () {
    return phoneNumber;
  }
  public void setPhoneNumber ( String phoneNumber ) {
    this.phoneNumber = phoneNumber;
  }

  public ArrayList<Drink> getQuickOrder() {
    return quickOrder;
  }
  public void resetQuickOrder() { quickOrder.clear(); }
  public void resetQuickOrder( ArrayList<Drink> drinks ) {
    quickOrder.clear();
    for( Drink d : drinks ){
      quickOrder.add( d );
    }
  }
  public void addQuickOrder( Drink drink ) {
    quickOrder.add( drink );
  }
  public void addMoreQuickOrder( Drink drink, int quantity ) {
    quickOrder.get( quickOrder.indexOf(drink) ).addQuantity( quantity );
  }
  public void removeFromQuickOrder( Drink drink, int quantity ){

    quickOrder.get( quickOrder.indexOf( drink )).subtractQuantity( quantity );
    if (   quickOrder.get( quickOrder.indexOf( drink )).getQuantity() <= 0) {
      quickOrder.remove( drink );
    }

  }
  public void removeAllFromQuickOrder( Drink drink, int quantity ) {
    quickOrder.remove( drink );
  }
  @Override
    public String toString() {
        return String.format(
                "User[id=%s, firstName='%s', lastName='%s', email='%s']",
                id, firstName, lastName, email);
    }
}
