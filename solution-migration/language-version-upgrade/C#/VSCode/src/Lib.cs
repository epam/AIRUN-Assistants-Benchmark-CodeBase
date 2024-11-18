using System.Linq;

namespace src
{
    public class Lib
    {
        // C# 1.0 method for greeting users
        public string Greet(string name)
        {
            if (name == null)
            {
                return "Hello!";
            }
            else
            {
                return "Hello, " + name + "!";
            }
        }
    }
}