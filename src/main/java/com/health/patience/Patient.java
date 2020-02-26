package com.health.patience;

//id integer NOT NULL,
//        first_name character varying(50) NOT NULL,
//        last_name character varying(50) NOT NULL,
//        age integer,
//        gender character varying,
//        date_added timestamp without time zone
//
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;


public class Patient{

    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;

    private String hrMin;
    private String hrMax;
    private String bpMin;
    private String bpMax;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHrMin() {
        return hrMin;
    }

    public void setHrMin(String hrMin) {
        this.hrMin = hrMin;
    }

    public String getHrMax() {
        return hrMax;
    }

    public void setHrMax(String hrMax) {
        this.hrMax = hrMax;
    }

    public String getBpMin() {
        return bpMin;
    }

    public void setBpMin(String bpMin) {
        this.bpMin = bpMin;
    }

    public String getBpMax() {
        return bpMax;
    }

    public void setBpMax(String bpMax) {
        this.bpMax = bpMax;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", hrMin='" + hrMin + '\'' +
                ", hrMax='" + hrMax + '\'' +
                ", bpMin='" + bpMin + '\'' +
                ", bpMax='" + bpMax + '\'' +
                '}';
    }
}



