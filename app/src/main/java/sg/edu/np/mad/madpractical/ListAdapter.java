package sg.edu.np.mad.madpractical;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {
    ArrayList<User> data;

    public ListAdapter(ArrayList<User> input){ //Gather data from outside
        data = input;
    }

    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //Creates a new View Holder Object
        View item; //Decides the layout that is to be put inside the view holder
        if (viewType == 1)
        {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview2, parent, false);
        }
        else {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview, parent, false);
        }
        return new ListViewHolder(item);
    }

    public void onBindViewHolder(ListViewHolder holder, int position){
        User info = data.get(position);
        holder.txt.setText(info.name + "\n" + info.description);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.img.getContext());
                builder.setTitle("Profile");
                builder.setMessage(info.name);
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent intent = new Intent(holder.img.getContext(), MainActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putInt("key", position);
                        intent.putExtras(bundle);
                        holder.img.getContext().startActivity(intent);
                    }
                });
                builder.setNegativeButton("Close", null);
                AlertDialog alert = builder.create();
                alert.show();
            }

        });

    }

    @Override
    public int getItemViewType(int position){
        User info = data.get(position);
        if (info.getName().charAt(info.getName().length()-1 ) == '7')
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public int getItemCount(){
        return data.size();
    }
}
