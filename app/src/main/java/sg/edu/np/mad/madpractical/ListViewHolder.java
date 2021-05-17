package sg.edu.np.mad.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {
    ImageView img; //Declaring items in ViewHolder
    TextView txt; //Declaring items in ViewHolder

    public ListViewHolder(View itemView){
        super(itemView);
        txt = itemView.findViewById(R.id.textView); //location
        img = itemView.findViewById(R.id.img_profile); //location
    }
}
