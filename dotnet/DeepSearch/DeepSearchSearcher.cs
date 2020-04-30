using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Linq;

namespace DeepSearch
{
    public class DeepSearchSearcher
    {
        public int SumSearch(string jsonString) {
            return JObject.Parse(jsonString)
                .Descendants()
                .Where(x => x is JObject)
                .Where(x => x["should_process"] != null)
                .Where(x => (bool)x["should_process"])
                .Select(x => (int)x["value"])
                .Sum(); 
        }
    }
}
