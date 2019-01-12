package harsh.android.hellofirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference databaseReference;

    private EditText editName,editReg;
    private Button buttonSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        editName=(EditText) findViewById(R.id.EditName);
        editReg=(EditText) findViewById(R.id.EditReg);

        buttonSave=(Button) findViewById(R.id.SaveButton);
        buttonSave.setOnClickListener(this);
    }

    private void saveUserData(){
        String name=editName.getText().toString().trim();
        String regno=editReg.getText().toString().trim();

        String id= databaseReference.push().getKey();

        UserData userData=new UserData(id,name,regno);
        databaseReference.child("Users").child(id).setValue(userData);
        Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show();;
    }
    @Override
    public void onClick(View view) {

        if(view==buttonSave ){
            saveUserData();
        }
    }
}
