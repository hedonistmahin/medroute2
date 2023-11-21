package HopitalAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import HospitalModel.Hospital;
import com.example.medroute2.R;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.ViewHolder> {

    private List<Hospital> hospitals;
    private List<Hospital> filteredHospitals;
    private OnItemClickListener onItemClickListener; // Add this line

    public interface OnItemClickListener {
        void onItemClick(Hospital hospital);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public HospitalAdapter(List<Hospital> hospitals) {
        this.hospitals = hospitals;
        this.filteredHospitals = new ArrayList<>(hospitals);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hospital_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hospital hospital = filteredHospitals.get(position);
        holder.logoImageView.setImageResource(hospital.getLogoResourceId());
        holder.nameTextView.setText(hospital.getName());

        // Set click listener
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(hospital);
            }
        });
    }


    @Override
    public int getItemCount() {
        return filteredHospitals.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView logoImageView;
        TextView nameTextView;
        TextView infoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            logoImageView = itemView.findViewById(R.id.logoImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            infoTextView = itemView.findViewById(R.id.infoTextView);
        }
    }

    public void filter(String query) {
        filteredHospitals.clear();
        if (query.isEmpty()) {
            filteredHospitals.addAll(hospitals);
        } else {
            query = query.toLowerCase();
            for (Hospital hospital : hospitals) {
                if (hospital.getName().toLowerCase().contains(query)) {
                    filteredHospitals.add(hospital);
                }
            }
        }
        notifyDataSetChanged();
    }
}
