package bwie.com.shizhan2.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.recker.flybanner.FlyBanner;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import bwie.com.shizhan2.ErWeiMaActivity;
import bwie.com.shizhan2.R;
import bwie.com.shizhan2.ScanActivity;
import bwie.com.shizhan2.XiangqingActivity;
import bwie.com.shizhan2.adapter.MlsaAdapter;
import bwie.com.shizhan2.adapter.PzshAdapter;
import bwie.com.shizhan2.adapter.RxcpAdapter;
import bwie.com.shizhan2.bean.ShouYeBean;
import bwie.com.shizhan2.presenter.ShouYePresenterClass;
import bwie.com.shizhan2.view.ZxingActivity;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

public class ShouYeFragment extends Fragment
{
    private RecyclerView rec1;
    private RecyclerView rec2;
    private RecyclerView rec3;
    private Intent intent;
    private ImageView sao;
    private ImageView shengcheng;


    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shouye, container, false);
        FlyBanner fly= view.findViewById(R.id.flyBan);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("http://172.17.8.100/images/small/commodity/nx/ddx/3/1.jpg");
        strings.add("http://172.17.8.100/images/small/commodity/nx/ddx/3/1.jpg");
        strings.add("http://172.17.8.100/images/small/commodity/nx/ddx/3/1.jpg");
        strings.add("http://172.17.8.100/images/small/commodity/nx/ddx/3/1.jpg");
        fly.setImagesUrl(strings);
        sao = view.findViewById(R.id.sao);
        shengcheng = view.findViewById(R.id.shengcheng);
        shengcheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), ErWeiMaActivity.class);
                startActivity(intent);


            }
        });
        sao.setOnClickListener(new View.OnClickListener() {

            private Intent intent;

            @Override
            public void onClick(View v) {

                intent = new Intent(getActivity(), ZxingActivity.class);
                startActivity(intent);


              /*  // 设置要扫描的条码类型，ONE_D_CODE_TYPES：一维码，QR_CODE_TYPES-二维码
                IntentIntegrator integrator = new IntentIntegrator(getActivity());
                integrator.setDesiredBarcodeFormats(IntentIntegrator.CODE_39);
                integrator.setCaptureActivity(ScanActivity.class);
                integrator.setPrompt("请扫描二维码");//底部的提示文字，设为""可以置空
                integrator.setCameraId(0);//前置或者后置摄像头
                integrator.setBeepEnabled(true);//扫描成功的「哔哔」声，默认开启
                integrator.setBarcodeImageEnabled(true);
                integrator.initiateScan();*/
            }
        });
        rec1 = view.findViewById(R.id.rec1);
        rec2 =view.findViewById(R.id.rec2);
        rec3= view.findViewById(R.id.rec3);
        ShouYePresenterClass shouYePresenterClass = new ShouYePresenterClass(this);
        shouYePresenterClass.getShouYePresenterData();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rec1.setLayoutManager(staggeredGridLayoutManager);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rec2.setLayoutManager(layoutManager);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        rec3.setLayoutManager(gridLayoutManager);
        return view;
    }



    public void getData(Object data)
    {
        ShouYeBean sy = (ShouYeBean) data;
        final List<ShouYeBean.ResultBean.PzshBean.CommodityListBeanX> pzsh = sy.getResult().getPzsh().get(0).getCommodityList();
        final List<ShouYeBean.ResultBean.MlssBean.CommodityListBeanXX> mlss = sy.getResult().getMlss().get(0).getCommodityList();
        final List<ShouYeBean.ResultBean.RxxpBean.CommodityListBean> rxxp = sy.getResult().getRxxp().get(0).getCommodityList();
        RxcpAdapter rxcpAdapter = new RxcpAdapter(getActivity(), rxxp);
        rec1.setAdapter(rxcpAdapter);
        PzshAdapter pzshAdapter = new PzshAdapter(getActivity(), pzsh);
        rec3.setAdapter(pzshAdapter);
        MlsaAdapter mlsaAdapter = new MlsaAdapter(getActivity(), mlss);
        rec2.setAdapter(mlsaAdapter);
        rxcpAdapter.setClick(new RxcpAdapter.setOnItemClick() {
            @Override
            public void onitemClick(View v, int position, int id) {
               // Toast.makeText(getActivity(),rxxp.get(position).getCommodityName(),Toast.LENGTH_SHORT).show();
                intent = new Intent(getActivity(), XiangqingActivity.class);
                intent.putExtra("name",rxxp.get(position).getCommodityName());
                intent.putExtra("img",rxxp.get(position).getMasterPic());
                startActivity(intent);
            }
        });
        mlsaAdapter.setClick(new MlsaAdapter.setMlssOnItemClick() {
            @Override
            public void onitemClick(View v, int position, int id) {
                intent = new Intent(getActivity(), XiangqingActivity.class);
                intent = new Intent(getActivity(), XiangqingActivity.class);
                intent.putExtra("name",mlss.get(position).getCommodityName());
                startActivity(intent);
            }
        });
        pzshAdapter.setClick(new PzshAdapter.setPzshOnItemClick() {

            @Override
            public void onitemClick(View v, int position, int id) {
                intent = new Intent(getActivity(), XiangqingActivity.class);
                intent = new Intent(getActivity(), XiangqingActivity.class);
                intent.putExtra("name",pzsh.get(position).getCommodityName());
                startActivity(intent);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(intentResult !=null)
        {
            String contents = intentResult.getContents();
            Log.e("onActivityResult",contents+"");
            Toast.makeText(getActivity(),contents,Toast.LENGTH_SHORT).show();
        }
        Log.e("啦啦啦啦啦啦",intentResult+"");

    }

}
