package com.fengzhi.basislearning.th;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonDemo {
    public static void learn() {
        String str = "{'object':{'persons':[{'id':1001,'name':'Tom','address':'北京市'},{'id':1002," +
                "'name':'Mary','address':'上海市'}]}}";
        RootObj rootObj = new RootObj();
        Persons pers = null;
        List<Person> list = null;
        try {
            JSONObject root = new JSONObject(str);
            String object = root.optString("object");

            JSONObject objJson = new JSONObject(object);
            String personsStr = objJson.optString("persons");
            Person p = null;
            pers = new Persons();
            list = new ArrayList<Person>();
            JSONArray array = new JSONArray(personsStr);
            for (int i = 0; i < array.length(); i++) {
                String personStr = array.getString(i);
                System.out.println(personStr);
                JSONObject perJson = new JSONObject(personStr);
                p = new Person();
                p.setId(perJson.optInt("id"));
                p.setName(perJson.optString("name"));
                p.setAddress(perJson.optString("address"));
                list.add(p);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        pers.setPersons(list);
        rootObj.setObject(pers);

        System.out.println(rootObj);
    }
}
