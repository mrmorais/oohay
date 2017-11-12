package br.ufrn.imd.calculaarvore;

public class Node 
{	
	protected Node[] next;
	protected Palavra key;	
	
	public Node() 
	{
		next = new Node[26];
		key = null;
	}
}
