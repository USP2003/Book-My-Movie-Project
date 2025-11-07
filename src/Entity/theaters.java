package Entity;

public class theaters {
    private int theaterid;
    private String name;
    private String city;

    public theaters(int theaterid, String name, String city) {
        this.theaterid = theaterid;
        this.name = name;
        this.city = city;
    }

    public int getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(int theaterid) {
        this.theaterid = theaterid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
