package com.senssun.mystudysmartrefreshdemo02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.scwang.smartrefresh.header.FunGameHitBlockHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RefreshLayout refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        refreshLayout.setRefreshHeader(new FunGameHitBlockHeader(this));

       /* Translate,//平行移动        特点: HeaderView高度不会改变，
        Scale,//拉伸形变            特点：在下拉和上弹（HeaderView高度改变）时候，会自动触发OnDraw事件
                FixedBehind,//固定在背后    特点：HeaderView高度不会改变，
                FixedFront,//固定在前面     特点：HeaderView高度不会改变，
                MatchLayout//填满布局       特点：HeaderView高度不会改变，尺寸充满 RefreshLayout*/
        //设置 Footer 为 球脉冲
       // refreshLayout.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.MatchLayout));

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
            }
        });


    }
}
