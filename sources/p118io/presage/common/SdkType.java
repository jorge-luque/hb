package p118io.presage.common;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyConstants;

/* renamed from: io.presage.common.SdkType */
public final class SdkType {

    /* renamed from: a */
    public static final CamembertauCalvados f16924a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final SharedPreferences f16925b;

    /* renamed from: io.presage.common.SdkType$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static SdkType m21155a(Context context) {
            return new SdkType(context, (byte) 0);
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    private SdkType(Context context) {
        this.f16925b = context.getSharedPreferences("sdktypefile", 0);
    }

    public static final SdkType create(Context context) {
        return CamembertauCalvados.m21155a(context);
    }

    /* renamed from: a */
    public final int mo34891a() {
        return this.f16925b.getInt(TapjoyConstants.TJC_SDK_TYPE, 0);
    }

    public final void setType(int i) {
        this.f16925b.edit().putInt(TapjoyConstants.TJC_SDK_TYPE, i).apply();
    }

    public /* synthetic */ SdkType(Context context, byte b) {
        this(context);
    }
}
