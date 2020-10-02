package com.google.protobuf;

import com.google.protobuf.C3969a;
import com.google.protobuf.C4005f0;
import com.google.protobuf.C4019l;
import com.google.protobuf.C4023n;
import com.google.protobuf.C4023n.C4025b;
import com.google.protobuf.C4038p;
import com.google.protobuf.C4054u;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;

/* renamed from: com.google.protobuf.n */
/* compiled from: GeneratedMessageLite */
public abstract class C4023n<MessageType extends C4023n<MessageType, BuilderType>, BuilderType extends C4025b<MessageType, BuilderType>> extends C3969a<MessageType, BuilderType> {
    protected int memoizedSerializedSize = -1;
    protected C3985c0 unknownFields = C3985c0.m13262e();

    /* renamed from: com.google.protobuf.n$a */
    /* compiled from: GeneratedMessageLite */
    static /* synthetic */ class C4024a {

        /* renamed from: a */
        static final /* synthetic */ int[] f10829a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.protobuf.f0$c[] r0 = com.google.protobuf.C4005f0.C4012c.m13362a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10829a = r0
                com.google.protobuf.f0$c r1 = com.google.protobuf.C4005f0.C4012c.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10829a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.f0$c r1 = com.google.protobuf.C4005f0.C4012c.ENUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C4023n.C4024a.<clinit>():void");
        }
    }

    /* renamed from: com.google.protobuf.n$b */
    /* compiled from: GeneratedMessageLite */
    public static abstract class C4025b<MessageType extends C4023n<MessageType, BuilderType>, BuilderType extends C4025b<MessageType, BuilderType>> extends C3969a.C3970a<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;
        protected boolean isBuilt = false;

        protected C4025b(MessageType messagetype) {
            this.defaultInstance = messagetype;
            this.instance = (C4023n) messagetype.dynamicMethod(C4035k.NEW_MUTABLE_INSTANCE);
        }

        /* access modifiers changed from: protected */
        public void copyOnWrite() {
            if (this.isBuilt) {
                MessageType messagetype = (C4023n) this.instance.dynamicMethod(C4035k.NEW_MUTABLE_INSTANCE);
                messagetype.visit(C4034j.f10839a, this.instance);
                this.instance = messagetype;
                this.isBuilt = false;
            }
        }

        public final boolean isInitialized() {
            return C4023n.isInitialized(this.instance, false);
        }

        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw C3969a.C3970a.newUninitializedMessageException(buildPartial);
        }

        public MessageType buildPartial() {
            if (this.isBuilt) {
                return this.instance;
            }
            this.instance.makeImmutable();
            this.isBuilt = true;
            return this.instance;
        }

        public final BuilderType clear() {
            this.instance = (C4023n) this.instance.dynamicMethod(C4035k.NEW_MUTABLE_INSTANCE);
            return this;
        }

        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        /* access modifiers changed from: protected */
        public BuilderType internalMergeFrom(MessageType messagetype) {
            return mergeFrom(messagetype);
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            copyOnWrite();
            this.instance.visit(C4034j.f10839a, messagetype);
            return this;
        }

        public BuilderType clone() {
            BuilderType newBuilderForType = getDefaultInstanceForType().newBuilderForType();
            newBuilderForType.mergeFrom(buildPartial());
            return newBuilderForType;
        }

        public BuilderType mergeFrom(C4013g gVar, C4018k kVar) throws IOException {
            copyOnWrite();
            try {
                this.instance.dynamicMethod(C4035k.MERGE_FROM_STREAM, gVar, kVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }
    }

    /* renamed from: com.google.protobuf.n$c */
    /* compiled from: GeneratedMessageLite */
    protected static class C4026c<T extends C4023n<T, ?>> extends C3980b<T> {

        /* renamed from: a */
        private T f10830a;

        public C4026c(T t) {
            this.f10830a = t;
        }

        /* renamed from: a */
        public T m13441a(C4013g gVar, C4018k kVar) throws InvalidProtocolBufferException {
            return C4023n.parsePartialFrom(this.f10830a, gVar, kVar);
        }
    }

    /* renamed from: com.google.protobuf.n$d */
    /* compiled from: GeneratedMessageLite */
    static class C4027d implements C4036l {

        /* renamed from: a */
        static final C4027d f10831a = new C4027d();

        /* renamed from: b */
        static final C4028a f10832b = new C4028a();

        /* renamed from: com.google.protobuf.n$d$a */
        /* compiled from: GeneratedMessageLite */
        static final class C4028a extends RuntimeException {
            C4028a() {
            }
        }

        private C4027d() {
        }

        /* renamed from: a */
        public boolean mo28223a(boolean z, boolean z2, boolean z3, boolean z4) {
            if (z == z3 && z2 == z4) {
                return z2;
            }
            throw f10832b;
        }

        /* renamed from: a */
        public int mo28215a(boolean z, int i, boolean z2, int i2) {
            if (z == z2 && i == i2) {
                return i;
            }
            throw f10832b;
        }

        /* renamed from: a */
        public long mo28216a(boolean z, long j, boolean z2, long j2) {
            if (z == z2 && j == j2) {
                return j;
            }
            throw f10832b;
        }

        /* renamed from: a */
        public String mo28222a(boolean z, String str, boolean z2, String str2) {
            if (z == z2 && str.equals(str2)) {
                return str;
            }
            throw f10832b;
        }

        /* renamed from: a */
        public C3995f mo28218a(boolean z, C3995f fVar, boolean z2, C3995f fVar2) {
            if (z == z2 && fVar.equals(fVar2)) {
                return fVar;
            }
            throw f10832b;
        }

        /* renamed from: a */
        public <T extends C4054u> T mo28221a(T t, T t2) {
            if (t == null && t2 == null) {
                return null;
            }
            if (t == null || t2 == null) {
                throw f10832b;
            }
            ((C4023n) t).equals(this, t2);
            return t;
        }

        /* renamed from: a */
        public <T> C4038p.C4046h<T> mo28220a(C4038p.C4046h<T> hVar, C4038p.C4046h<T> hVar2) {
            if (hVar.equals(hVar2)) {
                return hVar;
            }
            throw f10832b;
        }

        /* renamed from: a */
        public C4019l<C4031g> mo28219a(C4019l<C4031g> lVar, C4019l<C4031g> lVar2) {
            if (lVar.equals(lVar2)) {
                return lVar;
            }
            throw f10832b;
        }

        /* renamed from: a */
        public C3985c0 mo28217a(C3985c0 c0Var, C3985c0 c0Var2) {
            if (c0Var.equals(c0Var2)) {
                return c0Var;
            }
            throw f10832b;
        }
    }

    /* renamed from: com.google.protobuf.n$e */
    /* compiled from: GeneratedMessageLite */
    public static abstract class C4029e<MessageType extends C4029e<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends C4023n<MessageType, BuilderType> implements C4030f<MessageType, BuilderType> {

        /* renamed from: a */
        protected C4019l<C4031g> f10833a = C4019l.m13419d();

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void visit(C4036l lVar, MessageType messagetype) {
            C4023n.super.visit(lVar, messagetype);
            this.f10833a = lVar.mo28219a(this.f10833a, messagetype.f10833a);
        }

        public /* bridge */ /* synthetic */ C4054u getDefaultInstanceForType() {
            return C4023n.super.getDefaultInstanceForType();
        }

        /* access modifiers changed from: protected */
        public final void makeImmutable() {
            C4023n.super.makeImmutable();
            this.f10833a.mo28173c();
        }

        public /* bridge */ /* synthetic */ C4054u.C4055a newBuilderForType() {
            return C4023n.super.newBuilderForType();
        }

        public /* bridge */ /* synthetic */ C4054u.C4055a toBuilder() {
            return C4023n.super.toBuilder();
        }
    }

    /* renamed from: com.google.protobuf.n$f */
    /* compiled from: GeneratedMessageLite */
    public interface C4030f<MessageType extends C4029e<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends C4056v {
    }

    /* renamed from: com.google.protobuf.n$g */
    /* compiled from: GeneratedMessageLite */
    static final class C4031g implements C4019l.C4021b<C4031g> {

        /* renamed from: a */
        final int f10834a;

        /* renamed from: b */
        final C4005f0.C4007b f10835b;

        /* renamed from: c */
        final boolean f10836c;

        C4031g(C4038p.C4042d<?> dVar, int i, C4005f0.C4007b bVar, boolean z, boolean z2) {
            this.f10834a = i;
            this.f10835b = bVar;
            this.f10836c = z;
        }

        /* renamed from: a */
        public int mo28225a() {
            return this.f10834a;
        }

        /* renamed from: p */
        public boolean mo28178p() {
            return this.f10836c;
        }

        /* renamed from: q */
        public C4005f0.C4007b mo28179q() {
            return this.f10835b;
        }

        /* renamed from: r */
        public C4005f0.C4012c mo28180r() {
            return this.f10835b.mo28132a();
        }

        /* renamed from: a */
        public C4054u.C4055a mo28177a(C4054u.C4055a aVar, C4054u uVar) {
            return ((C4025b) aVar).mergeFrom((C4023n) uVar);
        }

        /* renamed from: a */
        public int compareTo(C4031g gVar) {
            return this.f10834a - gVar.f10834a;
        }
    }

    /* renamed from: com.google.protobuf.n$h */
    /* compiled from: GeneratedMessageLite */
    public static class C4032h<ContainingType extends C4054u, Type> extends C4016i<ContainingType, Type> {

        /* renamed from: a */
        final Type f10837a;

        C4032h(ContainingType containingtype, Type type, C4054u uVar, C4031g gVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (gVar.mo28179q() == C4005f0.C4007b.MESSAGE && uVar == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.f10837a = type;
            }
        }
    }

    /* renamed from: com.google.protobuf.n$j */
    /* compiled from: GeneratedMessageLite */
    protected static class C4034j implements C4036l {

        /* renamed from: a */
        public static final C4034j f10839a = new C4034j();

        private C4034j() {
        }

        /* renamed from: a */
        public int mo28215a(boolean z, int i, boolean z2, int i2) {
            return z2 ? i2 : i;
        }

        /* renamed from: a */
        public long mo28216a(boolean z, long j, boolean z2, long j2) {
            return z2 ? j2 : j;
        }

        /* renamed from: a */
        public C3995f mo28218a(boolean z, C3995f fVar, boolean z2, C3995f fVar2) {
            return z2 ? fVar2 : fVar;
        }

        /* renamed from: a */
        public <T extends C4054u> T mo28221a(T t, T t2) {
            if (t == null || t2 == null) {
                return t != null ? t : t2;
            }
            return t.toBuilder().mergeFrom(t2).build();
        }

        /* renamed from: a */
        public String mo28222a(boolean z, String str, boolean z2, String str2) {
            return z2 ? str2 : str;
        }

        /* renamed from: a */
        public boolean mo28223a(boolean z, boolean z2, boolean z3, boolean z4) {
            return z3 ? z4 : z2;
        }

        /* renamed from: a */
        public <T> C4038p.C4046h<T> mo28220a(C4038p.C4046h<T> hVar, C4038p.C4046h<T> hVar2) {
            int size = hVar.size();
            int size2 = hVar2.size();
            if (size > 0 && size2 > 0) {
                if (!hVar.mo28080v()) {
                    hVar = hVar.mo28095c(size2 + size);
                }
                hVar.addAll(hVar2);
            }
            return size > 0 ? hVar : hVar2;
        }

        /* renamed from: a */
        public C4019l<C4031g> mo28219a(C4019l<C4031g> lVar, C4019l<C4031g> lVar2) {
            if (lVar.mo28171a()) {
                lVar = lVar.clone();
            }
            lVar.mo28170a(lVar2);
            return lVar;
        }

        /* renamed from: a */
        public C3985c0 mo28217a(C3985c0 c0Var, C3985c0 c0Var2) {
            return c0Var2 == C3985c0.m13262e() ? c0Var : C3985c0.m13258a(c0Var, c0Var2);
        }
    }

    /* renamed from: com.google.protobuf.n$k */
    /* compiled from: GeneratedMessageLite */
    public enum C4035k {
        IS_INITIALIZED,
        VISIT,
        MERGE_FROM_STREAM,
        MAKE_IMMUTABLE,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER;

        /* renamed from: a */
        public static C4035k[] m13478a() {
            return (C4035k[]) f10848i.clone();
        }
    }

    /* renamed from: com.google.protobuf.n$l */
    /* compiled from: GeneratedMessageLite */
    protected interface C4036l {
        /* renamed from: a */
        int mo28215a(boolean z, int i, boolean z2, int i2);

        /* renamed from: a */
        long mo28216a(boolean z, long j, boolean z2, long j2);

        /* renamed from: a */
        C3985c0 mo28217a(C3985c0 c0Var, C3985c0 c0Var2);

        /* renamed from: a */
        C3995f mo28218a(boolean z, C3995f fVar, boolean z2, C3995f fVar2);

        /* renamed from: a */
        C4019l<C4031g> mo28219a(C4019l<C4031g> lVar, C4019l<C4031g> lVar2);

        /* renamed from: a */
        <T> C4038p.C4046h<T> mo28220a(C4038p.C4046h<T> hVar, C4038p.C4046h<T> hVar2);

        /* renamed from: a */
        <T extends C4054u> T mo28221a(T t, T t2);

        /* renamed from: a */
        String mo28222a(boolean z, String str, boolean z2, String str2);

        /* renamed from: a */
        boolean mo28223a(boolean z, boolean z2, boolean z3, boolean z4);
    }

    /* access modifiers changed from: private */
    public static <MessageType extends C4029e<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>, T> C4032h<MessageType, T> checkIsLite(C4016i<MessageType, T> iVar) {
        if (iVar.mo28167a()) {
            return (C4032h) iVar;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends C4023n<T, ?>> T checkMessageInitialized(T t) throws InvalidProtocolBufferException {
        if (t == null || t.isInitialized()) {
            return t;
        }
        InvalidProtocolBufferException a = t.newUninitializedMessageException().mo28002a();
        a.mo28001a(t);
        throw a;
    }

    protected static C4038p.C4039a emptyBooleanList() {
        return C3986d.m13272b();
    }

    protected static C4038p.C4040b emptyDoubleList() {
        return C4015h.m13400b();
    }

    protected static C4038p.C4043e emptyFloatList() {
        return C4022m.m13430b();
    }

    protected static C4038p.C4044f emptyIntList() {
        return C4037o.m13488b();
    }

    protected static C4038p.C4045g emptyLongList() {
        return C4053t.m13514b();
    }

    protected static <E> C4038p.C4046h<E> emptyProtobufList() {
        return C4059y.m13531b();
    }

    private final void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == C3985c0.m13262e()) {
            this.unknownFields = C3985c0.m13263f();
        }
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static C4038p.C4044f mutableCopy(C4038p.C4044f fVar) {
        int size = fVar.size();
        return fVar.mo28095c(size == 0 ? 10 : size * 2);
    }

    public static <ContainingType extends C4054u, Type> C4032h<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, C4054u uVar, C4038p.C4042d<?> dVar, int i, C4005f0.C4007b bVar, boolean z, Class cls) {
        return new C4032h(containingtype, Collections.emptyList(), uVar, new C4031g(dVar, i, bVar, true, z), cls);
    }

    public static <ContainingType extends C4054u, Type> C4032h<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, C4054u uVar, C4038p.C4042d<?> dVar, int i, C4005f0.C4007b bVar, Class cls) {
        return new C4032h(containingtype, type, uVar, new C4031g(dVar, i, bVar, false, false), cls);
    }

    protected static <T extends C4023n<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, C4018k.m13414a()));
    }

    protected static <T extends C4023n<T, ?>> T parseFrom(T t, C3995f fVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parseFrom(t, fVar, C4018k.m13414a()));
    }

    private static <T extends C4023n<T, ?>> T parsePartialDelimitedFrom(T t, InputStream inputStream, C4018k kVar) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            C4013g a = C4013g.m13364a((InputStream) new C3969a.C3970a.C3971a(inputStream, C4013g.m13363a(read, inputStream)));
            T parsePartialFrom = parsePartialFrom(t, a, kVar);
            try {
                a.mo28134a(0);
                return parsePartialFrom;
            } catch (InvalidProtocolBufferException e) {
                e.mo28001a(parsePartialFrom);
                throw e;
            }
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2.getMessage());
        }
    }

    static <T extends C4023n<T, ?>> T parsePartialFrom(T t, C4013g gVar, C4018k kVar) throws InvalidProtocolBufferException {
        T t2 = (C4023n) t.dynamicMethod(C4035k.NEW_MUTABLE_INSTANCE);
        try {
            t2.dynamicMethod(C4035k.MERGE_FROM_STREAM, gVar, kVar);
            t2.makeImmutable();
            return t2;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e.getCause());
            }
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public Object dynamicMethod(C4035k kVar, Object obj) {
        return dynamicMethod(kVar, obj, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object dynamicMethod(C4035k kVar, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        try {
            visit(C4027d.f10831a, (C4023n) obj);
            return true;
        } catch (C4027d.C4028a unused) {
            return false;
        }
    }

    public final C4058x<MessageType> getParserForType() {
        return (C4058x) dynamicMethod(C4035k.GET_PARSER);
    }

    public int hashCode() {
        if (this.memoizedHashCode == 0) {
            C4033i iVar = new C4033i((C4024a) null);
            visit(iVar, this);
            this.memoizedHashCode = iVar.f10838a;
        }
        return this.memoizedHashCode;
    }

    public final boolean isInitialized() {
        return dynamicMethod(C4035k.IS_INITIALIZED, Boolean.TRUE) != null;
    }

    /* access modifiers changed from: protected */
    public void makeImmutable() {
        dynamicMethod(C4035k.MAKE_IMMUTABLE);
        this.unknownFields.mo28088c();
    }

    /* access modifiers changed from: protected */
    public void mergeLengthDelimitedField(int i, C3995f fVar) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mo28082a(i, fVar);
    }

    /* access modifiers changed from: protected */
    public final void mergeUnknownFields(C3985c0 c0Var) {
        this.unknownFields = C3985c0.m13258a(this.unknownFields, c0Var);
    }

    /* access modifiers changed from: protected */
    public void mergeVarintField(int i, int i2) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mo28081a(i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean parseUnknownField(int i, C4013g gVar) throws IOException {
        if (C4005f0.m13359b(i) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.mo28086a(i, gVar);
    }

    public String toString() {
        return C4057w.m13524a(this, super.toString());
    }

    /* access modifiers changed from: package-private */
    public void visit(C4036l lVar, MessageType messagetype) {
        dynamicMethod(C4035k.VISIT, lVar, messagetype);
        this.unknownFields = lVar.mo28217a(this.unknownFields, messagetype.unknownFields);
    }

    /* renamed from: com.google.protobuf.n$i */
    /* compiled from: GeneratedMessageLite */
    private static class C4033i implements C4036l {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f10838a;

        private C4033i() {
            this.f10838a = 0;
        }

        /* synthetic */ C4033i(C4024a aVar) {
            this();
        }

        /* renamed from: a */
        public boolean mo28223a(boolean z, boolean z2, boolean z3, boolean z4) {
            this.f10838a = (this.f10838a * 53) + C4038p.m13500a(z2);
            return z2;
        }

        /* renamed from: a */
        public int mo28215a(boolean z, int i, boolean z2, int i2) {
            this.f10838a = (this.f10838a * 53) + i;
            return i;
        }

        /* renamed from: a */
        public long mo28216a(boolean z, long j, boolean z2, long j2) {
            this.f10838a = (this.f10838a * 53) + C4038p.m13499a(j);
            return j;
        }

        /* renamed from: a */
        public String mo28222a(boolean z, String str, boolean z2, String str2) {
            this.f10838a = (this.f10838a * 53) + str.hashCode();
            return str;
        }

        /* renamed from: a */
        public C3995f mo28218a(boolean z, C3995f fVar, boolean z2, C3995f fVar2) {
            this.f10838a = (this.f10838a * 53) + fVar.hashCode();
            return fVar;
        }

        /* renamed from: a */
        public <T extends C4054u> T mo28221a(T t, T t2) {
            int i;
            if (t != null) {
                i = t instanceof C4023n ? ((C4023n) t).hashCode(this) : t.hashCode();
            } else {
                i = 37;
            }
            this.f10838a = (this.f10838a * 53) + i;
            return t;
        }

        /* renamed from: a */
        public <T> C4038p.C4046h<T> mo28220a(C4038p.C4046h<T> hVar, C4038p.C4046h<T> hVar2) {
            this.f10838a = (this.f10838a * 53) + hVar.hashCode();
            return hVar;
        }

        /* renamed from: a */
        public C4019l<C4031g> mo28219a(C4019l<C4031g> lVar, C4019l<C4031g> lVar2) {
            this.f10838a = (this.f10838a * 53) + lVar.hashCode();
            return lVar;
        }

        /* renamed from: a */
        public C3985c0 mo28217a(C3985c0 c0Var, C3985c0 c0Var2) {
            this.f10838a = (this.f10838a * 53) + c0Var.hashCode();
            return c0Var;
        }
    }

    protected static final <T extends C4023n<T, ?>> boolean isInitialized(T t, boolean z) {
        return t.dynamicMethod(C4035k.IS_INITIALIZED, Boolean.valueOf(z)) != null;
    }

    /* access modifiers changed from: protected */
    public Object dynamicMethod(C4035k kVar) {
        return dynamicMethod(kVar, (Object) null, (Object) null);
    }

    public final MessageType getDefaultInstanceForType() {
        return (C4023n) dynamicMethod(C4035k.GET_DEFAULT_INSTANCE);
    }

    public final BuilderType newBuilderForType() {
        return (C4025b) dynamicMethod(C4035k.NEW_BUILDER);
    }

    public final BuilderType toBuilder() {
        BuilderType buildertype = (C4025b) dynamicMethod(C4035k.NEW_BUILDER);
        buildertype.mergeFrom(this);
        return buildertype;
    }

    protected static final <T extends C4023n<T, ?>> void makeImmutable(T t) {
        t.dynamicMethod(C4035k.MAKE_IMMUTABLE);
    }

    protected static C4038p.C4045g mutableCopy(C4038p.C4045g gVar) {
        int size = gVar.size();
        return gVar.mo28095c(size == 0 ? 10 : size * 2);
    }

    protected static <T extends C4023n<T, ?>> T parseFrom(T t, C3995f fVar, C4018k kVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, fVar, kVar));
    }

    /* access modifiers changed from: package-private */
    public boolean equals(C4027d dVar, C4054u uVar) {
        if (this == uVar) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(uVar)) {
            return false;
        }
        visit(dVar, (C4023n) uVar);
        return true;
    }

    protected static <T extends C4023n<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream, C4018k kVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, kVar));
    }

    protected static <T extends C4023n<T, ?>> T parseFrom(T t, byte[] bArr) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, bArr, C4018k.m13414a()));
    }

    protected static C4038p.C4043e mutableCopy(C4038p.C4043e eVar) {
        int size = eVar.size();
        return eVar.mo28095c(size == 0 ? 10 : size * 2);
    }

    protected static <T extends C4023n<T, ?>> T parseFrom(T t, byte[] bArr, C4018k kVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, bArr, kVar));
    }

    /* access modifiers changed from: package-private */
    public int hashCode(C4033i iVar) {
        if (this.memoizedHashCode == 0) {
            int a = iVar.f10838a;
            int unused = iVar.f10838a = 0;
            visit(iVar, this);
            this.memoizedHashCode = iVar.f10838a;
            int unused2 = iVar.f10838a = a;
        }
        return this.memoizedHashCode;
    }

    protected static C4038p.C4040b mutableCopy(C4038p.C4040b bVar) {
        int size = bVar.size();
        return bVar.mo28095c(size == 0 ? 10 : size * 2);
    }

    protected static <T extends C4023n<T, ?>> T parseFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, C4013g.m13364a(inputStream), C4018k.m13414a()));
    }

    protected static <T extends C4023n<T, ?>> T parsePartialFrom(T t, C4013g gVar) throws InvalidProtocolBufferException {
        return parsePartialFrom(t, gVar, C4018k.m13414a());
    }

    private static <T extends C4023n<T, ?>> T parsePartialFrom(T t, C3995f fVar, C4018k kVar) throws InvalidProtocolBufferException {
        T parsePartialFrom;
        try {
            C4013g b = fVar.mo28111b();
            parsePartialFrom = parsePartialFrom(t, b, kVar);
            b.mo28134a(0);
            return parsePartialFrom;
        } catch (InvalidProtocolBufferException e) {
            e.mo28001a(parsePartialFrom);
            throw e;
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    protected static C4038p.C4039a mutableCopy(C4038p.C4039a aVar) {
        int size = aVar.size();
        return aVar.mo28095c(size == 0 ? 10 : size * 2);
    }

    protected static <E> C4038p.C4046h<E> mutableCopy(C4038p.C4046h<E> hVar) {
        int size = hVar.size();
        return hVar.mo28095c(size == 0 ? 10 : size * 2);
    }

    protected static <T extends C4023n<T, ?>> T parseFrom(T t, InputStream inputStream, C4018k kVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, C4013g.m13364a(inputStream), kVar));
    }

    protected static <T extends C4023n<T, ?>> T parseFrom(T t, C4013g gVar) throws InvalidProtocolBufferException {
        return parseFrom(t, gVar, C4018k.m13414a());
    }

    private static <T extends C4023n<T, ?>> T parsePartialFrom(T t, byte[] bArr, C4018k kVar) throws InvalidProtocolBufferException {
        T parsePartialFrom;
        try {
            C4013g a = C4013g.m13365a(bArr);
            parsePartialFrom = parsePartialFrom(t, a, kVar);
            a.mo28134a(0);
            return parsePartialFrom;
        } catch (InvalidProtocolBufferException e) {
            e.mo28001a(parsePartialFrom);
            throw e;
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    protected static <T extends C4023n<T, ?>> T parseFrom(T t, C4013g gVar, C4018k kVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, gVar, kVar));
    }
}
