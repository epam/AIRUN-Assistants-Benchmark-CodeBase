public class AccountService
{
    public Account HandeResponse(AccountResponse accountResponse)
    {
        if (accountResponse.Id == null)
        {
            throw new ArgumentException("Id is required");
        }
        if (accountResponse.Name == null)
        {
            throw new ArgumentException("Name is required");
        }
        if (accountResponse.Email == null)
        {
            throw new ArgumentException("Email is required");
        }
        if (accountResponse.Phone == null)
        {
            throw new ArgumentException("Phone is required");
        }

        Account account = new Account();
        account.Id = accountResponse.Id;
        account.Name = accountResponse.Name;
        account.Email = accountResponse.Email;
        account.Phone = accountResponse.Phone;

        return account;
    }
}

