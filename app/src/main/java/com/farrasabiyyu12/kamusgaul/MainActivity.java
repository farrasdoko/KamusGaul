package com.farrasabiyyu12.kamusgaul;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.farrasabiyyu12.kamusgaul.model.EntriesItem;
import com.farrasabiyyu12.kamusgaul.model.ResponseGaul;
import com.farrasabiyyu12.kamusgaul.rest.ApiClient;
import com.farrasabiyyu12.kamusgaul.rest.Apinterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

//    RecyclerView rc_bahasa;
    ListView lv_bahasa;
//    CustomAdapter adapter;
    KamusAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_bahasa = (ListView) findViewById(R.id.lv_bahasa);
//        rc_bahasa = findViewById(R.id.rc_bahasa);
        getData();
    }

    private void getData() {
        Apinterface apinterface = ApiClient.getInstance();
        Call<ResponseGaul> petugasCall = apinterface.getBahasa();
        petugasCall.enqueue(new Callback<ResponseGaul>() {
            @Override
            public void onResponse(Call<ResponseGaul> call, Response<ResponseGaul> response) {
                String status = "success";
                if (status.equals("success")) {
                    List<EntriesItem> entriesItemList = response.body().getEntries();
                    Log.d("Retrofit Get", "Jumlah Entri " + String.valueOf(entriesItemList.size()));
                    adapter = new KamusAdapter(entriesItemList, MainActivity.this);
                    lv_bahasa.setAdapter(adapter);
//                    adapter = new CustomAdapter(MainActivity.this, entriesItemList);
//                    rc_bahasa.setAdapter(adapter);
//                    rc_bahasa.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                }
            }

            @Override
            public void onFailure(Call<ResponseGaul> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    public class CustomAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private Context context;
        private List<EntriesItem> entriesItemList;

        CustomAdapter(Context context, List<EntriesItem> entriesItemList) {
            this.context = context;
            this.entriesItemList = entriesItemList;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rc_bahasa_layout, viewGroup, false);
            return new MyViewHolder(mView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            myViewHolder.word.setText(entriesItemList.get(i).getWord());
            myViewHolder.definition.setText(entriesItemList.get(i).getDefinition());
            if (i % 2 == 1) {
                myViewHolder.view.setBackgroundColor(Color.WHITE);
            } else if (i % 2 == 0) {
                myViewHolder.view.setBackgroundColor(Color.rgb(235, 240, 246));
            }
//            myViewHolder.author.setText(entriesItemList.get(i).getAuthorName());
        }

        @Override
        public int getItemCount() {
            return entriesItemList.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        View view;
        private TextView word, definition, author;

        MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            word = itemView.findViewById(R.id.word);
            definition = itemView.findViewById(R.id.definition);
//            author = itemView.findViewById(R.id.author);
        }
    }
}
