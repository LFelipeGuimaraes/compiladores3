/*Bruno Veiga - 743514
Lucas Costa - 743563
Luiz Felipe Guimarães - 743570
Thiago Borges - 613770*/

package AST;

import java.util.*;
import java.io.*;



public class Program{

		//atributos:
		private ArrayList<Function> arrayFunction;

		//construtor:
		public Program(ArrayList<Function> arrayFunction ){
			this.arrayFunction = arrayFunction;
		}

		//genc:
		public void	genC(){


			ParamList p;

			System.out.println("#include<stdio.h>");
			System.out.println("#include<string.h>");
			
			for(Function f : this.arrayFunction){
				if(f.getType() == null)
					System.out.print("void " + f.getId() + "(" );
				else
					System.out.print(f.getType().getCname() + " " + f.getId() + "(" );
				
				
				p = f.getParamList();
				
				if(f.getParamList() != null) {
					int length = p.size();				
					for(int i =0; i <length; i++ ){
	
						if( length != 0){
							
							System.out.print(p.access(i).getType().getCname() + " "+ p.access(i).getId());
	
							if( i != p.size() - 1){
								System.out.print(", ");
							}
						}
					}
				}
				System.out.println(")");
				System.out.println("{");
				f.genC();
				System.out.println("}");
			}
		}



}
