package com.ogury.p159cm;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* renamed from: com.ogury.cm.abaab */
public final class abaab extends abaaa {
    /* renamed from: a */
    public final void mo29429a(Context context) {
        accbb.m15218b(context, "context");
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).edit();
        aacca aacca = aacca.f12035a;
        edit.putString("IABConsent_ConsentString", ((ababb) ababa.m15062f()).mo29434b());
        edit.putBoolean("IABConsent_CMPPresent", true);
        edit.apply();
    }
}
