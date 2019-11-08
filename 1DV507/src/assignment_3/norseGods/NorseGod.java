package assignment_3.norseGods;


public class NorseGod extends GodsGUI implements GodsInterface {
	/* **************************** */
	public String name;
	public String race;
	public String desc;
	/* **************************** */
	
	@Override
	public void NorseGod() {
		NorseGod(NAMES.LOKI, 		RACES.GIANT, DESCRIPTIONS.LOKI_DESC);
		NorseGod(NAMES.THOR, 		RACES.AESIR, DESCRIPTIONS.THOR_DESC);
		NorseGod(NAMES.ODIN, 		RACES.AESIR, DESCRIPTIONS.ODIN_DESC);
		NorseGod(NAMES.BALDR, 		RACES.AESIR, DESCRIPTIONS.BALDR_DESC);
		NorseGod(NAMES.FREYR, 		RACES.VANIR, DESCRIPTIONS.FREYR_DESC);
		NorseGod(NAMES.FREYJA, 		RACES.VANIR, DESCRIPTIONS.FREYJA_DESC);
		NorseGod(NAMES.HEIMDALLR, 	RACES.AESIR, DESCRIPTIONS.HEIMDALLR_DESC);
		NorseGod(NAMES.BRAGI, 		RACES.AESIR, DESCRIPTIONS.BRAGI_DESC);
		NorseGod(NAMES.TYR, 		RACES.AESIR, DESCRIPTIONS.TYR_DESC);
	}

	@Override
	public void NorseGod(String name, String race, String desc) {
		NAME.add(name);
		RACE.add(race);
		DESCRIPTION.add(desc);
	}
	
	/* **************************** */
	/* 		GETTERS AND SETTERS		*/
	/* **************************** */
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getRace() {
		return race;
	}

	@Override
	public void setRace(String race) {
		this.race = race;
	}

	@Override
	public String getDesc() {
		return desc;
	}

	@Override
	public void setDesc(String desc) {
		this.desc = desc;
	}
}