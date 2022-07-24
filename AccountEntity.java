    package com.tip.calc.data;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "Accounts")
@Table(name = "accounts")
public class AccountEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String tipAmount;
    
    private String mealAmount;
    
    private Timestamp tipTime;
    // Getters and setters

	public Timestamp getTipTime() {
		return tipTime;
	}

	public void setTipTime(Timestamp tipTime) {
		this.tipTime = tipTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getTipAmount() {
		return tipAmount;
	}

	public void setTipAmount(String tipAmount) {
		this.tipAmount = tipAmount;
	}

	public String getMealAmount() {
		return mealAmount;
	}

	public void setMealAmount(String mealAmount) {
		this.mealAmount = mealAmount;
	}

}
