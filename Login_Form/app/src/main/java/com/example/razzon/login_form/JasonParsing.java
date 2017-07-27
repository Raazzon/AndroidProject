package com.example.razzon.login_form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JasonParsing extends AppCompatActivity {

    AQuery aquery;
    String url="http://10.0.2.2/login/select.php";
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jason_parsing);

        listView= (ListView) findViewById(R.id.listview);

        aquery=new AQuery(this);
        fetchdata();
    }
    public void fetchdata(){
        aquery.ajax(url, JSONArray.class,new AjaxCallback<JSONArray>(){
            @Override
            public void callback(String url, JSONArray array, AjaxStatus status) {
                super.callback(url, array, status);
                Log.i("response:", "response:" + array);

                ArrayList<UserDetails>list=new ArrayList<UserDetails>();
                for (int i=0;i<array.length();i++){
                    try {
                        JSONObject object=array.getJSONObject(i);
                        UserDetails Details=new UserDetails();

                        Details.id=object.getString("Id");
                        Details.firstname=object.getString("Fname");
                        Details.lastname=object.getString("Lname");
                        Details.address=object.getString("Address");
                        Details.phonenumber=object.getString("PNum");
                        Details.email=object.getString("Email");
                        Details.age=object.getString("Age");
                        Details.bloodgroup=object.getString("Bloodgroup");
                        Details.gender=object.getString("Gender");
                        Details.password=object.getString("Password");
                        Details.imageUrl=object.getString("Image");

                        list.add(Details);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listView.setAdapter(new UserListAdapter(JasonParsing.this,list));
            }
        });
    }
}
