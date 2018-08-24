package Server;



public class Server_Brain {
	
	public Server_Brain() {

	}
	

	public String processQuestion(String question) {
		
		String answer="";
		
		String[] line = question.split(" ");
		
		if (line.length==2) {
			
			answer=Integer.toString(calTwo(line[0],Integer.parseInt(line[1])));
			
		} else if (line.length==3) {
			
			answer=Integer.toString(calThree(Integer.parseInt(line[0]),line[1],Integer.parseInt(line[2])));
		}
		else 
			answer= "Invalid question";
		return answer;
	}
	
	
	private int calTwo(String func, int num ) {
		 int result=0;
	     switch (func) {
	         case "square":
	        	 result = num * num ;
	             break;
	         case "cube":
	        	 result = num * num * num ;
	             break;
	         case "factor":
	        	 result = calFactor(num);
	        	 break;
	         default:
	             throw new IllegalArgumentException("Invalid function: " + func);
	     }
	     return result;

	}
	
	private int calFactor(int m) { 
		int r =m;
	    for(int y=m-1; y >0 ; y--) {
	        r = r * y;
	        }
	    return r;
	}
	private int calThree(int num1, String func, int num2) {
		int result =0;
		switch (func) {
        case "plus":
       	 result = num1 + num2 ;
            break;
        case "minus":
       	 result = num1 - num2;
       	 break;
        case "multiply":
          	 result = num1 * num2;
          	 break;
        case "divide":
          	 result = num1/num2;
          	 break;
        default:
            throw new IllegalArgumentException("Invalid function: " + func);
    }
		return result;

	}
	

}
