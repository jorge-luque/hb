package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.C0402b;
import androidx.appcompat.view.menu.C0497m;
import com.google.android.gms.drive.MetadataChangeSet;

/* renamed from: androidx.appcompat.view.menu.h */
/* compiled from: MenuDialogHelper */
class C0485h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, C0497m.C0498a {

    /* renamed from: a */
    private C0482g f855a;

    /* renamed from: b */
    private C0402b f856b;

    /* renamed from: c */
    C0479e f857c;

    /* renamed from: d */
    private C0497m.C0498a f858d;

    public C0485h(C0482g gVar) {
        this.f855a = gVar;
    }

    /* renamed from: a */
    public void mo2587a(IBinder iBinder) {
        C0482g gVar = this.f855a;
        C0402b.C0403a aVar = new C0402b.C0403a(gVar.mo2556e());
        C0479e eVar = new C0479e(aVar.mo1983b(), R$layout.abc_list_menu_item_layout);
        this.f857c = eVar;
        eVar.mo2459a((C0497m.C0498a) this);
        this.f855a.mo2523a((C0497m) this.f857c);
        aVar.mo1980a(this.f857c.mo2495a(), this);
        View i = gVar.mo2564i();
        if (i != null) {
            aVar.mo1978a(i);
        } else {
            aVar.mo1977a(gVar.mo2560g());
            aVar.mo1981a(gVar.mo2562h());
        }
        aVar.mo1976a((DialogInterface.OnKeyListener) this);
        C0402b a = aVar.mo1982a();
        this.f856b = a;
        a.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f856b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES;
        this.f856b.show();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f855a.mo2527a((MenuItem) (C0486i) this.f857c.mo2495a().getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f857c.mo2457a(this.f855a, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f856b.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f856b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f855a.mo2526a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f855a.performShortcut(i, keyEvent, 0);
    }

    /* renamed from: a */
    public void mo2586a() {
        C0402b bVar = this.f856b;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    /* renamed from: a */
    public void mo2088a(C0482g gVar, boolean z) {
        if (z || gVar == this.f855a) {
            mo2586a();
        }
        C0497m.C0498a aVar = this.f858d;
        if (aVar != null) {
            aVar.mo2088a(gVar, z);
        }
    }

    /* renamed from: a */
    public boolean mo2089a(C0482g gVar) {
        C0497m.C0498a aVar = this.f858d;
        if (aVar != null) {
            return aVar.mo2089a(gVar);
        }
        return false;
    }
}
