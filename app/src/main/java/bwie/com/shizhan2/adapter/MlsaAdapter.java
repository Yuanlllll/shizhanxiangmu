package bwie.com.shizhan2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bwie.com.shizhan2.R;
import bwie.com.shizhan2.bean.ShouYeBean;

public class MlsaAdapter extends RecyclerView.Adapter<MlsaAdapter.MlsaViewHolder>
{
    Context context;
    MlsaViewHolder viewHolder;
    View view;
    List<ShouYeBean.ResultBean.MlssBean.CommodityListBeanXX> mlss;
    public MlsaAdapter(Context context, List<ShouYeBean.ResultBean.MlssBean.CommodityListBeanXX> mlss) {
    this.context=context;
    this.mlss =mlss;

    }

    @NonNull
    @Override
    public MlsaAdapter.MlsaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.shouye_2, viewGroup, false);
        viewHolder = new MlsaViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MlsaAdapter.MlsaViewHolder mlsaViewHolder, final int i)
    {
        viewHolder.name.setText(mlss.get(i).getCommodityName());
//        viewHolder.price.setText(mlss.get(i).getPrice());
        Glide.with(context)
                .load(mlss.get(i).getMasterPic())
                .into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener !=null)
                {
                    listener.onitemClick(view,i,mlss.get(i).getCommodityId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlss.size();
    }
    class MlsaViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
        ImageView img;
        public MlsaViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.name);
            price= itemView.findViewById(R.id.price);
            img= itemView.findViewById(R.id.img);
        }
    }
    public interface setMlssOnItemClick
    {
        void onitemClick(View v,int position,int id);
    }
    setMlssOnItemClick listener;
    public void setClick(setMlssOnItemClick listener)
    {
        this.listener =listener;
    }
}
