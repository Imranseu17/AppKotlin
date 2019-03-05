package infixsoft.imrankst1221.printer;

/**
 * Created by https://goo.gl/UAfmBd on 2/6/2017.
 */
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends Activity{
    private String TAG = "Main Activity";
    private RelativeLayout activity_main;
    EditText message;
    Button btnPrint, btnBill, btnDonate;
    private Bitmap bitmap = null;

    byte FONT_TYPE;
    private static BluetoothSocket btsocket;
    private static OutputStream outputStream;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity_main = (RelativeLayout) findViewById(R.id.activity_main);
        message = (EditText)findViewById(R.id.txtMessage);
        btnPrint = (Button)findViewById(R.id.btnPrint);
        btnBill = (Button)findViewById(R.id.btnBill);
        btnDonate = (Button)findViewById(R.id.btnDonate);

        //bitmap = getBitmapFromView(activity_main);


        btnPrint.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                printDemo();
            }
        });
        btnBill.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                printBill();
            }
        });
        btnDonate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.paypal_me)));
                startActivity(browserIntent);
            }
        });

    }


    protected void printBill() {
        if(btsocket == null){
            Intent BTIntent = new Intent(getApplicationContext(), DeviceList.class);
            this.startActivityForResult(BTIntent, DeviceList.REQUEST_CONNECT_BT);
        }
        else{
            OutputStream opstream = null;
            try {
                opstream = btsocket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            outputStream = opstream;

            //print command
            try {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputStream = btsocket.getOutputStream();
                byte[] printformat = new byte[]{0x1B,0x21,0x03};
                outputStream.write(printformat);

                String dateTime[] = getDateTime();
                printCustom("Money Receipt",2,1);
                printCustom(new String(new char[42]).replace("\0", "."),0,1);
                printCustom(getFormatStringByLength("Date and Time.",dateTime[0]+" "+dateTime[1]),4,0);
                printCustom(getFormatStringByLength("Transaction No.","1808166"),4,1);
                printCustom(getFormatStringByLength("Customer Name.","Mr.Imran Khan"),4,0);
                printCustom(getFormatStringByLength("Customer Code","2001NM-103624"),4,0);
                //printCustom(getFormatStringByLength("Meter No.","56899"),4,1);
                printCustom(getFormatStringByLength("Card No.","012E3D121D982E5F"),4,0);
                printCustom(getFormatStringByLength("POS Name","KGDCL HEAD OFFICE"),4,0);
                printCustom(getFormatStringByLength("Operator Name","Kafi"),4,0);
                printNewLine();
                printCustom(new String(new char[42]).replace("\0", "."),0,0);
                printCustom(getFormatStringByLength("Deposit Amount(TK)","1,000.00"),4,0);
                printCustom(getFormatStringByLength("Previous Balance(TK)","Kafi"),4,0);
                printCustom(getFormatStringByLength("Current Balance(TK)","Kafi"),4,0);
                printNewLine();
                printCustom(new String(new char[42]).replace("\0", "."),0,0);
                printCustom(getFormatStringByLength("Meter Rent(TK)","120.00"),4,0);
                printCustom(getFormatStringByLength("Other Charges(TK)","0.00"),4,0);
                printCustom(getFormatStringByLength("Gas Recharge(TK)","880.00"),4,0);
                printCustom(getFormatStringByLength("Gas Volume (m3)","96.70"),4,0);
                printNewLine();
                printCustom(new String(new char[42]).replace("\0", "."),0,1);
                printCustom("Customer Support <>",1,1);
                printCustom("Karnaphuli Gas Distribution Company Ltd.",1,1);
                printNewLine();
                printNewLine();
                printNewLine();

//                String dateTime[] = getDateTime();
//                printCustom("Money Receipt",3,1);
//                printCustom(new String(new char[40]).replace("\0", "."),0,1);
//                printCustom(getFormatStringByLength("Date and Time.",dateTime[0]+" "+dateTime[1]),4,1);
//                printCustom(getFormatStringByLength("Transaction No.","1808166"),4,1);
//                printCustom(getFormatStringByLength("Customer Name.","Mr.Imran Khan"),4,1);
//                printNewLine();
//                printNewLine();
//                printNewLine();


//                  String dateTime[] = getDateTime();
//                  printCustom("Money Receipt",3,1);
//                  printCustom(new String(new char[40]).replace("\0", "."),0,1);
//                  printCustom(getFormatStringByLength("Date and Time.",dateTime[0]+dateTime[1],24),4,0);
//                  printCustom(getFormatStringByLength("Transaction No.","1808166",31),4,0);
//                  printCustom(getFormatStringByLength("Customer Name.","Mr.Imran Khan",26),4,0);
//                  printNewLine();
//                  printNewLine();
//                  printNewLine();

//                printCustom(getFormatStringByLength("Card No.","012E3D121D982E5F",20),4,4);
//                printCustom("Fair Group BD",2,1);
//                printCustom("Pepperoni Foods Ltd.",0,1);
//                printPhoto(R.drawable.ic_icon_pos);
//                printCustom("H-123, R-123, Dhanmondi, Dhaka-1212",0,1);
//                printCustom("Hot Line: +88000 000000",0,1);
//                printCustom("Vat Reg : 0000000000,Mushak : 11",0,1);
//                String dateTime[] = getDateTime();
//                printText(leftRightAlign(dateTime[0], dateTime[1]));
//                printText(leftRightAlign("Qty: Name" , "Price "));
//                printCustom(new String(new char[32]).replace("\0", "."),0,1);
//                printText(leftRightAlign("Total" , "2,0000/="));
//                printNewLine();
//                printCustom("Thank you for coming & we look",0,1);
//                printCustom("forward to serve you again",0,1);
//                printNewLine();
//                printNewLine();

                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void printDemo() {
        if(btsocket == null){
            Intent BTIntent = new Intent(getApplicationContext(), DeviceList.class);
            this.startActivityForResult(BTIntent, DeviceList.REQUEST_CONNECT_BT);
        }
        else{
            OutputStream opstream = null;
            try {
                opstream = btsocket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            outputStream = opstream;

            //print command
            try {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputStream = btsocket.getOutputStream();

                byte[] printformat = { 0x1B, 0*21, FONT_TYPE };
                //outputStream.write(printformat);

                //print title
                printUnicode();
                //print normal text
                printCustom(message.getText().toString(),0,0);
                printPhoto(R.drawable.img);
                printNewLine();
                printText("     >>>>   Thank you  <<<<     "); // total 32 char in a single line
                //resetPrint(); //reset printer
                printUnicode();
                printNewLine();
                printNewLine();

                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //print custom
    private void printCustom(String msg, int size, int align) {
        //Print config "mode"
        byte[] cc = new byte[]{0x1B,0x21,0x03};  // 0- normal size text
        //byte[] cc1 = new byte[]{0x1B,0x21,0x00};  // 0- normal size text
        byte[] bb = new byte[]{0x1B,0x21,0x08};  // 1- only bold text
        byte[] bb2 = new byte[]{0x1B,0x21,0x20}; // 2- bold with medium text
        byte[] bb3 = new byte[]{0x1B,0x21,0x10}; // 3- bold with large text
        try {
            switch (size){
                case 0:
                    outputStream.write(cc);
                    break;
                case 1:
                    outputStream.write(bb);
                    break;
                case 2:
                    outputStream.write(bb2);
                    break;
                case 3:
                    outputStream.write(bb3);
                    break;
                case 4:
                    outputStream.write(cc);
                    break;
            }

            switch (align){
                case 0:
                    //left align
                    outputStream.write(PrinterCommands.ESC_ALIGN_LEFT);
                    break;
                case 1:
                    //center align
                    outputStream.write(PrinterCommands.ESC_ALIGN_CENTER);
                    break;
                case 2:
                    //right align
                    outputStream.write(PrinterCommands.ESC_ALIGN_RIGHT);
                    break;
                case 4:
                    //right align
                    outputStream.write(PrinterCommands.ESC_ALIGN_CENTER);
                    break;
            }
            outputStream.write(msg.getBytes());
            outputStream.write(PrinterCommands.LF);
            StringBuilder sb = new StringBuilder();
            //outputStream.write(cc);
            //printNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //print photo
    public void printPhoto(int img) {
        try {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(),
                    img);
            if(bmp!=null){
                byte[] command = Utils.decodeBitmap(bmp);
                outputStream.write(PrinterCommands.ESC_ALIGN_CENTER);
                printText(command);
            }else{
                Log.e("Print Photo error", "the file isn't exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("PrintTools", "the file isn't exists");
        }
    }

    //print unicode
    public void printUnicode(){
        try {
            outputStream.write(PrinterCommands.ESC_ALIGN_CENTER);
            printText(Utils.UNICODE_TEXT);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //print new line
    private void printNewLine() {
        try {
            outputStream.write(PrinterCommands.FEED_LINE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void resetPrint() {
        try{
            outputStream.write(PrinterCommands.ESC_FONT_COLOR_DEFAULT);
            outputStream.write(PrinterCommands.FS_FONT_ALIGN);
            outputStream.write(PrinterCommands.ESC_ALIGN_LEFT);
            outputStream.write(PrinterCommands.ESC_CANCEL_BOLD);
            outputStream.write(PrinterCommands.LF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //print text
    private void printText(String msg) {
        try {
            // Print normal text
            outputStream.write(msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //print byte[]
    private void printText(byte[] msg) {
        try {
            // Print normal text
            outputStream.write(msg);
            printNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String leftRightAlign(String str1, String str2) {
        String ans = str1 +str2;
        if(ans.length() <31){
            int n = (31 - str1.length() + str2.length());
            ans = str1 + new String(new char[n]).replace("\0", " ") + str2;
        }
        return ans;
    }

    private String getFormatStringByLength(String title, String value){
        String concatenation = title+value;
        int count = concatenation.length();
        StringBuilder builder = new StringBuilder();
       // String padded = String.format("%1$-"+(54-count)+"s", title);
        // Our result.
        String space = new String(new char[42-count]).replace("\0", " ");
        builder.append(title);
        builder.append(space);
        builder.append(value);
        return builder.toString();
    }


    private String[] getDateTime() {
        final Calendar c = Calendar.getInstance();
        String dateTime [] = new String[2];
        dateTime[0] = c.get(Calendar.DAY_OF_MONTH) +"/"+ c.get(Calendar.MONTH) +"/"+ c.get(Calendar.YEAR);
        dateTime[1] = c.get(Calendar.HOUR_OF_DAY) +":"+ c.get(Calendar.MINUTE);
        return dateTime;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            if(btsocket!= null){
                outputStream.close();
                btsocket.close();
                btsocket = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            btsocket = DeviceList.getSocket();
            if(btsocket != null){
                printText(message.getText().toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}