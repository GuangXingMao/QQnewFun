package com.study.mgx.qqnewfun.androidM;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import cn.itcast.wh.androidm.R;


public class PermissionActivity extends Activity {


    private static final int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
    }

    public void getFirstContact(View v) {
        // 如果应用程序是为target是23，用户可能会关闭权限
//        ① 在做一些权限敏感的操作时，检查权限，保证程序不会因为权限问题崩溃
        int permission = ContextCompat.checkSelfPermission(v.getContext(), Manifest.permission.READ_CONTACTS);
        if (permission == PackageManager.PERMISSION_GRANTED) {
            // 如果具备权限，才去获取
            showFirstContact(v.getContext());
        } else {
            // ②告诉用户去开启权限
            // 以下方式不可取，因为 1可能用户不知道怎么开，2比较麻烦
//            Toast.makeText(v.getContext(), "没有联系人权限，请去设置中开启", Toast.LENGTH_SHORT).show();
            // 系统提供了获取权限的操作
            // 可以一次要求用户提供多个权限
            String[] permissions = new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission
                    .WRITE_CONTACTS, Manifest.permission.READ_CALENDAR};
            ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE);
        }
    }

    // ③重写此方法，当要求获得权限的对话框消失之后，此方法会被调用，可知道获取权限的结果
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode != REQUEST_CODE) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < permissions.length; i++) {
            sb.append(grantResults[i]).append(" ").append(permissions[i]).append("\n");
        }

        Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();

        // 判断用户是否真的允许
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            showFirstContact(this);
        } else {
            // 告诉用户你必须同意才能继续
        }
    }

    private void showFirstContact(Context context) {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
        }
        cursor.close();
    }

    ;

}
