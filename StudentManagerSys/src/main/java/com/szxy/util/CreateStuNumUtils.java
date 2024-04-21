package com.szxy.util;

import java.io.*;
import java.util.Date;

public class CreateStuNumUtils {
	
	public static final String PATH = "src/main/resources/StuNum.dat";
	//测试学号工具
//	public static void main(String[] args) {
//		String id = CreateStuNumUtils.printId();
//		System.out.println("id:>"+id);
//	}
	
	public static int readID(){
		int id = 0;
		
		try(DataInputStream ins = new DataInputStream(new FileInputStream(PATH))){
			
			id = ins.readInt();
			
			createId(id+1);
			
		} catch (FileNotFoundException e) {
			createId(2);
			id = 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			clearFile();
			createId(2);
			id = 1;
		}
		
		return id;
	}
	
	public static void createId(int id){
		
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(PATH))){
			
			dos.writeInt(id);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	public static String printId() {
		int id = readID();
		
		Date date = new Date();
		
		String flag = DateUtil.format(date, "yyyy");
		
		String index = "00000" + id;
		
		index = index.substring(index.length() - 4, index.length());
		
		String e_num = "S" + flag + index;
		
		return e_num;
	}
	
	public static void clearFile(){
		try(DataOutputStream out = new DataOutputStream(new FileOutputStream(PATH))){
			
			out.write("".getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
		}
	}
}
