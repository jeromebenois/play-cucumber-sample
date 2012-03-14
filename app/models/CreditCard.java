package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class CreditCard extends Model {

	public boolean valid = true;
	public boolean inUse = false;
	
	public final Account account;

	public CreditCard(Account account) {
		this.account = account;
	}

	public void insertCard(){
		inUse = true;
	}
	
	public void returnCard(){
		inUse = false;
	}

}