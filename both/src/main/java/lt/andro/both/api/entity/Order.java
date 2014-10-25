package lt.andro.both.api.entity;

/**
 * @author Vilius Kraujutis
 * @since 2014-10-25 13:44
 */
public class Order extends BaseEntity {
    public String providerId;
    public UserPosition userPosition;
    public Destination destination;
}
