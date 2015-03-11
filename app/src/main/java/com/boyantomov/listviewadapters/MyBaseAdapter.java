package com.boyantomov.listviewadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by admin on 9.3.2015 г..
 */
public class MyBaseAdapter extends BaseAdapter {

    ArrayList<ListData> myList = new ArrayList<ListData>();
    LayoutInflater inflater;
    Context context;

    public MyBaseAdapter(Context context, ArrayList<ListData> myList) {
        this.myList = myList;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public ListData getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder myViewHolder;
        int type = getItemViewType(position);

        if (convertView == null) {
            if (type == 0) {
                convertView = inflater.inflate(R.layout.layout_list_item, null);
            } else {
                convertView = inflater.inflate(R.layout.layout_list_item_odd, null);
            }

            myViewHolder = new MyViewHolder();
            convertView.setTag(myViewHolder);

        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();

        }

        myViewHolder.tvMultiplication = detail(convertView, R.id.tvMultiplication, myList.get(position).getMultiplication());
        myViewHolder.tvResult = detail(convertView, R.id.tvResult, myList.get(position).getResult());


        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    private TextView detail(View v, int resID, String text) {
        TextView tv = (TextView) v.findViewById(resID);
        tv.setText(text);
        return tv;
    }

    private class MyViewHolder {
        TextView tvMultiplication, tvResult;
    }
}
