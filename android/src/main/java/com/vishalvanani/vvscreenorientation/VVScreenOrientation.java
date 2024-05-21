package com.vishalvanani.vvscreenorientation;

import android.util.Log;
import android.view.Surface;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.content.pm.ActivityInfo;

public class VVScreenOrientation {

    private AppCompatActivity activity;

//    public ScreenOrientation(AppCompatActivity activity) {
//        this.activity = activity;
//    }

   public String getCurrentOrientationType() {
       int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
       return fromRotationToOrientationType(rotation);
   }

   private String fromRotationToOrientationType(int rotation) {
       switch (rotation) {
           case Surface.ROTATION_90:
               return "landscape-primary";
           case Surface.ROTATION_180:
               return "portrait-secondary";
           case Surface.ROTATION_270:
               return "landscape-secondary";
           default:
               return "portrait-primary";
       }
   }

   @Override
    public void handleOnConfigurationChanged(Configuration newConfig) {
        super.handleOnConfigurationChanged(newConfig);
        if(implementation.hasOrientationChanged(newConfig.orientation)) {
            this.onOrientationChanged();
        }
    }

    private void onOrientationChanged() {
        JSObject ret = new JSObject();
        String type = implementation.getCurrentOrientationType();
        ret.put("type", type);
        notifyListeners("screenOrientationChange", ret);
    }

    @Nullable private int configOrientation;

    public boolean hasOrientationChanged(int orientation) {
        if (orientation == configOrientation) {
            return false;
        } else {
            this.configOrientation = orientation;
            return true;
        }
    }

    private int fromOrientationTypeToEnum(String orientationType) {
        switch (orientationType) {
            case "landscape-primary":
                return ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
            case "landscape-secondary":
                return ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
            case "portrait-secondary":
                return ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
            default:
                // Case: portrait-primary
                return ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        }
    }

    public void lock(String orientationType) {
        int orientationEnum = fromOrientationTypeToEnum(orientationType);
        activity.setRequestedOrientation(orientationEnum);
    }

    public void unlock() {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    }
}
