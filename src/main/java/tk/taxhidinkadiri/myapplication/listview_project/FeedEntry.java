package tk.taxhidinkadiri.myapplication.listview_project;

public class FeedEntry {

        private int id;
        private String name;
        private  String height;
        private String mass;

    public FeedEntry() {
    }

    public FeedEntry(String name, String height, String mass) {
        this.name = name;
        this.height = height;
        this.mass = mass;
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
