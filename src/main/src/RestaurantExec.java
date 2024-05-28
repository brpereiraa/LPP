package main.src;

public class RestaurantExec extends Restaurant {
    private Boolean privateRoom;
    private Boolean gourmetMenu;

    public void setRoom(boolean room){ this.privateRoom = room; }
    public void setMenu(boolean menu){ this.gourmetMenu =  menu; }

    public Boolean getRoom() { return this.privateRoom; }
    public Boolean getMenu() { return this.gourmetMenu; }

    public RestaurantExec(){}

    public RestaurantExec(String name, String location, int capacity, Boolean room, Boolean menu){
        super(name, location, capacity);
        this.privateRoom = room;
        this.gourmetMenu = menu;
    }

    public RestaurantExec(RestaurantExec restaurant){
        super(restaurant.getName(), restaurant.getLocation(), restaurant.getCapacity());
        this.privateRoom = restaurant.getRoom();
        this.gourmetMenu = restaurant.getMenu();
    }

    @Override
    public String toString(){
        return super.toString() + ( " | Private Room: " + this.privateRoom + " | Menu Gourmet: " + this.gourmetMenu);
    }
}
