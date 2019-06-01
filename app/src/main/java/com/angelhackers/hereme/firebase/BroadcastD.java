//package com.angelhackers.hereme.firebase;
//
//
//import android.app.Notification;
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.util.Log;
//import androidx.core.app.NotificationCompat;
//import com.angelhackers.hereme.R;
//import com.angelhackers.hereme.activity.MainActivity;
//
//public class BroadcastD extends BroadcastReceiver {
//    String INTENT_ACTION = Intent.ACTION_BOOT_COMPLETED;
////
////    @Override
////    public void onReceive(Context context, Intent intent) {//알람 시간이 되었을때 onReceive를 호출함
////        //NotificationManager 안드로이드 상태바에 메세지를 던지기위한 서비스 불러오고
////        Log.v("alarm!!!", "alarm!!!");
////        NotificationManager notificationmanager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
////        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
////        String channelId = "channel";
////        String channelName = "Channel Name";
////        int importance = NotificationManager.IMPORTANCE_LOW;
////
////        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
////            NotificationChannel mChannel = new NotificationChannel(
////                    channelId, channelName, importance);
////
////            notificationmanager.createNotificationChannel(mChannel);
////
////        }
////        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId);
////        builder.setSmallIcon(R.mipmap.ic_launcher).setTicker("HETT").setWhen(System.currentTimeMillis())
////                .setNumber(1).setContentTitle("!").setContentText("되라 기분은 어때요? 저한테 알려주세요!")
////                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE).setContentIntent(pendingIntent).setAutoCancel(true);
////
////        notificationmanager.notify(1, builder.build());
////    }
//
//}