package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by mohamed on 12/2/2017.
 */

public class Emojifier {
    public static void detectFaces(Bitmap image, Context context) {

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();
        Frame frame = new Frame.Builder().setBitmap(image).build();
        SparseArray<Face> faces = detector.detect(frame);
        if (faces.size() > 0)
            Log.i("number of faces: ", faces.size() + "");
        else
            Toast.makeText(context,"no faces detected",Toast.LENGTH_SHORT).show();
        detector.release();
    }
    public static void getClassification(Face face){
       boolean isLeftEyeOpen,isSmiling,isRightEyeOpen;
        float leftEyeProb=face.getIsLeftEyeOpenProbability();
        Log.i("left eye probability= ",leftEyeProb+"");


    }
}
