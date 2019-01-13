package harsh.android.hellofirebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference databaseReference;

    private EditText editName;
    private Button buttonSave,buttonShow;
    private TextView userview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        editName = (EditText) findViewById(R.id.EditName);


        buttonSave = (Button) findViewById(R.id.SaveButton);
        buttonShow=(Button) findViewById(R.id.ShowButton);
        userview=(TextView) findViewById(R.id.ShowText);


        buttonSave.setOnClickListener(this);
        buttonShow.setOnClickListener(this);
    }

    private void saveUserData() {
        String name = editName.getText().toString().trim();

        String id = databaseReference.push().getKey();

        databaseReference.setValue(name);
        Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {

        if (view == buttonSave) {
            saveUserData();
        }

        if (view == buttonShow){


            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String userData= dataSnapshot.getValue(String.class);
                        userview.setText(userData);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
