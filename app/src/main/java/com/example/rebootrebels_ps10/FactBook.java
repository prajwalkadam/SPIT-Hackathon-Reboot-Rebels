package com.example.rebootrebels_ps10;
import java.util.Random;
public class FactBook {
    public String[] mFacts = {"If people worldwide switched to energy efficient light bulbs the world would save 105 billion euros annually.",
            "Water use has grown at more than twice the rate of population increase in the last century.",
            "Recycling one ton of paper saves 2584l of oil, 26498l of water and 2.5 cubic meters of landfill space.",
            "Recycling one ton of paper saves 17 trees.",
            "Energy sector causes majority of greenhouse gas emissions, leading contributor to climate change",
            "Around 640 pounds of trash is produced by college students each year.",
            "Using public transport, walking, or biking reduces fuel expenses, emissions, and enhances car longevity while being environmentally safer.",
            "Daily activities consume gallons of water, often unnoticed, e.g. 2-min tap use = 3.5 gallons, long shower = 25 gallons.",
            "One hot water faucet leak at 1 drop/sec = 165 gallons/month, exceeding 2 week usage of an individual.",
            "Double-sided 10-page letter saves paper and costs less for mailing: $0.55 reduced to $0.34.",
            "It takes a 15-year-old tree to produce 700 grocery bags.",
            "Plastic bags, Styrofoam containers take thousands of years to decompose, harm marine life, soil, and water.",
            "Leaving computer monitors on overnight releases 9 million tons of CO2 annually.",
            "Sustainability crucial to conserve finite resources, prevent extinction, protect atmosphere.",
            "Cycling 10 km to work saves $1,700 and reduces 1,500 kg of GHG emissions annually.",
            "Recycling one aluminium can saves enough energy to run a TV for three hours",
            "The world's largest solar farm generates enough energy to power 160,000 homes.",
            "More than 90% of all trash in the ocean is plastic.",
            "The energy saved from recycling one glass bottle can run a 100-watt light bulb for four hours.",
            "Paper bags decompose in 6 weeks, plastic bags take 10-1,000 years..",
            "Earth's temperature rose 1°C due to human activities since 19th century."};

    public String getFact() {


        String fact = "";
        Random rm = new Random();
        int rn = rm.nextInt(mFacts.length);
        fact = mFacts[rn];
        return fact;


    }
}
