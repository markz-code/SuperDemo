package com.zpl.utils

import android.content.res.Resources
import android.util.DisplayMetrics


class ScreenUtil {

    companion object {
        /**
         * dp to px
         */
        fun pt2Px(ptValue: Float): Int {
            val metrics: DisplayMetrics = Resources.getSystem().displayMetrics
            return (ptValue * metrics.xdpi / 72f + 0.5).toInt()
        }

        /**
         * px to dp
         */
        fun px2Pt(pxValue: Float): Int {
            val metrics: DisplayMetrics = Resources.getSystem().displayMetrics
            return (pxValue * 72 / metrics.xdpi + 0.5).toInt()
        }
    }

}