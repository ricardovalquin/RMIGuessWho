//public void iniciar sesion();// almacenarlos en una lista
//public void	cerrar sesión
//public String ver conectados();
//public boolean retar(retador, contrincante)// true o false para ver si se puede retar o no 
//public int responderReto(contrincante, respuesta) // devuelve un numero puede ser la partida
//public String verpersonaje(int partida, string nombre)
//public boolean preguntar característica(int partida, String nombre,  característica)//nombre del que pregunta
//public boolean preguntar personaje (int partida,String nombre, nombre)
//public string verTurno(int partida);

//hacer que el descarte sea por el jugador


public class Partida{

	String jugador1 = null;
	String jugador2 = null;

	String personaje1 = null;
	String personaje2 = null;

	String tuno; //cambia entre los nombres de los jugadores
	String estado; // iniciada o terminada

	//GETTERS AND SETTERS

	public Partida(String jugador1, String jugador2){// cuando generan partida no está en curso, apenas lo están retando
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		personaje1 = "";
		personaje2 = "";
		turno = jugador1;
		estado = "reto";// cuando se acepte se pone activa, cuando se rechaza simplemente se borra, cuando se termina estado terminado

	}


}



//////////////////////////////// implementacipon en el servidor

ArrayList<partida> Partidas;  // instanciar en el constructor Partidas = new ArrayList();
// responder reto recorro partidas si estoy como jugador 2 y si me encuentro 


public boolean Retar(String nombre, String rival){// verificar que ambos jugadores no se encuenten en reto
//se tiene que buscar ambos jugadores y ver si están en línea antes de hacer comparaciones
	boolean respuesta = false;
	boolean encontro = false;
	for (int i=0; i< partidas.size() ; i++) {
		if (Partidas.get(i).getEstado().equals("activa")) {//yo estoy libre y solo puedo retar en esaas
			if (Partidas.get(i).getJugador1().equals(rival) || Partidas.get(i).getJugador2().equals(rival)) {
				encontro = true;
				break;				
			}			
		}else{
			
				if ((Partidas.get(i).getJugador1().equals(rival) && 
					Partidas.get(i).getJugador2().equals(rival)) || 
					(Partidas.get(i).getJugador1().equals(rival) && 
					Partidas.get(i).getJugador2().equals(rival))) {
				encontro = true;
				break;				
			}
			
		}
	}
	if (!encontro) {
		Partidas.add(new Partida(nombre, rival));//reto creado
		respuesta = true;	
	}	

	return respuesta;
}

//////////////////////////////////////////en la implementacipon en el server
						objeto implementacipon
	System.out.println(chat.Retar("Johan", "Yamile"));
	System.out.println(chat.Retar("Yamile", "Johan" ));


	///////////////////////////////////////

	//id de partida -1 parano				jugador1
public int responderReto(String retado, String retador, String respuesta){
	int numPartida; 	
		if (respuesta.equals("Acepto")) {
			for (int i=0; i<partidas.size() ;i++ ) {// se  buscan a los jugadores y devuelve num de partida
				// poner rechazado, no borrar
				//mirar las que esten en estado reto
				// comparar retador, retado
			}
		}else{
			numPartida = -1;
		}
		return numPartida;
}

public verRetos// que salga en la ventana quien me reta y al clickearlo un joption pane para aceptar o rechazar.
				// el que hizo el reto tiene que enterarse