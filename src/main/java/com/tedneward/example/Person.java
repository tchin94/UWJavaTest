/* Theodore Chin
INFO 498 Homework 1
*/

package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person>{
  private static int count;
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  
  public static class AgeComparator implements Comparator<Person> {
    
    public int compare(Person a, Person b) {
      return a.age - b.age;
    }
  }

  public int compareTo(Person other) {
    return (int)(other.salary - this.salary);
  }

  public Person() {
    this("", 0, 0.0d);
    count++;
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
    ssn = "";
    count++;
  }

  public int getAge() {
    return age;
  }
  
  public void setAge(int a) throws IllegalArgumentException {
    if (a < 0) {
      throw new IllegalArgumentException();
    }

    age = a;
  }

  public String getName() {
    return name;
  }

  public void setName(String n) throws IllegalArgumentException {
    if (n == null) {
      throw new IllegalArgumentException();
    }
    name = n;
  }
  
  public double getSalary() {
    return salary;
  }

  public void setSalary(double s) {
    salary = s;
  }
  
  public String getSSN() {
    return ssn;
  }

  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }

  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }

  public int count() {
    return count;
  }
  
  @Override
  public boolean equals(Object other) {
    if (other instanceof Person) {
      Person p = (Person)other;
      return (this.name.equals(p.name) && this.age == p.age);
    }
    return false;
  }

  public static ArrayList<Person> getNewardFamily() {
    ArrayList<Person> family = new ArrayList<Person>();
    Person p1 = new Person("Ted", 41, 250000);
    Person p2 = new Person("Charlotte", 43, 150000);
    Person p3 = new Person("Michael", 22, 10000);
    Person p4 = new Person("Matthew", 15, 0);
    family.add(p1);
    family.add(p2);
    family.add(p3);
    family.add(p4);
    return family;
  }

  @Override
  public String toString() {
    String string = "[Person name:" + name + " age:" + age + " salary:" + salary + "]";
    return string;
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }
}
