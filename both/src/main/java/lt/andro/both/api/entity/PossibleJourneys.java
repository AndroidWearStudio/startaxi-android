package lt.andro.both.api.entity;

import java.util.List;

/**
 * @author Vilius Kraujutis
 * @since 2014-10-25 13:39
 */
public class PossibleJourneys extends BaseEntity {
    public UserPosition userPosition;
    public List<Destination> destinations;
}
