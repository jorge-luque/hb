package com.applovin.impl.communicator;

import android.content.Context;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorMessagingService;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public class MessagingServiceImpl implements AppLovinCommunicatorMessagingService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f5085a;

    /* renamed from: b */
    private final ScheduledThreadPoolExecutor f5086b;

    /* renamed from: c */
    private final Queue<CommunicatorMessageImpl> f5087c = new LinkedList();

    /* renamed from: d */
    private final Object f5088d = new Object();

    public MessagingServiceImpl(Context context) {
        this.f5085a = context;
        this.f5086b = m6232a();
    }

    /* renamed from: a */
    private Queue<CommunicatorMessageImpl> m6231a(String str) {
        LinkedList linkedList;
        synchronized (this.f5088d) {
            linkedList = new LinkedList();
            for (CommunicatorMessageImpl communicatorMessageImpl : this.f5087c) {
                if (communicatorMessageImpl.mo7574a() && communicatorMessageImpl.getTopic().equals(str)) {
                    linkedList.add(communicatorMessageImpl);
                }
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m6232a() {
        return new ScheduledThreadPoolExecutor(4, new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "AppLovinSdk:com.applovin.communicator");
                thread.setPriority(10);
                thread.setDaemon(true);
                return thread;
            }
        });
    }

    /* renamed from: a */
    private void m6233a(final CommunicatorMessageImpl communicatorMessageImpl) {
        this.f5086b.execute(new Runnable() {
            public void run() {
                AppLovinBroadcastManager.getInstance(MessagingServiceImpl.this.f5085a).sendBroadcastSync(communicatorMessageImpl, (Map<String, Object>) null);
            }
        });
    }

    public void maybeFlushStickyMessages(String str) {
        for (CommunicatorMessageImpl a : m6231a(str)) {
            m6233a(a);
        }
    }

    public void publish(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        m6233a((CommunicatorMessageImpl) appLovinCommunicatorMessage);
        synchronized (this.f5088d) {
            this.f5087c.add(appLovinCommunicatorMessage);
        }
    }

    public String toString() {
        return "MessagingServiceImpl{}";
    }
}
