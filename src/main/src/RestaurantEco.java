package main.src;

import java.util.ArrayList;

public class RestaurantEco extends Restaurant{
    private Boolean wifi;

    public void setWifi(Boolean wifi) { this.wifi = wifi; }

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
}
