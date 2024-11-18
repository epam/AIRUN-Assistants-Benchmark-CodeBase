using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tests
{
    [TestFixture()]
    public class CsvEtlCommandTests
    {
        [Test()]
        public void ExecuteTest()
        {
            string testFolder = $@"{TestContext.CurrentContext.TestDirectory}\TestLocations\";
            string inputData = "col1,col2\r\n1,2\r\n3,4\r\n";
            string expected = "col2,col1\r\n2,1\r\n4,3\r\n";
            string inputFile = $"{testFolder}Test.csv";
            File.WriteAllText(inputFile, inputData);
            var outputFile = File.Create($"{testFolder}target.csv");
            outputFile.Close();

            var command = new CsvEtlCommand(new string(File.ReadAllText(inputFile)), outputFile.ToString());

            command.Execute();

            var outputData = File.ReadAllText(outputFile.Name);
            Assert.AreEqual(expected, outputData);

            File.Delete(inputFile);
            File.Delete(outputFile.Name);

        }
    }
}