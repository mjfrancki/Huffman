import java.util.Comparator;

public class Symbol implements Comparable<Symbol>{

char value;
int frequency ; 
String codeword ;

public Symbol(char v, int f){

	value = v;
	frequency =f;
	codeword = "";

}


public char getValue(){

	return value;
	
}

public int getFrequency(){

	return frequency;
	
}

public String getCodeword(){

	return codeword;
	
}

public void updateCodeword(String bit){

	codeword = bit + codeword;
	
}



public void print(){

	System.out.println(value +"  "+  frequency +"  "+ codeword);
	
}

@Override
 public int compareTo(Symbol s){
   
if ( (this.frequency - s.frequency) != 0 ){
    return this.frequency - s.frequency;
  
   }

   else
   	return this.value - s.value;

}


}