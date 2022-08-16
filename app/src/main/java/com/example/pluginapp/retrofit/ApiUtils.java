package com.example.pluginapp.retrofit;

public class ApiUtils {

    public static final String BASE_URL="https://v1.nocodeapi.com/sahaypratik/supabase/";

    public static UserService getUserService()
    {
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);

    }
}
