package com.example.assignment9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ContentActivity extends AppCompatActivity {

    private RoomViewModel roomViewModel;

    ListView lwList;
    Button btnReturn;
    RoomLogDB Db;
    LogRepository LogR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);

        LogR = new LogRepository(getApplication());
        // en tiedä, mitä tämä pyytää applicaatiolla
        // jos ei tee uutta, niin se väittää että LogR on null, ja sitten kaataa ohjelman


        //roomViewModel = ViewModelProviders.of(this).get(RoomViewModel.class);
        // live viewi puuttuu, ehkä huono asia? do something maybe

        lwList = (ListView) findViewById(R.id.listLW);

        btnReturn = (Button) findViewById(R.id.CreturnBTN);


        // adapteri jotenkin toimimaan?
        List<RoomEntity> lista;
        // jostain syystä se ei saa niitä kaikkia
        lista = LogR.getAllLogs();

        // Tämän tietenkin saisi vielä siten että hakisi tietyn henkilön tiedot... pitäisi query vain tehdä. Mutta kun ei saa vielä edes tähän asti tehtyä

        //RoomEntity roomEntity = new RoomEntity("Username","Password","Now");
        //lista.add(roomEntity);

        // muuten se laittaisi kaikki hyvin tänne :(
        OmaAdapteri adapteri = new OmaAdapteri(getApplicationContext(), R.layout.adapter_layout, lista);
        lwList.setAdapter(adapteri);

        adapteri.notifyDataSetChanged();





        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
