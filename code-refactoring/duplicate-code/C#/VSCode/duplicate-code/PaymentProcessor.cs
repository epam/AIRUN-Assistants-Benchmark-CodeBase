public class PaymentProcessor
{

    public Payment ProcessPayment(bool isOnline)
    {
        Payment payment = new Payment();
        payment.PaymentDate = DateTime.Now;
        payment.PaymentStatus = "active";
        payment.PaymentType = "credit";

        if (isOnline)
        {
            payment.PaymentBank = "ICICI";
            payment.PaymentMode = "online";
        }
        else
        {
            payment.PaymentBank = "HDFC";
            payment.PaymentMode = "offline";
        }
        return payment;
    }

}



