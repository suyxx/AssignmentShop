package www.prankapp.suyash.assignmentshop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public  class Parser {

    public static ArrayList<AllProductModel> parseAllProduct(JSONArray jsonArray){
        ArrayList<AllProductModel> productModelArrayList = new ArrayList<>();

        for(int i = 0;i<jsonArray.length();i++){
            try {
                AllProductModel allProductModel = new AllProductModel();
                JSONObject object = jsonArray.getJSONObject(i);
                String id = object.getString("cp_id");
                allProductModel.setId(id);
                String name = object.getString("shop_name");
                allProductModel.setName(name);
                String image = object.getString("main_image");
                allProductModel.setImage(image);
                String rating = object.getString("total_rated");
                allProductModel.setRating(rating);

                productModelArrayList.add(allProductModel);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return productModelArrayList;
    }
}
