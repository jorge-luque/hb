package com.google.android.gms.config.proto;

import com.google.protobuf.C3995f;
import com.google.protobuf.C4013g;
import com.google.protobuf.C4018k;
import com.google.protobuf.C4023n;
import com.google.protobuf.C4038p;
import com.google.protobuf.C4054u;
import com.google.protobuf.C4056v;
import com.google.protobuf.C4058x;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public final class Logs {

    /* renamed from: com.google.android.gms.config.proto.Logs$1 */
    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    static /* synthetic */ class C30891 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f8637xa1df5c61;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.n$k[] r0 = com.google.protobuf.C4023n.C4035k.m13478a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8637xa1df5c61 = r0
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8637xa1df5c61     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8637xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.MAKE_IMMUTABLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8637xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8637xa1df5c61     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.VISIT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8637xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.MERGE_FROM_STREAM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8637xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f8637xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.config.proto.Logs.C30891.<clinit>():void");
        }
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class AndroidConfigFetchProto extends C4023n<AndroidConfigFetchProto, Builder> implements AndroidConfigFetchProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final AndroidConfigFetchProto DEFAULT_INSTANCE;
        private static volatile C4058x<AndroidConfigFetchProto> PARSER = null;
        public static final int REASON_FIELD_NUMBER = 1;
        private int bitField0_;
        private ConfigFetchReason reason_;

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public static final class Builder extends C4023n.C4025b<AndroidConfigFetchProto, Builder> implements AndroidConfigFetchProtoOrBuilder {
            /* synthetic */ Builder(C30891 r1) {
                this();
            }

            public Builder clearReason() {
                copyOnWrite();
                ((AndroidConfigFetchProto) this.instance).clearReason();
                return this;
            }

            public ConfigFetchReason getReason() {
                return ((AndroidConfigFetchProto) this.instance).getReason();
            }

            public boolean hasReason() {
                return ((AndroidConfigFetchProto) this.instance).hasReason();
            }

            public Builder mergeReason(ConfigFetchReason configFetchReason) {
                copyOnWrite();
                ((AndroidConfigFetchProto) this.instance).mergeReason(configFetchReason);
                return this;
            }

            public Builder setReason(ConfigFetchReason configFetchReason) {
                copyOnWrite();
                ((AndroidConfigFetchProto) this.instance).setReason(configFetchReason);
                return this;
            }

            private Builder() {
                super(AndroidConfigFetchProto.DEFAULT_INSTANCE);
            }

            public Builder setReason(ConfigFetchReason.Builder builder) {
                copyOnWrite();
                ((AndroidConfigFetchProto) this.instance).setReason(builder);
                return this;
            }
        }

        static {
            AndroidConfigFetchProto androidConfigFetchProto = new AndroidConfigFetchProto();
            DEFAULT_INSTANCE = androidConfigFetchProto;
            androidConfigFetchProto.makeImmutable();
        }

        private AndroidConfigFetchProto() {
        }

        /* access modifiers changed from: private */
        public void clearReason() {
            this.reason_ = null;
            this.bitField0_ &= -2;
        }

        public static AndroidConfigFetchProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeReason(ConfigFetchReason configFetchReason) {
            ConfigFetchReason configFetchReason2 = this.reason_;
            if (configFetchReason2 == null || configFetchReason2 == ConfigFetchReason.getDefaultInstance()) {
                this.reason_ = configFetchReason;
            } else {
                this.reason_ = (ConfigFetchReason) ((ConfigFetchReason.Builder) ConfigFetchReason.newBuilder(this.reason_).mergeFrom(configFetchReason)).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static AndroidConfigFetchProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AndroidConfigFetchProto) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AndroidConfigFetchProto parseFrom(C3995f fVar) throws InvalidProtocolBufferException {
            return (AndroidConfigFetchProto) C4023n.parseFrom(DEFAULT_INSTANCE, fVar);
        }

        public static C4058x<AndroidConfigFetchProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setReason(ConfigFetchReason configFetchReason) {
            if (configFetchReason != null) {
                this.reason_ = configFetchReason;
                this.bitField0_ |= 1;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
            switch (C30891.f8637xa1df5c61[kVar.ordinal()]) {
                case 1:
                    return new AndroidConfigFetchProto();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((C30891) null);
                case 5:
                    C4023n.C4036l lVar = (C4023n.C4036l) obj;
                    AndroidConfigFetchProto androidConfigFetchProto = (AndroidConfigFetchProto) obj2;
                    this.reason_ = (ConfigFetchReason) lVar.mo28221a(this.reason_, androidConfigFetchProto.reason_);
                    if (lVar == C4023n.C4034j.f10839a) {
                        this.bitField0_ |= androidConfigFetchProto.bitField0_;
                    }
                    return this;
                case 6:
                    C4013g gVar = (C4013g) obj;
                    C4018k kVar2 = (C4018k) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int q = gVar.mo28155q();
                            if (q != 0) {
                                if (q == 10) {
                                    ConfigFetchReason.Builder builder = (this.bitField0_ & 1) == 1 ? (ConfigFetchReason.Builder) this.reason_.toBuilder() : null;
                                    ConfigFetchReason configFetchReason = (ConfigFetchReason) gVar.mo28133a(ConfigFetchReason.parser(), kVar2);
                                    this.reason_ = configFetchReason;
                                    if (builder != null) {
                                        builder.mergeFrom(configFetchReason);
                                        this.reason_ = (ConfigFetchReason) builder.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (!parseUnknownField(q, gVar)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            e.mo28001a(this);
                            throw new RuntimeException(e);
                        } catch (IOException e2) {
                            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e2.getMessage());
                            invalidProtocolBufferException.mo28001a(this);
                            throw new RuntimeException(invalidProtocolBufferException);
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (AndroidConfigFetchProto.class) {
                            if (PARSER == null) {
                                PARSER = new C4023n.C4026c(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        public ConfigFetchReason getReason() {
            ConfigFetchReason configFetchReason = this.reason_;
            return configFetchReason == null ? ConfigFetchReason.getDefaultInstance() : configFetchReason;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.m13123b(1, (C4054u) getReason());
            }
            int b = i2 + this.unknownFields.mo28087b();
            this.memoizedSerializedSize = b;
            return b;
        }

        public boolean hasReason() {
            return (this.bitField0_ & 1) == 1;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.mo27968a(1, (C4054u) getReason());
            }
            this.unknownFields.mo28084a(codedOutputStream);
        }

        public static Builder newBuilder(AndroidConfigFetchProto androidConfigFetchProto) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(androidConfigFetchProto);
        }

        public static AndroidConfigFetchProto parseDelimitedFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (AndroidConfigFetchProto) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        public static AndroidConfigFetchProto parseFrom(C3995f fVar, C4018k kVar) throws InvalidProtocolBufferException {
            return (AndroidConfigFetchProto) C4023n.parseFrom(DEFAULT_INSTANCE, fVar, kVar);
        }

        public static AndroidConfigFetchProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AndroidConfigFetchProto) C4023n.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AndroidConfigFetchProto parseFrom(byte[] bArr, C4018k kVar) throws InvalidProtocolBufferException {
            return (AndroidConfigFetchProto) C4023n.parseFrom(DEFAULT_INSTANCE, bArr, kVar);
        }

        /* access modifiers changed from: private */
        public void setReason(ConfigFetchReason.Builder builder) {
            this.reason_ = (ConfigFetchReason) builder.build();
            this.bitField0_ |= 1;
        }

        public static AndroidConfigFetchProto parseFrom(InputStream inputStream) throws IOException {
            return (AndroidConfigFetchProto) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AndroidConfigFetchProto parseFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (AndroidConfigFetchProto) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        public static AndroidConfigFetchProto parseFrom(C4013g gVar) throws IOException {
            return (AndroidConfigFetchProto) C4023n.parseFrom(DEFAULT_INSTANCE, gVar);
        }

        public static AndroidConfigFetchProto parseFrom(C4013g gVar, C4018k kVar) throws IOException {
            return (AndroidConfigFetchProto) C4023n.parseFrom(DEFAULT_INSTANCE, gVar, kVar);
        }
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public interface AndroidConfigFetchProtoOrBuilder extends C4056v {
        ConfigFetchReason getReason();

        boolean hasReason();
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class ConfigFetchReason extends C4023n<ConfigFetchReason, Builder> implements ConfigFetchReasonOrBuilder {
        /* access modifiers changed from: private */
        public static final ConfigFetchReason DEFAULT_INSTANCE;
        private static volatile C4058x<ConfigFetchReason> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int bitField0_;
        private int type_;

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public enum AndroidConfigFetchType implements C4038p.C4041c {
            UNKNOWN(0),
            SCHEDULED(1),
            BOOT_COMPLETED(2),
            PACKAGE_ADDED(3),
            PACKAGE_REMOVED(4),
            GMS_CORE_UPDATED(5),
            SECRET_CODE(6);
            
            public static final int BOOT_COMPLETED_VALUE = 2;
            public static final int GMS_CORE_UPDATED_VALUE = 5;
            public static final int PACKAGE_ADDED_VALUE = 3;
            public static final int PACKAGE_REMOVED_VALUE = 4;
            public static final int SCHEDULED_VALUE = 1;
            public static final int SECRET_CODE_VALUE = 6;
            public static final int UNKNOWN_VALUE = 0;
            private static final C4038p.C4042d<AndroidConfigFetchType> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new C4038p.C4042d<AndroidConfigFetchType>() {
                    public AndroidConfigFetchType findValueByNumber(int i) {
                        return AndroidConfigFetchType.forNumber(i);
                    }
                };
            }

            private AndroidConfigFetchType(int i) {
                this.value = i;
            }

            public static AndroidConfigFetchType forNumber(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return SCHEDULED;
                    case 2:
                        return BOOT_COMPLETED;
                    case 3:
                        return PACKAGE_ADDED;
                    case 4:
                        return PACKAGE_REMOVED;
                    case 5:
                        return GMS_CORE_UPDATED;
                    case 6:
                        return SECRET_CODE;
                    default:
                        return null;
                }
            }

            public static C4038p.C4042d<AndroidConfigFetchType> internalGetValueMap() {
                return internalValueMap;
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static AndroidConfigFetchType valueOf(int i) {
                return forNumber(i);
            }
        }

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public static final class Builder extends C4023n.C4025b<ConfigFetchReason, Builder> implements ConfigFetchReasonOrBuilder {
            /* synthetic */ Builder(C30891 r1) {
                this();
            }

            public Builder clearType() {
                copyOnWrite();
                ((ConfigFetchReason) this.instance).clearType();
                return this;
            }

            public AndroidConfigFetchType getType() {
                return ((ConfigFetchReason) this.instance).getType();
            }

            public boolean hasType() {
                return ((ConfigFetchReason) this.instance).hasType();
            }

            public Builder setType(AndroidConfigFetchType androidConfigFetchType) {
                copyOnWrite();
                ((ConfigFetchReason) this.instance).setType(androidConfigFetchType);
                return this;
            }

            private Builder() {
                super(ConfigFetchReason.DEFAULT_INSTANCE);
            }
        }

        static {
            ConfigFetchReason configFetchReason = new ConfigFetchReason();
            DEFAULT_INSTANCE = configFetchReason;
            configFetchReason.makeImmutable();
        }

        private ConfigFetchReason() {
        }

        /* access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -2;
            this.type_ = 0;
        }

        public static ConfigFetchReason getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static ConfigFetchReason parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConfigFetchReason) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigFetchReason parseFrom(C3995f fVar) throws InvalidProtocolBufferException {
            return (ConfigFetchReason) C4023n.parseFrom(DEFAULT_INSTANCE, fVar);
        }

        public static C4058x<ConfigFetchReason> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setType(AndroidConfigFetchType androidConfigFetchType) {
            if (androidConfigFetchType != null) {
                this.bitField0_ |= 1;
                this.type_ = androidConfigFetchType.getNumber();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
            switch (C30891.f8637xa1df5c61[kVar.ordinal()]) {
                case 1:
                    return new ConfigFetchReason();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((C30891) null);
                case 5:
                    C4023n.C4036l lVar = (C4023n.C4036l) obj;
                    ConfigFetchReason configFetchReason = (ConfigFetchReason) obj2;
                    this.type_ = lVar.mo28215a(hasType(), this.type_, configFetchReason.hasType(), configFetchReason.type_);
                    if (lVar == C4023n.C4034j.f10839a) {
                        this.bitField0_ |= configFetchReason.bitField0_;
                    }
                    return this;
                case 6:
                    C4013g gVar = (C4013g) obj;
                    C4018k kVar2 = (C4018k) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int q = gVar.mo28155q();
                            if (q != 0) {
                                if (q == 8) {
                                    int d = gVar.mo28140d();
                                    if (AndroidConfigFetchType.forNumber(d) == null) {
                                        super.mergeVarintField(1, d);
                                    } else {
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.type_ = d;
                                    }
                                } else if (!parseUnknownField(q, gVar)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            e.mo28001a(this);
                            throw new RuntimeException(e);
                        } catch (IOException e2) {
                            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e2.getMessage());
                            invalidProtocolBufferException.mo28001a(this);
                            throw new RuntimeException(invalidProtocolBufferException);
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (ConfigFetchReason.class) {
                            if (PARSER == null) {
                                PARSER = new C4023n.C4026c(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.m13134e(1, this.type_);
            }
            int b = i2 + this.unknownFields.mo28087b();
            this.memoizedSerializedSize = b;
            return b;
        }

        public AndroidConfigFetchType getType() {
            AndroidConfigFetchType forNumber = AndroidConfigFetchType.forNumber(this.type_);
            return forNumber == null ? AndroidConfigFetchType.UNKNOWN : forNumber;
        }

        public boolean hasType() {
            return (this.bitField0_ & 1) == 1;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.mo27965a(1, this.type_);
            }
            this.unknownFields.mo28084a(codedOutputStream);
        }

        public static Builder newBuilder(ConfigFetchReason configFetchReason) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(configFetchReason);
        }

        public static ConfigFetchReason parseDelimitedFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (ConfigFetchReason) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        public static ConfigFetchReason parseFrom(C3995f fVar, C4018k kVar) throws InvalidProtocolBufferException {
            return (ConfigFetchReason) C4023n.parseFrom(DEFAULT_INSTANCE, fVar, kVar);
        }

        public static ConfigFetchReason parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ConfigFetchReason) C4023n.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ConfigFetchReason parseFrom(byte[] bArr, C4018k kVar) throws InvalidProtocolBufferException {
            return (ConfigFetchReason) C4023n.parseFrom(DEFAULT_INSTANCE, bArr, kVar);
        }

        public static ConfigFetchReason parseFrom(InputStream inputStream) throws IOException {
            return (ConfigFetchReason) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigFetchReason parseFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (ConfigFetchReason) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        public static ConfigFetchReason parseFrom(C4013g gVar) throws IOException {
            return (ConfigFetchReason) C4023n.parseFrom(DEFAULT_INSTANCE, gVar);
        }

        public static ConfigFetchReason parseFrom(C4013g gVar, C4018k kVar) throws IOException {
            return (ConfigFetchReason) C4023n.parseFrom(DEFAULT_INSTANCE, gVar, kVar);
        }
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public interface ConfigFetchReasonOrBuilder extends C4056v {
        ConfigFetchReason.AndroidConfigFetchType getType();

        boolean hasType();
    }

    private Logs() {
    }

    public static void registerAllExtensions(C4018k kVar) {
    }
}
