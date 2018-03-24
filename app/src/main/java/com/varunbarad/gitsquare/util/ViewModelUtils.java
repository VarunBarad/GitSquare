package com.varunbarad.gitsquare.util;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.varunbarad.gitsquare.R;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Creator: Varun Barad
 * Date: 25-03-2018
 * Project: GitSquare
 */
public class ViewModelUtils {
  @BindingAdapter({"bind:imageUrl"})
  public static void loadImage(ImageView view, String imageUrl) {
    Picasso
        .with(view.getContext())
        .load(imageUrl)
        .error(R.drawable.ic_profile)
        .placeholder(R.drawable.ic_profile)
        .transform(new CropCircleTransformation())
        .into(view);
  }
  
  @BindingAdapter({"bind:webUrl"})
  public static void openUrl(TextView view, final String webUrl) {
    view.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Helper.openUrlInBrowser(view.getContext(), webUrl);
      }
    });
  }
}
