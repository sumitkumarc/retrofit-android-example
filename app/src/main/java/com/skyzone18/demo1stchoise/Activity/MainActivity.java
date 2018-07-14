package com.skyzone18.demo1stchoise.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.skyzone18.demo1stchoise.Adapter.OfferCatWiseProadapter;
import com.skyzone18.demo1stchoise.Model.Datum;
import com.skyzone18.demo1stchoise.R;
import com.skyzone18.demo1stchoise.RestClient.ApiClient;
import com.skyzone18.demo1stchoise.RestClient.ApiInterface;
import com.skyzone18.demo1stchoise.RestClient.Responce;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiService;
    RecyclerView recyclerView;
    ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiService = ApiClient.getClient().create(ApiInterface.class);
        bindview();
    }

    private void bindview() {
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager mLayoutManager;
        mLayoutManager = new LinearLayoutManager(this   );
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        catwisepro();
    }

    private void catwisepro() {
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
        Call<Responce> call = apiService.GetOffersubcategory();
        call.enqueue(new Callback<Responce>() {
            @Override
            public void onResponse(Call<Responce> call, retrofit2.Response<Responce> response) {
                List<Datum> items = response.body().getData();
                Log.d("", "Numbe " + items.size());
                if (response.body().getData().size() == 0) {
                    pDialog.dismiss();
                    recyclerView.setVisibility(View.GONE);
                  //  ivnotfound.setVisibility(View.VISIBLE);
                } else {
                    pDialog.dismiss();
                  //  ivnotfound.setVisibility(View.GONE);

                    OfferCatWiseProadapter offerCatWiseProadapter = new OfferCatWiseProadapter(MainActivity.this,items);
                        //offerCatWiseProadapter.RegisterofferClickShareClick(this);
                    // set the adapter object to the Recyclerview
                    recyclerView.setAdapter(offerCatWiseProadapter);
                    // offerCatWiseProadapter.RegisterofferClickShareClick(OfferFragment.this);
                }

            }

            @Override
            public void onFailure(Call<Responce> call, Throwable t) {
                // Log error here since request failed
                Log.e(">>>>>>", t.toString());
                //  imageView.setVisibility(View.GONE);
                pDialog.dismiss();
                Toast.makeText(MainActivity.this, "Try..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
