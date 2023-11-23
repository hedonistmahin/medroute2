package AmbulanceAdapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;



import com.example.medroute2.R;

import java.util.ArrayList;

import AmbulanceModel.AmbulanceModel;


public class AmbulanceAdapter extends RecyclerView.Adapter <AmbulanceAdapter.viewHolder> {

    ArrayList<AmbulanceModel> list;
    Context context;


    public AmbulanceAdapter(ArrayList<AmbulanceModel> list, Context context) {
        this.list=list;
        this.context = context;
    }


    @NonNull
    @Override
    public AmbulanceAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.ambulance_sample,parent,false);

        viewHolder vHolder=new viewHolder(view);






        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        AmbulanceModel model =list.get(position);
        holder.textView2.setText(model.getAmbulance_name());
        holder.textView1.setText(model.getAmbulance_contact());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class  viewHolder extends RecyclerView.ViewHolder {

        TextView textView2, textView1;

        public viewHolder(@NonNull View itemView) {
            super(itemView);


            textView2=itemView.findViewById(R.id.ambulanceName);
            textView1=itemView.findViewById(R.id.ambulance_contact);

        }
    }
}