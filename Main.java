package coldrock.survive.core;

import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

public class Main {
	public static ConsoleSystemInterface console = null;
	private static int x = 1;
	private static int y = 1;
	private static boolean doorcheck = false;
	public static void main(String[] args) {
		
		try {
            console = new WSwingConsoleInterface("Ascii Fight", false);
        } catch (ExceptionInInitializerError eiie) {
            System.out.println("Fatal Error Initializing Swing Console Box");
            eiie.printStackTrace();
            System.exit(-1);
        }
		console.cls();
		console.print(10, 10, "|", console.YELLOW);
		
		while(true){
			console.print(x, y, "@",console.WHITE);
			console.refresh();
			doorcheck(10 , 10);
			controls();
			
			
		}
		
		
		
	}
	private static void doorcheck(int xd , int yd) {
		if(x == xd && y == yd){
			doorcheck = true;
		}
		if(doorcheck == true){
			if(xd - 1 == x && yd == y){
				doorcheck = false;
				console.print(xd, yd, "\\", console.BLUE);
			}
			if(xd + 1 == x && yd == y){
				doorcheck = false;
				console.print(xd, yd, "\\", console.BLUE);
			}
			if(yd - 1 == y && xd == x){
				doorcheck = false;
				console.print(xd, yd, "\\", console.BLUE);
			}
			if(yd + 1 == y && xd == x){
				doorcheck = false;
				console.print(xd, yd, "\\", console.BLUE);
			}
		}
		
	}
	public static void printmsg(String msg){
		System.out.println(msg);
	}
	private static void controls(){
		CharKey dir = console.inkey();
		if(dir.code == CharKey.w&& (y-1 >= 0)){
			if(console.peekColor(x, y - 1) != console.BROWN){
				if( console.peekColor( x , y - 1) != console.YELLOW){
				console.print(x, y ," ");
				y--;
				}
			}
		}
		if(dir.code == CharKey.s && (y+1 < 25)){
			if(console.peekColor(x, y + 1) != console.BROWN){
				if(console.peekColor( x , y + 1) != console.YELLOW){
				console.print(x, y ," ");
				y++;
				}
				
			}
		}
		if(dir.code == CharKey.a && (x-1 >= 0)){
			if(console.peekColor(x - 1, y) != console.BROWN){
				if(console.peekColor( x - 1 , y) != console.YELLOW){
				console.print(x, y ," ");
				x--;
				}
		}
		}
		if(dir.code == CharKey.d && (x+1 < 80)){
			if(console.peekColor(x + 1, y) != console.BROWN){
				if(console.peekColor( x + 1 , y) != console.YELLOW){
				console.print(x, y ," ");
				x++;
				}
		}
		}
		if(dir.code == CharKey.f){
			System.out.println("x: "+ x + " y: " + y);
		}
		if(dir.code == CharKey.r){
			if(console.peekColor(x - 1, y) == console.YELLOW){
				console.print(x - 1, y, "\\" ,console.BLUE);
				
			}else
			if(console.peekColor(x - 1, y) == console.BLUE){
				console.print(x - 1, y, "|" , console.YELLOW);
				
			}
			if(console.peekColor(x + 1, y) == console.YELLOW){
				console.print(x + 1, y, "\\" ,console.BLUE);
				
			}else
			if(console.peekColor(x + 1, y) == console.BLUE){
				console.print(x + 1, y, "|" , console.YELLOW);
				
			}
			if(console.peekColor(x, y + 1) == console.YELLOW){
				console.print(x, y + 1, "\\" ,console.BLUE);
				
			}else
			if(console.peekColor(x, y + 1) == console.BLUE){
				console.print(x, y + 1, "|" , console.YELLOW);
				
			}
			if(console.peekColor(x , y - 1) == console.YELLOW){
				console.print(x, y - 1, "\\" ,console.BLUE);
				
			}else
			if(console.peekColor(x, y - 1) == console.BLUE){
				console.print(x, y - 1, "|" , console.YELLOW);
				
			}
		}
		
	}
}
