package com.gachonumc.threejeon.Platform.Yogiyo

import com.gachonumc.threejeon.Platform.Baemin.BaeminStoreList
import com.google.gson.annotations.SerializedName

data class YogiyoResponse (
        @SerializedName("result") val result: Array<BaeminStoreList>
        )
