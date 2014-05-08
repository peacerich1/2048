package com.t_nett.t2048;

public class Hoved{
	int str = 4;
	
	Knapp[][] knapper = new Knapp[str][str];
	int poeng;
	
	Hoved(){
		for(int n = 0; n < str; n++){
			for(int m = 0; m < str; m++){
				knapper[n][m] = new Knapp();
			}
		}
		
		for(int n = 0; n < 2; n++){
			random();
		}
		
	}
	
	
	void random(){
		int randomTall;
		int randomN = (int)(Math.random()*str);
		int randomM = (int)(Math.random()*str);
		int a = 0;
		System.out.println("ok");
		if (knapper[0][0].verdi == 0||knapper[0][1].verdi == 0||knapper[0][2].verdi == 0||knapper[0][3].verdi == 0||knapper[1][0].verdi == 0||knapper[1][1].verdi == 0||knapper[1][2].verdi == 0||knapper[1][3].verdi == 0||knapper[2][0].verdi == 0||knapper[2][1].verdi == 0||knapper[2][2].verdi == 0||knapper[2][3].verdi == 0||knapper[3][0].verdi == 0||knapper[3][1].verdi == 0||knapper[3][2].verdi == 0||knapper[3][3].verdi == 0){
			while (a < 1) {
				randomTall = ((int)(Math.random()*8));
				if (knapper[randomN][randomM].verdi != 0){
					randomN = (int)(Math.random()*str);
					randomM = (int)(Math.random()*str);
				}
				else{
					a = 2;
					if (randomTall == 1){
						knapper[randomN][randomM].verdi = 4;
					}
					else {
						knapper[randomN][randomM].verdi = 2;
					}
				}
			}
		}
	}
	
	void hoyre(){
		int max = str-1;
		boolean endret = false;
		//dobbel løkke for gjennomgang av alt
		for(int n = 0; n < str; n++){
			for(int m = str-2; m >= 0; m--){
				//Sjekker om den er tom
				if(knapper[n][m].verdi != 0){
					//hvis det er noe der gå tilbake og legg fra deg den
					for(int l = m+1; l < max+1; l++){
						//adder hvis de er like
						if(knapper[n][l].verdi != 0){
							if(knapper[n][l].verdi == knapper[n][m].verdi){
								knapper[n][l].verdi *= 2;
								knapper[n][m].verdi = 0;
								max = l;
								endret = true;
							}else{//Hvis ikke legg ved siden av
								if(knapper[n][l-1] != knapper[n][m]){
									knapper[n][l-1].verdi = knapper[n][m].verdi;
									knapper[n][m].verdi = 0;
									max = l-1;
									endret = true;
								}else{
									endret = true;
								}
							}
							break;
						}
					}
					if(endret == false){
						knapper[n][max].verdi = knapper[n][m].verdi;
						knapper[n][m].verdi = 0;
					}
					endret = false;
				}
				max = str-1;
			}
		}
	}
	void venstre(){
		int max = 0;
		boolean endret = false;
		//dobbel løkke for gjennomgang av alt
		for(int n = 0; n < str; n++){
			for(int m = 1; m < str; m++){
				//Sjekker om den er tom
				if(knapper[n][m].verdi != 0){
					//hvis det er noe der gå tilbake og legg fra deg den
					for(int l = m-1; l > max -1; l--){
						//adder hvis de er like
						if(knapper[n][l].verdi != 0){
							if(knapper[n][l].verdi == knapper[n][m].verdi){
								knapper[n][l].verdi *= 2;
								knapper[n][m].verdi = 0;
								max = l;
								endret = true;
							}else{//Hvis ikke legg ved siden av
								if(knapper[n][l+1] != knapper[n][m]){
									knapper[n][l+1].verdi = knapper[n][m].verdi;
									knapper[n][m].verdi = 0;
									max = l+1;
									endret = true;
								}else{
									endret = true;
								}
							}
							break;
						}
					}
					if(endret == false){
						knapper[n][max].verdi = knapper[n][m].verdi;
						knapper[n][m].verdi = 0;
					}
					endret = false;
				}
				max = 0;
			}
		}
	}
	void ned(){
		int max = str-1;
		boolean endret = false;
		//dobbel løkke for gjennomgang av alt
		for(int m = 0; m < str; m++){
			for(int n = str-2; n >= 0; n--){
				//Sjekker om den er tom
				if(knapper[n][m].verdi != 0){
					//hvis det er noe der gå tilbake og legg fra deg den
					for(int l = n+1; l < max+1; l++){
						//adder hvis de er like
						if(knapper[l][m].verdi != 0){
							if(knapper[l][m].verdi == knapper[n][m].verdi){
								knapper[l][m].verdi *= 2;
								knapper[n][m].verdi = 0;
								max = l;
								endret = true;
							}else{//Hvis ikke legg ved siden av
								if(knapper[l-1][m] != knapper[n][m]){
									knapper[l-1][m].verdi = knapper[n][m].verdi;
									knapper[n][m].verdi = 0;
									max = l-1;
									endret = true;
								}else{
									endret = true;
								}
							}
							break;
						}
					}
					if(endret == false){
						knapper[max][m].verdi = knapper[n][m].verdi;
						knapper[n][m].verdi = 0;
					}
					endret = false;
				}
				max = str-1;
			}
		}
	}
	void opp(){
		int max = 0;
		boolean endret = false;
		//dobbel løkke for gjennomgang av alt
		for(int m = 0; m < str; m++){
			for(int n = 1; n < str; n++){
				//Sjekker om den er tom
				if(knapper[n][m].verdi != 0){
					//hvis det er noe der gå tilbake og legg fra deg den
					for(int l = n-1; l > max -1; l--){
						//adder hvis de er like
						if(knapper[l][m].verdi != 0){
							if(knapper[l][m].verdi == knapper[n][m].verdi){
								knapper[l][m].verdi *= 2;
								knapper[n][m].verdi = 0;
								max = l;
								endret = true;
							}else{//Hvis ikke legg ved siden av
								if(knapper[l+1][m] != knapper[n][m]){
									knapper[l+1][m].verdi = knapper[n][m].verdi;
									knapper[n][m].verdi = 0;
									max = l+1;
									endret = true;
								}else{
									endret = true;
								}
							}
							break;
						}
					}
					if(endret == false){
						knapper[max][m].verdi = knapper[n][m].verdi;
						knapper[n][m].verdi = 0;
					}
					endret = false;
				}
				max = 0;
			}
		}
	}
}
