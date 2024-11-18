public class MessageProcessor {

    public void HandleMessageError(Message message) {
       string errorCode = message.ErrorCode;
       if (errorCode.Equals("100")) {
           throw new MessageException("Exception with code 100 occurred while processing the message");
       }
       if (errorCode.Equals("200")) {
           throw new MessageException("Exception with code 200 occurred while processing the message");
       }
       if (errorCode.Equals("300")) {
           throw new MessageException("Exception with code 300 occurred while processing the message");
       }
    }
}
