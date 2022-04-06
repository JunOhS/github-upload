//2018112524 ���ؿ� 
//��ȯ ȸ�� �˰���

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(new File("C:\\java\\Sample file.txt")); //txt������ ��� ���� ��ü�� �����ϰ� �̸� ��ĳ�ʿ��� �����Ѵ�
			ArrayList<String> list=new ArrayList<String>(); //list��� StringŸ���� ArrayList�� ����. list�� �� ���Ҵ� String���ν� �о�帰 txt������ �� ������ �����Ѵ�. ������ ��� ������ �𸣴� ArrayList�� �����Ͽ���. 
			int count=1; //��ȯ����̱� ������ �ش� ���ʸ� ����ϴ� ����
			
			while(sc.hasNextLine()) { //������ ���� ���� �ִ��� Ȯ���ϰ� ������ ���� �ݺ��Ѵ�
				list.add(sc.nextLine()); //��ĳ���� nextLine �޼ҵ带 �̿��Ͽ� String�� �Է¹޾� �� String�� list�� �߰��Ѵ�
			}
			
			palindrome(list, count); //list�� �ش� ������ ������ ȸ������ �˻��Ͽ� ����� ����Ѵ�.
		}catch(FileNotFoundException e) { //FileNotFoundException ���� ó��
		}
	}
	
	private static void palindrome(ArrayList<String> list, int count) { //���޹��� list�� �ش� ������ ������ ȸ������ �ƴ��� �˻��Ͽ� ����� ����ϴ� �Լ�
			String string1=list.get(0); //list�� ù��° ���Ҹ� string1������ �����Ѵ�
			if(hasSpecialCharacter(string1)==true) { //�ش� ������ Ư�����ڸ� �����ϰ� �ִٸ� 
				string1=string1.substring(0, string1.length()-1); //Ư�����ڸ� �����Ѵ�
			}
			StringBuilder sb=new StringBuilder(string1); //reverse�޼ҵ带 ����ϱ� ���� StringBuilder ��ü�� �����Ѵ�
			String string2=sb.reverse().toString(); //StringBuilder�� reverse().toString()�Լ��� �̿��Ͽ� string1�� �Ųٷ� �迭�Ѱ��� string2������ �����Ѵ�
			if(string1.equals(string2) && string1.length()>1) { //������ ����� �Ųٷ� �迭�� ������ �����ϴٸ� �̴� ������ ȸ���̶�� ���� ���Ѵ�. �ѱ��ڸ� ���� ���ڿ��� ��� ȸ���� �ƴ϶�� �Ǵ��Ѵ�. 
				System.out.println(count+"��° ������ ȸ���Դϴ�."); //�ش� ������ ������ ȸ���̶�� ����Ʈ�Ѵ�. 
			}
			else { //������ ����� �Ųٷ� �迭�� ������ �������� �ʰų� �ѱ��ڸ� ���� �ִٸ� ȸ���� �ƴ϶�� �Ǵ��Ѵ�. 
				System.out.println(count+"��° ������ ȸ���� �ƴմϴ�."); //�ش� ������ ������ ȸ���� �ƴ϶�� ����Ʈ�Ѵ�. 
			}
			
			list.remove(0); //�̹� �Ͽ� ȸ������ �ƴ��� �Ǻ��� ������ �����Ͽ� ���� ������ ù��° ���Ұ� �ǵ��� �Ѵ�
			if(!list.isEmpty()) { //���� ���� list�� ȸ������ �ƴ��� �Ǻ����� ���� ������ �����ִٸ� 
				count++; //���ʸ� 1 ī��Ʈ�ϰ� 
				palindrome(list, count); //��������� list�� �ش� ������ ������ ȸ������ �˻��Ͽ� ����� ����Ѵ� 
			}
	}
	
	private static boolean hasSpecialCharacter(String string) { //���޹��� String�� Ư�����ڸ� �����ϴ��� Ȯ���ϴ� �Լ�
		for(int i=0; i<string.length(); i++) { //���ڿ��� ù��° ���ں��� ������ ���ڱ��� �ݺ��Ѵ�
			if(!Character.isLetterOrDigit(string.charAt(i))) { //���޹��� String�� charAt()�Լ��� �̿��Ͽ� ��� ���ڸ� ���ʴ�� �����Ͽ� ���� ���ڰ� �ƴ� Ư�����ڰ� �����Ѵٸ� 
				return true; //Ư�����ڸ� �����Ѵٰ� true�� �����Ѵ�
			}
		}
		return false; //�ƴ϶�� Ư�����ڸ� �������� �ʴ´ٰ� false�� �����Ѵ�
	}
}
