package com.mr_trying.companion.Data;

public class DbHelper {
//
//    public static void sendData(Context context, String from, String to, String keyWord, String data) {
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_SEND_DATA,
//                System.out::println,
//                System.out::println)
//        {
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<>();
//                params.put("from", from);
//                params.put("to", to);
//                params.put("keyWord", keyWord);
//                params.put("data", data);
//
//                return params;
//            }
//        };
//
//        RequestHandler.getInstance(context).addToRequestQueue(stringRequest);
//    }
//
//    public static void deleteA_D(Context context, String param, String id) {
//        String url;
//        if (param.equals("ask")) url = Constants.URL_DELETE_ASK;
//        else url = Constants.URL_DELETE_DATA;
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                System.out::println,
//                System.out::println){
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<>();
//                params.put("id", id);
//                return params;
//            }
//        };
//
//        RequestHandler.getInstance(context).addToRequestQueue(stringRequest);
//    }
//
//    public static void updateGroupChat(Context context, GroupChat groupChat) {
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_UPDATE_GROUP_CHAT,
//                System.out::println,
//                System.out::println)
//        {
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<>();
//                params.put("id", groupChat.getChatID());
//                params.put("imageEncode", groupChat.getImgUrl());
//                params.put("name", groupChat.getName());
//
//                return params;
//            }
//        };
//
//        RequestHandler.getInstance(context).addToRequestQueue(stringRequest);
//    }
}