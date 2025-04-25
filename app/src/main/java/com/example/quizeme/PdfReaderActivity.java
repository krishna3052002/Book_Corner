package com.example.quizeme;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;

public class PdfReaderActivity extends AppCompatActivity {

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reader); // Make sure this layout exists

        pdfView = findViewById(R.id.pdfView); // Make sure R.id.pdfView exists in layout

        String fileName = getIntent().getStringExtra("bookName");

        if (fileName != null) {
            Log.d("PdfReaderActivity", "Loading PDF: " + fileName);
            try {
                pdfView.fromAsset(fileName).load();
            } catch (Exception e) {
                Log.e("PdfReaderActivity", "Error loading PDF: " + e.getMessage());
                // Optionally, show an error message to the user
            }
        } else {
            Log.e("PdfReaderActivity", "No book name provided!");
            // Optionally, show an error message or fallback
        }
    }
}
