package com.adcolony.sdk;

import android.location.Location;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
public class AdColonyUserMetadata {
    public static final String USER_EDUCATION_ASSOCIATES_DEGREE = "associates_degree";
    public static final String USER_EDUCATION_BACHELORS_DEGREE = "bachelors_degree";
    public static final String USER_EDUCATION_GRADE_SCHOOL = "grade_school";
    public static final String USER_EDUCATION_GRADUATE_DEGREE = "graduate_degree";
    public static final String USER_EDUCATION_HIGH_SCHOOL_DIPLOMA = "high_school_diploma";
    public static final String USER_EDUCATION_SOME_COLLEGE = "some_college";
    public static final String USER_EDUCATION_SOME_HIGH_SCHOOL = "some_high_school";
    public static final String USER_FEMALE = "female";
    public static final String USER_MALE = "male";
    public static final String USER_MARRIED = "married";
    public static final String USER_SINGLE = "single";

    /* renamed from: d */
    static final int f3317d = 128;

    /* renamed from: a */
    JSONArray f3318a = C1437s.m5579a();

    /* renamed from: b */
    JSONObject f3319b = C1437s.m5599b();

    /* renamed from: c */
    Location f3320c;

    public AdColonyUserMetadata addUserInterest(String str) {
        if (C1359k0.m5333g(str)) {
            C1437s.m5601b(this.f3318a, str);
            C1437s.m5593a(this.f3319b, "adc_interests", this.f3318a);
        }
        return this;
    }

    public AdColonyUserMetadata clearUserInterests() {
        JSONArray a = C1437s.m5579a();
        this.f3318a = a;
        C1437s.m5593a(this.f3319b, "adc_interests", a);
        return this;
    }

    public Object getMetadata(String str) {
        return C1437s.m5598b(this.f3319b, str);
    }

    public int getUserAge() {
        return C1437s.m5611f(this.f3319b, "adc_age");
    }

    public int getUserAnnualHouseholdIncome() {
        return C1437s.m5611f(this.f3319b, "adc_household_income");
    }

    public String getUserEducation() {
        return C1437s.m5613h(this.f3319b, "adc_education");
    }

    public String getUserGender() {
        return C1437s.m5613h(this.f3319b, "adc_gender");
    }

    public String[] getUserInterests() {
        String[] strArr = new String[this.f3318a.length()];
        for (int i = 0; i < this.f3318a.length(); i++) {
            strArr[i] = C1437s.m5607d(this.f3318a, i);
        }
        return strArr;
    }

    public Location getUserLocation() {
        return this.f3320c;
    }

    public String getUserMaritalStatus() {
        return C1437s.m5613h(this.f3319b, "adc_marital_status");
    }

    public String getUserZipCode() {
        return C1437s.m5613h(this.f3319b, "adc_zip");
    }

    public AdColonyUserMetadata setMetadata(String str, boolean z) {
        if (C1359k0.m5333g(str)) {
            C1437s.m5603b(this.f3319b, str, z);
        }
        return this;
    }

    public AdColonyUserMetadata setUserAge(int i) {
        setMetadata("adc_age", (double) i);
        return this;
    }

    public AdColonyUserMetadata setUserAnnualHouseholdIncome(int i) {
        setMetadata("adc_household_income", (double) i);
        return this;
    }

    public AdColonyUserMetadata setUserEducation(String str) {
        if (C1359k0.m5333g(str)) {
            setMetadata("adc_education", str);
        }
        return this;
    }

    public AdColonyUserMetadata setUserGender(String str) {
        if (C1359k0.m5333g(str)) {
            setMetadata("adc_gender", str);
        }
        return this;
    }

    public AdColonyUserMetadata setUserLocation(Location location) {
        this.f3320c = location;
        setMetadata("adc_longitude", location.getLongitude());
        setMetadata("adc_latitude", location.getLatitude());
        setMetadata("adc_speed", (double) location.getSpeed());
        setMetadata("adc_altitude", location.getAltitude());
        setMetadata("adc_time", (double) location.getTime());
        setMetadata("adc_accuracy", (double) location.getAccuracy());
        return this;
    }

    public AdColonyUserMetadata setUserMaritalStatus(String str) {
        if (C1359k0.m5333g(str)) {
            setMetadata("adc_marital_status", str);
        }
        return this;
    }

    public AdColonyUserMetadata setUserZipCode(String str) {
        if (C1359k0.m5333g(str)) {
            setMetadata("adc_zip", str);
        }
        return this;
    }

    public AdColonyUserMetadata setMetadata(String str, double d) {
        if (C1359k0.m5333g(str)) {
            C1437s.m5590a(this.f3319b, str, d);
        }
        return this;
    }

    public AdColonyUserMetadata setMetadata(String str, String str2) {
        if (C1359k0.m5333g(str2) && C1359k0.m5333g(str)) {
            C1437s.m5592a(this.f3319b, str, str2);
        }
        return this;
    }
}
