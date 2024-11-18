interface IUserService
{
    User CreateUser(User user);

    User GetUser(long id);

    List<User> GetAllUsers();

    User UpdateUser(long id, User user);

    void DeleteUser(long id);
}

