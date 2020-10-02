package com.applovin.impl.sdk.utils;

import android.util.Xml;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* renamed from: com.applovin.impl.sdk.utils.u */
public class C2033u {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1977q f6748a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Stack<C2035a> f6749b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public StringBuilder f6750c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f6751d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C2035a f6752e;

    /* renamed from: com.applovin.impl.sdk.utils.u$a */
    private static class C2035a extends C2032t {
        C2035a(String str, Map<String, String> map, C2032t tVar) {
            super(str, map, tVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo8843a(C2032t tVar) {
            if (tVar != null) {
                this.f6744c.add(tVar);
                return;
            }
            throw new IllegalArgumentException("None specified.");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo8844d(String str) {
            this.f6743b = str;
        }
    }

    C2033u(C1941j jVar) {
        if (jVar != null) {
            this.f6748a = jVar.mo8602v();
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    /* renamed from: a */
    public static C2032t m8054a(String str, C1941j jVar) throws SAXException {
        return new C2033u(jVar).mo8831a(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m8057a(Attributes attributes) {
        if (attributes == null) {
            return Collections.emptyMap();
        }
        int length = attributes.getLength();
        HashMap hashMap = new HashMap(length);
        for (int i = 0; i < length; i++) {
            hashMap.put(attributes.getQName(i), attributes.getValue(i));
        }
        return hashMap;
    }

    /* renamed from: a */
    public C2032t mo8831a(String str) throws SAXException {
        if (str != null) {
            this.f6750c = new StringBuilder();
            this.f6749b = new Stack<>();
            this.f6752e = null;
            Xml.parse(str, new ContentHandler() {
                public void characters(char[] cArr, int i, int i2) {
                    String trim = new String(Arrays.copyOfRange(cArr, i, i2)).trim();
                    if (C2025o.m7963b(trim)) {
                        C2033u.this.f6750c.append(trim);
                    }
                }

                public void endDocument() {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - C2033u.this.f6751d;
                    C1977q a = C2033u.this.f6748a;
                    a.mo8742b("XmlParser", "Finished parsing in " + seconds + " seconds");
                }

                public void endElement(String str, String str2, String str3) {
                    C2033u uVar = C2033u.this;
                    C2035a unused = uVar.f6752e = (C2035a) uVar.f6749b.pop();
                    C2033u.this.f6752e.mo8844d(C2033u.this.f6750c.toString().trim());
                    C2033u.this.f6750c.setLength(0);
                }

                public void endPrefixMapping(String str) {
                }

                public void ignorableWhitespace(char[] cArr, int i, int i2) {
                }

                public void processingInstruction(String str, String str2) {
                }

                public void setDocumentLocator(Locator locator) {
                }

                public void skippedEntity(String str) {
                }

                public void startDocument() {
                    C2033u.this.f6748a.mo8742b("XmlParser", "Begin parsing...");
                    long unused = C2033u.this.f6751d = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                }

                public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
                    C2035a aVar = null;
                    try {
                        if (!C2033u.this.f6749b.isEmpty()) {
                            aVar = (C2035a) C2033u.this.f6749b.peek();
                        }
                        C2035a aVar2 = new C2035a(str2, C2033u.this.m8057a(attributes), aVar);
                        if (aVar != null) {
                            aVar.mo8843a(aVar2);
                        }
                        C2033u.this.f6749b.push(aVar2);
                    } catch (Exception e) {
                        C1977q a = C2033u.this.f6748a;
                        a.mo8743b("XmlParser", "Unable to process element <" + str2 + ">", e);
                        throw new SAXException("Failed to start element", e);
                    }
                }

                public void startPrefixMapping(String str, String str2) {
                }
            });
            C2035a aVar = this.f6752e;
            if (aVar != null) {
                return aVar;
            }
            throw new SAXException("Unable to parse XML into node");
        }
        throw new IllegalArgumentException("Unable to parse. No XML specified.");
    }
}
