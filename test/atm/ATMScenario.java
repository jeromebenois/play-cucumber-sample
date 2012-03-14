package atm;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import models.ATM;
import models.Account;
import models.CreditCard;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

/**
 * Define all Steps
 */
public class ATMScenario {

	private ATM atm;
	private Account account;
	private CreditCard creditCard;

	private int money;

	@Given("^the account balance is (\\d*)$")
	public void createAccount(int balance) {
		account = new Account(balance);
	}

	@And("^the card is valid$")
	public void createCreditCard() {
		creditCard = new CreditCard(account);
		//throw new RuntimeException();
		//This line contains a failure:
		//assertFalse("This test failed because true not equals false :)",true);
	}

	@And("^the machine contains (\\d*)$")
	public void createATM(int money) {
		atm = new ATM(money);
	}

	@When("^the Account Holder requests (\\d*)$")
	public void requestMoney(int amount) {
		money = atm.requestMoney(creditCard, amount);
	}

	@Then("^the ATM should dispense (\\d*)$")
	public void checkMoney(int amount) {
		assertThat(money, is(amount));
	}

	@And("^the account balance should be (\\d*)$")
	public void checkBalance(int newBalance) {
		assertThat(newBalance, is(creditCard.account.balance));
	}

	@And("^the card should be returned$")
	public void cardShouldBeReturned() {
		assertFalse(creditCard.inUse);
	}

}
