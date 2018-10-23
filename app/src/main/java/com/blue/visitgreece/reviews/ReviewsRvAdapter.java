package com.blue.visitgreece.reviews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blue.visitgreece.R;

import java.util.ArrayList;

public class ReviewsRvAdapter extends RecyclerView.Adapter<ReviewsRvAdapter.ReviewsViewHolder> {

    private ArrayList<Review> reviews;
//    private Context context; //needed for UI color bundle data , maybe not needed



    public ReviewsRvAdapter(ArrayList<Review> reviews){
        this.reviews = reviews;
    }

//    public ReviewsRvAdapter(ArrayList<Review> reviews,Context context){
//        this.reviews = reviews;
//        this.context = context;
//    }

    public static class ReviewsViewHolder extends RecyclerView.ViewHolder {
        TextView mReviewDescription; //or maybe name comment???
        TextView mRating;
        TextView mReviewerName;
        RelativeLayout mReviewItemRoot;

        public ReviewsViewHolder(View v){
            super(v);
            mReviewDescription = v.findViewById(R.id.review_description);
            mRating = (v.findViewById(R.id.review_rating));
            mReviewerName = v.findViewById(R.id.review_reviewer_name);
            mReviewItemRoot = v.findViewById(R.id.review_item_root);
        }
    }


    @NonNull
    @Override
    public ReviewsRvAdapter.ReviewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_review_item, viewGroup, false);
        ReviewsRvAdapter.ReviewsViewHolder vh = new ReviewsRvAdapter.ReviewsViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewsRvAdapter.ReviewsViewHolder reviewsViewHolder, int i) {
        final int position = i;

        reviewsViewHolder.mReviewDescription.setText(reviews.get(position).getComment());
        reviewsViewHolder.mRating.setText(String.valueOf(reviews.get(position).getRating())); //parse integer String.valueOf
//        reviewsViewHolder.mReviewerName.setText(reviews.get(position).ge); ReviewerName from User Enitity

    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }
}
