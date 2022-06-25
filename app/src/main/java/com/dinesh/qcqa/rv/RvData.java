package com.dinesh.qcqa.rv;

import android.util.Log;

import com.dinesh.qcqa.api.ApiMain;

import java.util.ArrayList;
import java.util.List;

public class RvData {
    private static final String TAG = "log_RvData";
    private static RvData rvData = new RvData();
    List<ParentModelClass> parentModelClassList = new ArrayList<>();
    List<ChildModelClass> favList = new ArrayList<>();
    List<ChildModelClass> recentList = new ArrayList<>();
    List<ChildModelClass> latestList = new ArrayList<>();



    public RvData() {
        for (int i = 0; i < 50; i++) {
            latestList.add(new ChildModelClass("https://picsum.photos/" + (i + 250)));
            recentList.add(new ChildModelClass("https://picsum.photos/" + (i + 300)));
            favList.add(new ChildModelClass("https://picsum.photos/" + (i + 350)));
        }

        Log.e(TAG, "RvData: "+ ApiMain.testMethod2());
//        parentModelClassList.add(new ParentModelClass(ApiMain.bodytest.get(1).title, latestList));
        parentModelClassList.add(new ParentModelClass("Latest Movies", latestList));
        parentModelClassList.add(new ParentModelClass("Recent Movies", recentList));
        parentModelClassList.add(new ParentModelClass("Favorite Movies", favList));

        parentModelClassList.add(new ParentModelClass("Latest Movies", latestList));
        parentModelClassList.add(new ParentModelClass("Recent Movies", recentList));
        parentModelClassList.add(new ParentModelClass("Favorite Movies", favList));
        parentModelClassList.add(new ParentModelClass("Latest Movies", latestList));
        parentModelClassList.add(new ParentModelClass("Recent Movies", recentList));
        parentModelClassList.add(new ParentModelClass("Favorite Movies", favList));
        parentModelClassList.add(new ParentModelClass("Latest Movies", latestList));
        parentModelClassList.add(new ParentModelClass("Recent Movies", recentList));
        parentModelClassList.add(new ParentModelClass("Favorite Movies", favList));

    }

    public static RvData getRvData() {
        if (rvData == null) {
            rvData = new RvData();
        }
        return rvData;
    }

    public List<ParentModelClass> getRvDataList() {
        return parentModelClassList;
    }
}
