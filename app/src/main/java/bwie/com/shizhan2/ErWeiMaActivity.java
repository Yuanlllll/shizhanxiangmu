package bwie.com.shizhan2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

public class ErWeiMaActivity extends AppCompatActivity
{

    private ImageView sc;
    String name="白俊岭，我爱你……";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.erweima);
        sc = findViewById(R.id.shengcheng);
        createQRCode();
    }
    private void createQRCode()
    {
        QRtask qRtask=new QRtask(ErWeiMaActivity.this,sc,name);
        qRtask.execute(name);
    }
    static class QRtask extends AsyncTask<String,ImageView,Bitmap> {
        private WeakReference<Context> mcontext;
        private WeakReference<ImageView> mimage;

        public QRtask(Context context,ImageView imageView,String name) {
            mcontext=new WeakReference<>(context);
            mimage=new WeakReference<>(imageView);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String str = strings[0];
            if (TextUtils.isEmpty(str)){
                return null;
            }
            int size=mcontext.get().getResources().getDimensionPixelSize(R.dimen.cc);
            return QRCodeEncoder.syncEncodeQRCode(str,size);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap!=null){
                mimage.get().setImageBitmap(bitmap);
            }else{
                Toast.makeText(mcontext.get(), "生成失败", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
