package com.miniclip.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JavaSocket {
    /* access modifiers changed from: private */
    public static ArrayList<byte[]> _certs;
    /* access modifiers changed from: private */
    public DatagramSocket _datagramSocket = null;
    /* access modifiers changed from: private */
    public DataOutputStream _dout = null;
    /* access modifiers changed from: private */
    public InetAddress _host = null;
    /* access modifiers changed from: private */
    public String _hostAddress;
    /* access modifiers changed from: private */
    public int _hostPort;
    /* access modifiers changed from: private */
    public long _nativeObject;
    private ByteArrayOutputStream _packetBuffer = new ByteArrayOutputStream();
    private int _packetSize;
    private C4286e _packetSizeHeaderType;
    private List<byte[]> _queuedData = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public Thread _sendThread;
    Socket _socket = null;
    /* access modifiers changed from: private */
    public C4287f _socketType;
    /* access modifiers changed from: private */
    public C4288g _state = C4288g.NotConnected;
    /* access modifiers changed from: private */
    public int _workBufferSize;

    /* renamed from: com.miniclip.network.JavaSocket$a */
    class C4282a implements Runnable {
        C4282a() {
        }

        public void run() {
            while (JavaSocket.this.isConnected()) {
                JavaSocket.this.sendQueuedData();
                synchronized (JavaSocket.this._sendThread) {
                    try {
                        JavaSocket.this._sendThread.wait(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: com.miniclip.network.JavaSocket$b */
    class C4283b implements Runnable {
        C4283b() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            com.miniclip.network.JavaSocket.access$302(r5.f11437a, java.net.InetAddress.getByName(com.miniclip.network.JavaSocket.access$400(r5.f11437a)));
            com.miniclip.network.JavaSocket.access$502(r5.f11437a, new java.net.DatagramSocket());
            r0 = com.miniclip.network.JavaSocket.access$600(r5.f11437a);
            r1 = new byte[r0];
            r2 = com.miniclip.network.JavaSocket.access$200(r5.f11437a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            com.miniclip.network.JavaSocket.access$202(r5.f11437a, com.miniclip.network.JavaSocket.C4288g.f11450c);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            com.miniclip.network.JavaSocket.onConnect(com.miniclip.network.JavaSocket.access$700(r5.f11437a));
            com.miniclip.network.JavaSocket.access$100(r5.f11437a).start();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
            if (r5.f11437a.isConnected() == false) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
            com.miniclip.network.JavaSocket.access$500(r5.f11437a).setSoTimeout(2000);
            r2 = new java.net.DatagramPacket(r1, r0, com.miniclip.network.JavaSocket.access$300(r5.f11437a), com.miniclip.network.JavaSocket.access$800(r5.f11437a));
            com.miniclip.network.JavaSocket.access$500(r5.f11437a).receive(r2);
            r5.f11437a.onDataPartial(r2.getLength(), r2.getData());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0098, code lost:
            r0 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x009d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x009e, code lost:
            r0.printStackTrace();
            r0 = r0.getMessage();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                com.miniclip.network.JavaSocket r0 = com.miniclip.network.JavaSocket.this
                com.miniclip.network.JavaSocket$g r0 = r0._state
                monitor-enter(r0)
                com.miniclip.network.JavaSocket r1 = com.miniclip.network.JavaSocket.this     // Catch:{ all -> 0x00b4 }
                com.miniclip.network.JavaSocket$g r1 = r1._state     // Catch:{ all -> 0x00b4 }
                com.miniclip.network.JavaSocket$g r2 = com.miniclip.network.JavaSocket.C4288g.NotConnected     // Catch:{ all -> 0x00b4 }
                if (r1 == r2) goto L_0x0013
                monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
                return
            L_0x0013:
                com.miniclip.network.JavaSocket r1 = com.miniclip.network.JavaSocket.this     // Catch:{ all -> 0x00b4 }
                com.miniclip.network.JavaSocket$g r2 = com.miniclip.network.JavaSocket.C4288g.Connecting     // Catch:{ all -> 0x00b4 }
                com.miniclip.network.JavaSocket.C4288g unused = r1._state = r2     // Catch:{ all -> 0x00b4 }
                monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
                com.miniclip.network.JavaSocket r0 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x009d }
                com.miniclip.network.JavaSocket r1 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x009d }
                java.lang.String r1 = r1._hostAddress     // Catch:{ Exception -> 0x009d }
                java.net.InetAddress r1 = java.net.InetAddress.getByName(r1)     // Catch:{ Exception -> 0x009d }
                java.net.InetAddress unused = r0._host = r1     // Catch:{ Exception -> 0x009d }
                com.miniclip.network.JavaSocket r0 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x009d }
                java.net.DatagramSocket r1 = new java.net.DatagramSocket     // Catch:{ Exception -> 0x009d }
                r1.<init>()     // Catch:{ Exception -> 0x009d }
                java.net.DatagramSocket unused = r0._datagramSocket = r1     // Catch:{ Exception -> 0x009d }
                com.miniclip.network.JavaSocket r0 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x009d }
                int r0 = r0._workBufferSize     // Catch:{ Exception -> 0x009d }
                byte[] r1 = new byte[r0]     // Catch:{ Exception -> 0x009d }
                com.miniclip.network.JavaSocket r2 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x009d }
                com.miniclip.network.JavaSocket$g r2 = r2._state     // Catch:{ Exception -> 0x009d }
                monitor-enter(r2)     // Catch:{ Exception -> 0x009d }
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this     // Catch:{ all -> 0x009a }
                com.miniclip.network.JavaSocket$g r4 = com.miniclip.network.JavaSocket.C4288g.Connected     // Catch:{ all -> 0x009a }
                com.miniclip.network.JavaSocket.C4288g unused = r3._state = r4     // Catch:{ all -> 0x009a }
                monitor-exit(r2)     // Catch:{ all -> 0x009a }
                com.miniclip.network.JavaSocket r2 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x009d }
                long r2 = r2._nativeObject     // Catch:{ Exception -> 0x009d }
                com.miniclip.network.JavaSocket.onConnect(r2)     // Catch:{ Exception -> 0x009d }
                com.miniclip.network.JavaSocket r2 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x009d }
                java.lang.Thread r2 = r2._sendThread     // Catch:{ Exception -> 0x009d }
                r2.start()     // Catch:{ Exception -> 0x009d }
            L_0x005d:
                com.miniclip.network.JavaSocket r2 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x009d }
                boolean r2 = r2.isConnected()     // Catch:{ Exception -> 0x009d }
                if (r2 == 0) goto L_0x0098
                com.miniclip.network.JavaSocket r2 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x009d }
                java.net.DatagramSocket r2 = r2._datagramSocket     // Catch:{ Exception -> 0x009d }
                r3 = 2000(0x7d0, float:2.803E-42)
                r2.setSoTimeout(r3)     // Catch:{ Exception -> 0x009d }
                java.net.DatagramPacket r2 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x009d }
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x009d }
                java.net.InetAddress r3 = r3._host     // Catch:{ Exception -> 0x009d }
                com.miniclip.network.JavaSocket r4 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x009d }
                int r4 = r4._hostPort     // Catch:{ Exception -> 0x009d }
                r2.<init>(r1, r0, r3, r4)     // Catch:{ Exception -> 0x009d }
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x009d }
                java.net.DatagramSocket r3 = r3._datagramSocket     // Catch:{ Exception -> 0x009d }
                r3.receive(r2)     // Catch:{ Exception -> 0x009d }
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x009d }
                int r4 = r2.getLength()     // Catch:{ Exception -> 0x009d }
                byte[] r2 = r2.getData()     // Catch:{ Exception -> 0x009d }
                r3.onDataPartial(r4, r2)     // Catch:{ Exception -> 0x009d }
                goto L_0x005d
            L_0x0098:
                r0 = 0
                goto L_0x00a5
            L_0x009a:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x009a }
                throw r0     // Catch:{ Exception -> 0x009d }
            L_0x009d:
                r0 = move-exception
                r0.printStackTrace()
                java.lang.String r0 = r0.getMessage()
            L_0x00a5:
                if (r0 == 0) goto L_0x00ae
                com.miniclip.network.JavaSocket r1 = com.miniclip.network.JavaSocket.this
                r2 = -1
                r1.cleanup(r2, r0)
                goto L_0x00b3
            L_0x00ae:
                com.miniclip.network.JavaSocket r0 = com.miniclip.network.JavaSocket.this
                r0.cleanup()
            L_0x00b3:
                return
            L_0x00b4:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
                goto L_0x00b8
            L_0x00b7:
                throw r1
            L_0x00b8:
                goto L_0x00b7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.miniclip.network.JavaSocket.C4283b.run():void");
        }
    }

    /* renamed from: com.miniclip.network.JavaSocket$c */
    class C4284c implements Runnable {
        C4284c() {
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
            	at java.base/java.util.Objects.checkIndex(Objects.java:372)
            	at java.base/java.util.ArrayList.get(ArrayList.java:458)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        public void run() {
            /*
                r11 = this;
                com.miniclip.network.JavaSocket r0 = com.miniclip.network.JavaSocket.this
                com.miniclip.network.JavaSocket$g r0 = r0._state
                monitor-enter(r0)
                com.miniclip.network.JavaSocket r1 = com.miniclip.network.JavaSocket.this     // Catch:{ all -> 0x0190 }
                com.miniclip.network.JavaSocket$g r1 = r1._state     // Catch:{ all -> 0x0190 }
                com.miniclip.network.JavaSocket$g r2 = com.miniclip.network.JavaSocket.C4288g.NotConnected     // Catch:{ all -> 0x0190 }
                if (r1 == r2) goto L_0x0013
                monitor-exit(r0)     // Catch:{ all -> 0x0190 }
                return
            L_0x0013:
                com.miniclip.network.JavaSocket r1 = com.miniclip.network.JavaSocket.this     // Catch:{ all -> 0x0190 }
                com.miniclip.network.JavaSocket$g r2 = com.miniclip.network.JavaSocket.C4288g.Connecting     // Catch:{ all -> 0x0190 }
                com.miniclip.network.JavaSocket.C4288g unused = r1._state = r2     // Catch:{ all -> 0x0190 }
                monitor-exit(r0)     // Catch:{ all -> 0x0190 }
                r0 = 1
                r1 = 0
                r2 = 0
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00de }
                java.lang.String r3 = r3._hostAddress     // Catch:{ Exception -> 0x00de }
                java.lang.String r4 = ":"
                boolean r3 = r3.contains(r4)     // Catch:{ Exception -> 0x00de }
                if (r3 == 0) goto L_0x003c
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00de }
                com.miniclip.network.JavaSocket r4 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00de }
                java.lang.String r4 = r4._hostAddress     // Catch:{ Exception -> 0x00de }
                java.net.InetAddress r4 = java.net.Inet6Address.getByName(r4)     // Catch:{ Exception -> 0x00de }
                java.net.InetAddress unused = r3._host = r4     // Catch:{ Exception -> 0x00de }
                goto L_0x004b
            L_0x003c:
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00de }
                com.miniclip.network.JavaSocket r4 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00de }
                java.lang.String r4 = r4._hostAddress     // Catch:{ Exception -> 0x00de }
                java.net.InetAddress r4 = java.net.InetAddress.getByName(r4)     // Catch:{ Exception -> 0x00de }
                java.net.InetAddress unused = r3._host = r4     // Catch:{ Exception -> 0x00de }
            L_0x004b:
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00de }
                java.lang.String r3 = r3._hostAddress     // Catch:{ Exception -> 0x00de }
                java.net.InetAddress.getAllByName(r3)     // Catch:{ Exception -> 0x00de }
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00de }
                com.miniclip.network.JavaSocket$f r3 = r3._socketType     // Catch:{ Exception -> 0x00de }
                com.miniclip.network.JavaSocket$f r4 = com.miniclip.network.JavaSocket.C4287f.TCPSSL     // Catch:{ Exception -> 0x00de }
                if (r3 != r4) goto L_0x00a9
                java.lang.String r3 = "TLS"
                javax.net.ssl.SSLContext r3 = javax.net.ssl.SSLContext.getInstance(r3)     // Catch:{ Exception -> 0x00de }
                java.util.ArrayList r4 = com.miniclip.network.JavaSocket._certs     // Catch:{ Exception -> 0x00de }
                if (r4 == 0) goto L_0x0085
                java.util.ArrayList r4 = com.miniclip.network.JavaSocket._certs     // Catch:{ Exception -> 0x00de }
                int r4 = r4.size()     // Catch:{ Exception -> 0x00de }
                if (r4 <= 0) goto L_0x0085
                javax.net.ssl.TrustManager[] r4 = new javax.net.ssl.TrustManager[r0]     // Catch:{ Exception -> 0x00de }
                com.miniclip.network.JavaTrustManager r5 = new com.miniclip.network.JavaTrustManager     // Catch:{ Exception -> 0x00de }
                java.util.ArrayList r6 = com.miniclip.network.JavaSocket._certs     // Catch:{ Exception -> 0x00de }
                r5.<init>(r6)     // Catch:{ Exception -> 0x00de }
                r4[r1] = r5     // Catch:{ Exception -> 0x00de }
                r3.init(r2, r4, r2)     // Catch:{ Exception -> 0x00de }
                goto L_0x0088
            L_0x0085:
                r3.init(r2, r2, r2)     // Catch:{ Exception -> 0x00de }
            L_0x0088:
                javax.net.ssl.SSLSocketFactory r3 = r3.getSocketFactory()     // Catch:{ Exception -> 0x00de }
                com.miniclip.network.JavaSocket r4 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00de }
                java.net.InetAddress r4 = r4._host     // Catch:{ Exception -> 0x00de }
                com.miniclip.network.JavaSocket r5 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00de }
                int r5 = r5._hostPort     // Catch:{ Exception -> 0x00de }
                java.net.Socket r3 = r3.createSocket(r4, r5)     // Catch:{ Exception -> 0x00de }
                javax.net.ssl.SSLSocket r3 = (javax.net.ssl.SSLSocket) r3     // Catch:{ Exception -> 0x00de }
                r3.setUseClientMode(r0)     // Catch:{ Exception -> 0x00de }
                r3.startHandshake()     // Catch:{ Exception -> 0x00de }
                com.miniclip.network.JavaSocket r4 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00de }
                r4._socket = r3     // Catch:{ Exception -> 0x00de }
                goto L_0x00c8
            L_0x00a9:
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00de }
                com.miniclip.network.JavaSocket$f r3 = r3._socketType     // Catch:{ Exception -> 0x00de }
                com.miniclip.network.JavaSocket$f r4 = com.miniclip.network.JavaSocket.C4287f.TCP     // Catch:{ Exception -> 0x00de }
                if (r3 != r4) goto L_0x00c8
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00de }
                java.net.Socket r4 = new java.net.Socket     // Catch:{ Exception -> 0x00de }
                com.miniclip.network.JavaSocket r5 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00de }
                java.net.InetAddress r5 = r5._host     // Catch:{ Exception -> 0x00de }
                com.miniclip.network.JavaSocket r6 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00de }
                int r6 = r6._hostPort     // Catch:{ Exception -> 0x00de }
                r4.<init>(r5, r6)     // Catch:{ Exception -> 0x00de }
                r3._socket = r4     // Catch:{ Exception -> 0x00de }
            L_0x00c8:
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00de }
                java.net.Socket r3 = r3._socket     // Catch:{ Exception -> 0x00de }
                java.io.InputStream r3 = r3.getInputStream()     // Catch:{ Exception -> 0x00de }
                com.miniclip.network.JavaSocket r4 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x00d9 }
                java.net.Socket r4 = r4._socket     // Catch:{ Exception -> 0x00d9 }
                java.io.OutputStream r4 = r4.getOutputStream()     // Catch:{ Exception -> 0x00d9 }
                goto L_0x00eb
            L_0x00d9:
                r4 = move-exception
                r10 = r4
                r4 = r3
                r3 = r10
                goto L_0x00e0
            L_0x00de:
                r3 = move-exception
                r4 = r2
            L_0x00e0:
                r3.printStackTrace()
                java.lang.String r3 = r3.getMessage()
                r10 = r4
                r4 = r2
                r2 = r3
                r3 = r10
            L_0x00eb:
                r5 = -1
                if (r2 != 0) goto L_0x0182
                com.miniclip.network.JavaSocket r6 = com.miniclip.network.JavaSocket.this
                java.net.Socket r6 = r6._socket
                if (r6 == 0) goto L_0x0182
                java.io.DataInputStream r6 = new java.io.DataInputStream
                r6.<init>(r3)
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this
                java.io.DataOutputStream r7 = new java.io.DataOutputStream
                r7.<init>(r4)
                java.io.DataOutputStream unused = r3._dout = r7
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this
                com.miniclip.network.JavaSocket$g r3 = r3._state
                monitor-enter(r3)
                com.miniclip.network.JavaSocket r4 = com.miniclip.network.JavaSocket.this     // Catch:{ all -> 0x017f }
                com.miniclip.network.JavaSocket$g r7 = com.miniclip.network.JavaSocket.C4288g.Connected     // Catch:{ all -> 0x017f }
                com.miniclip.network.JavaSocket.C4288g unused = r4._state = r7     // Catch:{ all -> 0x017f }
                monitor-exit(r3)     // Catch:{ all -> 0x017f }
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this
                long r3 = r3._nativeObject
                com.miniclip.network.JavaSocket.onConnect(r3)
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this
                java.lang.Thread r3 = r3._sendThread
                r3.start()
                com.miniclip.network.JavaSocket r3 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x0176 }
                int r3 = r3._workBufferSize     // Catch:{ Exception -> 0x0176 }
                byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x0176 }
            L_0x012c:
                com.miniclip.network.JavaSocket r4 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x0176 }
                boolean r4 = r4.isConnected()     // Catch:{ Exception -> 0x0176 }
                if (r4 == 0) goto L_0x0182
                int r4 = r6.read(r3)     // Catch:{ Exception -> 0x0176 }
                if (r4 != r5) goto L_0x013b
                goto L_0x0182
            L_0x013b:
                int r7 = r6.available()     // Catch:{ Exception -> 0x0176 }
                if (r7 <= 0) goto L_0x016a
                java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0176 }
                r7.<init>()     // Catch:{ Exception -> 0x0176 }
                r7.write(r3, r1, r4)     // Catch:{ Exception -> 0x0176 }
            L_0x0149:
                int r4 = r6.available()     // Catch:{ Exception -> 0x0176 }
                if (r4 <= 0) goto L_0x015d
                int r4 = r6.read(r3)     // Catch:{ Exception -> 0x0176 }
                if (r4 <= 0) goto L_0x0159
                r7.write(r3, r1, r4)     // Catch:{ Exception -> 0x0176 }
                goto L_0x0149
            L_0x0159:
                if (r4 != r5) goto L_0x0149
                r4 = 1
                goto L_0x015e
            L_0x015d:
                r4 = 0
            L_0x015e:
                byte[] r8 = r7.toByteArray()     // Catch:{ Exception -> 0x0176 }
                int r7 = r7.size()     // Catch:{ Exception -> 0x0176 }
                r10 = r7
                r7 = r4
                r4 = r10
                goto L_0x016c
            L_0x016a:
                r8 = r3
                r7 = 0
            L_0x016c:
                if (r4 <= 0) goto L_0x0173
                com.miniclip.network.JavaSocket r9 = com.miniclip.network.JavaSocket.this     // Catch:{ Exception -> 0x0176 }
                r9.onDataPartial(r4, r8)     // Catch:{ Exception -> 0x0176 }
            L_0x0173:
                if (r7 == 0) goto L_0x012c
                goto L_0x0182
            L_0x0176:
                r0 = move-exception
                r0.printStackTrace()
                java.lang.String r2 = r0.getMessage()
                goto L_0x0182
            L_0x017f:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x017f }
                throw r0
            L_0x0182:
                if (r2 == 0) goto L_0x018a
                com.miniclip.network.JavaSocket r0 = com.miniclip.network.JavaSocket.this
                r0.cleanup(r5, r2)
                goto L_0x018f
            L_0x018a:
                com.miniclip.network.JavaSocket r0 = com.miniclip.network.JavaSocket.this
                r0.cleanup()
            L_0x018f:
                return
            L_0x0190:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0190 }
                goto L_0x0194
            L_0x0193:
                throw r1
            L_0x0194:
                goto L_0x0193
            */
            throw new UnsupportedOperationException("Method not decompiled: com.miniclip.network.JavaSocket.C4284c.run():void");
        }
    }

    /* renamed from: com.miniclip.network.JavaSocket$d */
    static /* synthetic */ class C4285d {

        /* renamed from: a */
        static final /* synthetic */ int[] f11439a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.miniclip.network.JavaSocket$e[] r0 = com.miniclip.network.JavaSocket.C4286e.m14401a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11439a = r0
                com.miniclip.network.JavaSocket$e r1 = com.miniclip.network.JavaSocket.C4286e.Size16     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f11439a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.miniclip.network.JavaSocket$e r1 = com.miniclip.network.JavaSocket.C4286e.Size32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f11439a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.miniclip.network.JavaSocket$e r1 = com.miniclip.network.JavaSocket.C4286e.Size64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f11439a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.miniclip.network.JavaSocket$e r1 = com.miniclip.network.JavaSocket.C4286e.f11440a     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.miniclip.network.JavaSocket.C4285d.<clinit>():void");
        }
    }

    /* renamed from: com.miniclip.network.JavaSocket$e */
    private enum C4286e {
        f11440a,
        Size16,
        Size32,
        Size64;

        /* renamed from: a */
        public static C4286e[] m14401a() {
            return (C4286e[]) f11444e.clone();
        }
    }

    /* renamed from: com.miniclip.network.JavaSocket$f */
    private enum C4287f {
        TCP,
        TCPSSL,
        UDP;

        static {
            TCP = new C4287f("TCP", 0);
            TCPSSL = new C4287f("TCPSSL", 1);
            UDP = new C4287f("UDP", 2);
        }
    }

    /* renamed from: com.miniclip.network.JavaSocket$g */
    private enum C4288g {
        NotConnected,
        Connecting,
        Connected,
        Closed;

        static {
            NotConnected = new C4288g("NotConnected", 0);
            Connecting = new C4288g("Connecting", 1);
            Connected = new C4288g("Connected", 2);
            Closed = new C4288g("Closed", 3);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a5, code lost:
        if (r3.equals("none") != false) goto L_0x00c7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c6 A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    JavaSocket(java.lang.String r3, java.lang.String r4, int r5, long r6, int r8, java.lang.String r9) {
        /*
            r2 = this;
            r2.<init>()
            r2._hostAddress = r4
            r2._hostPort = r5
            r2._nativeObject = r6
            r2._workBufferSize = r8
            r4 = 0
            r2._socket = r4
            r2._dout = r4
            com.miniclip.network.JavaSocket$g r5 = com.miniclip.network.JavaSocket.C4288g.NotConnected
            r2._state = r5
            r2._host = r4
            r2._datagramSocket = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = java.util.Collections.synchronizedList(r4)
            r2._queuedData = r4
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream
            r4.<init>()
            r2._packetBuffer = r4
            r4 = 0
            r2._packetSize = r4
            java.lang.String r5 = r3.toLowerCase()
            int r6 = r5.hashCode()
            r7 = -879106421(0xffffffffcb99e68b, float:-2.0172054E7)
            r8 = -1
            r0 = 2
            r1 = 1
            if (r6 == r7) goto L_0x005c
            r7 = 114657(0x1bfe1, float:1.60669E-40)
            if (r6 == r7) goto L_0x0052
            r7 = 115649(0x1c3c1, float:1.62059E-40)
            if (r6 == r7) goto L_0x0048
            goto L_0x0066
        L_0x0048:
            java.lang.String r6 = "udp"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0066
            r5 = 2
            goto L_0x0067
        L_0x0052:
            java.lang.String r6 = "tcp"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0066
            r5 = 0
            goto L_0x0067
        L_0x005c:
            java.lang.String r6 = "tcpssl"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0066
            r5 = 1
            goto L_0x0067
        L_0x0066:
            r5 = -1
        L_0x0067:
            if (r5 == 0) goto L_0x008e
            if (r5 == r1) goto L_0x0089
            if (r5 != r0) goto L_0x0072
            com.miniclip.network.JavaSocket$f r3 = com.miniclip.network.JavaSocket.C4287f.UDP
            r2._socketType = r3
            goto L_0x0092
        L_0x0072:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Invalid Socket Type: "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.<init>(r3)
            throw r4
        L_0x0089:
            com.miniclip.network.JavaSocket$f r3 = com.miniclip.network.JavaSocket.C4287f.TCPSSL
            r2._socketType = r3
            goto L_0x0092
        L_0x008e:
            com.miniclip.network.JavaSocket$f r3 = com.miniclip.network.JavaSocket.C4287f.TCP
            r2._socketType = r3
        L_0x0092:
            java.lang.String r3 = r9.toLowerCase()
            int r5 = r3.hashCode()
            r6 = 3
            switch(r5) {
                case -901912090: goto L_0x00bc;
                case -901912032: goto L_0x00b2;
                case -901911937: goto L_0x00a8;
                case 3387192: goto L_0x009f;
                default: goto L_0x009e;
            }
        L_0x009e:
            goto L_0x00c6
        L_0x009f:
            java.lang.String r5 = "none"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x00c6
            goto L_0x00c7
        L_0x00a8:
            java.lang.String r4 = "size64"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00c6
            r4 = 3
            goto L_0x00c7
        L_0x00b2:
            java.lang.String r4 = "size32"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00c6
            r4 = 2
            goto L_0x00c7
        L_0x00bc:
            java.lang.String r4 = "size16"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00c6
            r4 = 1
            goto L_0x00c7
        L_0x00c6:
            r4 = -1
        L_0x00c7:
            if (r4 == 0) goto L_0x00f5
            if (r4 == r1) goto L_0x00f0
            if (r4 == r0) goto L_0x00eb
            if (r4 != r6) goto L_0x00d4
            com.miniclip.network.JavaSocket$e r3 = com.miniclip.network.JavaSocket.C4286e.Size64
            r2._packetSizeHeaderType = r3
            goto L_0x00f9
        L_0x00d4:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Invalid Packet Size Type: "
            r4.append(r5)
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x00eb:
            com.miniclip.network.JavaSocket$e r3 = com.miniclip.network.JavaSocket.C4286e.Size32
            r2._packetSizeHeaderType = r3
            goto L_0x00f9
        L_0x00f0:
            com.miniclip.network.JavaSocket$e r3 = com.miniclip.network.JavaSocket.C4286e.Size16
            r2._packetSizeHeaderType = r3
            goto L_0x00f9
        L_0x00f5:
            com.miniclip.network.JavaSocket$e r3 = com.miniclip.network.JavaSocket.C4286e.f11440a
            r2._packetSizeHeaderType = r3
        L_0x00f9:
            java.lang.Thread r3 = new java.lang.Thread
            com.miniclip.network.JavaSocket$a r4 = new com.miniclip.network.JavaSocket$a
            r4.<init>()
            r3.<init>(r4)
            r2._sendThread = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miniclip.network.JavaSocket.<init>(java.lang.String, java.lang.String, int, long, int, java.lang.String):void");
    }

    public static boolean addTrustedCertificate(byte[] bArr) {
        if (_certs == null) {
            _certs = new ArrayList<>();
        }
        _certs.add(bArr);
        return true;
    }

    public static void clearTrustedCertificates() {
        if (_certs == null) {
            _certs = new ArrayList<>();
        }
        _certs.clear();
    }

    private boolean connectTCP() {
        new Thread(new C4284c()).start();
        return true;
    }

    private boolean connectUDP() {
        new Thread(new C4283b()).start();
        return true;
    }

    public static native void onConnect(long j);

    public static native void onData(long j, byte[] bArr, int i, int i2);

    public static native void onDisconnect(long j, int i, String str);

    private boolean sendDataTCP(byte[] bArr) {
        DataOutputStream dataOutputStream = this._dout;
        if (dataOutputStream != null) {
            try {
                dataOutputStream.write(bArr, 0, bArr.length);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean sendDataUDP(byte[] bArr) {
        if (this._datagramSocket == null) {
            return false;
        }
        try {
            this._datagramSocket.send(new DatagramPacket(bArr, bArr.length, this._host, this._hostPort));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void sendQueuedData() {
        synchronized (this._queuedData) {
            Iterator<byte[]> it = this._queuedData.iterator();
            while (it.hasNext()) {
                if (this._socketType == C4287f.UDP) {
                    sendDataUDP(it.next());
                } else {
                    sendDataTCP(it.next());
                }
            }
            this._queuedData.clear();
        }
    }

    public void cleanup() {
        cleanup(0, "");
    }

    public void cleanupTcp() {
        try {
            if (this._socket != null) {
                this._socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this._socket = null;
            throw th;
        }
        this._socket = null;
    }

    public void cleanupUdp() {
        try {
            if (this._datagramSocket != null) {
                this._datagramSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this._datagramSocket = null;
            throw th;
        }
        this._datagramSocket = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        if (r4._socketType != com.miniclip.network.JavaSocket.C4287f.f11447c) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        return connectUDP();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        return connectTCP();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean connect() {
        /*
            r4 = this;
            java.lang.String r0 = r4._hostAddress
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = "Socket"
            java.lang.String r2 = "Host address must not be empty"
            android.util.Log.e(r0, r2)
            return r1
        L_0x0011:
            int r0 = r4._hostPort
            if (r0 != 0) goto L_0x001d
            java.lang.String r0 = "Socket"
            java.lang.String r2 = "Host port must not be 0"
            android.util.Log.e(r0, r2)
            return r1
        L_0x001d:
            com.miniclip.network.JavaSocket$g r0 = r4._state
            monitor-enter(r0)
            com.miniclip.network.JavaSocket$g r2 = r4._state     // Catch:{ all -> 0x0040 }
            com.miniclip.network.JavaSocket$g r3 = com.miniclip.network.JavaSocket.C4288g.NotConnected     // Catch:{ all -> 0x0040 }
            if (r2 == r3) goto L_0x002f
            java.lang.String r2 = "Socket"
            java.lang.String r3 = "connect() can only be called successfully once per instance"
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x0040 }
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            return r1
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            com.miniclip.network.JavaSocket$f r0 = r4._socketType
            com.miniclip.network.JavaSocket$f r1 = com.miniclip.network.JavaSocket.C4287f.UDP
            if (r0 != r1) goto L_0x003b
            boolean r0 = r4.connectUDP()
            return r0
        L_0x003b:
            boolean r0 = r4.connectTCP()
            return r0
        L_0x0040:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miniclip.network.JavaSocket.connect():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        cleanup();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean disconnect() {
        /*
            r3 = this;
            com.miniclip.network.JavaSocket$g r0 = r3._state
            monitor-enter(r0)
            com.miniclip.network.JavaSocket$g r1 = r3._state     // Catch:{ all -> 0x001f }
            com.miniclip.network.JavaSocket$g r2 = com.miniclip.network.JavaSocket.C4288g.Connected     // Catch:{ all -> 0x001f }
            if (r1 == r2) goto L_0x0019
            com.miniclip.network.JavaSocket$g r1 = r3._state     // Catch:{ all -> 0x001f }
            com.miniclip.network.JavaSocket$g r2 = com.miniclip.network.JavaSocket.C4288g.Connecting     // Catch:{ all -> 0x001f }
            if (r1 == r2) goto L_0x0019
            java.lang.String r1 = "Socket"
            java.lang.String r2 = "disconnect() can only be called on open connections"
            android.util.Log.e(r1, r2)     // Catch:{ all -> 0x001f }
            r1 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return r1
        L_0x0019:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            r3.cleanup()
            r0 = 1
            return r0
        L_0x001f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miniclip.network.JavaSocket.disconnect():boolean");
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this._state) {
            z = this._state == C4288g.Connected;
        }
        return z;
    }

    public void onDataPartial(int i, byte[] bArr) {
        C4286e eVar = this._packetSizeHeaderType;
        if (eVar != C4286e.f11440a) {
            int i2 = C4285d.f11439a[eVar.ordinal()];
            int i3 = i2 != 1 ? i2 != 2 ? i2 != 3 ? 0 : 8 : 4 : 2;
            this._packetBuffer.write(bArr, 0, i);
            while (true) {
                if (this._packetSize == 0 && this._packetBuffer.size() > i3) {
                    int i4 = C4285d.f11439a[this._packetSizeHeaderType.ordinal()];
                    if (i4 == 1) {
                        this._packetSize = ByteBuffer.wrap(this._packetBuffer.toByteArray()).getShort() & 65535;
                    } else if (i4 == 2) {
                        this._packetSize = ByteBuffer.wrap(this._packetBuffer.toByteArray()).getInt();
                    } else if (i4 == 3) {
                        this._packetSize = (int) ByteBuffer.wrap(this._packetBuffer.toByteArray()).getLong();
                    }
                }
                if (this._packetSize != 0 && this._packetBuffer.size() - i3 >= this._packetSize) {
                    onData(this._nativeObject, this._packetBuffer.toByteArray(), i3, this._packetSize);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byteArrayOutputStream.write(this._packetBuffer.toByteArray(), this._packetSize + i3, this._packetBuffer.size() - (this._packetSize + i3));
                    this._packetBuffer = byteArrayOutputStream;
                    this._packetSize = 0;
                } else {
                    return;
                }
            }
        } else {
            onData(this._nativeObject, bArr, 0, i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        r0 = null;
        r2 = com.miniclip.network.JavaSocket.C4285d.f11439a[r5._packetSizeHeaderType.ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r2 == 1) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        if (r2 == 2) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        if (r2 == 3) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        r0 = java.nio.ByteBuffer.allocate(8);
        r0.putLong((long) r6.length);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        r0 = java.nio.ByteBuffer.allocate(4);
        r0.putInt(r6.length);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        if (r6.length <= 65535) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        android.util.Log.e("Socket", "Data size must fit into 2 bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
        r0 = java.nio.ByteBuffer.allocate(2);
        r0.putShort((short) r6.length);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0061, code lost:
        r1 = r5._queuedData;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0064, code lost:
        if (r0 == null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006a, code lost:
        if (r5._socketType == com.miniclip.network.JavaSocket.C4287f.f11445a) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0070, code lost:
        if (r5._socketType != com.miniclip.network.JavaSocket.C4287f.f11446b) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0072, code lost:
        r5._queuedData.add(r0.array());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007b, code lost:
        r5._queuedData.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0080, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0081, code lost:
        r6 = r5._sendThread;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0083, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r5._sendThread.notify();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0089, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008a, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sendData(byte[] r6) {
        /*
            r5 = this;
            int r0 = r6.length
            r1 = 0
            if (r0 != 0) goto L_0x000c
            java.lang.String r6 = "Socket"
            java.lang.String r0 = "Data must not be empty"
            android.util.Log.e(r6, r0)
            return r1
        L_0x000c:
            com.miniclip.network.JavaSocket$g r0 = r5._state
            monitor-enter(r0)
            com.miniclip.network.JavaSocket$g r2 = r5._state     // Catch:{ all -> 0x0091 }
            com.miniclip.network.JavaSocket$g r3 = com.miniclip.network.JavaSocket.C4288g.Closed     // Catch:{ all -> 0x0091 }
            if (r2 != r3) goto L_0x001e
            java.lang.String r6 = "Socket"
            java.lang.String r2 = "Socket has been closed"
            android.util.Log.e(r6, r2)     // Catch:{ all -> 0x0091 }
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            return r1
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            r0 = 0
            int[] r2 = com.miniclip.network.JavaSocket.C4285d.f11439a
            com.miniclip.network.JavaSocket$e r3 = r5._packetSizeHeaderType
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x004a
            if (r2 == r3) goto L_0x0040
            r1 = 3
            if (r2 == r1) goto L_0x0034
            goto L_0x0061
        L_0x0034:
            r0 = 8
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)
            int r1 = r6.length
            long r1 = (long) r1
            r0.putLong(r1)
            goto L_0x0061
        L_0x0040:
            r0 = 4
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)
            int r1 = r6.length
            r0.putInt(r1)
            goto L_0x0061
        L_0x004a:
            int r0 = r6.length
            r2 = 65535(0xffff, float:9.1834E-41)
            if (r0 <= r2) goto L_0x0058
            java.lang.String r6 = "Socket"
            java.lang.String r0 = "Data size must fit into 2 bytes"
            android.util.Log.e(r6, r0)
            return r1
        L_0x0058:
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r3)
            int r1 = r6.length
            short r1 = (short) r1
            r0.putShort(r1)
        L_0x0061:
            java.util.List<byte[]> r1 = r5._queuedData
            monitor-enter(r1)
            if (r0 == 0) goto L_0x007b
            com.miniclip.network.JavaSocket$f r2 = r5._socketType     // Catch:{ all -> 0x008e }
            com.miniclip.network.JavaSocket$f r3 = com.miniclip.network.JavaSocket.C4287f.TCP     // Catch:{ all -> 0x008e }
            if (r2 == r3) goto L_0x0072
            com.miniclip.network.JavaSocket$f r2 = r5._socketType     // Catch:{ all -> 0x008e }
            com.miniclip.network.JavaSocket$f r3 = com.miniclip.network.JavaSocket.C4287f.TCPSSL     // Catch:{ all -> 0x008e }
            if (r2 != r3) goto L_0x007b
        L_0x0072:
            java.util.List<byte[]> r2 = r5._queuedData     // Catch:{ all -> 0x008e }
            byte[] r0 = r0.array()     // Catch:{ all -> 0x008e }
            r2.add(r0)     // Catch:{ all -> 0x008e }
        L_0x007b:
            java.util.List<byte[]> r0 = r5._queuedData     // Catch:{ all -> 0x008e }
            r0.add(r6)     // Catch:{ all -> 0x008e }
            monitor-exit(r1)     // Catch:{ all -> 0x008e }
            java.lang.Thread r6 = r5._sendThread
            monitor-enter(r6)
            java.lang.Thread r0 = r5._sendThread     // Catch:{ all -> 0x008b }
            r0.notify()     // Catch:{ all -> 0x008b }
            monitor-exit(r6)     // Catch:{ all -> 0x008b }
            return r4
        L_0x008b:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x008b }
            throw r0
        L_0x008e:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008e }
            throw r6
        L_0x0091:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miniclip.network.JavaSocket.sendData(byte[]):boolean");
    }

    public void setWorkBufferSize(int i) {
        this._workBufferSize = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        r0 = r4._nativeObject;
        r4._nativeObject = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r4._socketType != com.miniclip.network.JavaSocket.C4287f.f11447c) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        cleanupUdp();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        cleanupTcp();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        r2 = r4._sendThread;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r4._sendThread.notify();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        onDisconnect(r0, r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cleanup(int r5, java.lang.String r6) {
        /*
            r4 = this;
            com.miniclip.network.JavaSocket$g r0 = r4._state
            monitor-enter(r0)
            com.miniclip.network.JavaSocket$g r1 = r4._state     // Catch:{ all -> 0x003a }
            com.miniclip.network.JavaSocket$g r2 = com.miniclip.network.JavaSocket.C4288g.Closed     // Catch:{ all -> 0x003a }
            if (r1 == r2) goto L_0x0038
            com.miniclip.network.JavaSocket$g r1 = r4._state     // Catch:{ all -> 0x003a }
            com.miniclip.network.JavaSocket$g r2 = com.miniclip.network.JavaSocket.C4288g.NotConnected     // Catch:{ all -> 0x003a }
            if (r1 != r2) goto L_0x0010
            goto L_0x0038
        L_0x0010:
            com.miniclip.network.JavaSocket$g r1 = com.miniclip.network.JavaSocket.C4288g.Closed     // Catch:{ all -> 0x003a }
            r4._state = r1     // Catch:{ all -> 0x003a }
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            long r0 = r4._nativeObject
            r2 = 0
            r4._nativeObject = r2
            com.miniclip.network.JavaSocket$f r2 = r4._socketType
            com.miniclip.network.JavaSocket$f r3 = com.miniclip.network.JavaSocket.C4287f.UDP
            if (r2 != r3) goto L_0x0025
            r4.cleanupUdp()
            goto L_0x0028
        L_0x0025:
            r4.cleanupTcp()
        L_0x0028:
            java.lang.Thread r2 = r4._sendThread
            monitor-enter(r2)
            java.lang.Thread r3 = r4._sendThread     // Catch:{ all -> 0x0035 }
            r3.notify()     // Catch:{ all -> 0x0035 }
            monitor-exit(r2)     // Catch:{ all -> 0x0035 }
            onDisconnect(r0, r5, r6)
            return
        L_0x0035:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0035 }
            throw r5
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x003a:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miniclip.network.JavaSocket.cleanup(int, java.lang.String):void");
    }
}
