package PRPPG;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Sistema {
    
    public static void main(String[] args) {
    	try {
			int cod;
			char tipo;
			String line;
			float impacto;
			boolean coord;
			String[] infoDocentes;
			String[] infoVeiculos;
			Calendar dateN = Calendar.getInstance();
			Calendar dateI = Calendar.getInstance();
			SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");
			
			// LEITURA DE DOCENTES
			List<Docente> docentes = new ArrayList<Docente>();
			BufferedReader bufferD = new BufferedReader(new InputStreamReader(new  FileInputStream(args[0]), args[1]));
			line = bufferD.readLine();	// Ignora a primeira linha de leitura
			while(line != null) {
				line = bufferD.readLine();
				infoDocentes = line.split(";");
				cod = Integer.parseInt(infoDocentes[0]);
				dateN.setTime(dma.parse(infoDocentes[2]));
				dateI.setTime(dma.parse(infoDocentes[3]));
				if(infoDocentes.length == 5) {coord = true;}
				else {coord = false;}
				Docente doc = new Docente(cod, infoDocentes[1], coord, dateN, dateI);
				docentes.add(doc);
			}
			bufferD.close();
			
			// LEITURA DE VEICULOS
			List<Veiculo> veiculos = new ArrayList<Veiculo>();
			BufferedReader bufferV = new BufferedReader(new InputStreamReader(new  FileInputStream(args[0]), args[1]));
			line = bufferV.readLine();	// Ignora a primeira linha de leitura
			while(line != null) {
				line = bufferV.readLine();
				infoVeiculos = line.split(";");
				tipo = infoVeiculos[2].charAt(0);
				impacto = Float.parseFloat(infoVeiculos[3]);
				Veiculo veic = new Veiculo(tipo, infoVeiculos[1], infoVeiculos[0], infoVeiculos[4], impacto);
				veiculos.add(veic);
			}
			bufferV.close();
    	} catch (IOException e) {
			System.err.printf("Erro na abertura do Arquivo %s.\n", e.getMessage());
		}
		catch (ParseException e) {
			System.err.printf("Erro para converter a Data.\n");
		}
    	
    	
    }
}