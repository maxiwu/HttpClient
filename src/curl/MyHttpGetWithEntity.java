package curl;

import java.net.URI;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public class MyHttpGetWithEntity extends HttpEntityEnclosingRequestBase { public final static String GET_METHOD = "GET";

public MyHttpGetWithEntity(final URI uri) {
    super();
    setURI(uri);
}

public MyHttpGetWithEntity(final String uri) {
    super();
    setURI(URI.create(uri));
}

@Override
public String getMethod() {
    return GET_METHOD;
}
}