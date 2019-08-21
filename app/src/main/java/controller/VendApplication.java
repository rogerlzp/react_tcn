package controller;


import com.facebook.react.BuildConfig;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.tcn.sdk.springdemo.ExampleReactNativePackage;
import com.tcn.springboard.control.TcnShareUseData;
import com.tcn.springboard.control.TcnVendApplication;

import java.util.Arrays;
import java.util.List;

/**
 * 描述：
 * 作者：Jiancheng,Song on 2016/5/31 15:53
 * 邮箱：m68013@qq.com
 */
public class VendApplication extends TcnVendApplication implements ReactApplication {

    public static final ExampleReactNativePackage exampleReactNativePackage=new ExampleReactNativePackage();

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    exampleReactNativePackage
            );
        }

    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        TcnShareUseData.getInstance().setBoardSerPortFirst("/dev/ttyS0");    //此处主板串口接安卓哪个串口，就填哪个串口
//        TcnShareUseData.getInstance().setBoardSerPortFirst("/dev/ttymxc1");
        //VendIF 这个文件里面 TcnComDef.COMMAND_SLOTNO_INFO这个消息，是上报货道信息的消息,每次重启程序都会查询一次所有的货道信息

        /****************  如果接有副柜  则需要如下设置  **********************/
//        TcnShareUseData.getInstance().setSerPortGroupMapFirst("0");    //设置主柜组号，也可不设置，默认就是0
//        TcnShareUseData.getInstance().setSerPortGroupMapSecond("0");   //设置副柜组号为0,副柜需要接安卓另外一个串口
        //TcnShareUseData.getInstance().setBoardTypeSecond("thj");   //设置副柜类型为弹簧机
//        TcnShareUseData.getInstance().setBoardSerPortSecond("/dev/ttyS1");    //设置副柜串口，副柜接安卓哪个串口，就填哪个串口

        /****************  如果带现金  则需要如下设置  **********************/
//        TcnShareUseData.getInstance().setCashPayOpen(true);  //设置是否启用现金支付
//        TcnShareUseData.getInstance().setBoardSerPortMDB("/dev/ttyS2");    //此处MDB主板设备接安卓哪个串口，就填哪个串口

        //先运行程序之后，请将TcnKey目录的tcn_sdk_device_id.txt文件发给我们，授权才能使用，每台机器都必须先授权。


        /*******************************      故障代码表见 VendIF  这个文件 **************************************/

    }
}
