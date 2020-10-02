package com.qumpara.offerwall.sdk.core;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.qumpara.offerwall.sdk.core.QumparaGenericRequest;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;
import com.qumpara.offerwall.sdk.listener.QumparaResponseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

abstract class QumparaOfferwallAPI {
    static long bestOfferAmount;

    QumparaOfferwallAPI() {
    }

    static void getCampaignById(String str) {
        if (QumparaOfferwallUtil.isNetworkAvailable(QumparaOfferwall.getContext()) != 1) {
            QumparaOfferwallLog.m16494w("getCampaignById request not started. Check your internet connection!");
            return;
        }
        QumparaOfferwallLog.m16485d("getCampaignById request started. campaignId: " + str);
        new QumparaGenericRequest(QumparaGenericRequest.RequestType.GET_OFFERWALL_ITEM_DETAIL_REQUEST, new QumparaResponseListener<JSONObject>() {
            public void onError(QumparaOfferwallModels.QumparaOfferwallError qumparaOfferwallError) {
                QumparaOfferwallLog.m16485d(qumparaOfferwallError.toString());
                QumparaOfferwallObservable.getInstance().onReceive(9, String.valueOf(qumparaOfferwallError.getCode()), qumparaOfferwallError.getMessage());
            }

            public void onResponse(JSONObject jSONObject) {
                if (jSONObject != null) {
                    try {
                        QumparaOfferwallObservable.getInstance().onReceive(8, QumparaOfferwallAPI.mapOfferwallResponse(jSONObject).getOfferwallItems());
                    } catch (Exception e) {
                        e.printStackTrace();
                        QumparaOfferwallObservable.getInstance().onReceive(9, String.valueOf(1004), QumparaOfferwall.MESSAGE_AD_ERR_ITEM_DETAIL_FAIL);
                    }
                } else {
                    throw new NullPointerException();
                }
            }
        }).mo30065go(QumparaOfferwall.getContext(), QumparaOfferwallModels.Identifiers.getInstance().getApplicationId(), str);
    }

    static void getCampaigns() {
        if (QumparaOfferwallUtil.isNetworkAvailable(QumparaOfferwall.getContext()) != 1) {
            QumparaOfferwallLog.m16494w("getCampaigns request not started. Check your internet connection!");
            QumparaOfferwallObservable.getInstance().onReceive(3, String.valueOf(1003), QumparaOfferwall.MESSAGE_AD_ERR_NO_INTERNET);
            return;
        }
        QumparaOfferwallLog.m16485d("getCampaigns request started!");
        new QumparaGenericRequest(QumparaGenericRequest.RequestType.GET_OFFERWALL_REQUEST, new QumparaResponseListener<JSONObject>() {
            public void onError(QumparaOfferwallModels.QumparaOfferwallError qumparaOfferwallError) {
                QumparaOfferwallLog.m16485d(qumparaOfferwallError.toString());
                QumparaOfferwallObservable.getInstance().onReceive(3, String.valueOf(qumparaOfferwallError.getCode()), qumparaOfferwallError.getMessage());
            }

            public void onResponse(JSONObject jSONObject) {
                if (jSONObject != null) {
                    try {
                        QumparaOfferwallModels.OfferwallResponse mapOfferwallResponse = QumparaOfferwallAPI.mapOfferwallResponse(jSONObject);
                        if (mapOfferwallResponse.getOfferwallItems() != null) {
                            if (mapOfferwallResponse.getOfferwallItems().size() > 0) {
                                if (mapOfferwallResponse.getMeta().isSSVEnabled()) {
                                    String applicationUserId = QumparaOfferwallModels.Identifiers.getInstance().getApplicationUserId();
                                    if (applicationUserId != null && !"".equals(applicationUserId)) {
                                        if (!"notSet".equals(applicationUserId)) {
                                            QumparaOfferwallAPI.setBestOfferAmount(mapOfferwallResponse.getOfferwallItems());
                                            QumparaOfferwallObservable.getInstance().onReceive(2, new String[0]);
                                            QumparaImpressionManager.getInstance().incrementCountData(1, (String) null, (String) null);
                                            return;
                                        }
                                    }
                                    QumparaOfferwallObservable.getInstance().onReceive(3, String.valueOf(1000), QumparaOfferwall.MESSAGE_AD_ERR_NO_FILL_SSV_CONSTRAINT);
                                    return;
                                }
                                QumparaOfferwallAPI.setBestOfferAmount(mapOfferwallResponse.getOfferwallItems());
                                QumparaOfferwallObservable.getInstance().onReceive(2, new String[0]);
                                QumparaImpressionManager.getInstance().incrementCountData(1, (String) null, (String) null);
                                return;
                            }
                        }
                        QumparaOfferwallObservable.getInstance().onReceive(3, String.valueOf(1000), QumparaOfferwall.MESSAGE_AD_ERR_NO_FILL);
                    } catch (Exception e) {
                        e.printStackTrace();
                        QumparaOfferwallObservable.getInstance().onReceive(3, String.valueOf(1000), QumparaOfferwall.MESSAGE_AD_ERR_NO_FILL);
                    }
                } else {
                    throw new NullPointerException();
                }
            }
        }).mo30065go(QumparaOfferwall.getContext(), QumparaOfferwallModels.Identifiers.getInstance().getApplicationId());
    }

    private static QumparaOfferwallModels.OfferwallItem getOfferwallItem(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("id", "");
            String optString2 = jSONObject.optString("conditionText", "");
            String optString3 = jSONObject.optString(MessengerShareContentUtility.MEDIA_IMAGE, "");
            String optString4 = jSONObject.optString("owDescription", "");
            String optString5 = jSONObject.optString("customer", "");
            String optString6 = jSONObject.optString("trackUrl", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("prizes");
            if (optJSONArray != null) {
                if (optJSONArray.length() == 1) {
                    return new QumparaOfferwallModels.OfferwallItem(optString, optString2, optString3, optString4, optString5, getOfferwallItemPrize(optJSONArray.getJSONObject(0)), optString6);
                }
            }
            return null;
        } catch (Exception e) {
            QumparaOfferwallLog.m16488e("getOfferwallItem parse error!", e);
            return null;
        }
    }

    private static QumparaOfferwallModels.OfferwallItemPrize getOfferwallItemPrize(JSONObject jSONObject) {
        String optString = jSONObject.optString("id", "");
        String optString2 = jSONObject.optString(MessengerShareContentUtility.MEDIA_IMAGE, "");
        String optString3 = jSONObject.optString("name", "");
        String optString4 = jSONObject.optString("headerName", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("asset");
        return new QumparaOfferwallModels.OfferwallItemPrize(optString, optString2, optString3, optString4, new QumparaOfferwallModels.OfferwallItemPrize.PrizeAsset(optJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE, ""), optJSONObject.optString("unit", "")));
    }

    static QumparaOfferwallModels.OfferwallResponse mapOfferwallResponse(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8 = "";
        if (jSONObject == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("campaigns");
            if (jSONArray == null) {
                return null;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    QumparaOfferwallModels.OfferwallItem offerwallItem = getOfferwallItem(jSONObject2);
                    if (offerwallItem != null) {
                        arrayList.add(offerwallItem);
                    }
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("meta");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("button");
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("header");
                str2 = optJSONObject.optString("helpUrl", str8);
                try {
                    if (optJSONObject.optInt("ssvEnabled", 0) == 1) {
                        z = true;
                    }
                    if (optJSONObject2 == null || optJSONObject3 == null) {
                        str6 = str8;
                        str5 = str6;
                        str4 = str5;
                        str3 = str4;
                        str = str3;
                    } else {
                        String optString = optJSONObject2.optString("backgroundStart", str8);
                        try {
                            str = optJSONObject2.optString("backgroundEnd", str8);
                            try {
                                str3 = optJSONObject2.optString("foreground", str8);
                                try {
                                    str4 = optJSONObject3.optString("backgroundStart", str8);
                                    try {
                                        str5 = optJSONObject3.optString("backgroundEnd", str8);
                                    } catch (Exception e) {
                                        e = e;
                                        str5 = str8;
                                        Exception exc = e;
                                        str7 = optString;
                                        e = exc;
                                        QumparaOfferwallLog.allError("ERROR: offerwall response format is not correct!!", e);
                                        String str9 = str8;
                                        str8 = str7;
                                        str6 = str9;
                                        return new QumparaOfferwallModels.OfferwallResponse(arrayList, new QumparaOfferwallModels.MetaData(new QumparaOfferwallModels.MetaColor(str8, str, str3), new QumparaOfferwallModels.MetaColor(str4, str5, str6), str2, z));
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    str5 = str8;
                                    str4 = str5;
                                    Exception exc2 = e;
                                    str7 = optString;
                                    e = exc2;
                                    QumparaOfferwallLog.allError("ERROR: offerwall response format is not correct!!", e);
                                    String str92 = str8;
                                    str8 = str7;
                                    str6 = str92;
                                    return new QumparaOfferwallModels.OfferwallResponse(arrayList, new QumparaOfferwallModels.MetaData(new QumparaOfferwallModels.MetaColor(str8, str, str3), new QumparaOfferwallModels.MetaColor(str4, str5, str6), str2, z));
                                }
                            } catch (Exception e3) {
                                e = e3;
                                str5 = str8;
                                str4 = str5;
                                str3 = str4;
                                Exception exc22 = e;
                                str7 = optString;
                                e = exc22;
                                QumparaOfferwallLog.allError("ERROR: offerwall response format is not correct!!", e);
                                String str922 = str8;
                                str8 = str7;
                                str6 = str922;
                                return new QumparaOfferwallModels.OfferwallResponse(arrayList, new QumparaOfferwallModels.MetaData(new QumparaOfferwallModels.MetaColor(str8, str, str3), new QumparaOfferwallModels.MetaColor(str4, str5, str6), str2, z));
                            }
                        } catch (Exception e4) {
                            e = e4;
                            str5 = str8;
                            str4 = str5;
                            str3 = str4;
                            str = str3;
                            Exception exc222 = e;
                            str7 = optString;
                            e = exc222;
                            QumparaOfferwallLog.allError("ERROR: offerwall response format is not correct!!", e);
                            String str9222 = str8;
                            str8 = str7;
                            str6 = str9222;
                            return new QumparaOfferwallModels.OfferwallResponse(arrayList, new QumparaOfferwallModels.MetaData(new QumparaOfferwallModels.MetaColor(str8, str, str3), new QumparaOfferwallModels.MetaColor(str4, str5, str6), str2, z));
                        }
                        try {
                            str6 = optJSONObject3.optString("foreground", str8);
                            str8 = optString;
                        } catch (Exception e5) {
                            e = e5;
                            Exception exc2222 = e;
                            str7 = optString;
                            e = exc2222;
                            QumparaOfferwallLog.allError("ERROR: offerwall response format is not correct!!", e);
                            String str92222 = str8;
                            str8 = str7;
                            str6 = str92222;
                            return new QumparaOfferwallModels.OfferwallResponse(arrayList, new QumparaOfferwallModels.MetaData(new QumparaOfferwallModels.MetaColor(str8, str, str3), new QumparaOfferwallModels.MetaColor(str4, str5, str6), str2, z));
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    str7 = str8;
                    str5 = str7;
                    str4 = str5;
                    str3 = str4;
                    str = str3;
                    QumparaOfferwallLog.allError("ERROR: offerwall response format is not correct!!", e);
                    String str922222 = str8;
                    str8 = str7;
                    str6 = str922222;
                    return new QumparaOfferwallModels.OfferwallResponse(arrayList, new QumparaOfferwallModels.MetaData(new QumparaOfferwallModels.MetaColor(str8, str, str3), new QumparaOfferwallModels.MetaColor(str4, str5, str6), str2, z));
                }
            } else {
                str6 = str8;
                str5 = str6;
                str4 = str5;
                str3 = str4;
                str2 = str3;
                str = str2;
            }
            return new QumparaOfferwallModels.OfferwallResponse(arrayList, new QumparaOfferwallModels.MetaData(new QumparaOfferwallModels.MetaColor(str8, str, str3), new QumparaOfferwallModels.MetaColor(str4, str5, str6), str2, z));
        } catch (Exception e7) {
            e = e7;
            str7 = str8;
            str5 = str7;
            str4 = str5;
            str3 = str4;
            str2 = str3;
            str = str2;
            QumparaOfferwallLog.allError("ERROR: offerwall response format is not correct!!", e);
            String str9222222 = str8;
            str8 = str7;
            str6 = str9222222;
            return new QumparaOfferwallModels.OfferwallResponse(arrayList, new QumparaOfferwallModels.MetaData(new QumparaOfferwallModels.MetaColor(str8, str, str3), new QumparaOfferwallModels.MetaColor(str4, str5, str6), str2, z));
        }
    }

    static boolean postCountData(String str) {
        if (QumparaOfferwallUtil.isNetworkAvailable(QumparaOfferwall.getContext()) != 1) {
            QumparaOfferwallLog.m16494w("postCountData request not started. Check your internet connection!");
            QumparaImpressionManager.getInstance().setSendingImpressionFalse();
            return false;
        }
        QumparaOfferwallLog.m16485d("postCountData request started. postData: " + str);
        new QumparaGenericRequest(QumparaGenericRequest.RequestType.POST_OFFERWALL_COUNT_DATA, new QumparaResponseListener<JSONObject>() {
            public void onError(QumparaOfferwallModels.QumparaOfferwallError qumparaOfferwallError) {
                QumparaOfferwallLog.m16485d("postCountData onError");
                QumparaImpressionManager.getInstance().setSendingImpressionFalse();
                QumparaOfferwallLog.m16485d(qumparaOfferwallError.toString());
            }

            public void onResponse(JSONObject jSONObject) {
                if (jSONObject != null) {
                    QumparaOfferwallPreferences.getInstance(QumparaOfferwall.getContext()).removeCountData();
                    QumparaImpressionManager.getInstance().setSendingImpressionFalse();
                    return;
                }
                QumparaOfferwallLog.m16485d("postCountData response null ");
                QumparaImpressionManager.getInstance().setSendingImpressionFalse();
            }
        }).mo30065go(QumparaOfferwall.getContext(), str);
        return true;
    }

    static boolean postEngagement(final QumparaOfferwallModels.OfferwallItem offerwallItem) {
        if (QumparaOfferwallUtil.isNetworkAvailable(QumparaOfferwall.getContext()) != 1) {
            QumparaOfferwallLog.m16494w("postEngagement request not started. Check your internet connection!");
            QumparaOfferwallObservable.getInstance().onReceive(11, offerwallItem.getId(), String.valueOf(1003), QumparaOfferwall.MESSAGE_AD_ERR_NO_INTERNET);
            return false;
        }
        String engagementRecord = QumparaOfferwallModels.Identifiers.getInstance().toEngagementRecord(offerwallItem.getId());
        QumparaOfferwallLog.m16485d("postEngagement request started. postData: " + engagementRecord);
        new QumparaGenericRequest(QumparaGenericRequest.RequestType.POST_OFFERWALL_SEND_ENGAGEMENT, new QumparaResponseListener<JSONObject>() {
            public void onError(QumparaOfferwallModels.QumparaOfferwallError qumparaOfferwallError) {
                QumparaOfferwallLog.m16485d(qumparaOfferwallError.toString());
                QumparaOfferwallObservable.getInstance().onReceive(11, offerwallItem.getId(), String.valueOf(qumparaOfferwallError.getCode()), qumparaOfferwallError.getMessage());
            }

            public void onResponse(JSONObject jSONObject) {
                if (jSONObject == null || !jSONObject.optString("operation", "").equals("engaged") || QumparaOfferwallUtil.isNullOrEmpty(jSONObject.optString("campaignUrl", ""))) {
                    QumparaOfferwallObservable.getInstance().onReceive(11, offerwallItem.getId(), String.valueOf(1005), QumparaOfferwall.MESSAGE_AD_ERR_ENGAGEMENT_FAIL);
                    return;
                }
                QumparaOfferwallObservable.getInstance().onReceive(10, offerwallItem.getId(), jSONObject.optString("campaignUrl", ""), offerwallItem.getCustomer(), offerwallItem.getRedirectURL(), jSONObject.optString("kfi", ""));
            }
        }).mo30065go(QumparaOfferwall.getContext(), engagementRecord);
        return true;
    }

    static void postRedeemCode(final String str, String str2, String str3, String str4) {
        String str5;
        if (QumparaOfferwallUtil.isNetworkAvailable(QumparaOfferwall.getContext()) != 1) {
            QumparaOfferwallLog.m16494w("postRedeemCode request not started. Check your internet connection!");
            QumparaOfferwallObservable.getInstance().onReceive(14, str, String.valueOf(1003), QumparaOfferwall.MESSAGE_AD_ERR_NO_INTERNET);
            return;
        }
        if (str4 == null || str4.equals("") || str4.equals("notSet")) {
            str5 = String.format(Locale.ENGLISH, "{\"code\":\"%s\",\"idfa\":\"%s\",\"applicationId\":\"%s\"}", new Object[]{str, str2, str3});
        } else {
            str5 = String.format(Locale.ENGLISH, "{\"code\":\"%s\",\"idfa\":\"%s\",\"applicationId\":\"%s\",\"applicationUserId\":\"%s\"}", new Object[]{str, str2, str3, str4});
        }
        QumparaOfferwallLog.m16485d("postRedeemCode request started. postData: " + str5);
        new QumparaGenericRequest(QumparaGenericRequest.RequestType.POST_OFFERWALL_REDEEM_CODE, new QumparaResponseListener<JSONObject>() {
            public void onError(QumparaOfferwallModels.QumparaOfferwallError qumparaOfferwallError) {
                QumparaOfferwallLog.m16485d(qumparaOfferwallError.toString());
                QumparaOfferwallObservable.getInstance().onReceive(14, str, String.valueOf(qumparaOfferwallError.getCode()), qumparaOfferwallError.getMessage());
            }

            public void onResponse(JSONObject jSONObject) {
                if (jSONObject == null || !jSONObject.optString("operation", "").equals("redeemed")) {
                    QumparaOfferwallObservable.getInstance().onReceive(14, str, String.valueOf(1007), QumparaOfferwall.MESSAGE_AD_ERR_REDEEM_FAIL);
                    return;
                }
                QumparaOfferwallObservable.getInstance().onReceive(13, str, jSONObject.optString("campaign", ""), jSONObject.optString("customer", ""));
            }
        }).mo30065go(QumparaOfferwall.getContext(), str5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean postSpendVirtualCurrency(java.lang.String r11, java.lang.String r12, final com.qumpara.offerwall.sdk.listener.QumparaOfferwallVirtualCurrencyListener r13) {
        /*
            android.content.Context r0 = com.qumpara.offerwall.sdk.core.QumparaOfferwall.getContext()
            int r0 = com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.isNetworkAvailable(r0)
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x0019
            java.lang.String r11 = "postSpendVirtualCurrency request not started. Check your internet connection!"
            com.qumpara.offerwall.sdk.core.QumparaOfferwallLog.m16494w(r11)
            r11 = 1003(0x3eb, float:1.406E-42)
            java.lang.String r12 = "Error: No Internet."
            r13.fail(r11, r12)
            return r2
        L_0x0019:
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallStatus r0 = com.qumpara.offerwall.sdk.core.QumparaOfferwallModels.OfferwallStatus.getInstance()
            long r3 = r0.getLastVirtualCurrencySentAt()
            r5 = 30000(0x7530, double:1.4822E-319)
            long r5 = r5 + r3
            long r7 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r7
            boolean r7 = r0.isHelpClicked()
            r8 = -1
            if (r7 == 0) goto L_0x0034
            r0.setHelpClicked(r2)
            goto L_0x0076
        L_0x0034:
            boolean r7 = r0.isOfferwallOpened()
            if (r7 != 0) goto L_0x003f
            r3 = 1011(0x3f3, float:1.417E-42)
            java.lang.String r4 = "Error: Offerwall has not been opened for this client. You need to show it at least once."
            goto L_0x0079
        L_0x003f:
            boolean r7 = r0.isEngagedBefore()
            if (r7 != 0) goto L_0x0050
            boolean r7 = r0.isRedeemedBefore()
            if (r7 != 0) goto L_0x0050
            r3 = 1012(0x3f4, float:1.418E-42)
            java.lang.String r4 = "Error: Neither engage nor redeem code called before for this client."
            goto L_0x0079
        L_0x0050:
            r9 = 0
            int r7 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x0076
            int r3 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x0076
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error: Spend virtual currency called too frequently. remaining time to request: "
            r3.append(r4)
            r9 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r9
            r3.append(r5)
            java.lang.String r4 = " sec."
            r3.append(r4)
            java.lang.String r4 = r3.toString()
            r3 = 1010(0x3f2, float:1.415E-42)
            goto L_0x0079
        L_0x0076:
            java.lang.String r4 = ""
            r3 = -1
        L_0x0079:
            if (r3 == r8) goto L_0x009b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "postSpendVirtualCurrency request not sent! Error message: "
            r11.append(r12)
            r11.append(r4)
            java.lang.String r12 = " , code: "
            r11.append(r12)
            r11.append(r3)
            java.lang.String r11 = r11.toString()
            com.qumpara.offerwall.sdk.core.QumparaOfferwallLog.m16494w(r11)
            r13.fail(r3, r4)
            return r2
        L_0x009b:
            long r3 = java.lang.System.currentTimeMillis()
            r0.setLastVirtualCurrencySentAt(r3)
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels.OfferwallStatus.putInstance(r0)
            java.util.Locale r0 = java.util.Locale.ENGLISH
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r11
            r3[r1] = r12
            java.lang.String r11 = "{\"applicationId\":\"%s\",\"idfa\":\"%s\"}"
            java.lang.String r11 = java.lang.String.format(r0, r11, r3)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "postSpendVirtualCurrency request started. postData: "
            r12.append(r0)
            r12.append(r11)
            java.lang.String r12 = r12.toString()
            com.qumpara.offerwall.sdk.core.QumparaOfferwallLog.m16485d(r12)
            com.qumpara.offerwall.sdk.core.QumparaOfferwallAPI$5 r12 = new com.qumpara.offerwall.sdk.core.QumparaOfferwallAPI$5
            r12.<init>(r13)
            com.qumpara.offerwall.sdk.core.QumparaGenericRequest r13 = new com.qumpara.offerwall.sdk.core.QumparaGenericRequest
            com.qumpara.offerwall.sdk.core.QumparaGenericRequest$RequestType r0 = com.qumpara.offerwall.sdk.core.QumparaGenericRequest.RequestType.POST_OFFERWALL_SPEND_VIRTUAL_CURRENCY
            r13.<init>(r0, r12)
            android.content.Context r12 = com.qumpara.offerwall.sdk.core.QumparaOfferwall.getContext()
            java.lang.String[] r0 = new java.lang.String[r1]
            r0[r2] = r11
            r13.mo30065go(r12, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qumpara.offerwall.sdk.core.QumparaOfferwallAPI.postSpendVirtualCurrency(java.lang.String, java.lang.String, com.qumpara.offerwall.sdk.listener.QumparaOfferwallVirtualCurrencyListener):boolean");
    }

    static void setBestOfferAmount(ArrayList<QumparaOfferwallModels.OfferwallItem> arrayList) {
        long j = 0;
        try {
            Iterator<QumparaOfferwallModels.OfferwallItem> it = arrayList.iterator();
            while (it.hasNext()) {
                long parseLong = Long.parseLong(it.next().getPrize().getAsset().getValue());
                if (j <= parseLong) {
                    j = parseLong;
                }
            }
            bestOfferAmount = j;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void destroy();

    public abstract boolean isLoaded();

    public abstract void load();

    public abstract void show();
}
