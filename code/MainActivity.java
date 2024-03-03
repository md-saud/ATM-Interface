import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private BankAccount account;
    private ATM atm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize account and ATM
        account = new BankAccount(1000);
        int userPin = 1234; // Default PIN
        atm = new ATM(account, userPin);

        // Set up UI components
        EditText pinEditText = findViewById(R.id.pinEditText);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pinStr = pinEditText.getText().toString();
                if (!pinStr.isEmpty()) {
                    int inputPin = Integer.parseInt(pinStr);
                    if (atm.verifyPin(inputPin)) {
                        // Display main menu activity
                        // Replace with your implementation
                        Toast.makeText(MainActivity.this, "Logged in successfully!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid PIN", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter your PIN", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
