package deepsearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeepSearchSearcher<T> {

    final ObjectMapper om = new ObjectMapper();

    public int sumOf(final String jsonString) throws JsonMappingException, JsonProcessingException {
        return om.readTree(jsonString)
            .findParents("should_process")
            .stream()
            .filter((JsonNode x) -> x.get("should_process").asBoolean())
            .map((JsonNode x) -> x.get("value").asInt())
            .reduce(0, (acc, x) -> acc + x);
	}
}
