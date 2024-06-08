package main.src;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Client {

    private String name;
    private String contact;
    private String email;
    private List<Reservation> history;

    public Client(String name, String contact, String email, List<Reservation> history) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.history = new ArrayList<>(history);
    }

    public Client(Client client) {
        this.name = client.name;
        this.contact = client.contact;
        this.email = client.email;
        this.history = new ArrayList<>();
        for (Reservation reservation : client.history) 
            this.history.add(new Reservation(reservation));
    }

    public Client copy() { return new Client(this); }

    public String getcontact() { return contact; }
    public String getEmail() { return email; }
    public String getname() { return name; }
    public List<Reservation> gethistory() { return this.history; }

    public void setname(String name) { this.name = name; }
    public void setcontact(String contact) { this.contact = contact; }
    public void setEmail(String email) { this.email = email; }
    public void sethistory(List<Reservation> history) { this.history = new ArrayList<>(history); }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }
    

    @Override
    public String toString() {
        return  ("Name: " + name + " | Contact: " + contact + " | Email: " + email  +" | History: " + history);
    }

}
