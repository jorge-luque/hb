package androidx.appcompat.p011d;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* renamed from: androidx.appcompat.d.i */
/* compiled from: WindowCallbackWrapper */
public class C0467i implements Window.Callback {

    /* renamed from: a */
    final Window.Callback f712a;

    public C0467i(Window.Callback callback) {
        if (callback != null) {
            this.f712a = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    /* renamed from: a */
    public final Window.Callback mo2347a() {
        return this.f712a;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f712a.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f712a.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f712a.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f712a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f712a.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f712a.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f712a.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f712a.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f712a.onAttachedToWindow();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f712a.onCreatePanelMenu(i, menu);
    }

    public View onCreatePanelView(int i) {
        return this.f712a.onCreatePanelView(i);
    }

    public void onDetachedFromWindow() {
        this.f712a.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f712a.onMenuItemSelected(i, menuItem);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.f712a.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        this.f712a.onPanelClosed(i, menu);
    }

    public void onPointerCaptureChanged(boolean z) {
        this.f712a.onPointerCaptureChanged(z);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.f712a.onPreparePanel(i, view, menu);
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
        this.f712a.onProvideKeyboardShortcuts(list, menu, i);
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f712a.onSearchRequested(searchEvent);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f712a.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        this.f712a.onWindowFocusChanged(z);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f712a.onWindowStartingActionMode(callback);
    }

    public boolean onSearchRequested() {
        return this.f712a.onSearchRequested();
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.f712a.onWindowStartingActionMode(callback, i);
    }
}
