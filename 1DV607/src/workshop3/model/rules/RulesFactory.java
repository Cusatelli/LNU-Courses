package workshop3.model.rules;

public class RulesFactory {

	public IHitStrategy GetHitRule() {
		return new BasicHitStrategy();
	}

	public INewGameStrategy GetNewGameRule() {
		return new AmericanNewGameStrategy();
	}

	public IWinStrategy GetWinnerRule() {
		return new DealerWinStrategy();
	}
}