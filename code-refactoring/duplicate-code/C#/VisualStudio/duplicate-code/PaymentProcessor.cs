public class PaymentProcessor
{
    public Payment ProcessPayment(bool isOnline)
    {
        Payment payment = new Payment();
        if (isOnline)
        {
            payment.PaymentDate = DateTime.Now;
            payment.PaymentStatus = "active";
            payment.PaymentType = "credit";

            payment.PaymentBank = "ICICI";
            payment.PaymentMode = "online";
        }
        else
        {
            payment.PaymentDate = DateTime.Now;
            payment.PaymentStatus = "active";
            payment.PaymentType = "credit";

            payment.PaymentBank = "HDFC";
            payment.PaymentMode = "offline";
        }
        return payment;
    }

}



