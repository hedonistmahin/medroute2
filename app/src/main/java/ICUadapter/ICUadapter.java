package ICUadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.example.medroute2.R;

import java.util.ArrayList;

import ICUmodel.ICUmodel;

public class ICUadapter extends RecyclerView.Adapter <ICUadapter.viewHolder> {

    ArrayList<ICUmodel> list;
    Context context;

    public ICUadapter(ArrayList<ICUmodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.icu_sample1,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ICUmodel model =list.get(position);
        holder.imageView.setImageResource(model.getHospital_img_icu());
        holder.textView.setText(model.getHospital_name_icu());
        holder.imageViewTic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"selected",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class  viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView,imageViewTic;
        TextView textView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.hospital_pic_icu);
            textView=itemView.findViewById(R.id.hospital_name_icu);
            imageViewTic=itemView.findViewById(R.id.tic);
        }
    }
}