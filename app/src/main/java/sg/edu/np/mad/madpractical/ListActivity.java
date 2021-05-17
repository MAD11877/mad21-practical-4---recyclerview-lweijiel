package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private final static String TAG = "List Activity";
    private ImageView imageView;
    static ArrayList<User> arrayList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        for (int i = 0; i<20;i++){
            User user = new User("Name" + randomNumber(), String.valueOf(randomNumber()), i, IsFollowed());
            arrayList.add(user);
        }

        setContentView(R.layout.activity_list);
        Log.v(TAG, "List Activity Created");

        RecyclerView recyclerView = findViewById(R.id.rv);
        ListAdapter sAdapter = new ListAdapter(arrayList);
        LinearLayoutManager mLayoutMaganer = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutMaganer);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sAdapter);

//        imageView = findViewById(R.id.imageView);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imageClick();
//            }
//        });
    }

    private boolean IsFollowed()
    {
        Random random = new Random(2);
        if (random.nextInt() == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private int randomNumber()
    {
        Random ran = new Random();
        int ranVal = ran.nextInt();
        return ranVal;
    }

    private void imageClick(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                int num = randomNumber();
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                intent.putExtra("Random", num);
                Log.v(TAG, "Passing Random Number to Main Activity");

                startActivity((intent));
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){ finish();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}