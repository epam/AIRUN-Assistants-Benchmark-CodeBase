namespace src
{
    public class ReferralProgram
    {
        private readonly IReferralService _referralService;
        private readonly decimal _bonusPercentage;

        public ReferralProgram(IReferralService referralService, decimal bonusPercentage)
        {
            _referralService = referralService;
            _bonusPercentage = bonusPercentage;
        }

        public decimal CalculateReferralBonus(string referralCode, decimal purchaseAmount)
        {
            if (!_referralService.IsValidReferralCode(referralCode))
            {
                throw new InvalidReferralCodeException("Invalid referral code.");
            }

            var referralBonus = purchaseAmount * _bonusPercentage / 100;
            return referralBonus;
        }
    }

    public interface IReferralService
    {
        bool IsValidReferralCode(string referralCode);
    }

    public class InvalidReferralCodeException : Exception
    {
        public InvalidReferralCodeException(string message) : base(message)
        {
        }
    }
}