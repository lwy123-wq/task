package task;

public class Task1 {
 int[] str=new int[32];

 public int[] isZero(int target){
  int len=Integer.toBinaryString(target).length();
  int j=0;
  for(int i=0;i<len;i++){
   if((target >> i & 1) == 1){
    str[j]=i;
    j++;
   }
  }
  return str;
 }
 public String test(){
  short cc=5;
  short dd=3;
  int ee;
  ee=cc;
  ee<<=16;
  ee|=dd;
  String s1=String.valueOf(ee);
  System.out.println(ee);
  char a1='5';
  char a2='a';
  char a3='d';
  char a4='e';
  int num;
  num=a1;
  num<<=8;
  num|=a2;
  num<<=8;
  num|=a3;
  num<<=8;
  num|=a4;
  String s2=String.valueOf(num);
  System.out.println(num);
  int b1=a3;
  String s3=String.valueOf(a2);
  String s4=String.valueOf(b1);
  System.out.println(b1);
  return s1+s2+s3+s4;

 }
 public static void main(String[] args) {
  int aa=7;
  int bb=aa<<1;
  System.out.println(bb);
  Task1 task1=new Task1();
  int[] num=task1.isZero(2);
  /*for(int num1:num){
   System.out.println(num1);
  }*/

 }
}
