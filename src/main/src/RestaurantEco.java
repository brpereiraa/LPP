package main.src;

import java.util.ArrayList;

public class RestaurantEco extends Restaurant{
    private ArrayList<String> DailyMenu = new ArrayList<String>();

    public void setDailyMenu(ArrayList<String> dailyMenu) { DailyMenu = dailyMenu; }
    public ArrayList<String> getMenu() { return this.DailyMenu; }

    public RestaurantEco(){}

    public RestaurantEco(String name, String location, int capacity){
        super(name, location, capacity);
    }

    public RestaurantEco(RestaurantEco restaurant){
        super(restaurant.getName(), restaurant.getLocation(), restaurant.getCapacity());
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
