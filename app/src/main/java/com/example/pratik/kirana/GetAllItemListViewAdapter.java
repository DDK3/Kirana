package com.example.pratik.kirana;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class GetAllItemListViewAdapter extends BaseAdapter {

    JSONArray jsonArray;
    Bitmap[] imagesFromDatabase;
    private static LayoutInflater inflater = null;

    public GetAllItemListViewAdapter(JSONArray jsonArray, Activity activity) {
        this.jsonArray = jsonArray;
        imagesFromDatabase = new Bitmap[jsonArray.length()];
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return jsonArray.length();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final GettingReferencesOfViewsFromDesignOfListView gettingViews;

        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.list_view_design_activity, null);
            gettingViews = new GettingReferencesOfViewsFromDesignOfListView();

            gettingViews.textViewNameOfItemInListViewDesignActivity = (TextView) convertView.findViewById(R.id.textViewNameOfItemInListViewDesignActivity);
            gettingViews.textViewBrandOfItemInListViewDesignActivity = (TextView) convertView.findViewById(R.id.textViewBrandOfItemInListViewDesignActivity);
            gettingViews.textViewPriceInListViewDesignActivity = (TextView) convertView.findViewById(R.id.textViewPriceInListViewDesignActivity);
            gettingViews.imageViewInListViewDesignActivity = (ImageView) convertView.findViewById(R.id.imageViewInListViewDesignActivity);
            //cell.isImageset=false;
            gettingViews.imageViewInListViewDesignActivity.setTag(gettingViews);
            convertView.setTag(gettingViews);
        } else {
            gettingViews = (GettingReferencesOfViewsFromDesignOfListView) convertView.getTag();
        }

        try {
                final JSONObject jsonObject = this.jsonArray.getJSONObject(position);
                    gettingViews.textViewNameOfItemInListViewDesignActivity.setText(jsonObject.getString("product_name"));
                    gettingViews.textViewBrandOfItemInListViewDesignActivity.setText(jsonObject.getString("brand"));
                    gettingViews.textViewPriceInListViewDesignActivity.setText(jsonObject.getString("price"));

                if(imagesFromDatabase[position]!=null)
                    gettingViews.imageViewInListViewDesignActivity.setImageBitmap(imagesFromDatabase[position]);

                //id of User
                final String idOfUser = jsonObject.getString("id");

                //Full Url of Image
                final String urlForImageFromDatabase = "http://192.168.43.35:80/kirana/getting_image_from_database.php?id="+idOfUser;

                //New Async Task
                class LoadImages extends AsyncTask<String, Void, Bitmap> {

                    ImageView imv;

                    public LoadImages(ImageView imv) {this.imv=imv;}

                    @Override
                    protected Bitmap doInBackground(String... params) {

                        String url = params[0];
                        Bitmap image = null;

                        try {
                            InputStream inputStream = new java.net.URL(url).openStream();
                            image = BitmapFactory.decodeStream(inputStream);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        return image;
                    }

                    @Override
                    protected void onPostExecute(Bitmap bitmap) {
                        super.onPostExecute(bitmap);
                        Log.d("#######", "Image Position = " + position);
                        int a = Integer.parseInt(idOfUser) - 1;
                        Log.d("#######", "ID of User is  = " + a);
                        imagesFromDatabase[position] = bitmap;
                        //cell.mobile.setImageBitmap(bitmap);
                        //cell.isImageset = true;
                    }
                }

                new LoadImages(gettingViews.imageViewInListViewDesignActivity).execute(urlForImageFromDatabase);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return convertView;

        }

        private class GettingReferencesOfViewsFromDesignOfListView{
            private TextView textViewNameOfItemInListViewDesignActivity, textViewBrandOfItemInListViewDesignActivity,
                    textViewPriceInListViewDesignActivity;
            private ImageView imageViewInListViewDesignActivity = null;
        }

}
