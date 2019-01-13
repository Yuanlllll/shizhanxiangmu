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

public class RxcpAdapter extends RecyclerView.Adapter<RxcpAdapter.RxcpViewHolder> {
    Context context;
    List<ShouYeBean.ResultBean.RxxpBean.CommodityListBean> rxxp;
    private RxcpViewHolder viewHolder;
    private View view;

    public RxcpAdapter(Context context, List<ShouYeBean.ResultBean.RxxpBean.CommodityListBean> rxxp) {
    this.context =context;
    this.rxxp =rxxp;
    }

    @NonNull
    @Override
    public RxcpAdapter.RxcpViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.shouye_1, viewGroup, false);
        viewHolder = new RxcpViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RxcpAdapter.RxcpViewHolder rxcpViewHolder, final int i)
    {
        rxcpViewHolder.name.setText(rxxp.get(i).getCommodityName());
//        rxcpViewHolder.price.setText(rxxp.get(i).getPrice());
        Glide.with(context)
                .load(rxxp.get(i).getMasterPic())
                .into(rxcpViewHolder.img);
        rxcpViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener !=null)
                {
                    listener.onitemClick(view,i,rxxp.get(i).getCommodityId());
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return rxxp.size();
    }
    class RxcpViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView price;
        ImageView img;

        public RxcpViewHolder(@NonNull View itemView) {
            super(itemView);
           name= itemView.findViewById(R.id.name);
           price= itemView.findViewById(R.id.price);
           img= itemView.findViewById(R.id.img);
        }
    }
   public interface setOnItemClick
    {
        void onitemClick(View v,int position,int id);
    }
    setOnItemClick listener;
    public void setClick(setOnItemClick listener)
    {
        this.listener =listener;
    }
}
