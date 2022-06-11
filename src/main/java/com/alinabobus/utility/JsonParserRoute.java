package com.alinabobus.utility;

import com.alinabobus.data.Route;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.TreeSet;

public class JsonParserRoute {

    public String serialize(TreeSet<Route> collectionData) {
        Gson gson = new GsonBuilder().registerTypeAdapter(java.time.LocalDate.class, new DateSerializer())
                .setLenient()
                .create();
        return gson.toJson(collectionData);
    }

    public TreeSet<Route> deSerialize(String strData) throws JsonSyntaxException, IllegalArgumentException {
        Gson gson = new GsonBuilder().registerTypeAdapter(java.time.LocalDate.class, new DateDeserializer())
                .setLenient()
                .create();
        Type type = new TypeToken<TreeSet<Route>>() {
        }.getType();
        if ("".equals(strData)) {
            return new TreeSet<>();
        }

        return  gson.fromJson(strData, type);
    }
}