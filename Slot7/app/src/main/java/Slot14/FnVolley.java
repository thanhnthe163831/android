package Slot14;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FnVolley {

    // Method to get string by Volley
    public void getStringByVolley(Context context, TextView textView) {
        // 1. Create request queue
        RequestQueue queue = Volley.newRequestQueue(context);
        // 2. URL
        String url = "https://www.google.com/";

        // 3. Create StringRequest
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 1000 characters of the response string
                        textView.setText("KQ: " + response.substring(0, 1000));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });

        // 4. Execute the request
        queue.add(stringRequest);
    }

    // Method to get array of objects
    public void getArrayOfObjects(Context context, TextView textView) {
        // URL
        String url = "https://hungnttg.github.io/array_json_new.json";

        // 1. Create request queue
        RequestQueue queue = Volley.newRequestQueue(context);

        // 2. Create JsonArrayRequest
        JsonArrayRequest request = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        String strJSON = "";
                        // Loop through the array
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject person = response.getJSONObject(i);
                                // Read each field
                                String id = person.getString("id");
                                String name = person.getString("name");
                                String email = person.getString("email");
                                JSONObject phone = person.getJSONObject("phone");
                                String mobile = phone.getString("mobile");
                                String home = phone.getString("home");

                                // Convert to string
                                strJSON += "ID: " + id + "\n";
                                strJSON += "Name: " + name + "\n";
                                strJSON += "Email: " + email + "\n";
                                strJSON += "Mobile: " + mobile + "\n";
                                strJSON += "Home: " + home + "\n";
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        // Display data on TextView
                        textView.setText(strJSON);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });

        // 3. Execute the request
        queue.add(request);
    }
    //insert
    public void insertVolley(Context context, TextView tvResult, TextView tvName, TextView tvPrice, TextView tvDes){
        //1. Tao request
        RequestQueue queue = Volley.newRequestQueue(context);
        //2.Url
        String url="http://192.168.0.105/202406/create_product.php/";
        //3. truyen tham so
        //StringRequest(phuongthuc,url,thanhcong,thatbai)
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        tvResult.setText(s.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                tvResult.setText(volleyError.getMessage());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> myData=new HashMap<>();
                myData.put("name",tvName.getText().toString());
                myData.put("price",tvPrice.getText().toString());
                myData.put("description",tvDes.getText().toString());
                return myData;
            }
        };
        //4. Xu ly request
        queue.add(stringRequest);
    }
    public void updateVolley(Context context, TextView tvResult, EditText tvPid, EditText tvName, EditText tvPrice, EditText tvDes){
        //1. Tao request
        RequestQueue queue = Volley.newRequestQueue(context);
        //2.Url
        String url="http://192.168.0.105/202406/update_product.php/";
        //3. truyen tham so
        //StringRequest(phuongthuc,url,thanhcong,thatbai)
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        tvResult.setText(s.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                tvResult.setText(volleyError.getMessage());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> myData=new HashMap<>();
                myData.put("pid", tvPid.getText().toString());
                myData.put("name",tvName.getText().toString());
                myData.put("price",tvPrice.getText().toString());
                myData.put("description",tvDes.getText().toString());
                return myData;
            }
        };
        //4. Xu ly request
        queue.add(stringRequest);
    }
    public void deleteVolley(Context context, TextView tvResult, EditText tvPid){
        //1. Tao request
        RequestQueue queue = Volley.newRequestQueue(context);
        //2.Url
        String url="http://192.168.0.105/202406/delete_product.php/";
        //3. truyen tham so
        //StringRequest(phuongthuc,url,thanhcong,thatbai)
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        tvResult.setText(s.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                tvResult.setText(volleyError.getMessage());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> myData=new HashMap<>();
                myData.put("pid", tvPid.getText().toString());
                return myData;
            }
        };
        //4. Xu ly request
        queue.add(stringRequest);
    }
}
