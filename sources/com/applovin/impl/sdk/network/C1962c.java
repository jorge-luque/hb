package com.applovin.impl.sdk.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.network.c */
public class C1962c extends BroadcastReceiver {

    /* renamed from: a */
    private final List<C1963a> f6572a = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.applovin.impl.sdk.network.c$a */
    public interface C1963a {
        /* renamed from: a */
        void mo8609a();

        /* renamed from: b */
        void mo8610b();
    }

    public C1962c(Context context) {
        context.getApplicationContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* renamed from: a */
    private static boolean m7627a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return false;
        }
        Object obj = extras.get("networkInfo");
        if (obj instanceof NetworkInfo) {
            return ((NetworkInfo) obj).isConnected();
        }
        return false;
    }

    /* renamed from: a */
    public void mo8674a(C1963a aVar) {
        this.f6572a.add(aVar);
    }

    /* renamed from: b */
    public void mo8675b(C1963a aVar) {
        this.f6572a.remove(aVar);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && !isInitialStickyBroadcast()) {
            ArrayList arrayList = new ArrayList(this.f6572a);
            boolean a = m7627a(intent);
            Iterator it = arrayList.iterator();
            if (a) {
                while (it.hasNext()) {
                    ((C1963a) it.next()).mo8609a();
                }
                return;
            }
            while (it.hasNext()) {
                ((C1963a) it.next()).mo8610b();
            }
        }
    }
}
