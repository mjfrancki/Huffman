import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.*;


public class HuffmanTree {

	 public static void main(String[] args) throws IOException {

	 		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	 		String text = sc.readLine();

      int n = text.length() ;
       
       ArrayList<Symbol> list = new ArrayList<Symbol>();

	 			//System.out.println(text);

	 			//mapPrint (charCount(text)) ;

       list = mapToArray( charCount(text) );

    Collections.sort(list);

    // for(Symbol s : list){
    //  s.print();
     //}	 

   

   treeGenerator(list) ;


	 }




private static Map<Character, Integer> charCount(String s) {

HashMap<Character,Integer> map = new HashMap<Character,Integer>();

for(int i = 0; i < s.length(); i++){
   char c = s.charAt(i);
   Integer val = map.get(new Character(c));
   if(val != null){
     map.put(c, new Integer(val + 1));
   }else{
     map.put(c,1);
   }
}

return map;

}


private static void mapPrint(Map<Character, Integer> map) {

	for(char key : map.keySet())
    {
    	 System.out.println(key + " : " +map.get(key));
    }

}


private static ArrayList<Symbol> mapToArray(Map<Character, Integer> map) {

 ArrayList<Symbol> list = new ArrayList<Symbol>();
	
	for(char key : map.keySet())
    {
    Symbol sym = new Symbol(key , map.get(key))	;
    list.add(sym);
    	
    }

return list;

}

private static void treeGenerator(ArrayList<Symbol> symbols) {

int leafpt = 2;
int nodept = 0;

int leftf=0;
int rightf=0;
//ArrayList<Node> Tree = new ArrayList<Node>();
  int n = symbols.size();
//System.out.println(n);
  Node[] tree = new Node[n];


for(int i = 0 ; i < n ;i++)
    tree[i] = new Node(-1);



tree[0].setleftleaf(0);
tree[0].setrightleaf(1);
tree[0].setFrequency( symbols.get(0).getFrequency() + symbols.get(1).getFrequency()  );

//symbols.get(0).updateCodeword("0");
//symbols.get(1).updateCodeword("1");

for(int i = 1;i<n-1;i++){

//set Left sub


//System.out.println(leafpt);
//System.out.println(nodept);
  
if(leafpt < n){
  if( symbols.get(leafpt).getFrequency() < tree[nodept].getFrequency() ) {

      tree[i].setleftleaf(leafpt);
      leftf = symbols.get(leafpt).getFrequency();
      leafpt++;
   }
 
   else{
       tree[i].setleftnode(nodept);
       leftf = tree[nodept].getFrequency();
       nodept++;
   }

   
//set Right sub
//System.out.println(leafpt);
//System.out.println(nodept);
  
   if( symbols.get(leafpt).getFrequency() < tree[nodept].getFrequency()  ) {

      tree[i].setrightleaf(leafpt);
      rightf = symbols.get(leafpt).getFrequency();
      leafpt++;
   }
   else{
       tree[i].setrightnode(nodept);
       rightf = tree[nodept].getFrequency();
       nodept++;
   }

}

else{

       tree[i].setleftnode(nodept);
       leftf = tree[nodept].getFrequency();
       nodept++;

       tree[i].setrightnode(nodept);
       rightf = tree[nodept].getFrequency();
       nodept++;
  

}

   //tree[i].setrightleaf(1);
   tree[i].setFrequency(  leftf  + rightf );

//System.out.println("N"+i +"  "+ tree[i].getFrequency() ); 

//tree[i].setleftleaf(0);
//tree[i].setrightleaf(1);
//tree[i].setfrequency( symbols.get(0) + symbols.get(0)  );

}


for(int i =0 ; i<n ;i++){
  System.out.print("L"+i+" ");
  symbols.get(i).print();

}
int leafcount = 0;
for(int i =0 ; i<n-1 ;i++){
  System.out.print("N"+i +"  "+ tree[i].getFrequency()+ " " );

 if(tree[i].getleftnode() != -1)
    System.out.print("N" +  tree[i].getleftnode()+" " );
  else{
    System.out.print("L" +  leafcount + " ");
    leafcount++;
  }


  if(tree[i].getrightnode() != -1)
    System.out.print("N" +  tree[i].getrightnode()+" " );
  else{
    System.out.print("L" +  leafcount +" ");
    leafcount++;
  }

  System.out.println("");
}

}



//private static int smallestfreq( Node[] tree){
//int smallest
//int index

//}




}



