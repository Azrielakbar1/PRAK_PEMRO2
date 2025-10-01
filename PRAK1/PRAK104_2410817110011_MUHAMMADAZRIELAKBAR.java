package PRAK1;
import java.util.Scanner;

public class PRAK104_2410817110011_MUHAMMADAZRIELAKBAR {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Tangan Abu : ");
		String tanganAbu = scan.nextLine().replace(" "," ");
		
		System.out.print("Tangan Bagas : ");
		String tanganBagas = scan.nextLine().replace(" ", " ");
		
		int skorAbu = 0;
		int skorBagas = 0;
		
		for(int i = 0; i < 3; i++) {
			char abu = tanganAbu.charAt(i);
			char bagas = tanganBagas.charAt(i);
		
		if (abu == bagas) {
			continue;
		}else if ((abu == 'B' && bagas == 'G') || 
				(abu == 'G' && bagas == 'K') || 
				(abu == 'K' && bagas == 'B')) {
			skorAbu++;
		}else {
			skorBagas++;
		}
		
		}
		System.out.println("Pemenang : ");
		if(skorAbu > skorBagas) {
				System.out.println("Abu");
			}else if (skorBagas > skorAbu){
				System.out.println("Bagas");
			}else {
				System.out.println("Seri");
			}
			scan.close();
	}
		
	
}
	


