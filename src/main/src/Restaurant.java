package main.src;

public class Restaurant {
    private String name;
    private String location;
    private int capacity;

    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.name = location; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String getName() { return this.name; }
    public String getLocation() { return this.location; }
    public int getCapacity() { return this.capacity; }

    public Restaurant(){}

    public Restaurant(String name, String location, int capacity){
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    public Restaurant(Restaurant restaurant){
        this.name = restaurant.getName();
        this.location = restaurant.getLocation();
        this.capacity = restaurant.getCapacity();
    }

    @Override
    public String toString(){
        return (this.name);
    }

}
