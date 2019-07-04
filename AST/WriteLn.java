/*Bruno Veiga - 743514
Lucas Costa - 743563
Luiz Felipe Guimarães - 743570
Thiago Borges - 613770*/

package AST;

public class WriteLn extends Statement {

    private Expr e;
    public WriteLn(Expr e){
      this.e = e;
    }

    public void genC(){
    	if(this.e.getType().getTypeName() != "String") {
    		System.out.print("printf(\"%d\\n\", ");
    		this.e.genC();
    		System.out.println(");");
    	}
    	else{
        		System.out.print("puts(");
        		this.e.genC();
        		System.out.println(");");
    	}
    }
}
