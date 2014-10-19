package lt.andro.both;

/**
 * @author Vilius Kraujutis
 * @since 2014-10-20 01:21
 */
public class Location {
    public static final Location HOME = new Location("Smolensko gatvė 17, Vilnius", "54.673347", "25.259668");
    public static final Location WORK = new Location("Žirmūnų gatvė 70, Vilnius", "54.7183", "25.302626");
    public static final Location SCHOOL = new Location("Mykolo Romerio Universitetas, Ateities gatvė, Vilnius", "54.733913", "25.258681");

    public String title;
    public String lat;
    public String lon;

    public Location(String title, String lat, String lon) {
        this.title = title;
        this.lat = lat;
        this.lon = lon;
    }
}
