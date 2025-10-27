package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class AirportInfoService {

    public HashMap<String, String> getDestinations(String filename) throws FileNotFoundException {
        File myFile = new File(filename);
        Scanner myReader = new Scanner(myFile);

        HashMap<String, String> destinations = new HashMap<String, String>();
        myReader.nextLine(); // skip header

        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String[] fullLine = line.split(",");
            String start = fullLine[2].trim();
            String end = fullLine[4].trim();

            if (destinations.containsKey(start)) {
                destinations.put(start, destinations.get(start) + " " + end);
            } else {
                destinations.put(start, end);
            }
        }
        myReader.close();
        return destinations;
    }

    public HashMap<String, Integer> getAirportCount(String filename) throws FileNotFoundException {
        HashMap<String, Integer> airportCount = new HashMap<>();
        List<String> totalAirports = new ArrayList<>();
        File myFile = new File(filename);
        Scanner myReader = new Scanner(myFile);
        myReader.nextLine();

        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String[] fullLine = line.split(",");
            String start = fullLine[2].trim();
            String end = fullLine[4].trim();

            totalAirports.add(start);
            totalAirports.add(end);
        }

        for (String airport : totalAirports) {
            airportCount.put(airport, airportCount.getOrDefault(airport, 0) + 1);
        }
        myReader.close();
        return airportCount;
    }

    public String getMax(HashMap<String, Integer> airportCount) {
        ArrayList<String> maxAirport = new ArrayList<String>();
        int maxCount = 0;

        for (String s : airportCount.keySet()) {
            int count = airportCount.get(s);
            if (count > maxCount) {
                maxCount = count;
                maxAirport.clear();
                maxAirport.add(s);
            } else if (count == maxCount) {
                maxAirport.add(s);
            }
        }

        Collections.sort(maxAirport);
        return "MAX FLIGHTS " + maxCount + " : " + String.join(" ", maxAirport);
    }

    public String getDepartures(HashMap<String, String> destinations) {
        ArrayList<String> sorted = new ArrayList<>(destinations.keySet());
        Collections.sort(sorted);
        StringBuilder result = new StringBuilder();

        for (String from : sorted) {
            result.append(from)
                  .append(" flies to ")
                  .append(destinations.get(from))
                  .append("\n");
        }
        return result.toString();
    }

    public String getLimits(int limit, HashMap<String, Integer> airportCount) {
        ArrayList<String> sortedKeys = new ArrayList<>(airportCount.keySet());
        Collections.sort(sortedKeys);
        StringBuilder result = new StringBuilder();

        for (String airport : sortedKeys) {
            int count = airportCount.get(airport);
            if (count > limit) {
                result.append(airport);
                result.append(" - ");
                result.append(count);
                result.append("\n");
            }
        }
        return result.toString();
    }

}
