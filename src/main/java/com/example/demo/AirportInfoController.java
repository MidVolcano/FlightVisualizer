package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Controller
public class AirportInfoController {

    private Map<String, double[]> airportCoordinates;

    public AirportInfoController() {
        airportCoordinates = new HashMap<>();
        try {
            // Load CSV file from resources folder
            File file = new File("src/main/resources/airports.csv");
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) scanner.nextLine(); // skip header

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().replace("\"", "");
                String[] parts = line.split(",", -1);
                if (parts.length < 4) continue;

                String code = parts[0].trim().toUpperCase();
                double lat = Double.parseDouble(parts[2].trim());
                double lon = Double.parseDouble(parts[3].trim());

                airportCoordinates.put(code, new double[]{lat, lon});
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Failed to load airports.csv: " );
        }
    }

    @RequestMapping("/airport")
    @ResponseBody
    public String getAirport(String code) {
        if (code == null) return "{\"error\":\"No code provided\"}";

        code = code.toUpperCase();
        if (!airportCoordinates.containsKey(code)) {
            return "{\"error\":\"Airport code not found: " + code + "\"}";
        }

        double[] coords = airportCoordinates.get(code);
        return "{\"code\":\"" + code + "\",\"latitude\":" + coords[0] + ",\"longitude\":" + coords[1] + "}";
    }
}
