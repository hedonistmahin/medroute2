package BedAdapter;



import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;



import com.example.medroute2.R;

import java.util.ArrayList;

import BedModel.BedModel;
import ICUmodel.ICUmodel;

public class BedAdapter extends RecyclerView.Adapter <BedAdapter.viewHolder> {

    ArrayList<BedModel> list;
    Context context;
    Dialog bedDialog;

    public BedAdapter(ArrayList<BedModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.bed_sample,parent,false);

        viewHolder vHolder=new viewHolder(view);


        bedDialog =new Dialog(context);
        bedDialog.setContentView(R.layout.dialog1);

        vHolder.hospitalItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatButton bedDialogCancel =bedDialog.findViewById(R.id.cancel);
                AppCompatButton bedDialogok =bedDialog.findViewById(R.id.ok);


                bedDialog.show();
                bedDialogok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"Selected",Toast.LENGTH_LONG).show();
                        bedDialog.dismiss();
                    }
                });
                bedDialogCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"Not selected",Toast.LENGTH_LONG).show();
                        bedDialog.dismiss();
                    }
                });
            }
        });


        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        BedModel model =list.get(position);
        holder.imageView.setImageResource(model.getHospital_img_bed());
        holder.textView.setText(model.getHospital_name_bed());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class  viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView,imageViewTic;
        TextView textView;
        LinearLayout hospitalItem;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            hospitalItem=itemView.findViewById(R.id.bedSample);
            imageView=itemView.findViewById(R.id.hospital_pic_bed);
            textView=itemView.findViewById(R.id.hospital_name_bed);

        }
    }
}