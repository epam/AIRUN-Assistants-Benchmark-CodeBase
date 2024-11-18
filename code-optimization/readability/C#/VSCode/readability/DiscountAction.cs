public class DiscountAction
{
    public Discount CalculateDiscount(double price, string userType, bool isHoliday)
    {
        double discountRate = 0;
        if (userType.Equals("STUDENT"))
        {
            discountRate = price * 0.1;
        }
        else if (userType.Equals("SENIOR"))
        {
            discountRate = price * 0.15;
        }
        else if (userType.Equals("EMPLOYEE"))
        {
            discountRate = price * 0.2;
        }
        if (isHoliday)
        {
            discountRate += price * 0.05;
        }

        Discount discount = new Discount();
        discount.Rate = discountRate;
        discount.UserType = userType;
        discount.IsHoliday = isHoliday;

        return discount;
    }

}
