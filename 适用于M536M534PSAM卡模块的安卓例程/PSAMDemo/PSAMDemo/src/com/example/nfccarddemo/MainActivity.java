package com.example.nfccarddemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.app.Application;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.serialport.PSAMAPI;
import android.widget.Button;


public class MainActivity extends Activity {
	
	//声明库函数
	final int TRUE = 1;
	final int FALSE = 0;

			
	public PSAMAPI mPSAMAPI=new PSAMAPI() ; 
	
	Button btnOpenCom;
	Button btnCloseCom;
	Button btnPowerUp;
	Button btnPowerDown;
	Button btnPSAMRst;
	Button btnPSAMCOS;
	Button btnClear;
	Button btnGetVer1;
	
	EditText etComNo;
	EditText etBaud;
	EditText etSAMNo1;
	EditText etCosInput1;
	EditText etResult1;
	
	TextView tvInfo;
	TextView tvResult;
	static int nfd=0;
	static int nPowerSta=0;
	static int nIsOpenCom=0;
	int nStatus=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_main);
		 
		initDlg();   //后面补充内容，先空着
		//globalVar.setFd(1);
		//globalVar.setIsComOpen(1);
	}

	public void rfInitComFun()
	{
		//nfd=mPSAMAPI.rfInitCom("/dev/ttyS2", 19200);	
		nfd=mPSAMAPI.rfInitCom("/dev/"+etComNo.getText().toString().replace(" ", ""),Integer.parseInt(etBaud.getText().toString().replace(" ", "")));
		if(nfd>0)
		{	
			nIsOpenCom=1;
			tvInfo.setText(R.string.open_com_OK);
		}
		else
		{
			nIsOpenCom=0;
			tvInfo.setText(R.string.open_com_Err);
		}
	}
	public void rfClosePortFun() {
		if(nIsOpenCom==0)
		{
			tvInfo.setText(R.string.btIsComOpen);
			return;
		}
		nStatus = mPSAMAPI.rfClosePort(nfd);
		if(nStatus==TRUE)
		{
			tvInfo.setText(R.string.close_com_OK);
		}
		else
		{
			tvInfo.setText(R.string.close_com_Err);
		}
	}
	public void rfPowerUpFun()
	{
		nPowerSta=mPSAMAPI.rfPower("/proc/devicepower/rfidpower", 1);
		if(nPowerSta>0)
		{	
			tvInfo.setText("打开电源成功");
		}
		else
		{
			tvInfo.setText("打开电源失败");
		}
	}
	public void rfPowerDownFun()
	{
		nPowerSta=mPSAMAPI.rfPower("/proc/devicepower/rfidpower", 0);
		if(nPowerSta>0)
		{	
			tvInfo.setText("关闭电源成功");
		}
		else
		{
			tvInfo.setText("关闭电源失败");
		}
	}
	public void rfSAMRstFun() 
	{
		if(nIsOpenCom==0)
		{
			tvInfo.setText(R.string.btIsComOpen);
			return;
		}
		byte[] pPara=new byte[100];
		byte[] pData=new byte[100];
		byte[] pMsgLg=new byte[1];
		
		byte[] cSAMNo = StringToByteArray(etSAMNo1.getText().toString());
		pPara[0]=(byte) (0x00 + cSAMNo[0]* 16);
		etResult1.setText("");
		nStatus = mPSAMAPI.rfSamRst(nfd,pPara, (byte)(1), pData, pMsgLg);
		if(nStatus==TRUE) 
		{
			tvInfo.setText(R.string.RfReset_OK);
			etResult1.setText(ByteArrayToString(pData,pMsgLg[0]));
		}
		else
		{
			tvInfo.setText(R.string.RfReset_Err);
		}
	}
	public void rfCosCommandFun() {
		if(nIsOpenCom==0)
		{
			tvInfo.setText(R.string.btIsComOpen);
			return;
		}
		byte[] pData=new byte[300];
		int[] pMsgLg=new int[1];
		byte[] command = StringToByteArray(etSAMNo1.getText().toString()+ etCosInput1.getText().toString());
		nStatus = mPSAMAPI.rfSamCos(nfd, command, (byte)(command.length), pData, pMsgLg);
		if(nStatus==TRUE)
		{
			tvInfo.setText(R.string.RfCosSend_OK);
			etResult1.setText(ByteArrayToString(pData,pMsgLg[0]));
		}
		else
		{
			tvInfo.setText(R.string.RfCosSend_Err);
		}
	}
	
	public void rfLibVerFun() {
		if(nIsOpenCom==0)
		{
			tvInfo.setText(R.string.btIsComOpen);
			return;
		}
		byte[] Ver=new byte[4];
		nStatus = mPSAMAPI.rfLibVer(nfd,Ver);
		if(nStatus==TRUE)
		{
			tvInfo.setText(R.string.RfGetVer_OK);
			etResult1.setText(ByteArrayToString(Ver,4));
		}
		else
		{
			tvInfo.setText(R.string.RfGetVer_Err);
		}
	}

	OnClickListener onClick=new OnClickListener()
	{
		public void onClick(View v) {
			switch (v.getId()){
			case R.id.btnOpenCom:
				rfInitComFun();
				break;
			case R.id.btnCloseCom:
				rfClosePortFun();
				break;
			case R.id.btnPowerUp:
				rfPowerUpFun();
				break;
			case R.id.btnPowerDown:
				rfPowerDownFun();
				break;
			case R.id.btnReset:
				rfSAMRstFun();
				break;
			case R.id.btnSendCos:
				rfCosCommandFun();
				break;
				
			case R.id.btnGetVer:
				rfLibVerFun();
				break;
				
				/*
			case R.id.btnOpenCom:
				
				break;*/
			}
		}
		
	};
	public void initDlg(){
		initButton();
		initTextView();
		initEditText();
	}
	public void initTextView(){
		tvInfo = (TextView)findViewById(R.id.TextViewInfo);
		tvResult = (TextView)findViewById(R.id.tvResult);
	}	
	public void initEditText(){
		etComNo=(EditText)findViewById(R.id.etComNo);
		etBaud=(EditText)findViewById(R.id.etBaud);		
		etSAMNo1=(EditText)findViewById(R.id.etSAMNo);
		etCosInput1=(EditText)findViewById(R.id.etCosInput);
		etResult1=(EditText)findViewById(R.id.etResult);
	}	
	public void initButton(){
        btnOpenCom = (Button) findViewById(R.id.btnOpenCom);
        btnOpenCom.setOnClickListener(onClick);
        
        btnCloseCom = (Button) findViewById(R.id.btnCloseCom);
        btnCloseCom.setOnClickListener(onClick);    
        
        btnPowerUp = (Button) findViewById(R.id.btnPowerUp);
        btnPowerUp.setOnClickListener(onClick);  
        
        btnPowerDown = (Button) findViewById(R.id.btnPowerDown);
        btnPowerDown.setOnClickListener(onClick);  
        
        btnPSAMRst = (Button) findViewById(R.id.btnReset);
        btnPSAMRst.setOnClickListener(onClick);  
        
        btnPSAMCOS = (Button) findViewById(R.id.btnSendCos);
        btnPSAMCOS.setOnClickListener(onClick);  
        
        btnGetVer1 = (Button) findViewById(R.id.btnGetVer);
        btnGetVer1.setOnClickListener(onClick);  
        
        
	}

	public String ByteArrayToString(byte[] bt_ary,int len) {
        StringBuilder sb = new StringBuilder();
        int i;
        if (bt_ary != null)
        	if(len<bt_ary.length)
        	{
	        	for(i=0;i<len;i++)
	        	{
	        		sb.append(String.format("%02X ",bt_ary[i]));
	        	}
        	}
        	else
        	{
	            for (byte b : bt_ary) {
	                sb.append(String.format("%02X ", b));
	            }
        	}
        return sb.toString();
    }
	public byte[] StringToByteArray(String str) {
		str=str.replaceAll(" ","");
		int n=str.length()/2;
        String[] str_ary = new String[n];
        for(int i=0;i<n;i++)
        {
        	str_ary[i]=str.substring(i * 2, i * 2 + 2);
        }
        byte[] bt_ary = new byte[n];
        for (int i = 0; i < n; i++)
            bt_ary[i] = (byte)Integer.parseInt(str_ary[i], 16) ;
        return bt_ary;
    }

}
