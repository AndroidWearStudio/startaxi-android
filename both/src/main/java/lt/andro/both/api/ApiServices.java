package lt.andro.both.api;

import lt.andro.both.api.entity.TaxiProviderResponse;
import retrofit.http.GET;
import rx.Observable;

/**
 * @author Vilius Kraujutis
 * @since 2014-10-25 12:58
 */
public interface ApiServices {
    @GET("/taxi/provider") public Observable<TaxiProviderResponse> getTaxiProvider();
}
