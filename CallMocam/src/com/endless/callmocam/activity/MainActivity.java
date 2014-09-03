package com.endless.callmocam.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final String MOCAM_PACKAGE_NAME = "com.cyber.wallet";
    private static final String MOCAM_CLASS_NAME = "com.cyber.wallet.LoadingActivity";
    private static final String CARD_PACKAGE_NAME = "card_package_name";
    private EditText mEtPackageName;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_call_pufa_card).setOnClickListener(this);
        findViewById(R.id.btn_goto_third_part_client).setOnClickListener(this);
        mEtPackageName =  (EditText) findViewById(R.id.editText_package_name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.btn_call_pufa_card:
            mEtPackageName.setText("com.cyber.crash");
            gotoCardClient("com.cyber.crash");
            break;
        case R.id.btn_goto_third_part_client:
            if (checkInputs()) {
                gotoCardClient(mEtPackageName.getText().toString());
            }
            break;
        default:
            break;
        }

    }
    
    private void gotoCardClient(String packageName) {
        ComponentName cName = new ComponentName(MOCAM_PACKAGE_NAME, MOCAM_CLASS_NAME);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(CARD_PACKAGE_NAME, packageName);
        intent.putExtras(bundle);
        intent.setComponent(cName);
        startActivity(intent);
    }
    
    private boolean checkInputs() {
        if (TextUtils.isEmpty(mEtPackageName.getText())) {
            Toast.makeText(this, R.string.package_name_is_empty, Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }
}
