class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
    int x = a.length()-1,y=b.length()-1;
        int carry = 0;

    while(x>=0 || y>=0){
          if(x>=0){
          	if(a.charAt(x) == '1')
          		carry++;
          	x--;
          } 

          if(y>=0){
          	if(b.charAt(y)=='1')
          		carry++;
          	y--;
          }

          if(carry==3){
          	builder.append('1');
carry =1;
          }
          else if(carry==2){
          	builder.append('0');
          	carry=1;
          }else{
          	builder.append(carry==1 ? '1':'0');
          	carry =0;
          	
          }

    }

    if(carry==1)
    	builder.append('1');


	return builder.reverse().toString();
    }
}