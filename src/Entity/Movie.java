package Entity;

public class Movie {
    private int movieid;
    private String title;
    private String genre;
    private String lang;
    private int duration;

    public Movie(int movieid, String genre, String title, String lang, int duration) {
        this.movieid = movieid;
        this.title = title;
        this.genre = genre;
        this.lang = lang;
        this.duration = duration;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
