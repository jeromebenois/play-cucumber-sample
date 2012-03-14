package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Account extends Model {
	public int balance;
	
	public Account(int balance) {	
		this.balance = balance;
	}

	public int getMoney(int amount) {
		if (balance < amount)
			return 0;

		balance = balance - amount;

		return amount;

	}
}