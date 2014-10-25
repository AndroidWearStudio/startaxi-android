package lt.andro.both.api;

import lt.andro.both.api.entity.TaxiProviderResponse;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * @author Vilius Kraujutis
 * @since 2014-10-25 12:58
 */
public interface ApiServices {
    @GET("/taxi/provider") public void getTaxiProvider(Callback<TaxiProviderResponse> callback);
}
