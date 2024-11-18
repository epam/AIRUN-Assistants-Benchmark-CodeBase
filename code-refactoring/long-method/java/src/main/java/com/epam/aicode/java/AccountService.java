package com.epam.aicode.java;

public class AccountService {

   public Account handleResponse(AccountResponse accountResponse) {
       if (accountResponse.getId() == null) {
           throw new IllegalArgumentException("Id is required");
       }
       if (accountResponse.getName() == null) {
           throw new IllegalArgumentException("Name is required");
       }
       if (accountResponse.getEmail() == null) {
           throw new IllegalArgumentException("Email is required");
       }
       if (accountResponse.getPhone() == null) {
           throw new IllegalArgumentException("Phone is required");
       }

       Account account = new Account();
       account.setId(accountResponse.getId());
       account.setName(accountResponse.getName());
       account.setEmail(accountResponse.getEmail());
       account.setPhone(accountResponse.getPhone());

       return account;
   }
}
