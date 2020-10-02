package p163cz.msebera.android.httpclient;

import java.nio.charset.CharacterCodingException;

/* renamed from: cz.msebera.android.httpclient.MessageConstraintException */
public class MessageConstraintException extends CharacterCodingException {
    private static final long serialVersionUID = 6077207720446368695L;

    /* renamed from: a */
    private final String f14489a;

    public MessageConstraintException(String str) {
        this.f14489a = str;
    }

    public String getMessage() {
        return this.f14489a;
    }
}
