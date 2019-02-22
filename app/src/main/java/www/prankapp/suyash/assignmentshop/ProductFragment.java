package www.prankapp.suyash.assignmentshop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductFragment extends Fragment {
    public String shopnumber;
    public String url;
    public ProductFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            shopnumber = getArguments().getString("productid");
            url = "https://www.egcashback.in/manage/api/cp_list/detail/?X-Api-Key=B1271BD939B74CA8D5C9A183C53BACDD&cp_id="+shopnumber;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        final ImageView fragmentImageview = view.findViewById(R.id.imageviewfragment);
        final TextView textView1 = view.findViewById(R.id.firsttext);
        final TextView textView2 = view.findViewById(R.id.secondtext);
        final TextView textView3 = view.findViewById(R.id.thirdtext);
        final TextView textView4 = view.findViewById(R.id.fourthtext);
        final TextView textView5 = view.findViewById(R.id.fifthtext);
        final TextView textView6 = view.findViewById(R.id.sixthtext);
        final TextView textView7 = view.findViewById(R.id.seventhtext);
        final TextView textView8 = view.findViewById(R.id.eighthtext);
        final TextView textView9 = view.findViewById(R.id.ninethtext);
        final TextView textView10 = view.findViewById(R.id.tenthtext);

        Picasso.get().load(R.drawable.image).into(fragmentImageview);

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject jsonObject = response.getJSONObject("data");
                    JSONObject jsonObject1 = jsonObject.getJSONObject("cp_list");

                    textView1.setText(" Shop name - "+ jsonObject1.getString("shop_name"));
                    textView2.setText(" Description - "+ jsonObject1.getString("description"));
                    textView3.setText(" Address - "+ jsonObject1.getString("address"));
                    textView4.setText(" Contact Persion - "+ jsonObject1.getString("contact_person"));
                    textView5.setText(" Permanent Address - "+ jsonObject1.getString("permanent_address"));
                    textView6.setText(" Phone Number - "+ jsonObject1.getString("phone_no"));
                    textView7.setText(" Mobile Number - "+ jsonObject1.getString("mobile_no"));
                    textView8.setText(" Email id - "+ jsonObject1.getString("email_id"));
                    textView9.setText(" Total Views - "+ jsonObject1.getString("total_views"));
                    textView10.setText(" Locality - "+ jsonObject1.getString("locality"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);

        return view;
    }


}
