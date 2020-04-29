/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package deepsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


public class DeepSearchSearcher {
    public boolean someLibraryMethod() {
        return true;
    }

    private List<Map.Entry<Object, Object>> flattenMap(final Map<Object, Object> original) {
        final var carryOver = new ArrayList<Map.Entry<Object, Object>>();
        for (final Map.Entry<Object, Object> item : original.entrySet()) {

            if (Map.class.isInstance(item.getValue())) { // if the value is another object
                Map<Object, Object> child = (Map<Object, Object>) item.getValue();
                
                if (child.keySet().contains("should_process")) {
                    if ((boolean)child.get("should_process"))
                        carryOver.add(item);
                } else {
                    final List<Map.Entry<Object, Object>> m = flattenMap(child);
                    carryOver.addAll(m);
                }
                
                
            }

        }
        return carryOver;
    }

    private int getEntryValue(Map.Entry<Object,Object> entry) {
        return (int)((Map<Object,Object>)entry.getValue()).get("value");
    }

    public int sumOf(final String jsonString) {
        final ObjectMapper om = new ObjectMapper();

        try {
            final List<Map.Entry<Object, Object>> f = flattenMap(om.readValue(jsonString, Map.class));
            int i = f.stream()
            .map(x -> getEntryValue(x))
            .reduce(0, Integer::sum);

            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } 
		return 0;
	}
}
