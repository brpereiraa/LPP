package main.src;

import java.util.ArrayList;

public class RestaurantEco extends Restaurant{
    private ArrayList<String> dailyMenu = new ArrayList<String>();
    private Boolean wifi;

    public void setDailyMenu(ArrayList<String> dailyMenu) { this.dailyMenu = dailyMenu; }
    public void setWifi(Boolean wifi) { this.wifi = wifi; }

    public ArrayList<String> getMenu() { return this.dailyMenu; }
    public Boolean getWifi(){ return this.wifi; }

    public RestaurantEco(){}

    public RestaurantEco(String name, String location, int capacity, Boolean wifi){
        super(name, location, capacity);
        this.wifi = wifi;
    }

    public RestaurantEco(RestaurantEco restaurant){
        super(restaurant.getName(), restaurant.getLocation(), restaurant.getCapacity());
        this.wifi = restaurant.getWifi();
    }

    @Override
    public String toString(){
        return (super.toString() + " | Wifi: " + this.wifi);
    }
}
