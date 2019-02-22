package www.prankapp.suyash.assignmentshop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AllProductAdapter extends RecyclerView.Adapter<AllProductAdapter.MyViewHolder> {

    private ArrayList<AllProductModel> totalProduct = new ArrayList<>();

    public AllProductAdapter(ArrayList<AllProductModel> arrayList){
        totalProduct = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View myView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recy_list_item,viewGroup,false);
        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
       final AllProductModel model = totalProduct.get(i);
             String s = model.getImage();
             Picasso.get().load(R.drawable.image).into(myViewHolder.imageView);
             myViewHolder.textView.setText(model.getName());

             myViewHolder.view.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Bundle bundle = new Bundle();
                     bundle.putString("productid", model.getId());
                     AppCompatActivity activity = (AppCompatActivity) v.getContext();
                     Fragment myFragment = new ProductFragment();
                     myFragment.setArguments(bundle);
                     activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentframelayout, myFragment).addToBackStack(null).commit();
                 }
             });
    }

    @Override
    public int getItemCount() {
        return totalProduct.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
          public ImageView imageView;
          public TextView textView ;
          public RatingBar ratingBar;
          public View view;
          public MyViewHolder(View view){
              super(view);
              this.view = view;
              imageView = view.findViewById(R.id.listimageview)  ;
              textView = view.findViewById(R.id.namelistitem);
              ratingBar = view.findViewById(R.id.listRatingBar);
          }
      }


}
