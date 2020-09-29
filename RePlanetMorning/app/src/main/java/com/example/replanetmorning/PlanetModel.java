package com.example.replanetmorning;

import java.util.ArrayList;

public class PlanetModel {

    public static class Planet {
        public String name;
        public double mass;
        public  double distance;

        public Planet(String name, double mass, double distance) {
            this.name = name;
            this.mass = mass;
            this.distance = distance;
        }
    }

    public ArrayList<Planet> myPlanets;

    private PlanetModel() {
        myPlanets = new ArrayList<Planet>();
        LoadModel();
    }

    private void LoadModel() {
        myPlanets.add(new Planet("Mercury", 3.0, 30));
        myPlanets.add(new Planet("Venus", 3.0, 30));
        myPlanets.add(new Planet("Earth", 3.0, 30));
        myPlanets.add(new Planet("Mars", 3.0, 30));
        myPlanets.add(new Planet("Jupiter", 3.0, 30));
        myPlanets.add(new Planet("Saturn", 3.0, 30));
        myPlanets.add(new Planet("Neptune", 3.0, 30));
        myPlanets.add(new Planet("Uranus", 3.0, 30));
    }

    //Make it a singleton
    private static PlanetModel singleton = null;
    public static  PlanetModel getModel() {
        if(singleton == null) {
            singleton = new PlanetModel();
        }
        return singleton;
    }
}
