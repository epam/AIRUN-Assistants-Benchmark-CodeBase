using System.Security.Cryptography;

namespace keystore
{
    
    public class Keystore
    {

        private const string PublicKeyFileName = "publicKey.xml";
        private const string PrivateKeyFileName = "privateKey.xml";

        
        public void CreateKeyStore()
        {   
            
            using var rsaServiceProvider = new RSACryptoServiceProvider();
            try
            {
                
                var rsaParameters = rsaServiceProvider.ExportParameters(true);

                
                var publicKey = rsaServiceProvider.ToXmlString(false);
                
                var privateKey = rsaServiceProvider.ToXmlString(true);

                WriteToXmlFile(PublicKeyFileName, publicKey);
                WriteToXmlFile(PrivateKeyFileName, privateKey);
            }
            
            catch (CryptographicException exception)
            {
                Console.WriteLine($"An error occurred while creating the keystore: {exception.Message}");
            }
        }

        
        private static void WriteToXmlFile(string fileName, string data)
        {
            File.WriteAllText(fileName, data);
        }
    }
}