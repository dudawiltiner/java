package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private List<Long> idTimes = new ArrayList<>(); // List é a interface e o Array é a implementação
	private List<String> nameTimes = new ArrayList<>(); // List é a interface e o Array é a implementação
	private List<Long> idJogadores = new ArrayList<>(); // List é a interface e o Array é a implementação
	private List<String> nameJogadores = new ArrayList<>(); // List é a interface e o Array é a implementação
	private List<Long> timeJogadores = new ArrayList<>(); // List é a interface e o Array é a implementação
	private List<Integer> habiJogadores = new ArrayList<>(); // List é a interface e o Array é a implementação
	private List<LocalDate> dateJogadores = new ArrayList<>(); // List é a interface e o Array é a implementação
	private List<BigDecimal> salaJogadores = new ArrayList<>(); // List é a interface e o Array é a implementação
	private List<Long> idCapitaes= new ArrayList<>(); // List é a interface e o Array é a implementação


//	public static void main (String[] args){
//		LocalDate current= LocalDate.now();//gets current LocalDateTime
//		DesafioMeuTimeApplication gerenciarTimes = new DesafioMeuTimeApplication();
//		System.out.println(gerenciarTimes.idTimes);
//		//gerenciarTimes.buscarTopJogadores(12);
//		gerenciarTimes.incluirTime(3L,"Eduarda", current, "azul", "vermelho");
//		gerenciarTimes.incluirTime(5L,"Eduarda", current, "azul", "vermelho");
//		gerenciarTimes.incluirTime(6L,"Eduarda", current, "azul", "vermelho");
//
//		try {
//			gerenciarTimes.incluirTime(3L,"Eduarda", current, "azul", "vermelho");
//		} catch (IdentificadorUtilizadoException e){
//			System.out.println(e);
//		}
//		System.out.println(gerenciarTimes.buscarTimes());
//		System.out.println("Concluido");
//	}

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) throws IdentificadorUtilizadoException {

		try {
			buscarNomeTime(id);
			IdentificadorUtilizadoException error = new IdentificadorUtilizadoException();
			throw error;
		}catch (TimeNaoEncontradoException e) {
			idTimes.add(id);
			nameTimes.add(nome);
		}

	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {

		try {
			buscarNomeTime(idTime);
			try {
				buscarNomeJogador(id);
				IdentificadorUtilizadoException error = new IdentificadorUtilizadoException();
				throw error;
			} catch (JogadorNaoEncontradoException e) {
				idJogadores.add(id);
				nameJogadores.add(nome);
				timeJogadores.add(idTime);
				habiJogadores.add(nivelHabilidade);
				salaJogadores.add(salario);
				dateJogadores.add(dataNascimento);
			}
		}catch (TimeNaoEncontradoException e) {
			TimeNaoEncontradoException error = new TimeNaoEncontradoException();
			throw error;
		}
	}

	public void definirCapitao(Long idJogador) {
		try {
			buscarNomeJogador(idJogador);
			idCapitaes.add(idJogador);
		}catch (JogadorNaoEncontradoException e) {
			JogadorNaoEncontradoException error = new JogadorNaoEncontradoException();
			throw error;
		}
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		TimeNaoEncontradoException error = new TimeNaoEncontradoException();
		CapitaoNaoInformadoException err = new CapitaoNaoInformadoException();

		if(idTimes.contains(idTime)){
			for (int i = 0; i < timeJogadores.size(); i++) {
				if(timeJogadores.get(i).equals(idTime)){
					if(idCapitaes.contains(idJogadores.get(i))){
						return idJogadores.get(i);
					}
				}
			}

			throw err;
		} else {
			throw error;
		}





	}

	public String buscarNomeJogador(Long idJogador) {
		JogadorNaoEncontradoException error = new JogadorNaoEncontradoException();

		if(idJogadores.size() == 0){
			throw error;
		}

		for (Long id: idJogadores) {
			if(id.equals(idJogador)){
				int value = idJogadores.indexOf(id);
				return nameJogadores.get(value);
			}
		}

		throw error;
	}

	public String buscarNomeTime(Long idTime) throws TimeNaoEncontradoException{
		TimeNaoEncontradoException error = new TimeNaoEncontradoException();

		if(idTimes.size() == 0){
			throw error;
		}

		for (Long id: idTimes) {
			if(id.equals(idTime)){
				int value = idTimes.indexOf(id);
				return nameTimes.get(value);
			}
		}

		throw error;
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		List<Long> jogadores = new ArrayList<>();

		try {
			buscarNomeTime(idTime);

			for (int i = 0; i < timeJogadores.size(); i++) {
				if(timeJogadores.get(i).equals(idTime)){
					Long jog = idJogadores.get(i);
					jogadores.add(jog);
				}
			}

			List<Long> newJogadores = jogadores.stream().sorted().collect(Collectors.toList());
			return newJogadores;
		}catch (TimeNaoEncontradoException e) {
			TimeNaoEncontradoException error = new TimeNaoEncontradoException();
			throw error;
		}

	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		List<Integer> newHabili = habiJogadores.stream().sorted().collect(Collectors.toList());
		List<Long> jogadores = new ArrayList<>();

		try {
			buscarNomeTime(idTime);
			for (int i = 0; i < newHabili.size(); i++) {
				int local = newHabili.size() - 1;
				if(newHabili.get(i).equals(newHabili.get(local))){
					Long timeId = timeJogadores.get(i);
					if(timeId != null && timeId.equals(idTime)){
						jogadores.add(idJogadores.get(i));
					}
				}
			}

			if(jogadores.size() > 0) {
				List<Long> whoTheBest = jogadores.stream().sorted().collect(Collectors.toList());
				return whoTheBest.get(0);
			}

			return jogadores.get(0);
		}catch (TimeNaoEncontradoException e) {
			TimeNaoEncontradoException error = new TimeNaoEncontradoException();
			throw error;
		}

	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		List<LocalDate> newDates = dateJogadores.stream().sorted().collect(Collectors.toList());
		List<Long> jogadores = new ArrayList<>();
		try {
			buscarNomeTime(idTime);
			for (int i = 0; i < newDates.size(); i++) {
				int local = 0;
				if(newDates.get(i).equals(newDates.get(local))){
					Long timeId = timeJogadores.get(i);
					if(timeId != null && timeId.equals(idTime)){
						jogadores.add(idJogadores.get(i));
					}
				}
			}

			if(jogadores.size() > 0) {
				List<Long> whoTheOldest = jogadores.stream().sorted().collect(Collectors.toList());
				return whoTheOldest.get(0);
			}

			return jogadores.get(0);
		}catch (TimeNaoEncontradoException e) {
			TimeNaoEncontradoException error = new TimeNaoEncontradoException();
			throw error;
		}
	}

	public List<Long> buscarTimes() {
		if(idTimes.size() == 0){
			return idTimes;
		}

		List<Long> newIdTimes = idTimes.stream().sorted().collect(Collectors.toList());
		return newIdTimes;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		List<BigDecimal> newSala = salaJogadores.stream().sorted().collect(Collectors.toList());
		List<Long> jogadores = new ArrayList<>();

		try {
			buscarNomeTime(idTime);
			for (BigDecimal sala: newSala) {
				int local = newSala.size() - 1;
				if(sala.equals(newSala.get(local))){
					int value = newSala.indexOf(sala);
					Long timeId = timeJogadores.get(value);
					if(timeId != null && timeId.equals(idTime)){
						jogadores.add(idJogadores.get(value));
					}
				}
			}

			if(jogadores.size() > 0) {
				List<Long> whoTheBest = jogadores.stream().sorted().collect(Collectors.toList());
				return whoTheBest.get(0);
			}

			return jogadores.get(0);
		}catch (TimeNaoEncontradoException e) {
			TimeNaoEncontradoException error = new TimeNaoEncontradoException();
			throw error;
		}
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {

		try {
			buscarNomeJogador(idJogador);
			int value = idJogadores.indexOf(idJogador);
			return salaJogadores.get(value);
		} catch (JogadorNaoEncontradoException e) {
			JogadorNaoEncontradoException error = new JogadorNaoEncontradoException();
			throw error;
		}

	}

	public List<Long> buscarTopJogadores(Integer top) {
		if(idJogadores.size() == 0){
			return  idJogadores;
		}

		List<Long> jogadores = new ArrayList<>();
		List<Integer> lista = habiJogadores.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		List<Integer> newHabili = lista.stream().limit(top).collect(Collectors.toList());

		for (int i = 0; i < habiJogadores.size(); i++) {
			if(newHabili.contains(habiJogadores.get(i))){
				jogadores.add(idJogadores.get(i));
			}
		}

		List<Long> newJog =  jogadores.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		List<Long> newJogadores = newJog.stream().limit(top).collect(Collectors.toList());

		return newJogadores;

	}

}
