package com.company;

import java.util.ArrayList;
import java.util.List;

public class Cities {
    ArrayList<String> Cities;
    int numberOfCities;
    private Graph cityMap;

    public Cities(int numberOfCities){
        this.Cities= new ArrayList<>();
        this.numberOfCities = numberOfCities; //Having a problem with this. Taking a break
        this.cityMap = new Graph(numberOfCities);
    }

    public void add(String fromCity,String toCity, int distance){
        if (Cities.indexOf(fromCity)==-1)
            Cities.add(fromCity);
        if (Cities.indexOf(toCity)==-1)
            Cities.add(toCity);
        addDistance(fromCity,toCity,distance);
    }

    public void addDistance(String fromCity, String toCity, int distance){
        if (Cities.indexOf(fromCity) >= 0 && Cities.indexOf(toCity) >= 0){
            cityMap.addEdge(Cities.indexOf(fromCity),Cities.indexOf(toCity),distance);
            cityMap.addEdge(Cities.indexOf(toCity),Cities.indexOf(fromCity),distance);
        }
    }

    public void getMST(){
        ArrayList<String> MST = cityMap.MSTPrims();
        //Defining a print method for MSTPrims array-list.
        for (int i = 0; i < numberOfCities; i++) {
            String myString = MST.get(i);
            for (int j = numberOfCities-1; j > -1; j--) {
                myString = myString.replaceAll("Edge: "+j,"Distance from: "+Cities.get(j));
                myString = myString.replaceAll("To: "+j,"--> "+Cities.get(j));
            }
            myString = myString.replaceAll("Edge: "+-1,"Distance from: Starting Point");
            System.out.println(myString);
        }
    }

    public static void main(String[] args) {
        Cities DanishCities = new Cities(16);
        //Adding cities + distances in km
        DanishCities.add("Eskildstrup","Maribo",28);
        DanishCities.add("Eskildstrup","NykøbingF",13);
        DanishCities.add("Eskildstrup","Vordingborg",25);
        DanishCities.add("Haslev","Korsør",60);
        DanishCities.add("Haslev","Køge",24);
        DanishCities.add("Haslev","Næstved",25);
        DanishCities.add("Haslev","Ringsted",19);
        DanishCities.add("Haslev","Roskilde",47);
        DanishCities.add("Haslev","Slagelse",48);
        DanishCities.add("Haslev","Sorø",34);
        DanishCities.add("Haslev","Vordingborg",40);

        //herefter kun den første af hvert steds connections.
        DanishCities.add("Holbæk","Jægerspris",34);
        DanishCities.add("Jægerspris","Korsør",94);
        DanishCities.add("Kalundborg","Ringsted",62);
        DanishCities.add("Korsør","Næstved",45);
        DanishCities.add("Køge","Næstved",45);
        DanishCities.add("Maribo","Nakskov",27);
        DanishCities.add("Næstved","Roskilde",57);
        DanishCities.add("Ringsted","Roskilde",31);
        DanishCities.add("Slagelse","Sorø",14);

        System.out.println(DanishCities.Cities.get(0));
        DanishCities.getMST();

        System.out.println(DanishCities.Cities);


    }
}

