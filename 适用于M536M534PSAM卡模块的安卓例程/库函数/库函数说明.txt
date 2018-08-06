package com.serialport;

public class PSAMAPI {
	//******** 功能：获得动态库版本号 *******************/
	//  参数：fd：  串口句柄
	//        nDevice：  通讯设备标识符
	//        Ver：返回的版本号，占用4个字节
	//  返回：成功则返回1
	//******************************************************/  
    public native int rfLibVer(int fd,byte Ver[]);
  
	//******** 功能：打开关闭电源*******************/
	//  参数：sPowerDev：  设备描述符
	//        nOnOff：  =1 打开电源   =0 关闭电源
	//  返回：成功则返回1
	//******************************************************/  
    
	public native int rfPower(String sPowerDev, int nOnOff);  
    
	//******** 功能：初始化串口 *******************/
	//  参数：fd：  串口句柄
	//        nDevice：  通讯设备标识符=0
	//        sPort：串口字符串
    //        nBaud：波特率  （19200，38400，115200）
    //               注意：模块或者读卡器上电默认波特率应为这3种的一种
	//  返回：成功则返回1
	//******************************************************/  
    
	public native int rfInitCom(String sPort, int nBaud);  
	
	//******** 功能：关闭串口 *******************/
	//  参数：fd：  串口句柄
	//        nDevice：  通讯设备标识符=0
	//  返回：成功则返回1
	//*******************************************************/  
	public native int rfClosePort(int fd);	
	
	//*******  功能：SAM初始化 ****************/
	//  参数：fd：  串口句柄
	//        nDevice：  通讯设备标识符
	//  Frequency：  SAM卡工作频率修改，只能是1M，2M，3M，4M，6M，12M，默认是4M
	//  返回：成功则返回1
	//*********************************************************/	
	public native int rfInitSam(int fd,byte Frequency);	

	//*******  功能：复位sam 卡 ****************/
	//  参数：fd：  串口句柄
	//        nDevice：  通讯设备标识符
	//        pData：返回的复位信息
	//        pMsgLg：返回的长度
	//  返回：成功则返回1
	//*********************************************************/
	public native int rfSamRst(int fd,byte pPara[],byte cParaLen,byte pData[],byte pMsgLg[]);
	
	//*******  功能：向SAM 卡发送COS 命令  ****************/
	//  参数：fd：  串口句柄
	//        nDevice：  通讯设备标识符
	//        command：  COS命令
	//        cmdLen：COS命令长度
	//        pData：卡片返回的数据，含SW1、SW2
	//        pMsgLg：返回的长度
	//  返回：成功则返回1
	//*********************************************************/	
	public native int rfSamCos(int fd,byte command[],byte cmdLen,byte pData[],int pMsgLg[]);	
	
	
	static {
        System.loadLibrary("PSAMAPI");
    }
}
