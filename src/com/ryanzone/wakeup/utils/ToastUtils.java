package com.ryanzone.wakeup.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast tolls
 * ToastUtils.java
 * @author Ryan
 * Create at 2013-12-8 下午1:56:32
 */
public final class ToastUtils {

	/**
	 * Show toast by string message
	 * @param context
	 * @param message
	 */
	public static void showToast(Context context,String message){
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * Show toast by resources id
	 * @param context
	 * @param resourceId
	 */
	public static void showToast(Context context,int resourceId){
		Toast.makeText(context, context.getResources().getString(resourceId), Toast.LENGTH_SHORT).show();
	}
	
}
