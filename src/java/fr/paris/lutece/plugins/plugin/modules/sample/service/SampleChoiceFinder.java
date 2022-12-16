package fr.paris.lutece.plugins.plugin.modules.sample.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SampleChoiceFinder {
    // Creates a list of the top number of choices based on desired amount
    public static List<String> desiredChoices(Map<String, Integer> map, int num) {
        List<String> choices = new ArrayList<>();
        
        // Adds every key to the string list
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                choices.add(entry.getKey());
        }

        // Gets the subList from the first index to the desired index number
        List<String> topChoice = new ArrayList<>(choices.subList(0, num));
        return topChoice;
    }
}
