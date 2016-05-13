package com.example.pratik.kirana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomAdapterForMainGridView extends BaseAdapter{

    String [] resultForMainLayout;
    Context context;
    int [] imageIdForMainLayout;
    private static LayoutInflater inflater=null;

    public CustomAdapterForMainGridView(Context context, String[] prgmNameList, int[] prgmImages) {
        resultForMainLayout=prgmNameList;
        this.context=context;
        imageIdForMainLayout = prgmImages;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return resultForMainLayout.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class HolderInMainLayout
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        HolderInMainLayout holder=new HolderInMainLayout();
        View rowView;

        rowView = inflater.inflate(R.layout.grid_layout_for_main, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textViewForMainLayout);
        holder.img=(ImageView) rowView.findViewById(R.id.imageViewForMainLayout);

        holder.tv.setText(resultForMainLayout[position]);

        holder.img.setImageResource(imageIdForMainLayout[position]);
        holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);

        return rowView;
    }

}
