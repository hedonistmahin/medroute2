package ICUadapter;

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

import ICUmodel.ICUmodel;

public class ICUadapter extends RecyclerView.Adapter <ICUadapter.viewHolder> {

    ArrayList<ICUmodel> list;
    Context context;
    Dialog icuDialog;

    public ICUadapter(ArrayList<ICUmodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.icu_sample1,parent,false);

        viewHolder vHolder=new viewHolder(view);


        icuDialog =new Dialog(context);
        icuDialog.setContentView(R.layout.dialog1);

        vHolder.hospitalItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatButton icuDialogCancel =icuDialog.findViewById(R.id.cancel);
                AppCompatButton icuDialogok =icuDialog.findViewById(R.id.ok);


                icuDialog.show();
                icuDialogok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"Selected",Toast.LENGTH_LONG).show();
                        icuDialog.dismiss();
                    }
                });
                icuDialogCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"Not selected",Toast.LENGTH_LONG).show();
                        icuDialog.dismiss();
                    }
                });
            }
        });


        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ICUmodel model =list.get(position);
        holder.imageView.setImageResource(model.getHospital_img_icu());
        holder.textView.setText(model.getHospital_name_icu());

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
            hospitalItem=itemView.findViewById(R.id.icuSample);
            imageView=itemView.findViewById(R.id.hospital_pic_icu);
            textView=itemView.findViewById(R.id.hospital_name_icu);

        }
    }
}