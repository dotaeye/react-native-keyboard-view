package im.shimo.react.keyboard;

import android.graphics.Rect;
import android.view.View;

/**
 * Created by song on 2018/1/17.
 */

public class KeyboardStateSmartianOS extends AbstractKeyboardState {
    KeyboardStateSmartianOS(View rootView, int navigationBarHeight, int statusBarHeight) {
        super(rootView, navigationBarHeight, statusBarHeight);
    }


    boolean isSmartisanOS() {
        return true;
    }

    @Override
    protected Rect dealKeyBoardFrame(Rect keyboardFrame, int navigationBarHeight, int statusBarHeight) {
        if (mKeyboardShowing) {
            //兼容非原生厂商rom隐藏navigation
            if (!mRomNavigationBarShow) {
                //rootView高度=屏幕绘画高度
                if (mRealNavigationBarShow) {
                    //系统NavigationBar显示
                    //说明键盘弹起时，高度需要增加NavigationBar高度
                } else {
                    //系统NavigationBar高度不显示
                    //说明键盘弹起时不需要增加任何高度
                }
            } else {
                //rootView高度=屏幕绘制高度-NavigationBar高度
                if (mRealNavigationBarShow) {
                    //系统NavigationBar显示
                    //说明键盘弹起时，高度需要增加NavigationBar高度
                    // ，因为键盘弹起时，NavigationBar会跟着键盘一起出现
                    keyboardFrame.top += navigationBarHeight;
                } else {
                    //系统NavigationBar高度不显示
                    //说明键盘弹起时不需要增加任何高度
                }
            }
        } else {

        }
        return keyboardFrame;
    }

    @Override
    public int checkExtraHeight(int navigationBarHeight) {
        int temp = 0;
        if (isRealNavigationBarShow()) {
            if (!isRomNavigationBarShow()) {
                temp = 0;
            } else {
                temp = navigationBarHeight;
            }
        }
        return temp;
    }
}
