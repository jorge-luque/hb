package com.crashlytics.android.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6072k;

final class ProcMapEntryParser {
    private static final Pattern MAP_REGEX = Pattern.compile("\\s*(\\p{XDigit}+)-\\s*(\\p{XDigit}+)\\s+(.{4})\\s+\\p{XDigit}+\\s+.+\\s+\\d+\\s+(.*)");

    private ProcMapEntryParser() {
    }

    public static ProcMapEntry parse(String str) {
        Matcher matcher = MAP_REGEX.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        try {
            long longValue = Long.valueOf(matcher.group(1), 16).longValue();
            return new ProcMapEntry(longValue, Long.valueOf(matcher.group(2), 16).longValue() - longValue, matcher.group(3), matcher.group(4));
        } catch (Exception unused) {
            C6072k f = C6059c.m19630f();
            f.mo34093d(CrashlyticsCore.TAG, "Could not parse map entry: " + str);
            return null;
        }
    }
}
