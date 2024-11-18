using Microsoft.AspNetCore.Mvc;
using Swashbuckle.AspNetCore.Annotations;


[ApiController]
[Route("api/[controller]")]
public class UsersController : ControllerBase
{
    private readonly IUserService _userService;

    [HttpPost]
    public User CreateUser([FromBody] User user)
    {
        return _userService.CreateUser(user);
    }

    [HttpGet("{id}")]
    public User GetUser(long id)
    {
        return _userService.GetUser(id);
    }

    [HttpGet]
    public List<User> GetAllUsers()
    {
        return _userService.GetAllUsers();
    }

    [HttpPut("{id}")]
    public User UpdateUser(long id, [FromBody] User user)
    {
        return _userService.UpdateUser(id, user);
    }

    [HttpDelete("{id}")]
    public void DeleteUser(long id)
    {
        _userService.DeleteUser(id);
    }

}

