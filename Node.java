
public class Node {


int frequency; 
int leftnode;
int rightnode; 
int leftleaf;
int rightleaf;



public Node(int f){

	
	frequency =f;
	leftnode  = -1;
    rightnode = -1;
    leftleaf  = -1;
    rightleaf = -1; 
   
}





public int getleftnode(){

	return leftnode;
	
}


public int getrightnode(){

	return rightnode;
	
}



public int getleftleaf(){

	return leftnode;
	
}


public int getrightleaf(){

	return leftnode;
	
}

public int getFrequency(){

	return frequency;
	
}


public void setFrequency( int x){

	frequency = x;
	
}




public void setleftnode(int x){

	leftnode = x;
	
}


public void setrightnode(int x){

	 rightnode = x;
	
}



public void setleftleaf(int x){

	 leftleaf = x;
	
}


public void setrightleaf(int x){

	rightleaf = x;
	
}



}