package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.epam.engx.cleancode.functions.task1.thirdpartyjar.CheckStatus.OK;

public class RegisterAccountAction {


    private PasswordChecker passwordChecker;
    private AccountManager accountManager; 
    
    public void register(Account account)
    {
        validateAccountName(account);
        validatePassword(account);
        account.setCreatedDate(new Date());
        account.setAddresses(getValues(account));
        accountManager.createNewAccount(account);
    }
    
    void validateAccountName(Account account)
    {
    	if (account.getName().length() <= 5){
            throw new WrongAccountNameException();
        }
    }
    
    void validatePassword(Account account)
    {
    	 String password = account.getPassword();
         if (password.length() <= 8) {
             if (passwordChecker.validate(password) != OK) {
                 throw new WrongPasswordException();
             }
         }
    }
    
    
    
    List<Address> getValues(Account account)
    {
    	 List<Address> addresses = new ArrayList<Address>();
    	 addresses.add(account.getHomeAddress());
    	 addresses.add(account.getWorkAddress());
    	 addresses.add(account.getAdditionalAddress());
    	return addresses;
    }
    
    
    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setPasswordChecker(PasswordChecker passwordChecker) {

        this.passwordChecker = passwordChecker;
    }

}
