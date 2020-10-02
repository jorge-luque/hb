package com.criteo.publisher.p054a0;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;

/* renamed from: com.criteo.publisher.a0.n */
public class C2339n {

    /* renamed from: a */
    private final Gson f7706a;

    public C2339n(Gson gson) {
        this.f7706a = gson;
    }

    /* renamed from: a */
    public void mo10163a(Object obj, OutputStream outputStream) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        try {
            this.f7706a.toJson(obj, (Appendable) outputStreamWriter);
            outputStreamWriter.flush();
        } catch (JsonIOException e) {
            throw new IOException(e);
        }
    }

    /* renamed from: a */
    public <T> T mo10162a(Class<T> cls, InputStream inputStream) throws IOException {
        try {
            T fromJson = this.f7706a.fromJson((Reader) new InputStreamReader(inputStream), cls);
            if (fromJson != null) {
                return fromJson;
            }
            throw new EOFException();
        } catch (JsonParseException e) {
            throw new IOException(e);
        }
    }
}
