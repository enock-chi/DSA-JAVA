import java.util.*;
import dsa761.TextEditor;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TextEditor<String> editor = new TextEditor<>();
        
        editor.insert("H");
        editor.insert("e");
        editor.insert("l");
        editor.insert("l");
        editor.insert("o");
        editor.insert("!");
        
        editor.print();
        
        editor.remove();
        
        editor.print();
        
        editor.left();
        
        editor.insert(" ");
        editor.insert("t");
        
        editor.print();
	}

}
