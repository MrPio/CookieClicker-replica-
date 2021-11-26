package mrpio.cookieclicker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.util.Log;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.nanoTime;

@TargetApi(Build.VERSION_CODES.KITKAT)
public class TestFragment extends android.app.Fragment {

    private void printLog(String s) {
// display a message in Log File
        Log.d("LifeCycle:", s);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        printLog("onActivityCreated---> "+String.valueOf (currentTimeMillis() - MainActivity.mtime     +"---> "+String.valueOf (nanoTime () - MainActivity.ntime)));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_test, container, false);
        printLog("onCreateView---> "+String.valueOf (currentTimeMillis() - MainActivity.mtime     +"---> "+String.valueOf (nanoTime () - MainActivity.ntime)));

        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        printLog("onViewCreated---> "+String.valueOf (currentTimeMillis() - MainActivity.mtime     +"---> "+String.valueOf (nanoTime () - MainActivity.ntime)));

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        printLog("onAttach---> "+String.valueOf (currentTimeMillis() - MainActivity.mtime     +"---> "+String.valueOf (nanoTime () - MainActivity.ntime)));    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printLog("onCreate---> "+String.valueOf (currentTimeMillis() - MainActivity.mtime     +"---> "+String.valueOf (nanoTime () - MainActivity.ntime)));    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        printLog("onDestroy---> "+String.valueOf (currentTimeMillis() - MainActivity.mtime     +"---> "+String.valueOf (nanoTime () - MainActivity.ntime)));    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        printLog("onDestroyView---> "+String.valueOf (currentTimeMillis() - MainActivity.mtime     +"---> "+String.valueOf (nanoTime () - MainActivity.ntime)));    }

    @Override
    public void onDetach() {
        super.onDetach();
        printLog("onDetach---> "+String.valueOf (currentTimeMillis() - MainActivity.mtime     +"---> "+String.valueOf (nanoTime () - MainActivity.ntime)));    }

    @Override
    public void onPause() {
        super.onPause();
        printLog("onPause---> "+String.valueOf (currentTimeMillis() - MainActivity.mtime     +"---> "+String.valueOf (nanoTime () - MainActivity.ntime)));    }

    @Override
    public void onResume() {
        super.onResume();
        printLog("onResume---> "+String.valueOf (currentTimeMillis() - MainActivity.mtime     +"---> "+String.valueOf (nanoTime () - MainActivity.ntime)));    }

    @Override
    public void onStart() {
        super.onStart();
        printLog("onStart---> "+String.valueOf (currentTimeMillis() - MainActivity.mtime     +"---> "+String.valueOf (nanoTime () - MainActivity.ntime)));    }

    @Override
    public void onStop() {
        super.onStop();
        printLog("onStop---> "+String.valueOf (currentTimeMillis() - MainActivity.mtime     +"---> "+String.valueOf (nanoTime () - MainActivity.ntime)));    }

}