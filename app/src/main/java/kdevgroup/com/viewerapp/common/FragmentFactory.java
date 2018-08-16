package kdevgroup.com.viewerapp.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentFactory {

    public static void changeFragment(@Nullable FragmentManager fragmentManager, int container, Fragment fragment, boolean addToBackStack, Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        if (bundle != null) {
            fragment.setArguments(bundle);
        }

        if (fragmentManager.findFragmentByTag(fragment.getTag()) != null) {
            fragmentTransaction.remove(fragment);
        }


        fragmentTransaction.replace(container, fragment, fragment.getClass().getSimpleName());

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        }

        fragmentTransaction.commit();
    }
}
