package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";
    private TextView textView;
    private TextView textView2;
    private Button button;

    //User user1 = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Create");

        Intent receivedData = getIntent();
        int num = receivedData.getIntExtra("key",0);
        User user = ListActivity.arrayList.get(num);
        TextView textView = findViewById(R.id.txtName);
        TextView textView2 = findViewById(R.id.txtDescription);
        Button button = findViewById(R.id.btnFollow);

        if (user.isFollowed() == true)
        {
            button.setText("Un-follow");
        }
        else
        {
            button.setText("Follow");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.isFollowed() == true)
                {
                    user.setFollowed(false);
                    button.setText("Follow");
                    Toast.makeText(getApplicationContext(),"Un-followed", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    user.setFollowed(true);
                    button.setText("Unfollow");
                    Toast.makeText(getApplicationContext(),"Followed", Toast.LENGTH_SHORT).show();
                }
            }
        });


//        Intent receivedData = getIntent();
//        int num = receivedData.getIntExtra("Random",0);
//        TextView textView = findViewById(R.id.txtName);
//        textView.setText("MAD " + num);
//
//        Button button = findViewById(R.id.btnFollow);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (user1.isFollowed() == false)
//                {
//                    button.setText("Unfollow");
//                    user1.setFollowed(true);
//                    Toast.makeText(getApplicationContext(),"Followed", Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    button.setText("Follow");
//                    user1.setFollowed(false);
//                    Toast.makeText(getApplicationContext(),"Follow", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG,"Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "Destroy");
    }


}