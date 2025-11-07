package Entity;

public class seat {
    private int seatid;
    private int showid;
    private String seat_number;
    private boolean isbooked;

    public seat(int seatid, int showid, String seat_number, boolean isbooked) {
        this.seatid = seatid;
        this.showid = showid;
        this.seat_number = seat_number;
        this.isbooked = isbooked;
    }

    public int getSeatid() {
        return seatid;
    }

    public void setSeatid(int seatid) {
        this.seatid = seatid;
    }

    public int getShowid() {
        return showid;
    }

    public void setShowid(int showid) {
        this.showid = showid;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }

    public boolean isIsbooked() {
        return isbooked;
    }

    public void setIsbooked(boolean isbooked) {
        this.isbooked = isbooked;
    }
}
