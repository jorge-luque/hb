package admost.sdk.listener;

public interface AdmostResponseListener<T> {
    void onError(String str, Exception exc);

    void onResponse(T t);
}
