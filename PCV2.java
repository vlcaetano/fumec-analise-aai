
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PCV2 {

	public static void main(String[] args) {
		final long tempoInicial = System.currentTimeMillis();
		
		//Declaração da matriz com a distância das cidades
		
//		int distanciaCidades[][] = {{0,8,12,18,3,13,16,1,5,6,8,11,4,5,6,17,11,2,18,6},
//									{8,0,15,19,14,19,17,16,1,6,11,15,2,12,2,11,5,10,19,14},
//									{12,15,0,3,14,10,3,14,15,10,15,12,8,13,11,8,11,18,1,19},
//									{18,19,3,0,7,8,19,2,3,9,6,18,3,6,6,2,18,7,2,16},
//									{3,14,14,7,0,6,12,10,9,8,5,9,19,6,7,16,11,3,19,11},
//									{13,19,10,8,6,0,1,16,14,10,4,7,6,14,2,9,15,4,13,1},
//									{16,17,3,19,12,1,0,9,17,8,3,14,13,11,3,7,8,2,8,19},
//									{1,16,14,2,10,16,9,0,8,1,5,7,8,11,15,10,13,14,18,4},
//									{5,1,15,3,9,14,17,8,0,15,1,17,15,13,18,5,13,12,16,1},
//									{6,6,10,9,8,10,8,1,15,0,15,7,15,12,9,8,4,11,12,6},
//									{8,11,15,6,5,4,3,5,1,15,0,6,6,1,13,9,9,5,9,1},
//									{11,15,12,18,9,7,14,7,17,7,6,0,2,15,13,10,15,18,12,3},
//									{4,2,8,3,19,6,13,8,15,15,6,2,0,11,3,2,12,9,9,18},
//									{5,12,13,6,6,14,11,11,13,12,1,15,11,0,5,9,7,6,9,10},
//									{6,2,11,6,7,2,3,15,18,9,13,13,3,5,0,18,11,11,15,9},
//									{17,11,8,2,16,9,7,10,5,8,9,10,2,9,18,0,8,13,4,8},
//									{11,5,11,18,11,15,8,13,13,4,9,15,12,7,11,8,0,18,7,18},
//									{2,10,18,7,3,4,2,14,12,11,5,18,9,6,11,13,18,0,9,13},
//									{18,19,1,2,19,13,8,18,16,12,9,12,9,9,15,4,7,9,0,13},
//									{6,14,19,16,11,1,19,4,1,6,1,3,18,10,9,8,18,13,13,0}};
		
		int distanciaCidades[][] = {{0,4,11,12,7,4,18,3,6,7,12,14,18,12,6,2,6,18,3,3},
									{4,0,7,11,3,5,17,8,9,8,7,11,11,5,18,8,19,16,11,16},
									{11,7,0,1,10,10,9,4,19,7,1,18,4,12,10,5,2,6,10,15},
									{12,11,1,0,8,13,8,5,2,15,13,19,7,18,14,15,6,4,11,3},
									{7,3,10,8,0,4,1,5,6,17,5,15,6,2,5,13,17,6,16,12},
									{4,5,10,13,4,0,7,15,17,3,4,12,2,14,9,8,3,17,13,15},
									{18,17,9,8,1,7,0,3,11,15,5,8,2,9,17,1,17,12,15,1},
									{3,8,4,5,5,15,3,0,3,18,16,16,11,4,12,5,4,13,1,17},
									{6,9,19,2,6,17,11,3,0,15,8,17,11,16,11,10,3,12,12,19},
									{7,8,7,15,17,3,15,18,15,0,19,16,1,15,7,11,5,1,12,5},
									{12,7,1,13,5,4,5,16,8,19,0,16,19,13,14,3,1,4,10,4},
									{14,11,18,19,15,12,8,16,17,16,16,0,9,12,11,1,9,7,4,1},
									{18,11,4,7,6,2,2,11,11,1,19,9,0,17,13,9,10,3,12,19},
									{12,5,12,18,2,14,9,4,16,15,13,12,17,0,15,6,7,6,19,13},
									{6,18,10,14,5,9,17,12,11,7,14,11,13,15,0,7,8,6,8,11},
									{2,8,5,15,13,8,1,5,10,11,3,1,9,6,7,0,1,16,6,16},
									{6,19,2,6,17,3,17,4,3,5,1,9,10,7,8,1,0,2,18,18},
									{18,16,6,4,6,17,12,13,12,1,4,7,3,6,6,16,2,0,4,8},
									{3,11,10,11,16,13,15,1,12,12,10,4,12,19,8,6,18,4,0,15},
									{3,16,15,3,12,15,1,17,19,5,4,1,19,13,11,16,18,8,15,0}};
		
		final int numeroDeCidades = distanciaCidades.length;
		
		//Declaração da lista de cidades visitadas, inicializando apenas com a cidade inicial
		List<Integer> cidadesJaVisitadas = new ArrayList<>();
		cidadesJaVisitadas.add(0);
		
		//Declaração da lista de cidades não visitadas, com as cidades restantes
		List<Integer> cidadesNaoVisitadas = IntStream.rangeClosed(1, numeroDeCidades-1)
			    .boxed().collect(Collectors.toList());
		
		List<Integer> listaCaminho = new ArrayList<Integer>();
		//adicionando na primeira e na última posição da lista a cidade inicial
		listaCaminho.add(0, 0);
		listaCaminho.add(1, 0);
		
		//enquanto todas as cidades não forem visitadas
		while(!cidadesNaoVisitadas.isEmpty()) {
			int menorDistancia = Integer.MAX_VALUE;
			
			//encontrar as rotas que possuem a menor distância possível
			List<Integer[]> listaRotasMenorDistancia = new ArrayList<>();
			for (int atual : cidadesJaVisitadas) {
				
				for (int destino : cidadesNaoVisitadas) {
					
					if (atual != destino && distanciaCidades[atual][destino] <= menorDistancia) {
						
						if (distanciaCidades[atual][destino] == menorDistancia) {
							Integer cidadesAtualEDestino[] = {atual,destino};
							listaRotasMenorDistancia.add(cidadesAtualEDestino);
						} else {
							menorDistancia = distanciaCidades[atual][destino];
							listaRotasMenorDistancia.clear();
							Integer cidadesAtualEDestino[] = {atual,destino};
							listaRotasMenorDistancia.add(cidadesAtualEDestino);
						}
					}
				}
			}
			
			int cidadeDestinoMenorDist = 0;
			int menorDistanciaTotal = Integer.MAX_VALUE;
			
			List<Integer> listaMenorCaminho = new ArrayList<>();
			
			//Para todas as rotas ligando duas cidades descobertas anteriormente, testar qual a melhor
			for (Integer[] cidades : listaRotasMenorDistancia) {
				int cidadeAtual = cidades[0];
				int cidadeDestino = cidades[1];
				
				//Caso a cidade de partida seja a cidade inicial
				if (cidadeAtual == 0) {
					int adicionarInicio=0;
					int adicionarFinal=0;
					
					//testar se é melhor adicionar a direita da primeira cidade ou a esquerda da última cidade
					listaCaminho.add(1, cidadeDestino);
					adicionarInicio = calcularDistancia(listaCaminho.stream().mapToInt(Integer::intValue).toArray(), distanciaCidades);
					listaCaminho.remove(Integer.valueOf(cidadeDestino));
					
					listaCaminho.add(listaCaminho.size()-1, cidadeDestino);
					adicionarFinal = calcularDistancia(listaCaminho.stream().mapToInt(Integer::intValue).toArray(), distanciaCidades);
					
					if (adicionarInicio < adicionarFinal) {
						listaCaminho.remove(Integer.valueOf(cidadeDestino));
						listaCaminho.add(1, cidadeDestino);
					}
					
				} else {
					int adicionarEsquerda=0;
					int adicionarDireita=0;
					
					//testar se é melhor adicionar a esquerda ou a direita da cidade
					listaCaminho.add(listaCaminho.indexOf(cidadeAtual), cidadeDestino);
					adicionarEsquerda = calcularDistancia(listaCaminho.stream().mapToInt(Integer::intValue).toArray(), distanciaCidades);
					listaCaminho.remove(Integer.valueOf(cidadeDestino));
					
					listaCaminho.add(listaCaminho.indexOf(cidadeAtual)+1, cidadeDestino);
					adicionarDireita = calcularDistancia(listaCaminho.stream().mapToInt(Integer::intValue).toArray(), distanciaCidades);
					
					if (adicionarEsquerda < adicionarDireita) {
						listaCaminho.remove(Integer.valueOf(cidadeDestino));
						listaCaminho.add(listaCaminho.indexOf(cidadeAtual), cidadeDestino);
					}
				}
				
				//Testar o tamanho da rota encontrada e guardá-la caso seja menor que a menor rota até então
				int distanciaCalculada = calcularDistancia(listaCaminho.stream().mapToInt(Integer::intValue).toArray(), distanciaCidades);
				if (distanciaCalculada < menorDistanciaTotal) {
					menorDistanciaTotal = distanciaCalculada;
					cidadeDestinoMenorDist = cidadeDestino;
					
					listaMenorCaminho = listaCaminho.stream().collect(Collectors.toList());
				}
				
				listaCaminho.remove(Integer.valueOf(cidadeDestino));
			}
			
			//adicionar a cidade destino na lista de cidades visitadas e a remover da lista de não visitadas
			cidadesJaVisitadas.add(cidadeDestinoMenorDist);
			cidadesNaoVisitadas.remove(Integer.valueOf(cidadeDestinoMenorDist));
			
			//salvar a rota com o menor caminho
			listaCaminho = listaMenorCaminho.stream().collect(Collectors.toList());
			
			//imprimir o passo a passo da rota, mostrando a cada cidade adicionada
//			System.out.println(listaCaminho + " Cidade adicionada: " + cidadeDestinoMenorDist);
		}
		
		System.out.println("Rota: " + listaCaminho);
		System.out.println("Distância: " + calcularDistancia(listaCaminho.stream().mapToInt(Integer::intValue).toArray(), distanciaCidades));
		
		//cálculo do tempo de execução do código
		final long tempoFinal = System.currentTimeMillis();
		System.out.println("Tempo de execução: "+(tempoFinal - tempoInicial) / (double)1000 +" segundos.");
	}
	
	public static int calcularDistancia(int[] caminho, int[][] distanciaCidades) {
		int distancia = 0;
		for (int i = 0; i < caminho.length-1; i++) {
			distancia += distanciaCidades[caminho[i]][caminho[i+1]];
		}
		return distancia;
	}
}
