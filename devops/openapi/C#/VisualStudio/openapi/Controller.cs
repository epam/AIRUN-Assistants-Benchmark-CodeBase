using Microsoft.AspNetCore.Mvc;

namespace openapi
{
    [ApiController]
    [Route("api")]
    public class Controller : ControllerBase
    {
        [HttpGet("users")]
        public List<User> GetListOfUsers()
        {
            return new List<User>
            {
                new User
                {
                    Name = "John Doe",
                    Email = "some-firstE@email.www",
                    Password = "some-password",
                    Address = "some-address",
                    Phone = "some-phone"
                },
                new User
                {
                    Name = "Jane Doe",
                    Email = "some-secondE@email.www",
                    Password = "some-password2",
                    Address = "some-address2",
                    Phone = "some-phone2"
                },
                new User
                {
                    Name = "Jane Doe",
                    Email = "some-thirdE@email.www",
                    Password = "some-password3",
                    Address = "some-address3",
                    Phone = "some-phone3"
                }
            };
        }
    }
}
