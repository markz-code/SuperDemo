package com.zpl.utils

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.DisplayMetrics
import com.zpl.R


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

        fun getAvatar(res: Resources?, width: Int): Bitmap {
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            BitmapFactory.decodeResource(res, R.mipmap.icon_git, options)
            options.inJustDecodeBounds = false
            options.inDensity = options.outWidth
            options.inTargetDensity = width
            return BitmapFactory.decodeResource(res, R.mipmap.icon_git, options)
        }
    }

}