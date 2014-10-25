package lt.andro.both.api.entity;

/**
 * @author Vilius Kraujutis
 * @since 2014-10-25 13:43
 */
public class Arrival extends BaseEntity {
    public int orderId;
    public Coordinates taxiPosition;
    public int arrivalEta;
    public boolean pickedUp;
    public boolean arrived;
}
