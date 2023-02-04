package com.example.rebootrebels_ps10;
import java.util.Random;
public class FactBook {
    public String[] mFacts = {"India has a total of 29 states and 7 union territories", "The capital of India is New Delhi.", "A citizen of India, who is 18 years old or above, is entitled to vote.", "The Telephone Country Code of India is +91.", "National Fruit-Mango ", "National Flower-Lotus", "National Currency-Indian Rupee  ", "National Sport-Hockey", "National Bird-Peacock ","National Animal-Royal Bengal Tiger","National Anthem-Jana Gana Mana, written by Rabindranath Tagore ","Population Density-382 persons per square kilometer ","Official Name-Bharat (Sanskrit), Republic of India (English)","Population-1,210,569,573 (2011 Census) ","India is the largest and the oldest civilisation in the world","Mahatma Gandhi was assassinated on 30 January 1948.","Ayurveda, which is the earliest school of medicine in the world, was born in India thousands of years ago","The Indian National Congress was formed in the year 1885","India has got a long coastline of 7,516.6 km","India is the largest producer of banana in the world","RBI is the only authority in India that can issue currency notes","Odisha is one of the major producers of graphite in India.","The first Special Economic Zone (SEZ) was established in Kandla in Gujarat in the year 1965.","India happens to be the second largest English speaking country in the world","The country's largest news agency is Press Trust of India (PTI)","Indian Railways is the world's eighth largest employer, employing over 1.4 million people","India is the first country in the world to enter the Martian orbit in its very first attempt","India is the largest producer of milk in the world.","It is four times the size of Pakistan, 13 times the size of UK and nine times the size of Japan","India has the largest number of Post Offices in the world.","Chess was invented in India.","India never invaded any country in her last 100000 years of history.","Algebra, Trigonometry and Calculus are studies, which originated in India","The 'Place Value System' and the 'Decimal System' were developed in India in 100 B.C.","Until 1896, India was the only source of diamonds in the world ","Islam is India's and the world's second largest religion.","There are 300,000 active mosques in India, more than in any other country, including the Muslim world.","Jews and Christians have lived continuously in India since 200 B.C. and 52 A.D. respectively.","Yoga has its origins in India and has existed for over 5,000 years.","Martial Arts were first created in India, and later spread to Asia by Buddhist missionaries.","The four religions born in India - Hinduism, Buddhism, Jainism, and Sikhism, are followed by 25% of the world's population.","India exports software to 90 countries."," The highest award in the country is Bharat Ratna.","India has never hosted the Olympic Games.","The largest dam is the Hirakud Dam in Orrisa.","The world’s highest battlefield (Siachin) is controlled by India.","The British Raj, or British rule, lasted from 1858 to 1947.","Takshila, the first ever university in the world started around 700 BC in India.","Apart from the U.S. and Japan, only India has built a super computer indigenously."};


    public String getFact() {


        String fact = "";
        Random rm = new Random();
        int rn = rm.nextInt(mFacts.length);
        fact = mFacts[rn];
        return fact;


    }
}
