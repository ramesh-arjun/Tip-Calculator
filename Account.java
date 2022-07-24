    package com.tip.calc.data;

import java.sql.Timestamp;

public class Account {
	
	private Integer id;

    private String name;

    private String tipAmount;
    
    private String mealAmount;
    
    private String tipTime;

	public String getTipTime() {
		return tipTime;
	}

	public void setTipTime(String tipTime) {
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
    
