package p118io.presage;

import android.graphics.Rect;

/* renamed from: io.presage.ay */
public final class C6234ay {

    /* renamed from: a */
    public static final C6234ay f16776a = new C6234ay();

    private C6234ay() {
    }

    /* renamed from: a */
    public static String m20852a() {
        return "ogySdkMraidGateway.updateSupportFlags({sms: false, tel: false, calendar: false, storePicture: false, inlineVideo: false, vpaid: false, location: false})";
    }

    /* renamed from: a */
    public static String m20858a(String str, String str2) {
        return "ogySdkMraidGateway.callErrorListeners(\"" + str2 + "\", \"" + str + "\")";
    }

    /* renamed from: b */
    public static String m20863b() {
        return "ogySdkMraidGateway.callEventListeners(\"ogyOnCloseSystem\", {})";
    }

    /* renamed from: b */
    public static String m20864b(int i, int i2) {
        return "ogySdkMraidGateway.updateMaxSize({width: " + i + ", height: " + i2 + "})";
    }

    /* renamed from: c */
    public static String m20868c() {
        return "ogySdkMraidGateway.callEventListeners(\"ogyOnTouchEnd\", {})";
    }

    /* renamed from: c */
    public static String m20870c(int i, int i2, int i3, int i4) {
        return "ogySdkMraidGateway.updateResizeProperties({width: " + i + ", height: " + i2 + ", offsetX: " + i3 + ", offsetY: " + i4 + ", customClosePosition: \"right\", allowOffscreen: false})";
    }

    /* renamed from: a */
    public static String m20853a(int i) {
        return "ogySdkMraidGateway.updateAudioVolume(" + i + ')';
    }

    /* renamed from: b */
    public static String m20865b(int i, int i2, int i3, int i4) {
        return "ogySdkMraidGateway.updateCurrentPosition({x: " + i3 + ", y: " + i4 + ", width: " + i + ", height: " + i2 + "})";
    }

    /* renamed from: c */
    public static String m20869c(int i, int i2) {
        return "ogySdkMraidGateway.updateExpandProperties({width: " + i + ", height: " + i2 + ", useCustomClose: false, isModal: true})";
    }

    /* renamed from: a */
    public static String m20859a(String str, boolean z) {
        return "ogySdkMraidGateway.updateCurrentAppOrientation({orientation: \"" + str + "\", locked: " + z + "})";
    }

    /* renamed from: b */
    public static String m20866b(String str) {
        return "ogySdkMraidGateway.updateState(\"" + str + "\")";
    }

    /* renamed from: a */
    public static String m20862a(boolean z, String str) {
        return "ogySdkMraidGateway.updateOrientationProperties({allowOrientationChange: " + z + ", forceOrientation: \"" + str + "\"})";
    }

    /* renamed from: b */
    public static String m20867b(String str, String str2) {
        return "ogySdkMraidGateway.callPendingMethodCallback(\"" + str + "\", null, " + str2 + ')';
    }

    /* renamed from: a */
    public static String m20854a(int i, int i2) {
        return "ogySdkMraidGateway.updateScreenSize({width: " + i + ", height: " + i2 + "})";
    }

    /* renamed from: a */
    public static String m20857a(String str) {
        return "ogySdkMraidGateway.updatePlacementType(\"" + str + "\")";
    }

    /* renamed from: a */
    public static String m20861a(boolean z) {
        return "ogySdkMraidGateway.updateViewability(" + z + ')';
    }

    /* renamed from: a */
    public static String m20855a(int i, int i2, int i3, int i4) {
        return "ogySdkMraidGateway.updateDefaultPosition({x: " + i3 + ", y: " + i4 + ", width: " + i + ", height: " + i2 + "})";
    }

    /* renamed from: a */
    public static String m20856a(C6231av avVar) {
        String str;
        StringBuilder sb = new StringBuilder();
        for (Rect next : avVar.mo34751b()) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append("{x: " + C6215af.m20775a(next.left) + ", y: " + C6215af.m20775a(next.top) + ", width: " + C6215af.m20775a(next.width()) + ", height: " + C6215af.m20775a(next.height()) + '}');
        }
        Rect a = avVar.mo34747a();
        if (a != null) {
            str = "visibleRectangle: {x: " + C6215af.m20775a(a.left) + ", y: " + C6215af.m20775a(a.top) + ", width: " + C6215af.m20775a(a.width()) + ", height: " + C6215af.m20775a(a.height()) + '}';
        } else {
            str = "visibleRectangle: null";
        }
        return "ogySdkMraidGateway.updateExposure({exposedPercentage: " + avVar.mo34752c() + ", " + str + ", occlusionRectangles: [" + sb + "]})";
    }

    /* renamed from: a */
    public static String m20860a(String str, boolean z, boolean z2, String str2, String str3) {
        return "ogySdkMraidGateway.callEventListeners(\"ogyOnNavigation\", {event: \"" + str + "\", canGoBack: " + z2 + ", canGoForward: " + z + ", webviewId: \"" + str2 + "\", url: \"" + str3 + "\"})";
    }
}
