package com.example.library;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.library.dataaccess.Book;
import com.example.library.dataaccess.DAFactory;
import com.example.library.dataaccess.IBookDA;
import java.util.List;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Spinner spnCats;
    private Button btnShow;
    private ListView lstResult;
    private TextView txtSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupViews();
        bindSpinner();
    }

    private void bindSpinner() {
        DAFactory factory = new DAFactory();
        IBookDA data = factory.getInstance();


        String[] cats = data.getCats();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, cats);
        spnCats.setAdapter(adapter);
    }

    private void setupViews() {
        spnCats = findViewById(R.id.spnCats);
        btnShow = findViewById(R.id.btnShow);
        lstResult = findViewById(R.id.lstResult);
        txtSelected =findViewById(R.id.txtSelected);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DAFactory factory = new DAFactory();
                IBookDA data = factory.getInstance();
                String r = spnCats.getSelectedItem().toString();
                List<Book> result = data.getBooks(r);

                ArrayAdapter<Book> adapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1, result);

                lstResult.setAdapter(adapter);


            }
        });


    }
}