package com.example.quizeme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private ArrayList<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        recyclerView = findViewById(R.id.bookRecyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns

        bookList = new ArrayList<>();

        // Add books manually for now (you can later fetch from Firebase or other source)
        bookList.add(new Book("DBMS Book", R.drawable.dbms_cover, "Database_Management_System[1].pdf"));
        bookList.add(new Book("Telecommunication", R.drawable.telecom_cover, "Telecommunication.pdf"));
        bookList.add(new Book("Computer Architecture", R.drawable.architecture_cover, "ComputerOrganization.pdf"));
        bookList.add(new Book("Algorithm", R.drawable.algorithm_cover, "Algorithm.pdf"));
        bookList.add(new Book("Networking", R.drawable.networking_cover, "Electronics.pdf"));
        bookList.add(new Book("Data Structure", R.drawable.datastructure_cover, "mechatronics.pdf"));
        bookList.add(new Book("EDC", R.drawable.edc_cover, "Electronics.pdf"));
        bookList.add(new Book("Big Java", R.drawable.java_cover, "Electronics.pdf"));

        adapter = new BookAdapter(this, bookList);  // Correct order: Context first, then the bookList
        recyclerView.setAdapter(adapter);

        Button logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(v -> {
            auth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });
    }
}
