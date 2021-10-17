package com.company;

import java.util.ArrayList;
import java.util.List;

public class Cities {
    ArrayList<String> Cities;

    public Cities(){
        this.Cities= new ArrayList<>();
    }

    public void add(String cityName){
        Cities.add(cityName);
    }

    public String getName(int index){
        return Cities.get(index);
    }
    public int getIndex(String cityName){
        //To be filled
        return 0;
    }


    public static void main(String args[]) {
        Cities DanishCities = new Cities();
        DanishCities.add("Eskildstrup");
        DanishCities.add("Haslev");
        DanishCities.add("Holbæk");
        DanishCities.add("Jægerspris");
        DanishCities.add("Kalundborg");
        DanishCities.add("Korsør");
        DanishCities.add("Køge");
        DanishCities.add("Maribo");
        DanishCities.add("Nakskov");
        DanishCities.add("Nykøbing F");
        DanishCities.add("Næstved");
        DanishCities.add("Ringsted");
        DanishCities.add("Roskilde");
        DanishCities.add("Slagelse");
        DanishCities.add("Sorø");
        DanishCities.add("Vordingborg");
    }
}

