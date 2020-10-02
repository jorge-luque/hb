package p118io.presage;

/* renamed from: io.presage.az */
public final class C6235az {

    /* renamed from: a */
    public static final CamembertauCalvados f16777a = new CamembertauCalvados((byte) 0);

    /* renamed from: io.presage.az$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    /* renamed from: a */
    private static String m20871a() {
        return "window.MRAID_ENV =  { version: '3.0', sdk: 'Presage', sdkVersion: '3.3.9-moat'};";
    }

    /* renamed from: a */
    public static String m20872a(SaintFelicien saintFelicien) {
        if (saintFelicien == null || !C6514hl.m21416a((Object) saintFelicien.mo34670c(), (Object) "optin_video")) {
            return m20871a();
        }
        return m20873b(saintFelicien);
    }

    /* renamed from: b */
    private static String m20873b(SaintFelicien saintFelicien) {
        return "window.MRAID_ENV =  { version: '3.0', sdk: 'Presage', sdkVersion: '3.3.9-moat', adUnit: { type: '" + saintFelicien.mo34670c() + "', reward : { name: '" + saintFelicien.mo34674e().getName() + "', value: '" + saintFelicien.mo34674e().getValue() + "', launch: '" + saintFelicien.mo34672d() + "'}}};";
    }
}
