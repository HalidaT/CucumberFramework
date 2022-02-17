package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TradeAppTradesPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class TradeAppTrades {
	
	TradeAppTradesPage tradePage = new TradeAppTradesPage();
	BrowserUtils utils = new BrowserUtils();
	String stockSymbol;
	String stockEntryPrice;
	
	 @Given ("I am on the Trade App log in page")
	 public void I_am_on_the_trade_app_log_in_page() {
		 Driver.getDriver().get(PropertiesReader.getProperty("TradeAppUrl"));
		 Assert.assertTrue(tradePage.pleaseSignInText.isDisplayed());
		 }
	 @When("I enter username {String} password {String}")
	 public void I_enter_username_password(String username, String password) {
		tradePage.username.sendKeys(username);
		tradePage.password.sendKeys(password);
	 }
	 @When ("I click on Trade login button")
	 public void I_click_on_Trade_login_button() {
		tradePage.signInBtn.click();
	 }
	 @Then ("I should be on Trade homepage")
	 public void i_should_be_on_trade_homepage() {
		Assert.assertTrue(tradePage.tradeIconImage.isDisplayed());
		Assert.assertTrue(tradePage.addTradeBtn.isDisplayed());
	 }
	 @When ("I click on Add Trade button")
	 public void i_click_on_add_trade_button() {
		 tradePage.addTradeBtn.click();
	 }
	    
	 @Then ("I should be on Save Trade page")
	 public void i_should_be_on_save_trade_page() {
		 Assert.assertTrue(tradePage.saveTradeText.isDisplayed());
	 }
	 @When ("I select {String} and I enter symbol {String} entryDate {String} entryPrice {String} exitDate {String} exitPrice{String}")
	 public void I_select_and_I_enter_symble_entry_Date_entry_Price_exit_Date_exit_Price__buy_Or_sell_symbol_entry_Date_entry_Price_exit_Date_exit_Date_exit_price(String buyOrsell, String symbol, String entryDate, String entryPrice, String exitDate, String exitPrice) {
		 stockSymbol = symbol;
		 stockEntryPrice = entryPrice;
		 utils.selectByVisibleText(tradePage.buyOrSellDropdown, buyOrsell);
		 
		 tradePage.stockSymbol.sendKeys(symbol);
		 tradePage.stockSymbol.sendKeys(entryDate);
		 tradePage.stockSymbol.sendKeys(entryPrice);
		 tradePage.stockSymbol.sendKeys(exitDate);
		 tradePage.stockSymbol.sendKeys(exitPrice);
	 }
	@When("I click Save button")
	public void i_click_save_button() {
		tradePage.saveBtn.click();
	}
	@Then("The trade is displayed on the trade table")
	public void the_trade_is_displayed_on_the_trade_table() {
	    Assert.assertTrue(tradePage.addTradeBtn.isDisplayed());
	    
	    for (WebElement singleSymbol : tradePage.stockSymbols) {
	    	if (singleSymbol.equals(stockSymbol)) {
	    		Assert.assertEquals(singleSymbol.getText(), stockSymbol);
	    			
	    		}
	    	}
 	 
	}
	    
		
	}
	    


