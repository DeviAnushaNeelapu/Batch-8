package com.muneiah.studentslogwithroomdb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdaper extends RecyclerView.Adapter<StudentAdaper.StudentViewHolder> {
   Context ctx;
   List<Students_entity> list;

    public StudentAdaper(Context ctx, List<Students_entity> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ctx).inflate(R.layout.every_row_design,parent,false);
        return new StudentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.n.setText(list.get(position).getName());
        holder.r.setText(list.get(position).getRollNumber());
        holder.d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // MainActivity.dataBase.studentDAO().delete(list.get(position));
                MainActivity.viewModel.delete(list.get(position));
                Toast.makeText(ctx, "Deleted :"+holder.n.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView e,n,r,d;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            e=itemView.findViewById(R.id.tv_edit);
            n=itemView.findViewById(R.id.tv_name);
            r=itemView.findViewById(R.id.tv_rollnumber);
            d=itemView.findViewById(R.id.tv_delete);
            e.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nam=n.getText().toString();
                    String rol=r.getText().toString();
                    Intent i=new Intent(ctx,UpdateActivity.class);
                    i.putExtra("key_name",nam);
                    i.putExtra("key_roll",rol);
                    ctx.startActivity(i);
                }
            });
        }
    }
}
