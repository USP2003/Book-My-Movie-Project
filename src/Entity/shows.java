package Entity;

public class shows {
    private int showid;
    private int movieid;
    private int theaterid;
    private String timing;
    private int available_seat;

    public shows(int showid, int movieid, int theaterid, String timing, int available_seat) {
        this.showid = showid;
        this.movieid = movieid;
        this.theaterid = theaterid;
        this.timing = timing;
        this.available_seat = available_seat;
    }

    public int getShowid() {
        return showid;
    }

    public void setShowid(int showid) {
        this.showid = showid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public int getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(int theaterid) {
        this.theaterid = theaterid;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public int getAvailable_seat() {
        return available_seat;
    }

    public void setAvailable_seat(int available_seat) {
        this.available_seat = available_seat;
    }
}
