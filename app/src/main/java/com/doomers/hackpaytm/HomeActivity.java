package com.doomers.hackpaytm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.paytm.pgsdk.PaytmMerchant;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button btn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;
        btn = (Button) findViewById(R.id.payButton);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PaytmPGService Service = PaytmPGService.getStagingService();
//                Map<String, String> paramMap = new HashMap<String, String>();
//
//                // these are mandatory parameters
//
////                paramMap.put("ORDER_ID", ((EditText) findViewById(R.id.order_id)).getText().toString());
////                paramMap.put("MID", ((EditText) findViewById(R.id.merchant_id)).getText().toString());
////                paramMap.put("CUST_ID", ((EditText) findViewById(R.id.customer_id)).getText().toString());
////                paramMap.put("CHANNEL_ID", ((EditText) findViewById(R.id.channel_id)).getText().toString());
////                paramMap.put("INDUSTRY_TYPE_ID", ((EditText) findViewById(R.id.industry_type_id)).getText().toString());
////                paramMap.put("WEBSITE", ((EditText) findViewById(R.id.website)).getText().toString());
////                paramMap.put("TXN_AMOUNT", ((EditText) findViewById(R.id.transaction_amount)).getText().toString());
////                paramMap.put("THEME", ((EditText) findViewById(R.id.theme)).getText().toString());
////                paramMap.put("EMAIL", ((EditText) findViewById(R.id.cust_email_id)).getText().toString());
////                paramMap.put("MOBILE_NO", ((EditText) findViewById(R.id.cust_mobile_no)).getText().toString());
//                paramMap.put("ORDER_ID", "20HACK12345");
//                paramMap.put("MID", "PayAdd32357802476407");
//                paramMap.put("CUST_ID", "rahul357");
//                paramMap.put("CHANNEL_ID", "WAP");
//                paramMap.put("INDUSTRY_TYPE_ID", "Retail");
//                paramMap.put("WEBSITE", "AddandPay");
//                paramMap.put("TXN_AMOUNT", "200");
//                paramMap.put("THEME", "merchant");
//
//                PaytmOrder Order = new PaytmOrder(paramMap);
//
//                PaytmMerchant Merchant = new PaytmMerchant(
//                        "https://pguat.paytm.com/paytmchecksum/paytmCheckSumGenerator.jsp",
//                        "https://pguat.paytm.com/paytmchecksum/paytmCheckSumVerify.jsp");
//
//                Service.initialize(Order, Merchant, null);
//
//                Service.startPaymentTransaction(context, true, true,
//                        new PaytmPaymentTransactionCallback() {
//                            @Override
//                            public void someUIErrorOccurred(String inErrorMessage) {
//                                // Some UI Error Occurred in Payment Gateway Activity.
//                                // // This may be due to initialization of views in
//                                // Payment Gateway Activity or may be due to //
//                                // initialization of webview. // Error Message details
//                                // the error occurred.
//                            }
//
//                            @Override
//                            public void onTransactionSuccess(Bundle inResponse) {
//                                // After successful transaction this method gets called.
//                                // // Response bundle contains the merchant response
//                                // parameters.
//                                Log.d("LOG", "Payment Transaction is successful " + inResponse);
//                                Toast.makeText(getApplicationContext(), "Payment Transaction is successful ", Toast.LENGTH_LONG).show();
//                            }
//
//                            @Override
//                            public void onTransactionFailure(String inErrorMessage,
//                                                             Bundle inResponse) {
//                                // This method gets called if transaction failed. //
//                                // Here in this case transaction is completed, but with
//                                // a failure. // Error Message describes the reason for
//                                // failure. // Response bundle contains the merchant
//                                // response parameters.
//                                Log.d("LOG", "Payment Transaction Failed " + inErrorMessage);
//                                Toast.makeText(getBaseContext(), "Payment Transaction Failed ", Toast.LENGTH_LONG).show();
//                            }
//
//                            @Override
//                            public void networkNotAvailable() { // If network is not
//                                // available, then this
//                                // method gets called.
//                            }
//
//                            @Override
//                            public void clientAuthenticationFailed(String inErrorMessage) {
//                                // This method gets called if client authentication
//                                // failed. // Failure may be due to following reasons //
//                                // 1. Server error or downtime. // 2. Server unable to
//                                // generate checksum or checksum response is not in
//                                // proper format. // 3. Server failed to authenticate
//                                // that client. That is value of payt_STATUS is 2. //
//                                // Error Message describes the reason for failure.
//                            }
//
//                            @Override
//                            public void onErrorLoadingWebPage(int iniErrorCode,
//                                                              String inErrorMessage, String inFailingUrl) {
//
//                            }
//
//                            // had to be added: NOTE
//                            @Override
//                            public void onBackPressedCancelTransaction() {
//                                // TODO Auto-generated method stub
//                            }
//
//                        });
//            }
//        });

    }

    public void onStartTransaction(View view) {
        PaytmPGService Service = PaytmPGService.getStagingService();
        Map<String, String> paramMap = new HashMap<String, String>();

        String MID = "WorldP64425807474247";
        String CUST_ID = "PayAdd123454321678";
        String INDUSTRY_TYPE = "Retail";
        String WEBSITE = "worldpressplg";
        String CHANNEL = "WEB";
        String AMOUNT = "30";
        String MOBILE_NO = "7777777777";
        String THEME = "merchant";

        Random r = new Random(System.currentTimeMillis());
        String orderId = "ORDER" + (1 + r.nextInt(2)) * 10000
                + r.nextInt(10000);

        // these are mandatory parameters

        paramMap.put("ORDER_ID", orderId);
        paramMap.put("MID", MID);
        paramMap.put("CUST_ID", CUST_ID);
        paramMap.put("CHANNEL_ID", CHANNEL);
        paramMap.put("INDUSTRY_TYPE_ID", INDUSTRY_TYPE);
        paramMap.put("WEBSITE", WEBSITE);
        paramMap.put("TXN_AMOUNT", AMOUNT);
        paramMap.put("THEME", THEME);
        //paramMap.put("EMAIL", EMAIL);
        paramMap.put("MOBILE_NO", MOBILE_NO);
        paramMap.put("CALLBACK_URL", "https://pguat.paytm.com/paytmchecksum/paytmCheckSumVerify.jsp");
        PaytmOrder Order = new PaytmOrder(paramMap);

        PaytmMerchant Merchant = new PaytmMerchant(
                "https://pguat.paytm.com/paytmchecksum/paytmCheckSumGenerator.jsp",
                "https://pguat.paytm.com/paytmchecksum/paytmCheckSumVerify.jsp");

        Service.initialize(Order, Merchant, null);

        Service.startPaymentTransaction(this, true, true,
                new PaytmPaymentTransactionCallback() {
                    @Override
                    public void someUIErrorOccurred(String inErrorMessage) {
                        // Some UI Error Occurred in Payment Gateway Activity.
                        // // This may be due to initialization of views in
                        // Payment Gateway Activity or may be due to //
                        // initialization of webview. // Error Message details
                        // the error occurred.

                        Log.d("LOG", "Payment Transaction UI Error " + inErrorMessage);
                        Toast.makeText(getApplicationContext(), "Payment Transaction Ui Error ", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onTransactionSuccess(Bundle inResponse) {
                        // After successful transaction this method gets called.
                        // // Response bundle contains the merchant response
                        // parameters.
                        Log.d("LOG", "Payment Transaction is successful " + inResponse);
                        Toast.makeText(getApplicationContext(), "Payment Transaction is successful ", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onTransactionFailure(String inErrorMessage,
                                                     Bundle inResponse) {
                        // This method gets called if transaction failed. //
                        // Here in this case transaction is completed, but with
                        // a failure. // Error Message describes the reason for
                        // failure. // Response bundle contains the merchant
                        // response parameters.
                        Log.d("LOG", "Payment Transaction Failed " + inErrorMessage);
                        Toast.makeText(getBaseContext(), "Payment Transaction Failed ", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void networkNotAvailable() { // If network is not
                        // available, then this
                        // method gets called.

                        Log.d("LOG", "No internet");
                        Toast.makeText(getApplicationContext(), "Please turn On the Internet!!!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void clientAuthenticationFailed(String inErrorMessage) {
                        // This method gets called if client authentication
                        // failed. // Failure may be due to following reasons //
                        // 1. Server error or downtime. // 2. Server unable to
                        // generate checksum or checksum response is not in
                        // proper format. // 3. Server failed to authenticate
                        // that client. That is value of payt_STATUS is 2. //
                        // Error Message describes the reason for failure.
                        Log.d("LOG", "Payment Transaction Auth failed " + inErrorMessage);
                        Toast.makeText(getApplicationContext(), "Payment Auth Failed", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onErrorLoadingWebPage(int iniErrorCode,
                                                      String inErrorMessage, String inFailingUrl) {

                    }

                    // had to be added: NOTE
                    @Override
                    public void onBackPressedCancelTransaction() {
                        // TODO Auto-generated method stub
                    }

                });
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Online_shopping) {
           startActivity(new Intent(HomeActivity.this,ProducerConsumerActivity.class));
        }else if(id == R.id.Analytics){

        }else if(id == R.id.scan){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
