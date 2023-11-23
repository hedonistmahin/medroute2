package OpositiveAdapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;



import com.example.medroute2.R;

import java.util.ArrayList;

import ApositiveModel.ApositiveModel;
import BedModel.BedModel;
import BpositiveModel.BpositiveModel;
import ICUmodel.ICUmodel;
import OpositiveModel.OpositiveModel;

public class OpositiveAdapter extends RecyclerView.Adapter <OpositiveAdapter.viewHolder> {

    ArrayList<OpositiveModel> list;
    Context context;
    Dialog bloodDialog;

    public OpositiveAdapter(ArrayList<OpositiveModel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public OpositiveAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.blood_bank_sample,parent,false);

        viewHolder vHolder=new viewHolder(view);


        bloodDialog =new Dialog(context);
        bloodDialog.setContentView(R.layout.dialog1);

        vHolder.hospitalItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatButton bedDialogCancel =bloodDialog.findViewById(R.id.cancel);
                AppCompatButton bedDialogok =bloodDialog.findViewById(R.id.ok);


                bloodDialog.show();
                bedDialogok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"Selected",Toast.LENGTH_LONG).show();
                        bloodDialog.dismiss();
                    }
                });
                bedDialogCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"Not selected",Toast.LENGTH_LONG).show();
                        bloodDialog.dismiss();
                    }
                });
            }
        });


        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        OpositiveModel model =list.get(position);
        holder.textView.setText(model.getBloodBank_name());
        holder.textView1.setText(model.getBloodBank_location());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class  viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView, textView1;
        RelativeLayout hospitalItem1;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            hospitalItem1=itemView.findViewById(R.id.b);

            textView=itemView.findViewById(R.id.blood_name);
            textView1=itemView.findViewById(R.id.blood_location);

        }
    }
}
