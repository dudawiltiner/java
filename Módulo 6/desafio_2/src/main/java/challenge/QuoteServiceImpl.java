package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		List<Quote> listQuote = this.repository.findAll();
		Random random = new Random();
		int number = random.nextInt((listQuote.size() - 1));
		return listQuote.get(number);
	}
	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> listQuote = this.repository.findByActor(actor);
		Random random = new Random();
		int number = random.nextInt((listQuote.size() - 1));
		return listQuote.get(number);
	}

}
