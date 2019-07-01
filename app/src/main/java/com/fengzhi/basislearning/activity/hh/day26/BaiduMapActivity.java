package com.fengzhi.basislearning.activity.hh.day26;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.BaseActivity;

import butterknife.BindView;

public class BaiduMapActivity extends BaseActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.bmapView)
    MapView bmapView;
    private BaiduMap baiduMap;//控件上的涂层

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("BaiduMapActivity");
        baiduMap = bmapView.getMap();
        //设置地图类型  MAP_TYPE_SATELLITE：卫星图   MAP_TYPE_NONE:空白
        baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        //开启实时交通
        //baiduMap.setTrafficEnabled(true);
        //104.021145,30.673295
        setMarker();
    }

    //添加一个指定的标注
    public void setMarker() {
        //通过地图上的一个坐标，构造一个经纬度对象
        LatLng position = new LatLng(30.673295, 104.021145);
        BitmapDescriptor icon = BitmapDescriptorFactory.
                fromResource(R.mipmap.download);

        final Bundle bundle = new Bundle();
        bundle.putInt("flag", 1);
        bundle.putString("msg", "标注的额外信息。西南财经大学");

        OverlayOptions options = new MarkerOptions().position(position)//设置经纬度
                .icon(icon)//设置标注的图标
                .title("标题")//设置标题
                .extraInfo(bundle);//设置一些额外信息，比如区分各自的标注标记


        //标注涂层添加到百度地图上
        baiduMap.addOverlay(options);
        //把当前的坐标移到视线中心
        baiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(position));


        //地图上的标注的点击事件
        baiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String title = marker.getTitle();
                Bundle bundle1 = marker.getExtraInfo();
                Toast.makeText(BaiduMapActivity.this, "点击了标注" + title + bundle1.getInt("flag"),
                        Toast.LENGTH_LONG).show();

                //获取到当前被点击的标注的经纬度
                LatLng position = marker.getPosition();


                Button button = new Button(BaiduMapActivity.this);
                button.setText(bundle1.getString("msg"));
                button.setPadding(10, 10, 10, 10);
                button.setBackgroundResource(R.mipmap.ic_launcher);

                //构造弹窗
//                InfoWindow infoWindow = new InfoWindow(
//                        button,//弹窗的视图界面
//                        position,//弹窗要显示的位置
//                        -70);//弹窗的偏移量

                InfoWindow infoWindow = new InfoWindow(BitmapDescriptorFactory.fromView(button),
                        //弹窗的视图界面。把一个控件转换成BitmapDescriptor对象
                        position,//弹窗要显示的位置
                        -70,//弹窗的偏移量
                        new InfoWindow.OnInfoWindowClickListener() {
                            @Override
                            public void onInfoWindowClick() {
                                //隐藏弹窗
                                baiduMap.hideInfoWindow();
                            }
                        });//点击弹窗的监听器。
                //显示弹窗
                baiduMap.showInfoWindow(infoWindow);

                return false;
            }
        });
    }

    //管理地图的生命周期
    @Override
    protected void onResume() {
        super.onResume();
        bmapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        bmapView.onPause();
    }

    @Override
    protected void onDestroy() {
        bmapView.onDestroy();
        super.onDestroy();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_baidu_map;
    }
}
