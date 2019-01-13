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

public class PzshAdapter extends RecyclerView.Adapter<PzshAdapter.PzshViewHolder> {
    Context context;
    List<ShouYeBean.ResultBean.PzshBean.CommodityListBeanX> pzsh;
    private View view;

    public PzshAdapter(Context context, List<ShouYeBean.ResultBean.PzshBean.CommodityListBeanX> pzsh) {
      this.context =context;
      this.pzsh=pzsh;
    }
    @NonNull
    @Override
    public PzshAdapter.PzshViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.shouye_3, viewGroup, false);
        PzshViewHolder pzshViewHolder = new PzshViewHolder(view);
        return pzshViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull PzshAdapter.PzshViewHolder pzshViewHolder, final int i) {
        pzshViewHolder.name.setText(pzsh.get(i).getCommodityName());
       // pzshViewHolder.price.setText(pzsh.get(i).getPrice());
        Glide.with(context)
                .load(pzsh.get(i).getMasterPic())
                .into(pzshViewHolder.img);
        pzshViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener !=null)
                {
                    listener.onitemClick(view,i,pzsh.get(i).getCommodityId());
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return pzsh.size();
    }
    class PzshViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
        ImageView img;
        public PzshViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.name);
            price= itemView.findViewById(R.id.price);
            img= itemView.findViewById(R.id.img);
        }
    }
    public interface setPzshOnItemClick
    {
        void onitemClick(View v,int position,int id);
    }
    setPzshOnItemClick listener;
    public void setClick(setPzshOnItemClick listener)
    {
        this.listener =listener;
    }
}
