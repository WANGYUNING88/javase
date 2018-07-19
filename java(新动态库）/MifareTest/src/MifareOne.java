import FunctionClass.FunctionClass.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import org.xvolks.jnative.exceptions.NativeException;
import org.xvolks.jnative.pointers.Pointer;
import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;

public class MifareOne {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JTextArea dataArea = new JTextArea();
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MifareOne window = new MifareOne();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MifareOne() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void output(String s)
	{
		dataArea.setText(dataArea.getText()+s);
	}
	
	@SuppressWarnings("unchecked")
	private void initialize() {
		
		
	/**
	 * The MainWindow UI.
	 */
	frame=new JFrame();
	frame.setBounds(100, 100, 908, 608);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));	
	JTabbedPane tabbedPane=new JTabbedPane(JTabbedPane.TOP);
	frame.getContentPane().add(tabbedPane);
	JPanel panel=new JPanel();
	tabbedPane.addTab("系统设置", null, panel, null);
	JLabel lblPort=new JLabel("端口号");
	lblPort.setBounds(10, 15, 95, 15);
	panel.add(lblPort);
	
	final JComboBox mfPort=new JComboBox<Object>();
	mfPort.setEditable(true);
	mfPort.setModel(new DefaultComboBoxModel<Object>(new String[]{"COM1", "COM2",
			"COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9"}));
	mfPort.setSelectedIndex(1);
	mfPort.setBounds(110, 15, 46, 15);
	panel.add(mfPort);	
	
	JLabel lblBaudRate=new JLabel("波特率");
	lblBaudRate.setBounds(10, 45, 95, 15);
	panel.add(lblBaudRate);	
	
	final JComboBox mfBaudRate=new JComboBox<Object>();
	mfBaudRate.setEditable(true);
	mfBaudRate.setModel(new DefaultComboBoxModel<Object>(new String[]{"9600", "14400",
			"19200", "38400", "115200"}));
	mfBaudRate.setSelectedIndex(2);
	mfBaudRate.setBounds(110, 45, 46, 15);
	panel.add(mfBaudRate);		
	
	JButton btnPortConnect=new JButton("端口连接");
	btnPortConnect.setBounds(302, 10, 131, 25);
	panel.add(btnPortConnect);
	
	JScrollPane scrollPane = new JScrollPane();
	panel.add(scrollPane, BorderLayout.CENTER);	
	dataArea = new JTextArea();
	dataArea.setBounds(100, 40, 200, 400);
	scrollPane.setViewportView(dataArea);
	frame.getContentPane().add(dataArea);
	btnPortConnect.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int intDevice=0;
			int intPort;
			int lngBaudRate;
			intPort=(mfPort.getSelectedIndex()+1);
			lngBaudRate=(int)Integer.parseInt((String)mfBaudRate.getSelectedItem());
			int ret = FunctionClass.RfInitCom(intDevice, intPort, lngBaudRate);
			if(ret == 0)
			{
				output("端口连接成功\n");
			}
			else
			{
				output("端口连接失败\n");
			}	
		}
		
	});
	
	JPanel panel_2=new JPanel();
	tabbedPane.addTab("Mifare One", null, panel_2, null);
	panel_2.setLayout(null);
	
	JLabel lblCardNo=new JLabel("卡号:");
	lblCardNo.setBounds(12, 10, 45, 20);
	panel_2.add(lblCardNo);
	
	final JTextField CardNo=new JTextField();
	CardNo.setBounds(60, 10, 100, 20);
	panel_2.add(CardNo);
	CardNo.setColumns(10);

	JButton btnReadCardNo=new JButton("寻卡");
	btnReadCardNo.setBounds(250,10, 100, 20);
	panel_2.add(btnReadCardNo);
	
	JPanel panel_3= new JPanel();
	panel_3.setBorder(new LineBorder(new Color(100,100,100)));
	panel_3.setBounds(12, 45, 350, 30);
	panel_2.add(panel_3);
	panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
	
	final JRadioButton radioKeyA = new JRadioButton("Key A");
	buttonGroup.add(radioKeyA);
	panel_3.add(radioKeyA);
	radioKeyA.setSelected(true);
	
	final JRadioButton radioKeyB = new JRadioButton("Key B");
	buttonGroup.add(radioKeyB);
	panel_3.add(radioKeyB);	
	
	final JTextField strKey=new JTextField();
	strKey.setBounds(150, 55, 100, 20);
	strKey.setText("FFFFFFFFFFFF");
	panel_3.add(strKey);
	
	JLabel lblBlock=new JLabel();
	lblBlock.setBounds(12, 90, 100, 20);
	lblBlock.setText("请选择块号");
	panel_2.add(lblBlock);
	
	final JComboBox cboBlockNo=new JComboBox();
	cboBlockNo.setEditable(true);
	for(int i=0;i<64;i++)
		{cboBlockNo.addItem(i);}
	cboBlockNo.setBounds(100, 90, 45, 20);
	cboBlockNo.setSelectedIndex(0);
	panel_2.add(cboBlockNo);
	
	JButton btnReadBlock=new JButton();
	btnReadBlock.setBounds(250, 90, 100, 20);
	btnReadBlock.setText("读块");
	panel_2.add(btnReadBlock);
	
	JLabel lblblockData=new JLabel();
	lblblockData.setBounds(12, 130, 80, 20);
	lblblockData.setText("读写块数据");
	panel_2.add(lblblockData);
	
	final JTextField txtBlockData= new JTextField();
	txtBlockData.setBounds(100, 130, 250, 20);
	panel_2.add(txtBlockData);
	
	JButton btnWriteBlock=new JButton();
	btnWriteBlock.setBounds(250, 165, 100, 20);
	btnWriteBlock.setText("写块");
	panel_2.add(btnWriteBlock);
	
	
	btnReadCardNo.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int icdev=0;
			byte mode=0x52;
			byte bcnt=0x04;
			int ret = FunctionClass.MF_Request(icdev, mode);
			if(ret == 0)
			{
				output("寻卡成功\n");
				for ( int i = 0 ; i < 2 ; i ++)
				{
					try {
						output(String.format("%02X", FunctionClass.b.getAsByte(i))+" ");
					} catch (NativeException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			else
			{
				output("寻卡失败\n");
			}
			output("\n");
			ret = FunctionClass.MF_RF_Anticoll(icdev, bcnt);
			if(ret == 0)
			{
				output("防冲突成功\n");
				String sCardNo="";
				try {
					for ( int i = 0 ; i < FunctionClass.d.getAsByte(0) ; i ++)
					{
						try {
							output(String.format("%02X", FunctionClass.b.getAsByte(i))+" ");
							sCardNo=sCardNo+String.format("%02X", FunctionClass.b.getAsByte(i))+" ";
						} catch (NativeException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					CardNo.setText(sCardNo);
				} catch (NativeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else
			{
				output("防冲突失败\n");
			}
			output("\n");
			ret = FunctionClass.MF_RF_Select(icdev, FunctionClass.b,bcnt);
			if(ret == 0)
			{
				output("选卡成功\n");
				for ( int i = 0 ; i < 2 ; i ++)
				{
					try {
						output(String.format("%02X", FunctionClass.d.getAsByte(i))+" ");
					} catch (NativeException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			else
			{
				output("选卡失败\n");
			}
			output("\n");
		}
		});
	btnReadBlock.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			int icdev=0;
			byte mode=0x60;			
			String sData;
			sData="";
			if (radioKeyA.isSelected())
				mode=0x60;
			else
				mode=0x61;
			byte block = (byte)cboBlockNo.getSelectedIndex();			
			String strKeyValue = strKey.getText();
			output(strKeyValue);
			if (strKeyValue.length()!=12 )
				{
					output("密钥长度不正确\n");
					return;
				}
			Pointer pKey = null ;
			try {
				pKey = new Pointer(MemoryBlockFactory.createMemoryBlock(20));
			} catch (NativeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (int  i = 0 ; i < 6 ; i ++)
			{
				byte value = (byte)Integer.parseInt(strKeyValue.substring(2 * i , 2 * i + 2),16);
				try {
					pKey.setByteAt(i, value);
				} catch (NativeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			int ret = FunctionClass.MF_RF_Auth(icdev,mode,block,pKey);
			if(ret == 0)
			{
				output("外部认证成功\n");
			}
			else
			{
				output("外部认证失败\n");
			}
			output("\n");		
			
			ret = FunctionClass.MF_RF_Read(icdev,block);
			if(ret == 0)
			{
				for ( int i = 0 ; i < 16 ; i ++)
				{
					try {
						output(String.format("%02X", FunctionClass.a.getAsByte(i))+" ");
						sData=sData+String.format("%02X", FunctionClass.a.getAsByte(i));
					} catch (NativeException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}			
				txtBlockData.setText(sData);
				output("读块"+String.valueOf(block)+"成功\n");
			}
			else
			{
				output("读块"+String.valueOf(block)+"失败\n");
			}
			output("\n");	
		}
	});
	
	btnWriteBlock.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int icdev=0;
			byte mode=0x60;			
			String sData;
			sData="";
			if (radioKeyA.isSelected())
				mode=0x60;
			else
				mode=0x61;
			byte block = (byte)cboBlockNo.getSelectedIndex();	
			if (block%4==3)
			{
				int iChoose=JOptionPane.showConfirmDialog(null, "此块为密钥块，写不正确会将整个扇区锁死，确定要写入吗？", "提示", JOptionPane.YES_NO_OPTION);
				if (iChoose!=JOptionPane.YES_OPTION)
				{
					output("您选择了退出操作\n");
					return;			
				}
			}
			String strKeyValue = strKey.getText();
			output(strKeyValue);
			if (strKeyValue.length()!=12 )
				{
					output("密钥长度不正确\n");
					return;
				}
			Pointer pKey = null ;
			try {
				pKey = new Pointer(MemoryBlockFactory.createMemoryBlock(20));
			} catch (NativeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (int  i = 0 ; i < 6 ; i ++)
			{
				byte value = (byte)Integer.parseInt(strKeyValue.substring(2 * i , 2 * i + 2),16);
				try {
					pKey.setByteAt(i, value);
				} catch (NativeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			int ret = FunctionClass.MF_RF_Auth(icdev,mode,block,pKey);
			if(ret == 0)
			{
				output("外部认证成功\n");
			}
			else
			{
				output("外部认证失败\n");
			}
			output("\n");		
			
			String strWriteData = txtBlockData.getText();
			if (strWriteData.length()!=32 )
				{   
					output("数据长度不正确\n");
					return;
				}
			Pointer pData = null ;
			try {
				pData = new Pointer(MemoryBlockFactory.createMemoryBlock(50));
			} catch (NativeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (int  i = 0 ; i < 16 ; i ++)
			{
				byte value = (byte)Integer.parseInt(strWriteData.substring(2 * i , 2 * i + 2),16);
				try {
					pData.setByteAt(i, value);
				} catch (NativeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}			
			ret = FunctionClass.MF_RF_Write(icdev,block,pData);
			if(ret == 0)
			{	
				output("写块"+String.valueOf(block)+"成功\n");
			}
			else
			{
				output("写块"+String.valueOf(block)+"失败\n");
			}
			output("\n");				
		}
	});
	}
}
