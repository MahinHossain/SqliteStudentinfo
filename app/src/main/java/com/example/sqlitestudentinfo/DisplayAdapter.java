package com.example.sqlitestudentinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DisplayAdapter extends BaseAdapter {
    Context context;
    List<StudentModel> studentModelList;

    public DisplayAdapter(Context context, List<StudentModel> studentModelList) {
        this.context = context;
        this.studentModelList = studentModelList;
    }

    @Override
    public int getCount() {
        return studentModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.my_item_layout, null);

        TextView name = customView.findViewById(R.id.nameIdi);
        TextView email = customView.findViewById(R.id.emailIdi);
        TextView phone = customView.findViewById(R.id.phoneIdi);
        TextView cgpa = customView.findViewById(R.id.cgpaidi);

        name.setText(studentModelList.get(i).getName());
        email.setText(studentModelList.get(i).getEmail());
        phone.setText(studentModelList.get(i).getPhone());
        cgpa.setText(studentModelList.get(i).getCgpa() + "");
        return customView;



    }
}
