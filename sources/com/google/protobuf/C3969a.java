package com.google.protobuf;

import com.google.protobuf.C3969a;
import com.google.protobuf.C3969a.C3970a;
import com.google.protobuf.C3995f;
import com.google.protobuf.C4054u;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

/* renamed from: com.google.protobuf.a */
/* compiled from: AbstractMessageLite */
public abstract class C3969a<MessageType extends C3969a<MessageType, BuilderType>, BuilderType extends C3970a<MessageType, BuilderType>> implements C4054u {
    protected int memoizedHashCode = 0;

    protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        C3970a.addAll(iterable, collection);
    }

    protected static void checkByteStringIsUtf8(C3995f fVar) throws IllegalArgumentException {
        if (!fVar.mo28110a()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String getSerializingExceptionMessage(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    /* access modifiers changed from: package-private */
    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream a = CodedOutputStream.m13121a(bArr);
            writeTo(a);
            a.mo27963a();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e);
        }
    }

    public C3995f toByteString() {
        try {
            C3995f.C4001f e = C3995f.m13326e(getSerializedSize());
            writeTo(e.mo28130b());
            return e.mo28129a();
        } catch (IOException e2) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e2);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream a = CodedOutputStream.m13120a(outputStream, CodedOutputStream.m13140g(CodedOutputStream.m13142h(serializedSize) + serializedSize));
        a.mo27964a(serializedSize);
        writeTo(a);
        a.mo27972b();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        CodedOutputStream a = CodedOutputStream.m13120a(outputStream, CodedOutputStream.m13140g(getSerializedSize()));
        writeTo(a);
        a.mo27972b();
    }

    /* renamed from: com.google.protobuf.a$a */
    /* compiled from: AbstractMessageLite */
    public static abstract class C3970a<MessageType extends C3969a<MessageType, BuilderType>, BuilderType extends C3970a<MessageType, BuilderType>> implements C4054u.C4055a {
        protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            if (iterable == null) {
                throw null;
            } else if (iterable instanceof C4052s) {
                checkForNullValues(((C4052s) iterable).mo28250u());
                collection.addAll((Collection) iterable);
            } else if (iterable instanceof Collection) {
                checkForNullValues(iterable);
                collection.addAll((Collection) iterable);
            } else {
                for (T next : iterable) {
                    if (next != null) {
                        collection.add(next);
                    } else {
                        throw null;
                    }
                }
            }
        }

        private static void checkForNullValues(Iterable<?> iterable) {
            for (Object obj : iterable) {
                if (obj == null) {
                    throw null;
                }
            }
        }

        private String getReadingExceptionMessage(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        protected static UninitializedMessageException newUninitializedMessageException(C4054u uVar) {
            return new UninitializedMessageException(uVar);
        }

        public abstract BuilderType clone();

        public abstract /* bridge */ /* synthetic */ C4054u.C4055a clone();

        public abstract /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException;

        /* access modifiers changed from: protected */
        public abstract BuilderType internalMergeFrom(MessageType messagetype);

        public boolean mergeDelimitedFrom(InputStream inputStream, C4018k kVar) throws IOException {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            mergeFrom((InputStream) new C3971a(inputStream, C4013g.m13363a(read, inputStream)), kVar);
            return true;
        }

        public abstract BuilderType mergeFrom(C4013g gVar, C4018k kVar) throws IOException;

        public abstract /* bridge */ /* synthetic */ C4054u.C4055a mergeFrom(C4013g gVar, C4018k kVar) throws IOException;

        /* renamed from: com.google.protobuf.a$a$a */
        /* compiled from: AbstractMessageLite */
        static final class C3971a extends FilterInputStream {

            /* renamed from: a */
            private int f10727a;

            C3971a(InputStream inputStream, int i) {
                super(inputStream);
                this.f10727a = i;
            }

            public int available() throws IOException {
                return Math.min(super.available(), this.f10727a);
            }

            public int read() throws IOException {
                if (this.f10727a <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f10727a--;
                }
                return read;
            }

            public long skip(long j) throws IOException {
                long skip = super.skip(Math.min(j, (long) this.f10727a));
                if (skip >= 0) {
                    this.f10727a = (int) (((long) this.f10727a) - skip);
                }
                return skip;
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = this.f10727a;
                if (i3 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i, Math.min(i2, i3));
                if (read >= 0) {
                    this.f10727a -= read;
                }
                return read;
            }
        }

        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            return mergeDelimitedFrom(inputStream, C4018k.m13414a());
        }

        public BuilderType mergeFrom(C4013g gVar) throws IOException {
            return mergeFrom(gVar, C4018k.m13414a());
        }

        public BuilderType mergeFrom(C3995f fVar) throws InvalidProtocolBufferException {
            try {
                C4013g b = fVar.mo28111b();
                mergeFrom(b);
                b.mo28134a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e2);
            }
        }

        public BuilderType mergeFrom(C3995f fVar, C4018k kVar) throws InvalidProtocolBufferException {
            try {
                C4013g b = fVar.mo28111b();
                mergeFrom(b, kVar);
                b.mo28134a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e2);
            }
        }

        public BuilderType mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, 0, bArr.length);
        }

        public BuilderType mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            try {
                C4013g a = C4013g.m13366a(bArr, i, i2);
                mergeFrom(a);
                a.mo28134a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e2);
            }
        }

        public BuilderType mergeFrom(byte[] bArr, C4018k kVar) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, 0, bArr.length, kVar);
        }

        public BuilderType mergeFrom(byte[] bArr, int i, int i2, C4018k kVar) throws InvalidProtocolBufferException {
            try {
                C4013g a = C4013g.m13366a(bArr, i, i2);
                mergeFrom(a, kVar);
                a.mo28134a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e2);
            }
        }

        public BuilderType mergeFrom(InputStream inputStream) throws IOException {
            C4013g a = C4013g.m13364a(inputStream);
            mergeFrom(a);
            a.mo28134a(0);
            return this;
        }

        public BuilderType mergeFrom(InputStream inputStream, C4018k kVar) throws IOException {
            C4013g a = C4013g.m13364a(inputStream);
            mergeFrom(a, kVar);
            a.mo28134a(0);
            return this;
        }

        public BuilderType mergeFrom(C4054u uVar) {
            if (getDefaultInstanceForType().getClass().isInstance(uVar)) {
                return internalMergeFrom((C3969a) uVar);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }
}
