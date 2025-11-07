package Service;

import Databaseconfig.config;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class BookMyMoviesys {
    Scanner sc=new Scanner(System.in);
    //DISPLAY MOVIE
    public void displaymovies(){
        try {
            Connection con= config.getconnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select *from movies");
            System.out.println("*******************Available Movies*******************");

            while (rs.next()){
                System.out.println(rs.getInt("movie_id"+". "+rs.getString("title"+" ("+rs.getString("genre")+")")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Show theater in a city


    public void displayTheaters(String city) {
        try {
            Connection con= config.getconnection();
            PreparedStatement st=con.prepareStatement("select *from theaters where city=?");
            st.setString(1,city);
            ResultSet rs=st.executeQuery();

            System.out.println("Theaters in "+city+":");
            while (rs.next()){
                System.out.println(rs.getInt("theater_id")+". "+rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //Display shows
    public void displayTheaters(int movieId, int theaterId){
        try{
            Connection con= config.getconnection();
            PreparedStatement st=con.prepareStatement("select *from shows where movie_id=? AND theater_id=?");
            st.setInt(1,movieId);
            st.setInt(2,theaterId);
            ResultSet rs=st.executeQuery();
            System.out.println("********Available Shows********");
            while (rs.next()){
                System.out.println(rs.getInt("show_id")+". "+rs.getInt("timing")+"-Seats Available: "+rs.getInt("available_seat"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Book Ticket
    public void bookTicket(int userId, int showId, List<String> selectedSeats){
        try {
            Connection con= config.getconnection();
            con.setAutoCommit(false);

            //check if seats are available
            boolean alreadyBookedSeat=false;
            for(String seat:selectedSeats){
                PreparedStatement st=con.prepareStatement("select *from seat where seat_number=? AND show_id=?");
                st.setString(1,seat);
                st.setInt(2,showId);
                ResultSet rs=st.executeQuery();
                if(rs.next() && rs.getBoolean("is_booked")){
                    alreadyBookedSeat=true;
                    System.out.println("Seat "+seat+" is already booked. Choose another Seat");
                }
            }
            if(alreadyBookedSeat){
                System.out.println("Booking Failed!!! Some seats are already booked.");
                con.rollback();
                return;
            }
            for(String seat:selectedSeats){
                PreparedStatement st=con.prepareStatement("update seat set is_booked=true where seat_number=? and show_id=?");
                st.setString(1,seat);
                st.setInt(2,showId);
                st.executeUpdate();
            }
            double seatPrice=200.0;
            double tp=selectedSeats.size()*seatPrice;
            PreparedStatement st=con.prepareStatement("insert into bookings(user_id, show_id, seats_booked,total_price) values(?,?,?,?)");
            st.setInt(1,userId);
            st.setInt(2,showId);
            st.setString(3,String.join(",",selectedSeats));
            st.setDouble(4,tp);
            st.executeUpdate();
            con.commit();
            System.out.println("Booking Successfull!! Your seats are: "+selectedSeats+" | Total Price: "+tp);


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
