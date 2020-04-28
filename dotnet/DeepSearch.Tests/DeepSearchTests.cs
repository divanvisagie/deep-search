using NUnit.Framework;
using System.IO;
using System;

namespace DeepSearch.Tests
{
    public class DeepSearchTests
    {
        private DeepSearchSearcher _deepSearchSearcher;

        private string jsonPayload = File.ReadAllText("test_file_0.json");

        [SetUp]
        public void Setup()
        {
            Console.WriteLine(jsonPayload);
            _deepSearchSearcher = new DeepSearchSearcher();
        }

        [Test]
        public void TestFileLoaded()
        {
            Assert.IsNotEmpty(jsonPayload);
        }

        [Test]
        public void GivenTestFile_ShouldReturn_4() 
        {
            var actual = _deepSearchSearcher.SumSearch(jsonPayload);
            Assert.AreEqual(4, actual);
        }
    }
}