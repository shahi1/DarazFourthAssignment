package com.example.darazfourthassign.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.darazfourthassign.R;
import com.example.darazfourthassign.adapter.ProductAdapter;
import com.example.darazfourthassign.adapter.SliderAdapter;
import com.example.darazfourthassign.api.ProductApi;
import com.example.darazfourthassign.model.Products;
import com.example.darazfourthassign.url.Url;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    SliderView sliderView;
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        sliderView = view.findViewById(R.id.Slider);
        recyclerView = view.findViewById(R.id.RecyclerView);

        final SliderAdapter adapter = new SliderAdapter(getContext());
        adapter.setCount(3);
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();

        getProduct();
        return view;
    }


        private void getProduct () {
            ProductApi productApi = Url.getInstance().create(ProductApi.class);
            Call<List<Products>> listCall = productApi.getProduct();
            listCall.enqueue(new Callback<List<Products>>() {
                @Override
                public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {

                    if (!response.isSuccessful()) {
                        Toast.makeText(getContext(), "Toast " + response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    ProductAdapter productadapter = new ProductAdapter(getActivity(), response.body());
                    recyclerView.setAdapter(productadapter);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    productadapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<Products>> call, Throwable t) {

                    Toast.makeText(getActivity(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
