package com.gaurav;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumericalSystem {
	static String ones[]=new String[]{
	        "","one ","two ","three ","four ","five ","six ","seven ","eight ","nine "
};
static String twos[]=new String[]{
        "ten ","eleven ","twelve ","thirteen ","fourteen ","fifteen ","sixteen ","seventeen ","eighteen ","nineteen "
};
static String tens[]=new String[]{
        "","","twenty ","thirty ","forty ","fifty ","sixty ","seventy ","eighty ","ninety "
};
static String hundreds[]=new String[]{
    "","one hundred ","two hundred ","three hundred ","four hundred ","five hundred ","six hundred ","seven hundred ","eight hundred ","nine hundred "
};
public static String IndianTwos(long n,String s){
            String r="";
            if(n>19){
                r=r+tens[(int)n/10]+ones[(int)n%10];
            }
            else if(n>9){
                r=r+twos[(int)n%10];
            }
            else{
                r=r+ones[(int)n%10];
            }
            if(n!=0){
                r=r+s;
            }
            return r;
}
public static String IndianNumericalSystem(long N){
	    String result="";
        result=result+IndianTwos(N/10000000,"crore ");
        result=result+IndianTwos((N/100000)%100,"lakh ");
        result=result+IndianTwos((N/1000)%100,"thousand ");
        result=result+IndianTwos((N/100)%10,"hundred ");
        if(N>100 && N%100>0){
            result=result+"and ";
        }
        result=result+IndianTwos(N%100,"");
        return result;
}
public static String InternationalThrees(long n,String s){
            String r="";
            if(n>99 && n%100>19){
                r=r+hundreds[(int)n/100]+tens[(int)(n%100)/10]+ones[(int)n%10];
            }
            else if(n>99 && n%100>9){
                r=r+hundreds[(int)n/100]+twos[(int)n%10];
            }
            else if(n>99){
                r=r+hundreds[(int)n/100]+ones[(int)n%10];
            }
            else if(n>19){
                r=r+tens[(int)n/10]+ones[(int)n%10];
            }
            else if(n>9){
                r=r+twos[(int)n%10];
            }
            else{
                r=r+ones[(int)n%10];
            }
            if(n!=0){
                r=r+s;
            }
            return r;
}
public static String InternationalNumericalSystem(long N){
	    String result="";
        result=result+InternationalThrees(N/1000000000,"billion ");
        result=result+InternationalThrees((N/1000000)%1000,"million ");
        result=result+InternationalThrees((N/1000)%1000,"thousand ");
        result=result+InternationalThrees(N%1000,"");
        return result;
}
	
	@PostMapping("getValue")
	public Number getValue(@RequestBody Number obj) {
		try {
			long N=Long.parseLong(obj.getNo());
			if(obj.getType().equals("Indian") && N>0) {
				String result=IndianNumericalSystem(N);
				obj.setNo(result);
				return obj;
			}
			else if(obj.getType().equals("International") && N>0){
				String result=InternationalNumericalSystem(N);
				obj.setNo(result);
				return obj;
			}
			else if(N==0) {
				obj.setNo("zero");
				return obj;
			}
			obj.setNo("wrong input");
			return obj;
		}
		catch(Exception e) {
			obj.setNo("wrong input");
			return obj;
		}
	}
}
