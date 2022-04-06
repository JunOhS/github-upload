//2018112524 신준오 
//순환 회문 알고리즘

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(new File("C:\\java\\Sample file.txt")); //txt파일이 담긴 파일 객체를 생성하고 이를 스캐너에게 전달한다
			ArrayList<String> list=new ArrayList<String>(); //list라는 String타입의 ArrayList를 생성. list의 각 원소는 String으로써 읽어드린 txt파일의 각 문장을 저장한다. 문장이 몇개가 들어올지 모르니 ArrayList로 선언하였다. 
			int count=1; //순환방식이기 때문에 해당 차례를 기록하는 변수
			
			while(sc.hasNextLine()) { //다음에 읽을 값이 있는지 확인하고 없을때 까지 반복한다
				list.add(sc.nextLine()); //스캐너의 nextLine 메소드를 이용하여 String을 입력받아 각 String을 list에 추가한다
			}
			
			palindrome(list, count); //list의 해당 차례의 문장이 회문인지 검사하여 결과를 출력한다.
		}catch(FileNotFoundException e) { //FileNotFoundException 예외 처리
		}
	}
	
	private static void palindrome(ArrayList<String> list, int count) { //전달받은 list의 해당 차례의 문장이 회문인지 아닌지 검사하여 결과를 출력하는 함수
			String string1=list.get(0); //list의 첫번째 원소를 string1변수에 저장한다
			if(hasSpecialCharacter(string1)==true) { //해당 문장이 특수문자를 포함하고 있다면 
				string1=string1.substring(0, string1.length()-1); //특수문자를 제거한다
			}
			StringBuilder sb=new StringBuilder(string1); //reverse메소드를 사용하기 위해 StringBuilder 객체를 선언한다
			String string2=sb.reverse().toString(); //StringBuilder의 reverse().toString()함수를 이용하여 string1을 거꾸로 배열한것을 string2변수에 저장한다
			if(string1.equals(string2) && string1.length()>1) { //원래의 문장과 거꾸로 배열한 문장이 동일하다면 이는 문장이 회문이라는 것을 뜻한다. 한글자만 적힌 문자열의 경우 회문이 아니라고 판단한다. 
				System.out.println(count+"번째 문장은 회문입니다."); //해당 차례의 문장이 회문이라고 프린트한다. 
			}
			else { //원래의 문장과 거꾸로 배열한 문장이 동일하지 않거나 한글자만 적혀 있다면 회문이 아니라고 판단한다. 
				System.out.println(count+"번째 문장은 회문이 아닙니다."); //해당 차례의 문장이 회문이 아니라고 프린트한다. 
			}
			
			list.remove(0); //이번 턴에 회문인지 아닌지 판별한 문장은 삭제하여 다음 문장이 첫번째 원소가 되도록 한다
			if(!list.isEmpty()) { //만약 아직 list에 회문인지 아닌지 판별되지 않은 문장이 남아있다면 
				count++; //차례를 1 카운트하고 
				palindrome(list, count); //재귀적으로 list의 해당 차례의 문장이 회문인지 검사하여 결과를 출력한다 
			}
	}
	
	private static boolean hasSpecialCharacter(String string) { //전달받은 String이 특수문자를 포함하는지 확인하는 함수
		for(int i=0; i<string.length(); i++) { //문자열의 첫번째 문자부터 마지막 문자까지 반복한다
			if(!Character.isLetterOrDigit(string.charAt(i))) { //전달받은 String을 charAt()함수를 이용하여 모든 문자를 차례대로 검토하여 만약 문자가 아닌 특수문자가 존재한다면 
				return true; //특수문자를 포함한다고 true를 리턴한다
			}
		}
		return false; //아니라면 특수문자를 포함하지 않는다고 false를 리턴한다
	}
}
