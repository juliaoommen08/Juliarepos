import java.util.Scanner;
class crcsum
{
public static void main(String args[])
{
 Scanner sc=new Scanner(System.in);

/*To enter the dataword*/
 System.out.print("Enter the number of data bits : ");
 int db = sc.nextInt();
 System.out.print("Enter the data bits : ");
 String data = sc.next();
 String code = data;
 System.out.println();
 
/*To enter the generator word*/
 System.out.print("Enter the number of generator bits : ");
 int gen = sc.nextInt();
 System.out.print("Enter the generator bits : ");
 String generator = sc.next();
 System.out.println();

/*To append n (generator-1) zeros to dataword*/
 while(code.length() < (db + gen - 1))
 code = code + "0";
 System.out.println("The Appended data word is : " + code);
 System.out.println();

/*To print the n bit remainder obtained after binary division*/
 String Remainder=div(code,generator);
 System.out.println("The remainder after division of appended dataword by generator bits is : " + Remainder);
 System.out.println();
/*To append the dataword with the remainder and print the codeword*/
 code = data + Remainder;
 System.out.println("Transmitted Code word is: " + code);
 System.out.println();

/*To enter the code received at the receiver side*/
 System.out.println("At Receiver side,");
 System.out.println();
 System.out.print("Enter the code word : ");
 String rec = sc.next();
 System.out.println();
 String rec_rem = div(rec,generator);
 System.out.println("The remainder after dividing received codeword by generator bits is : " + rec_rem);
 System.out.println();

/*To check if the received string has error*/
 if(Integer.parseInt(rec_rem) == 0)
 System.out.println("As remainder is zero, received code word has no errors.");
 else
 System.out.println("As remainder is non zero, the received code word has errors.");
}

/*To divide the string by generator using binary division*/
static String div(String num1,String num2)
{
 int pointer = num2.length();
 String result = num1.substring(0, pointer);
 String remainder = "";
 for(int i = 0; i < num2.length(); i++)
 {
 if(result.charAt(i) == num2.charAt(i))
 remainder += "0";
 else
 remainder += "1";
 }
 while(pointer < num1.length())
{
 if(remainder.charAt(0) == '0')
 {
 remainder = remainder.substring(1, remainder.length());
 remainder = remainder + String.valueOf(num1.charAt(pointer));
 pointer++;
 }
 result = remainder;
 remainder = "";
 if(result.charAt(0)=='0')
 {
 for(int i = 0; i < num2.length(); i++)
 {
 if(result.charAt(i) =='1')
 remainder += "1";
 else
 remainder += "0";
 }
 }
 else
 {
 for (int i = 0; i < num2.length(); i++) {
 if (result.charAt(i) == num2.charAt(i)) {
 remainder += "0";
 }
 else {
 remainder += "1";
 }
 }
 }
 }
 return remainder.substring(1,remainder.length());
}
}