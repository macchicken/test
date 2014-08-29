package codingbat;

public class Recursion1 {

	private static Recursion1 my;
	
	public static Recursion1 getInstance(){
		if (my==null) {
			return my = new Recursion1();
		}
		return my;
	}

	//88888-->9
	private int count8(int n){
		if (n<=10){return n==8?1:0;}
		int factor=n/10;
		int left=n%10;
		if (left==8){
			if (factor%10==8) {
				return 2+count8(factor);
			}else{
				return 1+count8(factor);
			}
		}
		return count8(factor);
	}
	
	private int factorial(int n) {
		if (n==1){return 1;}  
		return n*factorial(n-1);
	}
	
	private int bunnyEars(int bunnies) {
		  if (bunnies==0){return 0;}
		  return 2+bunnyEars(bunnies-1);
	}
	
	private int fibonacci(int n) {
		  if (n<=1){return n;}
		  return fibonacci(n-2)+fibonacci(n-1);
	}

	private int bunnyEars2(int bunnies) {
		  if (bunnies==0){return 0;}
		  if (bunnies%2!=0){return 2+bunnyEars2(bunnies-1);}
		  return 3+bunnyEars2(bunnies-1);
	}
	
	private int triangle(int rows) {
		  if (rows==0){return 0;}
		  return rows+triangle(rows-1);
	}
	
	private int sumDigits(int n) {
		  if (n==0){return 0;}
		  return n%10+sumDigits(n/10);
	}
	
	private int count7(int n) {
		  if (n<=10){return n==7?1:0;}
		  return count7(n/10)+count7(n%10);
	}
	
	private int powerN(int base, int n) {
		  if (n==1){return base;}
		  return base*powerN(base, n-1);
	}
	
	private int countX(String str) {
		  if (str.length()==0){return 0;}
		  if (str.charAt(0)=='x'){return 1+countX(str.substring(1));}
		  return countX(str.substring(1));
	}

	private int countHi(String str) {
		if (str.length()<2){return 0;}
		String hi=str.substring(0, 2);
		if ("hi".equals(hi)){
			return 1+countHi(str.substring(2));
		}
		return countHi(str.substring(1));
	}
	
	private String changeXY(String str) {
		  if (str.length()==0){return "";}
		  char curr=str.charAt(0);
		  if (curr=='x'){return 'y'+changeXY(str.substring(1));}
		  return curr+changeXY(str.substring(1));
	}
	
	private String changePi(String str) {
		  if (str.length()<2){return str;}
		  String pi=str.substring(0, 2);
		  if ("pi".equals(pi)){
			  return "3.14"+changePi(str.substring(2));
		  }
		  return String.valueOf(str.charAt(0))+changePi(str.substring(1));
	}

	private String noX(String str) {
		  if (str.length()==0){return "";}
		  char curr=str.charAt(0);
		  if (curr!='x'){return curr+noX(str.substring(1));}
		  return noX(str.substring(1));
	}
	
	private boolean array6(int[] nums, int index) {
		  if (index==nums.length){return false;}
		  if (nums[index]==6){return true;}
		  return array6(nums,index+1);
	}

	private int array11(int[] nums, int index) {
		if (index==nums.length){return 0;}
		if (nums[index]==11){return 1+array11(nums, index+1);}
		return array11(nums,index+1);
	}

	private boolean array220(int[] nums, int index) {
		if (nums.length<=1){return false;}
		if (index==nums.length-1){return false;}
		if (nums[index]*10==nums[index+1]){return true;}
		return array220(nums, index+1);
	}

	private String allStar(String str) {
		if (str.length()<=1){return str;}
		return str.charAt(0)+"*"+allStar(str.substring(1));
	}
	
	private String pairStar(String str) {
		if (str.length()<=1){return str;}
		char curr=str.charAt(0);
		char next=str.charAt(1);
		if (curr==next){
			return String.valueOf(curr)+"*"+pairStar(str.substring(1)); 
		}
		return String.valueOf(curr)+pairStar(str.substring(1));
	}

	private String endX(String str) {
		  if (str.length()<=1){return str;}
		  char curr=str.charAt(0);
		  if (curr=='x'){return endX(str.substring(1))+String.valueOf(curr);}
		  return String.valueOf(curr)+endX(str.substring(1));
	}
	
	private int countPairs(String str) {
		  if (str.length()<3){return 0;}
		  if (str.charAt(0)==str.charAt(2)){
			  return 1+countPairs(str.substring(1));
		  }
		  return countPairs(str.substring(1));
	}

	private int countAbc(String str) {
		  if (str.length()<3){return 0;}
		  String newStr=str.substring(0, 3);
		  if ("abc".equals(newStr)||"aba".equals(newStr)){
			  return 1+countAbc(str.substring(1));
		  }
		  return countAbc(str.substring(1));
	}

	private int count11(String str) {
		  if (str.length()<=1){return 0;}
		  if ("11".equals(str.substring(0, 2))){
			  return 1+count11(str.substring(2));
		  }
		  return count11(str.substring(1));
	}
	
	private String stringClean(String str) {
		  if (str.length()<2){return str;}
		  String first=String.valueOf(str.charAt(0));
		  String second=String.valueOf(str.charAt(1));
		  if (first.equals(second)){
			  return stringClean(first+str.substring(2));
		  }
		  return first+stringClean(str.substring(1));
	}

	private int countHi2(String str) {
		int len=str.length();
		if (len<=1){return 0;}
		if (len>=3){
			String newStr=str.substring(0, 3);
			if ('x'==newStr.charAt(0)){
				if ("hi".equals(newStr.substring(1))){
					return countHi2(str.substring(3));
				}else{
					return countHi2(str.substring(1));
				}
			}else{
				if ("hi".equals(newStr.substring(0, 2))){
					return 1+countHi2(str.substring(2));
				}
				return countHi2(str.substring(1));
			}
		}
		if ("hi".equals(str)){return 1;}
		return 0;
	}
	
	// if first char is not ( then removing the char,else see whether the last
	// char is ),if not removing last char till meet the )
	private String parenBit(String str) {
		  if ("".equals(str)){return "";}
		  if ("(".equals(String.valueOf(str.charAt(0)))){
			  int len=str.length();
			  if (")".equals(String.valueOf(str.charAt(len-1)))){
				  return str;
			  }
			  return parenBit(str.substring(0, len-1));
		  }
		  return parenBit(str.substring(1));
	}

	private boolean nestParen(String str){
		if ("".equals(str)){return true;}
		if (str.charAt(0)!='('){return false;}
		if (str.charAt(str.length()-1)==')'){
			return true&&nestParen(str.substring(1,str.length()-1));
		}
		return false;
	}
	
	private int strCount(String str,String sub){
		if (str.length()<sub.length()){return 0;}
		if (sub.equals(str.substring(0, sub.length()))){
			return 1+strCount(str.substring(sub.length()),sub);
		}
		return strCount(str.substring(1), sub);
	}

	private boolean strCopies(String str,String sub,int n){
		if (n==0){return true;}
		if (str.length()<sub.length()){return false;}
		if (sub.equals(str.substring(0, sub.length()))){
			return strCopies(str.substring(1), sub, n-1);
		}
		return strCopies(str.substring(1), sub, n);
	}

	private int strDist(String str,String sub){
		int strLen=str.length();
		int subLen=sub.length();
		if (strLen<subLen){return 0;}
		if (sub.equals(str.substring(0, subLen))){
			if (sub.equals(str.substring(strLen-subLen, strLen))){
				return strLen;
			}
			return strDist(str.substring(0,strLen-1),sub);
		}
		return strDist(str.substring(1), sub);
	}


	//test method
	public void testcount8(){
		System.out.println(1==count8(8));
		System.out.println(2==count8(818));
		System.out.println(4==count8(8818));
		System.out.println(9==count8(88888));
	}
	
	public void testfactorial(){
		System.out.println(1==factorial(1));
		System.out.println(2==factorial(2));
		System.out.println(6==factorial(3));
	}
	
	public void testbunnyEars(){
		System.out.println(0==bunnyEars(0));
		System.out.println(2==bunnyEars(1));
		System.out.println(4==bunnyEars(2));
	}
	
	public void testfibonacci(){
		System.out.println(0==fibonacci(0));
		System.out.println(1==fibonacci(1));
		System.out.println(1==fibonacci(2));
		System.out.println(5==fibonacci(5));
		System.out.println(8==fibonacci(6));
		System.out.println(21==fibonacci(8));
		
	}
	public void testbunnyEars2(){
		System.out.println(0==bunnyEars2(0));
		System.out.println(2==bunnyEars2(1));
		System.out.println(5==bunnyEars2(2));
	}

	public void testtriangle(){
		System.out.println(0==triangle(0));
		System.out.println(1==triangle(1));
		System.out.println(3==triangle(2));
		System.out.println(6==triangle(3));
	}
	
	public void testsumDigits(){
		System.out.println(9==sumDigits(126));
		System.out.println(13==sumDigits(49));
		System.out.println(3==sumDigits(12));
	}
	
	public void testcount7(){
		System.out.println(2==count7(717));
		System.out.println(1==count7(7));
		System.out.println(0==count7(123));
	}
	
	public void testpowerN(){
		System.out.println(3==powerN(3,1));
		System.out.println(9==powerN(3,2));
		System.out.println(27==powerN(3,3));
	}

	public void testcountX(){
		System.out.println(4==countX("xxhixx"));
		System.out.println(3==countX("xhixhix"));
		System.out.println(0==countX("hi"));
	}

	public void testcountHi(){
		System.out.println(1==countHi("xxhixx"));
		System.out.println(2==countHi("xhixhix"));
		System.out.println(2==countHi("xhixhi"));
		System.out.println(1==countHi("hi"));
	}
	
	public void testchangeXY(){
		System.out.println("codey".equals(changeXY("codex")));
		System.out.println("yyhiyy".equals(changeXY("xxhixx")));
		System.out.println("yhiyhiy".equals(changeXY("xhixhix")));
	}

	public void testchangePi(){
		System.out.println("x3.14x".equals(changePi("xpix")));
		System.out.println("3.143.14".equals(changePi("pipi")));
		System.out.println("3.14p".equals(changePi("pip")));
	}

	public void testnoX(){
		System.out.println("ab".equals(noX("xaxb")));
		System.out.println("abc".equals(noX("abc")));
		System.out.println("".equals(noX("xx")));
	}

	public void testarray6(){
		int[] nums={1, 6, 4};
		System.out.println(array6(nums,0));
		int[] nums2={1,4};
		System.out.println(array6(nums2,0));
		int[] nums3={6};
		System.out.println(array6(nums3,0));
	}

	public void testarray11(){
		int[] nums={1, 2, 11};
		System.out.println(array11(nums,0));
		int[] nums2={11, 11};
		System.out.println(array11(nums2,0));
		int[] nums3={1, 2, 3, 4};
		System.out.println(array11(nums3,0));
	}

	public void testarray220(){
		int[] nums={1, 2, 20};
		System.out.println(array220(nums,0));
		int[] nums2={3, 30};
		System.out.println(array220(nums2,0));
		int[] nums3={3};
		System.out.println(array220(nums3,0));
		int[] nums4={2, 19, 4};
		System.out.println(array220(nums4,0));
	}

	public void testallStar(){
		System.out.println(allStar("hello").equals("h*e*l*l*o"));
		System.out.println(allStar("abc").equals("a*b*c"));
		System.out.println(allStar("ab").equals("a*b"));
		System.out.println(allStar("").equals(""));
	}
	
	public void testpairStar(){
		System.out.println(pairStar("hello").equals("hel*lo"));
		System.out.println(pairStar("xxyy").equals("x*xy*y"));
		System.out.println(pairStar("aaaa").equals("a*a*a*a"));
		System.out.println(pairStar("").equals(""));
		System.out.println(pairStar("a").equals("a"));
		System.out.println(pairStar("al").equals("al"));
	}

	public void testendX(){
		System.out.println(endX("xxre").equals("rexx"));
		System.out.println(endX("xxhixx").equals("hixxxx"));
		System.out.println(endX("xhixhix").equals("hihixxx"));
		System.out.println(endX("").equals(""));
	}
	
	public void testcountPairs(){
		System.out.println(countPairs("axa"));
		System.out.println(countPairs("axax"));
		System.out.println(countPairs("axbx"));
	}
	
	public void testcountAbc(){
		System.out.println(1==countAbc("abc"));
		System.out.println(2==countAbc("abcxxabc"));
		System.out.println(2==countAbc("abaxxaba"));
		System.out.println(2==countAbc("ababc"));
	}
	
	public void testcount11(){
		System.out.println(2==count11("11abc11"));
		System.out.println(3==count11("abc11x11x11"));
		System.out.println(1==count11("111"));
	}
	
	public void teststringClean(){
		System.out.println("yza".equals(stringClean("yyzzza")));
		System.out.println("abcd".equals(stringClean("abbbcdd")));
		System.out.println("Helo".equals(stringClean("Hello")));
	}
	
	public void testcountHi2(){
		System.out.println(countHi2("ahixhi"));
		System.out.println(countHi2("ahibhi"));
		System.out.println(countHi2("xhixhi"));
	}

	public void testparenBit(){
		System.out.println(parenBit("xyz(abc)123"));
		System.out.println(parenBit("x(hello)"));
		System.out.println(parenBit("(xy)1"));
	}
	
	public void testnestParen(){
		System.out.println(nestParen("(())"));
		System.out.println(nestParen("((()))"));
		System.out.println(nestParen("(((x))"));
	}

	public void teststrCount(){
		System.out.println(2==strCount("catcowcat", "cat"));
		System.out.println(1==strCount("catcowcat", "cow"));
		System.out.println(0==strCount("catcowcat", "dog"));
	}

	public void teststrCopies(){
		System.out.println(strCopies("catcowcat", "cat", 2));
		System.out.println(strCopies("catcowcat", "cow", 2));
		System.out.println(strCopies("catcowcat", "cow", 1));
	}

	public void teststrDist(){
		System.out.println(strDist("catcowcat", "cat"));
		System.out.println(strDist("catcowcat", "cow"));
		System.out.println(strDist("cccatcowcatxx", "cat"));
	}

}