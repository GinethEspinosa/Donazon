package net.smallacademy.authenticatorapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Catalog extends AppCompatActivity {

    RecyclerView itemRecycler;
    AdapterItems adapterItems;

    List<Item> itemsList = new ArrayList<>();
    List<Item> shopCart = new ArrayList<>();
    private static final String TAG = "Catalog";

    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        db = FirebaseFirestore.getInstance();

        List<Item> itemsList = new ArrayList<Item>();

        //aquí deberíamos ingresar el código para ingreso automático
        DocumentReference docRef = db.collection("CATEGORIES").document("APPLIANCES");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {

                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Map<String, Object> map = document.getData();

                        Item item = new Item(((Long)map.get("index")).intValue(), (String)map.get("categoryName"),"", (String)map.get("categoryName"), (String)map.get("icon") );
                        adapterItems.addData(item);



                        //for (Map.Entry<String, Object> entry : map.entrySet()) {
                         //   adapterItems.addData((Item) entry.getValue());
                        //}
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.e(TAG, "get failed with ", task.getException());
                }
            }
        });

      //  itemsList.add(new Item(1, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.prod2));
        DocumentReference docRef = db.collection("CATEGORIES").document("APPLIANCES");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {

                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Map<String, Object> map = document.getData();

                        Item item = new Item(((Long)map.get("index")).intValue(), (String)map.get("categoryName"),"", (String)map.get("categoryName"), (String)map.get("icon") );
                        adapterItems.addData(item);



                        //for (Map.Entry<String, Object> entry : map.entrySet()) {
                        //   adapterItems.addData((Item) entry.getValue());
                        //}
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.e(TAG, "get failed with ", task.getException());
                }
            }
        });
        docRef = db.collection("CATEGORIES").document("BOOKS");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {

                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Map<String, Object> map = document.getData();

                        Item item = new Item(((Long)map.get("index")).intValue(), (String)map.get("categoryName"),"", (String)map.get("categoryName"), (String)map.get("icon") );
                        adapterItems.addData(item);



                        //for (Map.Entry<String, Object> entry : map.entrySet()) {
                        //   adapterItems.addData((Item) entry.getValue());
                        //}
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.e(TAG, "get failed with ", task.getException());
                }
            }
        });
        DocumentReference docRef = db.collection("CATEGORIES").document("APPLIANCES");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {

                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Map<String, Object> map = document.getData();

                        Item item = new Item(((Long)map.get("index")).intValue(), (String)map.get("categoryName"),"", (String)map.get("categoryName"), (String)map.get("icon") );
                        adapterItems.addData(item);



                        //for (Map.Entry<String, Object> entry : map.entrySet()) {
                        //   adapterItems.addData((Item) entry.getValue());
                        //}
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.e(TAG, "get failed with ", task.getException());
                }
            }
        });

        setitemRecycler(itemsList);

    }


    private void setitemRecycler(List<Item> itemsList) {

        itemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        itemRecycler.setLayoutManager(layoutManager);
        adapterItems = new AdapterItems(this, itemsList);
        itemRecycler.setAdapter(adapterItems);

    }
}