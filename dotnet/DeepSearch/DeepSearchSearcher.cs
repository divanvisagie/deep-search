using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Linq;

namespace DeepSearch
{
    public class DeepSearchSearcher
    {
        public int SumSearch(string jsonString) {

            var dec = JObject.Parse(jsonString)
                .Descendants() //flattened list of descendants
                .Where(x => x is JObject) //x is an object
                .Where(x => x["should_process"] != null) //x is an object containing a should_process that is not null
                .Where(x => (bool)x["should_process"]) // where the bool is true
                .Select(x => (int)x["value"]) //get the value of the object and make it an int
                .Sum(); 
            
            return dec;
        }
    }
}
