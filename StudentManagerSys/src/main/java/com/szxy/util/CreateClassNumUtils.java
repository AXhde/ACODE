package com.szxy.util;

import java.io.*;
import java.util.Date;

public class CreateClassNumUtils {
	
	public static final String PATH = "src/main/resources/ClassNum.dat";
	//测试生成班级编号工具
	public static void main(String[] args) {
		String id = CreateClassNumUtils.printId();
		System.out.println("id:>"+id);
	}
	
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
		
		String index = "000" + id;
		
		index = index.substring(index.length() - 3, index.length());
		
		String e_num = "CLS" + index;
		
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
