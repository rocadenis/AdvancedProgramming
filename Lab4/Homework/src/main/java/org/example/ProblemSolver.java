package org.example;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

/**
 * A class to solve a problem of matching drivers with passengers based on destinations using a greedy algorithm.
 */
public class ProblemSolver {
    private final List<Person> drivers;
    private final List<Person> passengers;

    /**
     * Constructs a ProblemSolver object with given lists of drivers, passengers, and destinations.
     *
     * @param drivers      List of drivers.
     * @param passengers   List of passengers.
     * @param destinations List of destinations.
     */
    public ProblemSolver(List<Person> drivers, List<Person> passengers, List<Destination> destinations) {
        this.drivers = drivers;
        this.passengers = passengers;
    }

    /**
     * Computes the destinations of all drivers based on the destinations they can travel to.
     *
     * @return List of unique destinations of all drivers.
     */
    private List<String> computeDestinationsOfDrivers() {
        Set<String> destinationSet = new HashSet<>();
        for (Person driver : drivers) {
            destinationSet.addAll(driver.getDestinations());
        }
        return new ArrayList<>(destinationSet);
    }

    /**
     * Computes a map of destinations to the list of passengers going to each destination.
     *
     * @return Map where keys are destinations and values are lists of passengers traveling to each destination.
     */
    private Map<String, List<Person>> computeDestinationMap() {
        Map<String, List<Person>> destinationMap = new HashMap<>();
        for (Person passenger : passengers) {
            for (String destination : passenger.getDestinations()) {
                destinationMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(passenger);
            }
        }
        return destinationMap;
    }

    /**
     * Solves the problem of matching drivers with passengers using a greedy algorithm.
     * Randomly assigns passengers to drivers for each destination.
     *
     * @return Map where keys are destinations and values are lists of passengers assigned to each destination's driver.
     */
    public Map<String, List<Person>> solveGreedy() {
        List<String> destinations = computeDestinationsOfDrivers();
        Map<String, List<Person>> destinationMap = computeDestinationMap();
        Map<String, List<Person>> result = new HashMap<>();

        for (String destination : destinations) {
            List<Person> passengersForDestination = destinationMap.getOrDefault(destination, new ArrayList<>());
            Collections.shuffle(passengersForDestination);
            int passengersNeeded = drivers.size(); // Each driver can take one passenger
            List<Person> passengersAssigned = passengersForDestination.subList(0, Math.min(passengersNeeded, passengersForDestination.size()));
            result.put(destination, passengersAssigned);
        }

        return result;
    }

    /**
     * Generates a random name for a destination.
     *
     * @return Randomly generated destination name.
     */
    private String generateRandomDestinationName() {
        return RandomStringUtils.randomAlphabetic(8);
    }
}
