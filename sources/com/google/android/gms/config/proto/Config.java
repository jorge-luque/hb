package com.google.android.gms.config.proto;

import com.facebook.internal.Utility;
import com.google.android.gms.config.proto.Logs;
import com.google.protobuf.C3969a;
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
import com.ogury.p159cm.OguryChoiceManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public final class Config {

    /* renamed from: com.google.android.gms.config.proto.Config$1 */
    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    static /* synthetic */ class C30861 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f8636xa1df5c61;

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
                f8636xa1df5c61 = r0
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8636xa1df5c61     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8636xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.MAKE_IMMUTABLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8636xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8636xa1df5c61     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.VISIT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8636xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.MERGE_FROM_STREAM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8636xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f8636xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.n$k r1 = com.google.protobuf.C4023n.C4035k.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.config.proto.Config.C30861.<clinit>():void");
        }
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class AppConfigTable extends C4023n<AppConfigTable, Builder> implements AppConfigTableOrBuilder {
        public static final int APP_NAME_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final AppConfigTable DEFAULT_INSTANCE;
        public static final int EXPERIMENT_PAYLOAD_FIELD_NUMBER = 3;
        public static final int NAMESPACE_CONFIG_FIELD_NUMBER = 2;
        private static volatile C4058x<AppConfigTable> PARSER;
        private String appName_ = "";
        private int bitField0_;
        private C4038p.C4046h<C3995f> experimentPayload_ = C4023n.emptyProtobufList();
        private C4038p.C4046h<AppNamespaceConfigTable> namespaceConfig_ = C4023n.emptyProtobufList();

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public static final class Builder extends C4023n.C4025b<AppConfigTable, Builder> implements AppConfigTableOrBuilder {
            /* synthetic */ Builder(C30861 r1) {
                this();
            }

            public Builder addAllExperimentPayload(Iterable<? extends C3995f> iterable) {
                copyOnWrite();
                ((AppConfigTable) this.instance).addAllExperimentPayload(iterable);
                return this;
            }

            public Builder addAllNamespaceConfig(Iterable<? extends AppNamespaceConfigTable> iterable) {
                copyOnWrite();
                ((AppConfigTable) this.instance).addAllNamespaceConfig(iterable);
                return this;
            }

            public Builder addExperimentPayload(C3995f fVar) {
                copyOnWrite();
                ((AppConfigTable) this.instance).addExperimentPayload(fVar);
                return this;
            }

            public Builder addNamespaceConfig(AppNamespaceConfigTable appNamespaceConfigTable) {
                copyOnWrite();
                ((AppConfigTable) this.instance).addNamespaceConfig(appNamespaceConfigTable);
                return this;
            }

            public Builder clearAppName() {
                copyOnWrite();
                ((AppConfigTable) this.instance).clearAppName();
                return this;
            }

            public Builder clearExperimentPayload() {
                copyOnWrite();
                ((AppConfigTable) this.instance).clearExperimentPayload();
                return this;
            }

            public Builder clearNamespaceConfig() {
                copyOnWrite();
                ((AppConfigTable) this.instance).clearNamespaceConfig();
                return this;
            }

            public String getAppName() {
                return ((AppConfigTable) this.instance).getAppName();
            }

            public C3995f getAppNameBytes() {
                return ((AppConfigTable) this.instance).getAppNameBytes();
            }

            public C3995f getExperimentPayload(int i) {
                return ((AppConfigTable) this.instance).getExperimentPayload(i);
            }

            public int getExperimentPayloadCount() {
                return ((AppConfigTable) this.instance).getExperimentPayloadCount();
            }

            public List<C3995f> getExperimentPayloadList() {
                return Collections.unmodifiableList(((AppConfigTable) this.instance).getExperimentPayloadList());
            }

            public AppNamespaceConfigTable getNamespaceConfig(int i) {
                return ((AppConfigTable) this.instance).getNamespaceConfig(i);
            }

            public int getNamespaceConfigCount() {
                return ((AppConfigTable) this.instance).getNamespaceConfigCount();
            }

            public List<AppNamespaceConfigTable> getNamespaceConfigList() {
                return Collections.unmodifiableList(((AppConfigTable) this.instance).getNamespaceConfigList());
            }

            public boolean hasAppName() {
                return ((AppConfigTable) this.instance).hasAppName();
            }

            public Builder removeNamespaceConfig(int i) {
                copyOnWrite();
                ((AppConfigTable) this.instance).removeNamespaceConfig(i);
                return this;
            }

            public Builder setAppName(String str) {
                copyOnWrite();
                ((AppConfigTable) this.instance).setAppName(str);
                return this;
            }

            public Builder setAppNameBytes(C3995f fVar) {
                copyOnWrite();
                ((AppConfigTable) this.instance).setAppNameBytes(fVar);
                return this;
            }

            public Builder setExperimentPayload(int i, C3995f fVar) {
                copyOnWrite();
                ((AppConfigTable) this.instance).setExperimentPayload(i, fVar);
                return this;
            }

            public Builder setNamespaceConfig(int i, AppNamespaceConfigTable appNamespaceConfigTable) {
                copyOnWrite();
                ((AppConfigTable) this.instance).setNamespaceConfig(i, appNamespaceConfigTable);
                return this;
            }

            private Builder() {
                super(AppConfigTable.DEFAULT_INSTANCE);
            }

            public Builder addNamespaceConfig(int i, AppNamespaceConfigTable appNamespaceConfigTable) {
                copyOnWrite();
                ((AppConfigTable) this.instance).addNamespaceConfig(i, appNamespaceConfigTable);
                return this;
            }

            public Builder setNamespaceConfig(int i, AppNamespaceConfigTable.Builder builder) {
                copyOnWrite();
                ((AppConfigTable) this.instance).setNamespaceConfig(i, builder);
                return this;
            }

            public Builder addNamespaceConfig(AppNamespaceConfigTable.Builder builder) {
                copyOnWrite();
                ((AppConfigTable) this.instance).addNamespaceConfig(builder);
                return this;
            }

            public Builder addNamespaceConfig(int i, AppNamespaceConfigTable.Builder builder) {
                copyOnWrite();
                ((AppConfigTable) this.instance).addNamespaceConfig(i, builder);
                return this;
            }
        }

        static {
            AppConfigTable appConfigTable = new AppConfigTable();
            DEFAULT_INSTANCE = appConfigTable;
            appConfigTable.makeImmutable();
        }

        private AppConfigTable() {
        }

        /* access modifiers changed from: private */
        public void addAllExperimentPayload(Iterable<? extends C3995f> iterable) {
            ensureExperimentPayloadIsMutable();
            C3969a.addAll(iterable, this.experimentPayload_);
        }

        /* access modifiers changed from: private */
        public void addAllNamespaceConfig(Iterable<? extends AppNamespaceConfigTable> iterable) {
            ensureNamespaceConfigIsMutable();
            C3969a.addAll(iterable, this.namespaceConfig_);
        }

        /* access modifiers changed from: private */
        public void addExperimentPayload(C3995f fVar) {
            if (fVar != null) {
                ensureExperimentPayloadIsMutable();
                this.experimentPayload_.add(fVar);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addNamespaceConfig(AppNamespaceConfigTable appNamespaceConfigTable) {
            if (appNamespaceConfigTable != null) {
                ensureNamespaceConfigIsMutable();
                this.namespaceConfig_.add(appNamespaceConfigTable);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearAppName() {
            this.bitField0_ &= -2;
            this.appName_ = getDefaultInstance().getAppName();
        }

        /* access modifiers changed from: private */
        public void clearExperimentPayload() {
            this.experimentPayload_ = C4023n.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearNamespaceConfig() {
            this.namespaceConfig_ = C4023n.emptyProtobufList();
        }

        private void ensureExperimentPayloadIsMutable() {
            if (!this.experimentPayload_.mo28080v()) {
                this.experimentPayload_ = C4023n.mutableCopy(this.experimentPayload_);
            }
        }

        private void ensureNamespaceConfigIsMutable() {
            if (!this.namespaceConfig_.mo28080v()) {
                this.namespaceConfig_ = C4023n.mutableCopy(this.namespaceConfig_);
            }
        }

        public static AppConfigTable getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static AppConfigTable parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AppConfigTable) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppConfigTable parseFrom(C3995f fVar) throws InvalidProtocolBufferException {
            return (AppConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, fVar);
        }

        public static C4058x<AppConfigTable> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void removeNamespaceConfig(int i) {
            ensureNamespaceConfigIsMutable();
            this.namespaceConfig_.remove(i);
        }

        /* access modifiers changed from: private */
        public void setAppName(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.appName_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setAppNameBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 1;
                this.appName_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setExperimentPayload(int i, C3995f fVar) {
            if (fVar != null) {
                ensureExperimentPayloadIsMutable();
                this.experimentPayload_.set(i, fVar);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setNamespaceConfig(int i, AppNamespaceConfigTable appNamespaceConfigTable) {
            if (appNamespaceConfigTable != null) {
                ensureNamespaceConfigIsMutable();
                this.namespaceConfig_.set(i, appNamespaceConfigTable);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
            switch (C30861.f8636xa1df5c61[kVar.ordinal()]) {
                case 1:
                    return new AppConfigTable();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.namespaceConfig_.mo28079t();
                    this.experimentPayload_.mo28079t();
                    return null;
                case 4:
                    return new Builder((C30861) null);
                case 5:
                    C4023n.C4036l lVar = (C4023n.C4036l) obj;
                    AppConfigTable appConfigTable = (AppConfigTable) obj2;
                    this.appName_ = lVar.mo28222a(hasAppName(), this.appName_, appConfigTable.hasAppName(), appConfigTable.appName_);
                    this.namespaceConfig_ = lVar.mo28220a(this.namespaceConfig_, appConfigTable.namespaceConfig_);
                    this.experimentPayload_ = lVar.mo28220a(this.experimentPayload_, appConfigTable.experimentPayload_);
                    if (lVar == C4023n.C4034j.f10839a) {
                        this.bitField0_ |= appConfigTable.bitField0_;
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
                                    String o = gVar.mo28153o();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.appName_ = o;
                                } else if (q == 18) {
                                    if (!this.namespaceConfig_.mo28080v()) {
                                        this.namespaceConfig_ = C4023n.mutableCopy(this.namespaceConfig_);
                                    }
                                    this.namespaceConfig_.add((AppNamespaceConfigTable) gVar.mo28133a(AppNamespaceConfigTable.parser(), kVar2));
                                } else if (q == 26) {
                                    if (!this.experimentPayload_.mo28080v()) {
                                        this.experimentPayload_ = C4023n.mutableCopy(this.experimentPayload_);
                                    }
                                    this.experimentPayload_.add(gVar.mo28139c());
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
                        synchronized (AppConfigTable.class) {
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

        public String getAppName() {
            return this.appName_;
        }

        public C3995f getAppNameBytes() {
            return C3995f.m13320a(this.appName_);
        }

        public C3995f getExperimentPayload(int i) {
            return this.experimentPayload_.get(i);
        }

        public int getExperimentPayloadCount() {
            return this.experimentPayload_.size();
        }

        public List<C3995f> getExperimentPayloadList() {
            return this.experimentPayload_;
        }

        public AppNamespaceConfigTable getNamespaceConfig(int i) {
            return this.namespaceConfig_.get(i);
        }

        public int getNamespaceConfigCount() {
            return this.namespaceConfig_.size();
        }

        public List<AppNamespaceConfigTable> getNamespaceConfigList() {
            return this.namespaceConfig_;
        }

        public AppNamespaceConfigTableOrBuilder getNamespaceConfigOrBuilder(int i) {
            return this.namespaceConfig_.get(i);
        }

        public List<? extends AppNamespaceConfigTableOrBuilder> getNamespaceConfigOrBuilderList() {
            return this.namespaceConfig_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int b = (this.bitField0_ & 1) == 1 ? CodedOutputStream.m13124b(1, getAppName()) + 0 : 0;
            for (int i2 = 0; i2 < this.namespaceConfig_.size(); i2++) {
                b += CodedOutputStream.m13123b(2, (C4054u) this.namespaceConfig_.get(i2));
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.experimentPayload_.size(); i4++) {
                i3 += CodedOutputStream.m13116a(this.experimentPayload_.get(i4));
            }
            int size = b + i3 + (getExperimentPayloadList().size() * 1) + this.unknownFields.mo28087b();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasAppName() {
            return (this.bitField0_ & 1) == 1;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.mo27969a(1, getAppName());
            }
            for (int i = 0; i < this.namespaceConfig_.size(); i++) {
                codedOutputStream.mo27968a(2, (C4054u) this.namespaceConfig_.get(i));
            }
            for (int i2 = 0; i2 < this.experimentPayload_.size(); i2++) {
                codedOutputStream.mo27967a(3, this.experimentPayload_.get(i2));
            }
            this.unknownFields.mo28084a(codedOutputStream);
        }

        public static Builder newBuilder(AppConfigTable appConfigTable) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(appConfigTable);
        }

        public static AppConfigTable parseDelimitedFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (AppConfigTable) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        public static AppConfigTable parseFrom(C3995f fVar, C4018k kVar) throws InvalidProtocolBufferException {
            return (AppConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, fVar, kVar);
        }

        public static AppConfigTable parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AppConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* access modifiers changed from: private */
        public void addNamespaceConfig(int i, AppNamespaceConfigTable appNamespaceConfigTable) {
            if (appNamespaceConfigTable != null) {
                ensureNamespaceConfigIsMutable();
                this.namespaceConfig_.add(i, appNamespaceConfigTable);
                return;
            }
            throw null;
        }

        public static AppConfigTable parseFrom(byte[] bArr, C4018k kVar) throws InvalidProtocolBufferException {
            return (AppConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, bArr, kVar);
        }

        /* access modifiers changed from: private */
        public void setNamespaceConfig(int i, AppNamespaceConfigTable.Builder builder) {
            ensureNamespaceConfigIsMutable();
            this.namespaceConfig_.set(i, (AppNamespaceConfigTable) builder.build());
        }

        public static AppConfigTable parseFrom(InputStream inputStream) throws IOException {
            return (AppConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppConfigTable parseFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (AppConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        /* access modifiers changed from: private */
        public void addNamespaceConfig(AppNamespaceConfigTable.Builder builder) {
            ensureNamespaceConfigIsMutable();
            this.namespaceConfig_.add((AppNamespaceConfigTable) builder.build());
        }

        public static AppConfigTable parseFrom(C4013g gVar) throws IOException {
            return (AppConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, gVar);
        }

        public static AppConfigTable parseFrom(C4013g gVar, C4018k kVar) throws IOException {
            return (AppConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, gVar, kVar);
        }

        /* access modifiers changed from: private */
        public void addNamespaceConfig(int i, AppNamespaceConfigTable.Builder builder) {
            ensureNamespaceConfigIsMutable();
            this.namespaceConfig_.add(i, (AppNamespaceConfigTable) builder.build());
        }
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public interface AppConfigTableOrBuilder extends C4056v {
        String getAppName();

        C3995f getAppNameBytes();

        C3995f getExperimentPayload(int i);

        int getExperimentPayloadCount();

        List<C3995f> getExperimentPayloadList();

        AppNamespaceConfigTable getNamespaceConfig(int i);

        int getNamespaceConfigCount();

        List<AppNamespaceConfigTable> getNamespaceConfigList();

        boolean hasAppName();
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class AppNamespaceConfigTable extends C4023n<AppNamespaceConfigTable, Builder> implements AppNamespaceConfigTableOrBuilder {
        /* access modifiers changed from: private */
        public static final AppNamespaceConfigTable DEFAULT_INSTANCE;
        public static final int DIGEST_FIELD_NUMBER = 2;
        public static final int ENTRY_FIELD_NUMBER = 3;
        public static final int NAMESPACE_FIELD_NUMBER = 1;
        private static volatile C4058x<AppNamespaceConfigTable> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 4;
        private int bitField0_;
        private String digest_ = "";
        private C4038p.C4046h<KeyValue> entry_ = C4023n.emptyProtobufList();
        private String namespace_ = "";
        private int status_;

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public static final class Builder extends C4023n.C4025b<AppNamespaceConfigTable, Builder> implements AppNamespaceConfigTableOrBuilder {
            /* synthetic */ Builder(C30861 r1) {
                this();
            }

            public Builder addAllEntry(Iterable<? extends KeyValue> iterable) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).addAllEntry(iterable);
                return this;
            }

            public Builder addEntry(KeyValue keyValue) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).addEntry(keyValue);
                return this;
            }

            public Builder clearDigest() {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).clearDigest();
                return this;
            }

            public Builder clearEntry() {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).clearEntry();
                return this;
            }

            public Builder clearNamespace() {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).clearNamespace();
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).clearStatus();
                return this;
            }

            public String getDigest() {
                return ((AppNamespaceConfigTable) this.instance).getDigest();
            }

            public C3995f getDigestBytes() {
                return ((AppNamespaceConfigTable) this.instance).getDigestBytes();
            }

            public KeyValue getEntry(int i) {
                return ((AppNamespaceConfigTable) this.instance).getEntry(i);
            }

            public int getEntryCount() {
                return ((AppNamespaceConfigTable) this.instance).getEntryCount();
            }

            public List<KeyValue> getEntryList() {
                return Collections.unmodifiableList(((AppNamespaceConfigTable) this.instance).getEntryList());
            }

            public String getNamespace() {
                return ((AppNamespaceConfigTable) this.instance).getNamespace();
            }

            public C3995f getNamespaceBytes() {
                return ((AppNamespaceConfigTable) this.instance).getNamespaceBytes();
            }

            public NamespaceStatus getStatus() {
                return ((AppNamespaceConfigTable) this.instance).getStatus();
            }

            public boolean hasDigest() {
                return ((AppNamespaceConfigTable) this.instance).hasDigest();
            }

            public boolean hasNamespace() {
                return ((AppNamespaceConfigTable) this.instance).hasNamespace();
            }

            public boolean hasStatus() {
                return ((AppNamespaceConfigTable) this.instance).hasStatus();
            }

            public Builder removeEntry(int i) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).removeEntry(i);
                return this;
            }

            public Builder setDigest(String str) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).setDigest(str);
                return this;
            }

            public Builder setDigestBytes(C3995f fVar) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).setDigestBytes(fVar);
                return this;
            }

            public Builder setEntry(int i, KeyValue keyValue) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).setEntry(i, keyValue);
                return this;
            }

            public Builder setNamespace(String str) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).setNamespace(str);
                return this;
            }

            public Builder setNamespaceBytes(C3995f fVar) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).setNamespaceBytes(fVar);
                return this;
            }

            public Builder setStatus(NamespaceStatus namespaceStatus) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).setStatus(namespaceStatus);
                return this;
            }

            private Builder() {
                super(AppNamespaceConfigTable.DEFAULT_INSTANCE);
            }

            public Builder addEntry(int i, KeyValue keyValue) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).addEntry(i, keyValue);
                return this;
            }

            public Builder setEntry(int i, KeyValue.Builder builder) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).setEntry(i, builder);
                return this;
            }

            public Builder addEntry(KeyValue.Builder builder) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).addEntry(builder);
                return this;
            }

            public Builder addEntry(int i, KeyValue.Builder builder) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).addEntry(i, builder);
                return this;
            }
        }

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public enum NamespaceStatus implements C4038p.C4041c {
            UPDATE(0),
            NO_TEMPLATE(1),
            NO_CHANGE(2),
            EMPTY_CONFIG(3),
            NOT_AUTHORIZED(4);
            
            public static final int EMPTY_CONFIG_VALUE = 3;
            public static final int NOT_AUTHORIZED_VALUE = 4;
            public static final int NO_CHANGE_VALUE = 2;
            public static final int NO_TEMPLATE_VALUE = 1;
            public static final int UPDATE_VALUE = 0;
            private static final C4038p.C4042d<NamespaceStatus> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new C4038p.C4042d<NamespaceStatus>() {
                    public NamespaceStatus findValueByNumber(int i) {
                        return NamespaceStatus.forNumber(i);
                    }
                };
            }

            private NamespaceStatus(int i) {
                this.value = i;
            }

            public static NamespaceStatus forNumber(int i) {
                if (i == 0) {
                    return UPDATE;
                }
                if (i == 1) {
                    return NO_TEMPLATE;
                }
                if (i == 2) {
                    return NO_CHANGE;
                }
                if (i == 3) {
                    return EMPTY_CONFIG;
                }
                if (i != 4) {
                    return null;
                }
                return NOT_AUTHORIZED;
            }

            public static C4038p.C4042d<NamespaceStatus> internalGetValueMap() {
                return internalValueMap;
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static NamespaceStatus valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            AppNamespaceConfigTable appNamespaceConfigTable = new AppNamespaceConfigTable();
            DEFAULT_INSTANCE = appNamespaceConfigTable;
            appNamespaceConfigTable.makeImmutable();
        }

        private AppNamespaceConfigTable() {
        }

        /* access modifiers changed from: private */
        public void addAllEntry(Iterable<? extends KeyValue> iterable) {
            ensureEntryIsMutable();
            C3969a.addAll(iterable, this.entry_);
        }

        /* access modifiers changed from: private */
        public void addEntry(KeyValue keyValue) {
            if (keyValue != null) {
                ensureEntryIsMutable();
                this.entry_.add(keyValue);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearDigest() {
            this.bitField0_ &= -3;
            this.digest_ = getDefaultInstance().getDigest();
        }

        /* access modifiers changed from: private */
        public void clearEntry() {
            this.entry_ = C4023n.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearNamespace() {
            this.bitField0_ &= -2;
            this.namespace_ = getDefaultInstance().getNamespace();
        }

        /* access modifiers changed from: private */
        public void clearStatus() {
            this.bitField0_ &= -5;
            this.status_ = 0;
        }

        private void ensureEntryIsMutable() {
            if (!this.entry_.mo28080v()) {
                this.entry_ = C4023n.mutableCopy(this.entry_);
            }
        }

        public static AppNamespaceConfigTable getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static AppNamespaceConfigTable parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AppNamespaceConfigTable) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppNamespaceConfigTable parseFrom(C3995f fVar) throws InvalidProtocolBufferException {
            return (AppNamespaceConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, fVar);
        }

        public static C4058x<AppNamespaceConfigTable> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void removeEntry(int i) {
            ensureEntryIsMutable();
            this.entry_.remove(i);
        }

        /* access modifiers changed from: private */
        public void setDigest(String str) {
            if (str != null) {
                this.bitField0_ |= 2;
                this.digest_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setDigestBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 2;
                this.digest_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setEntry(int i, KeyValue keyValue) {
            if (keyValue != null) {
                ensureEntryIsMutable();
                this.entry_.set(i, keyValue);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setNamespace(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.namespace_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setNamespaceBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 1;
                this.namespace_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setStatus(NamespaceStatus namespaceStatus) {
            if (namespaceStatus != null) {
                this.bitField0_ |= 4;
                this.status_ = namespaceStatus.getNumber();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
            switch (C30861.f8636xa1df5c61[kVar.ordinal()]) {
                case 1:
                    return new AppNamespaceConfigTable();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.entry_.mo28079t();
                    return null;
                case 4:
                    return new Builder((C30861) null);
                case 5:
                    C4023n.C4036l lVar = (C4023n.C4036l) obj;
                    AppNamespaceConfigTable appNamespaceConfigTable = (AppNamespaceConfigTable) obj2;
                    this.namespace_ = lVar.mo28222a(hasNamespace(), this.namespace_, appNamespaceConfigTable.hasNamespace(), appNamespaceConfigTable.namespace_);
                    this.digest_ = lVar.mo28222a(hasDigest(), this.digest_, appNamespaceConfigTable.hasDigest(), appNamespaceConfigTable.digest_);
                    this.entry_ = lVar.mo28220a(this.entry_, appNamespaceConfigTable.entry_);
                    this.status_ = lVar.mo28215a(hasStatus(), this.status_, appNamespaceConfigTable.hasStatus(), appNamespaceConfigTable.status_);
                    if (lVar == C4023n.C4034j.f10839a) {
                        this.bitField0_ |= appNamespaceConfigTable.bitField0_;
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
                                    String o = gVar.mo28153o();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.namespace_ = o;
                                } else if (q == 18) {
                                    String o2 = gVar.mo28153o();
                                    this.bitField0_ |= 2;
                                    this.digest_ = o2;
                                } else if (q == 26) {
                                    if (!this.entry_.mo28080v()) {
                                        this.entry_ = C4023n.mutableCopy(this.entry_);
                                    }
                                    this.entry_.add((KeyValue) gVar.mo28133a(KeyValue.parser(), kVar2));
                                } else if (q == 32) {
                                    int d = gVar.mo28140d();
                                    if (NamespaceStatus.forNumber(d) == null) {
                                        super.mergeVarintField(4, d);
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.status_ = d;
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
                        synchronized (AppNamespaceConfigTable.class) {
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

        public String getDigest() {
            return this.digest_;
        }

        public C3995f getDigestBytes() {
            return C3995f.m13320a(this.digest_);
        }

        public KeyValue getEntry(int i) {
            return this.entry_.get(i);
        }

        public int getEntryCount() {
            return this.entry_.size();
        }

        public List<KeyValue> getEntryList() {
            return this.entry_;
        }

        public KeyValueOrBuilder getEntryOrBuilder(int i) {
            return this.entry_.get(i);
        }

        public List<? extends KeyValueOrBuilder> getEntryOrBuilderList() {
            return this.entry_;
        }

        public String getNamespace() {
            return this.namespace_;
        }

        public C3995f getNamespaceBytes() {
            return C3995f.m13320a(this.namespace_);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int b = (this.bitField0_ & 1) == 1 ? CodedOutputStream.m13124b(1, getNamespace()) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                b += CodedOutputStream.m13124b(2, getDigest());
            }
            for (int i2 = 0; i2 < this.entry_.size(); i2++) {
                b += CodedOutputStream.m13123b(3, (C4054u) this.entry_.get(i2));
            }
            if ((this.bitField0_ & 4) == 4) {
                b += CodedOutputStream.m13134e(4, this.status_);
            }
            int b2 = b + this.unknownFields.mo28087b();
            this.memoizedSerializedSize = b2;
            return b2;
        }

        public NamespaceStatus getStatus() {
            NamespaceStatus forNumber = NamespaceStatus.forNumber(this.status_);
            return forNumber == null ? NamespaceStatus.UPDATE : forNumber;
        }

        public boolean hasDigest() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasNamespace() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasStatus() {
            return (this.bitField0_ & 4) == 4;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.mo27969a(1, getNamespace());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.mo27969a(2, getDigest());
            }
            for (int i = 0; i < this.entry_.size(); i++) {
                codedOutputStream.mo27968a(3, (C4054u) this.entry_.get(i));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.mo27965a(4, this.status_);
            }
            this.unknownFields.mo28084a(codedOutputStream);
        }

        public static Builder newBuilder(AppNamespaceConfigTable appNamespaceConfigTable) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(appNamespaceConfigTable);
        }

        public static AppNamespaceConfigTable parseDelimitedFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (AppNamespaceConfigTable) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        public static AppNamespaceConfigTable parseFrom(C3995f fVar, C4018k kVar) throws InvalidProtocolBufferException {
            return (AppNamespaceConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, fVar, kVar);
        }

        public static AppNamespaceConfigTable parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AppNamespaceConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* access modifiers changed from: private */
        public void addEntry(int i, KeyValue keyValue) {
            if (keyValue != null) {
                ensureEntryIsMutable();
                this.entry_.add(i, keyValue);
                return;
            }
            throw null;
        }

        public static AppNamespaceConfigTable parseFrom(byte[] bArr, C4018k kVar) throws InvalidProtocolBufferException {
            return (AppNamespaceConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, bArr, kVar);
        }

        /* access modifiers changed from: private */
        public void setEntry(int i, KeyValue.Builder builder) {
            ensureEntryIsMutable();
            this.entry_.set(i, (KeyValue) builder.build());
        }

        public static AppNamespaceConfigTable parseFrom(InputStream inputStream) throws IOException {
            return (AppNamespaceConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppNamespaceConfigTable parseFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (AppNamespaceConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        /* access modifiers changed from: private */
        public void addEntry(KeyValue.Builder builder) {
            ensureEntryIsMutable();
            this.entry_.add((KeyValue) builder.build());
        }

        public static AppNamespaceConfigTable parseFrom(C4013g gVar) throws IOException {
            return (AppNamespaceConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, gVar);
        }

        public static AppNamespaceConfigTable parseFrom(C4013g gVar, C4018k kVar) throws IOException {
            return (AppNamespaceConfigTable) C4023n.parseFrom(DEFAULT_INSTANCE, gVar, kVar);
        }

        /* access modifiers changed from: private */
        public void addEntry(int i, KeyValue.Builder builder) {
            ensureEntryIsMutable();
            this.entry_.add(i, (KeyValue) builder.build());
        }
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public interface AppNamespaceConfigTableOrBuilder extends C4056v {
        String getDigest();

        C3995f getDigestBytes();

        KeyValue getEntry(int i);

        int getEntryCount();

        List<KeyValue> getEntryList();

        String getNamespace();

        C3995f getNamespaceBytes();

        AppNamespaceConfigTable.NamespaceStatus getStatus();

        boolean hasDigest();

        boolean hasNamespace();

        boolean hasStatus();
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class ConfigFetchRequest extends C4023n<ConfigFetchRequest, Builder> implements ConfigFetchRequestOrBuilder {
        public static final int ANDROID_ID_FIELD_NUMBER = 1;
        public static final int API_LEVEL_FIELD_NUMBER = 8;
        public static final int CLIENT_VERSION_FIELD_NUMBER = 6;
        public static final int CONFIG_FIELD_NUMBER = 5;
        /* access modifiers changed from: private */
        public static final ConfigFetchRequest DEFAULT_INSTANCE;
        public static final int DEVICE_COUNTRY_FIELD_NUMBER = 9;
        public static final int DEVICE_DATA_VERSION_INFO_FIELD_NUMBER = 3;
        public static final int DEVICE_LOCALE_FIELD_NUMBER = 10;
        public static final int DEVICE_SUBTYPE_FIELD_NUMBER = 12;
        public static final int DEVICE_TIMEZONE_ID_FIELD_NUMBER = 14;
        public static final int DEVICE_TYPE_FIELD_NUMBER = 11;
        public static final int GMS_CORE_VERSION_FIELD_NUMBER = 7;
        public static final int OS_VERSION_FIELD_NUMBER = 13;
        public static final int PACKAGE_DATA_FIELD_NUMBER = 2;
        private static volatile C4058x<ConfigFetchRequest> PARSER = null;
        public static final int SECURITY_TOKEN_FIELD_NUMBER = 4;
        private long androidId_;
        private int apiLevel_;
        private int bitField0_;
        private int clientVersion_;
        private Logs.AndroidConfigFetchProto config_;
        private String deviceCountry_ = "";
        private String deviceDataVersionInfo_ = "";
        private String deviceLocale_ = "";
        private int deviceSubtype_;
        private String deviceTimezoneId_ = "";
        private int deviceType_;
        private int gmsCoreVersion_;
        private String osVersion_ = "";
        private C4038p.C4046h<PackageData> packageData_ = C4023n.emptyProtobufList();
        private long securityToken_;

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public static final class Builder extends C4023n.C4025b<ConfigFetchRequest, Builder> implements ConfigFetchRequestOrBuilder {
            /* synthetic */ Builder(C30861 r1) {
                this();
            }

            public Builder addAllPackageData(Iterable<? extends PackageData> iterable) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).addAllPackageData(iterable);
                return this;
            }

            public Builder addPackageData(PackageData packageData) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).addPackageData(packageData);
                return this;
            }

            public Builder clearAndroidId() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).clearAndroidId();
                return this;
            }

            public Builder clearApiLevel() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).clearApiLevel();
                return this;
            }

            public Builder clearClientVersion() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).clearClientVersion();
                return this;
            }

            public Builder clearConfig() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).clearConfig();
                return this;
            }

            public Builder clearDeviceCountry() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).clearDeviceCountry();
                return this;
            }

            public Builder clearDeviceDataVersionInfo() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).clearDeviceDataVersionInfo();
                return this;
            }

            public Builder clearDeviceLocale() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).clearDeviceLocale();
                return this;
            }

            public Builder clearDeviceSubtype() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).clearDeviceSubtype();
                return this;
            }

            public Builder clearDeviceTimezoneId() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).clearDeviceTimezoneId();
                return this;
            }

            public Builder clearDeviceType() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).clearDeviceType();
                return this;
            }

            public Builder clearGmsCoreVersion() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).clearGmsCoreVersion();
                return this;
            }

            public Builder clearOsVersion() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).clearOsVersion();
                return this;
            }

            public Builder clearPackageData() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).clearPackageData();
                return this;
            }

            public Builder clearSecurityToken() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).clearSecurityToken();
                return this;
            }

            public long getAndroidId() {
                return ((ConfigFetchRequest) this.instance).getAndroidId();
            }

            public int getApiLevel() {
                return ((ConfigFetchRequest) this.instance).getApiLevel();
            }

            public int getClientVersion() {
                return ((ConfigFetchRequest) this.instance).getClientVersion();
            }

            public Logs.AndroidConfigFetchProto getConfig() {
                return ((ConfigFetchRequest) this.instance).getConfig();
            }

            public String getDeviceCountry() {
                return ((ConfigFetchRequest) this.instance).getDeviceCountry();
            }

            public C3995f getDeviceCountryBytes() {
                return ((ConfigFetchRequest) this.instance).getDeviceCountryBytes();
            }

            public String getDeviceDataVersionInfo() {
                return ((ConfigFetchRequest) this.instance).getDeviceDataVersionInfo();
            }

            public C3995f getDeviceDataVersionInfoBytes() {
                return ((ConfigFetchRequest) this.instance).getDeviceDataVersionInfoBytes();
            }

            public String getDeviceLocale() {
                return ((ConfigFetchRequest) this.instance).getDeviceLocale();
            }

            public C3995f getDeviceLocaleBytes() {
                return ((ConfigFetchRequest) this.instance).getDeviceLocaleBytes();
            }

            public int getDeviceSubtype() {
                return ((ConfigFetchRequest) this.instance).getDeviceSubtype();
            }

            public String getDeviceTimezoneId() {
                return ((ConfigFetchRequest) this.instance).getDeviceTimezoneId();
            }

            public C3995f getDeviceTimezoneIdBytes() {
                return ((ConfigFetchRequest) this.instance).getDeviceTimezoneIdBytes();
            }

            public int getDeviceType() {
                return ((ConfigFetchRequest) this.instance).getDeviceType();
            }

            public int getGmsCoreVersion() {
                return ((ConfigFetchRequest) this.instance).getGmsCoreVersion();
            }

            public String getOsVersion() {
                return ((ConfigFetchRequest) this.instance).getOsVersion();
            }

            public C3995f getOsVersionBytes() {
                return ((ConfigFetchRequest) this.instance).getOsVersionBytes();
            }

            public PackageData getPackageData(int i) {
                return ((ConfigFetchRequest) this.instance).getPackageData(i);
            }

            public int getPackageDataCount() {
                return ((ConfigFetchRequest) this.instance).getPackageDataCount();
            }

            public List<PackageData> getPackageDataList() {
                return Collections.unmodifiableList(((ConfigFetchRequest) this.instance).getPackageDataList());
            }

            public long getSecurityToken() {
                return ((ConfigFetchRequest) this.instance).getSecurityToken();
            }

            public boolean hasAndroidId() {
                return ((ConfigFetchRequest) this.instance).hasAndroidId();
            }

            public boolean hasApiLevel() {
                return ((ConfigFetchRequest) this.instance).hasApiLevel();
            }

            public boolean hasClientVersion() {
                return ((ConfigFetchRequest) this.instance).hasClientVersion();
            }

            public boolean hasConfig() {
                return ((ConfigFetchRequest) this.instance).hasConfig();
            }

            public boolean hasDeviceCountry() {
                return ((ConfigFetchRequest) this.instance).hasDeviceCountry();
            }

            public boolean hasDeviceDataVersionInfo() {
                return ((ConfigFetchRequest) this.instance).hasDeviceDataVersionInfo();
            }

            public boolean hasDeviceLocale() {
                return ((ConfigFetchRequest) this.instance).hasDeviceLocale();
            }

            public boolean hasDeviceSubtype() {
                return ((ConfigFetchRequest) this.instance).hasDeviceSubtype();
            }

            public boolean hasDeviceTimezoneId() {
                return ((ConfigFetchRequest) this.instance).hasDeviceTimezoneId();
            }

            public boolean hasDeviceType() {
                return ((ConfigFetchRequest) this.instance).hasDeviceType();
            }

            public boolean hasGmsCoreVersion() {
                return ((ConfigFetchRequest) this.instance).hasGmsCoreVersion();
            }

            public boolean hasOsVersion() {
                return ((ConfigFetchRequest) this.instance).hasOsVersion();
            }

            public boolean hasSecurityToken() {
                return ((ConfigFetchRequest) this.instance).hasSecurityToken();
            }

            public Builder mergeConfig(Logs.AndroidConfigFetchProto androidConfigFetchProto) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).mergeConfig(androidConfigFetchProto);
                return this;
            }

            public Builder removePackageData(int i) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).removePackageData(i);
                return this;
            }

            public Builder setAndroidId(long j) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setAndroidId(j);
                return this;
            }

            public Builder setApiLevel(int i) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setApiLevel(i);
                return this;
            }

            public Builder setClientVersion(int i) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setClientVersion(i);
                return this;
            }

            public Builder setConfig(Logs.AndroidConfigFetchProto androidConfigFetchProto) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setConfig(androidConfigFetchProto);
                return this;
            }

            public Builder setDeviceCountry(String str) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setDeviceCountry(str);
                return this;
            }

            public Builder setDeviceCountryBytes(C3995f fVar) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setDeviceCountryBytes(fVar);
                return this;
            }

            public Builder setDeviceDataVersionInfo(String str) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setDeviceDataVersionInfo(str);
                return this;
            }

            public Builder setDeviceDataVersionInfoBytes(C3995f fVar) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setDeviceDataVersionInfoBytes(fVar);
                return this;
            }

            public Builder setDeviceLocale(String str) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setDeviceLocale(str);
                return this;
            }

            public Builder setDeviceLocaleBytes(C3995f fVar) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setDeviceLocaleBytes(fVar);
                return this;
            }

            public Builder setDeviceSubtype(int i) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setDeviceSubtype(i);
                return this;
            }

            public Builder setDeviceTimezoneId(String str) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setDeviceTimezoneId(str);
                return this;
            }

            public Builder setDeviceTimezoneIdBytes(C3995f fVar) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setDeviceTimezoneIdBytes(fVar);
                return this;
            }

            public Builder setDeviceType(int i) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setDeviceType(i);
                return this;
            }

            public Builder setGmsCoreVersion(int i) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setGmsCoreVersion(i);
                return this;
            }

            public Builder setOsVersion(String str) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setOsVersion(str);
                return this;
            }

            public Builder setOsVersionBytes(C3995f fVar) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setOsVersionBytes(fVar);
                return this;
            }

            public Builder setPackageData(int i, PackageData packageData) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setPackageData(i, packageData);
                return this;
            }

            public Builder setSecurityToken(long j) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setSecurityToken(j);
                return this;
            }

            private Builder() {
                super(ConfigFetchRequest.DEFAULT_INSTANCE);
            }

            public Builder addPackageData(int i, PackageData packageData) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).addPackageData(i, packageData);
                return this;
            }

            public Builder setConfig(Logs.AndroidConfigFetchProto.Builder builder) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setConfig(builder);
                return this;
            }

            public Builder setPackageData(int i, PackageData.Builder builder) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).setPackageData(i, builder);
                return this;
            }

            public Builder addPackageData(PackageData.Builder builder) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).addPackageData(builder);
                return this;
            }

            public Builder addPackageData(int i, PackageData.Builder builder) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).addPackageData(i, builder);
                return this;
            }
        }

        static {
            ConfigFetchRequest configFetchRequest = new ConfigFetchRequest();
            DEFAULT_INSTANCE = configFetchRequest;
            configFetchRequest.makeImmutable();
        }

        private ConfigFetchRequest() {
        }

        /* access modifiers changed from: private */
        public void addAllPackageData(Iterable<? extends PackageData> iterable) {
            ensurePackageDataIsMutable();
            C3969a.addAll(iterable, this.packageData_);
        }

        /* access modifiers changed from: private */
        public void addPackageData(PackageData packageData) {
            if (packageData != null) {
                ensurePackageDataIsMutable();
                this.packageData_.add(packageData);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearAndroidId() {
            this.bitField0_ &= -3;
            this.androidId_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearApiLevel() {
            this.bitField0_ &= -65;
            this.apiLevel_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearClientVersion() {
            this.bitField0_ &= -17;
            this.clientVersion_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearConfig() {
            this.config_ = null;
            this.bitField0_ &= -2;
        }

        /* access modifiers changed from: private */
        public void clearDeviceCountry() {
            this.bitField0_ &= -129;
            this.deviceCountry_ = getDefaultInstance().getDeviceCountry();
        }

        /* access modifiers changed from: private */
        public void clearDeviceDataVersionInfo() {
            this.bitField0_ &= -5;
            this.deviceDataVersionInfo_ = getDefaultInstance().getDeviceDataVersionInfo();
        }

        /* access modifiers changed from: private */
        public void clearDeviceLocale() {
            this.bitField0_ &= -257;
            this.deviceLocale_ = getDefaultInstance().getDeviceLocale();
        }

        /* access modifiers changed from: private */
        public void clearDeviceSubtype() {
            this.bitField0_ &= -1025;
            this.deviceSubtype_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearDeviceTimezoneId() {
            this.bitField0_ &= -4097;
            this.deviceTimezoneId_ = getDefaultInstance().getDeviceTimezoneId();
        }

        /* access modifiers changed from: private */
        public void clearDeviceType() {
            this.bitField0_ &= -513;
            this.deviceType_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearGmsCoreVersion() {
            this.bitField0_ &= -33;
            this.gmsCoreVersion_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearOsVersion() {
            this.bitField0_ &= -2049;
            this.osVersion_ = getDefaultInstance().getOsVersion();
        }

        /* access modifiers changed from: private */
        public void clearPackageData() {
            this.packageData_ = C4023n.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearSecurityToken() {
            this.bitField0_ &= -9;
            this.securityToken_ = 0;
        }

        private void ensurePackageDataIsMutable() {
            if (!this.packageData_.mo28080v()) {
                this.packageData_ = C4023n.mutableCopy(this.packageData_);
            }
        }

        public static ConfigFetchRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void mergeConfig(Logs.AndroidConfigFetchProto androidConfigFetchProto) {
            Logs.AndroidConfigFetchProto androidConfigFetchProto2 = this.config_;
            if (androidConfigFetchProto2 == null || androidConfigFetchProto2 == Logs.AndroidConfigFetchProto.getDefaultInstance()) {
                this.config_ = androidConfigFetchProto;
            } else {
                this.config_ = (Logs.AndroidConfigFetchProto) ((Logs.AndroidConfigFetchProto.Builder) Logs.AndroidConfigFetchProto.newBuilder(this.config_).mergeFrom(androidConfigFetchProto)).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static ConfigFetchRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConfigFetchRequest) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigFetchRequest parseFrom(C3995f fVar) throws InvalidProtocolBufferException {
            return (ConfigFetchRequest) C4023n.parseFrom(DEFAULT_INSTANCE, fVar);
        }

        public static C4058x<ConfigFetchRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void removePackageData(int i) {
            ensurePackageDataIsMutable();
            this.packageData_.remove(i);
        }

        /* access modifiers changed from: private */
        public void setAndroidId(long j) {
            this.bitField0_ |= 2;
            this.androidId_ = j;
        }

        /* access modifiers changed from: private */
        public void setApiLevel(int i) {
            this.bitField0_ |= 64;
            this.apiLevel_ = i;
        }

        /* access modifiers changed from: private */
        public void setClientVersion(int i) {
            this.bitField0_ |= 16;
            this.clientVersion_ = i;
        }

        /* access modifiers changed from: private */
        public void setConfig(Logs.AndroidConfigFetchProto androidConfigFetchProto) {
            if (androidConfigFetchProto != null) {
                this.config_ = androidConfigFetchProto;
                this.bitField0_ |= 1;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setDeviceCountry(String str) {
            if (str != null) {
                this.bitField0_ |= OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
                this.deviceCountry_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setDeviceCountryBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
                this.deviceCountry_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setDeviceDataVersionInfo(String str) {
            if (str != null) {
                this.bitField0_ |= 4;
                this.deviceDataVersionInfo_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setDeviceDataVersionInfoBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 4;
                this.deviceDataVersionInfo_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setDeviceLocale(String str) {
            if (str != null) {
                this.bitField0_ |= 256;
                this.deviceLocale_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setDeviceLocaleBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 256;
                this.deviceLocale_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setDeviceSubtype(int i) {
            this.bitField0_ |= OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS;
            this.deviceSubtype_ = i;
        }

        /* access modifiers changed from: private */
        public void setDeviceTimezoneId(String str) {
            if (str != null) {
                this.bitField0_ |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
                this.deviceTimezoneId_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setDeviceTimezoneIdBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
                this.deviceTimezoneId_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setDeviceType(int i) {
            this.bitField0_ |= 512;
            this.deviceType_ = i;
        }

        /* access modifiers changed from: private */
        public void setGmsCoreVersion(int i) {
            this.bitField0_ |= 32;
            this.gmsCoreVersion_ = i;
        }

        /* access modifiers changed from: private */
        public void setOsVersion(String str) {
            if (str != null) {
                this.bitField0_ |= 2048;
                this.osVersion_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setOsVersionBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 2048;
                this.osVersion_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setPackageData(int i, PackageData packageData) {
            if (packageData != null) {
                ensurePackageDataIsMutable();
                this.packageData_.set(i, packageData);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setSecurityToken(long j) {
            this.bitField0_ |= 8;
            this.securityToken_ = j;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
            switch (C30861.f8636xa1df5c61[kVar.ordinal()]) {
                case 1:
                    return new ConfigFetchRequest();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.packageData_.mo28079t();
                    return null;
                case 4:
                    return new Builder((C30861) null);
                case 5:
                    C4023n.C4036l lVar = (C4023n.C4036l) obj;
                    ConfigFetchRequest configFetchRequest = (ConfigFetchRequest) obj2;
                    this.config_ = (Logs.AndroidConfigFetchProto) lVar.mo28221a(this.config_, configFetchRequest.config_);
                    this.androidId_ = lVar.mo28216a(hasAndroidId(), this.androidId_, configFetchRequest.hasAndroidId(), configFetchRequest.androidId_);
                    this.packageData_ = lVar.mo28220a(this.packageData_, configFetchRequest.packageData_);
                    this.deviceDataVersionInfo_ = lVar.mo28222a(hasDeviceDataVersionInfo(), this.deviceDataVersionInfo_, configFetchRequest.hasDeviceDataVersionInfo(), configFetchRequest.deviceDataVersionInfo_);
                    this.securityToken_ = lVar.mo28216a(hasSecurityToken(), this.securityToken_, configFetchRequest.hasSecurityToken(), configFetchRequest.securityToken_);
                    this.clientVersion_ = lVar.mo28215a(hasClientVersion(), this.clientVersion_, configFetchRequest.hasClientVersion(), configFetchRequest.clientVersion_);
                    this.gmsCoreVersion_ = lVar.mo28215a(hasGmsCoreVersion(), this.gmsCoreVersion_, configFetchRequest.hasGmsCoreVersion(), configFetchRequest.gmsCoreVersion_);
                    this.apiLevel_ = lVar.mo28215a(hasApiLevel(), this.apiLevel_, configFetchRequest.hasApiLevel(), configFetchRequest.apiLevel_);
                    this.deviceCountry_ = lVar.mo28222a(hasDeviceCountry(), this.deviceCountry_, configFetchRequest.hasDeviceCountry(), configFetchRequest.deviceCountry_);
                    this.deviceLocale_ = lVar.mo28222a(hasDeviceLocale(), this.deviceLocale_, configFetchRequest.hasDeviceLocale(), configFetchRequest.deviceLocale_);
                    this.deviceType_ = lVar.mo28215a(hasDeviceType(), this.deviceType_, configFetchRequest.hasDeviceType(), configFetchRequest.deviceType_);
                    this.deviceSubtype_ = lVar.mo28215a(hasDeviceSubtype(), this.deviceSubtype_, configFetchRequest.hasDeviceSubtype(), configFetchRequest.deviceSubtype_);
                    this.osVersion_ = lVar.mo28222a(hasOsVersion(), this.osVersion_, configFetchRequest.hasOsVersion(), configFetchRequest.osVersion_);
                    this.deviceTimezoneId_ = lVar.mo28222a(hasDeviceTimezoneId(), this.deviceTimezoneId_, configFetchRequest.hasDeviceTimezoneId(), configFetchRequest.deviceTimezoneId_);
                    if (lVar == C4023n.C4034j.f10839a) {
                        this.bitField0_ |= configFetchRequest.bitField0_;
                    }
                    return this;
                case 6:
                    C4013g gVar = (C4013g) obj;
                    C4018k kVar2 = (C4018k) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int q = gVar.mo28155q();
                            switch (q) {
                                case 0:
                                    z = true;
                                    break;
                                case 9:
                                    this.bitField0_ |= 2;
                                    this.androidId_ = gVar.mo28144f();
                                    break;
                                case 18:
                                    if (!this.packageData_.mo28080v()) {
                                        this.packageData_ = C4023n.mutableCopy(this.packageData_);
                                    }
                                    this.packageData_.add((PackageData) gVar.mo28133a(PackageData.parser(), kVar2));
                                    break;
                                case 26:
                                    String o = gVar.mo28153o();
                                    this.bitField0_ |= 4;
                                    this.deviceDataVersionInfo_ = o;
                                    break;
                                case 33:
                                    this.bitField0_ |= 8;
                                    this.securityToken_ = gVar.mo28144f();
                                    break;
                                case 42:
                                    Logs.AndroidConfigFetchProto.Builder builder = (this.bitField0_ & 1) == 1 ? (Logs.AndroidConfigFetchProto.Builder) this.config_.toBuilder() : null;
                                    Logs.AndroidConfigFetchProto androidConfigFetchProto = (Logs.AndroidConfigFetchProto) gVar.mo28133a(Logs.AndroidConfigFetchProto.parser(), kVar2);
                                    this.config_ = androidConfigFetchProto;
                                    if (builder != null) {
                                        builder.mergeFrom(androidConfigFetchProto);
                                        this.config_ = (Logs.AndroidConfigFetchProto) builder.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
                                    break;
                                case 48:
                                    this.bitField0_ |= 16;
                                    this.clientVersion_ = gVar.mo28145g();
                                    break;
                                case 56:
                                    this.bitField0_ |= 32;
                                    this.gmsCoreVersion_ = gVar.mo28145g();
                                    break;
                                case 64:
                                    this.bitField0_ |= 64;
                                    this.apiLevel_ = gVar.mo28145g();
                                    break;
                                case 74:
                                    String o2 = gVar.mo28153o();
                                    this.bitField0_ |= OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
                                    this.deviceCountry_ = o2;
                                    break;
                                case 82:
                                    String o3 = gVar.mo28153o();
                                    this.bitField0_ |= 256;
                                    this.deviceLocale_ = o3;
                                    break;
                                case 88:
                                    this.bitField0_ |= 512;
                                    this.deviceType_ = gVar.mo28145g();
                                    break;
                                case 96:
                                    this.bitField0_ |= OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS;
                                    this.deviceSubtype_ = gVar.mo28145g();
                                    break;
                                case 106:
                                    String o4 = gVar.mo28153o();
                                    this.bitField0_ |= 2048;
                                    this.osVersion_ = o4;
                                    break;
                                case 114:
                                    String o5 = gVar.mo28153o();
                                    this.bitField0_ |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
                                    this.deviceTimezoneId_ = o5;
                                    break;
                                default:
                                    if (parseUnknownField(q, gVar)) {
                                        break;
                                    }
                                    z = true;
                                    break;
                            }
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
                        synchronized (ConfigFetchRequest.class) {
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

        public long getAndroidId() {
            return this.androidId_;
        }

        public int getApiLevel() {
            return this.apiLevel_;
        }

        public int getClientVersion() {
            return this.clientVersion_;
        }

        public Logs.AndroidConfigFetchProto getConfig() {
            Logs.AndroidConfigFetchProto androidConfigFetchProto = this.config_;
            return androidConfigFetchProto == null ? Logs.AndroidConfigFetchProto.getDefaultInstance() : androidConfigFetchProto;
        }

        public String getDeviceCountry() {
            return this.deviceCountry_;
        }

        public C3995f getDeviceCountryBytes() {
            return C3995f.m13320a(this.deviceCountry_);
        }

        public String getDeviceDataVersionInfo() {
            return this.deviceDataVersionInfo_;
        }

        public C3995f getDeviceDataVersionInfoBytes() {
            return C3995f.m13320a(this.deviceDataVersionInfo_);
        }

        public String getDeviceLocale() {
            return this.deviceLocale_;
        }

        public C3995f getDeviceLocaleBytes() {
            return C3995f.m13320a(this.deviceLocale_);
        }

        public int getDeviceSubtype() {
            return this.deviceSubtype_;
        }

        public String getDeviceTimezoneId() {
            return this.deviceTimezoneId_;
        }

        public C3995f getDeviceTimezoneIdBytes() {
            return C3995f.m13320a(this.deviceTimezoneId_);
        }

        public int getDeviceType() {
            return this.deviceType_;
        }

        public int getGmsCoreVersion() {
            return this.gmsCoreVersion_;
        }

        public String getOsVersion() {
            return this.osVersion_;
        }

        public C3995f getOsVersionBytes() {
            return C3995f.m13320a(this.osVersion_);
        }

        public PackageData getPackageData(int i) {
            return this.packageData_.get(i);
        }

        public int getPackageDataCount() {
            return this.packageData_.size();
        }

        public List<PackageData> getPackageDataList() {
            return this.packageData_;
        }

        public PackageDataOrBuilder getPackageDataOrBuilder(int i) {
            return this.packageData_.get(i);
        }

        public List<? extends PackageDataOrBuilder> getPackageDataOrBuilderList() {
            return this.packageData_;
        }

        public long getSecurityToken() {
            return this.securityToken_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int d = (this.bitField0_ & 2) == 2 ? CodedOutputStream.m13131d(1, this.androidId_) + 0 : 0;
            for (int i2 = 0; i2 < this.packageData_.size(); i2++) {
                d += CodedOutputStream.m13123b(2, (C4054u) this.packageData_.get(i2));
            }
            if ((this.bitField0_ & 4) == 4) {
                d += CodedOutputStream.m13124b(3, getDeviceDataVersionInfo());
            }
            if ((this.bitField0_ & 8) == 8) {
                d += CodedOutputStream.m13131d(4, this.securityToken_);
            }
            if ((this.bitField0_ & 1) == 1) {
                d += CodedOutputStream.m13123b(5, (C4054u) getConfig());
            }
            if ((this.bitField0_ & 16) == 16) {
                d += CodedOutputStream.m13141g(6, this.clientVersion_);
            }
            if ((this.bitField0_ & 32) == 32) {
                d += CodedOutputStream.m13141g(7, this.gmsCoreVersion_);
            }
            if ((this.bitField0_ & 64) == 64) {
                d += CodedOutputStream.m13141g(8, this.apiLevel_);
            }
            if ((this.bitField0_ & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) == 128) {
                d += CodedOutputStream.m13124b(9, getDeviceCountry());
            }
            if ((this.bitField0_ & 256) == 256) {
                d += CodedOutputStream.m13124b(10, getDeviceLocale());
            }
            if ((this.bitField0_ & 512) == 512) {
                d += CodedOutputStream.m13141g(11, this.deviceType_);
            }
            if ((this.bitField0_ & OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS) == 1024) {
                d += CodedOutputStream.m13141g(12, this.deviceSubtype_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                d += CodedOutputStream.m13124b(13, getOsVersion());
            }
            if ((this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096) {
                d += CodedOutputStream.m13124b(14, getDeviceTimezoneId());
            }
            int b = d + this.unknownFields.mo28087b();
            this.memoizedSerializedSize = b;
            return b;
        }

        public boolean hasAndroidId() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasApiLevel() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasClientVersion() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasConfig() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasDeviceCountry() {
            return (this.bitField0_ & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) == 128;
        }

        public boolean hasDeviceDataVersionInfo() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasDeviceLocale() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasDeviceSubtype() {
            return (this.bitField0_ & OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS) == 1024;
        }

        public boolean hasDeviceTimezoneId() {
            return (this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096;
        }

        public boolean hasDeviceType() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean hasGmsCoreVersion() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasOsVersion() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public boolean hasSecurityToken() {
            return (this.bitField0_ & 8) == 8;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.mo27966a(1, this.androidId_);
            }
            for (int i = 0; i < this.packageData_.size(); i++) {
                codedOutputStream.mo27968a(2, (C4054u) this.packageData_.get(i));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.mo27969a(3, getDeviceDataVersionInfo());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.mo27966a(4, this.securityToken_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.mo27968a(5, (C4054u) getConfig());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.mo27977c(6, this.clientVersion_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.mo27977c(7, this.gmsCoreVersion_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.mo27977c(8, this.apiLevel_);
            }
            if ((this.bitField0_ & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) == 128) {
                codedOutputStream.mo27969a(9, getDeviceCountry());
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.mo27969a(10, getDeviceLocale());
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.mo27977c(11, this.deviceType_);
            }
            if ((this.bitField0_ & OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS) == 1024) {
                codedOutputStream.mo27977c(12, this.deviceSubtype_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.mo27969a(13, getOsVersion());
            }
            if ((this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096) {
                codedOutputStream.mo27969a(14, getDeviceTimezoneId());
            }
            this.unknownFields.mo28084a(codedOutputStream);
        }

        public static Builder newBuilder(ConfigFetchRequest configFetchRequest) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(configFetchRequest);
        }

        public static ConfigFetchRequest parseDelimitedFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (ConfigFetchRequest) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        public static ConfigFetchRequest parseFrom(C3995f fVar, C4018k kVar) throws InvalidProtocolBufferException {
            return (ConfigFetchRequest) C4023n.parseFrom(DEFAULT_INSTANCE, fVar, kVar);
        }

        public static ConfigFetchRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ConfigFetchRequest) C4023n.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* access modifiers changed from: private */
        public void addPackageData(int i, PackageData packageData) {
            if (packageData != null) {
                ensurePackageDataIsMutable();
                this.packageData_.add(i, packageData);
                return;
            }
            throw null;
        }

        public static ConfigFetchRequest parseFrom(byte[] bArr, C4018k kVar) throws InvalidProtocolBufferException {
            return (ConfigFetchRequest) C4023n.parseFrom(DEFAULT_INSTANCE, bArr, kVar);
        }

        /* access modifiers changed from: private */
        public void setConfig(Logs.AndroidConfigFetchProto.Builder builder) {
            this.config_ = (Logs.AndroidConfigFetchProto) builder.build();
            this.bitField0_ |= 1;
        }

        /* access modifiers changed from: private */
        public void setPackageData(int i, PackageData.Builder builder) {
            ensurePackageDataIsMutable();
            this.packageData_.set(i, (PackageData) builder.build());
        }

        public static ConfigFetchRequest parseFrom(InputStream inputStream) throws IOException {
            return (ConfigFetchRequest) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigFetchRequest parseFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (ConfigFetchRequest) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        /* access modifiers changed from: private */
        public void addPackageData(PackageData.Builder builder) {
            ensurePackageDataIsMutable();
            this.packageData_.add((PackageData) builder.build());
        }

        public static ConfigFetchRequest parseFrom(C4013g gVar) throws IOException {
            return (ConfigFetchRequest) C4023n.parseFrom(DEFAULT_INSTANCE, gVar);
        }

        public static ConfigFetchRequest parseFrom(C4013g gVar, C4018k kVar) throws IOException {
            return (ConfigFetchRequest) C4023n.parseFrom(DEFAULT_INSTANCE, gVar, kVar);
        }

        /* access modifiers changed from: private */
        public void addPackageData(int i, PackageData.Builder builder) {
            ensurePackageDataIsMutable();
            this.packageData_.add(i, (PackageData) builder.build());
        }
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public interface ConfigFetchRequestOrBuilder extends C4056v {
        long getAndroidId();

        int getApiLevel();

        int getClientVersion();

        Logs.AndroidConfigFetchProto getConfig();

        String getDeviceCountry();

        C3995f getDeviceCountryBytes();

        String getDeviceDataVersionInfo();

        C3995f getDeviceDataVersionInfoBytes();

        String getDeviceLocale();

        C3995f getDeviceLocaleBytes();

        int getDeviceSubtype();

        String getDeviceTimezoneId();

        C3995f getDeviceTimezoneIdBytes();

        int getDeviceType();

        int getGmsCoreVersion();

        String getOsVersion();

        C3995f getOsVersionBytes();

        PackageData getPackageData(int i);

        int getPackageDataCount();

        List<PackageData> getPackageDataList();

        long getSecurityToken();

        boolean hasAndroidId();

        boolean hasApiLevel();

        boolean hasClientVersion();

        boolean hasConfig();

        boolean hasDeviceCountry();

        boolean hasDeviceDataVersionInfo();

        boolean hasDeviceLocale();

        boolean hasDeviceSubtype();

        boolean hasDeviceTimezoneId();

        boolean hasDeviceType();

        boolean hasGmsCoreVersion();

        boolean hasOsVersion();

        boolean hasSecurityToken();
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class ConfigFetchResponse extends C4023n<ConfigFetchResponse, Builder> implements ConfigFetchResponseOrBuilder {
        public static final int APP_CONFIG_FIELD_NUMBER = 4;
        /* access modifiers changed from: private */
        public static final ConfigFetchResponse DEFAULT_INSTANCE;
        public static final int INTERNAL_METADATA_FIELD_NUMBER = 3;
        public static final int PACKAGE_TABLE_FIELD_NUMBER = 1;
        private static volatile C4058x<ConfigFetchResponse> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        private C4038p.C4046h<AppConfigTable> appConfig_ = C4023n.emptyProtobufList();
        private int bitField0_;
        private C4038p.C4046h<KeyValue> internalMetadata_ = C4023n.emptyProtobufList();
        private C4038p.C4046h<PackageTable> packageTable_ = C4023n.emptyProtobufList();
        private int status_;

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public static final class Builder extends C4023n.C4025b<ConfigFetchResponse, Builder> implements ConfigFetchResponseOrBuilder {
            /* synthetic */ Builder(C30861 r1) {
                this();
            }

            public Builder addAllAppConfig(Iterable<? extends AppConfigTable> iterable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).addAllAppConfig(iterable);
                return this;
            }

            public Builder addAllInternalMetadata(Iterable<? extends KeyValue> iterable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).addAllInternalMetadata(iterable);
                return this;
            }

            public Builder addAllPackageTable(Iterable<? extends PackageTable> iterable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).addAllPackageTable(iterable);
                return this;
            }

            public Builder addAppConfig(AppConfigTable appConfigTable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).addAppConfig(appConfigTable);
                return this;
            }

            public Builder addInternalMetadata(KeyValue keyValue) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).addInternalMetadata(keyValue);
                return this;
            }

            public Builder addPackageTable(PackageTable packageTable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).addPackageTable(packageTable);
                return this;
            }

            public Builder clearAppConfig() {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).clearAppConfig();
                return this;
            }

            public Builder clearInternalMetadata() {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).clearInternalMetadata();
                return this;
            }

            public Builder clearPackageTable() {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).clearPackageTable();
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).clearStatus();
                return this;
            }

            public AppConfigTable getAppConfig(int i) {
                return ((ConfigFetchResponse) this.instance).getAppConfig(i);
            }

            public int getAppConfigCount() {
                return ((ConfigFetchResponse) this.instance).getAppConfigCount();
            }

            public List<AppConfigTable> getAppConfigList() {
                return Collections.unmodifiableList(((ConfigFetchResponse) this.instance).getAppConfigList());
            }

            public KeyValue getInternalMetadata(int i) {
                return ((ConfigFetchResponse) this.instance).getInternalMetadata(i);
            }

            public int getInternalMetadataCount() {
                return ((ConfigFetchResponse) this.instance).getInternalMetadataCount();
            }

            public List<KeyValue> getInternalMetadataList() {
                return Collections.unmodifiableList(((ConfigFetchResponse) this.instance).getInternalMetadataList());
            }

            public PackageTable getPackageTable(int i) {
                return ((ConfigFetchResponse) this.instance).getPackageTable(i);
            }

            public int getPackageTableCount() {
                return ((ConfigFetchResponse) this.instance).getPackageTableCount();
            }

            public List<PackageTable> getPackageTableList() {
                return Collections.unmodifiableList(((ConfigFetchResponse) this.instance).getPackageTableList());
            }

            public ResponseStatus getStatus() {
                return ((ConfigFetchResponse) this.instance).getStatus();
            }

            public boolean hasStatus() {
                return ((ConfigFetchResponse) this.instance).hasStatus();
            }

            public Builder removeAppConfig(int i) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).removeAppConfig(i);
                return this;
            }

            public Builder removeInternalMetadata(int i) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).removeInternalMetadata(i);
                return this;
            }

            public Builder removePackageTable(int i) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).removePackageTable(i);
                return this;
            }

            public Builder setAppConfig(int i, AppConfigTable appConfigTable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).setAppConfig(i, appConfigTable);
                return this;
            }

            public Builder setInternalMetadata(int i, KeyValue keyValue) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).setInternalMetadata(i, keyValue);
                return this;
            }

            public Builder setPackageTable(int i, PackageTable packageTable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).setPackageTable(i, packageTable);
                return this;
            }

            public Builder setStatus(ResponseStatus responseStatus) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).setStatus(responseStatus);
                return this;
            }

            private Builder() {
                super(ConfigFetchResponse.DEFAULT_INSTANCE);
            }

            public Builder addAppConfig(int i, AppConfigTable appConfigTable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).addAppConfig(i, appConfigTable);
                return this;
            }

            public Builder addInternalMetadata(int i, KeyValue keyValue) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).addInternalMetadata(i, keyValue);
                return this;
            }

            public Builder addPackageTable(int i, PackageTable packageTable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).addPackageTable(i, packageTable);
                return this;
            }

            public Builder setAppConfig(int i, AppConfigTable.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).setAppConfig(i, builder);
                return this;
            }

            public Builder setInternalMetadata(int i, KeyValue.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).setInternalMetadata(i, builder);
                return this;
            }

            public Builder setPackageTable(int i, PackageTable.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).setPackageTable(i, builder);
                return this;
            }

            public Builder addAppConfig(AppConfigTable.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).addAppConfig(builder);
                return this;
            }

            public Builder addInternalMetadata(KeyValue.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).addInternalMetadata(builder);
                return this;
            }

            public Builder addPackageTable(PackageTable.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).addPackageTable(builder);
                return this;
            }

            public Builder addAppConfig(int i, AppConfigTable.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).addAppConfig(i, builder);
                return this;
            }

            public Builder addInternalMetadata(int i, KeyValue.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).addInternalMetadata(i, builder);
                return this;
            }

            public Builder addPackageTable(int i, PackageTable.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).addPackageTable(i, builder);
                return this;
            }
        }

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public enum ResponseStatus implements C4038p.C4041c {
            SUCCESS(0),
            NO_PACKAGES_IN_REQUEST(1);
            
            public static final int NO_PACKAGES_IN_REQUEST_VALUE = 1;
            public static final int SUCCESS_VALUE = 0;
            private static final C4038p.C4042d<ResponseStatus> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new C4038p.C4042d<ResponseStatus>() {
                    public ResponseStatus findValueByNumber(int i) {
                        return ResponseStatus.forNumber(i);
                    }
                };
            }

            private ResponseStatus(int i) {
                this.value = i;
            }

            public static ResponseStatus forNumber(int i) {
                if (i == 0) {
                    return SUCCESS;
                }
                if (i != 1) {
                    return null;
                }
                return NO_PACKAGES_IN_REQUEST;
            }

            public static C4038p.C4042d<ResponseStatus> internalGetValueMap() {
                return internalValueMap;
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static ResponseStatus valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            ConfigFetchResponse configFetchResponse = new ConfigFetchResponse();
            DEFAULT_INSTANCE = configFetchResponse;
            configFetchResponse.makeImmutable();
        }

        private ConfigFetchResponse() {
        }

        /* access modifiers changed from: private */
        public void addAllAppConfig(Iterable<? extends AppConfigTable> iterable) {
            ensureAppConfigIsMutable();
            C3969a.addAll(iterable, this.appConfig_);
        }

        /* access modifiers changed from: private */
        public void addAllInternalMetadata(Iterable<? extends KeyValue> iterable) {
            ensureInternalMetadataIsMutable();
            C3969a.addAll(iterable, this.internalMetadata_);
        }

        /* access modifiers changed from: private */
        public void addAllPackageTable(Iterable<? extends PackageTable> iterable) {
            ensurePackageTableIsMutable();
            C3969a.addAll(iterable, this.packageTable_);
        }

        /* access modifiers changed from: private */
        public void addAppConfig(AppConfigTable appConfigTable) {
            if (appConfigTable != null) {
                ensureAppConfigIsMutable();
                this.appConfig_.add(appConfigTable);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addInternalMetadata(KeyValue keyValue) {
            if (keyValue != null) {
                ensureInternalMetadataIsMutable();
                this.internalMetadata_.add(keyValue);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addPackageTable(PackageTable packageTable) {
            if (packageTable != null) {
                ensurePackageTableIsMutable();
                this.packageTable_.add(packageTable);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearAppConfig() {
            this.appConfig_ = C4023n.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearInternalMetadata() {
            this.internalMetadata_ = C4023n.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearPackageTable() {
            this.packageTable_ = C4023n.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearStatus() {
            this.bitField0_ &= -2;
            this.status_ = 0;
        }

        private void ensureAppConfigIsMutable() {
            if (!this.appConfig_.mo28080v()) {
                this.appConfig_ = C4023n.mutableCopy(this.appConfig_);
            }
        }

        private void ensureInternalMetadataIsMutable() {
            if (!this.internalMetadata_.mo28080v()) {
                this.internalMetadata_ = C4023n.mutableCopy(this.internalMetadata_);
            }
        }

        private void ensurePackageTableIsMutable() {
            if (!this.packageTable_.mo28080v()) {
                this.packageTable_ = C4023n.mutableCopy(this.packageTable_);
            }
        }

        public static ConfigFetchResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static ConfigFetchResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConfigFetchResponse) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigFetchResponse parseFrom(C3995f fVar) throws InvalidProtocolBufferException {
            return (ConfigFetchResponse) C4023n.parseFrom(DEFAULT_INSTANCE, fVar);
        }

        public static C4058x<ConfigFetchResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void removeAppConfig(int i) {
            ensureAppConfigIsMutable();
            this.appConfig_.remove(i);
        }

        /* access modifiers changed from: private */
        public void removeInternalMetadata(int i) {
            ensureInternalMetadataIsMutable();
            this.internalMetadata_.remove(i);
        }

        /* access modifiers changed from: private */
        public void removePackageTable(int i) {
            ensurePackageTableIsMutable();
            this.packageTable_.remove(i);
        }

        /* access modifiers changed from: private */
        public void setAppConfig(int i, AppConfigTable appConfigTable) {
            if (appConfigTable != null) {
                ensureAppConfigIsMutable();
                this.appConfig_.set(i, appConfigTable);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setInternalMetadata(int i, KeyValue keyValue) {
            if (keyValue != null) {
                ensureInternalMetadataIsMutable();
                this.internalMetadata_.set(i, keyValue);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setPackageTable(int i, PackageTable packageTable) {
            if (packageTable != null) {
                ensurePackageTableIsMutable();
                this.packageTable_.set(i, packageTable);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setStatus(ResponseStatus responseStatus) {
            if (responseStatus != null) {
                this.bitField0_ |= 1;
                this.status_ = responseStatus.getNumber();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
            switch (C30861.f8636xa1df5c61[kVar.ordinal()]) {
                case 1:
                    return new ConfigFetchResponse();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.packageTable_.mo28079t();
                    this.internalMetadata_.mo28079t();
                    this.appConfig_.mo28079t();
                    return null;
                case 4:
                    return new Builder((C30861) null);
                case 5:
                    C4023n.C4036l lVar = (C4023n.C4036l) obj;
                    ConfigFetchResponse configFetchResponse = (ConfigFetchResponse) obj2;
                    this.packageTable_ = lVar.mo28220a(this.packageTable_, configFetchResponse.packageTable_);
                    this.status_ = lVar.mo28215a(hasStatus(), this.status_, configFetchResponse.hasStatus(), configFetchResponse.status_);
                    this.internalMetadata_ = lVar.mo28220a(this.internalMetadata_, configFetchResponse.internalMetadata_);
                    this.appConfig_ = lVar.mo28220a(this.appConfig_, configFetchResponse.appConfig_);
                    if (lVar == C4023n.C4034j.f10839a) {
                        this.bitField0_ |= configFetchResponse.bitField0_;
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
                                    if (!this.packageTable_.mo28080v()) {
                                        this.packageTable_ = C4023n.mutableCopy(this.packageTable_);
                                    }
                                    this.packageTable_.add((PackageTable) gVar.mo28133a(PackageTable.parser(), kVar2));
                                } else if (q == 16) {
                                    int d = gVar.mo28140d();
                                    if (ResponseStatus.forNumber(d) == null) {
                                        super.mergeVarintField(2, d);
                                    } else {
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.status_ = d;
                                    }
                                } else if (q == 26) {
                                    if (!this.internalMetadata_.mo28080v()) {
                                        this.internalMetadata_ = C4023n.mutableCopy(this.internalMetadata_);
                                    }
                                    this.internalMetadata_.add((KeyValue) gVar.mo28133a(KeyValue.parser(), kVar2));
                                } else if (q == 34) {
                                    if (!this.appConfig_.mo28080v()) {
                                        this.appConfig_ = C4023n.mutableCopy(this.appConfig_);
                                    }
                                    this.appConfig_.add((AppConfigTable) gVar.mo28133a(AppConfigTable.parser(), kVar2));
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
                        synchronized (ConfigFetchResponse.class) {
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

        public AppConfigTable getAppConfig(int i) {
            return this.appConfig_.get(i);
        }

        public int getAppConfigCount() {
            return this.appConfig_.size();
        }

        public List<AppConfigTable> getAppConfigList() {
            return this.appConfig_;
        }

        public AppConfigTableOrBuilder getAppConfigOrBuilder(int i) {
            return this.appConfig_.get(i);
        }

        public List<? extends AppConfigTableOrBuilder> getAppConfigOrBuilderList() {
            return this.appConfig_;
        }

        public KeyValue getInternalMetadata(int i) {
            return this.internalMetadata_.get(i);
        }

        public int getInternalMetadataCount() {
            return this.internalMetadata_.size();
        }

        public List<KeyValue> getInternalMetadataList() {
            return this.internalMetadata_;
        }

        public KeyValueOrBuilder getInternalMetadataOrBuilder(int i) {
            return this.internalMetadata_.get(i);
        }

        public List<? extends KeyValueOrBuilder> getInternalMetadataOrBuilderList() {
            return this.internalMetadata_;
        }

        public PackageTable getPackageTable(int i) {
            return this.packageTable_.get(i);
        }

        public int getPackageTableCount() {
            return this.packageTable_.size();
        }

        public List<PackageTable> getPackageTableList() {
            return this.packageTable_;
        }

        public PackageTableOrBuilder getPackageTableOrBuilder(int i) {
            return this.packageTable_.get(i);
        }

        public List<? extends PackageTableOrBuilder> getPackageTableOrBuilderList() {
            return this.packageTable_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.packageTable_.size(); i3++) {
                i2 += CodedOutputStream.m13123b(1, (C4054u) this.packageTable_.get(i3));
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.m13134e(2, this.status_);
            }
            for (int i4 = 0; i4 < this.internalMetadata_.size(); i4++) {
                i2 += CodedOutputStream.m13123b(3, (C4054u) this.internalMetadata_.get(i4));
            }
            for (int i5 = 0; i5 < this.appConfig_.size(); i5++) {
                i2 += CodedOutputStream.m13123b(4, (C4054u) this.appConfig_.get(i5));
            }
            int b = i2 + this.unknownFields.mo28087b();
            this.memoizedSerializedSize = b;
            return b;
        }

        public ResponseStatus getStatus() {
            ResponseStatus forNumber = ResponseStatus.forNumber(this.status_);
            return forNumber == null ? ResponseStatus.SUCCESS : forNumber;
        }

        public boolean hasStatus() {
            return (this.bitField0_ & 1) == 1;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.packageTable_.size(); i++) {
                codedOutputStream.mo27968a(1, (C4054u) this.packageTable_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.mo27965a(2, this.status_);
            }
            for (int i2 = 0; i2 < this.internalMetadata_.size(); i2++) {
                codedOutputStream.mo27968a(3, (C4054u) this.internalMetadata_.get(i2));
            }
            for (int i3 = 0; i3 < this.appConfig_.size(); i3++) {
                codedOutputStream.mo27968a(4, (C4054u) this.appConfig_.get(i3));
            }
            this.unknownFields.mo28084a(codedOutputStream);
        }

        public static Builder newBuilder(ConfigFetchResponse configFetchResponse) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(configFetchResponse);
        }

        public static ConfigFetchResponse parseDelimitedFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (ConfigFetchResponse) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        public static ConfigFetchResponse parseFrom(C3995f fVar, C4018k kVar) throws InvalidProtocolBufferException {
            return (ConfigFetchResponse) C4023n.parseFrom(DEFAULT_INSTANCE, fVar, kVar);
        }

        public static ConfigFetchResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ConfigFetchResponse) C4023n.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* access modifiers changed from: private */
        public void addAppConfig(int i, AppConfigTable appConfigTable) {
            if (appConfigTable != null) {
                ensureAppConfigIsMutable();
                this.appConfig_.add(i, appConfigTable);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addInternalMetadata(int i, KeyValue keyValue) {
            if (keyValue != null) {
                ensureInternalMetadataIsMutable();
                this.internalMetadata_.add(i, keyValue);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addPackageTable(int i, PackageTable packageTable) {
            if (packageTable != null) {
                ensurePackageTableIsMutable();
                this.packageTable_.add(i, packageTable);
                return;
            }
            throw null;
        }

        public static ConfigFetchResponse parseFrom(byte[] bArr, C4018k kVar) throws InvalidProtocolBufferException {
            return (ConfigFetchResponse) C4023n.parseFrom(DEFAULT_INSTANCE, bArr, kVar);
        }

        /* access modifiers changed from: private */
        public void setAppConfig(int i, AppConfigTable.Builder builder) {
            ensureAppConfigIsMutable();
            this.appConfig_.set(i, (AppConfigTable) builder.build());
        }

        /* access modifiers changed from: private */
        public void setInternalMetadata(int i, KeyValue.Builder builder) {
            ensureInternalMetadataIsMutable();
            this.internalMetadata_.set(i, (KeyValue) builder.build());
        }

        /* access modifiers changed from: private */
        public void setPackageTable(int i, PackageTable.Builder builder) {
            ensurePackageTableIsMutable();
            this.packageTable_.set(i, (PackageTable) builder.build());
        }

        public static ConfigFetchResponse parseFrom(InputStream inputStream) throws IOException {
            return (ConfigFetchResponse) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigFetchResponse parseFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (ConfigFetchResponse) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        /* access modifiers changed from: private */
        public void addAppConfig(AppConfigTable.Builder builder) {
            ensureAppConfigIsMutable();
            this.appConfig_.add((AppConfigTable) builder.build());
        }

        /* access modifiers changed from: private */
        public void addInternalMetadata(KeyValue.Builder builder) {
            ensureInternalMetadataIsMutable();
            this.internalMetadata_.add((KeyValue) builder.build());
        }

        /* access modifiers changed from: private */
        public void addPackageTable(PackageTable.Builder builder) {
            ensurePackageTableIsMutable();
            this.packageTable_.add((PackageTable) builder.build());
        }

        public static ConfigFetchResponse parseFrom(C4013g gVar) throws IOException {
            return (ConfigFetchResponse) C4023n.parseFrom(DEFAULT_INSTANCE, gVar);
        }

        public static ConfigFetchResponse parseFrom(C4013g gVar, C4018k kVar) throws IOException {
            return (ConfigFetchResponse) C4023n.parseFrom(DEFAULT_INSTANCE, gVar, kVar);
        }

        /* access modifiers changed from: private */
        public void addAppConfig(int i, AppConfigTable.Builder builder) {
            ensureAppConfigIsMutable();
            this.appConfig_.add(i, (AppConfigTable) builder.build());
        }

        /* access modifiers changed from: private */
        public void addInternalMetadata(int i, KeyValue.Builder builder) {
            ensureInternalMetadataIsMutable();
            this.internalMetadata_.add(i, (KeyValue) builder.build());
        }

        /* access modifiers changed from: private */
        public void addPackageTable(int i, PackageTable.Builder builder) {
            ensurePackageTableIsMutable();
            this.packageTable_.add(i, (PackageTable) builder.build());
        }
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public interface ConfigFetchResponseOrBuilder extends C4056v {
        AppConfigTable getAppConfig(int i);

        int getAppConfigCount();

        List<AppConfigTable> getAppConfigList();

        KeyValue getInternalMetadata(int i);

        int getInternalMetadataCount();

        List<KeyValue> getInternalMetadataList();

        PackageTable getPackageTable(int i);

        int getPackageTableCount();

        List<PackageTable> getPackageTableList();

        ConfigFetchResponse.ResponseStatus getStatus();

        boolean hasStatus();
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class KeyValue extends C4023n<KeyValue, Builder> implements KeyValueOrBuilder {
        /* access modifiers changed from: private */
        public static final KeyValue DEFAULT_INSTANCE;
        public static final int KEY_FIELD_NUMBER = 1;
        private static volatile C4058x<KeyValue> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int bitField0_;
        private String key_ = "";
        private C3995f value_ = C3995f.f10759b;

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public static final class Builder extends C4023n.C4025b<KeyValue, Builder> implements KeyValueOrBuilder {
            /* synthetic */ Builder(C30861 r1) {
                this();
            }

            public Builder clearKey() {
                copyOnWrite();
                ((KeyValue) this.instance).clearKey();
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((KeyValue) this.instance).clearValue();
                return this;
            }

            public String getKey() {
                return ((KeyValue) this.instance).getKey();
            }

            public C3995f getKeyBytes() {
                return ((KeyValue) this.instance).getKeyBytes();
            }

            public C3995f getValue() {
                return ((KeyValue) this.instance).getValue();
            }

            public boolean hasKey() {
                return ((KeyValue) this.instance).hasKey();
            }

            public boolean hasValue() {
                return ((KeyValue) this.instance).hasValue();
            }

            public Builder setKey(String str) {
                copyOnWrite();
                ((KeyValue) this.instance).setKey(str);
                return this;
            }

            public Builder setKeyBytes(C3995f fVar) {
                copyOnWrite();
                ((KeyValue) this.instance).setKeyBytes(fVar);
                return this;
            }

            public Builder setValue(C3995f fVar) {
                copyOnWrite();
                ((KeyValue) this.instance).setValue(fVar);
                return this;
            }

            private Builder() {
                super(KeyValue.DEFAULT_INSTANCE);
            }
        }

        static {
            KeyValue keyValue = new KeyValue();
            DEFAULT_INSTANCE = keyValue;
            keyValue.makeImmutable();
        }

        private KeyValue() {
        }

        /* access modifiers changed from: private */
        public void clearKey() {
            this.bitField0_ &= -2;
            this.key_ = getDefaultInstance().getKey();
        }

        /* access modifiers changed from: private */
        public void clearValue() {
            this.bitField0_ &= -3;
            this.value_ = getDefaultInstance().getValue();
        }

        public static KeyValue getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static KeyValue parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (KeyValue) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KeyValue parseFrom(C3995f fVar) throws InvalidProtocolBufferException {
            return (KeyValue) C4023n.parseFrom(DEFAULT_INSTANCE, fVar);
        }

        public static C4058x<KeyValue> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setKey(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.key_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setKeyBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 1;
                this.key_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setValue(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 2;
                this.value_ = fVar;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
            switch (C30861.f8636xa1df5c61[kVar.ordinal()]) {
                case 1:
                    return new KeyValue();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((C30861) null);
                case 5:
                    C4023n.C4036l lVar = (C4023n.C4036l) obj;
                    KeyValue keyValue = (KeyValue) obj2;
                    this.key_ = lVar.mo28222a(hasKey(), this.key_, keyValue.hasKey(), keyValue.key_);
                    this.value_ = lVar.mo28218a(hasValue(), this.value_, keyValue.hasValue(), keyValue.value_);
                    if (lVar == C4023n.C4034j.f10839a) {
                        this.bitField0_ |= keyValue.bitField0_;
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
                                    String o = gVar.mo28153o();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.key_ = o;
                                } else if (q == 18) {
                                    this.bitField0_ |= 2;
                                    this.value_ = gVar.mo28139c();
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
                        synchronized (KeyValue.class) {
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

        public String getKey() {
            return this.key_;
        }

        public C3995f getKeyBytes() {
            return C3995f.m13320a(this.key_);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.m13124b(1, getKey());
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.m13122b(2, this.value_);
            }
            int b = i2 + this.unknownFields.mo28087b();
            this.memoizedSerializedSize = b;
            return b;
        }

        public C3995f getValue() {
            return this.value_;
        }

        public boolean hasKey() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasValue() {
            return (this.bitField0_ & 2) == 2;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.mo27969a(1, getKey());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.mo27967a(2, this.value_);
            }
            this.unknownFields.mo28084a(codedOutputStream);
        }

        public static Builder newBuilder(KeyValue keyValue) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(keyValue);
        }

        public static KeyValue parseDelimitedFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (KeyValue) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        public static KeyValue parseFrom(C3995f fVar, C4018k kVar) throws InvalidProtocolBufferException {
            return (KeyValue) C4023n.parseFrom(DEFAULT_INSTANCE, fVar, kVar);
        }

        public static KeyValue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (KeyValue) C4023n.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static KeyValue parseFrom(byte[] bArr, C4018k kVar) throws InvalidProtocolBufferException {
            return (KeyValue) C4023n.parseFrom(DEFAULT_INSTANCE, bArr, kVar);
        }

        public static KeyValue parseFrom(InputStream inputStream) throws IOException {
            return (KeyValue) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KeyValue parseFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (KeyValue) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        public static KeyValue parseFrom(C4013g gVar) throws IOException {
            return (KeyValue) C4023n.parseFrom(DEFAULT_INSTANCE, gVar);
        }

        public static KeyValue parseFrom(C4013g gVar, C4018k kVar) throws IOException {
            return (KeyValue) C4023n.parseFrom(DEFAULT_INSTANCE, gVar, kVar);
        }
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public interface KeyValueOrBuilder extends C4056v {
        String getKey();

        C3995f getKeyBytes();

        C3995f getValue();

        boolean hasKey();

        boolean hasValue();
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class NamedValue extends C4023n<NamedValue, Builder> implements NamedValueOrBuilder {
        /* access modifiers changed from: private */
        public static final NamedValue DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile C4058x<NamedValue> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int bitField0_;
        private String name_ = "";
        private String value_ = "";

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public static final class Builder extends C4023n.C4025b<NamedValue, Builder> implements NamedValueOrBuilder {
            /* synthetic */ Builder(C30861 r1) {
                this();
            }

            public Builder clearName() {
                copyOnWrite();
                ((NamedValue) this.instance).clearName();
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((NamedValue) this.instance).clearValue();
                return this;
            }

            public String getName() {
                return ((NamedValue) this.instance).getName();
            }

            public C3995f getNameBytes() {
                return ((NamedValue) this.instance).getNameBytes();
            }

            public String getValue() {
                return ((NamedValue) this.instance).getValue();
            }

            public C3995f getValueBytes() {
                return ((NamedValue) this.instance).getValueBytes();
            }

            public boolean hasName() {
                return ((NamedValue) this.instance).hasName();
            }

            public boolean hasValue() {
                return ((NamedValue) this.instance).hasValue();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((NamedValue) this.instance).setName(str);
                return this;
            }

            public Builder setNameBytes(C3995f fVar) {
                copyOnWrite();
                ((NamedValue) this.instance).setNameBytes(fVar);
                return this;
            }

            public Builder setValue(String str) {
                copyOnWrite();
                ((NamedValue) this.instance).setValue(str);
                return this;
            }

            public Builder setValueBytes(C3995f fVar) {
                copyOnWrite();
                ((NamedValue) this.instance).setValueBytes(fVar);
                return this;
            }

            private Builder() {
                super(NamedValue.DEFAULT_INSTANCE);
            }
        }

        static {
            NamedValue namedValue = new NamedValue();
            DEFAULT_INSTANCE = namedValue;
            namedValue.makeImmutable();
        }

        private NamedValue() {
        }

        /* access modifiers changed from: private */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* access modifiers changed from: private */
        public void clearValue() {
            this.bitField0_ &= -3;
            this.value_ = getDefaultInstance().getValue();
        }

        public static NamedValue getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static NamedValue parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (NamedValue) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static NamedValue parseFrom(C3995f fVar) throws InvalidProtocolBufferException {
            return (NamedValue) C4023n.parseFrom(DEFAULT_INSTANCE, fVar);
        }

        public static C4058x<NamedValue> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void setName(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.name_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setNameBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 1;
                this.name_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setValue(String str) {
            if (str != null) {
                this.bitField0_ |= 2;
                this.value_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setValueBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 2;
                this.value_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
            switch (C30861.f8636xa1df5c61[kVar.ordinal()]) {
                case 1:
                    return new NamedValue();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((C30861) null);
                case 5:
                    C4023n.C4036l lVar = (C4023n.C4036l) obj;
                    NamedValue namedValue = (NamedValue) obj2;
                    this.name_ = lVar.mo28222a(hasName(), this.name_, namedValue.hasName(), namedValue.name_);
                    this.value_ = lVar.mo28222a(hasValue(), this.value_, namedValue.hasValue(), namedValue.value_);
                    if (lVar == C4023n.C4034j.f10839a) {
                        this.bitField0_ |= namedValue.bitField0_;
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
                                    String o = gVar.mo28153o();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.name_ = o;
                                } else if (q == 18) {
                                    String o2 = gVar.mo28153o();
                                    this.bitField0_ |= 2;
                                    this.value_ = o2;
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
                        synchronized (NamedValue.class) {
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

        public String getName() {
            return this.name_;
        }

        public C3995f getNameBytes() {
            return C3995f.m13320a(this.name_);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.m13124b(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.m13124b(2, getValue());
            }
            int b = i2 + this.unknownFields.mo28087b();
            this.memoizedSerializedSize = b;
            return b;
        }

        public String getValue() {
            return this.value_;
        }

        public C3995f getValueBytes() {
            return C3995f.m13320a(this.value_);
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasValue() {
            return (this.bitField0_ & 2) == 2;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.mo27969a(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.mo27969a(2, getValue());
            }
            this.unknownFields.mo28084a(codedOutputStream);
        }

        public static Builder newBuilder(NamedValue namedValue) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(namedValue);
        }

        public static NamedValue parseDelimitedFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (NamedValue) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        public static NamedValue parseFrom(C3995f fVar, C4018k kVar) throws InvalidProtocolBufferException {
            return (NamedValue) C4023n.parseFrom(DEFAULT_INSTANCE, fVar, kVar);
        }

        public static NamedValue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (NamedValue) C4023n.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static NamedValue parseFrom(byte[] bArr, C4018k kVar) throws InvalidProtocolBufferException {
            return (NamedValue) C4023n.parseFrom(DEFAULT_INSTANCE, bArr, kVar);
        }

        public static NamedValue parseFrom(InputStream inputStream) throws IOException {
            return (NamedValue) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static NamedValue parseFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (NamedValue) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        public static NamedValue parseFrom(C4013g gVar) throws IOException {
            return (NamedValue) C4023n.parseFrom(DEFAULT_INSTANCE, gVar);
        }

        public static NamedValue parseFrom(C4013g gVar, C4018k kVar) throws IOException {
            return (NamedValue) C4023n.parseFrom(DEFAULT_INSTANCE, gVar, kVar);
        }
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public interface NamedValueOrBuilder extends C4056v {
        String getName();

        C3995f getNameBytes();

        String getValue();

        C3995f getValueBytes();

        boolean hasName();

        boolean hasValue();
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class PackageData extends C4023n<PackageData, Builder> implements PackageDataOrBuilder {
        public static final int ACTIVE_CONFIG_AGE_SECONDS_FIELD_NUMBER = 20;
        public static final int ANALYTICS_USER_PROPERTY_FIELD_NUMBER = 17;
        public static final int APP_CERT_HASH_FIELD_NUMBER = 10;
        public static final int APP_INSTANCE_ID_FIELD_NUMBER = 12;
        public static final int APP_INSTANCE_ID_TOKEN_FIELD_NUMBER = 14;
        public static final int APP_VERSION_CODE_FIELD_NUMBER = 11;
        public static final int APP_VERSION_FIELD_NUMBER = 13;
        public static final int CERT_HASH_FIELD_NUMBER = 4;
        public static final int CONFIG_ID_FIELD_NUMBER = 5;
        public static final int CUSTOM_VARIABLE_FIELD_NUMBER = 9;
        /* access modifiers changed from: private */
        public static final PackageData DEFAULT_INSTANCE;
        public static final int DIGEST_FIELD_NUMBER = 3;
        public static final int FETCHED_CONFIG_AGE_SECONDS_FIELD_NUMBER = 19;
        public static final int GAMES_PROJECT_ID_FIELD_NUMBER = 7;
        public static final int GMP_PROJECT_ID_FIELD_NUMBER = 6;
        public static final int NAMESPACE_DIGEST_FIELD_NUMBER = 8;
        public static final int PACKAGE_NAME_FIELD_NUMBER = 1;
        private static volatile C4058x<PackageData> PARSER = null;
        public static final int REQUESTED_CACHE_EXPIRATION_SECONDS_FIELD_NUMBER = 18;
        public static final int REQUESTED_HIDDEN_NAMESPACE_FIELD_NUMBER = 15;
        public static final int SDK_VERSION_FIELD_NUMBER = 16;
        public static final int VERSION_CODE_FIELD_NUMBER = 2;
        private int activeConfigAgeSeconds_;
        private C4038p.C4046h<NamedValue> analyticsUserProperty_ = C4023n.emptyProtobufList();
        private C3995f appCertHash_ = C3995f.f10759b;
        private String appInstanceIdToken_ = "";
        private String appInstanceId_ = "";
        private int appVersionCode_;
        private String appVersion_ = "";
        private int bitField0_;
        private C3995f certHash_;
        private String configId_ = "";
        private C4038p.C4046h<NamedValue> customVariable_ = C4023n.emptyProtobufList();
        private C3995f digest_;
        private int fetchedConfigAgeSeconds_;
        private String gamesProjectId_ = "";
        private String gmpProjectId_ = "";
        private C4038p.C4046h<NamedValue> namespaceDigest_ = C4023n.emptyProtobufList();
        private String packageName_ = "";
        private int requestedCacheExpirationSeconds_;
        private C4038p.C4046h<String> requestedHiddenNamespace_ = C4023n.emptyProtobufList();
        private int sdkVersion_;
        private int versionCode_;

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public static final class Builder extends C4023n.C4025b<PackageData, Builder> implements PackageDataOrBuilder {
            /* synthetic */ Builder(C30861 r1) {
                this();
            }

            public Builder addAllAnalyticsUserProperty(Iterable<? extends NamedValue> iterable) {
                copyOnWrite();
                ((PackageData) this.instance).addAllAnalyticsUserProperty(iterable);
                return this;
            }

            public Builder addAllCustomVariable(Iterable<? extends NamedValue> iterable) {
                copyOnWrite();
                ((PackageData) this.instance).addAllCustomVariable(iterable);
                return this;
            }

            public Builder addAllNamespaceDigest(Iterable<? extends NamedValue> iterable) {
                copyOnWrite();
                ((PackageData) this.instance).addAllNamespaceDigest(iterable);
                return this;
            }

            public Builder addAllRequestedHiddenNamespace(Iterable<String> iterable) {
                copyOnWrite();
                ((PackageData) this.instance).addAllRequestedHiddenNamespace(iterable);
                return this;
            }

            public Builder addAnalyticsUserProperty(NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).addAnalyticsUserProperty(namedValue);
                return this;
            }

            public Builder addCustomVariable(NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).addCustomVariable(namedValue);
                return this;
            }

            public Builder addNamespaceDigest(NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).addNamespaceDigest(namedValue);
                return this;
            }

            public Builder addRequestedHiddenNamespace(String str) {
                copyOnWrite();
                ((PackageData) this.instance).addRequestedHiddenNamespace(str);
                return this;
            }

            public Builder addRequestedHiddenNamespaceBytes(C3995f fVar) {
                copyOnWrite();
                ((PackageData) this.instance).addRequestedHiddenNamespaceBytes(fVar);
                return this;
            }

            public Builder clearActiveConfigAgeSeconds() {
                copyOnWrite();
                ((PackageData) this.instance).clearActiveConfigAgeSeconds();
                return this;
            }

            public Builder clearAnalyticsUserProperty() {
                copyOnWrite();
                ((PackageData) this.instance).clearAnalyticsUserProperty();
                return this;
            }

            public Builder clearAppCertHash() {
                copyOnWrite();
                ((PackageData) this.instance).clearAppCertHash();
                return this;
            }

            public Builder clearAppInstanceId() {
                copyOnWrite();
                ((PackageData) this.instance).clearAppInstanceId();
                return this;
            }

            public Builder clearAppInstanceIdToken() {
                copyOnWrite();
                ((PackageData) this.instance).clearAppInstanceIdToken();
                return this;
            }

            public Builder clearAppVersion() {
                copyOnWrite();
                ((PackageData) this.instance).clearAppVersion();
                return this;
            }

            public Builder clearAppVersionCode() {
                copyOnWrite();
                ((PackageData) this.instance).clearAppVersionCode();
                return this;
            }

            public Builder clearCertHash() {
                copyOnWrite();
                ((PackageData) this.instance).clearCertHash();
                return this;
            }

            public Builder clearConfigId() {
                copyOnWrite();
                ((PackageData) this.instance).clearConfigId();
                return this;
            }

            public Builder clearCustomVariable() {
                copyOnWrite();
                ((PackageData) this.instance).clearCustomVariable();
                return this;
            }

            public Builder clearDigest() {
                copyOnWrite();
                ((PackageData) this.instance).clearDigest();
                return this;
            }

            public Builder clearFetchedConfigAgeSeconds() {
                copyOnWrite();
                ((PackageData) this.instance).clearFetchedConfigAgeSeconds();
                return this;
            }

            public Builder clearGamesProjectId() {
                copyOnWrite();
                ((PackageData) this.instance).clearGamesProjectId();
                return this;
            }

            public Builder clearGmpProjectId() {
                copyOnWrite();
                ((PackageData) this.instance).clearGmpProjectId();
                return this;
            }

            public Builder clearNamespaceDigest() {
                copyOnWrite();
                ((PackageData) this.instance).clearNamespaceDigest();
                return this;
            }

            public Builder clearPackageName() {
                copyOnWrite();
                ((PackageData) this.instance).clearPackageName();
                return this;
            }

            public Builder clearRequestedCacheExpirationSeconds() {
                copyOnWrite();
                ((PackageData) this.instance).clearRequestedCacheExpirationSeconds();
                return this;
            }

            public Builder clearRequestedHiddenNamespace() {
                copyOnWrite();
                ((PackageData) this.instance).clearRequestedHiddenNamespace();
                return this;
            }

            public Builder clearSdkVersion() {
                copyOnWrite();
                ((PackageData) this.instance).clearSdkVersion();
                return this;
            }

            public Builder clearVersionCode() {
                copyOnWrite();
                ((PackageData) this.instance).clearVersionCode();
                return this;
            }

            public int getActiveConfigAgeSeconds() {
                return ((PackageData) this.instance).getActiveConfigAgeSeconds();
            }

            public NamedValue getAnalyticsUserProperty(int i) {
                return ((PackageData) this.instance).getAnalyticsUserProperty(i);
            }

            public int getAnalyticsUserPropertyCount() {
                return ((PackageData) this.instance).getAnalyticsUserPropertyCount();
            }

            public List<NamedValue> getAnalyticsUserPropertyList() {
                return Collections.unmodifiableList(((PackageData) this.instance).getAnalyticsUserPropertyList());
            }

            public C3995f getAppCertHash() {
                return ((PackageData) this.instance).getAppCertHash();
            }

            public String getAppInstanceId() {
                return ((PackageData) this.instance).getAppInstanceId();
            }

            public C3995f getAppInstanceIdBytes() {
                return ((PackageData) this.instance).getAppInstanceIdBytes();
            }

            public String getAppInstanceIdToken() {
                return ((PackageData) this.instance).getAppInstanceIdToken();
            }

            public C3995f getAppInstanceIdTokenBytes() {
                return ((PackageData) this.instance).getAppInstanceIdTokenBytes();
            }

            public String getAppVersion() {
                return ((PackageData) this.instance).getAppVersion();
            }

            public C3995f getAppVersionBytes() {
                return ((PackageData) this.instance).getAppVersionBytes();
            }

            public int getAppVersionCode() {
                return ((PackageData) this.instance).getAppVersionCode();
            }

            public C3995f getCertHash() {
                return ((PackageData) this.instance).getCertHash();
            }

            public String getConfigId() {
                return ((PackageData) this.instance).getConfigId();
            }

            public C3995f getConfigIdBytes() {
                return ((PackageData) this.instance).getConfigIdBytes();
            }

            public NamedValue getCustomVariable(int i) {
                return ((PackageData) this.instance).getCustomVariable(i);
            }

            public int getCustomVariableCount() {
                return ((PackageData) this.instance).getCustomVariableCount();
            }

            public List<NamedValue> getCustomVariableList() {
                return Collections.unmodifiableList(((PackageData) this.instance).getCustomVariableList());
            }

            public C3995f getDigest() {
                return ((PackageData) this.instance).getDigest();
            }

            public int getFetchedConfigAgeSeconds() {
                return ((PackageData) this.instance).getFetchedConfigAgeSeconds();
            }

            public String getGamesProjectId() {
                return ((PackageData) this.instance).getGamesProjectId();
            }

            public C3995f getGamesProjectIdBytes() {
                return ((PackageData) this.instance).getGamesProjectIdBytes();
            }

            public String getGmpProjectId() {
                return ((PackageData) this.instance).getGmpProjectId();
            }

            public C3995f getGmpProjectIdBytes() {
                return ((PackageData) this.instance).getGmpProjectIdBytes();
            }

            public NamedValue getNamespaceDigest(int i) {
                return ((PackageData) this.instance).getNamespaceDigest(i);
            }

            public int getNamespaceDigestCount() {
                return ((PackageData) this.instance).getNamespaceDigestCount();
            }

            public List<NamedValue> getNamespaceDigestList() {
                return Collections.unmodifiableList(((PackageData) this.instance).getNamespaceDigestList());
            }

            public String getPackageName() {
                return ((PackageData) this.instance).getPackageName();
            }

            public C3995f getPackageNameBytes() {
                return ((PackageData) this.instance).getPackageNameBytes();
            }

            public int getRequestedCacheExpirationSeconds() {
                return ((PackageData) this.instance).getRequestedCacheExpirationSeconds();
            }

            public String getRequestedHiddenNamespace(int i) {
                return ((PackageData) this.instance).getRequestedHiddenNamespace(i);
            }

            public C3995f getRequestedHiddenNamespaceBytes(int i) {
                return ((PackageData) this.instance).getRequestedHiddenNamespaceBytes(i);
            }

            public int getRequestedHiddenNamespaceCount() {
                return ((PackageData) this.instance).getRequestedHiddenNamespaceCount();
            }

            public List<String> getRequestedHiddenNamespaceList() {
                return Collections.unmodifiableList(((PackageData) this.instance).getRequestedHiddenNamespaceList());
            }

            public int getSdkVersion() {
                return ((PackageData) this.instance).getSdkVersion();
            }

            public int getVersionCode() {
                return ((PackageData) this.instance).getVersionCode();
            }

            public boolean hasActiveConfigAgeSeconds() {
                return ((PackageData) this.instance).hasActiveConfigAgeSeconds();
            }

            public boolean hasAppCertHash() {
                return ((PackageData) this.instance).hasAppCertHash();
            }

            public boolean hasAppInstanceId() {
                return ((PackageData) this.instance).hasAppInstanceId();
            }

            public boolean hasAppInstanceIdToken() {
                return ((PackageData) this.instance).hasAppInstanceIdToken();
            }

            public boolean hasAppVersion() {
                return ((PackageData) this.instance).hasAppVersion();
            }

            public boolean hasAppVersionCode() {
                return ((PackageData) this.instance).hasAppVersionCode();
            }

            public boolean hasCertHash() {
                return ((PackageData) this.instance).hasCertHash();
            }

            public boolean hasConfigId() {
                return ((PackageData) this.instance).hasConfigId();
            }

            public boolean hasDigest() {
                return ((PackageData) this.instance).hasDigest();
            }

            public boolean hasFetchedConfigAgeSeconds() {
                return ((PackageData) this.instance).hasFetchedConfigAgeSeconds();
            }

            public boolean hasGamesProjectId() {
                return ((PackageData) this.instance).hasGamesProjectId();
            }

            public boolean hasGmpProjectId() {
                return ((PackageData) this.instance).hasGmpProjectId();
            }

            public boolean hasPackageName() {
                return ((PackageData) this.instance).hasPackageName();
            }

            public boolean hasRequestedCacheExpirationSeconds() {
                return ((PackageData) this.instance).hasRequestedCacheExpirationSeconds();
            }

            public boolean hasSdkVersion() {
                return ((PackageData) this.instance).hasSdkVersion();
            }

            public boolean hasVersionCode() {
                return ((PackageData) this.instance).hasVersionCode();
            }

            public Builder removeAnalyticsUserProperty(int i) {
                copyOnWrite();
                ((PackageData) this.instance).removeAnalyticsUserProperty(i);
                return this;
            }

            public Builder removeCustomVariable(int i) {
                copyOnWrite();
                ((PackageData) this.instance).removeCustomVariable(i);
                return this;
            }

            public Builder removeNamespaceDigest(int i) {
                copyOnWrite();
                ((PackageData) this.instance).removeNamespaceDigest(i);
                return this;
            }

            public Builder setActiveConfigAgeSeconds(int i) {
                copyOnWrite();
                ((PackageData) this.instance).setActiveConfigAgeSeconds(i);
                return this;
            }

            public Builder setAnalyticsUserProperty(int i, NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).setAnalyticsUserProperty(i, namedValue);
                return this;
            }

            public Builder setAppCertHash(C3995f fVar) {
                copyOnWrite();
                ((PackageData) this.instance).setAppCertHash(fVar);
                return this;
            }

            public Builder setAppInstanceId(String str) {
                copyOnWrite();
                ((PackageData) this.instance).setAppInstanceId(str);
                return this;
            }

            public Builder setAppInstanceIdBytes(C3995f fVar) {
                copyOnWrite();
                ((PackageData) this.instance).setAppInstanceIdBytes(fVar);
                return this;
            }

            public Builder setAppInstanceIdToken(String str) {
                copyOnWrite();
                ((PackageData) this.instance).setAppInstanceIdToken(str);
                return this;
            }

            public Builder setAppInstanceIdTokenBytes(C3995f fVar) {
                copyOnWrite();
                ((PackageData) this.instance).setAppInstanceIdTokenBytes(fVar);
                return this;
            }

            public Builder setAppVersion(String str) {
                copyOnWrite();
                ((PackageData) this.instance).setAppVersion(str);
                return this;
            }

            public Builder setAppVersionBytes(C3995f fVar) {
                copyOnWrite();
                ((PackageData) this.instance).setAppVersionBytes(fVar);
                return this;
            }

            public Builder setAppVersionCode(int i) {
                copyOnWrite();
                ((PackageData) this.instance).setAppVersionCode(i);
                return this;
            }

            public Builder setCertHash(C3995f fVar) {
                copyOnWrite();
                ((PackageData) this.instance).setCertHash(fVar);
                return this;
            }

            public Builder setConfigId(String str) {
                copyOnWrite();
                ((PackageData) this.instance).setConfigId(str);
                return this;
            }

            public Builder setConfigIdBytes(C3995f fVar) {
                copyOnWrite();
                ((PackageData) this.instance).setConfigIdBytes(fVar);
                return this;
            }

            public Builder setCustomVariable(int i, NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).setCustomVariable(i, namedValue);
                return this;
            }

            public Builder setDigest(C3995f fVar) {
                copyOnWrite();
                ((PackageData) this.instance).setDigest(fVar);
                return this;
            }

            public Builder setFetchedConfigAgeSeconds(int i) {
                copyOnWrite();
                ((PackageData) this.instance).setFetchedConfigAgeSeconds(i);
                return this;
            }

            public Builder setGamesProjectId(String str) {
                copyOnWrite();
                ((PackageData) this.instance).setGamesProjectId(str);
                return this;
            }

            public Builder setGamesProjectIdBytes(C3995f fVar) {
                copyOnWrite();
                ((PackageData) this.instance).setGamesProjectIdBytes(fVar);
                return this;
            }

            public Builder setGmpProjectId(String str) {
                copyOnWrite();
                ((PackageData) this.instance).setGmpProjectId(str);
                return this;
            }

            public Builder setGmpProjectIdBytes(C3995f fVar) {
                copyOnWrite();
                ((PackageData) this.instance).setGmpProjectIdBytes(fVar);
                return this;
            }

            public Builder setNamespaceDigest(int i, NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).setNamespaceDigest(i, namedValue);
                return this;
            }

            public Builder setPackageName(String str) {
                copyOnWrite();
                ((PackageData) this.instance).setPackageName(str);
                return this;
            }

            public Builder setPackageNameBytes(C3995f fVar) {
                copyOnWrite();
                ((PackageData) this.instance).setPackageNameBytes(fVar);
                return this;
            }

            public Builder setRequestedCacheExpirationSeconds(int i) {
                copyOnWrite();
                ((PackageData) this.instance).setRequestedCacheExpirationSeconds(i);
                return this;
            }

            public Builder setRequestedHiddenNamespace(int i, String str) {
                copyOnWrite();
                ((PackageData) this.instance).setRequestedHiddenNamespace(i, str);
                return this;
            }

            public Builder setSdkVersion(int i) {
                copyOnWrite();
                ((PackageData) this.instance).setSdkVersion(i);
                return this;
            }

            public Builder setVersionCode(int i) {
                copyOnWrite();
                ((PackageData) this.instance).setVersionCode(i);
                return this;
            }

            private Builder() {
                super(PackageData.DEFAULT_INSTANCE);
            }

            public Builder addAnalyticsUserProperty(int i, NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).addAnalyticsUserProperty(i, namedValue);
                return this;
            }

            public Builder addCustomVariable(int i, NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).addCustomVariable(i, namedValue);
                return this;
            }

            public Builder addNamespaceDigest(int i, NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).addNamespaceDigest(i, namedValue);
                return this;
            }

            public Builder setAnalyticsUserProperty(int i, NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).setAnalyticsUserProperty(i, builder);
                return this;
            }

            public Builder setCustomVariable(int i, NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).setCustomVariable(i, builder);
                return this;
            }

            public Builder setNamespaceDigest(int i, NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).setNamespaceDigest(i, builder);
                return this;
            }

            public Builder addAnalyticsUserProperty(NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).addAnalyticsUserProperty(builder);
                return this;
            }

            public Builder addCustomVariable(NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).addCustomVariable(builder);
                return this;
            }

            public Builder addNamespaceDigest(NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).addNamespaceDigest(builder);
                return this;
            }

            public Builder addAnalyticsUserProperty(int i, NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).addAnalyticsUserProperty(i, builder);
                return this;
            }

            public Builder addCustomVariable(int i, NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).addCustomVariable(i, builder);
                return this;
            }

            public Builder addNamespaceDigest(int i, NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).addNamespaceDigest(i, builder);
                return this;
            }
        }

        static {
            PackageData packageData = new PackageData();
            DEFAULT_INSTANCE = packageData;
            packageData.makeImmutable();
        }

        private PackageData() {
            C3995f fVar = C3995f.f10759b;
            this.digest_ = fVar;
            this.certHash_ = fVar;
        }

        /* access modifiers changed from: private */
        public void addAllAnalyticsUserProperty(Iterable<? extends NamedValue> iterable) {
            ensureAnalyticsUserPropertyIsMutable();
            C3969a.addAll(iterable, this.analyticsUserProperty_);
        }

        /* access modifiers changed from: private */
        public void addAllCustomVariable(Iterable<? extends NamedValue> iterable) {
            ensureCustomVariableIsMutable();
            C3969a.addAll(iterable, this.customVariable_);
        }

        /* access modifiers changed from: private */
        public void addAllNamespaceDigest(Iterable<? extends NamedValue> iterable) {
            ensureNamespaceDigestIsMutable();
            C3969a.addAll(iterable, this.namespaceDigest_);
        }

        /* access modifiers changed from: private */
        public void addAllRequestedHiddenNamespace(Iterable<String> iterable) {
            ensureRequestedHiddenNamespaceIsMutable();
            C3969a.addAll(iterable, this.requestedHiddenNamespace_);
        }

        /* access modifiers changed from: private */
        public void addAnalyticsUserProperty(NamedValue namedValue) {
            if (namedValue != null) {
                ensureAnalyticsUserPropertyIsMutable();
                this.analyticsUserProperty_.add(namedValue);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addCustomVariable(NamedValue namedValue) {
            if (namedValue != null) {
                ensureCustomVariableIsMutable();
                this.customVariable_.add(namedValue);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addNamespaceDigest(NamedValue namedValue) {
            if (namedValue != null) {
                ensureNamespaceDigestIsMutable();
                this.namespaceDigest_.add(namedValue);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addRequestedHiddenNamespace(String str) {
            if (str != null) {
                ensureRequestedHiddenNamespaceIsMutable();
                this.requestedHiddenNamespace_.add(str);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addRequestedHiddenNamespaceBytes(C3995f fVar) {
            if (fVar != null) {
                ensureRequestedHiddenNamespaceIsMutable();
                this.requestedHiddenNamespace_.add(fVar.mo28116e());
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearActiveConfigAgeSeconds() {
            this.bitField0_ &= -32769;
            this.activeConfigAgeSeconds_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearAnalyticsUserProperty() {
            this.analyticsUserProperty_ = C4023n.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearAppCertHash() {
            this.bitField0_ &= -129;
            this.appCertHash_ = getDefaultInstance().getAppCertHash();
        }

        /* access modifiers changed from: private */
        public void clearAppInstanceId() {
            this.bitField0_ &= -1025;
            this.appInstanceId_ = getDefaultInstance().getAppInstanceId();
        }

        /* access modifiers changed from: private */
        public void clearAppInstanceIdToken() {
            this.bitField0_ &= -2049;
            this.appInstanceIdToken_ = getDefaultInstance().getAppInstanceIdToken();
        }

        /* access modifiers changed from: private */
        public void clearAppVersion() {
            this.bitField0_ &= -513;
            this.appVersion_ = getDefaultInstance().getAppVersion();
        }

        /* access modifiers changed from: private */
        public void clearAppVersionCode() {
            this.bitField0_ &= -257;
            this.appVersionCode_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearCertHash() {
            this.bitField0_ &= -5;
            this.certHash_ = getDefaultInstance().getCertHash();
        }

        /* access modifiers changed from: private */
        public void clearConfigId() {
            this.bitField0_ &= -9;
            this.configId_ = getDefaultInstance().getConfigId();
        }

        /* access modifiers changed from: private */
        public void clearCustomVariable() {
            this.customVariable_ = C4023n.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearDigest() {
            this.bitField0_ &= -3;
            this.digest_ = getDefaultInstance().getDigest();
        }

        /* access modifiers changed from: private */
        public void clearFetchedConfigAgeSeconds() {
            this.bitField0_ &= -16385;
            this.fetchedConfigAgeSeconds_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearGamesProjectId() {
            this.bitField0_ &= -65;
            this.gamesProjectId_ = getDefaultInstance().getGamesProjectId();
        }

        /* access modifiers changed from: private */
        public void clearGmpProjectId() {
            this.bitField0_ &= -33;
            this.gmpProjectId_ = getDefaultInstance().getGmpProjectId();
        }

        /* access modifiers changed from: private */
        public void clearNamespaceDigest() {
            this.namespaceDigest_ = C4023n.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearPackageName() {
            this.bitField0_ &= -17;
            this.packageName_ = getDefaultInstance().getPackageName();
        }

        /* access modifiers changed from: private */
        public void clearRequestedCacheExpirationSeconds() {
            this.bitField0_ &= -8193;
            this.requestedCacheExpirationSeconds_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearRequestedHiddenNamespace() {
            this.requestedHiddenNamespace_ = C4023n.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearSdkVersion() {
            this.bitField0_ &= -4097;
            this.sdkVersion_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearVersionCode() {
            this.bitField0_ &= -2;
            this.versionCode_ = 0;
        }

        private void ensureAnalyticsUserPropertyIsMutable() {
            if (!this.analyticsUserProperty_.mo28080v()) {
                this.analyticsUserProperty_ = C4023n.mutableCopy(this.analyticsUserProperty_);
            }
        }

        private void ensureCustomVariableIsMutable() {
            if (!this.customVariable_.mo28080v()) {
                this.customVariable_ = C4023n.mutableCopy(this.customVariable_);
            }
        }

        private void ensureNamespaceDigestIsMutable() {
            if (!this.namespaceDigest_.mo28080v()) {
                this.namespaceDigest_ = C4023n.mutableCopy(this.namespaceDigest_);
            }
        }

        private void ensureRequestedHiddenNamespaceIsMutable() {
            if (!this.requestedHiddenNamespace_.mo28080v()) {
                this.requestedHiddenNamespace_ = C4023n.mutableCopy(this.requestedHiddenNamespace_);
            }
        }

        public static PackageData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static PackageData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PackageData) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PackageData parseFrom(C3995f fVar) throws InvalidProtocolBufferException {
            return (PackageData) C4023n.parseFrom(DEFAULT_INSTANCE, fVar);
        }

        public static C4058x<PackageData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void removeAnalyticsUserProperty(int i) {
            ensureAnalyticsUserPropertyIsMutable();
            this.analyticsUserProperty_.remove(i);
        }

        /* access modifiers changed from: private */
        public void removeCustomVariable(int i) {
            ensureCustomVariableIsMutable();
            this.customVariable_.remove(i);
        }

        /* access modifiers changed from: private */
        public void removeNamespaceDigest(int i) {
            ensureNamespaceDigestIsMutable();
            this.namespaceDigest_.remove(i);
        }

        /* access modifiers changed from: private */
        public void setActiveConfigAgeSeconds(int i) {
            this.bitField0_ |= 32768;
            this.activeConfigAgeSeconds_ = i;
        }

        /* access modifiers changed from: private */
        public void setAnalyticsUserProperty(int i, NamedValue namedValue) {
            if (namedValue != null) {
                ensureAnalyticsUserPropertyIsMutable();
                this.analyticsUserProperty_.set(i, namedValue);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setAppCertHash(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
                this.appCertHash_ = fVar;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setAppInstanceId(String str) {
            if (str != null) {
                this.bitField0_ |= OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS;
                this.appInstanceId_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setAppInstanceIdBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS;
                this.appInstanceId_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setAppInstanceIdToken(String str) {
            if (str != null) {
                this.bitField0_ |= 2048;
                this.appInstanceIdToken_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setAppInstanceIdTokenBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 2048;
                this.appInstanceIdToken_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setAppVersion(String str) {
            if (str != null) {
                this.bitField0_ |= 512;
                this.appVersion_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setAppVersionBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 512;
                this.appVersion_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setAppVersionCode(int i) {
            this.bitField0_ |= 256;
            this.appVersionCode_ = i;
        }

        /* access modifiers changed from: private */
        public void setCertHash(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 4;
                this.certHash_ = fVar;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setConfigId(String str) {
            if (str != null) {
                this.bitField0_ |= 8;
                this.configId_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setConfigIdBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 8;
                this.configId_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setCustomVariable(int i, NamedValue namedValue) {
            if (namedValue != null) {
                ensureCustomVariableIsMutable();
                this.customVariable_.set(i, namedValue);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setDigest(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 2;
                this.digest_ = fVar;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setFetchedConfigAgeSeconds(int i) {
            this.bitField0_ |= 16384;
            this.fetchedConfigAgeSeconds_ = i;
        }

        /* access modifiers changed from: private */
        public void setGamesProjectId(String str) {
            if (str != null) {
                this.bitField0_ |= 64;
                this.gamesProjectId_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setGamesProjectIdBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 64;
                this.gamesProjectId_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setGmpProjectId(String str) {
            if (str != null) {
                this.bitField0_ |= 32;
                this.gmpProjectId_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setGmpProjectIdBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 32;
                this.gmpProjectId_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setNamespaceDigest(int i, NamedValue namedValue) {
            if (namedValue != null) {
                ensureNamespaceDigestIsMutable();
                this.namespaceDigest_.set(i, namedValue);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setPackageName(String str) {
            if (str != null) {
                this.bitField0_ |= 16;
                this.packageName_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setPackageNameBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 16;
                this.packageName_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setRequestedCacheExpirationSeconds(int i) {
            this.bitField0_ |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            this.requestedCacheExpirationSeconds_ = i;
        }

        /* access modifiers changed from: private */
        public void setRequestedHiddenNamespace(int i, String str) {
            if (str != null) {
                ensureRequestedHiddenNamespaceIsMutable();
                this.requestedHiddenNamespace_.set(i, str);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setSdkVersion(int i) {
            this.bitField0_ |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
            this.sdkVersion_ = i;
        }

        /* access modifiers changed from: private */
        public void setVersionCode(int i) {
            this.bitField0_ |= 1;
            this.versionCode_ = i;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
            switch (C30861.f8636xa1df5c61[kVar.ordinal()]) {
                case 1:
                    return new PackageData();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.namespaceDigest_.mo28079t();
                    this.customVariable_.mo28079t();
                    this.requestedHiddenNamespace_.mo28079t();
                    this.analyticsUserProperty_.mo28079t();
                    return null;
                case 4:
                    return new Builder((C30861) null);
                case 5:
                    C4023n.C4036l lVar = (C4023n.C4036l) obj;
                    PackageData packageData = (PackageData) obj2;
                    this.versionCode_ = lVar.mo28215a(hasVersionCode(), this.versionCode_, packageData.hasVersionCode(), packageData.versionCode_);
                    this.digest_ = lVar.mo28218a(hasDigest(), this.digest_, packageData.hasDigest(), packageData.digest_);
                    this.certHash_ = lVar.mo28218a(hasCertHash(), this.certHash_, packageData.hasCertHash(), packageData.certHash_);
                    this.configId_ = lVar.mo28222a(hasConfigId(), this.configId_, packageData.hasConfigId(), packageData.configId_);
                    this.packageName_ = lVar.mo28222a(hasPackageName(), this.packageName_, packageData.hasPackageName(), packageData.packageName_);
                    this.gmpProjectId_ = lVar.mo28222a(hasGmpProjectId(), this.gmpProjectId_, packageData.hasGmpProjectId(), packageData.gmpProjectId_);
                    this.gamesProjectId_ = lVar.mo28222a(hasGamesProjectId(), this.gamesProjectId_, packageData.hasGamesProjectId(), packageData.gamesProjectId_);
                    this.namespaceDigest_ = lVar.mo28220a(this.namespaceDigest_, packageData.namespaceDigest_);
                    this.customVariable_ = lVar.mo28220a(this.customVariable_, packageData.customVariable_);
                    this.appCertHash_ = lVar.mo28218a(hasAppCertHash(), this.appCertHash_, packageData.hasAppCertHash(), packageData.appCertHash_);
                    this.appVersionCode_ = lVar.mo28215a(hasAppVersionCode(), this.appVersionCode_, packageData.hasAppVersionCode(), packageData.appVersionCode_);
                    this.appVersion_ = lVar.mo28222a(hasAppVersion(), this.appVersion_, packageData.hasAppVersion(), packageData.appVersion_);
                    this.appInstanceId_ = lVar.mo28222a(hasAppInstanceId(), this.appInstanceId_, packageData.hasAppInstanceId(), packageData.appInstanceId_);
                    this.appInstanceIdToken_ = lVar.mo28222a(hasAppInstanceIdToken(), this.appInstanceIdToken_, packageData.hasAppInstanceIdToken(), packageData.appInstanceIdToken_);
                    this.requestedHiddenNamespace_ = lVar.mo28220a(this.requestedHiddenNamespace_, packageData.requestedHiddenNamespace_);
                    this.sdkVersion_ = lVar.mo28215a(hasSdkVersion(), this.sdkVersion_, packageData.hasSdkVersion(), packageData.sdkVersion_);
                    this.analyticsUserProperty_ = lVar.mo28220a(this.analyticsUserProperty_, packageData.analyticsUserProperty_);
                    this.requestedCacheExpirationSeconds_ = lVar.mo28215a(hasRequestedCacheExpirationSeconds(), this.requestedCacheExpirationSeconds_, packageData.hasRequestedCacheExpirationSeconds(), packageData.requestedCacheExpirationSeconds_);
                    this.fetchedConfigAgeSeconds_ = lVar.mo28215a(hasFetchedConfigAgeSeconds(), this.fetchedConfigAgeSeconds_, packageData.hasFetchedConfigAgeSeconds(), packageData.fetchedConfigAgeSeconds_);
                    this.activeConfigAgeSeconds_ = lVar.mo28215a(hasActiveConfigAgeSeconds(), this.activeConfigAgeSeconds_, packageData.hasActiveConfigAgeSeconds(), packageData.activeConfigAgeSeconds_);
                    if (lVar == C4023n.C4034j.f10839a) {
                        this.bitField0_ |= packageData.bitField0_;
                    }
                    return this;
                case 6:
                    C4013g gVar = (C4013g) obj;
                    C4018k kVar2 = (C4018k) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int q = gVar.mo28155q();
                            switch (q) {
                                case 0:
                                    z = true;
                                    break;
                                case 10:
                                    String o = gVar.mo28153o();
                                    this.bitField0_ |= 16;
                                    this.packageName_ = o;
                                    break;
                                case 16:
                                    this.bitField0_ |= 1;
                                    this.versionCode_ = gVar.mo28145g();
                                    break;
                                case 26:
                                    this.bitField0_ |= 2;
                                    this.digest_ = gVar.mo28139c();
                                    break;
                                case 34:
                                    this.bitField0_ |= 4;
                                    this.certHash_ = gVar.mo28139c();
                                    break;
                                case 42:
                                    String o2 = gVar.mo28153o();
                                    this.bitField0_ |= 8;
                                    this.configId_ = o2;
                                    break;
                                case 50:
                                    String o3 = gVar.mo28153o();
                                    this.bitField0_ |= 32;
                                    this.gmpProjectId_ = o3;
                                    break;
                                case 58:
                                    String o4 = gVar.mo28153o();
                                    this.bitField0_ |= 64;
                                    this.gamesProjectId_ = o4;
                                    break;
                                case 66:
                                    if (!this.namespaceDigest_.mo28080v()) {
                                        this.namespaceDigest_ = C4023n.mutableCopy(this.namespaceDigest_);
                                    }
                                    this.namespaceDigest_.add((NamedValue) gVar.mo28133a(NamedValue.parser(), kVar2));
                                    break;
                                case 74:
                                    if (!this.customVariable_.mo28080v()) {
                                        this.customVariable_ = C4023n.mutableCopy(this.customVariable_);
                                    }
                                    this.customVariable_.add((NamedValue) gVar.mo28133a(NamedValue.parser(), kVar2));
                                    break;
                                case 82:
                                    this.bitField0_ |= OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
                                    this.appCertHash_ = gVar.mo28139c();
                                    break;
                                case 88:
                                    this.bitField0_ |= 256;
                                    this.appVersionCode_ = gVar.mo28145g();
                                    break;
                                case 98:
                                    String o5 = gVar.mo28153o();
                                    this.bitField0_ |= OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS;
                                    this.appInstanceId_ = o5;
                                    break;
                                case 106:
                                    String o6 = gVar.mo28153o();
                                    this.bitField0_ |= 512;
                                    this.appVersion_ = o6;
                                    break;
                                case 114:
                                    String o7 = gVar.mo28153o();
                                    this.bitField0_ |= 2048;
                                    this.appInstanceIdToken_ = o7;
                                    break;
                                case 122:
                                    String o8 = gVar.mo28153o();
                                    if (!this.requestedHiddenNamespace_.mo28080v()) {
                                        this.requestedHiddenNamespace_ = C4023n.mutableCopy(this.requestedHiddenNamespace_);
                                    }
                                    this.requestedHiddenNamespace_.add(o8);
                                    break;
                                case OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE /*128*/:
                                    this.bitField0_ |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
                                    this.sdkVersion_ = gVar.mo28145g();
                                    break;
                                case 138:
                                    if (!this.analyticsUserProperty_.mo28080v()) {
                                        this.analyticsUserProperty_ = C4023n.mutableCopy(this.analyticsUserProperty_);
                                    }
                                    this.analyticsUserProperty_.add((NamedValue) gVar.mo28133a(NamedValue.parser(), kVar2));
                                    break;
                                case 144:
                                    this.bitField0_ |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                                    this.requestedCacheExpirationSeconds_ = gVar.mo28145g();
                                    break;
                                case 152:
                                    this.bitField0_ |= 16384;
                                    this.fetchedConfigAgeSeconds_ = gVar.mo28145g();
                                    break;
                                case 160:
                                    this.bitField0_ |= 32768;
                                    this.activeConfigAgeSeconds_ = gVar.mo28145g();
                                    break;
                                default:
                                    if (parseUnknownField(q, gVar)) {
                                        break;
                                    }
                                    z = true;
                                    break;
                            }
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
                        synchronized (PackageData.class) {
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

        public int getActiveConfigAgeSeconds() {
            return this.activeConfigAgeSeconds_;
        }

        public NamedValue getAnalyticsUserProperty(int i) {
            return this.analyticsUserProperty_.get(i);
        }

        public int getAnalyticsUserPropertyCount() {
            return this.analyticsUserProperty_.size();
        }

        public List<NamedValue> getAnalyticsUserPropertyList() {
            return this.analyticsUserProperty_;
        }

        public NamedValueOrBuilder getAnalyticsUserPropertyOrBuilder(int i) {
            return this.analyticsUserProperty_.get(i);
        }

        public List<? extends NamedValueOrBuilder> getAnalyticsUserPropertyOrBuilderList() {
            return this.analyticsUserProperty_;
        }

        public C3995f getAppCertHash() {
            return this.appCertHash_;
        }

        public String getAppInstanceId() {
            return this.appInstanceId_;
        }

        public C3995f getAppInstanceIdBytes() {
            return C3995f.m13320a(this.appInstanceId_);
        }

        public String getAppInstanceIdToken() {
            return this.appInstanceIdToken_;
        }

        public C3995f getAppInstanceIdTokenBytes() {
            return C3995f.m13320a(this.appInstanceIdToken_);
        }

        public String getAppVersion() {
            return this.appVersion_;
        }

        public C3995f getAppVersionBytes() {
            return C3995f.m13320a(this.appVersion_);
        }

        public int getAppVersionCode() {
            return this.appVersionCode_;
        }

        public C3995f getCertHash() {
            return this.certHash_;
        }

        public String getConfigId() {
            return this.configId_;
        }

        public C3995f getConfigIdBytes() {
            return C3995f.m13320a(this.configId_);
        }

        public NamedValue getCustomVariable(int i) {
            return this.customVariable_.get(i);
        }

        public int getCustomVariableCount() {
            return this.customVariable_.size();
        }

        public List<NamedValue> getCustomVariableList() {
            return this.customVariable_;
        }

        public NamedValueOrBuilder getCustomVariableOrBuilder(int i) {
            return this.customVariable_.get(i);
        }

        public List<? extends NamedValueOrBuilder> getCustomVariableOrBuilderList() {
            return this.customVariable_;
        }

        public C3995f getDigest() {
            return this.digest_;
        }

        public int getFetchedConfigAgeSeconds() {
            return this.fetchedConfigAgeSeconds_;
        }

        public String getGamesProjectId() {
            return this.gamesProjectId_;
        }

        public C3995f getGamesProjectIdBytes() {
            return C3995f.m13320a(this.gamesProjectId_);
        }

        public String getGmpProjectId() {
            return this.gmpProjectId_;
        }

        public C3995f getGmpProjectIdBytes() {
            return C3995f.m13320a(this.gmpProjectId_);
        }

        public NamedValue getNamespaceDigest(int i) {
            return this.namespaceDigest_.get(i);
        }

        public int getNamespaceDigestCount() {
            return this.namespaceDigest_.size();
        }

        public List<NamedValue> getNamespaceDigestList() {
            return this.namespaceDigest_;
        }

        public NamedValueOrBuilder getNamespaceDigestOrBuilder(int i) {
            return this.namespaceDigest_.get(i);
        }

        public List<? extends NamedValueOrBuilder> getNamespaceDigestOrBuilderList() {
            return this.namespaceDigest_;
        }

        public String getPackageName() {
            return this.packageName_;
        }

        public C3995f getPackageNameBytes() {
            return C3995f.m13320a(this.packageName_);
        }

        public int getRequestedCacheExpirationSeconds() {
            return this.requestedCacheExpirationSeconds_;
        }

        public String getRequestedHiddenNamespace(int i) {
            return this.requestedHiddenNamespace_.get(i);
        }

        public C3995f getRequestedHiddenNamespaceBytes(int i) {
            return C3995f.m13320a(this.requestedHiddenNamespace_.get(i));
        }

        public int getRequestedHiddenNamespaceCount() {
            return this.requestedHiddenNamespace_.size();
        }

        public List<String> getRequestedHiddenNamespaceList() {
            return this.requestedHiddenNamespace_;
        }

        public int getSdkVersion() {
            return this.sdkVersion_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int b = (this.bitField0_ & 16) == 16 ? CodedOutputStream.m13124b(1, getPackageName()) + 0 : 0;
            if ((this.bitField0_ & 1) == 1) {
                b += CodedOutputStream.m13141g(2, this.versionCode_);
            }
            if ((this.bitField0_ & 2) == 2) {
                b += CodedOutputStream.m13122b(3, this.digest_);
            }
            if ((this.bitField0_ & 4) == 4) {
                b += CodedOutputStream.m13122b(4, this.certHash_);
            }
            if ((this.bitField0_ & 8) == 8) {
                b += CodedOutputStream.m13124b(5, getConfigId());
            }
            if ((this.bitField0_ & 32) == 32) {
                b += CodedOutputStream.m13124b(6, getGmpProjectId());
            }
            if ((this.bitField0_ & 64) == 64) {
                b += CodedOutputStream.m13124b(7, getGamesProjectId());
            }
            for (int i2 = 0; i2 < this.namespaceDigest_.size(); i2++) {
                b += CodedOutputStream.m13123b(8, (C4054u) this.namespaceDigest_.get(i2));
            }
            for (int i3 = 0; i3 < this.customVariable_.size(); i3++) {
                b += CodedOutputStream.m13123b(9, (C4054u) this.customVariable_.get(i3));
            }
            if ((this.bitField0_ & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) == 128) {
                b += CodedOutputStream.m13122b(10, this.appCertHash_);
            }
            if ((this.bitField0_ & 256) == 256) {
                b += CodedOutputStream.m13141g(11, this.appVersionCode_);
            }
            if ((this.bitField0_ & OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS) == 1024) {
                b += CodedOutputStream.m13124b(12, getAppInstanceId());
            }
            if ((this.bitField0_ & 512) == 512) {
                b += CodedOutputStream.m13124b(13, getAppVersion());
            }
            if ((this.bitField0_ & 2048) == 2048) {
                b += CodedOutputStream.m13124b(14, getAppInstanceIdToken());
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.requestedHiddenNamespace_.size(); i5++) {
                i4 += CodedOutputStream.m13118a(this.requestedHiddenNamespace_.get(i5));
            }
            int size = b + i4 + (getRequestedHiddenNamespaceList().size() * 1);
            if ((this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096) {
                size += CodedOutputStream.m13141g(16, this.sdkVersion_);
            }
            for (int i6 = 0; i6 < this.analyticsUserProperty_.size(); i6++) {
                size += CodedOutputStream.m13123b(17, (C4054u) this.analyticsUserProperty_.get(i6));
            }
            if ((this.bitField0_ & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 8192) {
                size += CodedOutputStream.m13141g(18, this.requestedCacheExpirationSeconds_);
            }
            if ((this.bitField0_ & 16384) == 16384) {
                size += CodedOutputStream.m13141g(19, this.fetchedConfigAgeSeconds_);
            }
            if ((this.bitField0_ & 32768) == 32768) {
                size += CodedOutputStream.m13141g(20, this.activeConfigAgeSeconds_);
            }
            int b2 = size + this.unknownFields.mo28087b();
            this.memoizedSerializedSize = b2;
            return b2;
        }

        public int getVersionCode() {
            return this.versionCode_;
        }

        public boolean hasActiveConfigAgeSeconds() {
            return (this.bitField0_ & 32768) == 32768;
        }

        public boolean hasAppCertHash() {
            return (this.bitField0_ & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) == 128;
        }

        public boolean hasAppInstanceId() {
            return (this.bitField0_ & OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS) == 1024;
        }

        public boolean hasAppInstanceIdToken() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public boolean hasAppVersion() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean hasAppVersionCode() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasCertHash() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasConfigId() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasDigest() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasFetchedConfigAgeSeconds() {
            return (this.bitField0_ & 16384) == 16384;
        }

        public boolean hasGamesProjectId() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasGmpProjectId() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasPackageName() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasRequestedCacheExpirationSeconds() {
            return (this.bitField0_ & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 8192;
        }

        public boolean hasSdkVersion() {
            return (this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096;
        }

        public boolean hasVersionCode() {
            return (this.bitField0_ & 1) == 1;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.mo27969a(1, getPackageName());
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.mo27977c(2, this.versionCode_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.mo27967a(3, this.digest_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.mo27967a(4, this.certHash_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.mo27969a(5, getConfigId());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.mo27969a(6, getGmpProjectId());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.mo27969a(7, getGamesProjectId());
            }
            for (int i = 0; i < this.namespaceDigest_.size(); i++) {
                codedOutputStream.mo27968a(8, (C4054u) this.namespaceDigest_.get(i));
            }
            for (int i2 = 0; i2 < this.customVariable_.size(); i2++) {
                codedOutputStream.mo27968a(9, (C4054u) this.customVariable_.get(i2));
            }
            if ((this.bitField0_ & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) == 128) {
                codedOutputStream.mo27967a(10, this.appCertHash_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.mo27977c(11, this.appVersionCode_);
            }
            if ((this.bitField0_ & OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS) == 1024) {
                codedOutputStream.mo27969a(12, getAppInstanceId());
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.mo27969a(13, getAppVersion());
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.mo27969a(14, getAppInstanceIdToken());
            }
            for (int i3 = 0; i3 < this.requestedHiddenNamespace_.size(); i3++) {
                codedOutputStream.mo27969a(15, this.requestedHiddenNamespace_.get(i3));
            }
            if ((this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096) {
                codedOutputStream.mo27977c(16, this.sdkVersion_);
            }
            for (int i4 = 0; i4 < this.analyticsUserProperty_.size(); i4++) {
                codedOutputStream.mo27968a(17, (C4054u) this.analyticsUserProperty_.get(i4));
            }
            if ((this.bitField0_ & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 8192) {
                codedOutputStream.mo27977c(18, this.requestedCacheExpirationSeconds_);
            }
            if ((this.bitField0_ & 16384) == 16384) {
                codedOutputStream.mo27977c(19, this.fetchedConfigAgeSeconds_);
            }
            if ((this.bitField0_ & 32768) == 32768) {
                codedOutputStream.mo27977c(20, this.activeConfigAgeSeconds_);
            }
            this.unknownFields.mo28084a(codedOutputStream);
        }

        public static Builder newBuilder(PackageData packageData) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(packageData);
        }

        public static PackageData parseDelimitedFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (PackageData) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        public static PackageData parseFrom(C3995f fVar, C4018k kVar) throws InvalidProtocolBufferException {
            return (PackageData) C4023n.parseFrom(DEFAULT_INSTANCE, fVar, kVar);
        }

        public static PackageData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PackageData) C4023n.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* access modifiers changed from: private */
        public void addAnalyticsUserProperty(int i, NamedValue namedValue) {
            if (namedValue != null) {
                ensureAnalyticsUserPropertyIsMutable();
                this.analyticsUserProperty_.add(i, namedValue);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addCustomVariable(int i, NamedValue namedValue) {
            if (namedValue != null) {
                ensureCustomVariableIsMutable();
                this.customVariable_.add(i, namedValue);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addNamespaceDigest(int i, NamedValue namedValue) {
            if (namedValue != null) {
                ensureNamespaceDigestIsMutable();
                this.namespaceDigest_.add(i, namedValue);
                return;
            }
            throw null;
        }

        public static PackageData parseFrom(byte[] bArr, C4018k kVar) throws InvalidProtocolBufferException {
            return (PackageData) C4023n.parseFrom(DEFAULT_INSTANCE, bArr, kVar);
        }

        /* access modifiers changed from: private */
        public void setAnalyticsUserProperty(int i, NamedValue.Builder builder) {
            ensureAnalyticsUserPropertyIsMutable();
            this.analyticsUserProperty_.set(i, (NamedValue) builder.build());
        }

        /* access modifiers changed from: private */
        public void setCustomVariable(int i, NamedValue.Builder builder) {
            ensureCustomVariableIsMutable();
            this.customVariable_.set(i, (NamedValue) builder.build());
        }

        /* access modifiers changed from: private */
        public void setNamespaceDigest(int i, NamedValue.Builder builder) {
            ensureNamespaceDigestIsMutable();
            this.namespaceDigest_.set(i, (NamedValue) builder.build());
        }

        public static PackageData parseFrom(InputStream inputStream) throws IOException {
            return (PackageData) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PackageData parseFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (PackageData) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        /* access modifiers changed from: private */
        public void addAnalyticsUserProperty(NamedValue.Builder builder) {
            ensureAnalyticsUserPropertyIsMutable();
            this.analyticsUserProperty_.add((NamedValue) builder.build());
        }

        /* access modifiers changed from: private */
        public void addCustomVariable(NamedValue.Builder builder) {
            ensureCustomVariableIsMutable();
            this.customVariable_.add((NamedValue) builder.build());
        }

        /* access modifiers changed from: private */
        public void addNamespaceDigest(NamedValue.Builder builder) {
            ensureNamespaceDigestIsMutable();
            this.namespaceDigest_.add((NamedValue) builder.build());
        }

        public static PackageData parseFrom(C4013g gVar) throws IOException {
            return (PackageData) C4023n.parseFrom(DEFAULT_INSTANCE, gVar);
        }

        public static PackageData parseFrom(C4013g gVar, C4018k kVar) throws IOException {
            return (PackageData) C4023n.parseFrom(DEFAULT_INSTANCE, gVar, kVar);
        }

        /* access modifiers changed from: private */
        public void addAnalyticsUserProperty(int i, NamedValue.Builder builder) {
            ensureAnalyticsUserPropertyIsMutable();
            this.analyticsUserProperty_.add(i, (NamedValue) builder.build());
        }

        /* access modifiers changed from: private */
        public void addCustomVariable(int i, NamedValue.Builder builder) {
            ensureCustomVariableIsMutable();
            this.customVariable_.add(i, (NamedValue) builder.build());
        }

        /* access modifiers changed from: private */
        public void addNamespaceDigest(int i, NamedValue.Builder builder) {
            ensureNamespaceDigestIsMutable();
            this.namespaceDigest_.add(i, (NamedValue) builder.build());
        }
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public interface PackageDataOrBuilder extends C4056v {
        int getActiveConfigAgeSeconds();

        NamedValue getAnalyticsUserProperty(int i);

        int getAnalyticsUserPropertyCount();

        List<NamedValue> getAnalyticsUserPropertyList();

        C3995f getAppCertHash();

        String getAppInstanceId();

        C3995f getAppInstanceIdBytes();

        String getAppInstanceIdToken();

        C3995f getAppInstanceIdTokenBytes();

        String getAppVersion();

        C3995f getAppVersionBytes();

        int getAppVersionCode();

        C3995f getCertHash();

        String getConfigId();

        C3995f getConfigIdBytes();

        NamedValue getCustomVariable(int i);

        int getCustomVariableCount();

        List<NamedValue> getCustomVariableList();

        C3995f getDigest();

        int getFetchedConfigAgeSeconds();

        String getGamesProjectId();

        C3995f getGamesProjectIdBytes();

        String getGmpProjectId();

        C3995f getGmpProjectIdBytes();

        NamedValue getNamespaceDigest(int i);

        int getNamespaceDigestCount();

        List<NamedValue> getNamespaceDigestList();

        String getPackageName();

        C3995f getPackageNameBytes();

        int getRequestedCacheExpirationSeconds();

        String getRequestedHiddenNamespace(int i);

        C3995f getRequestedHiddenNamespaceBytes(int i);

        int getRequestedHiddenNamespaceCount();

        List<String> getRequestedHiddenNamespaceList();

        int getSdkVersion();

        int getVersionCode();

        boolean hasActiveConfigAgeSeconds();

        boolean hasAppCertHash();

        boolean hasAppInstanceId();

        boolean hasAppInstanceIdToken();

        boolean hasAppVersion();

        boolean hasAppVersionCode();

        boolean hasCertHash();

        boolean hasConfigId();

        boolean hasDigest();

        boolean hasFetchedConfigAgeSeconds();

        boolean hasGamesProjectId();

        boolean hasGmpProjectId();

        boolean hasPackageName();

        boolean hasRequestedCacheExpirationSeconds();

        boolean hasSdkVersion();

        boolean hasVersionCode();
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class PackageTable extends C4023n<PackageTable, Builder> implements PackageTableOrBuilder {
        public static final int CONFIG_ID_FIELD_NUMBER = 3;
        /* access modifiers changed from: private */
        public static final PackageTable DEFAULT_INSTANCE;
        public static final int ENTRY_FIELD_NUMBER = 2;
        public static final int PACKAGE_NAME_FIELD_NUMBER = 1;
        private static volatile C4058x<PackageTable> PARSER;
        private int bitField0_;
        private String configId_ = "";
        private C4038p.C4046h<KeyValue> entry_ = C4023n.emptyProtobufList();
        private String packageName_ = "";

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public static final class Builder extends C4023n.C4025b<PackageTable, Builder> implements PackageTableOrBuilder {
            /* synthetic */ Builder(C30861 r1) {
                this();
            }

            public Builder addAllEntry(Iterable<? extends KeyValue> iterable) {
                copyOnWrite();
                ((PackageTable) this.instance).addAllEntry(iterable);
                return this;
            }

            public Builder addEntry(KeyValue keyValue) {
                copyOnWrite();
                ((PackageTable) this.instance).addEntry(keyValue);
                return this;
            }

            public Builder clearConfigId() {
                copyOnWrite();
                ((PackageTable) this.instance).clearConfigId();
                return this;
            }

            public Builder clearEntry() {
                copyOnWrite();
                ((PackageTable) this.instance).clearEntry();
                return this;
            }

            public Builder clearPackageName() {
                copyOnWrite();
                ((PackageTable) this.instance).clearPackageName();
                return this;
            }

            public String getConfigId() {
                return ((PackageTable) this.instance).getConfigId();
            }

            public C3995f getConfigIdBytes() {
                return ((PackageTable) this.instance).getConfigIdBytes();
            }

            public KeyValue getEntry(int i) {
                return ((PackageTable) this.instance).getEntry(i);
            }

            public int getEntryCount() {
                return ((PackageTable) this.instance).getEntryCount();
            }

            public List<KeyValue> getEntryList() {
                return Collections.unmodifiableList(((PackageTable) this.instance).getEntryList());
            }

            public String getPackageName() {
                return ((PackageTable) this.instance).getPackageName();
            }

            public C3995f getPackageNameBytes() {
                return ((PackageTable) this.instance).getPackageNameBytes();
            }

            public boolean hasConfigId() {
                return ((PackageTable) this.instance).hasConfigId();
            }

            public boolean hasPackageName() {
                return ((PackageTable) this.instance).hasPackageName();
            }

            public Builder removeEntry(int i) {
                copyOnWrite();
                ((PackageTable) this.instance).removeEntry(i);
                return this;
            }

            public Builder setConfigId(String str) {
                copyOnWrite();
                ((PackageTable) this.instance).setConfigId(str);
                return this;
            }

            public Builder setConfigIdBytes(C3995f fVar) {
                copyOnWrite();
                ((PackageTable) this.instance).setConfigIdBytes(fVar);
                return this;
            }

            public Builder setEntry(int i, KeyValue keyValue) {
                copyOnWrite();
                ((PackageTable) this.instance).setEntry(i, keyValue);
                return this;
            }

            public Builder setPackageName(String str) {
                copyOnWrite();
                ((PackageTable) this.instance).setPackageName(str);
                return this;
            }

            public Builder setPackageNameBytes(C3995f fVar) {
                copyOnWrite();
                ((PackageTable) this.instance).setPackageNameBytes(fVar);
                return this;
            }

            private Builder() {
                super(PackageTable.DEFAULT_INSTANCE);
            }

            public Builder addEntry(int i, KeyValue keyValue) {
                copyOnWrite();
                ((PackageTable) this.instance).addEntry(i, keyValue);
                return this;
            }

            public Builder setEntry(int i, KeyValue.Builder builder) {
                copyOnWrite();
                ((PackageTable) this.instance).setEntry(i, builder);
                return this;
            }

            public Builder addEntry(KeyValue.Builder builder) {
                copyOnWrite();
                ((PackageTable) this.instance).addEntry(builder);
                return this;
            }

            public Builder addEntry(int i, KeyValue.Builder builder) {
                copyOnWrite();
                ((PackageTable) this.instance).addEntry(i, builder);
                return this;
            }
        }

        static {
            PackageTable packageTable = new PackageTable();
            DEFAULT_INSTANCE = packageTable;
            packageTable.makeImmutable();
        }

        private PackageTable() {
        }

        /* access modifiers changed from: private */
        public void addAllEntry(Iterable<? extends KeyValue> iterable) {
            ensureEntryIsMutable();
            C3969a.addAll(iterable, this.entry_);
        }

        /* access modifiers changed from: private */
        public void addEntry(KeyValue keyValue) {
            if (keyValue != null) {
                ensureEntryIsMutable();
                this.entry_.add(keyValue);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearConfigId() {
            this.bitField0_ &= -3;
            this.configId_ = getDefaultInstance().getConfigId();
        }

        /* access modifiers changed from: private */
        public void clearEntry() {
            this.entry_ = C4023n.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void clearPackageName() {
            this.bitField0_ &= -2;
            this.packageName_ = getDefaultInstance().getPackageName();
        }

        private void ensureEntryIsMutable() {
            if (!this.entry_.mo28080v()) {
                this.entry_ = C4023n.mutableCopy(this.entry_);
            }
        }

        public static PackageTable getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static PackageTable parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PackageTable) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PackageTable parseFrom(C3995f fVar) throws InvalidProtocolBufferException {
            return (PackageTable) C4023n.parseFrom(DEFAULT_INSTANCE, fVar);
        }

        public static C4058x<PackageTable> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* access modifiers changed from: private */
        public void removeEntry(int i) {
            ensureEntryIsMutable();
            this.entry_.remove(i);
        }

        /* access modifiers changed from: private */
        public void setConfigId(String str) {
            if (str != null) {
                this.bitField0_ |= 2;
                this.configId_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setConfigIdBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 2;
                this.configId_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setEntry(int i, KeyValue keyValue) {
            if (keyValue != null) {
                ensureEntryIsMutable();
                this.entry_.set(i, keyValue);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setPackageName(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.packageName_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setPackageNameBytes(C3995f fVar) {
            if (fVar != null) {
                this.bitField0_ |= 1;
                this.packageName_ = fVar.mo28116e();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
            switch (C30861.f8636xa1df5c61[kVar.ordinal()]) {
                case 1:
                    return new PackageTable();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.entry_.mo28079t();
                    return null;
                case 4:
                    return new Builder((C30861) null);
                case 5:
                    C4023n.C4036l lVar = (C4023n.C4036l) obj;
                    PackageTable packageTable = (PackageTable) obj2;
                    this.packageName_ = lVar.mo28222a(hasPackageName(), this.packageName_, packageTable.hasPackageName(), packageTable.packageName_);
                    this.entry_ = lVar.mo28220a(this.entry_, packageTable.entry_);
                    this.configId_ = lVar.mo28222a(hasConfigId(), this.configId_, packageTable.hasConfigId(), packageTable.configId_);
                    if (lVar == C4023n.C4034j.f10839a) {
                        this.bitField0_ |= packageTable.bitField0_;
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
                                    String o = gVar.mo28153o();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.packageName_ = o;
                                } else if (q == 18) {
                                    if (!this.entry_.mo28080v()) {
                                        this.entry_ = C4023n.mutableCopy(this.entry_);
                                    }
                                    this.entry_.add((KeyValue) gVar.mo28133a(KeyValue.parser(), kVar2));
                                } else if (q == 26) {
                                    String o2 = gVar.mo28153o();
                                    this.bitField0_ |= 2;
                                    this.configId_ = o2;
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
                        synchronized (PackageTable.class) {
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

        public String getConfigId() {
            return this.configId_;
        }

        public C3995f getConfigIdBytes() {
            return C3995f.m13320a(this.configId_);
        }

        public KeyValue getEntry(int i) {
            return this.entry_.get(i);
        }

        public int getEntryCount() {
            return this.entry_.size();
        }

        public List<KeyValue> getEntryList() {
            return this.entry_;
        }

        public KeyValueOrBuilder getEntryOrBuilder(int i) {
            return this.entry_.get(i);
        }

        public List<? extends KeyValueOrBuilder> getEntryOrBuilderList() {
            return this.entry_;
        }

        public String getPackageName() {
            return this.packageName_;
        }

        public C3995f getPackageNameBytes() {
            return C3995f.m13320a(this.packageName_);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int b = (this.bitField0_ & 1) == 1 ? CodedOutputStream.m13124b(1, getPackageName()) + 0 : 0;
            for (int i2 = 0; i2 < this.entry_.size(); i2++) {
                b += CodedOutputStream.m13123b(2, (C4054u) this.entry_.get(i2));
            }
            if ((this.bitField0_ & 2) == 2) {
                b += CodedOutputStream.m13124b(3, getConfigId());
            }
            int b2 = b + this.unknownFields.mo28087b();
            this.memoizedSerializedSize = b2;
            return b2;
        }

        public boolean hasConfigId() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasPackageName() {
            return (this.bitField0_ & 1) == 1;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.mo27969a(1, getPackageName());
            }
            for (int i = 0; i < this.entry_.size(); i++) {
                codedOutputStream.mo27968a(2, (C4054u) this.entry_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.mo27969a(3, getConfigId());
            }
            this.unknownFields.mo28084a(codedOutputStream);
        }

        public static Builder newBuilder(PackageTable packageTable) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(packageTable);
        }

        public static PackageTable parseDelimitedFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (PackageTable) C4023n.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        public static PackageTable parseFrom(C3995f fVar, C4018k kVar) throws InvalidProtocolBufferException {
            return (PackageTable) C4023n.parseFrom(DEFAULT_INSTANCE, fVar, kVar);
        }

        public static PackageTable parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PackageTable) C4023n.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        /* access modifiers changed from: private */
        public void addEntry(int i, KeyValue keyValue) {
            if (keyValue != null) {
                ensureEntryIsMutable();
                this.entry_.add(i, keyValue);
                return;
            }
            throw null;
        }

        public static PackageTable parseFrom(byte[] bArr, C4018k kVar) throws InvalidProtocolBufferException {
            return (PackageTable) C4023n.parseFrom(DEFAULT_INSTANCE, bArr, kVar);
        }

        /* access modifiers changed from: private */
        public void setEntry(int i, KeyValue.Builder builder) {
            ensureEntryIsMutable();
            this.entry_.set(i, (KeyValue) builder.build());
        }

        public static PackageTable parseFrom(InputStream inputStream) throws IOException {
            return (PackageTable) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PackageTable parseFrom(InputStream inputStream, C4018k kVar) throws IOException {
            return (PackageTable) C4023n.parseFrom(DEFAULT_INSTANCE, inputStream, kVar);
        }

        /* access modifiers changed from: private */
        public void addEntry(KeyValue.Builder builder) {
            ensureEntryIsMutable();
            this.entry_.add((KeyValue) builder.build());
        }

        public static PackageTable parseFrom(C4013g gVar) throws IOException {
            return (PackageTable) C4023n.parseFrom(DEFAULT_INSTANCE, gVar);
        }

        public static PackageTable parseFrom(C4013g gVar, C4018k kVar) throws IOException {
            return (PackageTable) C4023n.parseFrom(DEFAULT_INSTANCE, gVar, kVar);
        }

        /* access modifiers changed from: private */
        public void addEntry(int i, KeyValue.Builder builder) {
            ensureEntryIsMutable();
            this.entry_.add(i, (KeyValue) builder.build());
        }
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public interface PackageTableOrBuilder extends C4056v {
        String getConfigId();

        C3995f getConfigIdBytes();

        KeyValue getEntry(int i);

        int getEntryCount();

        List<KeyValue> getEntryList();

        String getPackageName();

        C3995f getPackageNameBytes();

        boolean hasConfigId();

        boolean hasPackageName();
    }

    private Config() {
    }

    public static void registerAllExtensions(C4018k kVar) {
    }
}
