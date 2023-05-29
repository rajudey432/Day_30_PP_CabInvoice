package com.bridgelabz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class State {
    private String code;
    private String name;

    public State(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "State{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

class CSVStates {
    private static final String CSV_FILE_PATH = "states.csv";

    public List<State> loadStates() throws IOException {
        List<State> states = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String code = data[0].trim();
                    String name = data[1].trim();
                    State state = new State(code, name);
                    states.add(state);
                }
            }
        }

        return states;
    }
}

class StateCensusAnalyser {
    private static final String CSV_FILE_PATH = "census_data.csv";

    public int getRecordCount() throws IOException {
        int recordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            while (reader.readLine() != null) {
                recordCount++;
            }
        }

        return recordCount;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            CSVStates csvStates = new CSVStates();
            List<State> states = csvStates.loadStates();

            System.out.println("Loaded states:");
            for (State state : states) {
                System.out.println(state);
            }

            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int recordCount = censusAnalyser.getRecordCount();

            System.out.println("Number of records in census data: " + recordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

