package FunctionClass.FunctionClass;
import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.pointers.Pointer;
import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;

public class FunctionClass {
	public static Pointer a,b,c,d;
	public static int MF_Halt(int arg0)
	{
		JNative n = null;   
        try {              
            n = new JNative("MasterRDnew.dll", "rf_halt");   
            n.setRetVal(Type.INT);
            n.setParameter(0, arg0);
            n.invoke();
            return Integer.parseInt(n.getRetVal());
        } catch(Exception e) {
        	System.out.print("Failed");
        	return 1;
        }
	}
	public static int RfInitCom(int icdev , int comPort,int comBaudRate)
	{
		JNative n = null;   
        try {              
            n = new JNative("MasterRDnew.dll", "rf_init_com");   
            n.setRetVal(Type.INT);
            n.setParameter(0,icdev);
            n.setParameter(1, comPort);
            n.setParameter(2,comBaudRate);
            n.invoke();
            return Integer.parseInt(n.getRetVal());
        } catch(Exception e) {
        	System.out.print("Failed");
        	return 1;
        }
	}
	public static int ControlLED(int arg0 , int arg1)
	{
		JNative n = null;   
        try {              
            n = new JNative("MasterRDnew.dll", "rf_light");   
            n.setRetVal(Type.INT);
            n.setParameter(0,arg0);
            n.setParameter(1, arg1);
            n.invoke();
            return Integer.parseInt(n.getRetVal());
        } catch(Exception e) {
        	System.out.print("Failed");
        	return 1;
        }
	}
	//蜂鸣器控制
	//输入：参数1，设备标识符
	//      参数2,声音长短00-ff
	public static int ControlBuzzer(int arg0 , int arg1)
	{
		JNative n = null;   
        try {              
            n = new JNative("MasterRDnew.dll", "rf_beep");   
            n.setRetVal(Type.INT);
            n.setParameter(0,arg0);
            n.setParameter(1,arg1);
            n.invoke();
            return Integer.parseInt(n.getRetVal());
        } catch(Exception e) {
        	System.out.print("Failed");
        	return 1;
        }
	}
	public static int MF_Request(int icdev,byte mode)
	{
		JNative n = null;   
        try {              
            n = new JNative("MasterRDnew.dll", "rf_request");   
            n.setRetVal(Type.INT);
            n.setParameter(0,icdev);
            n.setParameter(1, mode);
            a = new Pointer(MemoryBlockFactory.createMemoryBlock(10));     
            n.setParameter(2,a);
            n.invoke();
            b = a;
            return Integer.parseInt(n.getRetVal());
        } catch(Exception e) {
        	System.out.print("Failed");
        	return 1;
        }
	}	
	public static int MF_RF_Anticoll(int icdev,byte bcnt)
	{
		JNative n = null;   
        try {              
            n = new JNative("MasterRDnew.dll", "rf_anticoll");   
            n.setRetVal(Type.INT);
            n.setParameter(0,icdev);
            n.setParameter(1, bcnt);
            a = new Pointer(MemoryBlockFactory.createMemoryBlock(10));
            c = new Pointer(MemoryBlockFactory.createMemoryBlock(10));
            n.setParameter(2,a);
            n.setParameter(3,c);
            n.invoke();
            b = a;
            d = c;
            return Integer.parseInt(n.getRetVal());
        } catch(Exception e) {
        	System.out.print("Failed");
        	return 1;
        }
	}
	public static int MF_RF_Select(int icdev,Pointer p,byte len)
	{
		JNative n = null;   
        try {              
            n = new JNative("MasterRDnew.dll", "rf_select");   
            n.setRetVal(Type.INT);
            n.setParameter(0,icdev);
            n.setParameter(1, p);
            n.setParameter(2,len);
            c = new Pointer(MemoryBlockFactory.createMemoryBlock(10));
            n.setParameter(3,c);
            n.invoke();
            d=c;
            return Integer.parseInt(n.getRetVal());
        } catch(Exception e) {
        	System.out.print("Failed");
        	return 1;
        }
	}
	public static int MF_RF_Auth(int icdev,byte model,byte block, Pointer p)
	{
		JNative n = null;   
        try {              
            n = new JNative("MasterRDnew.dll", "rf_M1_authentication2");   
            n.setRetVal(Type.INT);
            n.setParameter(0,icdev);
            n.setParameter(1, model);
            n.setParameter(2,block);
            n.setParameter(3,p);
            n.invoke();
            return Integer.parseInt(n.getRetVal());
        } catch(Exception e) {
        	System.out.print("Failed");
        	return 1;
        }
	}
	public static int MF_RF_Read(int icdev,byte block)
	{
		JNative n = null;   
        try {              
            n = new JNative("MasterRDnew.dll", "rf_M1_read");   
            n.setRetVal(Type.INT);
            n.setParameter(0,icdev);
            n.setParameter(1, block);
            a= new Pointer(MemoryBlockFactory.createMemoryBlock(50));
            c= new Pointer(MemoryBlockFactory.createMemoryBlock(10));
            n.setParameter(2,a);
            n.setParameter(3,c);
            n.invoke();
            b=a;
            d=c;
            return Integer.parseInt(n.getRetVal());
        } catch(Exception e) {
        	System.out.print("Failed");
        	return 1;
        }
	}	
	public static int MF_RF_Write(int icdev,byte block,Pointer p)
	{
		JNative n = null;   
        try {              
            n = new JNative("MasterRDnew.dll", "rf_M1_write");   
            n.setRetVal(Type.INT);
            n.setParameter(0,icdev);
            n.setParameter(1, block);
            n.setParameter(2,p);
            n.invoke();
            return Integer.parseInt(n.getRetVal());
        } catch(Exception e) {
        	System.out.print("Failed");
        	return 1;
        }
	}		
}