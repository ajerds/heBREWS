package com.example.heBREWS.mongo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "users")
public class User {

  private String firstName, lastName, email;

  @Id
     private String id;

  // constructor
  public User( String firstName, String lastName, String email){
    setEmail(firstName);
    setFirstName(firstName);
    setLastName(lastName);

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

  @Override
    public String toString() {
        return String.format(
                "User[id=%s, firstName='%s', lastName='%s', email='%s']",
                id, firstName, lastName, email);
    }
}
