package admost.adserver.videocache;

public class ProxyCacheException extends Exception {
    public ProxyCacheException(String str) {
        super(str + ". Version: 0.1.2");
    }

    public ProxyCacheException(String str, Throwable th) {
        super(str + ". Version: 0.1.2", th);
    }
}
