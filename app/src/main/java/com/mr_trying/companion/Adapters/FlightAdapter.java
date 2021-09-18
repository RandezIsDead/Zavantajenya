package com.mr_trying.companion.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mr_trying.companion.Models.Flight;
import com.mr_trying.companion.R;

import java.util.List;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.ViewHolder> {

    private final Context context;
    private final List<Flight> flightList;

    public FlightAdapter(Context context, List<Flight> flightList) {
        this.context = context;
        this.flightList = flightList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.flight_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Flight flight = flightList.get(position);

        holder.flightNum.setText(flight.getFlightNum());
        holder.fromStation.setText(flight.getFromStation());
        holder.toStation.setText(flight.getToStation());
        holder.sendingDate.setText(flight.getSendingDate());
        holder.arrivalDate.setText(flight.getArrivalDate());
    }

    @Override
    public int getItemCount() {
        return flightList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView flightNum;
        public TextView fromStation;
        public TextView toStation;
        public TextView sendingDate;
        public TextView arrivalDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            flightNum = itemView.findViewById(R.id.flight_number);
            fromStation = itemView.findViewById(R.id.from_station);
            toStation = itemView.findViewById(R.id.to_station);
            sendingDate = itemView.findViewById(R.id.sending_time);
            arrivalDate = itemView.findViewById(R.id.arrival_time);
        }
    }
}
