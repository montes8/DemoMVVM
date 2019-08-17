package pe.solera.repository.network.utils

import android.content.Context
import android.graphics.Point
import android.util.DisplayMetrics
import android.view.WindowManager


fun getDensity(context: Context): Float {
    val metrics = DisplayMetrics()
    val windowsManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    windowsManager.defaultDisplay.getMetrics(metrics)
    return metrics.density
}

fun getWidht(context: Context): Int {
    val size = Point()
    val windowsManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    windowsManager.defaultDisplay.getSize(size)
    return size.x
}

fun getHeight(context: Context): Int {
    val size = Point()
    val windowsManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    windowsManager.defaultDisplay.getSize(size)
    return size.y
}