package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class ATM extends Model {
	private int money;

	public ATM(int money) {
		this.money = money;
	}

	public int requestMoney(CreditCard creditCard, int amount) {
		if (!creditCard.valid || amount > money) {
			return 0;
		}
		amount = creditCard.account.getMoney(amount);
		money = money - amount;
		return amount;
	}
}
