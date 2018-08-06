package com.serialport;

public class PSAMAPI {
	//******** ���ܣ���ö�̬��汾�� *******************/
	//  ������fd��  ���ھ��
	//        nDevice��  ͨѶ�豸��ʶ��
	//        Ver�����صİ汾�ţ�ռ��4���ֽ�
	//  ���أ��ɹ��򷵻�1
	//******************************************************/  
    public native int rfLibVer(int fd,byte Ver[]);
  
	//******** ���ܣ��򿪹رյ�Դ*******************/
	//  ������sPowerDev��  �豸������
	//        nOnOff��  =1 �򿪵�Դ   =0 �رյ�Դ
	//  ���أ��ɹ��򷵻�1
	//******************************************************/  
    
	public native int rfPower(String sPowerDev, int nOnOff);  
    
	//******** ���ܣ���ʼ������ *******************/
	//  ������fd��  ���ھ��
	//        nDevice��  ͨѶ�豸��ʶ��=0
	//        sPort�������ַ���
    //        nBaud��������  ��19200��38400��115200��
    //               ע�⣺ģ����߶������ϵ�Ĭ�ϲ�����ӦΪ��3�ֵ�һ��
	//  ���أ��ɹ��򷵻�1
	//******************************************************/  
    
	public native int rfInitCom(String sPort, int nBaud);  
	
	//******** ���ܣ��رմ��� *******************/
	//  ������fd��  ���ھ��
	//        nDevice��  ͨѶ�豸��ʶ��=0
	//  ���أ��ɹ��򷵻�1
	//*******************************************************/  
	public native int rfClosePort(int fd);	
	
	//*******  ���ܣ�SAM��ʼ�� ****************/
	//  ������fd��  ���ھ��
	//        nDevice��  ͨѶ�豸��ʶ��
	//  Frequency��  SAM������Ƶ���޸ģ�ֻ����1M��2M��3M��4M��6M��12M��Ĭ����4M
	//  ���أ��ɹ��򷵻�1
	//*********************************************************/	
	public native int rfInitSam(int fd,byte Frequency);	

	//*******  ���ܣ���λsam �� ****************/
	//  ������fd��  ���ھ��
	//        nDevice��  ͨѶ�豸��ʶ��
	//        pData�����صĸ�λ��Ϣ
	//        pMsgLg�����صĳ���
	//  ���أ��ɹ��򷵻�1
	//*********************************************************/
	public native int rfSamRst(int fd,byte pPara[],byte cParaLen,byte pData[],byte pMsgLg[]);
	
	//*******  ���ܣ���SAM ������COS ����  ****************/
	//  ������fd��  ���ھ��
	//        nDevice��  ͨѶ�豸��ʶ��
	//        command��  COS����
	//        cmdLen��COS�����
	//        pData����Ƭ���ص����ݣ���SW1��SW2
	//        pMsgLg�����صĳ���
	//  ���أ��ɹ��򷵻�1
	//*********************************************************/	
	public native int rfSamCos(int fd,byte command[],byte cmdLen,byte pData[],int pMsgLg[]);	
	
	
	static {
        System.loadLibrary("PSAMAPI");
    }
}
