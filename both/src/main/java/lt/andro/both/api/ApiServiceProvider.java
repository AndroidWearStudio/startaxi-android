package lt.andro.both.api;

import retrofit.RestAdapter;

/**
 * @author Andrius Semionovas
 * @since 2014-10-25
 */
public class ApiServiceProvider {
    private static final String END_POINT = "http://startaxi.2m.lt/api";

    private static ApiServiceProvider instance;

    private final ApiServices apiServices;

    private ApiServiceProvider() {
        RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(END_POINT)
            .build();

        apiServices = restAdapter.create(ApiServices.class);
    }

    public static ApiServiceProvider getInstance() {
        if (instance == null) {
            instance = new ApiServiceProvider();
        }

        return instance;
    }

    public static ApiServices getApi() {
        return getInstance().apiServices;
    }

    public ApiServices getApiServices() {
        return apiServices;
    }
}
