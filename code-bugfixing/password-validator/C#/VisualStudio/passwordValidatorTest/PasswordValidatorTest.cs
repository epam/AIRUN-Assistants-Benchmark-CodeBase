using NUnit.Framework;


namespace Tests
{
    [TestFixture]
    public class PasswordValidatorTest
    {
        [Test]
        public void TestValidPasswords()
        {
            Assert.IsTrue(PasswordValidator.IsValidPassword("Password1!"));
            Assert.IsTrue(PasswordValidator.IsValidPassword("StrongPass123$"));
            Assert.IsTrue(PasswordValidator.IsValidPassword("Good#Pass1"));
            Assert.IsTrue(PasswordValidator.IsValidPassword("Valid1@Pass"));
        }

        [Test]
        public void TestInvalidPasswords()
        {
            Assert.IsFalse(PasswordValidator.IsValidPassword("Pass1!"));
            Assert.IsFalse(PasswordValidator.IsValidPassword("password1!"));
            Assert.IsFalse(PasswordValidator.IsValidPassword("PASSWORD1!"));
            Assert.IsFalse(PasswordValidator.IsValidPassword("Password!"));
            Assert.IsFalse(PasswordValidator.IsValidPassword("Password1"));
            Assert.IsFalse(PasswordValidator.IsValidPassword("Password 1!"));
            Assert.IsFalse(PasswordValidator.IsValidPassword(null));
        }
    }
}