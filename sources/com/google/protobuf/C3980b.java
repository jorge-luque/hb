package com.google.protobuf;

import com.google.protobuf.C4054u;

/* renamed from: com.google.protobuf.b */
/* compiled from: AbstractParser */
public abstract class C3980b<MessageType extends C4054u> implements C4058x<MessageType> {
    static {
        C4018k.m13414a();
    }

    /* renamed from: b */
    private UninitializedMessageException m13246b(MessageType messagetype) {
        if (messagetype instanceof C3969a) {
            return ((C3969a) messagetype).newUninitializedMessageException();
        }
        return new UninitializedMessageException(messagetype);
    }

    /* renamed from: a */
    private MessageType m13245a(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        InvalidProtocolBufferException a = m13246b(messagetype).mo28002a();
        a.mo28001a(messagetype);
        throw a;
    }

    /* renamed from: b */
    public MessageType mo28066b(C3995f fVar, C4018k kVar) throws InvalidProtocolBufferException {
        MessageType messagetype;
        try {
            C4013g b = fVar.mo28111b();
            messagetype = (C4054u) mo28214a(b, kVar);
            b.mo28134a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e) {
            e.mo28001a(messagetype);
            throw e;
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    /* renamed from: a */
    public MessageType m13248a(C3995f fVar, C4018k kVar) throws InvalidProtocolBufferException {
        MessageType b = mo28066b(fVar, kVar);
        m13245a(b);
        return b;
    }
}
