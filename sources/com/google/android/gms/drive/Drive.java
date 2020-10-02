package com.google.android.gms.drive;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.drive.zzaf;
import com.google.android.gms.internal.drive.zzaw;
import com.google.android.gms.internal.drive.zzbb;
import com.google.android.gms.internal.drive.zzbr;
import com.google.android.gms.internal.drive.zzcb;
import com.google.android.gms.internal.drive.zzch;
import com.google.android.gms.internal.drive.zzeb;
import java.util.Set;

@Deprecated
public final class Drive {
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Drive.API", zzq, CLIENT_KEY);
    public static final Api.ClientKey<zzaw> CLIENT_KEY = new Api.ClientKey<>();
    @Deprecated
    public static final DriveApi DriveApi = new zzaf();
    @Deprecated
    public static final DrivePreferencesApi DrivePreferencesApi = new zzcb();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
    private static final Api.AbstractClientBuilder<zzaw, Api.ApiOptions.NoOptions> zzq = new zze();
    private static final Api.AbstractClientBuilder<zzaw, zzb> zzr = new zzf();
    private static final Api.AbstractClientBuilder<zzaw, zza> zzs = new zzg();
    @ShowFirstParty
    private static final Scope zzt = new Scope(Scopes.DRIVE_FULL);
    private static final Scope zzu = new Scope(Scopes.DRIVE_APPS);
    private static final Api<zzb> zzv = new Api<>("Drive.INTERNAL_API", zzr, CLIENT_KEY);
    public static final Api<zza> zzw = new Api<>("Drive.API_CONNECTIONLESS", zzs, CLIENT_KEY);
    @ShowFirstParty
    @Deprecated
    private static final zzj zzx = new zzbr();
    private static final zzl zzy = new zzeb();

    public static class zza implements Api.ApiOptions.HasGoogleSignInAccountOptions {
        private final GoogleSignInAccount zzaa;
        private final Bundle zzz = new Bundle();

        public zza(GoogleSignInAccount googleSignInAccount) {
            this.zzaa = googleSignInAccount;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == zza.class) {
                zza zza = (zza) obj;
                if (!Objects.equal(this.zzaa, zza.getGoogleSignInAccount())) {
                    return false;
                }
                String string = this.zzz.getString("method_trace_filename");
                String string2 = zza.zzz.getString("method_trace_filename");
                return ((string == null && string2 == null) || !(string == null || string2 == null || !string.equals(string2))) && this.zzz.getBoolean("bypass_initial_sync") == zza.zzz.getBoolean("bypass_initial_sync") && this.zzz.getInt("proxy_type") == zza.zzz.getInt("proxy_type");
            }
        }

        public final GoogleSignInAccount getGoogleSignInAccount() {
            return this.zzaa;
        }

        public final int hashCode() {
            return Objects.hashCode(this.zzaa, this.zzz.getString("method_trace_filename", ""), Integer.valueOf(this.zzz.getInt("proxy_type")), Boolean.valueOf(this.zzz.getBoolean("bypass_initial_sync")));
        }

        public final Bundle zzh() {
            return this.zzz;
        }
    }

    public static class zzb implements Api.ApiOptions.Optional {
    }

    private Drive() {
    }

    @Deprecated
    public static DriveClient getDriveClient(Context context, GoogleSignInAccount googleSignInAccount) {
        zza(googleSignInAccount);
        return new zzbb(context, new zza(googleSignInAccount));
    }

    @Deprecated
    public static DriveResourceClient getDriveResourceClient(Context context, GoogleSignInAccount googleSignInAccount) {
        zza(googleSignInAccount);
        return new zzch(context, new zza(googleSignInAccount));
    }

    private static void zza(GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        Set<Scope> requestedScopes = googleSignInAccount.getRequestedScopes();
        Preconditions.checkArgument(requestedScopes.contains(SCOPE_FILE) || requestedScopes.contains(SCOPE_APPFOLDER) || requestedScopes.contains(zzt) || requestedScopes.contains(zzu), "You must request a Drive scope in order to interact with the Drive API.");
    }

    @Deprecated
    public static DriveClient getDriveClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        zza(googleSignInAccount);
        return new zzbb(activity, new zza(googleSignInAccount));
    }

    @Deprecated
    public static DriveResourceClient getDriveResourceClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        zza(googleSignInAccount);
        return new zzch(activity, new zza(googleSignInAccount));
    }
}
