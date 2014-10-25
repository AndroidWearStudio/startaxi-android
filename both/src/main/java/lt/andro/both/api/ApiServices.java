package lt.andro.both.api;

import java.util.List;

import lt.andro.both.api.entity.Arrival;
import lt.andro.both.api.entity.DriverMessage;
import lt.andro.both.api.entity.Estimate;
import lt.andro.both.api.entity.Order;
import lt.andro.both.api.entity.PossibleJourneys;
import lt.andro.both.api.entity.Preferences;
import lt.andro.both.api.entity.Provider;
import lt.andro.both.api.entity.UserPosition;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import rx.Observable;

/**
 * @author Vilius Kraujutis
 * @since 2014-10-25 12:58
 */
public interface ApiServices {
    /**
     * Get available taxi providers in the area
     * <p/>
     * Returns information about available taxi providers in the area.
     */
    @GET("/taxi/provider")
    Observable<List<Provider>> getProviders(@Body UserPosition body);

    /**
     * Get available taxi providers and the estimates to the destinations
     */
    @GET("/taxi/estimate")
    Observable<List<Estimate>> getEstimations(@Body PossibleJourneys body);

    /**
     * Order a taxi
     * <p/>
     * Place a taxi order to the selected provider with user and destination coordinates.
     */
    @POST("/taxi/order")
    Observable<Arrival> postOrder(@Body Order order);

    /**
     * Send preferences to the particular order
     * <p/>
     * Interact with the driver by sending preferences to the particular order.
     */
    @PUT("/taxi/order")
    Observable<DriverMessage> putOrderPreferences(@Body Preferences preferences);

    /**
     * Get order information
     * <p/>
     * Can be streamed using SSE.
     */
    @GET("/taxi/order/{id}")
    Observable<Arrival> getOrder(@Path("id") int orderId);
}
