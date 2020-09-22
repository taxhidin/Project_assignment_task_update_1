package tk.taxhidinkadiri.myapplication.other_methods.Main_Screen.model;

public class Contact {
    private int id;
    private String name;
    private  String height;
    private String mass;

    public Contact(int id, String name, String height, String mass) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.mass = mass;
    }

    public Contact(String name, String height, String mass) {
        this.name = name;
        this.height = height;
        this.mass = mass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }
}
