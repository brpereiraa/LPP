package main.src;

public class RestaurantLux extends Restaurant {
    private Boolean valet;
    private Boolean tastingMenu;

    public Boolean getValet(){ return valet; }
    public Boolean getMenu(){ return tastingMenu; }

    public void setValet(Boolean valet){ this.valet = valet; }
    public void setMenu(Boolean menu){ this.tastingMenu = menu; }

    public RestaurantLux(){}

    public RestaurantLux(String name, String location, int capacity, Boolean valet, Boolean menu){
        super(name, location, capacity);
        this.valet = valet;
        this.tastingMenu = menu;
    }

    public RestaurantLux(RestaurantLux restaurant){
        super(restaurant.getName(), restaurant.getLocation(), restaurant.getCapacity());
        this.valet = restaurant.getValet();
        this.tastingMenu = restaurant.getMenu();
    }

    @Override
    public String toString(){
        return ( super.toString() + " | Valet: " + this.valet + " | Degustation Menu: " +  this.tastingMenu);
    }
}
