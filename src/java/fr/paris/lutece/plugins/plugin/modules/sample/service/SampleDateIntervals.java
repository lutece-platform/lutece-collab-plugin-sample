package fr.paris.lutece.plugins.plugin.modules.sample.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SampleDateIntervals {
    // Creates Time Stamps on 15 minute intervals from the given range of dates and times
    public static List<String> intervalChoices(String rangeOfDates) {
        // Range of dates format: MM/DD-MM/DD HH:MM-HH:MM in 24 hour format
        List<String> datesAndTimes = new ArrayList<>();
        String curr;

        // Initializing dates based on the inputted date format
        int startMonth = Integer.valueOf(rangeOfDates.substring(0,rangeOfDates.indexOf("/")));
        int startDay = Integer.valueOf(rangeOfDates.substring(rangeOfDates.indexOf("/") + 1,rangeOfDates.indexOf("-")));
        int finMonth = Integer.valueOf(rangeOfDates.substring(rangeOfDates.indexOf("-") + 1,rangeOfDates.lastIndexOf("/")));
        int finDay = Integer.valueOf(rangeOfDates.substring(rangeOfDates.lastIndexOf("/") + 1,rangeOfDates.indexOf(" ")));
        int startHour = Integer.valueOf(rangeOfDates.substring(rangeOfDates.indexOf(" ") + 1,rangeOfDates.indexOf(":")));
        int startMin = Integer.valueOf(rangeOfDates.substring(rangeOfDates.indexOf(":") + 1,rangeOfDates.lastIndexOf("-")));
        int finHour = Integer.valueOf(rangeOfDates.substring(rangeOfDates.lastIndexOf("-") + 1,rangeOfDates.lastIndexOf(":")));
        int finMin = Integer.valueOf(rangeOfDates.substring(rangeOfDates.lastIndexOf(":") + 1,rangeOfDates.length()));

        int currMonth = startMonth;
        int currDay = startDay;
        int currMin = startMin;
        int currHour = startHour;

        // Loops and adds every date that fits our criteria into a string list
        while (currMonth < finMonth || currDay <= finDay) {
            currMin = startMin;
            currHour = startHour;

            while (currHour < finHour || currMin < finMin) {
                curr = currMonth + "/" + currDay + " " + currHour + ":" + currMin;
                datesAndTimes.add(curr);
                currMin += 15;

                // Hour increment once minutes hit 60
                if (currMin == 60) {
                    currHour += 1;
                    currMin = 0;
                }
            }
            currDay += 1;

            // Month increment due to days overcoming barrier for the month
            if (currDay == 29 && currMonth == 2) {
                currMonth += 1;
                currDay = 1;
            } else if (currDay == 31 && (currMonth == 4 || currMonth == 6 || currMonth == 9 || currMonth == 11)) {
                currMonth += 1;
                currDay = 1;
            } else if (currDay == 32) {
                currMonth += 1;
                currDay = 1;
            }
        }
        

        return datesAndTimes;
    }
}
