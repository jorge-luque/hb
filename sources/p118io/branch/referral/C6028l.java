package p118io.branch.referral;

import admost.sdk.listener.AdMostAdListener;
import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.games.Notifications;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;

/* renamed from: io.branch.referral.l */
/* compiled from: Defines */
public enum C6028l {
    IdentityID("identity_id"),
    Identity("identity"),
    DeviceFingerprintID("device_fingerprint_id"),
    SessionID(TapjoyConstants.TJC_SESSION_ID),
    LinkClickID("link_click_id"),
    GoogleSearchInstallReferrer("google_search_install_referrer"),
    GooglePlayInstallReferrer("install_referrer_extras"),
    ClickedReferrerTimeStamp("clicked_referrer_ts"),
    InstallBeginTimeStamp("install_begin_ts"),
    FaceBookAppLinkChecked("facebook_app_link_checked"),
    BranchLinkUsed("branch_used"),
    ReferringBranchIdentity("referring_branch_identity"),
    BranchIdentity("branch_identity"),
    BranchKey("branch_key"),
    BranchData("branch_data"),
    Bucket("bucket"),
    DefaultBucket("default"),
    Amount("amount"),
    CalculationType("calculation_type"),
    Location(PlaceFields.LOCATION),
    Type("type"),
    CreationSource("creation_source"),
    Prefix("prefix"),
    Expiration("expiration"),
    Event(TapjoyConstants.TJC_SDK_TYPE_DEFAULT),
    Metadata("metadata"),
    CommerceData("commerce_data"),
    ReferralCode("referral_code"),
    Total("total"),
    Unique("unique"),
    Length("length"),
    Direction("direction"),
    BeginAfterID("begin_after_id"),
    Link("link"),
    ReferringData("referring_data"),
    ReferringLink("referring_link"),
    IsFullAppConv("is_full_app_conversion"),
    Data("data"),
    OS("os"),
    HardwareID("hardware_id"),
    AndroidID(TapjoyConstants.TJC_ANDROID_ID),
    UnidentifiedDevice("unidentified_device"),
    HardwareIDType("hardware_id_type"),
    HardwareIDTypeVendor("vendor_id"),
    HardwareIDTypeRandom("random"),
    IsHardwareIDReal("is_hardware_id_real"),
    AppVersion(TapjoyConstants.TJC_APP_VERSION_NAME),
    OSVersion(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME),
    Country(UserDataStore.COUNTRY),
    Language("language"),
    IsReferrable("is_referrable"),
    Update("update"),
    OriginalInstallTime("first_install_time"),
    FirstInstallTime("latest_install_time"),
    LastUpdateTime("latest_update_time"),
    PreviousUpdateTime("previous_update_time"),
    URIScheme("uri_scheme"),
    AppLinks(PlaceFields.APP_LINKS),
    AppIdentifier("app_identifier"),
    LinkIdentifier("link_identifier"),
    GoogleAdvertisingID("google_advertising_id"),
    AAID("aaid"),
    LATVal("lat_val"),
    LimitedAdTracking("limit_ad_tracking"),
    limitFacebookTracking("limit_facebook_tracking"),
    Debug("debug"),
    Brand("brand"),
    Model("model"),
    ScreenDpi("screen_dpi"),
    ScreenHeight("screen_height"),
    ScreenWidth("screen_width"),
    WiFi(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI),
    LocalIP("local_ip"),
    UserData("user_data"),
    DeveloperIdentity("developer_identity"),
    UserAgent("user_agent"),
    SDK("sdk"),
    SdkVersion("sdk_version"),
    UIMode("ui_mode"),
    InstallMetadata("install_metadata"),
    Clicked_Branch_Link("+clicked_branch_link"),
    IsFirstSession("+is_first_session"),
    AndroidDeepLinkPath("$android_deeplink_path"),
    DeepLinkPath("$deeplink_path"),
    AndroidAppLinkURL("android_app_link_url"),
    AndroidPushNotificationKey("branch"),
    AndroidPushIdentifier("push_identifier"),
    ForceNewBranchSession("branch_force_new_session"),
    CanonicalIdentifier("$canonical_identifier"),
    ContentTitle("$og_title"),
    ContentDesc("$og_description"),
    ContentImgUrl("$og_image_url"),
    CanonicalUrl("$canonical_url"),
    ContentType("$content_type"),
    PublicallyIndexable("$publicly_indexable"),
    LocallyIndexable("$locally_indexable"),
    ContentKeyWords("$keywords"),
    ContentExpiryTime("$exp_date"),
    Params(NativeProtocol.WEB_DIALOG_PARAMS),
    SharedLink("$shared_link"),
    ShareError("$share_error"),
    External_Intent_URI("external_intent_uri"),
    External_Intent_Extra("external_intent_extra"),
    Last_Round_Trip_Time("lrtt"),
    Branch_Round_Trip_Time("brtt"),
    Branch_Instrumentation("instrumentation"),
    Queue_Wait_Time("qwt"),
    InstantDeepLinkSession("instant_dl_session"),
    BranchViewData("branch_view_data"),
    BranchViewID("id"),
    BranchViewAction(NativeProtocol.WEB_DIALOG_ACTION),
    BranchViewNumOfUse("number_of_use"),
    BranchViewUrl("url"),
    BranchViewHtml(TJAdUnitConstants.String.HTML),
    Path("path"),
    ViewList("view_list"),
    ContentActionView(ViewHierarchyConstants.VIEW_KEY),
    ContentPath("content_path"),
    ContentNavPath("content_nav_path"),
    ReferralLink("referral_link"),
    ContentData("content_data"),
    ContentEvents("events"),
    ContentAnalyticsMode("content_analytics_mode"),
    ContentDiscovery("cd"),
    Environment("environment"),
    InstantApp("INSTANT_APP"),
    NativeApp("FULL_APP"),
    TransactionID(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER),
    Currency("currency"),
    Revenue("revenue"),
    Shipping("shipping"),
    Tax("tax"),
    Coupon("coupon"),
    Affiliation("affiliation"),
    Description("description"),
    SearchQuery("search_query"),
    Name("name"),
    CustomData("custom_data"),
    EventData("event_data"),
    ContentItems("content_items"),
    ContentSchema("$content_schema"),
    Price("$price"),
    PriceCurrency("$currency"),
    Quantity("$quantity"),
    SKU("$sku"),
    ProductName("$product_name"),
    ProductBrand("$product_brand"),
    ProductCategory("$product_category"),
    ProductVariant("$product_variant"),
    Rating("$rating"),
    RatingAverage("$rating_average"),
    RatingCount("$rating_count"),
    RatingMax("$rating_max"),
    AddressStreet("$address_street"),
    AddressCity("$address_city"),
    AddressRegion("$address_region"),
    AddressCountry("$address_country"),
    AddressPostalCode("$address_postal_code"),
    Latitude("$latitude"),
    Longitude("$longitude"),
    ImageCaptions("$image_captions"),
    Condition("$condition"),
    CreationTimestamp("$creation_timestamp"),
    TrackingDisabled("tracking_disabled"),
    Instant("instant");
    

    /* renamed from: a */
    private String f15589a;

    static {
        IdentityID = new C6028l("IdentityID", 0, "identity_id");
        Identity = new C6028l("Identity", 1, "identity");
        DeviceFingerprintID = new C6028l("DeviceFingerprintID", 2, "device_fingerprint_id");
        SessionID = new C6028l("SessionID", 3, TapjoyConstants.TJC_SESSION_ID);
        LinkClickID = new C6028l("LinkClickID", 4, "link_click_id");
        GoogleSearchInstallReferrer = new C6028l("GoogleSearchInstallReferrer", 5, "google_search_install_referrer");
        GooglePlayInstallReferrer = new C6028l("GooglePlayInstallReferrer", 6, "install_referrer_extras");
        ClickedReferrerTimeStamp = new C6028l("ClickedReferrerTimeStamp", 7, "clicked_referrer_ts");
        InstallBeginTimeStamp = new C6028l("InstallBeginTimeStamp", 8, "install_begin_ts");
        FaceBookAppLinkChecked = new C6028l("FaceBookAppLinkChecked", 9, "facebook_app_link_checked");
        BranchLinkUsed = new C6028l("BranchLinkUsed", 10, "branch_used");
        ReferringBranchIdentity = new C6028l("ReferringBranchIdentity", 11, "referring_branch_identity");
        BranchIdentity = new C6028l("BranchIdentity", 12, "branch_identity");
        BranchKey = new C6028l("BranchKey", 13, "branch_key");
        BranchData = new C6028l("BranchData", 14, "branch_data");
        Bucket = new C6028l("Bucket", 15, "bucket");
        DefaultBucket = new C6028l("DefaultBucket", 16, "default");
        Amount = new C6028l("Amount", 17, "amount");
        CalculationType = new C6028l("CalculationType", 18, "calculation_type");
        Location = new C6028l("Location", 19, PlaceFields.LOCATION);
        Type = new C6028l("Type", 20, "type");
        CreationSource = new C6028l("CreationSource", 21, "creation_source");
        Prefix = new C6028l("Prefix", 22, "prefix");
        Expiration = new C6028l("Expiration", 23, "expiration");
        Event = new C6028l("Event", 24, TapjoyConstants.TJC_SDK_TYPE_DEFAULT);
        Metadata = new C6028l("Metadata", 25, "metadata");
        CommerceData = new C6028l("CommerceData", 26, "commerce_data");
        ReferralCode = new C6028l("ReferralCode", 27, "referral_code");
        Total = new C6028l("Total", 28, "total");
        Unique = new C6028l("Unique", 29, "unique");
        Length = new C6028l("Length", 30, "length");
        Direction = new C6028l("Direction", 31, "direction");
        BeginAfterID = new C6028l("BeginAfterID", 32, "begin_after_id");
        Link = new C6028l("Link", 33, "link");
        ReferringData = new C6028l("ReferringData", 34, "referring_data");
        ReferringLink = new C6028l("ReferringLink", 35, "referring_link");
        IsFullAppConv = new C6028l("IsFullAppConv", 36, "is_full_app_conversion");
        Data = new C6028l("Data", 37, "data");
        OS = new C6028l("OS", 38, "os");
        HardwareID = new C6028l("HardwareID", 39, "hardware_id");
        AndroidID = new C6028l("AndroidID", 40, TapjoyConstants.TJC_ANDROID_ID);
        UnidentifiedDevice = new C6028l("UnidentifiedDevice", 41, "unidentified_device");
        HardwareIDType = new C6028l("HardwareIDType", 42, "hardware_id_type");
        HardwareIDTypeVendor = new C6028l("HardwareIDTypeVendor", 43, "vendor_id");
        HardwareIDTypeRandom = new C6028l("HardwareIDTypeRandom", 44, "random");
        IsHardwareIDReal = new C6028l("IsHardwareIDReal", 45, "is_hardware_id_real");
        AppVersion = new C6028l("AppVersion", 46, TapjoyConstants.TJC_APP_VERSION_NAME);
        OSVersion = new C6028l("OSVersion", 47, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME);
        Country = new C6028l("Country", 48, UserDataStore.COUNTRY);
        Language = new C6028l("Language", 49, "language");
        IsReferrable = new C6028l("IsReferrable", 50, "is_referrable");
        Update = new C6028l("Update", 51, "update");
        OriginalInstallTime = new C6028l("OriginalInstallTime", 52, "first_install_time");
        FirstInstallTime = new C6028l("FirstInstallTime", 53, "latest_install_time");
        LastUpdateTime = new C6028l("LastUpdateTime", 54, "latest_update_time");
        PreviousUpdateTime = new C6028l("PreviousUpdateTime", 55, "previous_update_time");
        URIScheme = new C6028l("URIScheme", 56, "uri_scheme");
        AppLinks = new C6028l("AppLinks", 57, PlaceFields.APP_LINKS);
        AppIdentifier = new C6028l("AppIdentifier", 58, "app_identifier");
        LinkIdentifier = new C6028l("LinkIdentifier", 59, "link_identifier");
        GoogleAdvertisingID = new C6028l("GoogleAdvertisingID", 60, "google_advertising_id");
        AAID = new C6028l("AAID", 61, "aaid");
        LATVal = new C6028l("LATVal", 62, "lat_val");
        LimitedAdTracking = new C6028l("LimitedAdTracking", 63, "limit_ad_tracking");
        limitFacebookTracking = new C6028l("limitFacebookTracking", 64, "limit_facebook_tracking");
        Debug = new C6028l("Debug", 65, "debug");
        Brand = new C6028l("Brand", 66, "brand");
        Model = new C6028l("Model", 67, "model");
        ScreenDpi = new C6028l("ScreenDpi", 68, "screen_dpi");
        ScreenHeight = new C6028l("ScreenHeight", 69, "screen_height");
        ScreenWidth = new C6028l("ScreenWidth", 70, "screen_width");
        WiFi = new C6028l("WiFi", 71, TapjoyConstants.TJC_CONNECTION_TYPE_WIFI);
        LocalIP = new C6028l("LocalIP", 72, "local_ip");
        UserData = new C6028l("UserData", 73, "user_data");
        DeveloperIdentity = new C6028l("DeveloperIdentity", 74, "developer_identity");
        UserAgent = new C6028l("UserAgent", 75, "user_agent");
        SDK = new C6028l("SDK", 76, "sdk");
        SdkVersion = new C6028l("SdkVersion", 77, "sdk_version");
        UIMode = new C6028l("UIMode", 78, "ui_mode");
        InstallMetadata = new C6028l("InstallMetadata", 79, "install_metadata");
        Clicked_Branch_Link = new C6028l("Clicked_Branch_Link", 80, "+clicked_branch_link");
        IsFirstSession = new C6028l("IsFirstSession", 81, "+is_first_session");
        AndroidDeepLinkPath = new C6028l("AndroidDeepLinkPath", 82, "$android_deeplink_path");
        DeepLinkPath = new C6028l("DeepLinkPath", 83, "$deeplink_path");
        AndroidAppLinkURL = new C6028l("AndroidAppLinkURL", 84, "android_app_link_url");
        AndroidPushNotificationKey = new C6028l("AndroidPushNotificationKey", 85, "branch");
        AndroidPushIdentifier = new C6028l("AndroidPushIdentifier", 86, "push_identifier");
        ForceNewBranchSession = new C6028l("ForceNewBranchSession", 87, "branch_force_new_session");
        CanonicalIdentifier = new C6028l("CanonicalIdentifier", 88, "$canonical_identifier");
        ContentTitle = new C6028l("ContentTitle", 89, "$og_title");
        ContentDesc = new C6028l("ContentDesc", 90, "$og_description");
        ContentImgUrl = new C6028l("ContentImgUrl", 91, "$og_image_url");
        CanonicalUrl = new C6028l("CanonicalUrl", 92, "$canonical_url");
        ContentType = new C6028l("ContentType", 93, "$content_type");
        PublicallyIndexable = new C6028l("PublicallyIndexable", 94, "$publicly_indexable");
        LocallyIndexable = new C6028l("LocallyIndexable", 95, "$locally_indexable");
        ContentKeyWords = new C6028l("ContentKeyWords", 96, "$keywords");
        ContentExpiryTime = new C6028l("ContentExpiryTime", 97, "$exp_date");
        Params = new C6028l("Params", 98, NativeProtocol.WEB_DIALOG_PARAMS);
        SharedLink = new C6028l("SharedLink", 99, "$shared_link");
        ShareError = new C6028l("ShareError", 100, "$share_error");
        External_Intent_URI = new C6028l("External_Intent_URI", 101, "external_intent_uri");
        External_Intent_Extra = new C6028l("External_Intent_Extra", 102, "external_intent_extra");
        Last_Round_Trip_Time = new C6028l("Last_Round_Trip_Time", 103, "lrtt");
        Branch_Round_Trip_Time = new C6028l("Branch_Round_Trip_Time", 104, "brtt");
        Branch_Instrumentation = new C6028l("Branch_Instrumentation", 105, "instrumentation");
        Queue_Wait_Time = new C6028l("Queue_Wait_Time", 106, "qwt");
        InstantDeepLinkSession = new C6028l("InstantDeepLinkSession", 107, "instant_dl_session");
        BranchViewData = new C6028l("BranchViewData", 108, "branch_view_data");
        BranchViewID = new C6028l("BranchViewID", 109, "id");
        BranchViewAction = new C6028l("BranchViewAction", 110, NativeProtocol.WEB_DIALOG_ACTION);
        BranchViewNumOfUse = new C6028l("BranchViewNumOfUse", 111, "number_of_use");
        BranchViewUrl = new C6028l("BranchViewUrl", 112, "url");
        BranchViewHtml = new C6028l("BranchViewHtml", 113, TJAdUnitConstants.String.HTML);
        Path = new C6028l("Path", 114, "path");
        ViewList = new C6028l("ViewList", 115, "view_list");
        ContentActionView = new C6028l("ContentActionView", 116, ViewHierarchyConstants.VIEW_KEY);
        ContentPath = new C6028l("ContentPath", 117, "content_path");
        ContentNavPath = new C6028l("ContentNavPath", 118, "content_nav_path");
        ReferralLink = new C6028l("ReferralLink", 119, "referral_link");
        ContentData = new C6028l("ContentData", 120, "content_data");
        ContentEvents = new C6028l("ContentEvents", 121, "events");
        ContentAnalyticsMode = new C6028l("ContentAnalyticsMode", 122, "content_analytics_mode");
        ContentDiscovery = new C6028l("ContentDiscovery", 123, "cd");
        Environment = new C6028l("Environment", 124, "environment");
        InstantApp = new C6028l("InstantApp", 125, "INSTANT_APP");
        NativeApp = new C6028l("NativeApp", 126, "FULL_APP");
        TransactionID = new C6028l("TransactionID", Notifications.NOTIFICATION_TYPES_ALL, AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER);
        Currency = new C6028l("Currency", OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE, "currency");
        Revenue = new C6028l("Revenue", 129, "revenue");
        Shipping = new C6028l("Shipping", 130, "shipping");
        Tax = new C6028l("Tax", 131, "tax");
        Coupon = new C6028l("Coupon", 132, "coupon");
        Affiliation = new C6028l("Affiliation", 133, "affiliation");
        Description = new C6028l("Description", 134, "description");
        SearchQuery = new C6028l("SearchQuery", 135, "search_query");
        Name = new C6028l("Name", 136, "name");
        CustomData = new C6028l("CustomData", 137, "custom_data");
        EventData = new C6028l("EventData", 138, "event_data");
        ContentItems = new C6028l("ContentItems", 139, "content_items");
        ContentSchema = new C6028l("ContentSchema", 140, "$content_schema");
        Price = new C6028l("Price", 141, "$price");
        PriceCurrency = new C6028l("PriceCurrency", 142, "$currency");
        Quantity = new C6028l("Quantity", 143, "$quantity");
        SKU = new C6028l("SKU", 144, "$sku");
        ProductName = new C6028l("ProductName", 145, "$product_name");
        ProductBrand = new C6028l("ProductBrand", 146, "$product_brand");
        ProductCategory = new C6028l("ProductCategory", 147, "$product_category");
        ProductVariant = new C6028l("ProductVariant", 148, "$product_variant");
        Rating = new C6028l("Rating", 149, "$rating");
        RatingAverage = new C6028l("RatingAverage", 150, "$rating_average");
        RatingCount = new C6028l("RatingCount", 151, "$rating_count");
        RatingMax = new C6028l("RatingMax", 152, "$rating_max");
        AddressStreet = new C6028l("AddressStreet", 153, "$address_street");
        AddressCity = new C6028l("AddressCity", 154, "$address_city");
        AddressRegion = new C6028l("AddressRegion", 155, "$address_region");
        AddressCountry = new C6028l("AddressCountry", 156, "$address_country");
        AddressPostalCode = new C6028l("AddressPostalCode", 157, "$address_postal_code");
        Latitude = new C6028l("Latitude", 158, "$latitude");
        Longitude = new C6028l("Longitude", 159, "$longitude");
        ImageCaptions = new C6028l("ImageCaptions", 160, "$image_captions");
        Condition = new C6028l("Condition", AdMostAdListener.FAILED, "$condition");
        CreationTimestamp = new C6028l("CreationTimestamp", AdMostAdListener.COMPLETED, "$creation_timestamp");
        TrackingDisabled = new C6028l("TrackingDisabled", AdMostAdListener.LOADED, "tracking_disabled");
        Instant = new C6028l("Instant", AdMostAdListener.CLOSED, "instant");
    }

    private C6028l(String str) {
        this.f15589a = "";
        this.f15589a = str;
    }

    /* renamed from: a */
    public String mo33920a() {
        return this.f15589a;
    }

    public String toString() {
        return this.f15589a;
    }
}
